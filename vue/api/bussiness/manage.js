import request from '@/utils/request'

// 查询币种管理列表
export function listManage(query) {
  return request({
    url: '/bussiness/manage/list',
    method: 'get',
    params: query
  })
}

// 查询币种管理详细
export function getManage(id) {
  return request({
    url: '/bussiness/manage/' + id,
    method: 'get'
  })
}

// 新增币种管理
export function addManage(data) {
  return request({
    url: '/bussiness/manage',
    method: 'post',
    data: data
  })
}

// 修改币种管理
export function updateManage(data) {
  return request({
    url: '/bussiness/manage',
    method: 'put',
    data: data
  })
}

// 删除币种管理
export function delManage(id) {
  return request({
    url: '/bussiness/manage/' + id,
    method: 'delete'
  })
}
