package com.sky.mapper;

import com.sky.entity.Setmeal;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SetmealMapper {

    /**
     * 根据分类id查询套餐的数量
     * @param id
     * @return
     */
    @Select("select count(id) from setmeal where category_id = #{categoryId}")
    Integer countByCategoryId(Long id);


    /**
     * 根据分类id查询套餐
     * @param categoryId
     * @return
     */
    @Select("select * from setmeal where category_id = #{categoryId}")
    List<Setmeal> getById(Long categoryId);

    /**
     * 新增套餐
     * @param setmeal
     */
    void insert(Setmeal setmeal);
}
