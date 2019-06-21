package com.jdrx.springboot.clickmeiiiiiiiiiiiiiii0_0iiiiiiiiiiiiiiii.thread_safe;


import java.util.*;
import java.util.concurrent.*;

/**
 * 并行处理任务时，并行处理任务，并及时获取到执行的结果
 * 这里模拟浏览器=》下载图片=》加载图片的过程，
 * 为了提高用户体验，并行下载图片，并且每下载一张图片就进行渲染
 * @author : dengxuelong
 * @date : 2018/11/01 16:07
 */
public class ConcurrentExecuteGetResult1 {
    ExecutorService es = Executors.newFixedThreadPool(10);
    //渲染页面
    public void renderPage(List<String> imageUrlList) throws InterruptedException, ExecutionException {
        List<Future> futures = new ArrayList<>();
        for (String url : imageUrlList) {
            //并行下载图片
            Future<String> future = es.submit(() -> downloadImage(url));
            futures.add(future);
        }
        //获取下载好的图片并渲染
        while (futures.size()>0){
            Iterator<Future> iterator = futures.iterator();
            while (iterator.hasNext()) {
                try {
                    String imageStream = (String) iterator.next().
                            get(0,TimeUnit.MILLISECONDS);
                    //渲染图片 -》删除结果
                    renderImage(imageStream);
                    iterator.remove();
                } catch (TimeoutException e) {
                    //图片未完成下载 进行下次循环
                }
            }
        }
    }
    //下载图片
    public String downloadImage(String url) throws InterruptedException {
        int i = new Random().nextInt(10);
        Thread.sleep(100*i);
        return i + "-" + url + "-" + url.hashCode();
    }
    //渲染图片
    public void renderImage(String imageStream){
        System.out.println(imageStream);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        new ConcurrentExecuteGetResult1().renderPage(Arrays.asList("baidu.com/a.image","baidu.com/b.image",
                "baidu.com/c.image","baidu.com/d.image","baidu.com/e.image","baidu.com/f.image","baidu.com/g.image",
                "baidu.com/h.image"));
    }

}







