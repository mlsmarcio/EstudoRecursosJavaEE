package servlet;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import jakarta.servlet.RequestDispatcher;
import dao.DaoArquivo;
import dao.DaoUsuario;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import user.Arquivo;
import user.Usuario;
import jakarta.servlet.ServletException;

@WebServlet("/pages/servletUploadFile")
public class ServletUploadFile extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	private DaoUsuario daoUsuario = new DaoUsuario();
	protected DaoArquivo daoArquivo = new DaoArquivo(); 
	
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
				request.setAttribute("listaImagens", daoArquivo.listar(usuario.getId()));
				dispatcher.forward(request, response);
				
			}else if (acao.equalsIgnoreCase("download")) {
				
				String idArquivo = request.getParameter("idImagem");
				
				
				
				if (idArquivo != null) {
					
					Arquivo arquivo = daoArquivo.getImagem(Long.parseLong(idArquivo));
					
					// DEFINE O CABEÇALHO DA RESPOSTA
					response.setHeader("Content-Disposition", "attachment;filename=imagem." + arquivo.getTipo());
					
					// ESCREVER DADOS DA RESPOSTA
					InputStream is = arquivo.gerarImagem();
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
		
		if (fileUpload != null) {
			HttpSession session = request.getSession();
			Usuario usuario = (Usuario) session.getAttribute("usuario");
			usuario.addArquivo(new Arquivo(0L,fileUpload));
			daoUsuario.gravarImagem(usuario);
			
			System.out.println("Arquivo:  " + fileUpload);
			response.getWriter().write("Processada com sucesso");
		}
	}
	
}
