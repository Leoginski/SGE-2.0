<%-- 
    Document   : pesquisaAlbum
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
        <title>Pesquisa de Albuns</title>
    </head>
    <body>
        <h1>Pesquisa de Albuns</h1>
        <table border=1>
            <tr>
                <th>Código Album</th>
                <th>Nome Album</th>
                <th colspan=2>Ação</th>
            </tr>
            <c:forEach items="${albuns}" var="album">
                <tr>
                    <td><c:out value="${album.idAlbum}"/></td>
                    <td><c:out value="${album.descricao}"/></td>
                    <td><a href="ManterAlbumController?acao=prepararEditar&idAlbum=<c:out value="${album.idAlbum}" />"><button>Editar</button></a></td>
                    <td><a href="ManterAlbumController?acao=prepararExcluir&idAlbum=<c:out value="${album.idAlbum}" />"><button>Excluir</button></a></td>
                </tr>   
            </c:forEach>
       </table>
        <form action="ManterAlbumController?acao=prepararIncluir" method="post">
            <input type="submit" name="btnIncluir" value="Incluir">
        </form>     
    </body>
</html>
