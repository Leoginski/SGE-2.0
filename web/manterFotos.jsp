<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset ="utf-8">
		<title>SGE - Sistema de Gerenciamento de Eventos</title>
                  <!-- Compiled and minified CSS -->
	</head>
	<body>
		<header>
			<!--cabeÃ§alho comentario-->
			<table>
                            <tr>
                                <th colspan="7"><h1>Sistema de Gerenciamento de Eventos</h1></th>
                            </tr>
                            <tr>
                                <td><a href="VoltarInicioController"><button>Home</button></a></td>
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
				<h1>Adicionar Fotos - - ${operacao}</h1>
			</section>
			<section>
				<table>
					<tr>
						<td>Adicionar<input type="text" name=""><input type="submit" name="" value="+"></td>
					</tr>
				</table>
			</section>
			<section>
				<table>
					<tr>
						<td></td>
						<td>Progresso</td>
						<td>Adicionar Legenda</td>
					</tr>
					<tr>
						<td>Nome da Imagem</td>
						<td><progress value="10" max="100"></td>
						<td>Foto do Evento...</td>
					</tr>
					<tr>
						<td>Nome da Imagem</td>
						<td><progress value="10" max="100"></td>
						<td>Foto do Evento...</td>
					</tr>
					<tr>
						<td>Nome da Imagem</td>
						<td><progress value="10" max="100"></td>
						<td>Foto do Evento...</td>
					</tr>
				</table>

				<input type="submit" value="Confirmar" name="">
			</section>

		</header>	
		<footer>
			<h6>SGE - Sistema de Gerenciamento de Eventos| -- | IF Sudeste MG, CÃ¢mpus Juiz de Fora | -- | Contato: (32)4009-3059 | -- | Desenvolvido por: Leonardo S. | Luiz Filipy | Matheus LeÃ£o</h6>
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
