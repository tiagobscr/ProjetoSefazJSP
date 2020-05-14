<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Pesquisa Usuários</title>
</head>
<body>
	<table border=1>
		<thead>
			<tr>

				<th>nome</th>


				<th>Email</th>
				<th colspan=2>Action</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach items="${usuarios}" var="usuario">
				<tr>

					<td><c:out value="${usuario.nome}" /></td>


					<td><c:out value="${usuario.email}" /></td>
					<td><a
						href="UsuarioControle?action=edit&email=<c:out value="${usuario.email}"/>">Editar</a></td>
					<td><a
						href="UsuarioControle?action=delete&email=<c:out value="${usuario.email}"/>">Excluir</a></td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	<p>
		<a href="index.jsp">Logout</a>
	</p>
	</body>
</html>