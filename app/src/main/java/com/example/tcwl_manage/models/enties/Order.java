package com.example.tcwl_manage.models.enties;

import java.util.List;

/**
 * Created by suanzi on 2016/3/25.
 */
public class Order {

    /**
     * arrivingDate : 1973-05-31
     * code : 测试内容e74i
     * goodsList : [{"name":"测试内容j56q"}]
     * initDate : 测试内容78rf
     * orderNo : 测试内容s0p6
     * orderNoManual : 测试内容81nb
     * receivingAddr : 测试内容65mv
     * receivingUint : 测试内容816e
     * sendingAddr : 测试内容f42n
     * sendingUnit : 测试内容35qy
     * totalQuantity : 51521
     * totalTransportFee : 37368
     * totalVolume : 83301
     * totalWight : 17371
     * transportDate : 测试内容5pmi
     */

    private String arrivingDate;
    private String code;
    private String initDate;
    private String orderNo;
    private String orderNoManual;
    private String receivingAddr;
    private String receivingUint;
    private String sendingAddr;
    private String sendingUnit;
    private int totalQuantity;
    private int totalTransportFee;
    private int totalVolume;
    private int totalWight;
    private String transportDate;
    /**
     * name : 测试内容j56q
     */

    private List<GoodsListBean> goodsList;

    public String getArrivingDate() {
        return arrivingDate;
    }

    public void setArrivingDate(String arrivingDate) {
        this.arrivingDate = arrivingDate;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getInitDate() {
        return initDate;
    }

    public void setInitDate(String initDate) {
        this.initDate = initDate;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public String getOrderNoManual() {
        return orderNoManual;
    }

    public void setOrderNoManual(String orderNoManual) {
        this.orderNoManual = orderNoManual;
    }

    public String getReceivingAddr() {
        return receivingAddr;
    }

    public void setReceivingAddr(String receivingAddr) {
        this.receivingAddr = receivingAddr;
    }

    public String getReceivingUint() {
        return receivingUint;
    }

    public void setReceivingUint(String receivingUint) {
        this.receivingUint = receivingUint;
    }

    public String getSendingAddr() {
        return sendingAddr;
    }

    public void setSendingAddr(String sendingAddr) {
        this.sendingAddr = sendingAddr;
    }

    public String getSendingUnit() {
        return sendingUnit;
    }

    public void setSendingUnit(String sendingUnit) {
        this.sendingUnit = sendingUnit;
    }

    public int getTotalQuantity() {
        return totalQuantity;
    }

    public void setTotalQuantity(int totalQuantity) {
        this.totalQuantity = totalQuantity;
    }

    public int getTotalTransportFee() {
        return totalTransportFee;
    }

    public void setTotalTransportFee(int totalTransportFee) {
        this.totalTransportFee = totalTransportFee;
    }

    public int getTotalVolume() {
        return totalVolume;
    }

    public void setTotalVolume(int totalVolume) {
        this.totalVolume = totalVolume;
    }

    public int getTotalWight() {
        return totalWight;
    }

    public void setTotalWight(int totalWight) {
        this.totalWight = totalWight;
    }

    public String getTransportDate() {
        return transportDate;
    }

    public void setTransportDate(String transportDate) {
        this.transportDate = transportDate;
    }

    public List<GoodsListBean> getGoodsList() {
        return goodsList;
    }

    public void setGoodsList(List<GoodsListBean> goodsList) {
        this.goodsList = goodsList;
    }

    public static class GoodsListBean {
        private String name;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }
    }
}
