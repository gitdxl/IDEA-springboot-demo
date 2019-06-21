package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.mian_shi_jin_dian.graph;

import java.util.ArrayList;
import java.util.List;

/**
 * 顶点
 * @author : dengxuelong
 * @date : 2019/06/11 11:30
 */
public class Vertex<T> {
    /** 顶点的标识 */
    T label;
    /** 该顶点邻接的边 */
    List<Edge> edgeList;
    /** 顶点被访问状态 */
    EVisitState visitState = EVisitState.UN_VISIT;

    /**非必要属性 该顶点的前驱节点  可以用来求2个顶点的最短路径 */
    Vertex<T> prevVertex;
    /**非必要属性 顶点的权值 注意和边的权值区分开 可以用来求无权图
     * (边不带权值)的最短路径*/
    double cost;

    public Vertex(T label) {
        this.label = label;
        edgeList = new ArrayList<>();
    }

    /** 获取顶点的邻接顶点 */
    public List<Edge> getEdgeList(){
        return new ArrayList<>(edgeList);
    }

    public T getLabel() {
        return label;
    }

    public void setLabel(T label) {
        this.label = label;
    }

    public void setEdgeList(List<Edge> edgeList) {
        this.edgeList = edgeList;
    }

    public EVisitState getVisitState() {
        return visitState;
    }

    public void setVisitState(EVisitState visitState) {
        this.visitState = visitState;
    }

    public Vertex<T> getPrevVertex() {
        return prevVertex;
    }

    public void setPrevVertex(Vertex<T> prevVertex) {
        this.prevVertex = prevVertex;
    }

    public double getCost() {
        return cost;
    }

    public void setCost(double cost) {
        this.cost = cost;
    }
}