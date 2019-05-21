package com.imooc.o2o.dto;

import java.io.Serializable;
import java.util.Date;

public class AreaDto implements Serializable {
    //区域id
    private Integer areaId;
    //区域名称
    private String areaName;
    //区域权重等级
    private Integer priority;
    //区域创建时间
    private String createTime;
    //区域最后更新时间
    private String lastEditTime;

    public Integer getAreaId() {
        return areaId;
    }

    public void setAreaId(Integer areaId) {
        this.areaId = areaId;
    }

    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

}
