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

	<h1>Cadastrar Usuário</h1>
	<form method="POST" action='UsuarioControle?action=novo'
		name="frmAddUser">
		Email : <input type="text" name="email"
			value="<c:out value="${usuario.email}" />" /> <br /> Nome : <input
			type="text" name="nome" value="<c:out value="${usuario.nome}" />" />
		<br /> <label for="senha" class="col-sm-3 control-label">Senha:</label>

		<input type="password" name="senha" id="senha" class="form-control" />
		<label for="senha2" class="col-sm-3 control-label">Confirmar
			senha:</label> <input type="password" name="senha2" id="senha2"
			class="form-control" /> <br /> <input type="submit" value="Submit" />
		<br /> <br /> <select id="dropdown">
			<option value="CELULAR">CELULAR</option>
			<option value="FIXO" selected>FIXO</option>

		</select>
	</form>
</body>
</html>