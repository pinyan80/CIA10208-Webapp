package com.meals.model;

import java.util.*;
import java.sql.*;

public class MealsJDBCDAO implements MealsDAO_interface {
	String driver = "com.mysql.cj.jdbc.Driver";
	String url = "jdbc:mysql://localhost:3306/db01?serverTimezone=Asia/Taipei";
	String userid = "root";
	String passwd = "880316";

	private static final String INSERT_STMT = 
		"INSERT INTO emp2 (ename,job,hiredate,sal,comm,deptno) VALUES (?, ?, ?, ?, ?, ?)";
	private static final String GET_ALL_STMT = 
		"SELECT empno,ename,job,hiredate,sal,comm,deptno FROM emp2 order by empno";
	private static final String GET_ONE_STMT = 
		"SELECT empno,ename,job,hiredate,sal,comm,deptno FROM emp2 where empno = ?";
	private static final String DELETE = 
		"DELETE FROM emp2 where empno = ?";
	private static final String UPDATE = 
		"UPDATE emp2 set ename=?, job=?, hiredate=?, sal=?, comm=?, deptno=? where empno = ?";

	@Override
	public void insert(MealsVO mealsVO) {

		Connection con = null;
		PreparedStatement pstmt = null;

		try {

			Class.forName(driver);
			con = DriverManager.getConnection(url, userid, passwd);
			pstmt = con.prepareStatement(INSERT_STMT);

			pstmt.setInt(1, mealsVO.getMealPicId());
			pstmt.setByte(2, mealsVO.getMealPic());
			pstmt.setString(3, mealsVO.getMealPicInfo());
			pstmt.setInt(4, mealsVO.getMealsId());
			

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

			pstmt.setInt(1, mealsVO.getMealPicId());
			pstmt.setByte(2, mealsVO.getMealPic());
			pstmt.setString(3, mealsVO.getMealPicInfo());
			pstmt.setInt(4, mealsVO.getMealsId());
			

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
				mealsVO.setMealPicId(rs.getInt("mealPicId"));
				mealsVO.setMealPic(rs.getByte("mealPic"));
				mealsVO.setMealPicInfo(rs.getString("mealPicInfo"));
				mealsVO.setMealsId(rs.getInt("mealsId"));
				
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
				mealsVO.setMealPicId(rs.getInt("mealPicId"));
				mealsVO.setMealPic(rs.getByte("mealPic"));
				mealsVO.setMealPicInfo(rs.getString("mealPicInfo"));
				mealsVO.setMealsId(rs.getInt("mealsId"));
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
		MealsVO mealsVO3 = dao.findByPrimaryKey(7001);
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