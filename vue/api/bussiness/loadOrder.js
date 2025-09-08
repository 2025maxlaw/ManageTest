import request from '@/utils/request'

// 查询贷款订单列表
export function listLoadOrder(query) {
  return request({
    url: '/bussiness/loadOrder/list',
    method: 'get',
    params: query
  })
}

// 查询贷款订单详细
export function getLoadOrder(id) {
  return request({
    url: '/bussiness/loadOrder/' + id,
    method: 'get'
  })
}

// 新增贷款订单
export function addLoadOrder(data) {
  return request({
    url: '/bussiness/loadOrder',
    method: 'post',
    data: data
  })
}

// 修改贷款订单
export function updateLoadOrder(data) {
  return request({
    url: '/bussiness/loadOrder',
    method: 'put',
    data: data
  })
}

// 删除贷款订单
export function delLoadOrder(id) {
  return request({
    url: '/bussiness/loadOrder/' + id,
    method: 'delete'
  })
}
