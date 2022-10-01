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



@WebServlet("/AdmFindAndUpdate")
public class AdmFindAndUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public AdmFindAndUpdate() {
        super();
        
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		
		int admId = Integer.parseInt(request.getParameter("admId"));
		Adm adm = AdmDao.findByPkAdm(admId); 
		
		request.setAttribute("adm", adm);
		RequestDispatcher requestDispatcher = request.getRequestDispatcher("formUpdateA.jsp") ;
		requestDispatcher.forward(request, response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Adm adm = new Adm();
		
		adm.setNome(request.getParameter("nome"));
		adm.setSobrenome(request.getParameter("sobrenome"));
		adm.setEmail(request.getParameter("email"));
		adm.setSenha(request.getParameter("senha"));
		
		AdmDao.updateAdm(adm);
		
		AdmCreateAndFind admFindAndFind = new AdmCreateAndFind();
		admFindAndFind.doGet(request, response);
	}

}
