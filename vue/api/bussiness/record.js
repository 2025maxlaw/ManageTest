import request from '@/utils/request'

// 查询币种兑换记录列表
export function listRecord(query) {
  return request({
    url: '/bussiness/record/list',
    method: 'get',
    params: query
  })
}

// 查询币种兑换记录详细
export function getRecord(id) {
  return request({
    url: '/bussiness/record/' + id,
    method: 'get'
  })
}

// 新增币种兑换记录
export function addRecord(data) {
  return request({
    url: '/bussiness/record',
    method: 'post',
    data: data
  })
}

// 修改币种兑换记录
export function updateRecord(data) {
  return request({
    url: '/bussiness/record',
    method: 'put',
    data: data
  })
}

// 删除币种兑换记录
export function delRecord(id) {
  return request({
    url: '/bussiness/record/' + id,
    method: 'delete'
  })
}
