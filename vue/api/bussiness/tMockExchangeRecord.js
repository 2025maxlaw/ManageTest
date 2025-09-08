import request from '@/utils/request'

// 查询账户切换记录列表
export function listTMockExchangeRecord(query) {
  return request({
    url: '/bussiness/tMockExchangeRecord/list',
    method: 'get',
    params: query
  })
}

// 查询账户切换记录详细
export function getTMockExchangeRecord(id) {
  return request({
    url: '/bussiness/tMockExchangeRecord/' + id,
    method: 'get'
  })
}

// 新增账户切换记录
export function addTMockExchangeRecord(data) {
  return request({
    url: '/bussiness/tMockExchangeRecord',
    method: 'post',
    data: data
  })
}

// 修改账户切换记录
export function updateTMockExchangeRecord(data) {
  return request({
    url: '/bussiness/tMockExchangeRecord',
    method: 'put',
    data: data
  })
}

// 删除账户切换记录
export function delTMockExchangeRecord(id) {
  return request({
    url: '/bussiness/tMockExchangeRecord/' + id,
    method: 'delete'
  })
}
