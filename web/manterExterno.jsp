<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>SGE - Novo Externo</title>
        <!--Css Materialize-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/css/materialize.min.css">
        <!--Fontes e Ícones Materialize-->
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Css SGE-->
        <link type="text/css" rel="stylesheet" href="css/style.css"  media="screen,projection"/>
        <!--Informe o Browser sobre a compatibilidade-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    </head>
    <body>
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
            <h5 class="flow-text center">Manter Externo - ${operacao}</h5>
            <form action="ManterExternoController?acao=confirmar${operacao}" method="post" name="frmManterExterno" onsubmit="return validarFormulario(this)">
                <div class="row">
                    <div class="input-field col s6">
                        <input type="text" name="txtIdExterno" value="${externo.idExterno}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>>
                            <label class="active" for="txtIdExterno">Id Externo</label>
                        </div>
                        <div class="input-field col s6"> 
                            <input type="text" name="txtNomeExterno" value="${externo.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <label class="active" for="txtNomeExterno">Nome</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s6">
                            <input type="text" name="txtEmailExterno" value="${externo.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <label class="active" for="txtEmailExterno">E-mail</label>
                        </div>
                        <div class="input-field col s6">
                            <input type="text" name="txtDataNascimentoExterno" value="${externo.dataNascimento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <label class="active" for="txtDataNascimentoExterno">Data de Nascimento</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s6">
                            <input type="text" name="txtSenhaExterno" value="${externo.senha}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                            <label class="active" for="txtSenhaExterno">Senha:</label>
                        </div>
                        <div class="input-field col s6">
                            <input type="text" name="txtConhecimentoExterno" value="${externo.conhecimento}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>>
                        <label class="active" for="txtConhecimentoExterno">Como tomou conhecimento?</label>
                    </div>
                </div> 
                <div class="container center">
                    <input class="btn waves-effect waves-light center" type="submit" name="btnConfirmar" value="Confirmar">
                </div>
            </form>
            </div>  
        </section>
    </main>
    <footer class="page-footer light-green lighten-1">
        <div class="footer-copyright grey-text text-lighten-4">
            © 2016 Copyright - Modelagem e Programação: Matheus Souza Leao | Luiz Filipy Damaceno | Leonardo Smoginski Fernandes
        </div>
    </footer>
    <SCRIPT language="JavaScript">
        < SCRIPT language = "JavaScript" >
                < !--

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
            if (form.txtIdExterno.value == "") {
                mensagem = mensagem + "Informe o Código do Externo\n";
            }
            if (form.txtNomeExterno.value == "") {
                mensagem = mensagem + "Informe o Nome do Externo\n";
            }
            if (form.txtEmailExterno.value == "") {
                mensagem = mensagem + "Informe o Email do Externo\n";
            }
            if (form.txtSenhaExterno.value == "") {
                mensagem = mensagem + "Informe a Senha do Externo\n";
            }
            if (form.txtDataNascimentoExterno.value == "") {
                mensagem = mensagem + "Informe a Data de Nascimento do Externo\n";
            }
            if (!campoNumerico(form.txtIdExterno.value)) {
                mensagem = mensagem + "O Código do Externo deve ser numérico\n";
            }
            if (mensagem == "") {
                return true;
            } else {
                alert(mensagem);
                return false;
            }
        }
        //-->
    </SCRIPT>
    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/js/materialize.min.js"></script>
    <!-- JavaScript SGE-->
    <script type="text/javascript" src="js/materialize.min.js"></script>
</body>
</html>
