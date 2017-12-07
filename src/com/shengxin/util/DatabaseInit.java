package com.shengxin.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseInit {
	private void constructDatabaseAndInitData() throws ClassNotFoundException,
			SQLException {
		// Class.forName("com.mysql.jdbc.Driver");

		// String url =
		// "jdbc:mysql://localhost:3306/mysql?useUnicode=true&characterEncoding=utf-8";
		Connection conn = MySQLDBUtil.getInstance().getConnection("mysql");
		// Connection conn = DriverManager.getConnection(url, "root", "root");
		createDatabase(conn);

		// stat.executeUpdate("if db_id('hello') is not null begin drop database hello end");
		// url =
		// "jdbc:mysql://localhost:3306/hello?useUnicode=true&characterEncoding=utf-8";
		// conn = DriverManager.getConnection(url, "root", "root");
		conn = MySQLDBUtil.getInstance().getConnection("hot_pot_hit");
		createTable(conn);
		createData(conn);

		Statement stat = conn.createStatement();
		ResultSet result = stat.executeQuery("select * from variety_of_dishes");
		while (result.next()) {
			System.out.println(result.getInt("id") + " "
					+ result.getString("name") + " "
					+ result.getString("pic_url"));
		}

		MySQLDBUtil.getInstance().closeConnection(result, stat, conn);

	}

	public void constructDatabase(Connection conn) throws SQLException {
		createDatabase(conn);
		createTable(conn);
	}

	public void createDatabase(Connection conn) throws SQLException {
		Statement stat = conn.createStatement();
		stat.executeUpdate("drop database if exists hot_pot_hit");
		stat.executeUpdate("create database if not exists hot_pot_hit");
	}

	public void createTable(Connection conn) throws SQLException {
		Statement stat = conn.createStatement();

		stat.executeUpdate("drop table if exists seller");
		stat.executeUpdate("create table if not exists hot_pot_hit.seller("
				+ "id int not null auto_increment, "
				+ "name varchar(100) not null, "
				+ "address varchar(200) not null, "
				+ "pic_url  varchar(200) not null,"
				+ "phone varchar(100) not null,"
				+ "restaurant_hours varchar(100) not null,"
				+ "primary key ( id )"
				+ ")ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC");

		stat.executeUpdate("drop table if exists class");
		stat.executeUpdate("create table if not exists hot_pot_hit.class("
				+ "id int not null auto_increment, "
				+ "seller_id int not null,"
				+ "chinese_name varchar(100) not null, "
				+ "english_name varchar(100), "
				+ "pic_url  varchar(200) not null,"
				+ "banner_show boolean default false,"
				+ "constraint fk_seller_id foreign key(seller_id) references seller(id),"
				+ "primary key ( id )"
				+ ")ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC");
		// "primary key ( id )"+")ENGINE=MEMORY AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC");

		stat.executeUpdate("drop table if exists variety_of_dishes");
		stat.executeUpdate("create table if not exists hot_pot_hit.variety_of_dishes("
				+ "id int not null auto_increment, "
				+ "name varchar(100) not null, "
				+ "pic_url  varchar(200) not null,"
				+ "original_price decimal(5,2),"
				+ "present_price decimal(5,2) not null,"
				+ "class_id int not null,"
				+ "favouravle boolean default false,"
				+ "sold_num int default 0,"
				+ "scanned_num int default 0,"
				+ "constraint fk_class_id foreign key(class_id) references class(id),"
				+ "primary key ( id )"
				+ ")ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC");
		// "primary key ( id )"+")ENGINE=MEMORY AUTO_INCREMENT=1 DEFAULT CHARSET=utf8 CHECKSUM=1 DELAY_KEY_WRITE=1 ROW_FORMAT=DYNAMIC");

	}

	public void createData(Connection conn) throws SQLException {
		Statement stat = conn.createStatement();

		stat.executeUpdate("insert into seller(name,address,pic_url,phone,restaurant_hours) values('´¨Î¶»ð¹ø','ÉîÛÚÊÐÄÏÉ½Çø¿Æ¼¼Ô°','/image/variety_of_dishes/timg.jpg','15029345605','ÎçÊÐ:09:00-15:00;Ò¹ÊÐ:15:00-24:00')");

		stat.executeUpdate("insert into class(seller_id,chinese_name,pic_url,banner_show) values(1,'¹øµ×','/image/variety_of_dishes/timg.jpg',false)");
		stat.executeUpdate("insert into class(seller_id,chinese_name,pic_url,banner_show) values(1,'µ÷ÁÏ','/image/variety_of_dishes/timg.jpg',false)");
		stat.executeUpdate("insert into class(seller_id,chinese_name,pic_url,banner_show) values(1,'ÌØÉ«','/image/variety_of_dishes/timg.jpg',false)");
		stat.executeUpdate("insert into class(seller_id,chinese_name,pic_url,banner_show) values(1,'»ç²Ë','/image/variety_of_dishes/timg.jpg',false)");
		stat.executeUpdate("insert into class(seller_id,chinese_name,pic_url,banner_show) values(1,'ËØ²Ë','/image/variety_of_dishes/timg.jpg',false)");
		stat.executeUpdate("insert into class(seller_id,chinese_name,pic_url,banner_show) values(1,'Ð¡³Ô','/image/variety_of_dishes/timg.jpg',false)");
		stat.executeUpdate("insert into class(seller_id,chinese_name,pic_url,banner_show) values(1,'¾ÆË®','/image/variety_of_dishes/timg.jpg',false)");
		stat.executeUpdate("insert into class(seller_id,chinese_name,pic_url,banner_show) values(1,'ÒûÁÏ','/image/variety_of_dishes/timg.jpg',false)");
		stat.executeUpdate("insert into class(seller_id,chinese_name,pic_url,banner_show) values(1,'ÆäËû','/image/variety_of_dishes/timg.jpg',false)");

		stat.executeUpdate("insert into variety_of_dishes(name,pic_url,present_price,class_id,favouravle) values('ºìÌÀ¹øµ×', '/image/variety_of_dishes/timg.jpg',10,1,false)");
		stat.executeUpdate("insert into variety_of_dishes(name,pic_url,present_price,class_id,favouravle) values('Ô§Ñì¹øµ×', '/image/variety_of_dishes/timg.jpg',10,1,false)");
		// stat.executeUpdate("insert into variety_of_dishes(name,pic_url,present_price,class_id,seller_id,favouravle) values('ºìÌÀ¹øµ×', '/image/timg.jpg',10,1,2,false)");
		stat.executeUpdate("insert into variety_of_dishes(name,pic_url,present_price,class_id,favouravle) values('ÓÍµú', '/image/variety_of_dishes/timg.jpg',10,2,false)");
		stat.executeUpdate("insert into variety_of_dishes(name,pic_url,present_price,class_id,favouravle) values('¸ÉÓÍµú', '/image/variety_of_dishes/timg.jpg',15,2,false)");
		stat.executeUpdate("insert into variety_of_dishes(name,pic_url,present_price,class_id,favouravle) values('Ö¥ÂéÏãÓÍ', '/image/variety_of_dishes/timg.jpg',15,2,false)");
		stat.executeUpdate("insert into variety_of_dishes(name,pic_url,present_price,class_id,favouravle) values('ºì»¨½·', '/image/variety_of_dishes/timg.jpg',20,2,false)");
		stat.executeUpdate("insert into variety_of_dishes(name,pic_url,present_price,class_id,favouravle) values('ÏÊÍÁÑ¼³¦¸¨ÁÏ', '/image/variety_of_dishes/timg.jpg',25,2,false)");
		//
	}

	public static void main(String[] args) {
		DatabaseInit di = new DatabaseInit();
		try {
			di.constructDatabaseAndInitData();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
