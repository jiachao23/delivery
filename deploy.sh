#!/bin/bash
# tag::code[]
# 定义颜色

BLUE_COLOR="\033[36m"
RED_COLOR="\033[31m"
GREEN_COLOR="\033[32m"
VIOLET_COLOR="\033[35m"
YELLOW_COLOR="\033[33m"
RES="\033[0m"

# 软件下载目录
BASE_DIR=/opt/software
INSTALL_DIR=/usr/local

usage() {
	echo -e "${BLUE_COLOR}docker 方式安装，请执行 ./deploy.sh start${RES}"
	exit 1
}


port(){
	#nginx
	firewall-cmd --add-port=80/tcp --permanent
	firewall-cmd --add-port=443/tcp --permanent
	#mysql
	firewall-cmd --add-port=3306/tcp --permanent
	
	#redis
	firewall-cmd --add-port=6379/tcp --permanent

	service firewalld restart
	firewall-cmd --list-ports
}

download(){
	wget -N $BASH_CONFIG/deploy/$1
}


echo -e "${VIOLET_COLOR}########################################################################${RES}"
echo -e "${VIOLET_COLOR}#                           Deploy Script                              #${RES}"
echo -e "${VIOLET_COLOR}########################################################################${RES}"

cd ~

# 安装依赖
echo -e "${RED_COLOR}>>>>>>>>>>>>>>>>>>>>>>>> Start Install Dependency <<<<<<<<<<<<<<<<<<<<<<${RES}"

if  [ -x "$(command -v expect)" ];then
    echo -e "${YELLOW_COLOR}>>>>>>>>>>>>>>>>>>>>> expect      already install! <<<<<<<<<<<<<<<<<<<<<${RES}"
else
    echo -e "${YELLOW_COLOR}>>>>>>>>>>>>>> expect is not install,start install expect! <<<<<<<<<<<<<${RES}"
    #安装expect
    yum install -y expect
fi

if [ -x "$(command -v wget)" ];then
    echo -e "${YELLOW_COLOR}>>>>>>>>>>>>>>>>>>>>> wget        already install! <<<<<<<<<<<<<<<<<<<<<${RES}"
else
    echo -e "${YELLOW_COLOR}>>>>>>>>>>>>>> wget is not install,start install expect!       <<<<<<<<<<<${RES}"
    #安装wget
    yum install -y wget 
fi

if [ -x "$(command -v unzip)" ];then
    echo -e "${YELLOW_COLOR}>>>>>>>>>>>>>>>>>>>>> unzip        already install! <<<<<<<<<<<<<<<<<<<<<${RES}"
else
    echo -e "${YELLOW_COLOR}>>>>>>>>>>>>>> unzip is not install,start install unzip!       <<<<<<<<<<<${RES}"
    #安装wget
    yum install -y unzip
fi

echo -e "${RED_COLOR}>>>>>>>>>>>>>>>>>>>>>>>> End Install Dependency <<<<<<<<<<<<<<<<<<<<<<<<${RES}"


jdk(){
	if [ -x "$(command -v java)" ];then
		echo "====================== JDK 已存在,JAVA_HOME='$JAVA_HOME' ======================"
	else
		echo "====================== 开始安装 JDK ======================"
		wget -N https://software.jcohy.com//jdk/11/OpenJDK11U-jdk_x64_linux_hotspot_11.0.11_9.tar.gz -P $BASE_DIR
		tar -zxvf $BASE_DIR/OpenJDK11U-jdk_x64_linux_hotspot_11.0.11_9.tar.gz -C ${INSTALL_DIR}
		cat >> /etc/profile << EOF
export JAVA_HOME=${INSTALL_DIR}/jdk-11.0.11+9
export PATH=\$PATH:\$JAVA_HOME/bin
EOF
		echo "====================== JDK 已安装完成，JAVA_HOME='$JAVA_HOME' ======================"
	fi
}

