-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('侧边栏内容', '3', '1', 'activity_info', 'bussiness/activity_info/index', 1, 0, 'C', '0', '0', 'bussiness:activity_info:list', '#', 'admin', sysdate(), '', null, '侧边栏内容菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('侧边栏内容查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'bussiness:activity_info:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('侧边栏内容新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'bussiness:activity_info:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('侧边栏内容修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'bussiness:activity_info:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('侧边栏内容删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'bussiness:activity_info:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('侧边栏内容导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'bussiness:activity_info:export',       '#', 'admin', sysdate(), '', null, '');