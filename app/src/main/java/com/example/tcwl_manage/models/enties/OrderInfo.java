package com.example.tcwl_manage.models.enties;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by suanzi on 2016/3/29.
 */
public class OrderInfo {


    /**
     * code : 测试内容5t5s
     * deliverWay : 53608
     * goods : [{"code":"测试内容94yj","deliveryFee":23021,"name":"测试内容84r1","otherFee":85217,"package":"测试内容dm62","payMethod":71774,"quantity":51371,"remark":"测试内容1dgy","specification":"测试内容r51k","unitPrice":36000,"value":12455,"volume":84431,"weight":35384}]
     * initDate : 1979-06-03
     * isReceipt : false
     * orderNo : 测试内容6nx3
     * orderNoManual : 测试内容sit7
     * payMethod : 77437
     * pickingStyle : 27756
     * pickingWay : 42586
     * receivingAddr : 测试内容66ce
     * receivingPerson : 测试内容8b29
     * receivingPhoneNo : 66602
     * receivingUint : 测试内容8irj
     * remark : 测试内容o46l
     * sendingAddr : 测试内容5f0c
     * sendingPerson : 测试内容f3nv
     * sendingPhoneNo : 18304
     * sendingUnit : 测试内容e7pg
     * status : 38054
     * totalDeliveryFee : 80088
     * totalFee : 85825
     * totalFockFee : 83130
     * totalInsuranceFee : 74237
     * totalLoadingFee : 15502
     * totalOtherFee : 11506
     * totalPickingFee : 61866
     * totalStoringFee : 11166
     * totalTransportFee : 26367
     * trackingInfo : [{"createTime":"2014-05-17","oprateType":24686,"oprator":"测试内容qr2s"}]
     */

    private String code;
    private int deliverWay;
    private String initDate;
    private boolean isReceipt;
    private String orderNo;
    private String orderNoManual;
    private int payMethod;
    private int pickingStyle;
    private int pickingWay;
    private String receivingAddr;
    private String receivingPerson;
    private int receivingPhoneNo;
    private String receivingUint;
    private String remark;
    private String sendingAddr;
    private String sendingPerson;
    private int sendingPhoneNo;
    private String sendingUnit;
    private int status;
    private int totalDeliveryFee;
    private int totalFee;
    private int totalFockFee;
    private int totalInsuranceFee;
    private int totalLoadingFee;
    private int totalOtherFee;
    private int totalPickingFee;
    private int totalStoringFee;
    private int totalTransportFee;
    /**
     * code : 测试内容94yj
     * deliveryFee : 23021
     * name : 测试内容84r1
     * otherFee : 85217
     * package : 测试内容dm62
     * payMethod : 71774
     * quantity : 51371
     * remark : 测试内容1dgy
     * specification : 测试内容r51k
     * unitPrice : 36000
     * value : 12455
     * volume : 84431
     * weight : 35384
     */

    private List<GoodsBean> goods;
    /**
     * createTime : 2014-05-17
     * oprateType : 24686
     * oprator : 测试内容qr2s
     */

    private List<TrackingInfoBean> trackingInfo;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getDeliverWay() {
        return deliverWay;
    }

    public void setDeliverWay(int deliverWay) {
        this.deliverWay = deliverWay;
    }

    public String getInitDate() {
        return initDate;
    }

    public void setInitDate(String initDate) {
        this.initDate = initDate;
    }

    public boolean isIsReceipt() {
        return isReceipt;
    }

