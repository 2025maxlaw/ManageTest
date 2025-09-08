import request from '@/utils/request'

// 查询活动侧边栏列表
export function listActivity_sidebar(query) {
  return request({
    url: '/bussiness/activity_sidebar/list',
    method: 'get',
    params: query
  })
}

// 查询活动侧边栏详细
export function getActivity_sidebar(id) {
  return request({
    url: '/bussiness/activity_sidebar/' + id,
    method: 'get'
  })
}

// 新增活动侧边栏
export function addActivity_sidebar(data) {
  return request({
    url: '/bussiness/activity_sidebar',
    method: 'post',
    data: data
  })
}

// 修改活动侧边栏
export function updateActivity_sidebar(data) {
  return request({
    url: '/bussiness/activity_sidebar',
    method: 'put',
    data: data
  })
}

// 删除活动侧边栏
export function delActivity_sidebar(id) {
  return request({
    url: '/bussiness/activity_sidebar/' + id,
    method: 'delete'
  })
}
