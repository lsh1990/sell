package com.lsh.dataobject;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Date;

/**
 * @ClassName SellerInfo
 * @Description: 卖家信息
 * @Author lsh
 * @Date 2018/10/30 21:11
 * @Version
 */
@Data
@Entity
public class SellerInfo {
    @Id
    private String sellerId;

    private String username;

    private String password;

    private String openid;

    private Date createTime;

    private Date updateTime;
}
