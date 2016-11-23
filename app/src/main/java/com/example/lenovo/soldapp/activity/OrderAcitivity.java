package com.example.lenovo.soldapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

import com.example.lenovo.soldapp.MainActivity;
import com.example.lenovo.soldapp.adapter.OrderListAdapter;
import com.example.lenovo.soldapp.commodity.OrderListCommodity;
import com.example.lenovo.soldapp.R;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;

import java.util.ArrayList;
import java.util.List;

public class OrderAcitivity extends AppCompatActivity {
    private List<OrderListCommodity> commodities=new ArrayList<OrderListCommodity>();
    private OrderListAdapter orderListAdapter;
    private ListView orderlist_lv;
    private Button backsign;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //删除标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_orderlist);
        getData();
        //获取控件
        setView();
        backsign.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent();
                intent.setClass(OrderAcitivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
        orderListAdapter=new OrderListAdapter(commodities,this);
        orderlist_lv.setAdapter(orderListAdapter);
    }

    //从服务器上获取数据存到commodities中
    private void getData(){
//        AsyncHttpClient client=new AsyncHttpClient();
//        client.get(getApplicationContext(), "http://10.222.251.163/order/index", new AsyncHttpResponseHandler() {
//            @Override
//            public void onSuccess(int i, Header[] headers, byte[] bytes) {
//                String string=new String(bytes);
//                string=string.substring(string.indexOf("["),string.length());
//                try {
//                    JSONArray jsonArray=new JSONArray(string);
//                    for (int j=0;j<jsonArray.length();j++){
//                        OrderListCommodity commodity=new OrderListCommodity(jsonArray.getJSONObject(j).getString("title"),jsonArray.getJSONObject(j).getString("count"),jsonArray.getJSONObject(j).getString("price"));
//                        commodities.add(commodity);
//                    }
//                } catch (JSONException e) {
//                    e.printStackTrace();
//                }
                commodities.add(new OrderListCommodity("122","2333","2222"));
    }

//            @Override
//            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
//                Toast.makeText(getApplicationContext(),
//                        "数据解析错误", Toast.LENGTH_LONG);
//            }
//        });
//    };



    //将获取控件封装成方法
    private void setView(){
        orderlist_lv=(ListView)findViewById(R.id.orderlist_lv);
        backsign=(Button)findViewById(R.id.orderlist_backsign);
    }

}
