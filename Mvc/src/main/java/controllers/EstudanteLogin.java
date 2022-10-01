package controllers;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.EstudanteDao;
import model.Estudante;


@WebServlet("/EstudanteLogin")
public class EstudanteLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
    public EstudanteLogin() {
        super();
        }
      
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		
			String username = request.getParameter("email");
			String senha = request.getParameter("senha");
			
			Estudante login = new Estudante();
			login.setEmail(username);
			login.setSenha(senha);
			
			
			
			if(EstudanteDao.validar(login) == true){
				System.out.println("--sucess login");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("index2.html");
				request.setAttribute("login", login);
				requestDispatcher.forward(request, response);
			} else { 
				System.out.println("--erro na senha ou email");
				RequestDispatcher requestDispatcher = request.getRequestDispatcher("loginE2.html");
				requestDispatcher.forward(request, response);
		}
	}

}
