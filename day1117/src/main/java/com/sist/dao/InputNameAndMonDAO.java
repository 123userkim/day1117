package com.sist.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import com.sist.vo.InputNameAndMonVO;


/*
select e.eno, e.ename, e.hirdate, (e.salary+e.comm)*12 ¿¬ºÀ,
	rpad(substr(e.jumin,1,8),14,'*') ÁÖ¹Î,substr(e.email,1, instr(e.email,'@')-1)¾ÆÀÌµð
	from  emp e, emp m
	where m.ename = '±è½Ã¾Æ' and
	e.mgr = m.eno and
	months_between(sysdate, m.hirdate ) < months_between(sysdate, e.hirdate);
*/
public class InputNameAndMonDAO {

	private String driver = "oracle.jdbc.driver.OracleDriver";
	private String url = "jdbc:oracle:thin:@localhost:1521:XE";
	private String user = "c##madang";
	private String password = "madang";
	
	public ArrayList<InputNameAndMonVO> listPerson(String name, int month){
		ArrayList<InputNameAndMonVO> list = new ArrayList<InputNameAndMonVO>();
		String sql =  "select e.eno, e.ename, e.hirdate, (e.salary+e.comm)*12¿¬ºÀ, rpad(substr(e.jumin,1,8),14,'*')ÁÖ¹Î,substr(e.email,1, instr(e.email,'@')-1)¾ÆÀÌµð from  emp e, emp m where m.ename = ? and e.mgr = m.eno and	? < months_between(sysdate, e.hirdate)";
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1, name);
			pstmt.setInt(2, month);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				list.add(new InputNameAndMonVO(rs.getInt(1), rs.getString(2), rs.getDate(3), rs.getInt(4), rs.getString(5), rs.getString(6)));
		} 
		}catch (Exception e) {
			System.out.println("¿¹¿Ü¹ß»ý:"+e.getMessage());
		}finally {
			try {
				if(rs != null) {
					rs.close();
				}
				if(pstmt != null) {
					pstmt.close();
				}
				if(conn != null) {
					conn.close();
				}
			}catch (Exception e) {
				// TODO: handle exception
			}
		}
		
		return list;
	}
}
