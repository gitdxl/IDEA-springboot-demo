package com.jdrx.smartyu.cpf.beans.entity;

import io.swagger.annotations.*;
import java.io.Serializable;
import java.util.Date;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

/**
 * test
 */
@ApiModel(value = "TestPO", description = "")
public class TestPO implements Serializable {
    private Integer i3;

    private Integer i6;

    private Integer i9;

    private Date datetime1;

    @NotNull
    private Date timestamp1;

    /**
     * test
     */
    private static final long serialVersionUID = 1L;

    public Integer getI3() {
        return i3;
    }

    public void setI3(Integer i3) {
        this.i3 = i3;
    }

    public Integer getI6() {
        return i6;
    }

    public void setI6(Integer i6) {
        this.i6 = i6;
    }

    public Integer getI9() {
        return i9;
    }

    public void setI9(Integer i9) {
        this.i9 = i9;
    }

    public Date getDatetime1() {
        return datetime1;
    }

    public void setDatetime1(Date datetime1) {
        this.datetime1 = datetime1;
    }

    public Date getTimestamp1() {
        return timestamp1;
    }

    public void setTimestamp1(Date timestamp1) {
        this.timestamp1 = timestamp1;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" {");
        sb.append("Hash = ").append(hashCode());
        sb.append(", i3=").append(i3);
        sb.append(", i6=").append(i6);
        sb.append(", i9=").append(i9);
        sb.append(", datetime1=").append(datetime1);
        sb.append(", timestamp1=").append(timestamp1);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("}");
        return sb.toString();
    }
}