insert into sys_menu values('4', '卡劵管理', '0', '3', '#', '', 'M', '0', '', 'fa fa-bars',    'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '卡劵管理');


insert into sys_menu values('113',  '卡劵管理', '4', '6', '/system/card',          '', 'C', '0', 'system:card:view',         '#', 'admin', '2020-08-20 11-33-00', 'admin', '2020-08-20 11-33-00', '卡劵管理');

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('卡劵查询', 113, '1',  '#',  'F', '0', 'system:card:list',         '#', 'admin', '2020-08-20', 'admin', '2020-08-20', '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('卡劵新增', 113, '2',  '#',  'F', '0', 'system:card:add',          '#', 'admin', '2020-08-20', 'admin', '2020-08-20', '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('卡劵修改', 113, '3',  '#',  'F', '0', 'system:card:edit',         '#', 'admin', '2020-08-20', 'admin', '2020-08-20', '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('卡劵删除', 113, '4',  '#',  'F', '0', 'system:card:remove',       '#', 'admin', '2020-08-20', 'admin', '2020-08-20', '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('卡劵导出', 113, '5',  '#',  'F', '0', 'system:card:export',       '#', 'admin', '2020-08-20', 'admin', '2020-08-20', '');

insert into sys_menu (menu_name, parent_id, order_num, url, menu_type, visible, perms, icon, create_by, create_time, update_by, update_time, remark)
values('卡劵导入', 113, '6',  '#',  'F', '0', 'system:card:import',       '#', 'admin', '2020-08-20', 'admin', '2020-08-20', '');

