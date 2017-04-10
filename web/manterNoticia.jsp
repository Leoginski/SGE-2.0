<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
		<title>SGE - Sistema de Gerenciamento de Eventos</title>
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
					<td><button>Inscricao</button></td>
					<td><button>Programacao</button></td>
					<td><button>Noticias</button></td>
					<td><button>Edicoes</button></td>
					<td><button>Fotos</button></td>
					<td><button>Conheca</button></td>
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
                            <h1>Novas Noticia - ${operacao} </h1>
                            <form action="ManterNoticiaController?acao=confirmar${operacao}" method="post" name="frmManterNoticia" onsubmit="return validarFormulario(this)">
				
                                <table>
                                    <tr>
                                        <td>Codigo</td>
                                        <td><input type="text" name="txtIdNoticia" value="${aluno.idNoticia}" <c:if test="${operacao != 'Incluir'}">readonly</c:if> ></td>                                                
                                    </tr>
                                    <tr>
                                        <td>Data</td>
                                        <td><input type="text" name="txtDataNoticia" value="${noticia.data}" <c:if test="${operacao == 'Excluir'}">readonly</c:if>></td>
                                    </tr>
                                    <tr>
                                        <td>Descricao</td>
                                        <td><input type="text" name="txtDescricaoNoticia" value="${noticia.descricao}" <c:if test="${operacao == 'Excluir'}">readonly</c:if>></td>
                                    </tr>
                                    <td><input type="submit" name="btnConfirmar" value="Confirmar"></td>  
                                </table>
                            </form>
                        </section>
		</header>	
		<footer>
			<h6>SGE - Sistema de Gerenciamento de Eventos| -- | IF Sudeste MG, Campus Juiz de Fora | -- | Contato: (32)4009-3059 | -- | Desenvolvido por: Leonardo S. | Luiz Filipy | Matheus Leão</h6>
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
                if (form.txtCodCurso.value == ""){
                    mensagem = mensagem + "Informe o Código do Curso\n";
                }                             
                if (form.txtNomeCurso.value == ""){
                    mensagem = mensagem + "Informe o Nome do Curso\n";
                }             
                if (form.txtTotalPeriodos.value == ""){
                    mensagem = mensagem + "Informe o Total de Períodos\n";
                }                  
                if (form.txtCargaHoraria.value == ""){
                    mensagem = mensagem + "Informe a Carga Horária\n";
                }                  
                if (!campoNumerico(form.txtCodCurso.value)){
                    mensagem = mensagem + "Código do Curso deve ser numérico\n";
                }                  
                if (!campoNumerico(form.txtTotalPeriodos.value)){
                    mensagem = mensagem + "Total de Períodos deve ser numérico\n";
                }                  
                if (!campoNumerico(form.txtCargaHoraria.value)){
                    mensagem = mensagem + "Carga Horária deve ser numérica\n";
                }                  
                if (mensagem == ""){
                    return true;
                }else{
                    alert(mensagem);
                    return false;
                }                
            } 
            //-->
        </SCRIPT>        
    </body>
</html>
