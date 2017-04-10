<%-- 
    Document   : pesquisaGerente
    Created on : 20/09/2016, 09:21:35
    Author     : Aluno
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Gerentes</title>
    </head>
    <body>
        <h1>Pesquisa de Gerentes</h1>
        <table border=1>
            <tr>
                <th>Código Gerente</th>
                <th>Nome Gerente</th>
                <th>Email</th>
                <th colspan=2>Ação</th>
            </tr>
            <c:forEach items="${gerentes}" var="gerente">
                <tr>
                    <td><c:out value="${gerente.codGerente}"/></td>
                    <td><c:out value="${gerente.nome}"/></td>
                    <td><c:out value="${gerente.email}"/></td>
                    <td><a href="ManterGerenteController?acao=prepararEditar&codGerente=<c:out value="${gerente.codGerente}" />"> <button> Editar </button> </a></td>
                    <td><a href="ManterGerenteController?acao=prepararExcluir&codGerente=<c:out value="${gerente.codGerente}" />"> <button> Excluir </button> </a></td>
                </tr>   
            </c:forEach>
       </table>
        <form action="ManterGerenteController?acao=prepararIncluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>     
    </body>
</html>
