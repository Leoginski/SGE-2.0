<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <title>SGE - Novo Administrador</title>
        <!--Css Materialize-->
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/0.97.8/css/materialize.min.css">
        <!--Fontes e Ícones Materialize-->
        <link href="http://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">
        <!--Css SGE-->
        <link type="text/css" rel="stylesheet" href="css/style.css"  media="screen,projection"/>
        <!--Informe o Browser sobre a compatibilidade-->
        <meta name="viewport" content="width=device-width, initial-scale=1.0"/>
        <meta charset="UTF-8">
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
            <h5 class="flow-text center">Manter Aluno - ${operacao}</h5>
            <form action="ManterAlunoController?acao=confirmarOperacao&operacao=${operacao}" method="post" name="frmManterAluno" onsubmit="return validarFormulario(this)">
                <div class="row">
                    <div class="input-field col s6">
                        <input type="text" name="txtIdAluno" value="${aluno.idAluno}" <c:if test="${operacao != 'incluir'}"> readonly</c:if>>
                            <label class="active" for="txtIdAluno">Matrícula do Aluno</label>
                        </div>
                        <div class="input-field col s6">
                            <input type="text" name="txtNomeAluno" value="${aluno.nome}" <c:if test="${operacao == 'excluir'}"> readonly</c:if>>
                            <label class="active" for="txtNomeAluno">Nome</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s6">
                            <input type="text" name="txtEmailAluno" value="${aluno.email}" <c:if test="${operacao == 'excluir'}"> readonly</c:if>>
                            <label class="active" for="txtEmailAluno">E-mail</label>
                        </div>
                        <div class="input-field col s6">
                            <input type="text" name="txtSenhaAluno" value="${aluno.senha}" <c:if test="${operacao == 'excluir'}"> readonly</c:if>>
                            <label class="active" for="txtSenhaAluno">Senha</label>
                        </div>
                    </div>
                    <div class="input-field center">
                        <input type="text" name="txtDataNascimentoAluno" value="${aluno.dataNascimento}" <c:if test="${operacao == 'excluir'}"> readonly</c:if>>  
                        <label class="active" for="txtDataNascimentoAluno">Data Nascimento</label>
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
            <!--
            
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
            if (form.txtIdAluno.value == "") {
                mensagem = mensagem + "Informe o Código do Aluno\n";
            }
            if (form.txtNomeAluno.value == "") {
                mensagem = mensagem + "Informe o Nome do Aluno\n";
            }
            if (form.txtEmailAluno.value == "") {
                mensagem = mensagem + "Informe o Email do Aluno\n";
            }
            if (form.txtDataNascimentoAluno.value == "") {
                mensagem = mensagem + "Informe a Data Nascimento do Aluno\n";
            }
            if (!campoNumerico(form.txtIdAluno.value)) {
                mensagem = mensagem + "Código do Curso deve ser numérico\n";
            }
            if (form.txtSenhaAluno.value == "") {
                mensagem = mensagem + "Informe a Senha do Aluno\n";
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
