package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.mian_shi_jin_dian;

import com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.mian_shi_jin_dian.graph.EVisitState;
import com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.mian_shi_jin_dian.graph.Edge;
import com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.mian_shi_jin_dian.graph.Graph;
import com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.mian_shi_jin_dian.graph.Vertex;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;

/**
 * 图中的2个节点是否存在一条路径
 * @author : dengxuelong
 * @date : 2019/06/11 15:15
 */
public class _4_2_IsExistsPath {
    /**
     * 图中的2个节点是否存在一条路径
     * 广度优先
     * @param graph
     * @param startLabel
     * @param destinationLabel
     * @return
     */
    public static boolean isExistsPath(Graph<String> graph,
                                       String startLabel,
                                       String destinationLabel){
        if (graph == null) {
            return false;
        }
        //把所有顶点的访问状态置为未访问
        graph.resetVisitState();
        //实现核心，借助队列的先进先出特点
        java.util.Queue<Vertex<String>> queue = new LinkedList<>();
        //开始顶点
        Vertex<String> startVertex = graph.getVertex(startLabel);
        //目标顶点
        Vertex<String> destinationVertex = graph.getVertex(destinationLabel);
        if (startVertex == null || destinationVertex == null) {
            return false;
        }
        queue.add(startVertex);

        while (!queue.isEmpty()) {
            //当前顶点
            Vertex<String> currentVertex = queue.poll();
            //当前顶点的邻接列表
            List<Edge> edgeList = currentVertex.getEdgeList();

            //遍历[当前顶点的邻接列表]，寻找目标顶点
            for (Edge edge : edgeList) {
                //当前顶点的邻接顶点
                Vertex endVertex = edge.getEnd();
                if(destinationVertex.equals(endVertex)){
                    //找到目标顶点
                    return true;
                } else {
                    if (endVertex.getVisitState().
                            equals(EVisitState.UN_VISIT)) {
                        //如果邻接顶点尚未访问，加入到队列中
                        queue.add(endVertex);
                    }
                }
            }
            //把当前节点访问状态标记为已访问
            currentVertex.setVisitState(EVisitState.VISITED);
        }

        //为找到目标顶点
        return false;
    }


    /**
     * 深度优先
     * @param graph
     * @param startVertex
     * @param destinationVertex
     * @return
     */
    public static boolean isExistsPath1(Graph<String> graph,
                                        Vertex<String> startVertex,
                                        Vertex<String> destinationVertex){
        if (graph == null) {
            return false;
        }
        if (startVertex == null || destinationVertex == null) {
            return false;
        }
        //把当前节点设置为已访问
        startVertex.setVisitState(EVisitState.VISITED);
        for (Edge edge : startVertex.getEdgeList()) {
            if (edge.getEnd().equals(destinationVertex)) {
                //找到目标节点
                throw new RuntimeException("找到目标节点");
            } else if (edge.getEnd().getVisitState().equals(EVisitState.UN_VISIT)){
                //如果当前节点的邻接节点未访问，则进行迭代
                isExistsPath1(graph, edge.getEnd(), destinationVertex);
            }
        }
        return false;
    }


    /**
     * 最短路径算法：在边不带权值的图中求顶点A到顶点B的最短路径--其实就是顶点A到顶点B之间的最少边的条数
     * @param graph
     * @param startVertex
     * @param destinationVertex
     * @return
     */
    public static Integer minPathCount(Graph<String> graph,
                                        Vertex<String> startVertex,
                                        Vertex<String> destinationVertex) {
        if (graph == null || startVertex == null || destinationVertex == null) {
            return null;
        }
        graph.resetVisitState();
        java.util.Queue<Vertex<String>> queue = new LinkedList<>();
        queue.add(startVertex);
        //最短长度 while循环迭代多少次长度就是几
        int pathCount = 1;
        while (!queue.isEmpty()) {
            //当前顶点
            Vertex<String> currentVertex = queue.poll();
            //当前顶点的邻接列表
            List<Edge> edgeList = currentVertex.getEdgeList();
            for (Edge edge : edgeList) {
                //邻接顶点
                Vertex endVertex = edge.getEnd();
                if (endVertex.equals(destinationVertex)) {
                    //找到目标节点
                    return pathCount;
                } else if(endVertex.getVisitState().equals(EVisitState.UN_VISIT)){
                    //如果邻接顶点尚未访问，加入到队列中
                    queue.add(endVertex);
                }
            }
            pathCount ++;
        }
        //不能到达目标节点
        return null;
    }


    /**
     * 拓扑排序
     * 寻找出度为0的顶点，保存到栈中，利用栈先进后出的特点，得到拓扑排序
     * @param graph
     * @return
     */
    public static Stack<Vertex<String>> topologySort(Graph<String> graph){
        Stack<Vertex<String>> stack = new Stack<>();

        //获取出度为0的顶点([不存在邻接顶点]或[顶点的所有邻接顶点均已被访问])
        Vertex<String> tailVertex = graph.getTailVertex();

        while (tailVertex != null) {
            stack.push(tailVertex);
            tailVertex.setVisitState(EVisitState.VISITED);
            tailVertex = graph.getTailVertex();
        }
        return stack;
    }



    public static void main(String[] args) {
        Graph<String> graph = new Graph<>();
        graph.addVertex("A");
        graph.addVertex("B");
        graph.addVertex("C");
        graph.addVertex("D");
        graph.addEdge("A","B",0);
        graph.addEdge("A","C",0);
        graph.addEdge("B","C",0);
        graph.addEdge("B","D",0);
        Vertex<String> a = graph.getVertex("A");
        Vertex<String> b = graph.getVertex("B");
        Vertex<String> c = graph.getVertex("C");
        Vertex<String> d = graph.getVertex("D");

        Stack<Vertex<String>> stack = topologySort(graph);
        while (!stack.isEmpty()) {
            System.out.println(stack.pop().getLabel());
        }

        System.out.println(" b -> a " + minPathCount(graph, b,a));
        graph.resetVisitState();
        System.out.println(" A -> D " + minPathCount(graph, a,d));
        System.out.println(" B -> C " + minPathCount(graph, b,c));

        System.out.println(" A -> D " + isExistsPath(graph, "A", "D"));
        System.out.println(" B -> A " + isExistsPath(graph, "B", "A"));
        System.out.println(" B -> D " + isExistsPath(graph, "B", "D"));
        System.out.println();
    }
}







