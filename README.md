# MVPPractice
MVP框架——思想代码--解决内存泄漏<br/>

MVP框架定义：
M：model 实体
V:view 视图
P:presenter 中间者

关系如下图：

![github](https://github.com/heavenxue/MVPPractice/raw/master/doc/show0.png "github")

presenter相当于一个中间者，来联系着Model和View,但是presenter和Model是双重相互可以联系，而presenter和View只是单向联系

我们都是为了你M V P三者解耦合，并不是像其他帖子中说的那样，像一个OnClickListener那么简单，不能让view跟presenter绑定，使view更加笨拙，
一定要通过presenter，理论上来说presenter和业务逻辑层都是纯旧式的能够与桌面应用或其他任何java应用共享的java代码。

那么此项目就模拟了个MVP框架，具体关系如下图：

![github](https://github.com/heavenxue/MVPPractice/raw/master/doc/show1.png "github")

为了解决内存泄漏，我们用WeakReference来保存使用过的各个view

那么`BasePresenter`的实现如下：
```java
 /**
     * 当内存不足释放内存
     */
    protected WeakReference<T> mViewRef; // view 的弱引用

    /**
     * bind p with v
     * @param view
     */
    public void attachView(T view){
        mViewRef = new WeakReference<T>(view);
    }

    public void detachView(){
        if (mViewRef != null){
            mViewRef.clear();
            mViewRef = null;
            Log.i("BasePresenter","已经GC...");
        }
    }
    /**
     * 获取view的方法
     *
     * @return 当前关联的view
     */
    public T getView() {
        return mViewRef.get();
    }
```

每个Presenter都会继承BasePresenter,如代码中的PresenterV01和PresenterV02
那么MVPBaseActivity用泛型引入BasePresenter,代码如下：
```java
public abstract class MVPBaseActivity<V,T extends BasePresenter<V>> extends Activity{
    protected T mPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //创建Presenter
        mPresenter = createPresenter();
        //内存泄漏
        //关联View
        mPresenter.attachView((V)this);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        //接触关联
        mPresenter.detachView();
    }

    protected abstract T createPresenter();
}
```
最后每个Activity就可以继承MVPBaseActivity了





鸣谢：

[https://github.com/hehonghui/android-tech-frontier/blob/master/issue-12/MVP%E6%A1%86%E6%9E%B6Mosby%E6%9E%B6%E6%9E%84%E8%AF%A6%E8%A7%A3.md](https://github.com/hehonghui/android-tech-frontier/blob/master/issue-12/MVP%E6%A1%86%E6%9E%B6Mosby%E6%9E%B6%E6%9E%84%E8%AF%A6%E8%A7%A3.md)
