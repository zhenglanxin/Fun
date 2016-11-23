package com.example.lenovo.soldapp.fragment;

import android.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.example.lenovo.soldapp.R;
import com.example.lenovo.soldapp.adapter.RecommendListAdapter;
import com.example.lenovo.soldapp.commodity.MainListCommodity;
import com.example.lenovo.soldapp.commodity.RecommendListCommodity;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lenovo on 2016/11/1.
 */
public class RecommendFragment extends Fragment {
    View view;
    private Context context;
    private List<RecommendListCommodity> recommendListCommodities=new ArrayList<RecommendListCommodity>();
    private RecommendListAdapter recommendListAdapter;
    private ListView recommendListView;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view=inflater.inflate(R.layout.activity_recommend,container,false);
        context=this.getActivity().getApplicationContext();
        getData();
        recommendListView=(ListView)view.findViewById(R.id.recommend_lv);
        recommendListAdapter=new RecommendListAdapter(context,recommendListCommodities);
        recommendListView.setAdapter(recommendListAdapter);
        return view;
    }

    private void getData() {
        AsyncHttpClient client=new AsyncHttpClient();
        client.get(context, "http://10.222.251.163/recommend/index", new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                String string=new String(bytes);
                string=string.substring(string.indexOf("["),string.length());
                try {
                    JSONArray jsonArray=new JSONArray(string);
                    for (int j=0;j<jsonArray.length();j++){
                        RecommendListCommodity commodity=new RecommendListCommodity(jsonArray.getJSONObject(j).getLong("id"),jsonArray.getJSONObject(j).getString("title"),jsonArray.getJSONObject(j).getString("price"));
                        recommendListCommodities.add(commodity);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {

            }
        });

    }

}
