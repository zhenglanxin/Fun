package com.example.lenovo.soldapp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.lenovo.soldapp.commodity.OrderListCommodity;
import com.example.lenovo.soldapp.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2016/11/3.
 */
public class OrderListAdapter extends BaseAdapter {
    private Context context;
    private List<OrderListCommodity> commodities=new ArrayList<OrderListCommodity>();

    public OrderListAdapter(List<OrderListCommodity> commodities, Context context) {
        this.commodities = commodities;
        this.context = context;
    }

    @Override
    public int getCount() {
        return commodities.size();
    }

    @Override
    public Object getItem(int position) {
        return commodities.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (null==convertView){
            convertView= LayoutInflater.from(context).inflate(R.layout.activity_orderlistview,null);
        }
        //设置名字为服务器上下载下来的名字
        TextView textViewComName=(TextView)convertView.findViewById(R.id.orderlist_tv_name);
        textViewComName.setText(commodities.get(position).getComName());
        //设置数量为从服务器上下载下来的数量
        TextView textViewComCount=(TextView)convertView.findViewById(R.id.orderlist_tv_count);
        textViewComCount.setText(commodities.get(position).getComCount());
        //设置价钱为从服务器上下载下来的价格
        TextView textViewComPrice=(TextView)convertView.findViewById(R.id.orderlist_tv_price);
        textViewComPrice.setText(commodities.get(position).getComPrice());

        return convertView;

    }
}
