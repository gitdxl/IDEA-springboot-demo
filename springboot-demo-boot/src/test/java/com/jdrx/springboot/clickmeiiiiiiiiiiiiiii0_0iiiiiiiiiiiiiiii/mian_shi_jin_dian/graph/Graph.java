package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.mian_shi_jin_dian.graph;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 有向图
 * 要存储所有的顶点和以及需要对图进行哪些操作
 * @author : dengxuelong
 * @date : 2019/06/11 11:30
 */
public class Graph<T> {
    /** 顶点Map,key=顶点.label 为什么不用List存储顶点？Map可以方便根据标识获取顶点 */
    private Map<T,Vertex<T>> vertexMap = new HashMap<>();
    // 边的数量
    private int edgeCount = 0;

    /** 添加顶点 */
    public void addVertex(T label){
        vertexMap.put(label, new Vertex<>(label));
    }

    /** 添加边 */
    public boolean addEdge(T startVertexLabel, T endVertexLabel, int weight){
        //开始顶点
        Vertex<T> startVertex = vertexMap.get(startVertexLabel);
        //结束顶点
        Vertex<T> endVertex = vertexMap.get(endVertexLabel);
        if (startVertex == null || endVertex == null) {
            //顶点不存在
            return false;
        }

        //开始顶点的边
        List<Edge> startVertexEdgeList = startVertex.edgeList;
        for (Edge edge : startVertexEdgeList) {
            //保证不会添加重复的边(不会指向重复的顶点)
            if (edge.end.equals(endVertex)) {
                return false;
            }
        }

        //创建边对象
        Edge<T> newEdge = new Edge<>(weight, endVertex);
        //将边对象添加到开始节点的邻接列表中
        startVertexEdgeList.add(newEdge);

        edgeCount ++;
        return true;
    }
    /** 根据标识获取顶点 */
    public Vertex<T> getVertex(T label){
        return vertexMap.get(label);
    }

    /** 获取边的数量 */
    public int getEdgeCount(){
        return edgeCount;
    }
    /** 获取顶点的数量 */
    public int getVertexCount(){
        return vertexMap.size();
    }

    /** 把所有顶点的访问状态置为未访问 */
    public void resetVisitState(){
        for (Map.Entry<T, Vertex<T>> entry : vertexMap.entrySet()) {
            entry.getValue().setVisitState(EVisitState.UN_VISIT);
        }
    }

    /** 获取出度为0的顶点([不存在邻接顶点]或[顶点的所有邻接顶点均已被访问])*/
    public Vertex<T> getTailVertex(){
        for (Map.Entry<T, Vertex<T>> entry : vertexMap.entrySet()) {
            Vertex<T> vertex = entry.getValue();
            if (!vertex.getVisitState().equals(EVisitState.UN_VISIT)) {
                //忽略已经被访问的顶点
                continue;
            }
            //当前顶点的邻接列表
            List<Edge> edgeList = vertex.edgeList;
            if (edgeList.size() == 0) {
                //没有邻接列表
                return vertex;
            }
            boolean isTail = true;
            for (Edge edge : edgeList) {
                if (edge.end.getVisitState().equals(EVisitState.UN_VISIT)) {
                    //只要有一个邻接顶点未访问，那么这个节点的出度就不为0
                    isTail = false;
                    break;
                }
            }
            if (isTail) {
                return vertex;
            }
        }
        return null;
    }
}







