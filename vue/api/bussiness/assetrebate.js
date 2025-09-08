import request from '@/utils/request'

// 查询用户资产返佣列表
export function listAssetrebate(query) {
  return request({
    url: '/bussiness/assetrebate/list',
    method: 'get',
    params: query
  })
}

// 查询用户资产返佣详细
export function getAssetrebate(id) {
  return request({
    url: '/bussiness/assetrebate/' + id,
    method: 'get'
  })
}

// 新增用户资产返佣
export function addAssetrebate(data) {
  return request({
    url: '/bussiness/assetrebate',
    method: 'post',
    data: data
  })
}

// 修改用户资产返佣
export function updateAssetrebate(data) {
  return request({
    url: '/bussiness/assetrebate',
    method: 'put',
    data: data
  })
}

// 删除用户资产返佣
export function delAssetrebate(id) {
  return request({
    url: '/bussiness/assetrebate/' + id,
    method: 'delete'
  })
}
