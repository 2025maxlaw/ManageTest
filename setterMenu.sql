-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('规则说明', '3', '1', 'setter', 'bussiness/setter/index', 1, 0, 'C', '0', '0', 'bussiness:setter:list', '#', 'admin', sysdate(), '', null, '规则说明菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('规则说明查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'bussiness:setter:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('规则说明新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'bussiness:setter:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('规则说明修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'bussiness:setter:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('规则说明删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'bussiness:setter:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('规则说明导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'bussiness:setter:export',       '#', 'admin', sysdate(), '', null, '');