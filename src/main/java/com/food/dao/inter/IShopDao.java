package com.food.dao.inter;

import com.food.dao.model.Shop;
import java.util.List;

public interface IShopDao {
    int deleteByPrimaryKey(Long id);

    int insert(Shop record);

    int insertSelective(Shop record);

    Shop selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Shop record);

    int updateByPrimaryKey(Shop record);

    List<Shop> selectByShopName(Shop reocrd);
}