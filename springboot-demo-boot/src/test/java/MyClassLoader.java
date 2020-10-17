import java.io.IOException;
import java.io.InputStream;

/**
 * @author : dengxuelong
 * @date : 2020/01/06 16:53
 */
public class MyClassLoader extends ClassLoader {
    public void s(){
        Class<?> loadedClass = findLoadedClass("java.lang.Object");

    }

    @Override
    public Class<?> loadClass(String name) throws ClassNotFoundException {
//        String className = name.substring(name.lastIndexOf(".") + 1) + ".class";
        InputStream is = getClass().getResourceAsStream("java/lang/String" + ".class");
        if(is == null){
            return super.loadClass(name);
        }

        try {
            byte[] classByte = new byte[is.available()];
            is.read(classByte);

            return defineClass(name, classByte, 0, classByte.length);
        } catch (IOException e) {
            throw new ClassNotFoundException();
        }



    }
}