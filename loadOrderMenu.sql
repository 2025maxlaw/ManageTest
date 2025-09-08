-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('贷款订单', '3', '1', 'loadOrder', 'bussiness/loadOrder/index', 1, 0, 'C', '0', '0', 'bussiness:loadOrder:list', '#', 'admin', sysdate(), '', null, '贷款订单菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('贷款订单查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'bussiness:loadOrder:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('贷款订单新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'bussiness:loadOrder:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('贷款订单修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'bussiness:loadOrder:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('贷款订单删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'bussiness:loadOrder:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('贷款订单导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'bussiness:loadOrder:export',       '#', 'admin', sysdate(), '', null, '');