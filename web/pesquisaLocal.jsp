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
        <title>Pesquisa de Local</title>
    </head>
    <body>
        <h1>Pesquisa de Local</h1>
        
        <table border=1>
            <tr>
                <th>Codigo Local</th>
                <th>Descricao</th>
                <th>Capacidade</th>
                <th colspan=2>Ação</th>
            </tr>
            <c:forEach items="${locais}" var="local">
                <tr>
                    <td><c:out value="${local.idLocal}"/></td>
                    <td><c:out value="${local.descricao}"/></td>
                    <td><c:out value="${local.capacidade}"/></td>
                    <td><a href="ManterLocalController?acao=prepararEditar&id=<c:out value="${local.idLocal}" />"> <button> Editar </button> </a></td>
                    <td><a href="ManterLocalController?acao=prepararExcluir&id=<c:out value="${local.idLocal}" />"> <button> Excluir </button> </a></td>
                </tr>      
            </c:forEach>
        </table>
        <form action="ManterLocalController?acao=prepararIncluir" method="post">
            <input type="submit" name="bntIncluir" value="Incluir">
        </form>
    </body>
</html>