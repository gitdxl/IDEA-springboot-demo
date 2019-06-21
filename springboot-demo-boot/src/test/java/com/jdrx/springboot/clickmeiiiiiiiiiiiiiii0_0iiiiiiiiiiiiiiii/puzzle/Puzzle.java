package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.puzzle;

import java.util.Set;

/**
 * @author : dengxuelong
 * @date : 2019/02/15 10:12
 */
public interface Puzzle<P,M> {
    //初始化一个起始位置
    P initialPosition () ;
    //位置是否是终点
    boolean isGoal(P position) ;
    //参数位置能够移动到的位置集合
    Set<M> legalMoves(P position) ;
    P move ( P position, M move);
}