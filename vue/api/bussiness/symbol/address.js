import request from '@/utils/request'

// 查询用户币种充值地址列表
export function listSymbol/address(query) {
  return request({
    url: '/bussiness/symbol/address/list',
    method: 'get',
    params: query
  })
}

// 查询用户币种充值地址详细
export function getSymbol/address(id) {
  return request({
    url: '/bussiness/symbol/address/' + id,
    method: 'get'
  })
}

// 新增用户币种充值地址
export function addSymbol/address(data) {
  return request({
    url: '/bussiness/symbol/address',
    method: 'post',
    data: data
  })
}

// 修改用户币种充值地址
export function updateSymbol/address(data) {
  return request({
    url: '/bussiness/symbol/address',
    method: 'put',
    data: data
  })
}

// 删除用户币种充值地址
export function delSymbol/address(id) {
  return request({
    url: '/bussiness/symbol/address/' + id,
    method: 'delete'
  })
}
