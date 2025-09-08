-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('划转记录', '2039', '1', 'tAssetTransFunds', 'bussiness/tAssetTransFunds/index', 1, 0, 'C', '0', '0', 'bussiness:tAssetTransFunds:list', '#', 'admin', sysdate(), '', null, '划转记录菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('划转记录查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'bussiness:tAssetTransFunds:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('划转记录新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'bussiness:tAssetTransFunds:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('划转记录修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'bussiness:tAssetTransFunds:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('划转记录删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'bussiness:tAssetTransFunds:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('划转记录导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'bussiness:tAssetTransFunds:export',       '#', 'admin', sysdate(), '', null, '');