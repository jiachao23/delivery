-- ----------------------------
-- 初始化-部门表数据
-- ----------------------------
insert into sys_dept values(100,  0,   '0',      'delivery',        '27000000',     0, 'admin', '15888888888', 'admin@qq.com', '0', '0', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00');


-- ----------------------------
-- 初始化-用户信息表数据
-- ----------------------------
insert into sys_user values(1,  100, 'admin', '管理员', '00', 'admin@163.com', '15888888888', '1', '', '29c67a30398638269fe600f73a054934', '111111', '0', '0', '127.0.0.1', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '管理员');

-- ----------------------------
-- 初始化-角色信息表数据
-- ----------------------------
insert into sys_role values('1', '超级管理员', 'admin',  1, 1, '0', '0', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '超级管理员');


-- ----------------------------
-- 初始化-菜单信息表数据
-- ----------------------------
-- 一级菜单
insert into sys_menu values('1', '系统管理', '0', '1', '#', '', 'M', '0', '', 'fa fa-gear',          'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '系统管理目录');
insert into sys_menu values('2', '系统监控', '0', '2', '#', '', 'M', '0', '', 'fa fa-video-camera',  'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '系统监控目录');
insert into sys_menu values('3', '系统工具', '0', '3', '#', '', 'M', '0', '', 'fa fa-bars',    'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '系统工具目录');
-- 二级菜单
insert into sys_menu values('100',  '用户管理', '1', '1', '/system/user',          '', 'C', '0', 'system:user:view',         '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '用户管理菜单');
insert into sys_menu values('101',  '角色管理', '1', '2', '/system/role',          '', 'C', '0', 'system:role:view',         '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '角色管理菜单');
insert into sys_menu values('102',  '菜单管理', '1', '3', '/system/menu',          '', 'C', '0', 'system:menu:view',         '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '菜单管理菜单');
insert into sys_menu values('103',  '部门管理', '1', '4', '/system/dept',          '', 'C', '0', 'system:dept:view',         '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '部门管理菜单');
-- insert into sys_menu values('104',  '岗位管理', '1', '5', '/system/post',          '', 'C', '0', 'system:post:view',         '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '岗位管理菜单');
insert into sys_menu values('105',  '字典管理', '1', '6', '/system/dict',          '', 'C', '0', 'system:dict:view',         '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '字典管理菜单');
insert into sys_menu values('106',  '参数设置', '1', '7', '/system/config',        '', 'C', '0', 'system:config:view',       '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '参数设置菜单');
insert into sys_menu values('107',  '通知公告', '1', '8', '/system/notice',        '', 'C', '0', 'system:notice:view',       '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '通知公告菜单');
insert into sys_menu values('108',  '日志管理', '1', '9', '#',                     '', 'M', '0', '',                         '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '日志管理菜单');
insert into sys_menu values('109',  '在线用户', '2', '1', '/monitor/online',       '', 'C', '0', 'monitor:online:view',      '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '在线用户菜单');
insert into sys_menu values('110',  '数据监控', '2', '3', '/monitor/data',         '', 'C', '0', 'monitor:data:view',        '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '数据监控菜单');
insert into sys_menu values('111',  '服务监控', '2', '3', '/monitor/server',       '', 'C', '0', 'monitor:server:view',      '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '服务监控菜单');
insert into sys_menu values('112',  '系统接口', '3', '3', '/tool/swagger',         '', 'C', '0', 'tool:swagger:view',        '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '系统接口菜单');
-- 三级菜单
insert into sys_menu values('500',  '操作日志', '108', '1', '/monitor/operlog',    '', 'C', '0', 'monitor:operlog:view',     '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '操作日志菜单');
insert into sys_menu values('501',  '登录日志', '108', '2', '/monitor/logininfor', '', 'C', '0', 'monitor:logininfor:view',  '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '登录日志菜单');
-- 用户管理按钮
insert into sys_menu values('1000', '用户查询', '100', '1',  '#', '',  'F', '0', 'system:user:list',        '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
insert into sys_menu values('1001', '用户新增', '100', '2',  '#', '',  'F', '0', 'system:user:add',         '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
insert into sys_menu values('1002', '用户修改', '100', '3',  '#', '',  'F', '0', 'system:user:edit',        '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
insert into sys_menu values('1003', '用户删除', '100', '4',  '#', '',  'F', '0', 'system:user:remove',      '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
insert into sys_menu values('1004', '用户导出', '100', '5',  '#', '',  'F', '0', 'system:user:export',      '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
insert into sys_menu values('1005', '用户导入', '100', '6',  '#', '',  'F', '0', 'system:user:import',      '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
insert into sys_menu values('1006', '重置密码', '100', '7',  '#', '',  'F', '0', 'system:user:resetPwd',    '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
-- 角色管理按钮
insert into sys_menu values('1007', '角色查询', '101', '1',  '#', '',  'F', '0', 'system:role:list',        '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
insert into sys_menu values('1008', '角色新增', '101', '2',  '#', '',  'F', '0', 'system:role:add',         '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
insert into sys_menu values('1009', '角色修改', '101', '3',  '#', '',  'F', '0', 'system:role:edit',        '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
insert into sys_menu values('1010', '角色删除', '101', '4',  '#', '',  'F', '0', 'system:role:remove',      '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
insert into sys_menu values('1011', '角色导出', '101', '5',  '#', '',  'F', '0', 'system:role:export',      '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
-- 菜单管理按钮
insert into sys_menu values('1012', '菜单查询', '102', '1',  '#', '',  'F', '0', 'system:menu:list',        '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
insert into sys_menu values('1013', '菜单新增', '102', '2',  '#', '',  'F', '0', 'system:menu:add',         '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
insert into sys_menu values('1014', '菜单修改', '102', '3',  '#', '',  'F', '0', 'system:menu:edit',        '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
insert into sys_menu values('1015', '菜单删除', '102', '4',  '#', '',  'F', '0', 'system:menu:remove',      '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
-- 部门管理按钮
insert into sys_menu values('1016', '部门查询', '103', '1',  '#', '',  'F', '0', 'system:dept:list',        '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
insert into sys_menu values('1017', '部门新增', '103', '2',  '#', '',  'F', '0', 'system:dept:add',         '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
insert into sys_menu values('1018', '部门修改', '103', '3',  '#', '',  'F', '0', 'system:dept:edit',        '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
insert into sys_menu values('1019', '部门删除', '103', '4',  '#', '',  'F', '0', 'system:dept:remove',      '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
-- -- 岗位管理按钮
-- insert into sys_menu values('1020', '岗位查询', '104', '1',  '#', '',  'F', '0', 'system:post:list',        '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
-- insert into sys_menu values('1021', '岗位新增', '104', '2',  '#', '',  'F', '0', 'system:post:add',         '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
-- insert into sys_menu values('1022', '岗位修改', '104', '3',  '#', '',  'F', '0', 'system:post:edit',        '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
-- insert into sys_menu values('1023', '岗位删除', '104', '4',  '#', '',  'F', '0', 'system:post:remove',      '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
-- insert into sys_menu values('1024', '岗位导出', '104', '5',  '#', '',  'F', '0', 'system:post:export',      '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
-- 字典管理按钮
insert into sys_menu values('1025', '字典查询', '105', '1', '#', '',  'F', '0', 'system:dict:list',         '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
insert into sys_menu values('1026', '字典新增', '105', '2', '#', '',  'F', '0', 'system:dict:add',          '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
insert into sys_menu values('1027', '字典修改', '105', '3', '#', '',  'F', '0', 'system:dict:edit',         '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
insert into sys_menu values('1028', '字典删除', '105', '4', '#', '',  'F', '0', 'system:dict:remove',       '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
insert into sys_menu values('1029', '字典导出', '105', '5', '#', '',  'F', '0', 'system:dict:export',       '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
-- 参数设置按钮
insert into sys_menu values('1030', '参数查询', '106', '1', '#', '',  'F', '0', 'system:config:list',      '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
insert into sys_menu values('1031', '参数新增', '106', '2', '#', '',  'F', '0', 'system:config:add',       '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
insert into sys_menu values('1032', '参数修改', '106', '3', '#', '',  'F', '0', 'system:config:edit',      '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
insert into sys_menu values('1033', '参数删除', '106', '4', '#', '',  'F', '0', 'system:config:remove',    '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
insert into sys_menu values('1034', '参数导出', '106', '5', '#', '',  'F', '0', 'system:config:export',    '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
-- 通知公告按钮
insert into sys_menu values('1035', '公告查询', '107', '1', '#', '',  'F', '0', 'system:notice:list',      '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
insert into sys_menu values('1036', '公告新增', '107', '2', '#', '',  'F', '0', 'system:notice:add',       '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
insert into sys_menu values('1037', '公告修改', '107', '3', '#', '',  'F', '0', 'system:notice:edit',      '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
insert into sys_menu values('1038', '公告删除', '107', '4', '#', '',  'F', '0', 'system:notice:remove',    '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
-- 操作日志按钮
insert into sys_menu values('1039', '操作查询', '500', '1', '#', '',  'F', '0', 'monitor:operlog:list',    '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
insert into sys_menu values('1040', '操作删除', '500', '2', '#', '',  'F', '0', 'monitor:operlog:remove',  '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
insert into sys_menu values('1041', '详细信息', '500', '3', '#', '',  'F', '0', 'monitor:operlog:detail',  '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
insert into sys_menu values('1042', '日志导出', '500', '4', '#', '',  'F', '0', 'monitor:operlog:export',  '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
-- 登录日志按钮
insert into sys_menu values('1043', '登录查询', '501', '1', '#', '',  'F', '0', 'monitor:logininfor:list',         '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
insert into sys_menu values('1044', '登录删除', '501', '2', '#', '',  'F', '0', 'monitor:logininfor:remove',       '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
insert into sys_menu values('1045', '日志导出', '501', '3', '#', '',  'F', '0', 'monitor:logininfor:export',       '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
insert into sys_menu values('1046', '账户解锁', '501', '4', '#', '',  'F', '0', 'monitor:logininfor:unlock',       '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
-- 在线用户按钮
insert into sys_menu values('1047', '在线查询', '109', '1', '#', '',  'F', '0', 'monitor:online:list',             '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
insert into sys_menu values('1048', '批量强退', '109', '2', '#', '',  'F', '0', 'monitor:online:batchForceLogout', '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
insert into sys_menu values('1049', '单条强退', '109', '3', '#', '',  'F', '0', 'monitor:online:forceLogout',      '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');


-- ----------------------------
-- 初始化-用户和角色关联表数据
-- ----------------------------
insert into sys_user_role values ('1', '1');

-- ----------------------------
-- 初始化-用户与岗位关联表数据
-- ----------------------------
insert into sys_user_post values ('1', '1');
insert into sys_user_post values ('2', '2');

insert into sys_dict_type values(1,  '用户性别', 'sys_user_sex',        '0', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '用户性别列表');
insert into sys_dict_type values(2,  '菜单状态', 'sys_show_hide',       '0', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '菜单状态列表');
insert into sys_dict_type values(3,  '系统开关', 'sys_normal_disable',  '0', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '系统开关列表');
insert into sys_dict_type values(4,  '任务状态', 'sys_job_status',      '0', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '任务状态列表');
insert into sys_dict_type values(5,  '任务分组', 'sys_job_group',       '0', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '任务分组列表');
insert into sys_dict_type values(6,  '系统是否', 'sys_yes_no',          '0', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '系统是否列表');
insert into sys_dict_type values(7,  '通知类型', 'sys_notice_type',     '0', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '通知类型列表');
insert into sys_dict_type values(8,  '通知状态', 'sys_notice_status',   '0', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '通知状态列表');
insert into sys_dict_type values(9,  '操作类型', 'sys_oper_type',       '0', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '操作类型列表');
insert into sys_dict_type values(10, '系统状态', 'sys_common_status',   '0', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '登录状态列表');
insert into sys_dict_type values(11, '卡劵状态', 'card_status',   '0', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '卡劵状态列表');

insert into sys_dict_data values(1,  1,  '男',       '0',       'sys_user_sex',        '',   '',        'Y', '0', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '性别男');
insert into sys_dict_data values(2,  2,  '女',       '1',       'sys_user_sex',        '',   '',        'N', '0', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '性别女');
insert into sys_dict_data values(3,  3,  '未知',     '2',       'sys_user_sex',        '',   '',        'N', '0', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '性别未知');
insert into sys_dict_data values(4,  1,  '显示',     '0',       'sys_show_hide',       '',   'primary', 'Y', '0', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '显示菜单');
insert into sys_dict_data values(5,  2,  '隐藏',     '1',       'sys_show_hide',       '',   'danger',  'N', '0', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '隐藏菜单');
insert into sys_dict_data values(6,  1,  '正常',     '0',       'sys_normal_disable',  '',   'primary', 'Y', '0', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '正常状态');
insert into sys_dict_data values(7,  2,  '停用',     '1',       'sys_normal_disable',  '',   'danger',  'N', '0', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '停用状态');
insert into sys_dict_data values(8,  1,  '正常',     '0',       'sys_job_status',      '',   'primary', 'Y', '0', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '正常状态');
insert into sys_dict_data values(9,  2,  '暂停',     '1',       'sys_job_status',      '',   'danger',  'N', '0', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '停用状态');
insert into sys_dict_data values(10, 1,  '默认',     'DEFAULT', 'sys_job_group',       '',   '',        'Y', '0', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '默认分组');
insert into sys_dict_data values(11, 2,  '系统',     'SYSTEM',  'sys_job_group',       '',   '',        'N', '0', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '系统分组');
insert into sys_dict_data values(12, 1,  '是',       'Y',       'sys_yes_no',          '',   'primary', 'Y', '0', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '系统默认是');
insert into sys_dict_data values(13, 2,  '否',       'N',       'sys_yes_no',          '',   'danger',  'N', '0', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '系统默认否');
insert into sys_dict_data values(14, 1,  '通知',     '1',       'sys_notice_type',     '',   'warning', 'Y', '0', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '通知');
insert into sys_dict_data values(15, 2,  '公告',     '2',       'sys_notice_type',     '',   'success', 'N', '0', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '公告');
insert into sys_dict_data values(16, 1,  '正常',     '0',       'sys_notice_status',   '',   'primary', 'Y', '0', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '正常状态');
insert into sys_dict_data values(17, 2,  '关闭',     '1',       'sys_notice_status',   '',   'danger',  'N', '0', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '关闭状态');
insert into sys_dict_data values(18, 99, '其他',     '0',       'sys_oper_type',       '',   'info',    'N', '0', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '其他操作');
insert into sys_dict_data values(19, 1,  '新增',     '1',       'sys_oper_type',       '',   'info',    'N', '0', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '新增操作');
insert into sys_dict_data values(20, 2,  '修改',     '2',       'sys_oper_type',       '',   'info',    'N', '0', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '修改操作');
insert into sys_dict_data values(21, 3,  '删除',     '3',       'sys_oper_type',       '',   'danger',  'N', '0', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '删除操作');
insert into sys_dict_data values(22, 4,  '授权',     '4',       'sys_oper_type',       '',   'primary', 'N', '0', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '授权操作');
insert into sys_dict_data values(23, 5,  '导出',     '5',       'sys_oper_type',       '',   'warning', 'N', '0', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '导出操作');
insert into sys_dict_data values(24, 6,  '导入',     '6',       'sys_oper_type',       '',   'warning', 'N', '0', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '导入操作');
insert into sys_dict_data values(25, 7,  '强退',     '7',       'sys_oper_type',       '',   'danger',  'N', '0', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '强退操作');
insert into sys_dict_data values(26, 8,  '生成代码', '8',       'sys_oper_type',       '',   'warning', 'N', '0', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '生成操作');
insert into sys_dict_data values(27, 9,  '清空数据', '9',       'sys_oper_type',       '',   'danger',  'N', '0', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '清空操作');
insert into sys_dict_data values(28, 1,  '成功',     '0',       'sys_common_status',   '',   'primary', 'N', '0', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '正常状态');
insert into sys_dict_data values(29, 2,  '失败',     '1',       'sys_common_status',   '',   'danger',  'N', '0', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '停用状态');
insert into sys_dict_data values(30, 1,  '待处理',     '1',       'card_status',   '',   'primary',  'N', '0', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '待处理状态');
insert into sys_dict_data values(31, 2,  '未核销',     '2',       'card_status',   '',   'primary',  'N', '0', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '已处理，未核销');
insert into sys_dict_data values(32, 3,  '已核销',     '3',       'card_status',   '',   'primary',  'N', '0', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '已核销');


insert into sys_config values(1, '主框架页-默认皮肤样式名称',     'sys.index.skinName',       'skin-blue',     'Y', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '蓝色 skin-blue、绿色 skin-green、紫色 skin-purple、红色 skin-red、黄色 skin-yellow');
insert into sys_config values(2, '用户管理-账号初始密码',         'sys.user.initPassword',    '123456',        'Y', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '初始化密码 123456');
insert into sys_config values(3, '主框架页-侧边栏主题',           'sys.index.sideTheme',      'theme-dark',    'Y', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '深黑主题theme-dark，浅色主题theme-light，深蓝主题theme-blue');
insert into sys_config values(4, '账号自助-是否开启用户注册功能', 'sys.account.registerUser', 'false',         'Y', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '是否开启注册用户功能');
insert into sys_config values(5, '用户管理-密码字符范围',         'sys.account.chrtype',      '0',             'Y', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '默认任意字符范围，0任意（密码可以输入任意字符），1数字（密码只能为0-9数字），2英文字母（密码只能为a-z和A-Z字母），3字母和数字（密码必须包含字母，数字）,4字母数组和特殊字符（密码必须包含字母，数字，特殊字符-_）');


-- ----------------------------
-- 初始化-公告信息表数据
-- ----------------------------
insert into sys_notice values('1', '温馨提醒：2018-07-01 新版本发布啦', '2', '新版本内容', '0', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '管理员');
insert into sys_notice values('2', '维护通知：2018-07-01 系统凌晨维护', '1', '维护内容',   '0', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '管理员');