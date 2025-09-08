import request from '@/utils/request'

// 查询秒合约币种配置列表
export function listConfig(query) {
  return request({
    url: '/system/config/list',
    method: 'get',
    params: query
  })
}

// 查询秒合约币种配置详细
export function getConfig(id) {
  return request({
    url: '/system/config/' + id,
    method: 'get'
  })
}

// 新增秒合约币种配置
export function addConfig(data) {
  return request({
    url: '/system/config',
    method: 'post',
    data: data
  })
}

// 修改秒合约币种配置
export function updateConfig(data) {
  return request({
    url: '/system/config',
    method: 'put',
    data: data
  })
}

// 删除秒合约币种配置
export function delConfig(id) {
  return request({
    url: '/system/config/' + id,
    method: 'delete'
  })
}
