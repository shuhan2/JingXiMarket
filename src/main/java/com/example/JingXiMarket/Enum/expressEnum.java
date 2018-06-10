package com.example.JingXiMarket.Enum;

public enum expressEnum {
    CREATE(1,"CREATE"),
    TRANSPORT(2,"TRANSPORT"),
    SIGN(3,"SIGN"),
    INVALID(5,"INVALID");
    private int expressStatusId;
    private String expressStatus;
    public int getExpressStatusId() {
        return expressStatusId;
    }

    public void setExpressStatusId(int expressStatusId) {
        this.expressStatusId = expressStatusId;
    }

    public String getExpressStatus() {
        return expressStatus;
    }

    public void setExpressStatus(String expressStatus) {
        this.expressStatus = expressStatus;
    }


    expressEnum(int expressStatusId,String expressStatus){
        this.expressStatusId = expressStatusId;
        this.expressStatus = expressStatus;
    }
}
