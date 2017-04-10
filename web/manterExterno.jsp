<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Externo</title>
    </head>
    <body>
        <header>
            <!--cabeÃ§alho comentario-->
            <table>
                <tr>
                    <th colspan="7">Sistema de Gerenciamento de Eventos</th>
                </tr>
                <tr>
                    <td><button>Home</button></td>
                    <td><button>Inscrição</button></td>
                    <td><button>Programação</button></td>
                    <td><button>Notícias</button></td>
                    <td><button>Edições</button></td>
                    <td><button>Fotos</button></td>
                    <td><button>Conheça</button></td>				
                </tr>
            </table>

            <table>
                <tr>
                    <td>Login</td>
                </tr>
                <tr>
                    <td><input type="text"></td>
                </tr>
                <tr>
                    <td>Senha</td>
                </tr>
                <tr>
                    <td><input type="password"></td>
                </tr>
            </table>
            <section>
                <h1>Manter Externo - ${operacao}</h1>
                <form action="ManterExternoController?acao=confirmar${operacao}" method="post" name="frmManterExterno" onsubmit="return validarFormulario(this)">
                    <table>
                        <tr>
                            <td>Código do Externo:</td> 
                            <td><input type="text" name="txtIdExterno" value="${externo.idExterno}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr>
                                <td>Nome:</td> 
                                <td><input type="text" name="txtNomeExterno" value="${externo.nomeEvento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr>
                                <td>Email:</td> 
                                <td><input type="text" name="txtEmailExterno" value="${externo.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr>
                                <td>Senha:</td> 
                                <td><input type="text" name="txtSenhaExterno" value="${externo.senha}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr> 
                                <td>Data de Nascimento:</td> 
                                <td><input type="text" name="txtDnExterno" value="${externo.dn}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>    
                            <tr> 
                                <td>Como tomou conhecimento?</td> 
                                <td><input type="text" name="txtConhecimentoExterno" value="${externo.conhecimento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
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