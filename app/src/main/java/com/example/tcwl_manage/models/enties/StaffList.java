package com.example.tcwl_manage.models.enties;

import java.util.List;

/**
 * Created by suanzi on 2016/3/23.
 */
public class StaffList {

    /**
     * count : 63630
     * dataList : [{"addr":"测试内容vucf","authValue":37006,"city":"测试内容vy3b","lastLoginTime":"测试内容8439","mobileNo":31718,"province":"测试内容766l","realName":"测试内容pmp1","roleId":74437,"staffCode":"测试内容4951","status":55232}]
     * page : 18710
     * totalCount : 15165
     */

    private int count;
    private int page;
    private int totalCount;
    /**
     * addr : 测试内容vucf
     * authValue : 37006
     * city : 测试内容vy3b
     * lastLoginTime : 测试内容8439
     * mobileNo : 31718
     * province : 测试内容766l
     * realName : 测试内容pmp1
     * roleId : 74437
     * staffCode : 测试内容4951
     * status : 55232
     */

    private List<DataListBean> dataList;

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

    public List<DataListBean> getDataList() {
        return dataList;
    }

    public void setDataList(List<DataListBean> dataList) {
        this.dataList = dataList;
    }

    public static class DataListBean {
        private String addr;
        private int authValue;
        private String city;
        private String lastLoginTime;
        private int mobileNo;
        private String province;
        private String realName;
        private int roleId;
        private String staffCode;
        private int status;

        public String getAddr() {
            return addr;
        }

        public void setAddr(String addr) {
            this.addr = addr;
        }

        public int getAuthValue() {
            return authValue;
        }

        public void setAuthValue(int authValue) {
            this.authValue = authValue;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getLastLoginTime() {
            return lastLoginTime;
        }

        public void setLastLoginTime(String lastLoginTime) {
            this.lastLoginTime = lastLoginTime;
        }

        public int getMobileNo() {
            return mobileNo;
        }

        public void setMobileNo(int mobileNo) {
            this.mobileNo = mobileNo;
        }

        public String getProvince() {
            return province;
        }

        public void setProvince(String province) {
            this.province = province;
        }

        public String getRealName() {
            return realName;
        }

        public void setRealName(String realName) {
            this.realName = realName;
        }

        public int getRoleId() {
            return roleId;
        }

        public void setRoleId(int roleId) {
            this.roleId = roleId;
        }

        public String getStaffCode() {
            return staffCode;
        }

        public void setStaffCode(String staffCode) {
            this.staffCode = staffCode;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
        }
    }
}
