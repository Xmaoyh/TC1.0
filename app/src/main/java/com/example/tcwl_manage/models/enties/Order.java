package com.example.tcwl_manage.models.enties;

import java.util.List;

/**
 * Created by suanzi on 2016/3/25.
 */
public class Order {

    /**
     * count : 54706
     * dateList : [{"arrivingDate":"1995-06-24","code":"测试内容5ju3","goodsList":[{"name":"测试内容71nm"}],"initDate":"测试内容hc89","orderNo":"测试内容xi53","orderNoManual":"测试内容qs54","receivingAddr":"测试内容021l","receivingUint":"测试内容et8r","sendingAddr":"测试内容y55x","sendingUnit":"测试内容jb61","totalQuantity":50150,"totalTransportFee":48645,"totalVolume":46667,"totalWight":61145,"trackingInfo":[{"createTime":"测试内容8xsi","oprateType":47642,"station":"测试内容l811"}],"transportDate":"测试内容86ip"}]
     * page : 21281
     * totalCount : 68037
     */

    private int count;
    private int page;
    private int totalCount;
    /**
     * arrivingDate : 1995-06-24
     * code : 测试内容5ju3
     * goodsList : [{"name":"测试内容71nm"}]
     * initDate : 测试内容hc89
     * orderNo : 测试内容xi53
     * orderNoManual : 测试内容qs54
     * receivingAddr : 测试内容021l
     * receivingUint : 测试内容et8r
     * sendingAddr : 测试内容y55x
     * sendingUnit : 测试内容jb61
     * totalQuantity : 50150
     * totalTransportFee : 48645
     * totalVolume : 46667
     * totalWight : 61145
     * trackingInfo : [{"createTime":"测试内容8xsi","oprateType":47642,"station":"测试内容l811"}]
     * transportDate : 测试内容86ip
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
         * name : 测试内容71nm
         */

        private List<GoodsListBean> goodsList;
        /**
         * createTime : 测试内容8xsi
         * oprateType : 47642
         * station : 测试内容l811
         */

        private List<TrackingInfoBean> trackingInfo;

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

        public List<TrackingInfoBean> getTrackingInfo() {
            return trackingInfo;
        }

        public void setTrackingInfo(List<TrackingInfoBean> trackingInfo) {
            this.trackingInfo = trackingInfo;
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

        public static class TrackingInfoBean {
            private String createTime;
            private int oprateType;
            private String station;

            public String getCreateTime() {
                return createTime;
            }

            public void setCreateTime(String createTime) {
                this.createTime = createTime;
            }

            public int getOprateType() {
                return oprateType;
            }

            public void setOprateType(int oprateType) {
                this.oprateType = oprateType;
            }

            public String getStation() {
                return station;
            }

            public void setStation(String station) {
                this.station = station;
            }
        }
    }
}