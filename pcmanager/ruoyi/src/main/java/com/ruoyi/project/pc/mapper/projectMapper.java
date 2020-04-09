package com.ruoyi.project.pc.mapper;

import java.util.List;

public interface projectMapper {

    /**
     * 项目新增
     */
    public int addProject();

    /**
     * 项目查询
     */
    public List getProjectList();

    /**
     * 项目修改
     */
    public int updateProject();
}
