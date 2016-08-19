package com.aibei.lixue.mvppractice.model;

import com.aibei.lixue.mvppractice.datas.Girl;
import com.aibei.lixue.mvppractice.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016/8/19.
 */
public class GirlModel implements IGirlModel {
    @Override
    public void loadGirl(OnCompletedListener listener) {
        //获取数据
        List<Girl> girls = new ArrayList<>();
        Girl girl0 = new Girl(R.drawable.girl0,"美女一枚多多关注");
        Girl girl1 = new Girl(R.drawable.girl1,"心如心如最美丽");
        Girl girl2 = new Girl(R.drawable.girl2,"白富美");
        Girl girl3 = new Girl(R.drawable.girl3,"天天好心情");
        Girl girl4 = new Girl(R.drawable.girl4,"眉笑眼开");
        Girl girl5 = new Girl(R.drawable.girl5,"天天魅力无限");
        Girl girl6 = new Girl(R.drawable.girl6,"美好的心情开始了");
        Girl girl7 = new Girl(R.drawable.girl8,"天空飘过一朵云");
        girls.add(girl0);
        girls.add(girl1);
        girls.add(girl2);
        girls.add(girl3);
        girls.add(girl4);
        girls.add(girl5);
        girls.add(girl6);
        girls.add(girl7);

        listener.OnCompleted(girls);


    }
}
