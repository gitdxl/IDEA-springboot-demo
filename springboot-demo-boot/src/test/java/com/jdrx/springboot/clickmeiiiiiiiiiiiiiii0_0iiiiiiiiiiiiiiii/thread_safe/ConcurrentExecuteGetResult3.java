package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.thread_safe;


import java.util.*;
import java.util.concurrent.*;

/**
 * 并行处理任务时，并行处理任务，并及时获取到执行的结果
 * 这里模拟浏览器=》下载图片=》加载图片的过程，
 * 为了提高用户体验，并行下载图片
 * 当下载超时就显示图片下载失败
 * <p>
 * 对于获取执行结果  进行了优化
 *
 * @author : dengxuelong
 * @date : 2018/11/01 16:07
 */
public class ConcurrentExecuteGetResult3 {
    ExecutorService es = Executors.newFixedThreadPool(10);
    //超时时间
    Long delayTime = 500L;

    //渲染页面
    public void renderPage(List<String> imageUrlList) throws InterruptedException {
        List<DownloadImgTask> taskList = new ArrayList<>();
        for (String url : imageUrlList) {
            taskList.add(new DownloadImgTask(url));
        }
        //将任务列表提交到线程池，并设置超时时间，当任务执行超时，这个任务将被取消
        //当【所有任务】都执行完成、超时取消、执行过程中抛出异常致任务结束后，这个方法才会被返回
        List<Future<String>> futureList = es.invokeAll(taskList, delayTime, TimeUnit.MILLISECONDS);
        Iterator<DownloadImgTask> taskIterator = taskList.iterator();
        for (Future<String> future : futureList) {
            DownloadImgTask task = taskIterator.next();
            try {
                //渲染图片
                renderImage(future.get());
            } catch (CancellationException e) {
                //这里能获取到失败的那个任务到底是哪个
                //因为invokeAll的【参数taskList】和【返回的futureList】有一一对应关系
                System.out.println("--" + task.url +   "图片下载超时");
            } catch (ExecutionException e) {
                System.out.println("--" + task.url + "图片下载错误"+e.getMessage());
            }
        }
    }

    //渲染图片
    public void renderImage(String imageStream) {
        System.out.println(imageStream);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new ConcurrentExecuteGetResult3().renderPage(Arrays.asList("baidu.com/a.image", "baidu.com/b.image",
                "baidu.com/c.image", "baidu.com/d.image", "baidu.com/e.image", "baidu.com/f.image", "baidu.com/g.image",
                "baidu.com/h.image"));
    }

}
/** 下载图片任务 */
class DownloadImgTask implements Callable<String>{
    String url;
    public DownloadImgTask(String url) {
        this.url = url;
    }
    @Override
    public String call() throws Exception {
        //下载图片
        int i = new Random().nextInt(10);
        Thread.sleep(100 * i);
        return i + "-" + url + "-" + url.hashCode();
    }
}







