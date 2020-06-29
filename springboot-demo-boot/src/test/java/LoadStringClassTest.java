

/**
 * @author : dengxuelong
 * @date : 2020/03/17 11:14
 */
public class LoadStringClassTest {
    public static void main(String[] args) throws ClassNotFoundException {
        MyClassLoader myClassLoader = new MyClassLoader();
        Class<?> string = myClassLoader.loadClass("java.lang.String");
        System.out.println(string.getClass());
    }
}