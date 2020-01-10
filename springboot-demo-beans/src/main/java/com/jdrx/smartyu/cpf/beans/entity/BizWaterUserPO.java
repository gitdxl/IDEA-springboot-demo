package com.jdrx.smartyu.cpf.beans.entity;

import io.swagger.annotations.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

/**
 * biz_water_user
 */
@ApiModel(value = "BizWaterUserPO", description = "")
public class BizWaterUserPO implements Serializable {
    @NotNull
    @Range(min = 1)
    @ApiModelProperty(value = "ID", required = true)
    private Long id;

    @NotEmpty
    @Length(min = 1, max = 64)
    @ApiModelProperty(value = "用户号", required = true)
    private String code;

    @NotEmpty
    @Length(min = 1, max = 255)
    @ApiModelProperty(value = "用水地址", required = true)
    private String waterAddr;

    @NotEmpty
    @Length(min = 1, max = 10)
    @ApiModelProperty(value = "用水性质编号", required = true)
    private String waterNatureCode;

    @NotNull
    @Range(min = 1)
    @ApiModelProperty(value = "用户类别 (sys_param_detail.id)", required = true)
    private Long type;

    @ApiModelProperty(value = "国民经济分类")
    private Long applyTypeId;

    @ApiModelProperty(value = "水表ID(biz_meter.id)")
    private Long meterId;

    @NotNull
    @Range(min = 1)
    @ApiModelProperty(value = "用户状态 1(正常) 2(待接收) 3(待入册) 4(关阀停水) 5(拆表停水) 6(销户) 7(作废)", required = true)
    private Integer state;

    @NotNull
    @Range(min = 1)
    @ApiModelProperty(value = "客户ID(biz_customer.id)", required = true)
    private Long customerId;

    @ApiModelProperty(value = "用水人数")
    private Integer usePeople;

    @ApiModelProperty(value = "申请号")
    private String requestNumber;

    @ApiModelProperty(value = "工程项目编号")
    private String projectNumber;

    @ApiModelProperty(value = "水表维护单位(sys_organization.id)")
    private Long maintenanceOrgId;

    @NotNull
    @Range(min = 1)
    @ApiModelProperty(value = "行政区域  （sys_param_detail.id）", required = true)
    private Long adId;

    @ApiModelProperty(value = "所属街道ID")
    private Long addressId;

    @ApiModelProperty(value = "累计用水量")
    private Integer cumulativeWater;

    @ApiModelProperty(value = "定位坐标")
    private String meterLocationCoordinat;

    @ApiModelProperty(value = "定位地址")
    private String meterLocationAddr;

    @NotNull
    @ApiModelProperty(value = "创建时间", required = true)
    private Date createAt;

    @NotNull
    @Range(min = 1)
    @ApiModelProperty(value = "创建人", required = true)
    private Long createBy;

    @ApiModelProperty(value = "修改时间")
    private Date updateAt;

    @ApiModelProperty(value = "修改人")
    private Long updateBy;

    @NotNull
    @ApiModelProperty(value = "删除标记", required = true)
    private Byte deleteFlag;

    @NotNull
    @Range(min = 1)
    @ApiModelProperty(value = "数据所属单位（用户管理部门）", required = true)
    private Long ownerOrgId;

    @ApiModelProperty(value = "微信openId")
    private String openId;

    @ApiModelProperty(value = "垃圾费")
    private BigDecimal garbageMoney;

    @ApiModelProperty(value = "污水减免吨数")
    private Integer sewageAmount;

    @ApiModelProperty(value = "表位照片")
    private String meterLocationPic;

