package com.neuedu.ruidaoexam.entity;

import java.util.Date;

public class TradeRecord {
    private Integer tradeId;

    private Integer sellerId;

    private Integer points;

    private Date time;

    private Integer productType;

    private Integer bankId;

    private Integer paperId;

    private Integer buyerType;

    private Integer buyerSId;

    private Integer buyerTId;

    public Integer getTradeId() {
        return tradeId;
    }

    public void setTradeId(Integer tradeId) {
        this.tradeId = tradeId;
    }

    public Integer getSellerId() {
        return sellerId;
    }

    public void setSellerId(Integer sellerId) {
        this.sellerId = sellerId;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public Integer getBankId() {
        return bankId;
    }

    public void setBankId(Integer bankId) {
        this.bankId = bankId;
    }

    public Integer getPaperId() {
        return paperId;
    }

    public void setPaperId(Integer paperId) {
        this.paperId = paperId;
    }

    public Integer getBuyerType() {
        return buyerType;
    }

    public void setBuyerType(Integer buyerType) {
        this.buyerType = buyerType;
    }

    public Integer getBuyerSId() {
        return buyerSId;
    }

    public void setBuyerSId(Integer buyerSId) {
        this.buyerSId = buyerSId;
    }

    public Integer getBuyerTId() {
        return buyerTId;
    }

    public void setBuyerTId(Integer buyerTId) {
        this.buyerTId = buyerTId;
    }
}