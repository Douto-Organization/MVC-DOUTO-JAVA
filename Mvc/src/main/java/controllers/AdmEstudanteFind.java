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

/**
 * Servlet implementation class AdmEstudanteFind
 */
@WebServlet("/AdmEstudanteFind")
public class AdmEstudanteFind extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public AdmEstudanteFind() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	        Estudante estudante = new Estudante();
	        
	        estudante.setNome(request.getParameter("nome"));
	        estudante.setSobrenome(request.getParameter("sobrenome"));
	        estudante.setNascimento(request.getParameter("nascimento"));
	        estudante.setSerie(request.getParameter("serie"));
	        estudante.setEstado(request.getParameter("estado"));
	        estudante.setCidade(request.getParameter("cidade"));
	        estudante.setEmail(request.getParameter("email"));
	        estudante.setSenha(request.getParameter("senha"));
	        
	        EstudanteDao.create(estudante);
	       doGet(request, response);
	    }
}
