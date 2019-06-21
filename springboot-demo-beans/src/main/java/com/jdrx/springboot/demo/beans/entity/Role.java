package com.jdrx.springboot.demo.beans.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.jdrx.springboot.demo.beans.commons.JsonDateDeSerializer;

import java.util.Date;
import java.util.List;
@JsonIgnoreProperties(ignoreUnknown = true, value = {"handler"})
public class Role{

    /** 角色id */
    private Integer id;
    /** 角色中文 */
    private String nameCn;
    /** 角色英文 */
    private String nameEn;
    /** 角色所属的机构id */
    private Integer organizationId;
    /** 角色描述 */
    private String remark;
    /** 用户状态  1、有效  0 、无效 */
    private Integer roleStatus;
    /**
     * 角色类型 0 平台创建的角色 1 租户自定义的角色 2 第三方服务提供商创建的角色
     */
    private Integer roleType;
    /**
     * 服务提供商Id
     */
    private Integer providerId;

    /** 创建该角色的用户id */
    private Integer createBy;
    /** 创建该角色的用户名称 */
    private String createUserName;
    /** 创建时间 */
    private Date createAt;
    /** 更新该角色的用户Id */
    private Integer updateBy;
    /** 更新该角色的用户名称 */
    private String updateUserName;
    /** 更新时间 */
    private Date updateAt;
    /** 角色对应的资源以“,”分割 */
    private String resourceIds;
    /**
     * 资源菜单id使用逗号拼接,用于前端树级菜单资源id保存
     */
    private String resourceAllIds;
    /** 角色对应的布局 */
    private String layout;
    /** 是否可用标志位，0表示可用，1表示删除 */
    private Integer deleteFlag = 0;
    /** **/
    //private List<Resource> resourceList;

    public Role() {

    }
    /**
    public List<Resource> getResourceList() {
        return resourceList;
    }

    public void setResourceList(List<Resource> resourceList) {
        this.resourceList = resourceList;
    }
    */

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameCn() {
        return nameCn;
    }

    public void setNameCn(String nameCn) {
        this.nameCn = nameCn == null ? null : nameCn.trim();
    }

    public String getNameEn() {
        return nameEn;
    }

    public void setNameEn(String nameEn) {
        this.nameEn = nameEn == null ? null : nameEn.trim();
    }

    public Integer getOrganizationId() {
        return organizationId;
    }

    public void setOrganizationId(Integer organizationId) {
        this.organizationId = organizationId;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getRoleStatus() {
        return roleStatus;
    }

    public void setRoleStatus(Integer roleStatus) {
        this.roleStatus = roleStatus;
    }

    public Integer getRoleType() {
        return roleType;
    }

    public void setRoleType(Integer roleType) {
        this.roleType = roleType;
    }

    public Integer getProviderId() {
        return providerId;
    }

    public void setProviderId(Integer providerId) {
        this.providerId = providerId;
    }

    public Integer getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    public String getCreateUserName() {
        return createUserName;
    }

    public void setCreateUserName(String createUserName) {
        this.createUserName = createUserName == null ? null : createUserName.trim();
    }

    @JsonDeserialize(using = JsonDateDeSerializer.class)
    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Integer getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    public String getUpdateUserName() {
        return updateUserName;
    }

    public void setUpdateUserName(String updateUserName) {
        this.updateUserName = updateUserName == null ? null : updateUserName.trim();
    }

    @JsonDeserialize(using = JsonDateDeSerializer.class)
    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public String getResourceIds() {
        return resourceIds;
    }

    public void setResourceIds(String resourceIds) {
        this.resourceIds = resourceIds == null ? null : resourceIds.trim();
    }

    public String getResourceAllIds() {
        return resourceAllIds;
    }

    public void setResourceAllIds(String resourceAllIds) {
        this.resourceAllIds = resourceAllIds;
    }

    public String getLayout() {
        return layout;
    }

    public void setLayout(String layout) {
        this.layout = layout == null ? null : layout.trim();
    }

    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    @Override
    public String toString() {
        return "Role{" +
                "id=" + id +
                ", nameCn='" + nameCn + '\'' +
                ", nameEn='" + nameEn + '\'' +
                ", organizationId=" + organizationId +
                ", remark='" + remark + '\'' +
                ", roleStatus=" + roleStatus +
                ", roleType=" + roleType +
                ", providerId=" + providerId +
                ", createBy=" + createBy +
                ", createUserName='" + createUserName + '\'' +
                ", createAt=" + createAt +
                ", updateBy=" + updateBy +
                ", updateUserName='" + updateUserName + '\'' +
                ", updateAt=" + updateAt +
                ", resourceIds='" + resourceIds + '\'' +
                ", resourceAllIds='" + resourceAllIds + '\'' +
                ", layout='" + layout + '\'' +
                ", deleteFlag=" + deleteFlag +
                '}';
    }
}