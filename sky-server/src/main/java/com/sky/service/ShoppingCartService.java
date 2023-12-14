package com.sky.service;

import com.sky.dto.ShoppingCartDTO;
import com.sky.entity.ShoppingCart;

import java.util.List;

public interface ShoppingCartService {

    /**
     * 将商品添加到购物车
     * @param shoppingCartDTO
     */

    void addShoppingCart(ShoppingCartDTO shoppingCartDTO);

    /**
     * 展示购物车当中的商品
     * @return
     */
    List<ShoppingCart> showShoppingCart();
}
