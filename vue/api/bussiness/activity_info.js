import request from '@/utils/request'

// 查询侧边栏内容列表
export function listActivity_info(query) {
  return request({
    url: '/bussiness/activity_info/list',
    method: 'get',
    params: query
  })
}

// 查询侧边栏内容详细
export function getActivity_info(id) {
  return request({
    url: '/bussiness/activity_info/' + id,
    method: 'get'
  })
}

// 新增侧边栏内容
export function addActivity_info(data) {
  return request({
    url: '/bussiness/activity_info',
    method: 'post',
    data: data
  })
}

// 修改侧边栏内容
export function updateActivity_info(data) {
  return request({
    url: '/bussiness/activity_info',
    method: 'put',
    data: data
  })
}

// 删除侧边栏内容
export function delActivity_info(id) {
  return request({
    url: '/bussiness/activity_info/' + id,
    method: 'delete'
  })
}
