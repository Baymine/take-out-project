package com.sky.service;

import com.sky.dto.SetmealDTO;
import com.sky.entity.Setmeal;
import org.springframework.stereotype.Service;

import java.util.List;


public interface SetmealService {

    /**
     * 根据分类id查询套餐数据
     * @param categoryId
     * @return
     */
    List<Setmeal> getById(Long categoryId);

    /**
     * 新增套餐
     * @param setmealDTO
     */
    void saveWithDish(SetmealDTO setmealDTO);
}
