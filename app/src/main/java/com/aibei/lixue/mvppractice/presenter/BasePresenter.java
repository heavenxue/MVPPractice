package com.aibei.lixue.mvppractice.presenter;

import java.lang.ref.WeakReference;

/**
 * Created by Administrator on 2016/8/19.
 */
public abstract class BasePresenter<T> {
    private static final String TAG = "BasePresenter";
    protected WeakReference<T> mViewRef; // view 的弱引用

    /**
     * 将presenter与view建立关联
     *
     * @param view
     */
    public void attachView(T view) {
        mViewRef = new WeakReference<>(view);
    }

    /**
     * 获取view的方法
     *
     * @return 当前关联的view
     */
    public T getView() {
        return mViewRef.get();
    }

    /**
     * 判断是否关联的方法
     *
     * @return
     */
    public boolean isAttach() {
        return mViewRef != null && mViewRef.get() != null;
    }

    /**
     * 解除关联的方法
     */
    public void detachView() {
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
        }
    }
}
