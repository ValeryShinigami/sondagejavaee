package com.mycompany.sondage;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.jdbc.Driver;



/**
 * Servlet implementation class Ajouter
 */
@WebServlet("/Ajouter")
public class Ajouter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Ajouter() {
        super();
        
        
    }
    //fonction qui récupère les attributs de la classe Personne par le biais de la requête httpServletRequest
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	String id = request.getParameter("id");
    	String nom = request.getParameter("nom");
    	String prenom = request.getParameter("prenom");
    	String email = request.getParameter("email");
    	String age = request.getParameter("age");
    	String profession = request.getParameter("profession");
    	String sexe = request.getParameter("sexe");
    	
    	request.setAttribute("nom", nom);
    	request.setAttribute("id", id);
    	request.setAttribute("prenom", prenom);
    	request.setAttribute("email", email);
    	request.setAttribute("age", age);
    	request.setAttribute("profession", profession);
    	request.setAttribute("sexe", sexe);
    	
    	try(PrintWriter out = response.getWriter()){
    		
    		Class c = Class.forName("com.mysql.cj.jdbc.Driver");
    		
    		Driver pilote = (Driver) c.newInstance();
    		DriverManager.registerDriver(pilote);
    		
    		String protocole = "jdbc:mysql:";
            String ip = "localhost";  // dépend du contexte
            String port = "8889";  // port MySQL par défaut
            // Nom de la base ;
            String nomBase = "sondage";  // dépend du contexte
            // Chaîne de connexion
            String conString = protocole + "//" + ip + ":" + port + "/" + nomBase;
            // Identifiants de connexion et mot de passe
            String nomConnexion = "root";  // dépend du contexte
            String motDePasse = "root";  // dépend du contexte
            
            //Connexion
            Connection con = DriverManager.getConnection(conString, nomConnexion, motDePasse); 
            String consulterSql = "select * from sondagedeux where email = '" + email + "'";
            java.sql.Statement smtConsulter = con.createStatement();
            ResultSet result = smtConsulter.executeQuery(consulterSql);
            if(result.next()){
                //implémentation de la méthode pour vérifier l'existence d'une adresse mail dans la BDD
                RequestDispatcher requestDispatcher = request.getRequestDispatcher("erreurInscription.jsp");

                requestDispatcher.forward(request, response);
            }else{
                String insertSql = "insert into sondagedeux(id,nom,prenom,email,age,profession,sexe) Values('"+ id +"','"+ nom +"','"+ prenom +"','"+ email +"','"+ age +"','"+ profession +"','"+ sexe +"')";
            java.sql.Statement smt = con.createStatement();
            int i = smt.executeUpdate(insertSql);
             RequestDispatcher requestDispatcher = request.getRequestDispatcher("confirmation.jsp");
                requestDispatcher.forward(request, response);
            }
            
           	
    		   
    	   }catch (ClassNotFoundException | SQLException | InstantiationException | IllegalAccessException e) {
    		   
    		   Logger.getLogger(Ajouter.class.getName()).log(Level.SEVERE, null, e);
    		   e.printStackTrace();
    		   
    	   }
    	
    }
   

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		processRequest(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		processRequest(request, response);
	}

}
