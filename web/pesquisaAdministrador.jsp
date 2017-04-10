<%-- 
    Document   : pesquisaAluno
    Created on : 20/09/2016, 09:25:00
    Author     : Math
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Pesquisa de Administrador</title>
    </head>
    <body>
        <h1>Pesquisa de Administrador</h1>
        
        <table border=1>
            <tr>
                <th>Codigo Administrador</th>
                <th>Nome do Administrador</th>
                <th>Data de Nascimento</th>
                <th>Email</th>
                <th colspan=2>Ação</th>
            </tr>
            <c:forEach items="${administradores}" var="administrador">
                <tr>
                    <td><c:out value="${administrador.codAdministrador}"/></td>
                    <td><c:out value="${administrador.nome}"/></td>
                    <td><c:out value="${administrador.dataNascimento}"/></td>
                    <td><c:out value="${administrador.email}"/></td>
                    <td><a href="ManterAdministradorController?acao=prepararEditar&codAdministrador=<c:out value="${administrador.codAdministrador}" />"><button> Editar </button></a></td>
                    <td><a href="ManterAdministradorController?acao=prepararExcluir&codAdministrador=<c:out value="${administrador.codAdministrador}" />"><button> Excluir</button> </a></td>
                </tr>      
            </c:forEach>
        </table>
        <form action="ManterAdministradorController?acao=prepararIncluir" method="post">
            <input type="submit" name="bntIncluir" value="Incluir">
        </form>
    </body>
</html>
