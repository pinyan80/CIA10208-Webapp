package com.meals.model;

import java.util.*;
import java.sql.*;

public class MealsJDBCDAO implements MealsDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/morningcode?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "880316";

	private static final String INSERT_STMT = 
		"INSERT INTO meal_picture (meal_pic, meal_pic_info, meals_id) VALUES (?, ?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT meal_pic_id, meal_pic, meal_pic_info, meals_id FROM meal_picture order by meal_pic_id";
	private static final String GET_ONE_STMT = 
		"SELECT meal_pic_id, meal_pic, meal_pic_info, meals_id FROM meal_picture where meal_pic_id = ?";
	private static final String DELETE = 
		"DELETE FROM meal_picture where meal_pic_id = ?";
	private static final String UPDATE = 
		"UPDATE meal_picture set meal_pic=? ,meal_pic_info=? ,meals_id=? where meal_pic_id=?";

	@Override
	public void insert(MealsVO mealsVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			
			pstmt.setBytes(1, mealsVO.getMealPic());
			pstmt.setString(2, mealsVO.getMealPicInfo());
			pstmt.setInt(3, mealsVO.getMealsId());
			

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void update(MealsVO mealsVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

//			pstmt.setInt(1, mealsVO.getMealPicId());
			pstmt.setBytes(1, mealsVO.getMealPic());
			pstmt.setString(2, mealsVO.getMealPicInfo());
			pstmt.setInt(3, mealsVO.getMealsId());
			pstmt.setInt(4, mealsVO.getMealPicId());

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public void delete(Integer mealPicId) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(DELETE);

			pstmt.setInt(1, mealPicId);

			pstmt.executeUpdate();

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}

	}

	@Override
	public MealsVO findByPrimaryKey(Integer mealPicId) {

		MealsVO mealsVO = null;
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ONE_STMT);

			pstmt.setInt(1, mealPicId);

			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVo 也稱為 Domain objects
				mealsVO = new MealsVO();
				mealsVO.setMealPicId(rs.getInt("meal_pic_id"));
				mealsVO.setMealPic(rs.getBytes("meal_pic"));
				mealsVO.setMealPicInfo(rs.getString("meal_pic_info"));
				mealsVO.setMealsId(rs.getInt("meals_id"));
				
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return mealsVO;
	}

	@Override
	public List<MealsVO> getAll() {
		List<MealsVO> list = new ArrayList<MealsVO>();
		MealsVO mealsVO = null;

		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(GET_ALL_STMT);
			rs = pstmt.executeQuery();

			while (rs.next()) {
				// empVO 也稱為 Domain objects
				mealsVO = new MealsVO();
				mealsVO.setMealPicId(rs.getInt("meal_pic_id"));
				mealsVO.setMealPic(rs.getBytes("meal_pic"));
				mealsVO.setMealPicInfo(rs.getString("meal_pic_info"));
				mealsVO.setMealsId(rs.getInt("meals_id"));
				list.add(mealsVO); // Store the row in the list
			}

			// Handle any driver errors
		} catch (ClassNotFoundException e) {
			throw new RuntimeException("Couldn't load database driver. "
					+ e.getMessage());
			// Handle any SQL errors
		} catch (SQLException se) {
			throw new RuntimeException("A database error occured. "
					+ se.getMessage());
			// Clean up JDBC resources
		} finally {
			if (rs != null) {
				try {
					rs.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (pstmt != null) {
				try {
					pstmt.close();
				} catch (SQLException se) {
					se.printStackTrace(System.err);
				}
			}
			if (con != null) {
				try {
					con.close();
				} catch (Exception e) {
					e.printStackTrace(System.err);
				}
			}
		}
		return list;
	}

	public static void main(String[] args) {

		MealsJDBCDAO dao = new MealsJDBCDAO();

		// 新增
		MealsVO mealsVO1 = new MealsVO();
		
		mealsVO1.setMealPicInfo("草莓吐司");
		mealsVO1.setMealsId(1);
		dao.insert(mealsVO1);

		// 修改
		MealsVO mealsVO2 = new MealsVO();
		
		mealsVO2.setMealPicId(1);
		mealsVO2.setMealPicInfo("三明治");
		mealsVO2.setMealsId(3);
		dao.update(mealsVO2);

		// 刪除
		dao.delete(1);

		// 查詢
		MealsVO mealsVO3 = dao.findByPrimaryKey(1);
		System.out.print(mealsVO3.getMealPicId() + ",");
		System.out.print(mealsVO3.getMealPic() + ",");
		System.out.print(mealsVO3.getMealPicInfo() + ",");
		System.out.print(mealsVO3.getMealsId() + ",");
		System.out.println("---------------------");

		// 查詢
		List<MealsVO> list = dao.getAll();
		for (MealsVO aMeals : list) {
			System.out.print(aMeals.getMealPicId() + ",");
			System.out.print(aMeals.getMealPic() + ",");
			System.out.print(aMeals.getMealPicInfo() + ",");
			System.out.print(aMeals.getMealsId() + ",");
			System.out.println();
		}
	}
}