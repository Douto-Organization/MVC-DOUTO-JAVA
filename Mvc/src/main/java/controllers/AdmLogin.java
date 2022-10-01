package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.AdmDao;
import model.Adm;


@WebServlet("/AdmLogin")
public class AdmLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public String emailLogado;
	public String senhaLogado;
       
    
    public AdmLogin() {
        super();
    }

	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String username = request.getParameter("email");
		String senha = request.getParameter("senha");
		
		Adm login = new Adm();
		login.setEmail(username);
		login.setSenha(senha);
		
		if(AdmDao.validarAdm(login) == true){
			System.out.println("--sucess login");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("lista.jsp");
			requestDispatcher.forward(request, response);
			emailLogado = username;
			senhaLogado = senha;
		} else {
			System.out.println("--erro: senha ou email incorreto");
			RequestDispatcher requestDispatcher = request.getRequestDispatcher("loginAdm.jsp");
			requestDispatcher.forward(request, response);
	}
}

}
