package com.lsh.dao;

import com.lsh.dataobject.OrderMaster;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
/**
 * @ClassName OrderMasterDao
 * @Description: 订单-DAO
 * @Author lsh
 * @Date 2018/10/11 21:18
 * @Version
 */
public interface OrderMasterDao extends JpaRepository<OrderMaster,String> {
    /**
     * 分页查询
     * @param buyerOpenid
     * @param pageable
     * @return
     */
    Page<OrderMaster> findByBuyerOpenid(String buyerOpenid, Pageable pageable);

}
