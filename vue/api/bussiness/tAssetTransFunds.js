import request from '@/utils/request'

// 查询划转记录列表
export function listTAssetTransFunds(query) {
  return request({
    url: '/bussiness/tAssetTransFunds/list',
    method: 'get',
    params: query
  })
}

// 查询划转记录详细
export function getTAssetTransFunds(id) {
  return request({
    url: '/bussiness/tAssetTransFunds/' + id,
    method: 'get'
  })
}

// 新增划转记录
export function addTAssetTransFunds(data) {
  return request({
    url: '/bussiness/tAssetTransFunds',
    method: 'post',
    data: data
  })
}

// 修改划转记录
export function updateTAssetTransFunds(data) {
  return request({
    url: '/bussiness/tAssetTransFunds',
    method: 'put',
    data: data
  })
}

// 删除划转记录
export function delTAssetTransFunds(id) {
  return request({
    url: '/bussiness/tAssetTransFunds/' + id,
    method: 'delete'
  })
}
