package com.jdrx.smartyu.cpf.beans.entity;

import io.swagger.annotations.*;
import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

/**
 * aaaa
 */
@ApiModel(value = "AaaaPO", description = "")
public class AaaaPO implements Serializable {
    private Integer a;

    private Integer b;

    /**
     * aaaa
     */
    private static final long serialVersionUID = 1L;

    public Integer getA() {
        return a;
    }

    public void setA(Integer a) {
        this.a = a;
    }

    public Integer getB() {
        return b;
    }

    public void setB(Integer b) {
        this.b = b;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" {");
        sb.append("Hash = ").append(hashCode());
        sb.append(", a=").append(a);
        sb.append(", b=").append(b);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("}");
        return sb.toString();
    }
}