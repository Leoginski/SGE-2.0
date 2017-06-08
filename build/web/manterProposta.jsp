<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>SGE - Nova Proposta</title>
        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>
        <!--Css Materialize-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/css/materialize.min.css">
        <!--Fontes e Ícones Materialize-->
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Css SGE-->
        <link type="text/css" rel="stylesheet" href="css/style.css"  media="screen,projection"/>
        <!--Informe o Browser sobre a compatibilidade-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <meta charset="UTF-8">
        <script>
            $(document).ready(function () {
                $('select').material_select();
            });
        </script>
    </head>
    <body onload="checkbox()">
        <header>
            <nav class="nav-wraper light-green lighten-1">
                <div class="nav-wrapper">
                    <a href="#" class="brand-logo right">Sistema de Gerenciamento de Eventos</a>
                    <a href="#" data-activates="mobile-demo" class="button-collapse"><i class="material-icons">menu</i></a>
                    <ul id="nav-mobile" class="left hide-on-med-and-down">
                        <li class="tab"><a href="VoltarInicioController">Início</a></li>
                        <li class="tab"><a href="PesquisaNoticiaController">Noticias</a></li>
                        <li class="tab"><a href="PesquisaPropostaController">Propostas</a></li>
                        <li class="tab"><a href="PesquisaAlunoController">Alunos</a></li>
                        <li class="tab"><a href="PesquisaAdministradorController">Administrador</a></li>
                        <li class="tab"><a href="PesquisaEventoController">Evento</a></li>
                        <li class="tab"><a href="PesquisaExternoController">Externo</a></li>
                        <li class="tab"><a href="PesquisaGerenteController">Gerente</a></li>
                        <li class="tab"><a href="PesquisaLocalController">Local</a></li>
                    </ul>
                </div>
            </nav>
        </header>
        <main>
            <section>
                <h5 class="flow-text center">Manter Proposta - ${operacao}</h5>
                <form class="col s12" action="ManterPropostaController?acao=confirmar${operacao}" method="post" name="frmManterProposta" onsubmit="return validarFormulario(this)">
                    <div class="row">
                        <div class="input-field col s6">
                            <input type="text" name="txtIdProposta" value="${proposta.idProposta}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                                <label class="active" for="txtIdProposta">Id da Proposta</label>
                            </div>
                            <div class="input-field col s6">
                                <input type="text" name="txtNomeProponente" value="${proposta.proponente}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                <label class="active" for="txtNomeProponente">Nome Proponente</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s6">
                                <input type="text" name="txtEmailProponente" value="${proposta.emailProponente}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                <label class="active" for="txtEmailProponente">E-mail do Proponente</label>
                            </div>
                            <div class="input-field col s6">
                                <input type="text" name="txtTipoAtividade" value="${proposta.tipoAtividade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                <label class="active" for="txtTipoAtividade">Tipo da Atividade</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s6">
                                <input type="text" name="txtTituloAtividade" value="${proposta.tituloAtividade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                <label class="active" for="txtEmailProponente">Título da Atividade</label>
                            </div>
                            <div class="input-field col s6">
                                <input type="text" name="txtFinalidadeAtividade" value="${proposta.finalidadeAtividade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                <label class="active" for="txtFinalidadeAtividade">Finalidade da Atividade</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s6">
                                <input type="text" name="txtCargaHoraria" value="${proposta.cargaHoraria}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                <label class="active" for="txtCargaHoraria">Carga Horaria</label>
                            </div>
                            <div class="input-field col s6">
                                <input type="text" name="txtVagasAtividade" value="${proposta.vagasAtividade}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                <label class="active" for="txtVagasAtividade">Vagas p/ Atividade</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s6">
                                <input type="text" name="txtNomeConvidado" value="${proposta.nomeConvidado}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                <label class="active" for="txtNomeConvidado">Nome Convidado</label>
                            </div>
                            <div class="input-field col s6">
                                <input type="text" name="txtEmailConvidado" value="${proposta.emailConvidado}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                <label class="active" for="txtEmailConvidado">E-mail do Convidado</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s6">
                                <input type="text" name="txtFormacaoConvidado" value="${proposta.formacaoConvidado}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                <label class="active" for="txtFormacaoConvidado">Formação do Convidado</label>
                            </div>
                            <div class="input-field col s6">
                                <input type="text" name="txtOrigem" value="${proposta.origem}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                <label class="active" for="txtOrigem">Origem do Convidado</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s6">
                                <input type="text" name="txtInformacoesComplementares" value="${proposta.informacoesComplementares}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                <label class="active" for="txtInformacoesComplementares">Informacoes Complemetares</label>
                            </div>
                            <div class="input-field col s6">
                                <input type="text" name="txtOrigem" value="${proposta.origem}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                <label class="active" for="txtOrigem">Origem do Convidado</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s6">
                                <input type="text" name="txtDiaria" value="${proposta.diaria}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                <label class="active" for="txtDiaria">Diaria?</label>
                            </div>
                            <div class="input-field col s6">
                                <input type="text" name="txtEstado" value="${proposta.estado}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                <label class="active" for="txtEstado">Estado</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s6">
                                <input type="text" name="txtDataInicioProposta" value="${proposta.dataInicio}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                <label class="active" for="txtDataInicioProposta">Data Inicio</label>
                            </div>
                            <div class="input-field col s6">
                                <input type="text" name="txtDataFimProposta" value="${proposta.dataFim}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                                <label class="active" for="txtDataFimProposta">Data Fim</label>
                            </div>
                        </div>
                        <p class="center flow-text">Publico Alvo</p>
                        <p class="center">
                            <input id="livre" type="radio" name="radioPublicoAlvo" value="livre" <c:if test="${proposta.publico_alvo == 'livre'}"> checked</c:if>>
                            <label for="livre">Livre</label>
                            <input id="preferencial" type="radio" name="radioPublicoAlvo" value="preferencial" <c:if test="${proposta.publico_alvo == 'preferencial'}"> checked</c:if> >
                            <label for="preferencial">Preferencial</label>
                            <input id="especifica" type="radio" name="radioPublicoAlvo" value="especifica" <c:if test="${proposta.publico_alvo == 'especifica'}"> checked</c:if> >
                            <label for="especifica">Específica</label>
                        </p>
                        <div class="row">
                            <div class="col s2">
                                <input type="checkbox" id="1" name="checkPublicoTodos" value="${proposta.publico_todos}" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                                <label for="1">Todos</label>
                            </div>
                            <div class="col s2">                                
                                <input type="checkbox" id="2" name="checkInformatica" value="${proposta.publico_informatica}" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                                <label for="2">Informática</label>
                            </div>
                            <div class="col s2">
                                <input type="checkbox" id="3" name="checkEdificacoes" value="${proposta.publico_edificacoes}" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                                <label for="3">Edificações</label>
                            </div>
                            <div class="col s2">
                                <input type="checkbox" id="4" name="checkEletromecanica" value="${proposta.publico_eletromecanica}" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                                <label for="4">Eletromecânica</label>
                            </div>
                            <div class="col s2">
                                <input type="checkbox" id="5" name="checkEletrotecnica" value="${proposta.publico_eletrotecnica}" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                                <label for="5">Eletrotécnica</label>
                            </div>
                            <div class="col s2">
                                <input type="checkbox" id="6" name="checkMecanica" value="${proposta.publico_mecanica}"<c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                                <label for="6">Mecânica</label> 
                            </div>
                        </div>
                        <div class="row">        
                            <div class="col s2">
                                <input type="checkbox" id="7" name="checkMetalurgia" value="${proposta.publico_metalurgia}"<c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                                <label for="7">Metalurgia</label>
                            </div>
                            <div class="col s2">
                                <input type="checkbox" id="8" name="checkEventos" value="${proposta.publico_eventos}"<c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                                <label for="8">Eventos</label>
                            </div>
                            <div class="col s2">
                                <input type="checkbox" id="9" name="checkSecretariado" value="${proposta.publico_secretariado}"<c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                                <label for="9">Secretariado</label>
                            </div>
                            <div class="col s2">
                                <input type="checkbox" id="10" name="checkDesignMoveis" value="${proposta.publico_designMoveis}"<c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                                <label for="10">Design Móveis</label>
                            </div>
                            <div class="col s2">
                                <input type="checkbox" id="11"  name="checkEletronica" value="${proposta.publico_eletronica}"<c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                                <label for="11">Eletrônica</label>
                            </div>
                            <div class="col s2">
                                <input type="checkbox" id="12"  name="checkTransacoesImobiliarias" value="${proposta.publico_transacoesImobiliarias}"<c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                                <label for="12">Transações Imobiliárias</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="col s2">
                                <input type="checkbox"  id="13" name="checkTransporteFerroviario" value="${proposta.publico_transporteFerroviario}"<c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                                <label for="13">Transporte Ferroviario</label>
                            </div>
                            <div class="col s2">
                                <input type="checkbox"  id="14" name="checkSistemasInformacao" value="${proposta.publico_sistemasInformacao}"<c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                                <label for="14">Sistemas de Informação</label>
                            </div>
                            <div class="col s2">
                                <input type="checkbox"  id="15" name="checkEngMecatronica" value="${proposta.publico_engMecatronica}"<c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                                <label for="15">Engenharia Mecatrônica</label>
                            </div>
                            <div class="col s2">                            
                                <input type="checkbox"  id="16" name="checkEngMetalurgica" value="${proposta.publico_engMetalurgica}"<c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                                <label for="16">Engenharia Metalúrgica</label>
                            </div>
                            <div class="col s2">
                                <input type="checkbox"  id="17" name="checkFisica" value="${proposta.publico_fisica}"<c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                                <label for="17">Física</label>
                            </div>
                        </div>

                        <p class="center flow-text">Dias da Semana</p>
                        <div class="row">
                            <div class="col s2">
                                <input type="checkbox" id="18" name="checkSegunda" value="${proposta.segunda}"<c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                                <label for="18">Segunda</label>
                            </div>
                            <div class="col s2">
                                <input type="checkbox" id="19" name="checkTerca" value="${proposta.terca}"<c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                                <label for="19">Terça</label>
                            </div>
                            <div class="col s2">
                                <input type="checkbox" id="20" name="checkQuarta" value="${proposta.quarta}"<c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                                <label for="20">Quarta</label>
                            </div>
                            <div class="col s2">
                                <input type="checkbox" id="21" name="checkQuinta" value="${proposta.quinta}"<c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                                <label for="21">Quinta</label>
                            </div>
                            <div class="col s2">
                                <input type="checkbox" id="22" name="checkSexta" value="${proposta.sexta}"<c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                                <label for="22">Sexta</label>
                            </div>
                            <div class="col s2">
                                <input type="checkbox" id="23" name="checkSabado" value="${proposta.sabado}"<c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                                <label for="23">Sábado</label>
                            </div>
                        </div>
                        <div class="input-field row">
                            <select name="optGerente" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                            <option value="0" <c:if test="${gerente.codGerente == null}"> selected</c:if>></option>
                            <c:forEach items="${gerentes}" var="gerente">
                                <option value="${gerente.codGerente}" <c:if test="${proposta.gerente.codGerente == gerente.codGerente}"> selected</c:if>>${gerente.nome}</option>
                            </c:forEach>
                        </select>
                        <label>Gerente</label>
                    </div>                             
                    <div class="input-field row">
                        <select name="optLocal" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                            <option value="0" <c:if test="${local.idLocal == null}"> selected</c:if>></option>
                            <c:forEach items="${locais}" var="local">
                                <option value="${local.idLocal}" <c:if test="${proposta.local.idLocal == local.idLocal}"> selected</c:if>>${local.descricao}</option>
                            </c:forEach>
                        </select>
                        <label>Local</label>
                        
                        
                    </div>

                    <div class="input-field row">
                        <select name="optEvento" <c:if test="${operacao == 'Excluir'}"> disabled</c:if>>
                            <option value="0" <c:if test="${evento.idEvento == null}"> selected</c:if>></option>
                            <c:forEach items="${eventos}" var="evento">
                                <option value="${evento.idEvento}" <c:if test="${proposta.evento.idEvento == evento.idEvento}"> selected</c:if>>${evento.nomeEvento}</option>
                            </c:forEach>
                        </select>
                        <label>Evento</label>
                    </div>
                    <div class="container center">
                        <input class="btn waves-effect waves-light center" type="submit" name="btnConfirmar" value="Confirmar">
                    </div>
                </form>
            </section>
        </main>
        <footer class="page-footer light-green lighten-1">
            <div class="footer-copyright grey-text text-lighten-4">
                © 2016 Copyright - Modelagem e Programação: Matheus Souza Leao | Luiz Filipy Damaceno | Leonardo Smoginski Fernandes
            </div>
        </footer>
        <SCRIPT language="JavaScript">
            function checkbox() {
                for (x = 1; x <= 23; x++) {
                    if (document.getElementById(x).value == 1) {
                        document.getElementById(x).checked = true;
                    }
                }
            }

            function campoNumerico(valor)
            {
                var caracteresValidos = "0123456789";
                var ehNumero = true;
                var umCaracter;
                for (i = 0; i < valor.length && ehNumero == true; i++)
                {
                    umCaracter = valor.charAt(i);
                    if (caracteresValidos.indexOf(umCaracter) == -1)
                    {
                        ehNumero = false;
                    }
                }
                return ehNumero;
            }

            function validarFormulario(form) {
                var mensagem;
                mensagem = "";
                if (form.txtIdProposta.value == "") {
                    mensagem = mensagem + "Informe o Código da Proposta\n";
                }
                if (form.txtNomeProponente.value == "") {
                    mensagem = mensagem + "Informe o Nome do Proponente\n";
                }
                if (form.txtEmailProponente.value == "") {
                    mensagem = mensagem + "Informe o Email do Proponente\n";
                }
                if (form.txtTipoAtividade.value == "") {
                    mensagem = mensagem + "Informe o Tipo da Atividade\n"
                }
                if (form.txtTituloAtividade.value == "") {
                    mensagem = mensagem + "Informe o Título da Atividade\n"
                }
                if (form.txtFinalidadeAtividade.value == "") {
                    mensagem = mensagem + "Informe a Finalidade da Atividade\n"
                }
                if (form.txtCargaHoraria.value == "") {
                    mensagem = mensagem + "Informe a Carga Horária\n"
                }
                if (form.txtVagasAtividade.value == "") {
                    mensagem = mensagem + "Informe a Vagas da Atividade\n"
                }
                if (form.optGerente.value == 0) {
                    mensagem = mensagem + "Escolha um gerente\n"
                }
                if (form.optLocal.value == 0) {
                    mensagem = mensagem + "Escolha um local\n"
                }
                if (form.optEvento.value == 0) {
                    mensagem = mensagem + "Escolha um evento\n"
                }
                if (form.txtDataInicioProposta.value == "") {
                    mensagem = mensagem + "Informe o Início da Atividade\n"
                }
                if (form.txtDataFimProposta.value == "") {
                    mensagem = mensagem + "Informe o Fim da Atividade\n"
                }
                if (!campoNumerico(form.txtIdProposta.value)) {
                    mensagem = mensagem + "Código da Proposta deve ser numérico\n";
                }
                if (mensagem == "") {
                    return true;
                } else {
                    alert(mensagem);
                    return false;
                }
            }
        </SCRIPT>
        <!-- Compiled and minified JavaScript -->
        <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/js/materialize.min.js"></script>
        <!-- JavaScript SGE-->
        <script type="text/javascript" src="js/materialize.min.js"></script>
        <!-- JQuery-->
        <!--        <script type="text/javascript" src="https://code.jquery.com/jquery-2.1.1.min.js"></script>-->
    </body>
</html>
