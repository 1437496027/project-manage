import request from '@/utils/request'

export function getOwnerProject() {
  return request({
    url:'../../../../data/projectData.json',
    method:'get'
  })
}
