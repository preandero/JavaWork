<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>   <%-- JDBC 관련 클래스 import --%>
<% 	// parameter 받아오기
	int uid = Integer.parseInt(request.getParameter("uid"));
	//※ 이단계에서 parameter 검증 필요
%>
<%!
	// JDBC 관련 기본 객체 변수들 선언
	Connection conn = null;
	Statement stmt = null;
	PreparedStatement pstmt = null;
	ResultSet rs = null;
	
	// Connection 에 필요한 값 세팅
	final String DRIVER = "oracle.jdbc.driver.OracleDriver";	
	final String URL = "jdbc:oracle:thin:@localhost:1521:xe";
	final String USERID = "scott0316";
	final String USERPW = "tiger0316";
%>    
<%!
	// 쿼리문 준비
	String sql_delete = "DELETE FROM test_write WHERE wr_uid = ?";
%>
 
<%
	int cnt = 0;
	try{
		Class.forName(DRIVER);
		out.println("드라이버 로딩 성공" + "<br>");   // 테스트 출력
		conn = DriverManager.getConnection(URL, USERID, USERPW);
		out.println("conn 성공" + "<br>");       // 테스트 출력
		
		// 쿼리 실행
		pstmt = conn.prepareStatement(sql_delete);
		
		pstmt.setInt(1, uid);
		
		cnt = pstmt.executeUpdate();
				
	} catch(Exception e){
		e.printStackTrace();
		// ※ 여기서 예외처리를 하든지, 예외 페이지를 설정해주어야 한다.
	} finally {
		try{
			if(pstmt != null) pstmt.close();
			if(conn != null) conn.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

%>

<% if(cnt == 0){ %>
<script>
	alert("삭제 실패");
	hisotry.back();
</script>
<% } else { %>
<script>
	alert("삭제 성공");
	location.href = "list.jsp"; <%-- 삭제후에는 list 로 가자 --%>
</script>
<% } %>  


