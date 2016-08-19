package com.aibei.lixue.mvppractice.model;

import com.aibei.lixue.mvppractice.datas.Girl;

import java.util.List;

/**
 * 用来显示数据的model
 * Created by Administrator on 2016/8/19.
 */
public interface IGirlModel {
    void loadGirl(OnCompletedListener listener);

    public abstract class OnCompletedListener{
        public abstract void OnCompleted(List<Girl> girlList);
    }
}
