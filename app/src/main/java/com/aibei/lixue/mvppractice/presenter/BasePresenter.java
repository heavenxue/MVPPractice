package com.aibei.lixue.mvppractice.presenter;

import android.util.Log;

import java.lang.ref.WeakReference;

/**
 * Created by Administrator on 2016/8/26.
 */
public abstract class BasePresenter<T> {
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

}
