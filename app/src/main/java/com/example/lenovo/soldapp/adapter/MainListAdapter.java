package com.example.lenovo.soldapp.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.soldapp.commodity.MainListCommodity;
import com.example.lenovo.soldapp.R;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by lenovo on 2016/11/1.
 */
public class MainListAdapter extends BaseAdapter {
    //上下文环境
    private Context context;
    //网络上下载下来的信息存储的列表
    private List<MainListCommodity> listCommodities=new LinkedList<>();

    public MainListAdapter(Context context, List<MainListCommodity> listCommodities) {
        this.context = context;
        this.listCommodities = listCommodities;
    }

    @Override
    public int getCount() {
        return listCommodities.size();
    }

    @Override
    public Object getItem(int position) {
        return listCommodities.get(position);
    }

    @Override
    public long getItemId(int position) {
        return listCommodities.get(position).getId();
    }

    //实现listview的布局
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (null==convertView){
                convertView= LayoutInflater.from(context).inflate(R.layout.activity_mainlistview,null);
        }
        //设置textViewAuthor的内容为从服务器上下载的图片
        TextView textViewAuthor =(TextView)convertView.findViewById(R.id.mainlistview_tv_author);
        textViewAuthor.setText(listCommodities.get(position).getTvAuthor());

        //设置textViewContent的内容为从服务器上下载的图片
        TextView textViewContent=(TextView)convertView.findViewById(R.id.mainlistview_tv_content);
        textViewContent.setText(listCommodities.get(position).getTvContent());


        return convertView;
    }
}
