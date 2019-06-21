package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.mian_shi_jin_dian.graph;

import java.util.List;

/**
 * 边
 * 实际上使用【终点和权重】来表示一个边
 * @author : dengxuelong
 * @date : 2019/06/11 11:29
 */
public class Edge<T> {
    //边的权重
    int weight;
    //终点
    Vertex<T> end;

    public Edge(int weight, Vertex<T> end) {
        this.weight = weight;
        this.end = end;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public Vertex<T> getEnd() {
        return end;
    }

    public void setEnd(Vertex<T> end) {
        this.end = end;
    }
}