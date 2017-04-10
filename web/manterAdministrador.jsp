<%-- 
    Document   : manterAdministrador
    Created on : 11/10/2016, 10:18:06
    Author     : Math
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Administrador</title>
    </head>
    <body>
        <header>
            <section>
                <h1>Manter Administrador - ${operacao}</h1>
                <form action="ManterAdministradorController?acao=confirmar${operacao}" method="post" name="frmManterAdministrador" onsubmit="return validarFormulario(this)">
                    <table>
                        <tr>
                            <td>Código do Administrador</td> 
                            <td><input type="text" name="txtCodAdministrador" value="${administrador.codAdministrador}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr>
                                <td>Nome:</td> 
                                <td><input type="text" name="txtNomeAdministrador" value="${administrador.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr>
                                <td>Email:</td> 
                                <td><input type="text" name="txtTotalPeriodos" value="${administrador.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr>
                                <td>Senha:</td> 
                                <td><input type="text" name="txtCargaHoraria" value="${administrador.senha}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr> 
                                <td>Data de Nascimento:</td> 
                                <td><input type="text" name="txtDataNascimento" value="${administrador.dn}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
                        </tr>
                    </table>
                </form>
            </section>
        </header>
        <footer>
            <h6>SGE - Sistema de Gerenciamento de Eventos| -- | IF Sudeste MG, CÃ¢mpus Juiz de Fora | -- | Contato: (32)4009-3059 | -- | Desenvolvido por: Leonardo S. | Luiz Filipy | Matheus Leão</h6>
        </footer>
    </body>
</html>
