<%-- 
    Document   : manterLocal
    Created on : 11/10/2016, 10:18:51
    Author     : Math
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Local</title>
    </head>
    <body>
        <header>
            <section>
                <h1>Manter Local - ${operacao}</h1>
                <form action="ManterLocalController?acao=confirmar${operacao}" method="post" name="frmManterLocal" onsubmit="return validarFormulario(this)">
                    <table>
                        <tr>
                            <td>Id do Local:</td> 
                            <td><input type="text" name="txtIdLocal" value="${local.idLocal}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr>
                                <td>Descriçao:</td> 
                                <td><input type="text" name="txtDescricaoGerente" value="${local.descricao}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr>
                                <td>Capacidade:</td> 
                                <td><input type="text" name="txtCapacidadeGerente" value="${local.capacidade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>                   
                        <tr>
                            <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
                        </tr>
                    </table>
                </form>
            </section>
        </header>                    
        <footer>
            <h6>SGE - Sistema de Gerenciamento de Eventos| -- | IF Sudeste MG, Campus Juiz de Fora | -- | Contato: (32)4009-3059 | -- | Desenvolvido por: Leonardo S. | Luiz Filipy | Matheus Leão</h6>
        </footer> 
    </body>
</html>
