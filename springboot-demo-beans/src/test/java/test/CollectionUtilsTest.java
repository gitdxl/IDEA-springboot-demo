package test;

import org.apache.commons.collections.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author DengXueLong
 * @Date 2018/2/13 14:51
 */
public class CollectionUtilsTest {
    public static void main(String[] args) {
        List<Integer> a = new ArrayList<>();
        a.add(0);
        a.add(1);
        a.add(2);
        List<Integer> b = new ArrayList<>();
        b.add(2);
        b.add(3);
        b.add(4);
        System.out.println("a："+a);
        System.out.println("b："+b);
        System.out.println("isEmpty():" + CollectionUtils.isEmpty(a));
        System.out.println("并集:" + CollectionUtils.union(a, b));
        System.out.println("交集:" + CollectionUtils.intersection(a, b));
        System.out.println("并集-交集:" + CollectionUtils.disjunction(a, b));
        System.out.println("是否是子集:" + CollectionUtils.isSubCollection(a, b));
        System.out.println("a与b的差:" + CollectionUtils.subtract(a, b));
        System.out.println("b与a的差:" + CollectionUtils.subtract(b, a));
        System.out.println("集合内元素是否完全相同且size相等:" + CollectionUtils.isEqualCollection(a, b));
    }
}
