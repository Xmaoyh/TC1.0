package com.example.tcwl_manage.models.enties;

/**
 * Created by suanzi on 2016/4/5.
 * 修改订单列表的费用
 */
public class OKOrder {
    private int actionType;
    private String code;
    private int totalDeliveryFee;
    private int totalFockFee;
    private int totalInsuranceFee;
    private int totalLoadingFee;
    private int totalOtherFee;
    private int totalPickingFee;
    private int totalStoringFee;
    private int totalTransportFee;
    private String userCode;

    public int getActionType() {
        return actionType;
    }

    public void setActionType(int actionType) {
        this.actionType = actionType;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public int getTotalDeliveryFee() {
        return totalDeliveryFee;
    }

    public void setTotalDeliveryFee(int totalDeliveryFee) {
        this.totalDeliveryFee = totalDeliveryFee;
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

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
}
