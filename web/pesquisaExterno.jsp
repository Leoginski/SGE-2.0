<%-- 
    Document   : pesquisaExterno
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
        <title>Pesquisa de Externos</title>
    </head>
    <body>
        <h1>Pesquisa de Externos</h1>
        <table border=1>
            <tr>
                <th>Código Externo</th>
                <th>Nome de Participante Externo</th>
                <th>Como tomou conhecimento?</th>
                <th>Email</th>
                <th colspan=2>Ação</th>
            </tr>
            <c:forEach items="${externos}" var="externo">
                <tr>
                    <td><c:out value="${externo.idExterno}"/></td>
                    <td><c:out value="${externo.nome}"/></td>
                    <td><c:out value="${externo.conhecimento}"/></td>
                    <td><c:out value="${externo.email}"/></td>
                    <td><a href="ManterExternoController?acao=prepararEditar&codExterno=<c:out value="${externo.idExterno}" />"> <button> Editar </button> </a></td>
                    <td><a href="ManterExternoController?acao=prepararExcluir&codExterno=<c:out value="${externo.idExterno}" />"> <button> Excluir </button></a></td>
                </tr>   
            </c:forEach>
       </table>
        <form action="ManterExternoController?acao=prepararIncluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>     
    </body>
</html>
