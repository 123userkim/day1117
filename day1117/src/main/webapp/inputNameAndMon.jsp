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
		�̸��� �Է��ϼ��� ==> <input type="text" name="name">
		������ �Է��ϼ��� ==> <input type="text" name="month">
		<input type="submit" value="Ȯ��">
		 
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
					<td>�����ȣ</td>
					<td>����̸�</td>
					<td>�Ի糯¥</td>
					<td>����</td>
					<td>�ֹ�</td>
					<td>���̵�</td>
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