mysql(){

	echo -e "${YELLOW_COLOR}>>>>>>>>>>>>>>>>>>>>> 加载 sql.sh! <<<<<<<<<<<<<<<<<<<<<<<${RES}"
	test ! -e "./sql.sh" && wget -N https://software.jcohy.com/bash/deploy/sql.sh && chmod +x sql.sh
	test ! -x "./sql.sh" && chmod +x sql.sh
	echo -e "${YELLOW_COLOR}>>>>>>>>>>>>>>>>>>>>> 加载 sql.sh 成功! <<<<<<<<<<<<<<<<<<<<<<<${RES}"

	if [ -x "$(command -v mysql)" ];then
		echo "====================== mysql 已存在======================"
	else
		echo "======================安装 mysql ======================"
		wget -N https://software.jcohy.com/mysql/8/mysql-8.0.19-1.el7.x86_64.rpm-bundle.tar -P $BASE_DIR
		cd $BASE_DIR
		tar -xvf $BASE_DIR/mysql-8.0.19-1.el7.x86_64.rpm-bundle.tar
		echo "---------->>删除依赖"
		rpm -qa|grep mariadb-libs | xargs rpm -e  --nodeps
		#安装必要依赖
		echo "---------->>安装依赖项"
		yum install -y libaio net-tools perl numactl
		echo "---------->>安装Mysql"
		rpm -ivh mysql-community-common-8.0.19-1.el7.x86_64.rpm
		rpm -ivh mysql-community-libs-8.0.19-1.el7.x86_64.rpm
		rpm -ivh mysql-community-client-8.0.19-1.el7.x86_64.rpm
		rpm -ivh mysql-community-server-8.0.19-1.el7.x86_64.rpm
		echo '---------->>启动Mysql'
		systemctl enable mysqld
		systemctl start mysqld

		# grep 'temporary password' /var/log/mysqld.log | sed -r 's/.*localhost: (.*)/\1/g'
		cd ~
		password=`grep 'temporary password' /var/log/mysqld.log|tail -n 1| awk '{print $NF}'`
		echo "---------->>mysql 默认密码: "$password
		expect <<EOF
      spawn mysql -u root -p
      expect {
          "Enter password: " {send "$password\r";exp_continue;}
      }
      expect "mysql> " {send "ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'Jcohy@1203';\r"}
      expect "mysql> " {send "set global validate_password.policy=0;\r"}
      expect "mysql> " {send "flush privileges;\r"}
      expect "mysql> " {send "CREATE USER 'root'@'%' IDENTIFIED WITH mysql_native_password BY 'jcohy1203';\r"}
      expect "mysql> " {send "ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'jcohy1203';\r"}
      expect "mysql> " {send "flush privileges;\r"}
      expect "mysql> " {send "CREATE DATABASE delivery;\r"}
      expect "mysql> " {send "use mysql\r"}
      expect "mysql> " {send "select host,user,plugin  from mysql.user;\r"}
      expect "mysql> " {send "exit;\r"}
EOF

		#echo "====================== 开启端口访问======================"
		#firewall-cmd --permanent --zone=public --add-port=3306/tcp
		#firewall-cmd --permanent --zone=public --add-port=3306/udp
		#firewall-cmd --reload
		#firewall-cmd --list-ports
		echo "====================== mysql 安装完成 Mysql密码为 jcohy1203 ======================"
	fi
}

deploy() {
  wget -N https://codeload.github.com/jiachao23/delivery/tar.gz/refs/tags/V1.0.2
  tar -zxvf V1.0.2
  cd delivery-1.0.2 && chmod +x gradlew && ./gradlew clean build
  cd /root/delivery-1.0.2/delivery-admin/build/libs
  java -jar delivery-admin-1.0.2.jar
}

#根据输入参数，选择执行对应方法，不输入则执行使用说明
case "$1" in
"start")
	jdk
	mysql
	port
	deploy
;;
"port")
	port
;;
*)
	usage
;;
esac
# end::code[]
