import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Created by dengxuelong on 2017/10/27.
 */
public class Test {
    public static void main(String[] args) {
        ScheduledExecutorService executor =
                Executors.newScheduledThreadPool(2);
//        ScheduledExecutorService executor =
//              Executors.newSingleThreadScheduledExecutor();
        executor.scheduleAtFixedRate(()->{
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(format.format(new Date()) + Thread.currentThread().getName() + "  start");
            try {
                Thread.sleep(30);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },1000,1000, TimeUnit.MILLISECONDS);

        executor.scheduleWithFixedDelay(()->{
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            System.out.println(format.format(new Date()) + Thread.currentThread().getName() + "  start1");
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        },1000,1000, TimeUnit.MILLISECONDS);
    }
}
