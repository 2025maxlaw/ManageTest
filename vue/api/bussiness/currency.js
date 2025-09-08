import request from '@/utils/request'

// 查询币币交易币种配置列表
export function listCurrency(query) {
  return request({
    url: '/bussiness/currency/list',
    method: 'get',
    params: query
  })
}

// 查询币币交易币种配置详细
export function getCurrency(id) {
  return request({
    url: '/bussiness/currency/' + id,
    method: 'get'
  })
}

// 新增币币交易币种配置
export function addCurrency(data) {
  return request({
    url: '/bussiness/currency',
    method: 'post',
    data: data
  })
}

// 修改币币交易币种配置
export function updateCurrency(data) {
  return request({
    url: '/bussiness/currency',
    method: 'put',
    data: data
  })
}

// 删除币币交易币种配置
export function delCurrency(id) {
  return request({
    url: '/bussiness/currency/' + id,
    method: 'delete'
  })
}
