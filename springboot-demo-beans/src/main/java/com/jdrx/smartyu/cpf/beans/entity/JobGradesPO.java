package com.jdrx.smartyu.cpf.beans.entity;

import io.swagger.annotations.*;
import java.io.Serializable;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.Range;

/**
 * job_grades
 */
@ApiModel(value = "JobGradesPO", description = "")
public class JobGradesPO implements Serializable {
    private String gradeLevel;

    private Integer lowestSal;

    private Integer highestSal;

    /**
     * job_grades
     */
    private static final long serialVersionUID = 1L;

    public String getGradeLevel() {
        return gradeLevel;
    }

    public void setGradeLevel(String gradeLevel) {
        this.gradeLevel = gradeLevel == null ? null : gradeLevel.trim();
    }

    public Integer getLowestSal() {
        return lowestSal;
    }

    public void setLowestSal(Integer lowestSal) {
        this.lowestSal = lowestSal;
    }

    public Integer getHighestSal() {
        return highestSal;
    }

    public void setHighestSal(Integer highestSal) {
        this.highestSal = highestSal;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" {");
        sb.append("Hash = ").append(hashCode());
        sb.append(", gradeLevel=").append(gradeLevel);
        sb.append(", lowestSal=").append(lowestSal);
        sb.append(", highestSal=").append(highestSal);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("}");
        return sb.toString();
    }
}