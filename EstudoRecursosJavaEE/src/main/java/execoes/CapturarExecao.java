package execoes;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/pages/capturarExecao")
public class CapturarExecao extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public CapturarExecao() {

    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Integer.parseInt(request.getParameter("valorParam"));
			System.out.println(request.getParameter("valorParam"));		
			response.setStatus(200);
			response.getWriter().write("Processada com sucesso");
			
		}catch (Exception e) {
			response.setStatus(500);
			response.getWriter().write("Erro ao processar: " + e.getMessage());
		}
	
	}

}
