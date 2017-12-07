package com.shengxin.dao.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.shengxin.dao.IClassDao;
import com.shengxin.po.Class;
import com.shengxin.util.MySQLDBUtil;

public class ClassDao implements IClassDao {
	public List<Class> getClassBySellerId(int sellerId) {
		List<Class> classList = new ArrayList<Class>();
		try {

			Connection conn = MySQLDBUtil.getInstance().getConnection(
					"hot_pot_hit");
			Statement stmt = conn.createStatement();

			String sql = "select * from class where seller_id=" + sellerId;
			ResultSet rs = stmt.executeQuery(sql);
			while (rs.next()) {
				Class clas = new Class();

				clas.setId(rs.getInt("id"));
				clas.setSellerId(rs.getInt("seller_id"));
				clas.setChineseName(rs.getString("chinese_name"));
				clas.setEnglishName(rs.getString("english_name"));
				clas.setPicUrl(rs.getString("pic_url"));
				clas.setBannerShow(rs.getBoolean("banner_show"));

				classList.add(clas);
			}
			MySQLDBUtil.getInstance().closeConnection(rs, stmt, conn);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return classList;
	}
}
