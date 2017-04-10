<%-- 
    Document   : pesquisaNoticia
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
        <title>Pesquisa de Notícias</title>
    </head>
    <body>
        <h1>Pesquisa de Notícias</h1>
        <table border=1>
            <tr>
                <th>Código Notícia</th>
                <th>Nome Notícia</th>
                <th colspan=2>Ação</th>
            </tr>
            <c:forEach items="${noticias}" var="noticia">
                <tr>
                    <td><c:out value="${noticia.idNoticia}"/></td>
                    <td><c:out value="${noticia.descricao}"/></td>
                    <td><a href="ManterNoticiaController?acao=prepararEditar&idNoticia=<c:out value="${noticia.idNoticia}" />"> <button> Editar </button> </a></td>
                    <td><a href="ManterNoticiaController?acao=prepararExcluir&idNoticia=<c:out value="${noticia.idNoticia}" />"> <button> Excluir  </button></a></td>
                </tr>   
            </c:forEach>
       </table>
        <form action="ManterNoticiaController?acao=prepararIncluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>     
    </body>
</html>
