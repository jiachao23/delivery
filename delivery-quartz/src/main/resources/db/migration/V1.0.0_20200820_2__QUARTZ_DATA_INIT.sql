
-- 系统监控 -> 二级菜单
insert into sys_menu values('113',  '定时任务', '2', '2', '/monitor/job',          '', 'C', '0', 'monitor:job:view',         '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '定时任务菜单');

-- 定时任务按钮
insert into sys_menu values('1050', '任务查询', '113', '1', '#', '',  'F', '0', 'monitor:job:list',                '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
insert into sys_menu values('1051', '任务新增', '113', '2', '#', '',  'F', '0', 'monitor:job:add',                 '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
insert into sys_menu values('1052', '任务修改', '113', '3', '#', '',  'F', '0', 'monitor:job:edit',                '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
insert into sys_menu values('1053', '任务删除', '113', '4', '#', '',  'F', '0', 'monitor:job:remove',              '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
insert into sys_menu values('1054', '状态修改', '113', '5', '#', '',  'F', '0', 'monitor:job:changeStatus',        '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
insert into sys_menu values('1055', '任务详细', '113', '6', '#', '',  'F', '0', 'monitor:job:detail',              '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');
insert into sys_menu values('1056', '任务导出', '113', '7', '#', '',  'F', '0', 'monitor:job:export',              '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '');