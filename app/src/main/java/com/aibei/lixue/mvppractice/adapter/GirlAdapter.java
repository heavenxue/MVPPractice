package com.aibei.lixue.mvppractice.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.aibei.lixue.mvppractice.R;
import com.aibei.lixue.mvppractice.datas.Girl;

import java.util.List;

/**
 * Created by Administrator on 2016/8/19.
 */
public class GirlAdapter extends BaseAdapter {
    private List<Girl> girls;
    private Context mContext;

    public GirlAdapter(List<Girl> girls , Context mContext){
        this.girls = girls;
        this.mContext = mContext;
    }

    @Override
    public int getCount() {
        return girls.size();
    }

    @Override
    public Object getItem(int i) {
        return girls.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder holder = null;
        if (view == null){
            holder = new ViewHolder();
            view = LayoutInflater.from(mContext).inflate(R.layout.item_girl,null);
            holder.imageView = (ImageView) view.findViewById(R.id.image);
            holder.textView = (TextView) view.findViewById(R.id.text);
            view.setTag(holder);
        }else{
            holder = (ViewHolder) view.getTag();
        }
        if (girls != null && girls.size() > 0){
            holder.imageView.setImageResource(girls.get(i).imageUrl);
            holder.textView.setText(girls.get(i).girlIntroduce);
        }
        return view;
    }

    class ViewHolder{
        ImageView imageView;
        TextView textView;
    }
}
