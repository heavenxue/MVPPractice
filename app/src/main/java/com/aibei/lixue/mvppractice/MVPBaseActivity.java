package com.aibei.lixue.mvppractice;

import android.app.Activity;
import android.os.Bundle;

import com.aibei.lixue.mvppractice.presenter.BasePresenter;

/**
 * 现在我们模拟的MVP框架，现在V和P之间有关联，P对Activity有引用，并且现在P进行的是耗时操作
 * 假如activity已经按了返回键，退出了，那么p还是有activity引用，没有放弃，那么p所开辟的内存空间没有被GC
 * 那么这样就造成了内存泄漏
 *
 * 解决方案：用弱引用来解决
 *
 * Created by Administrator on 2016/8/19.
 */
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
