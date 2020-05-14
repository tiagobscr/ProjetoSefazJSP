<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Editar Usuário</title>
</head>
<body>

	<h1>Editar Usuário</h1>
	<form method="POST" action='UsuarioControle?action=editUser' name="editUser">
		Email : <input type="text" readonly="readonly" name="email"
			value="<c:out value="${usuario.email}" />" /> <br /> Nome : <input
			type="text" name="nome" value="<c:out value="${usuario.nome}" />" />
		<br /> <input type="submit" value="Submit" />
	</form>
</body>
</html>