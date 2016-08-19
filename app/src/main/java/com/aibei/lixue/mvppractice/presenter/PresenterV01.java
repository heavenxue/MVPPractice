package com.aibei.lixue.mvppractice.presenter;

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

    public PresenterV01(IGirlView iGrilView){
        this.iGrilView = iGrilView;
    }

    public void attach(){
        iGrilView.loading();
        iGirlModel.loadGirl(new IGirlModel.OnCompletedListener() {
            @Override
            public void OnCompleted(List<Girl> girlList) {
                iGrilView.showGirl(girlList);
            }
        });
    }
}
