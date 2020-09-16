insert into sys_menu values('114',  '表单构建', '3', '1', '/tool/build',           '', 'C', '0', 'tool:build:view',          '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '表单构建菜单');
insert into sys_menu values('115',  '代码生成', '3', '2', '/tool/gen',             '', 'C', '0', 'tool:gen:view',            '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '代码生成菜单');

-- 代码生成按钮
insert into sys_menu values('1057', '生成查询', '115', '1', '#', '',  'F', '0', 'tool:gen:list',     '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
insert into sys_menu values('1058', '生成修改', '115', '2', '#', '',  'F', '0', 'tool:gen:edit',     '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
insert into sys_menu values('1059', '生成删除', '115', '3', '#', '',  'F', '0', 'tool:gen:remove',   '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
insert into sys_menu values('1060', '预览代码', '115', '4', '#', '',  'F', '0', 'tool:gen:preview',  '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
insert into sys_menu values('1061', '生成代码', '115', '5', '#', '',  'F', '0', 'tool:gen:code',     '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');