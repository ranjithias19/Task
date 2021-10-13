package com.tricon.registration.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.tricon.registration.dao.PersonDao;
import com.tricon.registration.model.Person;



@WebServlet("/register")
public class PersonServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    private PersonDao personDao=new PersonDao();
    
    public PersonServlet() {
    	super();
    }
    
    
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
    	    throws ServletException, IOException {
    	response.getWriter().append("served at: ").append(request.getContextPath());
    	RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/personregister.jsp");
    	dispatcher.forward(request, response);
    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
    throws ServletException, IOException {

    	String passId = request.getParameter("passId");
        String name = request.getParameter("name");
        
        Person person = new Person();
        person.setPassId(passId);
        person.setName(name);
        
        try {
            personDao.registerEmployee(person);
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        RequestDispatcher dispatcher=request.getRequestDispatcher("/WEB-INF/views/persondetails.jsp");
    	dispatcher.forward(request, response);
     }
}


