package servlet;

import java.io.IOException;

import dao.DaoUsuario;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import jakarta.servlet.http.HttpSession;
import user.Usuario;

@WebServlet("/pages/ServletAutenticacao")
public class ServletAutenticacao extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ServletAutenticacao() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		if (Boolean.parseBoolean(request.getParameter("deslogar"))) {
			HttpSession session = request.getSession(); 
			session.invalidate();
			// REDIRECIONA PARA PÁGINA INDEX
			response.sendRedirect("../index.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String login = request.getParameter("usuario");
		String senha = request.getParameter("senha");
		String url = request.getParameter("url");
		
		if (login.equalsIgnoreCase("admin") && senha.equals("123")) {
			
			Usuario usuario = new Usuario();
			usuario.setId(2L);
			usuario.setLogin(login);
			usuario.setSenha(senha);
			
			HttpSession session = request.getSession(); 
			session.setAttribute("usuario", usuario);
			request.getRequestDispatcher(url).forward(request, response);
			
		}else {
			request.setAttribute("msg", "Login ou senha inválidos!");
			request.getRequestDispatcher("/autenticar.jsp?url="+url).forward(request, response);
			
		}
	}

}
