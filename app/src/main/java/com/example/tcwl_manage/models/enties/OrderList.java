package com.example.tcwl_manage.models.enties;

import java.util.List;

/**
 * Created by MAOYH on 2016/3/29.
 */
public class OrderList {

    /**
     * count : 75516
     * dateList : [{"arrivingDate":"2002-01-14","code":"测试内容1321","goodsList":[{"name":"测试内容bj2t"}],"initDate":"测试内容j4jx","orderNo":"测试内容xstv","orderNoManual":"测试内容5f24","receivingAddr":"测试内容65b1","receivingUint":"测试内容5vu5","sendingAddr":"测试内容9c00","sendingUnit":"测试内容w8pk","totalQuantity":35347,"totalTransportFee":48151,"totalVolume":46332,"totalWight":30231,"transportDate":"测试内容95zj"}]
     * page : 13437
     * totalCount : 86313
     */

    private int count;
    private int page;
    private int totalCount;
    /**
     * arrivingDate : 2002-01-14
     * code : 测试内容1321
     * goodsList : [{"name":"测试内容bj2t"}]
     * initDate : 测试内容j4jx
     * orderNo : 测试内容xstv
     * orderNoManual : 测试内容5f24
     * receivingAddr : 测试内容65b1
     * receivingUint : 测试内容5vu5
     * sendingAddr : 测试内容9c00
     * sendingUnit : 测试内容w8pk
     * totalQuantity : 35347
     * totalTransportFee : 48151
     * totalVolume : 46332
     * totalWight : 30231
     * transportDate : 测试内容95zj
     */

    private List<DateListBean> dateList;

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<DateListBean> getDateList() {
        return dateList;
    }

    public void setDateList(List<DateListBean> dateList) {
        this.dateList = dateList;
    }

    public static class DateListBean {
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
         * name : 测试内容bj2t
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
}
