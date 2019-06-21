package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.puzzle;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 串行解析
 * @param <P>
 * @param <M>
 */
public class SequentialPuzzleSolver<P, M> {
    private final Puzzle<P, M> puzzle;
    //已经经过的尾位置
    private final Set<P> seen = new HashSet<P>();

    public SequentialPuzzleSolver(Puzzle<P, M> puzzle) {
        this.puzzle = puzzle;
    }

    public List<M> solve() {
        //构建一个起始位置
        P pos = puzzle.initialPosition();
        return search(new Node<>(pos, null, null));
    }

    /**
     * 深度优先遍历  当发现路径不是最优解时推出
     * @param node  起始节点
     * @return
     */
    private List<M> search(Node<P, M> node) {
        if (!seen.contains(node.pos)) {
            seen.add(node.pos);
            if (puzzle.isGoal(node.pos))
                return node.asMoveList();
            for (M move : puzzle.legalMoves(node.pos)) {
                P pos = puzzle.move(node.pos, move);
                Node<P, M> child = new Node<>(pos, move, node);
                List<M> result = search(child);
                if (result != null)
                    return result;
            }
        }
        return null;
    }
}