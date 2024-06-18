package com.mealspic.model;

import java.io.*;
import java.sql.*;

import javax.naming.Context;
import javax.naming.NamingException;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import javax.sql.DataSource;

@WebServlet("/DBGifReader4")
public class DBGifReader4 extends HttpServlet {

	Connection con;

	public void doGet(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		
		String driver = "com.mysql.cj.jdbc.Driver";
		String url = "jdbc:mysql://localhost:3306/morningcode?serverTimezone=Asia/Taipei";
		String userid = "root";
		String passwd = "880316";
		
		

		res.setContentType("image/gif");
		ServletOutputStream out = res.getOutputStream();

		try {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			String id = req.getParameter("id").trim();
			pstmt = con.prepareStatement("SELECT meal_pic FROM meal_picture WHERE meal_pic_id=" + id);
			rs = pstmt.executeQuery();
			
//			Statement stmt = con.createStatement();
//			String id = req.getParameter("id").trim();
//			ResultSet rs = stmt.executeQuery(
//					"SELECT meal_pic FROM meal_picture WHERE meal_pic_id=" + id);

			if (rs.next()) {
				BufferedInputStream in = new BufferedInputStream(rs.getBinaryStream("meal_pic"));
				byte[] buf = new byte[4 * 1024]; // 4K buffer
				int len;
				while ((len = in.read(buf)) != -1) {
					out.write(buf, 0, len);
				}
				in.close();
			} else {
//				res.sendError(HttpServletResponse.SC_NOT_FOUND);
				InputStream in = getServletContext().getResourceAsStream("/NoData/none2.jpg");
				byte[] b = new byte[in.available()];
				in.read(b);
				out.write(b);
				in.close();
			}
			rs.close();
//			stmt.close();
			pstmt.close();
		} catch (Exception e) {
//			System.out.println(e);
			InputStream in = getServletContext().getResourceAsStream("/NoData/null.jpg");
//			byte[] b = new byte[in.available()];
//			in.read(b);
			byte[] b = in.readAllBytes(); // Java 9 ���s��k
			out.write(b);
			in.close();
		}
	}

	public void init() throws ServletException {
		try {
			Context ctx = new javax.naming.InitialContext();
			DataSource ds = (DataSource) ctx.lookup("java:comp/env/jdbc/CIA10208");
			con = ds.getConnection();
		} catch (NamingException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	public void destroy() {
		try {
			if (con != null)
				con.close();
		} catch (SQLException e) {
			System.out.println(e);
		}
	}

}