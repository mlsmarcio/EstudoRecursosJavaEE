package filter;

import java.io.IOException;

import jakarta.servlet.Filter;
import jakarta.servlet.FilterChain;
import jakarta.servlet.FilterConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import user.Usuario;

@WebFilter(urlPatterns={"/pages/*"})
public class FilterAutenticacao implements Filter{
	
	@Override
	public void destroy() {
		System.out.println("Destruindo a Aplicação!");
	}

	@Override
	public void doFilter(ServletRequest arg0, ServletResponse arg1, FilterChain arg2)
			throws IOException, ServletException {
		
		HttpServletRequest request = (HttpServletRequest) arg0;
		
		String urlParaAutenticacao = request.getServletPath();
		
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		
		if (usuario == null && !urlParaAutenticacao.equalsIgnoreCase("/pages/ServletAutenticacao")) {
			session.setMaxInactiveInterval(1);
			arg0.getRequestDispatcher("/autenticar.jsp?url="+urlParaAutenticacao).forward(arg0, arg1);
			return;
		}
		
		arg2.doFilter(arg0, arg1);
		
		
	}

	@Override
	public void init(FilterConfig arg0) throws ServletException {
		System.out.println("Inicializando a Aplicação");
	}
}
