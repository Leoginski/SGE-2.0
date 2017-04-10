<%-- 
    Document   : manterGerente
    Created on : 11/10/2016, 10:18:37
    Author     : Math
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Gerente</title>
    </head>
    <body>
        <header>
            <section>
                <h1>Manter Gerente - ${operacao}</h1>
                <form action="ManterGerenteController?acao=confirmar${operacao}" method="post" name="frmManterGerente" onsubmit="return validarFormulario(this)">
                    <table>
                        <tr>
                            <td>Matrícula do Aluno</td> 
                            <td><input type="text" name="txtCodGerente" value="${gerente.idAluno}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr>
                                <td>Nome:</td> 
                                <td><input type="text" name="txtNomeGerente" value="${gerente.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr>
                                <td>Email:</td> 
                                <td><input type="text" name="txtEmailGerente" value="${gerente.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr>
                                <td>Senha:</td> 
                                <td><input type="text" name="txtSenhaGerente" value="${gerente.senha}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr> 
                                <td>Data de Nascimento:</td> 
                                <td><input type="text" name="txtDnGerente" value="${gerente.dn}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
                        </tr>
                    </table>
            </section>
        </header>
    </form>
    <footer>
        <h6>SGE - Sistema de Gerenciamento de Eventos| -- | IF Sudeste MG, Campus Juiz de Fora | -- | Contato: (32)4009-3059 | -- | Desenvolvido por: Leonardo S. | Luiz Filipy | Matheus Leão</h6>
    </footer>              
</body>
</html>
