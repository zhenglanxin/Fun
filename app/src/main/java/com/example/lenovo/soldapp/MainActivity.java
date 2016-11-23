package com.example.lenovo.soldapp;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.example.lenovo.soldapp.fragment.firstFragment;
import com.example.lenovo.soldapp.fragment.RecommendFragment;
import com.example.lenovo.soldapp.fragment.UserFragment;

public class MainActivity extends AppCompatActivity {
    View.OnClickListener myListner=new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            //1.获取一个fragmentmanager对象，是对fragment的管理器对象
            android.app.FragmentManager fm=getFragmentManager();
            //2.要获取fragmentTrasaction对象
            FragmentTransaction transaction=fm.beginTransaction();
            switch (v.getId()){
                //点击右边的按钮  个人信息
                case R.id.main_btn_information:
                    if(mInformation==null) {
                        mInformation = new UserFragment();
                    }
                        //3.设置页面
                        transaction.replace(R.id.main_content, mInformation);

                    break;
                //点击中间的按钮   商品列表
                case R.id.main_btn_list:
                    if(mList==null) {
                        mList = new firstFragment();
                    }
                        //3.设置页面
                        transaction.replace(R.id.main_content, mList);

                    break;
                //点击左边的按钮   推荐商品
                case R.id.main_btn_recommend:
                    if(mRecommend==null) {
                        mRecommend = new RecommendFragment();
                    }
                        //3.设置页面
                        transaction.replace(R.id.main_content, mRecommend);

                    break;
                case R.id.main_user:
                    if(mInformation==null) {
                        mInformation = new UserFragment();
                    }
                    //3.设置页面
                    transaction.replace(R.id.main_content, mInformation);
                    break;
            }

            //4.执行更改
            transaction.commit();
            //5.由于调用后页面不会自动刷新，所以调用方法刷新页面
            mainLinear.invalidate();
        }
    };
    private ImageButton btnInformation;
    private ImageButton btnList;
    private ImageButton btnRecommend;
    private LinearLayout mainLinear;
    private firstFragment mList;
    private UserFragment mInformation;
    private RecommendFragment mRecommend;
    private Button mainUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //删除标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        //获取控件
        setView();
        //设置监听器
        setMyListner();

        switch (Utils.flag){
            case 1://显示默认页面
                //3.设置默认的页面（fragment页面）
                setDefaultPage();
                break;
            case 2://朋友页面
                setInformationPage();
                break;
            case 3://通讯录页面
                setRecommendPage();
                break;
        }

    }





    //设置最左面的推荐界面
    private void setRecommendPage() {
        //1.获取一个fragmentmanager对象，是对fragment的管理器对象
        android.app.FragmentManager fm=getFragmentManager();
        //2.要获取fragmentTrasaction对象
        FragmentTransaction transaction=fm.beginTransaction();
        //创建对象
        if (mRecommend==null){
            mRecommend=new RecommendFragment();
        }

        //3.设置页面
        transaction.replace(R.id.main_content,mRecommend);
        //4.执行更改
        transaction.commit();
    }

    //设置最右面的用户界面
    private void setInformationPage() {
        //1.获取一个fragmentmanager对象，是对fragment的管理器对象
        android.app.FragmentManager fm=getFragmentManager();
        //2.要获取fragmentTrasaction对象
        FragmentTransaction transaction=fm.beginTransaction();
        //判断是否有这个对象
        if (mInformation==null){
            mInformation=new UserFragment();
        }
        //3.设置页面
        transaction.replace(R.id.main_content,mInformation);
        //4.执行更改
        transaction.commit();
    }

    //设置默认页面（fragment页面）
    private void setDefaultPage(){
        //1.获取一个fragmentmanager对象，是对fragment的管理器对象
        android.app.FragmentManager fm=getFragmentManager();
        //2.要获取fragmentTrasaction对象
        FragmentTransaction transaction=fm.beginTransaction();
        //判断是否创建了这个对象
        if (mList==null){
            mList=new firstFragment();
        }
        //3.设置页面
        transaction.replace(R.id.main_content,mList);
        //4.执行更改
        transaction.commit();
    }




    //将获取控件封装成方法
    private void setView(){
        btnInformation=(ImageButton)findViewById(R.id.main_btn_information);
        btnList=(ImageButton)findViewById(R.id.main_btn_list);
        btnRecommend=(ImageButton)findViewById(R.id.main_btn_recommend);
        mainLinear=(LinearLayout)findViewById(R.id.main_ll);
        mainUser=(Button)findViewById(R.id.main_user);


    }
    //将设置监听器封装成方法
    private void setMyListner(){
        btnInformation.setOnClickListener(myListner);
        btnList.setOnClickListener(myListner);
        btnRecommend.setOnClickListener(myListner);
        mainUser.setOnClickListener(myListner);
    }
}
