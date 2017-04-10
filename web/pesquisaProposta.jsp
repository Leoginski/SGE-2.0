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
        <title>Pesquisa de Proposta</title>
    </head>
    <body>
        <h1>Pesquisa de Proposta</h1>
        
        <table border=1>
            <tr>
                <th>Codigo Proposta</th>
                <th>Titulo Proposta</th>
                <th colspan=2>Ação</th>
            </tr>
            <c:forEach items="${propostas}" var="proposta">
                <tr>
                    <td><c:out value="${proposta.idProposta}"/></td>
                    <td><c:out value="${proposta.tituloAtividade}"/></td>
                    <td><a href="ManterPropostaController?acao=prepararEditar&id=<c:out value="${proposta.idProposta}" />"><button> Editar </button> </a></td>
                    <td><a href="ManterPropostaController?acao=prepararExcluir&id=<c:out value="${proposta.idProposta}" />"><button> Excluir </button> </a></td>
                </tr>      
            </c:forEach>
        </table>
        <form action="ManterPropostaController?acao=prepararIncluir" method="post">
            <input type="submit" name="bntIncluir" value="Incluir">
        </form>
    </body>
</html>