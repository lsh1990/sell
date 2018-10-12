package com.lsh.dao;

import com.lsh.dataobject.OrderDetail;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

/**
 * @ClassName OrderDetailDao
 * @Description:
 * @Author lsh
 * @Date 2018/10/11 21:25
 * @Version
 */
public interface OrderDetailDao extends JpaRepository<OrderDetail, String> {

    List<OrderDetail> findByOrderId(String orderId);
}
