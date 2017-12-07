package com.shengxin.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import com.shengxin.po.Seller;
import com.shengxin.util.MySQLDBUtil;

public class SellerDao {
	public Seller getSellerById(int sellerId) {
		Seller seller = new Seller();
		try {

			Connection conn = MySQLDBUtil.getInstance().getConnection(
					"hot_pot_hit");
			Statement stmt = conn.createStatement();

			String sql = "select * from seller where id=" + sellerId;
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				seller.setId(rs.getInt("id"));
				seller.setName(rs.getString("name"));
				seller.setAddress(rs.getString("address"));
				seller.setPicUrl(rs.getString("pic_url"));
				seller.setPhone(rs.getString("phone"));
				seller.setRestaurantHours(rs.getString("restaurant_hours"));
			}
			MySQLDBUtil.getInstance().closeConnection(rs, stmt, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return seller;
	}
}
