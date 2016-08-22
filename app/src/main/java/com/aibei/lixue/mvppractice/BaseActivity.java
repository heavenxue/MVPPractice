package com.aibei.lixue.mvppractice;

import android.app.Activity;
import android.util.Log;

import com.aibei.lixue.mvppractice.view.IGirlView;

import java.lang.ref.WeakReference;

/**
 * 现在我们模拟的MVP框架，现在V和P之间有关联，P对Activity有引用，并且现在P进行的是耗时操作
 * 假如activity已经按了返回键，退出了，那么p还是有activity引用，没有放弃，那么p所开辟的内存空间没有被GC
 * 那么这样就造成了内存泄漏
 *
 * 解决方案：用弱引用来解决
 *
 * Created by Administrator on 2016/8/19.
 */
public abstract class BaseActivity<T extends IGirlView> extends Activity{
    private static final String TAG = "BaseActivity";
    protected WeakReference<T> mViewRef; // view 的弱引用

    /**
     * 获取view的方法
     *
     * @return 当前关联的view
     */
    public T getView() {
        return mViewRef.get();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (mViewRef != null) {
            mViewRef.clear();
            mViewRef = null;
            Log.i(TAG,"已经GC---");
        }
    }
}
