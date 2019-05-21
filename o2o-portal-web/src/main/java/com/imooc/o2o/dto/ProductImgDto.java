package com.imooc.o2o.dto;

import java.util.Date;

public class ProductImgDto {
    private Integer productImgId;
    private String productImgDesc;
    private Integer productImgAddr;
    private Integer priority;
    private Date createTime;
    private Integer productId;

    public Integer getProductImgId() {
        return productImgId;
    }

    public void setProductImgId(Integer productImgId) {
        this.productImgId = productImgId;
    }

    public String getProductImgDesc() {
        return productImgDesc;
    }

    public void setProductImgDesc(String productImgDesc) {
        this.productImgDesc = productImgDesc;
    }

    public Integer getProductImgAddr() {
        return productImgAddr;
    }

    public void setProductImgAddr(Integer productImgAddr) {
        this.productImgAddr = productImgAddr;
    }

    public Integer getPriority() {
        return priority;
    }

    public void setPriority(Integer priority) {
        this.priority = priority;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getProductId() {
        return productId;
    }

    public void setProductId(Integer productId) {
        this.productId = productId;
    }
}
