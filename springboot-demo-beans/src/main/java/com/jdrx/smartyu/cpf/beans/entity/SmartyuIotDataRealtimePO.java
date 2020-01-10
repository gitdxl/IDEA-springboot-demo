package com.jdrx.smartyu.cpf.beans.entity;

import io.swagger.annotations.*;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

/**
 * smartyu_iot_data_realtime
 */
@ApiModel(value = "SmartyuIotDataRealtimePO", description = "")
public class SmartyuIotDataRealtimePO implements Serializable {
    @NotNull
    @Range(min = 1)
    private Integer id;

    private String iotId;

    private String dataValue;

    @NotNull
    private Date dataTime;

    @NotNull
    private Date createAt;

    private String dataPack;

    /**
     * smartyu_iot_data_realtime
     */
    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getIotId() {
        return iotId;
    }

    public void setIotId(String iotId) {
        this.iotId = iotId == null ? null : iotId.trim();
    }

    public String getDataValue() {
        return dataValue;
    }

    public void setDataValue(String dataValue) {
        this.dataValue = dataValue == null ? null : dataValue.trim();
    }

    public Date getDataTime() {
        return dataTime;
    }

    public void setDataTime(Date dataTime) {
        this.dataTime = dataTime;
    }

    public Date getCreateAt() {
        return createAt;
    }

    public void setCreateAt(Date createAt) {
        this.createAt = createAt;
    }

    public String getDataPack() {
        return dataPack;
    }

    public void setDataPack(String dataPack) {
        this.dataPack = dataPack == null ? null : dataPack.trim();
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" {");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", iotId=").append(iotId);
        sb.append(", dataValue=").append(dataValue);
        sb.append(", dataTime=").append(dataTime);
        sb.append(", createAt=").append(createAt);
        sb.append(", dataPack=").append(dataPack);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("}");
        return sb.toString();
    }
}