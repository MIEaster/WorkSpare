package com.nf.cjexam.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.nf.cjexam.dao.ProductDao;
import com.nf.cjexam.entity.ProductItemEntity;
import com.nf.cjexam.utils.JsonUtil;

@WebServlet("/product/insert")
public class ProductInsertServlet extends HttpServlet {

	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		ProductDao dao = new ProductDao();
		ProductItemEntity item = JsonUtil.fromJson(req.getInputStream(), ProductItemEntity.class);
		
		System.out.println(item);
		boolean result = dao.add(item);
		System.out.println(result);
		
		resp.setContentType("application/json;charset=UTF-8");
		resp.getWriter().print(result);
		
	}

}
