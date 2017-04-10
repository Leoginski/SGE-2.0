<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Proposta</title>
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
                <h1>Manter Proposta - ${operacao}</h1>
                <form action="ManterPropostaController?acao=confirmar${operacao}" method="post" name="frmManterProposta" onsubmit="return validarFormulario(this)">
                    <table>
                        <tr>
                            <td>Id da Proposta</td> 
                            <td><input type="text" name="txtIdProposta" value="${proposta.idProposta}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr>
                                <td>Nome Proponente:</td> 
                                <td><input type="text" name="txtNomeProponente" value="${proposta.proponente}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr>
                                <td>Email do Proponente:</td> 
                                <td><input type="text" name="txtEmailProponente" value="${proposta.emailProponente}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr>
                                <td>Tipo da Atividade:</td> 
                                <td><input type="text" name="txtTipoAtividade" value="${proposta.tipoAtividade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr> 
                                <td>Título da Atividade:</td> 
                                <td><input type="text" name="txtTituloAtividade" value="${proposta.tituloAtividade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr> 
                                <td>Finalidade da Atividade:</td> 
                                <td><input type="text" name="txtFinalidadeAtividade" value="${proposta.finalidadeAtividade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr> 
                                <td>Carga Horaria:</td> 
                                <td><input type="text" name="txtCargaHoraria" value="${proposta.cargaHoraria}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr> 
                                <td>Vagas p/ Atividade:</td> 
                                <td><input type="text" name="txtVagasAtividade" value="${proposta.vagasAtividade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr> 
                                <td>Convidado?</td> 
                                <td><input type="text" name="txtNomeConvidado" value="${proposta.nomeConvidado}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr> 
                                <td>Email do Convidado</td> 
                                <td><input type="text" name="txtEmailConvidado" value="${proposta.emailConvidado}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr> 
                                <td>Formação do Convidado</td> 
                                <td><input type="text" name="txtFormacaoConvidado" value="${proposta.formacaoConvidado}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr> 
                                <td>Origem:</td> 
                                <td><input type="text" name="txtOrigem" value="${proposta.origem}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr> 
                                <td>informacoes Complemetares:</td> 
                                <td><input type="text" name="txtInformacoesComplemetares" value="${proposta.informacoesComplemetares}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr> 
                                <td>Diaria?</td> 
                                <td><input type="text" name="txtDiaria" value="${proposta.diaria}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr> 
                                <td>Estado:</td> 
                                <td><input type="text" name="txtEstado" value="${proposta.estado}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr> 
                                <td>Exclusiva:</td> 
                                <td><input type="text" name="txtExclusiva" value="${proposta.exclusiva}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr> 
                                <td>Preferencial:</td> 
                                <td><input type="text" name="txtPreferencial" value="${proposta.preferencial}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr> 
                                <td>Especifica:</td> 
                                <td><input type="text" name="txtEspecifica" value="${proposta.especifica}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <!--    private int publico_todos;
                                private int publico_informatica;
                                private int publico_edificacoes;
                                private int publico_eletromecanica;
                                private int publico_eletrotecnica;
                                private int publico_mecanica;
                                private int publico_metalurgia;
                                private int publico_eventos;
                                private int publico_secretariado;
                                private int publico_designMoveis;
                                private int publico_eletronica;
                                private int publico_transacoesImobiliarias;
                                private int publico_trasporteFerroviario;
                                private int publico_sistemasInformacao;
                                private int publico_engMecatronica;
                                private int publico_engMetalurgica;
                                private int publico_fisica;
                                private int segunda;
        private int terca;
        private int quarta;
        private int quinta;
        private int sexta;
        private int sabado;
                            -->

                            <tr>
                                <td>Evento:</td> 
                                <td>
                                    <select name="optEvento" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                    <option value="0" <c:if test="${proposta.evento.idEvento == null}"> selected</c:if>> </option>  
                                    <c:forEach items="${eventos}" var="galeria">
                                        <option value="${evento.titulo}" <c:if test="${proposta.evento.idEvento == evento.idEvento}"> selected</c:if>>${galeria.evento}</option>  
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr>

                            <td>Local:</td> 
                            <td>
                                <select name="optLocal" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                    <option value="0" <c:if test="${porposta.local.idLocal == null}"> selected</c:if>> </option>  
                                    <c:forEach items="${locais}" var="galeria">
                                        <option value="${local.idLocal}" <c:if test="${proposta.local.idLocal == local.idLocal}"> selected</c:if>>${galeria.evento}</option>  
                                    </c:forEach>
                                </select>
                            </td>
                        </tr>
                        <tr> 
                            <td>Id do Gerente:</td> 
                            <td><input type="text" name="txtIdGerenteProposta" value="${proposta.idGerente}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr> 
                                <td>Data Inicio:</td> 
                                <td><input type="text" name="txtDataInicioProposta" value="${proposta.dataInicio}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr> 
                                <td>Data Fim:</td> 
                                <td><input type="text" name="txtDataFimProposta" value="${proposta.dataFim}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                        </tr>
                        <tr>
                            <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>
                        </tr>
                    </table>
                </form>
            </section> 
        </header>
        <footer>
            <h6>SGE - Sistema de Gerenciamento de Eventos| -- | IF Sudeste MG, CÃ¢mpus Juiz de Fora | -- | Contato: (32)4009-3059 | -- | Desenvolvido por: Leonardo S. | Luiz Filipy | Matheus LeÃ£o</h6>
        </footer>
    </body>
</html>