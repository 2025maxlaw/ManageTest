import request from '@/utils/request'

// 查询【请填写功能名称】列表
export function listDay(query) {
  return request({
    url: '/system/day/list',
    method: 'get',
    params: query
  })
}

// 查询【请填写功能名称】详细
export function getDay(amount) {
  return request({
    url: '/system/day/' + amount,
    method: 'get'
  })
}

// 新增【请填写功能名称】
export function addDay(data) {
  return request({
    url: '/system/day',
    method: 'post',
    data: data
  })
}

// 修改【请填写功能名称】
export function updateDay(data) {
  return request({
    url: '/system/day',
    method: 'put',
    data: data
  })
}

// 删除【请填写功能名称】
export function delDay(amount) {
  return request({
    url: '/system/day/' + amount,
    method: 'delete'
  })
}
