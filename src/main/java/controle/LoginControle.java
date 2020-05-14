package controle;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDaoImpl;
import entidade.Usuario;

@WebServlet(name = "Usuarios", urlPatterns = { "/LoginControle" })
public class LoginControle extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String INSERT_OR_EDIT = "/user.jsp";
	private static String LIST_USER = "/pesquisaUsuario.jsp";
	private static String LOGIN = "/index.jsp";
	private UsuarioDaoImpl usuarioDao;
	private List<Usuario> usuarios;
	private Usuario usuario;

	public LoginControle() {
		super();
		usuarioDao = new UsuarioDaoImpl();
		usuario = new Usuario();
		usuarios = usuarioDao.listarTodos();

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String usuarioTXT = request.getParameter("usuario");
		String senhaTXT = request.getParameter("senha");
		String forward = LIST_USER;

		if (usuarioTXT.equals("admin") && senhaTXT.equals("admin")) {
			RequestDispatcher view = request.getRequestDispatcher(forward);
			request.setAttribute("usuarios", usuarioDao.listarTodos());
			view.forward(request, response);
		} else {
			usuario = this.usuarioDao.pesquisar(usuarioTXT);
			if (usuario.getEmail() != null) {
				if (usuario.getSenha().equals(senhaTXT)) {
					// this.usuarioLogado = usuarioDao.pesquisar(this.usuarioTXT);

					// this.usuarioLogado = this.usuario;
					RequestDispatcher view = request.getRequestDispatcher(forward);
					request.setAttribute("usuarios", usuarioDao.listarTodos());
					view.forward(request, response);
				} else {
					String mensagem = " Senha inválida";
					forward = LOGIN;
					System.out.println(mensagem);
					RequestDispatcher view = request.getRequestDispatcher(forward);
					request.setAttribute("mensagem", mensagem);
					view.forward(request, response);
				}
			} else {

				String mensagem = " Usuario não cadastrado";
				System.out.println(mensagem);
				forward = LOGIN;
				RequestDispatcher view = request.getRequestDispatcher(forward);
				request.setAttribute("mensagem", mensagem);
				view.forward(request, response);
			}

		}
	}

}
