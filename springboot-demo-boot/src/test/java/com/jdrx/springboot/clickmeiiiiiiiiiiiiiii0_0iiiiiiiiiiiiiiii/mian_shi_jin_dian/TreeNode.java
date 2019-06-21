package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.mian_shi_jin_dian;

import org.apache.commons.lang3.builder.EqualsBuilder;
import org.apache.commons.lang3.builder.HashCodeBuilder;

/**
 * @author : dengxuelong
 * @date : 2019/06/10 16:24
 */
public class TreeNode<T> {
    public T value;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode(T value) {
        this.value = value;
    }

}