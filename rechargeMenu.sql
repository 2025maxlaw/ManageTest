-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('用户充值', '3', '1', 'recharge', 'system/recharge/index', 1, 0, 'C', '0', '0', 'system:recharge:list', '#', 'admin', sysdate(), '', null, '用户充值菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('用户充值查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'system:recharge:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('用户充值新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'system:recharge:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('用户充值修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'system:recharge:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('用户充值删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'system:recharge:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('用户充值导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'system:recharge:export',       '#', 'admin', sysdate(), '', null, '');