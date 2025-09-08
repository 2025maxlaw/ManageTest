-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('用户资产返佣', '2039', '1', 'assetrebate', 'bussiness/assetrebate/index', 1, 0, 'C', '0', '0', 'bussiness:assetrebate:list', '#', 'admin', sysdate(), '', null, '用户资产返佣菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('用户资产返佣查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'bussiness:assetrebate:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('用户资产返佣新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'bussiness:assetrebate:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('用户资产返佣修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'bussiness:assetrebate:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('用户资产返佣删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'bussiness:assetrebate:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('用户资产返佣导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'bussiness:assetrebate:export',       '#', 'admin', sysdate(), '', null, '');