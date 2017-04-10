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
        <title>Pesquisa de Evento</title>
    </head>
    <body>
        <h1>Pesquisa de Evento</h1>
        
        <table border=1>
            <tr>
                <th>Codigo Evento</th>
                <th>Nome Evento</th>
                <th>Duração</th>
                <th>Tema</th>
                <th>Data Inicio do Evento</th>
                <th>Data de Fim do Evento</th>
                <th>Data Inicio da Inscricao</th>
                <th>Data Final da Inscricao</th>
                <th colspan=2>Ação</th>
            </tr>
            <c:forEach items="${eventos}" var="evento">
                <tr>
                    <td><c:out value="${evento.idEvento}"/></td>
                    <td><c:out value="${evento.nomeEvento}"/></td>
                    <td><c:out value="${evento.duracao}"/></td>
                    <td><c:out value="${evento.tema}"/></td>
                    <td><c:out value="${evento.dataInicioEvento}"/></td>
                    <td><c:out value="${evento.dataFimEvento}"/></td>
                    <td><c:out value="${evento.dataInicioInscricao}"/></td>
                    <td><c:out value="${evento.dataFimInscricao}"/></td>
                    <td><a href="ManterEventoController?acao=prepararEditar&id=<c:out value="${evento.idEvento}" />"><button> Editar </button> </a></td>
                    <td><a href="ManterEventoController?acao=prepararExcluir&id=<c:out value="${evento.idEvento}" />"><button> Excluir </button> </a></td>
                </tr>      
            </c:forEach>
        </table>
        <form action="ManterEventoController?acao=prepararIncluir" method="post">
            <input type="submit" name="bntIncluir" value="Incluir">
        </form>
    </body>
</html>