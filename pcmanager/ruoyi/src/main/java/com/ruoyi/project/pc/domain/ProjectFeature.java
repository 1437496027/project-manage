package com.ruoyi.project.pc.domain;

public class ProjectFeature {
    private static final long serialVersionUID = 1L;
    /**
     * 要素id
     */
    private long featureId;

    /**
     * 要素名称
     */
    private String featureName;

    /**
     * geom对象
     */
    private String geom;

    public long getFeatureId() {
        return featureId;
    }

    public void setFeatureId(long featureId) {
        this.featureId = featureId;
    }

    public String getFeatureName() {
        return featureName;
    }

    public void setFeatureName(String featureName) {
        this.featureName = featureName;
    }

    public String getGeom() {
        return geom;
    }

    public void setGeom(String geom) {
        this.geom = geom;
    }
}
