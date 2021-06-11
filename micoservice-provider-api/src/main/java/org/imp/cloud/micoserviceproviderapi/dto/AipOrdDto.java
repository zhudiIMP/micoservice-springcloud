package org.imp.cloud.micoserviceproviderapi.dto;

import lombok.Data;

import java.util.Date;

@Data
public class AipOrdDto {
    private Long netOrdId;
    private String ptOrdNo;
    private String ordNo;
    private Date createTime;
    private Date updateTime;
    private Date deliverTime;
    private String ordFromCode;
    private String ordFromName;
    private String shopCode;
    private String whCode;
    private String ordStatus;
    private String payType;
    private Integer ordTotal;
    private Integer mchDscTotal;
    private Integer ptDscTotal;
    private Integer packageFee;
    private Integer logisFee;
    private Integer actualTotal;
    private Integer leftTotal;
    private Integer seviceFee;
    private String logisCode;
    private String logisName;
    private String logisBillNo;
    private String fetchCode;
    private String custName;
    private String custPhone;
    private String custAddress;
    private String shipperName;
    private String shipperPhone;
    private String invoiceTitle;
    private String clkCode;
    private String clkName;
    private String cshCode;
    private String cshName;
    private String remark;
    private String salBillNo;
    private Date recTime;
    private String longitude;
    private String latitude;
    private String logisType;
    private String daySeq;
    private String taxIdNo;
    private String salesChannel;
    private String mainOrderNo;
    private String salesOrg;
    private String udp12;
    private String udp13;
    private String udp14;
    private String udp15;
    private String vipCardNo;
    private String isDskUpload;
    private String isDskUploadtest;
    private String saleNo;
    private Integer logisFeeTotal;
    private Integer logisFeeDsc;
}
