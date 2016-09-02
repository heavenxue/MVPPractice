package com.aibei.lixue.mvppractice;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.Toast;

import com.aibei.lixue.mvppractice.adapter.GirlAdapter;
import com.aibei.lixue.mvppractice.datas.Girl;
import com.aibei.lixue.mvppractice.presenter.PresenterV01;
import com.aibei.lixue.mvppractice.view.IGirlView;

import java.util.List;

public class MainActivity extends MVPBaseActivity<IGirlView,PresenterV01> implements IGirlView {

//    private GridView gridView;
    private ListView listView;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        mContext = getBaseContext();
        mPresenter.attach();
//        new PresenterV02(this).attach();
    }

    @Override
    protected PresenterV01 createPresenter() {
//        mPresenter.attachView(this);
        return new PresenterV01();
    }


    private void initView(){
//        gridView = (GridView) findViewById(R.id.grid);
        listView = (ListView) findViewById(R.id.list);
    }

    @Override
    public void loading() {
        Toast.makeText(mContext,"美女正在加载中....",Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showGirl(List<Girl> girls) {

//        gridView.setAdapter(new GirlAdapter(girls,mContext));
        listView.setAdapter(new GirlAdapter(girls,mContext));
    }
}
