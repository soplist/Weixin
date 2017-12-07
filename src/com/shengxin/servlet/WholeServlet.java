package com.shengxin.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import net.sf.json.JSONArray;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.shengxin.dao.IClassDao;
import com.shengxin.dao.IVarietyOfDishesDao;
import com.shengxin.dao.impl.ClassDao;
import com.shengxin.dao.impl.VarietyOfDishesDao;

public class WholeServlet extends HttpServlet {

	private IVarietyOfDishesDao varietyOfDishesDao;
	private IClassDao classDao;

	private ApplicationContext applicationContext;

	public void init(ServletConfig config) throws ServletException {
		super.init(config);
		applicationContext = WebApplicationContextUtils
				.getRequiredWebApplicationContext(this.getServletContext());
		varietyOfDishesDao = (VarietyOfDishesDao) applicationContext
				.getBean("varietyOfDishesDao");
		classDao = (ClassDao) applicationContext.getBean("classDao");
	}

	/**
	 * The doGet method of the servlet. <br>
	 * 
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request
	 *            the request send by the client to the server
	 * @param response
	 *            the response send by the server to the client
	 * @throws ServletException
	 *             if an error occurred
	 * @throws IOException
	 *             if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		if (this.varietyOfDishesDao != null)
			System.out.println("varietyOfDishesDao is not null");

		response.setHeader("Content-type", "text/html;charset=UTF-8");
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		PrintWriter out = response.getWriter();

		String method = request.getParameter("method");
		if ("getVarietyOfDishesListBySellerId".equals(method)) {
			String sellerIdString = request.getParameter("sellerId");
			if (!("".equals(sellerIdString))) {
				int sellerId = Integer.parseInt(sellerIdString);
				out.println(getVarietyOfDishesListBySellerId(sellerId));
			}
		} else if ("getVarietyOfDishesListByClassIdAndSellerId".equals(method)) {
			String classIdString = request.getParameter("classId");
			String sellerIdString = request.getParameter("sellerId");
			if (!("".equals(classIdString)) && !("".equals(sellerIdString))) {
				int classId = Integer.parseInt(classIdString);
				int sellerId = Integer.parseInt(sellerIdString);
				out.println(getVarietyOfDishesListByClassIdAndSellerId(classId,
						sellerId));
			}
		} else if ("getClassBySellerId".equals(method)) {
			String sellerIdString = request.getParameter("sellerId");
			if (!("".equals(sellerIdString))) {
				int sellerId = Integer.parseInt(sellerIdString);
				out.println(getClassBySellerId(sellerId));
			}
		}

		/*
		 * out.println(
		 * "<!DOCTYPE HTML PUBLIC \"-//W3C//DTD HTML 4.01 Transitional//EN\">");
		 * out.println("<HTML>");
		 * out.println("  <HEAD><TITLE>A Servlet</TITLE></HEAD>");
		 * out.println("  <BODY>");
		 */

		// out.println("<img src='" + request.getContextPath() +
		// varietyOfDishesDao.getVarietyOfDishesListBySellerId().get(0).getPicUrl()
		// + "' width='100px' height='100px' />");

		/*
		 * out.println("  </BODY>"); out.println("</HTML>");
		 */

		out.flush();
		out.close();
	}

	private String getVarietyOfDishesListBySellerId(int sellerId) {
		JSONArray json = JSONArray.fromObject(varietyOfDishesDao
				.getVarietyOfDishesListBySellerId(sellerId));
		return json.toString();
	}

	private String getVarietyOfDishesListByClassIdAndSellerId(int classId,
			int sellerId) {
		JSONArray json = JSONArray.fromObject(varietyOfDishesDao
				.getVarietyOfDishesListByClassIdAndSellerId(classId, sellerId));
		return json.toString();
	}

	private String getClassBySellerId(int sellerId) {
		JSONArray json = JSONArray.fromObject(classDao
				.getClassBySellerId(sellerId));
		return json.toString();
	}
}
