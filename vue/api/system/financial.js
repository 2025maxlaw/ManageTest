import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listFinancial(query) {
  return request({
    url: '/system/financial/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getFinancial(id) {
  return request({
    url: '/system/financial/' + id,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addFinancial(data) {
  return request({
    url: '/system/financial',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateFinancial(data) {
  return request({
    url: '/system/financial',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delFinancial(id) {
  return request({
    url: '/system/financial/' + id,
    method: 'delete'
  })
}
