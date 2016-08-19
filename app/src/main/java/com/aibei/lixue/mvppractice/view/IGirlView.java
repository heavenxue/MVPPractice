package com.aibei.lixue.mvppractice.view;

import com.aibei.lixue.mvppractice.datas.Girl;

import java.util.List;

/**
 * 为了显示View的接口
 * Created by Administrator on 2016/8/19.
 */
public interface IGirlView {
    void loading();
    void showGirl(List<Girl> girls);
}
