package controle;

import java.io.IOException;
import java.util.ArrayList;


import java.util.List;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.UsuarioDaoImpl;
import entidade.Telefone;
import entidade.Usuario;

@WebServlet("/UsuarioControle")
public class UsuarioControle extends HttpServlet {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private static String INSERT_OR_EDIT = "/editarUsuario.jsp";
	private static String LIST_USER = "/pesquisaUsuario.jsp";
	private static String LOGIN = "/index.jsp";
	private UsuarioDaoImpl usuarioDao;
	private List<Usuario> usuarios;
	private Usuario usuario;
	private List<Telefone> telefones;
	

	public UsuarioControle() {
		super();
		usuarioDao = new UsuarioDaoImpl();
		usuario = new Usuario();
		telefones = new ArrayList<Telefone>();
		usuarios = new ArrayList<Usuario>();
		usuario.setTelefones(telefones);
		

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String forward = "";
		String action = request.getParameter("action");
        System.out.println(action);
		if (action.equalsIgnoreCase("delete")) {
			String email = request.getParameter("email");
			usuario = usuarioDao.pesquisar(email);
			System.out.println(email);
			usuarioDao.remover(usuario);
			forward = LIST_USER;
			request.setAttribute("usuarios", usuarioDao.listarTodos());
	        
		} else if (action.equalsIgnoreCase("edit")) {
			forward = INSERT_OR_EDIT;
			String email = request.getParameter("email");
			usuario = usuarioDao.pesquisar(email);
			request.setAttribute("usuario", usuario);
		} else if (action.equalsIgnoreCase("listUser")) {
			forward = LIST_USER;
			request.setAttribute("usuarios", usuarioDao.listarTodos());
		} else {
			if (action.equalsIgnoreCase("logout"))forward = LOGIN;
			
		}
        System.out.println(forward);
		RequestDispatcher view = request.getRequestDispatcher(forward);
		view.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		usuario=usuarioDao.pesquisar(request.getParameter("email"));
		String action = request.getParameter("action");
		if(usuario.getEmail()==null) {
			
		usuario = new Usuario();
		usuario.setNome(request.getParameter("nome"));
		usuario.setSenha(request.getParameter("senha"));
        System.out.println(usuario);
		usuario.setEmail(request.getParameter("email"));
		usuario.setTelefones(telefones);
		System.out.println(request.getParameter("email"));
		System.out.println(usuario.getEmail());
		usuarioDao.inserir(usuario);
		String mensagem = " Usuario "+usuario.getNome()+" cadastrado com sucesso";
		System.out.println(mensagem);
		
		RequestDispatcher view = request.getRequestDispatcher(LOGIN);
		request.setAttribute("mensagem", mensagem);
		view.forward(request, response);
		}else { 
			if(action.equalsIgnoreCase("editUser")) {
				usuario.setNome(request.getParameter("nome"));
				usuarioDao.alterar(usuario);
				usuarios=usuarioDao.listarTodos();
				RequestDispatcher view = request.getRequestDispatcher(LIST_USER);
				request.setAttribute("usuarios", usuarios);
				view.forward(request, response);
			}
			System.out.println(request.getRequestURI());
			System.out.println(action);
			System.out.println("usuario já cadastrado");
			String mensagem = " Usuario Já cadastrado";
			System.out.println(mensagem);
			
			RequestDispatcher view = request.getRequestDispatcher(LOGIN);
			request.setAttribute("mensagem", mensagem);
			view.forward(request, response);
		}
		
	}

}
