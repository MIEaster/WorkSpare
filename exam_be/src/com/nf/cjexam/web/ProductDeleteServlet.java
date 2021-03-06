package com.nf.cjexam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nf.cjexam.dao.ProductDao;
import com.nf.cjexam.utils.JsonUtil;

@WebServlet("/product/delete")
public class ProductDeleteServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductDao dao = new ProductDao();
		int id = Integer.parseInt(req.getParameter("id"));
		System.out.println("id:" + id);
		boolean result = dao.deleteItemById(id);
		
		resp.setContentType("application/json;charset=UTF-8");
		resp.getWriter().print(result);
		
	}

}