    public void setIsReceipt(boolean isReceipt) {
        this.isReceipt = isReceipt;
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

    public int getPayMethod() {
        return payMethod;
    }

    public void setPayMethod(int payMethod) {
        this.payMethod = payMethod;
    }

    public int getPickingStyle() {
        return pickingStyle;
    }

    public void setPickingStyle(int pickingStyle) {
        this.pickingStyle = pickingStyle;
    }

    public int getPickingWay() {
        return pickingWay;
    }

    public void setPickingWay(int pickingWay) {
        this.pickingWay = pickingWay;
    }

    public String getReceivingAddr() {
        return receivingAddr;
    }

    public void setReceivingAddr(String receivingAddr) {
        this.receivingAddr = receivingAddr;
    }

    public String getReceivingPerson() {
        return receivingPerson;
    }

    public void setReceivingPerson(String receivingPerson) {
        this.receivingPerson = receivingPerson;
    }

    public int getReceivingPhoneNo() {
        return receivingPhoneNo;
    }

    public void setReceivingPhoneNo(int receivingPhoneNo) {
        this.receivingPhoneNo = receivingPhoneNo;
    }

    public String getReceivingUint() {
        return receivingUint;
    }

    public void setReceivingUint(String receivingUint) {
        this.receivingUint = receivingUint;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getSendingAddr() {
        return sendingAddr;
    }

    public void setSendingAddr(String sendingAddr) {
        this.sendingAddr = sendingAddr;
    }

    public String getSendingPerson() {
        return sendingPerson;
    }

    public void setSendingPerson(String sendingPerson) {
        this.sendingPerson = sendingPerson;
    }

    public int getSendingPhoneNo() {
        return sendingPhoneNo;
    }

    public void setSendingPhoneNo(int sendingPhoneNo) {
        this.sendingPhoneNo = sendingPhoneNo;
    }

    public String getSendingUnit() {
        return sendingUnit;
    }

    public void setSendingUnit(String sendingUnit) {
        this.sendingUnit = sendingUnit;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getTotalDeliveryFee() {
        return totalDeliveryFee;
    }

    public void setTotalDeliveryFee(int totalDeliveryFee) {
        this.totalDeliveryFee = totalDeliveryFee;
    }

    public int getTotalFee() {
        return totalFee;
    }

    public void setTotalFee(int totalFee) {
        this.totalFee = totalFee;
    }

    public int getTotalFockFee() {
        return totalFockFee;
    }

    public void setTotalFockFee(int totalFockFee) {
        this.totalFockFee = totalFockFee;
    }

    public int getTotalInsuranceFee() {
        return totalInsuranceFee;
    }

    public void setTotalInsuranceFee(int totalInsuranceFee) {
        this.totalInsuranceFee = totalInsuranceFee;
    }

    public int getTotalLoadingFee() {
        return totalLoadingFee;
    }

    public void setTotalLoadingFee(int totalLoadingFee) {
        this.totalLoadingFee = totalLoadingFee;
    }

    public int getTotalOtherFee() {
        return totalOtherFee;
    }

    public void setTotalOtherFee(int totalOtherFee) {
        this.totalOtherFee = totalOtherFee;
    }

    public int getTotalPickingFee() {
        return totalPickingFee;
    }

    public void setTotalPickingFee(int totalPickingFee) {
        this.totalPickingFee = totalPickingFee;
    }

    public int getTotalStoringFee() {
        return totalStoringFee;
    }

    public void setTotalStoringFee(int totalStoringFee) {
        this.totalStoringFee = totalStoringFee;
    }

    public int getTotalTransportFee() {
        return totalTransportFee;
    }

    public void setTotalTransportFee(int totalTransportFee) {
        this.totalTransportFee = totalTransportFee;
    }

    public List<GoodsBean> getGoods() {
        return goods;
    }

    public void setGoods(List<GoodsBean> goods) {
        this.goods = goods;
    }

    public List<TrackingInfoBean> getTrackingInfo() {
        return trackingInfo;
    }

    public void setTrackingInfo(List<TrackingInfoBean> trackingInfo) {
        this.trackingInfo = trackingInfo;
    }

    public static class GoodsBean {
        private String code;
        private int deliveryFee;
        private String name;
        private int otherFee;
        @SerializedName("package")
        private String packageX;
        private int payMethod;
        private int quantity;
        private String remark;
        private String specification;
        private int unitPrice;
        private int value;
        private int volume;
        private int weight;

        public String getCode() {
            return code;
        }

        public void setCode(String code) {
            this.code = code;
        }

        public int getDeliveryFee() {
            return deliveryFee;
        }

        public void setDeliveryFee(int deliveryFee) {
            this.deliveryFee = deliveryFee;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getOtherFee() {
            return otherFee;
        }

        public void setOtherFee(int otherFee) {
            this.otherFee = otherFee;
        }

        public String getPackageX() {
            return packageX;
        }

        public void setPackageX(String packageX) {
            this.packageX = packageX;
        }

        public int getPayMethod() {
            return payMethod;
        }

        public void setPayMethod(int payMethod) {
            this.payMethod = payMethod;
        }

        public int getQuantity() {
            return quantity;
        }

        public void setQuantity(int quantity) {
            this.quantity = quantity;
        }

        public String getRemark() {
            return remark;
        }

        public void setRemark(String remark) {
            this.remark = remark;
        }

        public String getSpecification() {
            return specification;
        }

        public void setSpecification(String specification) {
            this.specification = specification;
        }

        public int getUnitPrice() {
            return unitPrice;
        }

        public void setUnitPrice(int unitPrice) {
            this.unitPrice = unitPrice;
        }

        public int getValue() {
            return value;
        }

        public void setValue(int value) {
            this.value = value;
        }

        public int getVolume() {
            return volume;
        }

        public void setVolume(int volume) {
            this.volume = volume;
        }

        public int getWeight() {
            return weight;
        }

        public void setWeight(int weight) {
            this.weight = weight;
        }
    }

    public static class TrackingInfoBean {
        private String createTime;
        private int oprateType;
        private String oprator;

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

        public String getOprator() {
            return oprator;
        }

        public void setOprator(String oprator) {
            this.oprator = oprator;
        }
    }
}
