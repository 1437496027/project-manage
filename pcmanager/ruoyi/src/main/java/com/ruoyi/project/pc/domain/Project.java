package com.ruoyi.project.pc.domain;
import java.util.Date;
import java.util.List;

/**
 * 项目表
 */
public class Project {
    private static final long serialVersionUID = 1L;
    /**项目id*/
    private long projectId;

    /**
     *项目名称
     * */
    private String projectName;

    /**
     * 项目类型
     */
    private String projectType;
    /**
     * 操作人
     */
    private String projectPerson;

    /**
     *创建时间
     */
    private Date createTime;

    /**
     * feature数据集
     * @return
     */
    private List<ProjectFeature> projectFeatureList;

    public List <ProjectFeature> getProjectFeatureList() {
        return projectFeatureList;
    }

    public void setProjectFeatureList(List <ProjectFeature> projectFeatureList) {
        this.projectFeatureList = projectFeatureList;
    }

    public long getProjectId() {
        return projectId;
    }

    public void setProjectId(long projectId) {
        this.projectId = projectId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public String getProjectType() {
        return projectType;
    }

    public void setProjectType(String projectType) {
        this.projectType = projectType;
    }

    public String getProjectPerson() {
        return projectPerson;
    }

    public void setProjectPerson(String projectPerson) {
        this.projectPerson = projectPerson;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