    /**
     * biz_water_user
     */
    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code == null ? null : code.trim();
    }

    public String getWaterAddr() {
        return waterAddr;
    }

    public void setWaterAddr(String waterAddr) {
        this.waterAddr = waterAddr == null ? null : waterAddr.trim();
    }

    public String getWaterNatureCode() {
        return waterNatureCode;
    }

    public void setWaterNatureCode(String waterNatureCode) {
        this.waterNatureCode = waterNatureCode == null ? null : waterNatureCode.trim();
    }

    public Long getType() {
        return type;
    }

    public void setType(Long type) {
        this.type = type;
    }

    public Long getApplyTypeId() {
        return applyTypeId;
    }

    public void setApplyTypeId(Long applyTypeId) {
        this.applyTypeId = applyTypeId;
    }

    public Long getMeterId() {
        return meterId;
    }

    public void setMeterId(Long meterId) {
        this.meterId = meterId;
    }

    public Integer getState() {
        return state;
    }

    public void setState(Integer state) {
        this.state = state;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public Integer getUsePeople() {
        return usePeople;
    }

    public void setUsePeople(Integer usePeople) {
        this.usePeople = usePeople;
    }

    public String getRequestNumber() {
        return requestNumber;
    }

    public void setRequestNumber(String requestNumber) {
        this.requestNumber = requestNumber == null ? null : requestNumber.trim();
    }

    public String getProjectNumber() {
        return projectNumber;
    }

    public void setProjectNumber(String projectNumber) {
        this.projectNumber = projectNumber == null ? null : projectNumber.trim();
    }

    public Long getMaintenanceOrgId() {
        return maintenanceOrgId;
    }

    public void setMaintenanceOrgId(Long maintenanceOrgId) {
        this.maintenanceOrgId = maintenanceOrgId;
    }

    public Long getAdId() {
        return adId;
    }

    public void setAdId(Long adId) {
        this.adId = adId;
    }

    public Long getAddressId() {
        return addressId;
    }

    public void setAddressId(Long addressId) {
        this.addressId = addressId;
    }

    public Integer getCumulativeWater() {
        return cumulativeWater;
    }

    public void setCumulativeWater(Integer cumulativeWater) {
        this.cumulativeWater = cumulativeWater;
    }

    public String getMeterLocationCoordinat() {
        return meterLocationCoordinat;
    }

    public void setMeterLocationCoordinat(String meterLocationCoordinat) {
        this.meterLocationCoordinat = meterLocationCoordinat == null ? null : meterLocationCoordinat.trim();
    }

    public String getMeterLocationAddr() {
        return meterLocationAddr;
    }

    public void setMeterLocationAddr(String meterLocationAddr) {
        this.meterLocationAddr = meterLocationAddr == null ? null : meterLocationAddr.trim();
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public Long getCreateBy() {
        return createBy;
    }

    public void setCreateBy(Long createBy) {
        this.createBy = createBy;
    }

    public Date getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Date updateAt) {
        this.updateAt = updateAt;
    }

    public Long getUpdateBy() {
        return updateBy;
    }

    public void setUpdateBy(Long updateBy) {
        this.updateBy = updateBy;
    }

    public Byte getDeleteFlag() {
        return deleteFlag;
    }

    public void setDeleteFlag(Byte deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    public Long getOwnerOrgId() {
        return ownerOrgId;
    }

    public void setOwnerOrgId(Long ownerOrgId) {
        this.ownerOrgId = ownerOrgId;
    }

    public String getOpenId() {
        return openId;
    }

    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
    }

    public BigDecimal getGarbageMoney() {
        return garbageMoney;
    }

    public void setGarbageMoney(BigDecimal garbageMoney) {
        this.garbageMoney = garbageMoney;
    }

    public Integer getSewageAmount() {
        return sewageAmount;
    }

    public void setSewageAmount(Integer sewageAmount) {
        this.sewageAmount = sewageAmount;
    }

    public String getMeterLocationPic() {
        return meterLocationPic;
    }

    public void setMeterLocationPic(String meterLocationPic) {
        this.meterLocationPic = meterLocationPic == null ? null : meterLocationPic.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" {");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", code=").append(code);
        sb.append(", waterAddr=").append(waterAddr);
        sb.append(", waterNatureCode=").append(waterNatureCode);
        sb.append(", type=").append(type);
        sb.append(", applyTypeId=").append(applyTypeId);
        sb.append(", meterId=").append(meterId);
        sb.append(", state=").append(state);
        sb.append(", customerId=").append(customerId);
        sb.append(", usePeople=").append(usePeople);
        sb.append(", requestNumber=").append(requestNumber);
        sb.append(", projectNumber=").append(projectNumber);
        sb.append(", maintenanceOrgId=").append(maintenanceOrgId);
        sb.append(", adId=").append(adId);
        sb.append(", addressId=").append(addressId);
        sb.append(", cumulativeWater=").append(cumulativeWater);
        sb.append(", meterLocationCoordinat=").append(meterLocationCoordinat);
        sb.append(", meterLocationAddr=").append(meterLocationAddr);
        sb.append(", createAt=").append(createAt);
        sb.append(", createBy=").append(createBy);
        sb.append(", updateAt=").append(updateAt);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", deleteFlag=").append(deleteFlag);
        sb.append(", ownerOrgId=").append(ownerOrgId);
        sb.append(", openId=").append(openId);
        sb.append(", garbageMoney=").append(garbageMoney);
        sb.append(", sewageAmount=").append(sewageAmount);
        sb.append(", meterLocationPic=").append(meterLocationPic);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("}");
        return sb.toString();
    }
}