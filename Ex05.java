package days03;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Iterator;

import com.util.DBconn;

/**
 * @author 채영
 * @date
 * @subject 프로젝트 때 참고할 사항
 * @content
 */
public class Ex05 {

	public static void main(String[] args) {
		 
		
		String sql = " SELECT grade , losal, hisal , COUNT(*) cnt "
					+ " FROM salgrade s JOIN emp e ON sal BETWEEN losal AND hisal "
					+ " GROUP BY grade , losal, hisal  "
					+ " ORDER BY grade ASC ";
		
		// System.out.println(sql);
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<SalgradeDTO> list = null;
		SalgradeDTO dto = null;
		 
		conn = DBconn.getConnection();
		
		try {
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			 
			if(rs.next()) {
				list = new ArrayList< >();
				
				do {
					
					int grade = rs.getInt("grade");
					int hisal = rs.getInt("hisal");
					int losal = rs.getInt("losal");
					int cnt = rs.getInt("cnt"); 
					
					dto = new SalgradeDTO(grade, losal, hisal, cnt);
					 				 
					list.add(dto);
					
				}while(rs.next());
				
			}//if
			 
			
			
		} catch (SQLException e) { 
			e.printStackTrace();
		}finally{
			try {
				pstmt.close();
				rs.close();
			} catch (SQLException e) { 
				e.printStackTrace();
			}
			
		}
		 
		DBconn.close();
		
		printsalgrade(list);
		 
		System.out.println("end");
	}//main

	private static void printsalgrade(ArrayList<SalgradeDTO> list) { 
		
		Iterator<SalgradeDTO> ir = list.iterator();
		
		while (ir.hasNext()) {
			SalgradeDTO dto =   ir.next();
			System.out.println(dto);
			
		}
	}

}//class


/*
        [실행결과]
      1등급   (  700~1200 ) - 2명
        20   RESEARCH   7369   SMITH   800
        30   SALES         7900   JAMES   950
      2등급   (   1201~1400 ) - 2명
         30   SALES   7654   MARTIN   2650
         30   SALES   7521   WARD      1750   
      3등급   (   1401~2000 ) - 2명
         30   SALES   7499   ALLEN      1900
         30   SALES   7844   TURNER   1500
      4등급   (   2001~3000 ) - 4명
         10   ACCOUNTING   7782   CLARK   2450
         20   RESEARCH   7902   FORD   3000
         20   RESEARCH   7566   JONES   2975
         30   SALES   7698   BLAKE   2850
      5등급   (   3001~9999 ) - 1명   
         10   ACCOUNTING   7839   KING   5000
       */
