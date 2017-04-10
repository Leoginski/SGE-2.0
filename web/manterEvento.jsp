<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Evento</title>
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
            <section>
                <h1>Manter Evento - ${operacao}</h1>
                <form action="ManterEventoController?acao=confirmar${operacao}" method="post" name="frmManterEvento" onsubmit="return validarFormulario(this)">
                    <table>
                        <tr>
                            <td>Código do Evento:</td> 
                            <td><input type="text" name="txtIdEvento" value="${evento.idEvento}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr>
                                <td>Nome do Evento:</td> 
                                <td><input type="text" name="txtNomeEvento" value="${evento.nomeEvento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr>
                                <td>Duração do Evento:</td> 
                                <td><input type="text" name="txtDuracaoEvento" value="${evento.duracao}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr>
                                <td>Tema:</td> 
                                <td><input type="text" name="txtTemaEvento" value="${evento.tema}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr>
                                <td>Data Inicio:</td> 
                                <td><input type="text" name="txtInicioEvento" value="${evento.dataInicioEvento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr>
                                <td>Data Fim:</td> 
                                <td><input type="text" name="txtFimEvento" value="${evento.dataFimEvento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr>
                                <td>Início Inscrições:</td> 
                                <td><input type="text" name="txtInicioInscricaoEvento" value="${evento.dataInicioInscricao}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr>
                                <td>Fim Inscrições:</td> 
                                <td><input type="text" name="txtFimInscricaoEvento" value="${evento.dataFimInscricao}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr>
                                <td>Código Administrador:</td> 
                                <td><input type="text" name="txtCodAdministradorEvento" value="${evento.codAdministrador}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
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