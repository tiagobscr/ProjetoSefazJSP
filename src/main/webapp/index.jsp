<html>
<body>
	<h1>Autentica��o de Usu�rio</h1>
	<form method="post" action="LoginControle">
		<table>
			<tr>
				<th>Login:</th>
				<td><input type="text" name="usuario"  /></td>
			</tr>
			<tr>
				<th>Senha:</th>
				<td><input type="password" name="senha" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" name="bOK" value="Entrar" />
				</td>
			</tr>
			
		</table>
		<p>
		<a href="novoUsuario.jsp">Novo Usu�rio</a>
	</p>
		<p >${mensagem}</p>	
	</form>
</body>
</html>
