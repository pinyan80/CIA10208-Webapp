package com.mealspic.model;

import java.util.*;
import java.sql.*;

public class MealsPicJDBCDAO implements MealsPicDAO_interface {
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
	public void insert(MealsPicVO mealspicVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			
			pstmt.setBytes(1, mealspicVO.getMealPic());
			pstmt.setString(2, mealspicVO.getMealPicInfo());
			pstmt.setInt(3, mealspicVO.getMealsId());
			

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
	public void update(MealsPicVO mealspicVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(UPDATE);

//			pstmt.setInt(1, mealspicVO.getMealPicId());
			pstmt.setBytes(1, mealspicVO.getMealPic());
			pstmt.setString(2, mealspicVO.getMealPicInfo());
			pstmt.setInt(3, mealspicVO.getMealsId());
			pstmt.setInt(4, mealspicVO.getMealPicId());

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
	public MealsPicVO findByPrimaryKey(Integer mealPicId) {

		MealsPicVO mealspicVO = null;
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
				mealspicVO = new MealsPicVO();
				mealspicVO.setMealPicId(rs.getInt("meal_pic_id"));
				mealspicVO.setMealPic(rs.getBytes("meal_pic"));
				mealspicVO.setMealPicInfo(rs.getString("meal_pic_info"));
				mealspicVO.setMealsId(rs.getInt("meals_id"));
				
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
		return mealspicVO;
	}

	@Override
	public List<MealsPicVO> getAll() {
		List<MealsPicVO> list = new ArrayList<MealsPicVO>();
		MealsPicVO mealspicVO = null;

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
				mealspicVO = new MealsPicVO();
				mealspicVO.setMealPicId(rs.getInt("meal_pic_id"));
				mealspicVO.setMealPic(rs.getBytes("meal_pic"));
				mealspicVO.setMealPicInfo(rs.getString("meal_pic_info"));
				mealspicVO.setMealsId(rs.getInt("meals_id"));
				list.add(mealspicVO); // Store the row in the list
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

		MealsPicJDBCDAO dao = new MealsPicJDBCDAO();

		// 新增
		MealsPicVO mealspicVO1 = new MealsPicVO();
		
		mealspicVO1.setMealPicInfo("草莓吐司");
		mealspicVO1.setMealsId(1);
		dao.insert(mealspicVO1);

		// 修改
		MealsPicVO mealspicVO2 = new MealsPicVO();
		
		mealspicVO2.setMealPicId(1);
		mealspicVO2.setMealPicInfo("三明治");
		mealspicVO2.setMealsId(3);
		dao.update(mealspicVO2);

		// 刪除
		dao.delete(1);

		// 查詢
		MealsPicVO mealspicVO3 = dao.findByPrimaryKey(1);
		System.out.print(mealspicVO3.getMealPicId() + ",");
		System.out.print(mealspicVO3.getMealPic() + ",");
		System.out.print(mealspicVO3.getMealPicInfo() + ",");
		System.out.print(mealspicVO3.getMealsId() + ",");
		System.out.println("---------------------");

		// 查詢
		List<MealsPicVO> list = dao.getAll();
		for (MealsPicVO aMeals : list) {
			System.out.print(aMeals.getMealPicId() + ",");
			System.out.print(aMeals.getMealPic() + ",");
			System.out.print(aMeals.getMealPicInfo() + ",");
			System.out.print(aMeals.getMealsId() + ",");
			System.out.println();
		}
	}
}