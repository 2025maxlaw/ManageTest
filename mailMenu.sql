-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('1v1站内信', '3', '1', 'mail', 'bussiness/mail/index', 1, 0, 'C', '0', '0', 'bussiness:mail:list', '#', 'admin', sysdate(), '', null, '1v1站内信菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('1v1站内信查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'bussiness:mail:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('1v1站内信新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'bussiness:mail:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('1v1站内信修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'bussiness:mail:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('1v1站内信删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'bussiness:mail:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('1v1站内信导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'bussiness:mail:export',       '#', 'admin', sysdate(), '', null, '');