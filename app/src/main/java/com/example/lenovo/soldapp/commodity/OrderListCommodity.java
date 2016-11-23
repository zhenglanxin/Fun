package com.example.lenovo.soldapp.commodity;

/**
 * Created by lenovo on 2016/11/3.
 */
public class OrderListCommodity {
    //订单的货物名字
    String comName;
    //订单的数量
    String comCount;
    //订单的价格
    String comPrice;

    public OrderListCommodity(String comCount, String comName, String comPrice) {
        this.comCount = comCount;
        this.comName = comName;
        this.comPrice = comPrice;
    }

    public String getComCount() {
        return comCount;
    }

    public void setComCount(String comCount) {
        this.comCount = comCount;
    }

    public String getComName() {
        return comName;
    }

    public void setComName(String comName) {
        this.comName = comName;
    }

    public String getComPrice() {
        return comPrice;
    }

    public void setComPrice(String comPrice) {
        this.comPrice = comPrice;
    }
}
