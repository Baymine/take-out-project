package com.sky.service;

import com.sky.dto.SetmealDTO;
import com.sky.dto.SetmealPageQueryDTO;
import com.sky.entity.Setmeal;
import com.sky.result.PageResult;
import com.sky.vo.DishItemVO;
import com.sky.vo.SetmealVO;

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

    /**
     * 分页查询
     * @param setmealPageQueryDTO
     * @return
     */
    PageResult page(SetmealPageQueryDTO setmealPageQueryDTO);

    /**
     * 批量删除套餐
     * @param ids
     */
    void deleteBatch(List<Long> ids);

    /**
     *  根据id查询套餐
     * @param id
     * @return
     */
    SetmealVO getByIdWithDish(Long id);

    /**
     *  修改套餐
     * @param setmealDTO
     */
    void update(SetmealDTO setmealDTO);

    /**
     *  修改指定套装的状态
     * @param status
     * @param id
     */
    void startOrStop(Integer status, Long id);

    /**
     * 根据id查询套餐
     * @param setmeal
     */
    List<Setmeal> list(Setmeal setmeal);

    /**
     * 根据套餐id查询包含菜品的列表
     *
     * @param id
     * @return
     */
    List<DishItemVO> getDishItemById(Long id);
}
