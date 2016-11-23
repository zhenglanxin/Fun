package com.example.lenovo.soldapp.fragment;

import android.app.Fragment;
import android.app.ListFragment;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.lenovo.soldapp.activity.CommodityAcitivity;
import com.example.lenovo.soldapp.adapter.MainListAdapter;
import com.example.lenovo.soldapp.commodity.MainListCommodity;
import com.example.lenovo.soldapp.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;
import org.apache.http.HttpEntity;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;

import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;

import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.protocol.HTTP;
import org.apache.http.util.EntityUtils;
import org.json.JSONArray;
import org.json.JSONException;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URI;
import java.net.URISyntaxException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2016/11/1.
 */
public class firstFragment extends Fragment {
    View view;
    private Context context;
    private ListView mainListView;
    private List<MainListCommodity> mainListCommodities=new ArrayList<MainListCommodity>();
    private MainListAdapter mainListAdapter;
    private static final String Url = "http://10.7.88.102/blog/index";
    private String urlContent=null;
    private ImageView mainImg;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.activity_mainlist,container,false);
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        getData();
        setView();
        context=this.getActivity().getApplicationContext();
        mainImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(context,CommodityAcitivity.class);
                startActivity(intent);
            }
        });
        mainListAdapter=new MainListAdapter(this.context,mainListCommodities);

        setOnclick();

    }
    //点击跳转到内容界面
    private void setOnclick() {
        mainListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent=new Intent();
                intent.setClass(getActivity(), CommodityAcitivity.class);
                intent.putExtra("id",position);
                startActivity(intent);
            }
        });
    }

    //从服务器上获取需要的数据存放在
    private void getData(){
//        AsyncHttpClient client=new AsyncHttpClient();
//        client.get(context, "http://10.222.251.163/blog/index", new AsyncHttpResponseHandler() {
//            @Override
//            public void onSuccess(int i, Header[] headers, byte[] bytes) {
//                String string=new String(bytes);
//                string=string.substring(string.indexOf("["),string.length());
//                try {
//                    JSONArray jsonArray=new JSONArray(string);
//                    for (int j=0;j<jsonArray.length();j++){
//                        MainListCommodity commodity=new MainListCommodity(jsonArray.getJSONObject(j).getString("title"),jsonArray.getJSONObject(j).getString("content"));
//                        mainListCommodities.add(commodity);
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
//            }
//
//            @Override
//            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
//                Log.e("cuolallalalal",Url);
//            }
//        });

    }
    //对下方的ListView进行获取控件
    public void setView(){
        mainListView=(ListView)view.findViewById(R.id.mainlistview_lv);
        mainImg=(ImageView)view.findViewById(R.id.mainlist_img);
    }
}
