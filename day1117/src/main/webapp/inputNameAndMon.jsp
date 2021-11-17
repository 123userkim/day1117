<%@page import="com.sist.vo.InputNameAndMonVO"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.sist.dao.InputNameAndMonDAO"%>
<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<form action="inputNameAndMon.jsp" method="post">
		이름을 입력하세요 ==> <input type="text" name="name">
		월수를 입력하세요 ==> <input type="text" name="month">
		<input type="submit" value="확인">
		 
	</form>
	
	<%
		request.setCharacterEncoding("euc-kr");
		if(request.getParameter("name") != null && request.getParameter("month") != null){
			String name = request.getParameter("name");
			int month =Integer.parseInt(request.getParameter("month")) ;
			InputNameAndMonDAO dao = new InputNameAndMonDAO();
			ArrayList<InputNameAndMonVO>list= dao.listPerson(name, month);
			
			%>
			<table border="1">
				<tr>
					<td>사원번호</td>
					<td>사원이름</td>
					<td>입사날짜</td>
					<td>연봉</td>
					<td>주민</td>
					<td>아이디</td>
				</tr>
				<%
					for(InputNameAndMonVO i : list){
						%>
						<tr>
							<td><%= i.getEno() %></td>
							<td><%= i.getEname() %></td>
							<td><%= i.getHirdate() %></td>
							<td><%= i.getSal() %></td>
							<td><%= i.getJumin() %></td>
							<td><%= i.getId() %></td>
						</tr>
						<%
					}
				%>
				
			</table>
			<br>
			
			<%
			
		}
	%>

</body>
</html>