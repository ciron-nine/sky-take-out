package com.sky.mapper;

import com.sky.entity.SetmealDish;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface SetmealDishMapper {

    /**
     * 根据菜品id查询对应套餐id
     * @param dishIds
     * @return
     */
    List<Long> getSetmealIdsByDishId(List<Long> dishIds );

    /**
     * 新增套餐口味关联
     * @param dish
     */
    void insert(SetmealDish dish);

    /**
     * 批量插入套餐口味关联
     * @param dishes
     */
    void insertBatch(List<SetmealDish> dishes);

    /**
     * 批量删除套餐菜品关联
     * @param setmealIds
     */
    void deleteBySetmealId(Long[] setmealIds);

    /**
     * 获取套餐关联的菜品
     * @param setmealId
     * @return
     */
    @Select("select * from setmeal_dish where setmeal_id = #{setmealId}")
    List<SetmealDish> getBySetmealId(Long setmealId);

    @Update("update setmeal set status = #{status} where id = #{id}")
    void startOrStop(Integer status, Long id);
}
