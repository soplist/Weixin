package com.shengxin.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shengxin.dao.IVarietyOfDishesDao;
import com.shengxin.po.VarietyOfDishes;
import com.shengxin.util.MySQLDBUtil;

public class VarietyOfDishesDao implements IVarietyOfDishesDao {

	public List<VarietyOfDishes> getVarietyOfDishesListBySellerId(int sellerId) {
		String sql = "select * from variety_of_dishes join class on variety_of_dishes.class_id = class.id join seller on class.seller_id = seller.id where seller_id="
				+ sellerId;
		return packageVarietyOfDishesList(sql);
	}

	public List<VarietyOfDishes> getVarietyOfDishesListByClassIdAndSellerId(
			int classId, int sellerId) {
		String sql = "select * from variety_of_dishes join class on variety_of_dishes.class_id = class.id join seller on class.seller_id = seller.id where class_id="
				+ classId + " and seller_id=" + sellerId;
		return packageVarietyOfDishesList(sql);
	}

	private List<VarietyOfDishes> packageVarietyOfDishesList(String sql) {
		List<VarietyOfDishes> varietyOfDishesList = new ArrayList<VarietyOfDishes>();
		try {

			Connection conn = MySQLDBUtil.getInstance().getConnection(
					"hot_pot_hit");
			Statement stmt = conn.createStatement();

			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				VarietyOfDishes varietyOfDishes = new VarietyOfDishes();

				varietyOfDishes.setId(rs.getInt("id"));
				varietyOfDishes.setName(rs.getString("name"));
				varietyOfDishes.setPicUrl(rs.getString("pic_url"));
				if (rs.getBigDecimal("original_price") != null)
					varietyOfDishes.setOriginalPrice(rs.getBigDecimal(
							"original_price").doubleValue());
				varietyOfDishes.setPresentPrice(rs.getBigDecimal(
						"present_price").doubleValue());
				varietyOfDishes.setClass_id(rs.getInt("class_id"));
				varietyOfDishes
						.setClassName(rs.getString("class.chinese_name"));
				varietyOfDishes.setSeller_id(rs.getInt("seller_id"));
				varietyOfDishes.setSellerName(rs.getString("seller.name"));
				varietyOfDishes.setFavouravle(rs.getBoolean("favouravle"));
				varietyOfDishes.setSoldNum(rs.getInt("sold_num"));
				varietyOfDishes.setScannedNum(rs.getInt("scanned_num"));

				varietyOfDishesList.add(varietyOfDishes);
			}
			MySQLDBUtil.getInstance().closeConnection(rs, stmt, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return varietyOfDishesList;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		VarietyOfDishesDao dao = new VarietyOfDishesDao();
		List<VarietyOfDishes> list = dao.getVarietyOfDishesListBySellerId(1);
		for (VarietyOfDishes varietyOfDishes : list) {
			System.out.println(varietyOfDishes.getId() + ","
					+ varietyOfDishes.getName() + ","
					+ varietyOfDishes.getPicUrl() + ","
					+ varietyOfDishes.getOriginalPrice() + ","
					+ varietyOfDishes.getPresentPrice() + ","
					+ varietyOfDishes.getClass_id() + ","
					+ varietyOfDishes.getClassName() + ","
					+ varietyOfDishes.getSeller_id() + ","
					+ varietyOfDishes.getSellerName() + ","
					+ varietyOfDishes.isFavouravle() + ","
					+ varietyOfDishes.getSoldNum() + ","
					+ varietyOfDishes.getScannedNum());
		}

	}

}
