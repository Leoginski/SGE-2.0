<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Manter Aluno</title>
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
                <h1>Manter Aluno - ${operacao}</h1>
                <form action="ManterAlunoController?acao=confirmar${operacao}" method="post" name="frmManterAluno" onsubmit="return validarFormulario(this)">
                    <table>
                        <tr>
                            <td>Matrícula do Aluno</td> 
                            <td><input type="text" name="txtCodAluno" value="${aluno.idAluno}" <c:if test="${operacao != 'Incluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr>
                                <td>Nome:</td> 
                                <td><input type="text" name="txtNomeAluno" value="${aluno.nome}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr>
                                <td>Email:</td> 
                                <td><input type="text" name="txtEmailAluno" value="${aluno.email}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr>
                                <td>Senha:</td> 
                                <td><input type="text" name="txtSenhaAluno" value="${aluno.senha}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
                            </tr>
                            <tr> 
                                <td>Data de Nascimento:</td> 
                                <td><input type="text" name="txtDnAluno" value="${aluno.dn}" <c:if test="${operacao == 'Excluir'}"> readonly</c:if>></td>
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