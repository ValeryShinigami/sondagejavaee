package com.mycompany.sondage;


import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.jdbc.Driver;

/**
 * Servlet implementation class Consulter
 */
@WebServlet("/Consulter")
public class Consulter extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Consulter() {
        super();
        // TODO Auto-generated constructor stub
    }
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try ( PrintWriter out = response.getWriter()) {
            
            Class c = Class.forName("com.mysql.jdbc.Driver");
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
            // Connexion
            Connection con = DriverManager.getConnection(conString, nomConnexion, motDePasse);        
            String selectSql = "select * from sondagedeux";
            java.sql.Statement smt = con.createStatement();
            ResultSet i = smt.executeQuery(selectSql);
            ArrayList<Personne> personne = new ArrayList<>();
            while(i.next()){
                int dbId = i.getInt("id");
                String dbNom = i.getString("nom");
                String dbPrenom = i.getString("prenom");
                String dbEmail = i.getString("email");
                int dbAge = i.getInt("age");
                String dbProfession = i.getString("profession");
                String dbSexe = i.getString("sexe");
                Personne p = new Personne(dbId, dbNom, dbPrenom, dbEmail, dbAge, dbProfession, dbSexe);
                personne.add(p);
            }
            
                     request.setAttribute("listePersonne", personne);
             javax.servlet.RequestDispatcher requestDispatcher = request.getRequestDispatcher("liste.jsp");

                requestDispatcher.forward(request, response);
            }   catch (ClassNotFoundException | InstantiationException | IllegalAccessException | SQLException ex) {
            Logger.getLogger(Ajouter.class.getName()).log(Level.SEVERE, null, ex);
            
        }
    }

    /**
     * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
//        response.getWriter().append("Served at: ").append(request.getContextPath());
    	processRequest(request, response);
    }

    /**
     * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
     */
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
//        doGet(request, response);
    	processRequest(request, response);
    }

}


