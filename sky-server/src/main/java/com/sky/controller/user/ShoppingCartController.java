package com.sky.controller.user;

import com.sky.context.BaseContext;
import com.sky.dto.DishDTO;
import com.sky.dto.ShoppingCartDTO;
import com.sky.entity.ShoppingCart;
import com.sky.result.Result;
import com.sky.service.ShoppingCartService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user/shoppingCart")
@Slf4j
@Api(tags = "C端购物车相关接口")
public class ShoppingCartController {

    @Autowired
    private ShoppingCartService shoppingCartService;

    // TODO: 存在问题，在插入的时候，用户id为null，这导致插入失败
    @PostMapping("/add")
    @ApiOperation("添加购物车")
    public Result add(@RequestBody ShoppingCartDTO shoppingCartDTO){
        log.info("添加购物车，商品信息为:{}", shoppingCartDTO);
        shoppingCartService.addShoppingCart(shoppingCartDTO);
        return Result.success();
    }

    @GetMapping("/list")
    @ApiOperation("查询购物车数据")
    public Result<List<ShoppingCart>> list(){
        log.info("查询购物车数据");
        List<ShoppingCart>list = shoppingCartService.showShoppingCart();
        return Result.success(list);
    }

    @DeleteMapping("/clean")
    @ApiOperation("删除购物车数据")
    public Result delete(){
        log.info("删除购物车数据");
        shoppingCartService.deleteShoppingCart();
        return Result.success();
    }

    @PostMapping("/sub")
    @ApiOperation("减少购物车数据")
    public Result sub(@RequestBody DishDTO dishDTO){
        log.info("减少购物车数据");
        shoppingCartService.subShoppingCart(dishDTO);
        return Result.success();
    }
}
