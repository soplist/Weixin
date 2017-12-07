package com.shengxin.dao;

import java.util.List;

import com.shengxin.po.Class;

public interface IClassDao {
	public List<Class> getClassBySellerId(int sellerId);
}
