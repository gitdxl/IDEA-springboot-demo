package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.puzzle;

import java.util.LinkedList;
import java.util.List;

/*
 *  代表一个位置
 */
class Node<P, M> {
    final P pos;
    final M move;
    //前一个位置
    final Node<P, M> prev;

    Node(P pos, M move, Node<P, M> prev) {
        this.pos = pos;
        this.move = move;
        this.prev = prev;
    }

    //构建移动的位置节点
    List<M> asMoveList() {
        List<M> solution = new LinkedList<M>();
        for (Node<P, M> n = this; n.move != null; n = n.prev)
            solution.add(0, n.move);
        return solution;
    }
}
