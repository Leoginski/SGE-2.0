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
        <title>Pesquisa de Aluno</title>
    </head>
    <body>
        <h1>Pesquisa de Alunos</h1>
        
        <table border=1>
            <tr>
                <th>Codigo Aluno</th>
                <th>Nome do Aluno</th>
                <th>Email</th>
                <th>Senha</th>
                <th>Data de Nascimento</th>
                <th colspan=2>Ação</th>
            </tr>
            <c:forEach items="${alunos}" var="aluno">
                <tr>
                    <td><c:out value="${aluno.idAluno}"/></td>
                    <td><c:out value="${aluno.nome}"/></td>
                    <td><c:out value="${aluno.email}"/></td>
                    <td><c:out value="${aluno.senha}"/></td>
                    <td><c:out value="${aluno.dataNascimento}"/></td>
                    <td><a href="ManterAlunoController?acao=prepararEditar&idAluno=<c:out value="${aluno.idAluno}" />"><button> Editar </button></a></td>
                    <td><a href="ManterAlunoController?acao=prepararExcluir&idAluno=<c:out value="${aluno.idAluno}" />"><button> Excluir </button></a></td>
                </tr>      
            </c:forEach>
        </table>
        <form action="ManterAlunoController?acao=prepararIncluir" method="post">
            <input type="submit" name="bntIncluir" value="Incluir">
        </form>
    </body>
</html>
