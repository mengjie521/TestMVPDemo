package m2166.com.testmvpdemo.page.thread;

import android.os.Bundle;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import m2166.com.testmvpdemo.R;
import m2166.com.testmvpdemo.base.MVPBaseActivity;
import m2166.com.testmvpdemo.utils.CPUUtils;

/**
 * author： mengjie on 2017/8/28.
 * email: weidadajie@163.com
 * 一个线程池里面核心没满,用核心线程去执行
 * 一个线程池里面核心满了,workQueue没满,添加到workQueue里面,等待核心线程的空闲
 * 一个线程池里面核心满了,workQueue满了,则启用非核心线程池
 */

public class ThreadPoolActivity extends MVPBaseActivity<ThreadPoolActivity, ThreadPoolPresenterImp> implements ThreadPoolView {
    @BindView(R.id.bu_thread_pool)
    Button buThreadPool;
    @BindView(R.id.bu_cached)
    Button buCached;
    @BindView(R.id.bu_fixed)
    Button buFixed;
    @BindView(R.id.bu_scheduled)
    Button buScheduled;
    @BindView(R.id.bu_single)
    Button buSingle;


    @Override
    protected ThreadPoolPresenterImp createPresenter() {
        return new ThreadPoolPresenterImp();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_thread_pool);
        ButterKnife.bind(this);

    }

    /**
     * 线程池的7个构造方法
     * public ThreadPoolExecutor(
     * int corePoolSize, 线程池中核心线程的数量    (cpu数量+1)
     * int maximumPoolSize,线程池中最大线程的数量  (cpu * 2 +1)
     * long keepAliveTime,非核心线程的保存时间
     * TimeUnit unit,(keepAliveTime)参数的单位有纳秒、微秒、毫秒、秒、分、时、天等
     * BlockingQueue<Runnable> workQueue,线程池中的任务队列,用来存储已经被提交到时尚未执行的任务
     * ThreadFactory threadFactory,为线程池提供新创建线程的功能,一般默认
     * RejectedExecutionHandler handler拒绝策略,线程池无法执行任务时
     * )
     */
    @OnClick(R.id.bu_thread_pool)
    public void onViewClicked() {
        int numCores = CPUUtils.getNumCores();
        ThreadPoolExecutor threadPoolExecutor =  new ThreadPoolExecutor(numCores + 1,
                numCores * 2 + 1,
                1, TimeUnit.SECONDS, new LinkedBlockingQueue<Runnable>(128));

        for (int i = 0; i < 30; i++) {
            final int i1 = i;
            Runnable runnable = new Runnable() {
                @Override
                public void run() {
                    SystemClock.sleep(2000);
                    Log.e("======pool", "run: " + i1);
                }
            };
            threadPoolExecutor.execute(runnable);
        }
    }

    @OnClick({R.id.bu_cached, R.id.bu_fixed, R.id.bu_scheduled, R.id.bu_single})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.bu_cached:
                //CachedTreadPool一个最大的优势是它可以根据程序的运行情况自动来调整线程池中的线程数量
                /**
                 CachedThreadPool中是没有核心线程的，但是它的最大线程数却为Integer.MAX_VALUE，
                 另外，它是有线程超时机制的，超时时间为60秒，这里它使用了SynchronousQueue作为线程队列
                 ，SynchronousQueue的特点上文已经说过了，这里不再赘述。
                 那么我们提交到CachedThreadPool消息队列中的任务在执行的过程中有什么特点呢？
                 由于最大线程数为无限大，所以每当我们添加一个新任务进来的时候，如果线程池中有空闲的线程，
                 则由该空闲的线程执行新任务，如果没有空闲线程，则创建新线程来执行任务。
                 根据CachedThreadPool的特点，我们可以在有大量任务请求的时候使用CachedThreadPool，
                 因为当CachedThreadPool中没有新任务的时候，它里边所有的线程都会因为超时而被终止
                 */
                ExecutorService executorService2 = Executors.newCachedThreadPool();
                for (int i = 0; i < 30; i++) {
                    final int i1 = i;
                    Runnable runnable = new Runnable() {
                        @Override
                        public void run() {
                            SystemClock.sleep(2000);
                            Log.e("=====", "run: " + i1);
                        }
                    };
                    executorService2.execute(runnable);
                    SystemClock.sleep(1000);
                }
                break;
            case R.id.bu_fixed:
                /*
               int corePoolSize,
               int maximumPoolSize,
               long keepAliveTime,
               TimeUnit unit,
               BlockingQueue<Runnable> workQueue
               corePoolSize 和 maximumPoolSize相等,没有保存时间,没有设置最大缓存区
               所以,在fixedThread里面,全是核心线程
               当所有的核心线程都在执行任务的时候，新的任务只能进入线程队列中进行等待，直到有线程被空闲出来
                 */
                ExecutorService executorService = Executors.newFixedThreadPool(3);
                for (int i = 0; i < 30; i++) {
                    final int i1 = i;
                    Runnable runnable = new Runnable() {
                        @Override
                        public void run() {
                            SystemClock.sleep(3000);
                            Log.e("=====", "run: "+ i1);
                        }
                    };
                    executorService.execute(runnable);
                }

                break;
            case R.id.bu_scheduled:
                //延迟initialDelay秒后每个period秒执行一次任务
                ScheduledExecutorService scheduledExecutorService = Executors.newScheduledThreadPool(3);
                Runnable runnable4 = new Runnable(){
                    @Override
                    public void run() {
                        Log.e("====", "run: ----");
                    }
                };
                scheduledExecutorService.scheduleWithFixedDelay(runnable4, 5, 1, TimeUnit.SECONDS);
                break;
            case R.id.bu_single:
                ExecutorService executorService1 = Executors.newSingleThreadExecutor();
                for (int i = 0; i < 30; i++) {
                    final int i1 = i;
                    Runnable runnable = new Runnable() {
                        @Override
                        public void run() {
                            SystemClock.sleep(1000);
                            Log.e("=====", "run: "+ i1);
                        }
                    };
                    executorService1.execute(runnable);
                }
                break;
        }
    }
}
