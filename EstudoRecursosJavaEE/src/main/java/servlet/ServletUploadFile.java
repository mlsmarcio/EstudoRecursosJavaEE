package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import jakarta.servlet.RequestDispatcher;
import dao.DaoImagem;
import dao.DaoUsuario;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import user.Imagem;
import user.Usuario;
import jakarta.servlet.ServletException;

@WebServlet("/pages/servletUploadFile")
public class ServletUploadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private DaoUsuario daoUsuario = new DaoUsuario();
	protected DaoImagem daoImagem = new DaoImagem(); 
	
    public ServletUploadFile() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("upload.jsp");
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		
		request.setAttribute("user", usuario);
		
		try {
			String acao = request.getParameter("acao");
			
			if (acao.equalsIgnoreCase("carregar")) {
				request.setAttribute("listaImagens", daoImagem.listar(usuario.getId()));
				dispatcher.forward(request, response);
				
			}else if (acao.equalsIgnoreCase("download")) {
				
				String idImagem = request.getParameter("idImagem");
				
				
				
				if (idImagem != null) {
					
					Imagem imagem = daoImagem.getImagem(Long.parseLong(idImagem));
					
					// DEFINE O CABEÇALHO DA RESPOSTA
					response.setHeader("Content-Disposition", "attachment;filename=imagem.png");
					
					// ESCREVER DADOS DA RESPOSTA
					InputStream is = imagem.gerarImagem();
					int read = 0;
					byte[] bytes = new byte[1024];
					OutputStream os = response.getOutputStream();
					while ( (read = is.read(bytes)) != -1 ) {
						os.write(bytes, 0,read);
					}
					os.flush();
					os.close();
				}

			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// imagem em base 64
		String fileUpload = request.getParameter("fileUpload");
		
		HttpSession session = request.getSession();
		Usuario usuario = (Usuario) session.getAttribute("usuario");
		usuario.addImagem(new Imagem(0L,fileUpload));
		daoUsuario.gravarImagem(usuario);
		
		System.out.println("Imagem:  " + fileUpload);
		response.getWriter().write("Processada com sucesso");
	}
	
}
