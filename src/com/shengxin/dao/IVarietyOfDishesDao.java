package com.shengxin.dao;

import java.util.List;

import com.shengxin.po.VarietyOfDishes;

public interface IVarietyOfDishesDao {
	public List<VarietyOfDishes> getVarietyOfDishesListBySellerId(int sellerId);

	public List<VarietyOfDishes> getVarietyOfDishesListByClassIdAndSellerId(
			int classId, int sellerId);
}
