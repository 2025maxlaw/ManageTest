import request from '@/utils/request'

// 查询客户端登录IP白名单列表
export function listTUserIpWhite(query) {
  return request({
    url: '/bussiness/tUserIpWhite/list',
    method: 'get',
    params: query
  })
}

// 查询客户端登录IP白名单详细
export function getTUserIpWhite(id) {
  return request({
    url: '/bussiness/tUserIpWhite/' + id,
    method: 'get'
  })
}

// 新增客户端登录IP白名单
export function addTUserIpWhite(data) {
  return request({
    url: '/bussiness/tUserIpWhite',
    method: 'post',
    data: data
  })
}

// 修改客户端登录IP白名单
export function updateTUserIpWhite(data) {
  return request({
    url: '/bussiness/tUserIpWhite',
    method: 'put',
    data: data
  })
}

// 删除客户端登录IP白名单
export function delTUserIpWhite(id) {
  return request({
    url: '/bussiness/tUserIpWhite/' + id,
    method: 'delete'
  })
}
