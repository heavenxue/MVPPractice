package com.aibei.lixue.mvppractice.presenter;

import android.os.Handler;

import com.aibei.lixue.mvppractice.datas.Girl;
import com.aibei.lixue.mvppractice.model.GirlModel;
import com.aibei.lixue.mvppractice.model.IGirlModel;
import com.aibei.lixue.mvppractice.view.IGirlView;

import java.util.List;

/**
 * Created by Administrator on 2016/8/19.
 */
public class PresenterV01 {
    private IGirlView iGrilView;
    private IGirlModel iGirlModel = new GirlModel();

    private Handler mHandler = new Handler();

    public PresenterV01(IGirlView iGrilView){
        this.iGrilView = iGrilView;
    }

    public void attach(){
        iGrilView.loading();
        iGirlModel.loadGirl(new IGirlModel.OnCompletedListener() {
            @Override
            public void OnCompleted(final List<Girl> girlList) {
                mHandler.post(new Runnable() {//这里要用handler进行UI的显示，因为加载数据是在模拟的子线程中耗时操作的
                    @Override
                    public void run() {
                        iGrilView.showGirl(girlList);
                    }
                });
            }
        });
    }
}
