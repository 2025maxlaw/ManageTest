import request from '@/utils/request'

// 查询mingProduct列表
export function listMing(query) {
  return request({
    url: '/bussiness/ming/list',
    method: 'get',
    params: query
  })
}

// 查询mingProduct详细
export function getMing(id) {
  return request({
    url: '/bussiness/ming/' + id,
    method: 'get'
  })
}

// 新增mingProduct
export function addMing(data) {
  return request({
    url: '/bussiness/ming',
    method: 'post',
    data: data
  })
}

// 修改mingProduct
export function updateMing(data) {
  return request({
    url: '/bussiness/ming',
    method: 'put',
    data: data
  })
}

// 删除mingProduct
export function delMing(id) {
  return request({
    url: '/bussiness/ming/' + id,
    method: 'delete'
  })
}
