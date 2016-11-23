package com.example.lenovo.soldapp.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.app.FragmentActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.soldapp.R;
import com.example.lenovo.soldapp.commodity.RecommendListCommodity;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2016/11/3.
 */
public class RecommendListAdapter extends BaseAdapter {
    private Context context;
    private List<RecommendListCommodity> recommendCommodities=new ArrayList<RecommendListCommodity>();

    public RecommendListAdapter(Context context, List<RecommendListCommodity> recommendCommodities) {
        this.context=context;
        this.recommendCommodities = recommendCommodities;
    }

    @Override
    public int getCount() {
        return recommendCommodities.size();
    }

    @Override
    public Object getItem(int position) {
        return recommendCommodities.get(position);
    }

    @Override
    public long getItemId(int position) {
        return recommendCommodities.get(position).getId();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (null==convertView){
            convertView= LayoutInflater.from(context).inflate(R.layout.activity_orderlistview,null);
        }
        //从服务器上下载下来的名字
        TextView textViewAuthor =(TextView)convertView.findViewById(R.id.recommend_tv_author);
        textViewAuthor.setText(recommendCommodities.get(position).getName());
        //从服务器上下载下来的简介
        TextView textViewSynopsis=(TextView)convertView.findViewById(R.id.recommend_tv_content);
        textViewSynopsis.setText(recommendCommodities.get(position).getSynopsis());

        return convertView;
    }
}
