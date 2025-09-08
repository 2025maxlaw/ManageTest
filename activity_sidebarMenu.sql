-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('活动侧边栏', '3', '1', 'activity_sidebar', 'bussiness/activity_sidebar/index', 1, 0, 'C', '0', '0', 'bussiness:activity_sidebar:list', '#', 'admin', sysdate(), '', null, '活动侧边栏菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('活动侧边栏查询', @parentId, '1',  '#', '', 1, 0, 'F', '0', '0', 'bussiness:activity_sidebar:query',        '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('活动侧边栏新增', @parentId, '2',  '#', '', 1, 0, 'F', '0', '0', 'bussiness:activity_sidebar:add',          '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('活动侧边栏修改', @parentId, '3',  '#', '', 1, 0, 'F', '0', '0', 'bussiness:activity_sidebar:edit',         '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('活动侧边栏删除', @parentId, '4',  '#', '', 1, 0, 'F', '0', '0', 'bussiness:activity_sidebar:remove',       '#', 'admin', sysdate(), '', null, '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, is_cache, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('活动侧边栏导出', @parentId, '5',  '#', '', 1, 0, 'F', '0', '0', 'bussiness:activity_sidebar:export',       '#', 'admin', sysdate(), '', null, '');