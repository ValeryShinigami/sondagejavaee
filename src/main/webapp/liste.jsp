<%@ taglib prefix="c" 
       uri="http://java.sun.com/jsp/jstl/core" %>

<%@ taglib prefix="fn" 
       uri="http://java.sun.com/jsp/jstl/functions" %>
       
<%@page language="java" contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Liste des participants</title>
        <style>
            table, tr, td, th{
                border: 1px solid rgb(154,205,50) ;
                text-align:center;
            }
            table{
                border-collapse: collapse;
                width: 70%;
            }

        </style>
    </head>
    <body>
        <h1>Liste des inscrits</h1>
        <table>
            <thead>
                <tr>
                    <th>ID</th>
                    <th>Nom</th>
                    <th>Prénom</th>
                    <th>Email</th>
                    <th>Âge</th>
                    <th>Profession</th>
                    <th>Sexe</th>
                </tr>
                </thead>
            <tbody>
                <c:forEach items="${listePersonne}" var="listePersonne">
                    <tr>
                        <td>${listePersonne.getId()}</td>
                        <td>${listePersonne.getNom()}</td>
                        <td>${listePersonne.getPrenom()}</td>
                        <td>${listePersonne.getEmail()}</td>
                        <td>${listePersonne.getAge()}</td>
                        <td>${listePersonne.getProfession()}</td>
                        <td>${listePersonne.getSexe()}</td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
         <a href="index.jsp">Retourner à l'accueil</a>
    </body>
</html>