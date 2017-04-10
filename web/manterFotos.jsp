<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset ="utf-8">
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
	</body>
</html>