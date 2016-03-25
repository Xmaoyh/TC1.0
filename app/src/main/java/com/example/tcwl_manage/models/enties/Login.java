package com.example.tcwl_manage.models.enties;

/**
 * Created by MAOYH on 2016/3/25.
 */
public class Login {
    /**
     * code : 73777
     * expiresAt : 73721
     * tokenCode : 测试内容bg57
     * userCode : 测试内容6ddi
     */

    private int code;
    private int expiresAt;
    private String tokenCode;
    private String userCode;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getExpiresAt() {
        return expiresAt;
    }

    public void setExpiresAt(int expiresAt) {
        this.expiresAt = expiresAt;
    }

    public String getTokenCode() {
        return tokenCode;
    }

    public void setTokenCode(String tokenCode) {
        this.tokenCode = tokenCode;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode;
    }
}
