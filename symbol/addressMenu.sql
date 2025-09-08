-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('用户币种充值地址', '3', '1', 'symbol/address', 'bussiness/symbol/address/index', 1, 0, 'C', '0', '0', 'bussiness:symbol/address:list', '#', 'admin', sysdate(), '', null, '用户币种充值地址菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('用户币种充值地址查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'bussiness:symbol/address:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('用户币种充值地址新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'bussiness:symbol/address:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('用户币种充值地址修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'bussiness:symbol/address:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('用户币种充值地址删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'bussiness:symbol/address:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('用户币种充值地址导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'bussiness:symbol/address:export',       '#', 'admin', sysdate(), '', null, '');