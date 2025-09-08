-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('用户提现', '3', '1', 'withdraw', 'system/withdraw/index', 1, 0, 'C', '0', '0', 'system:withdraw:list', '#', 'admin', sysdate(), '', null, '用户提现菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('用户提现查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'system:withdraw:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('用户提现新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'system:withdraw:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('用户提现修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'system:withdraw:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('用户提现删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'system:withdraw:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('用户提现导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'system:withdraw:export',       '#', 'admin', sysdate(), '', null, '');