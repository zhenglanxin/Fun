package com.example.lenovo.soldapp.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.soldapp.R;
import com.example.lenovo.soldapp.commodity.RecommendListCommodity;
import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;
import org.json.JSONArray;
import org.json.JSONException;

public class CommodityAcitivity extends AppCompatActivity {

    private Button back_btn;
    private TextView comName;
    private TextView comContent;
    private TextView comPrice;
    private int id;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //删除标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_commoditycontent);

        Intent intent = getIntent();

       id=intent.getIntExtra("id",0);
        //获取控件
        setView();
        //设置监听器
        setData();


    }








    //将获取控件封装成方法
    private void setView(){
        back_btn=(Button)findViewById(R.id.com_backsign);
        comName=(TextView)findViewById(R.id.com_tv_name);
        comContent=(TextView)findViewById(R.id.com_tv_content);
        comPrice=(TextView)findViewById(R.id.com_tv_price);
    }
    //将设置监听器封装成方法
    private void setData(){
        AsyncHttpClient client=new AsyncHttpClient();
        client.get(this, "http://10.222.251.163/blog/get("+id+")", new AsyncHttpResponseHandler() {
            @Override
            public void onSuccess(int i, Header[] headers, byte[] bytes) {
                String string=new String(bytes);
                string=string.substring(string.indexOf("["),string.length());
                try {
                    JSONArray jsonArray=new JSONArray(string);
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }

            @Override
            public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                Toast.makeText(getApplicationContext(),
                        "数据解析错误", Toast.LENGTH_LONG);
            }
        });
    }
}
