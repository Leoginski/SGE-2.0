package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Evento;
import modelo.Gerente;
import modelo.Local;
import modelo.Proposta;
import DAO.PropostaDAO;

/**
 *
 * @author Math
 */
@WebServlet(name = "ManterPropostaController", urlPatterns = {"/ManterPropostaController"})
public class ManterPropostaController extends HttpServlet {

    private Proposta proposta;

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        if (acao.equals("prepararOperacao")) {
            prepararOperacao(request, response);
        }
        if (acao.equals("confirmarOperacao")) {
            confirmarOperacao(request, response);
        }
    }

    public void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("gerentes", GerenteDAO.getInstance().getAllGerentes());
            request.setAttribute("locais", LocalDAO.getInstance().getAllLocais());
            request.setAttribute("eventos", EventoDAO.getInstance().getAllEventos());
            if (!operacao.equals("incluir")) {
                int idProposta = Integer.parseInt(request.getParameter("idProposta"));
                proposta = PropostaDAO.getInstance().getProposta(idProposta);
                request.setAttribute("proposta", proposta);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterProposta.jsp");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        }
    }

    public void confirmarOperacao(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try {
//            String operacao = request.getParameter("operacao");
//            int codCurso = Integer.parseInt(request.getParameter("codCurso"));
//            String nome = request.getParameter("nomeCurso");
//            int cargaHoraria = Integer.parseInt(request.getParameter("cargaHoraria"));
//            String tipoCurso = request.getParameter("tipoCurso");
//            int totalPeriodos = Integer.parseInt(request.getParameter("totalPeriodos"));
//            int codCoordenador = Integer.parseInt(request.getParameter("coordenador"));
            String operacao = request.getParameter("operacao");
            int idProposta = Integer.parseInt(request.getParameter("txtIdProposta"));
            String proponente = request.getParameter("txtNomeProponente");
            String emailProponente = request.getParameter("txtEmailProponente");
            String tipoAtividade = request.getParameter("txtTipoAtividade");
            String tituloAtividade = request.getParameter("txtTituloAtividade");
            String finalidadeAtividade = request.getParameter("txtFinalidadeAtividade");
            String cargaHoraria = request.getParameter("txtCargaHoraria");
            int vagasAtividade = Integer.parseInt(request.getParameter("txtVagasAtividade"));
            String nomeConvidado = request.getParameter("txtNomeConvidado");
            String emailConvidado = request.getParameter("txtEmailConvidado");
            String formacaoConvidado = request.getParameter("txtFormacaoConvidado");
            String origem = request.getParameter("txtOrigem");
            String informacoesComplementares = request.getParameter("txtInformacoesComplementares");
            int diaria = Integer.parseInt(request.getParameter("txtDiaria"));
            String estado = request.getParameter("txtEstado");
            String publico_alvo = request.getParameter("radioPublicoAlvo");
            int publico_todos = testCheck(request.getParameter("checkPublicoTodos"));
            int publico_informatica = testCheck(request.getParameter("checkInformatica"));
            int publico_edificacoes = testCheck(request.getParameter("checkEdificacoes"));
            int publico_eletromecanica = testCheck(request.getParameter("checkEletromecanica"));
            int publico_eletrotecnica = testCheck(request.getParameter("checkEletrotecnica"));
            int publico_mecanica = testCheck(request.getParameter("checkMecanica"));
            int publico_metalurgia = testCheck(request.getParameter("checkMetalurgia"));
            int publico_eventos = testCheck(request.getParameter("checkEventos"));
            int publico_secretariado = testCheck(request.getParameter("checkSecretariado"));
            int publico_designMoveis = testCheck(request.getParameter("checkDesignMoveis"));
            int publico_eletronica = testCheck(request.getParameter("checkEletronica"));
            int publico_transacoesImobiliarias = testCheck(request.getParameter("checkTransacoesImobiliarias"));
            int publico_trasporteFerroviario = testCheck(request.getParameter("checkTransporteFerroviario"));
            int publico_sistemasInformacao = testCheck(request.getParameter("checkSistemasInformacao"));
            int publico_engMecatronica = testCheck(request.getParameter("checkEngMecatronica"));
            int publico_engMetalurgica = testCheck(request.getParameter("checkEngMetalurgica"));
            int publico_fisica = testCheck(request.getParameter("checkFisica"));
            int segunda = testCheck(request.getParameter("checkSegunda"));
            int terca = testCheck(request.getParameter("checkTerca"));
            int quarta = testCheck(request.getParameter("checkQuarta"));
            int quinta = testCheck(request.getParameter("checkQuinta"));
            int sexta = testCheck(request.getParameter("checkSexta"));
            int sabado = testCheck(request.getParameter("checkSabado"));
            int idEvento = Integer.parseInt(request.getParameter("optEvento"));
            int idLocal = Integer.parseInt(request.getParameter("optLocal"));
            int idGerente = Integer.parseInt(request.getParameter("optGerente"));
            String dataInicio = request.getParameter("txtDataInicioProposta");
            String dataFim = request.getParameter("txtDataFimProposta");
            Gerente gerente = null;
            Evento evento = null;
            Local local = null;
            if (idGerente != 0) {
                gerente = GerenteDAO.getInstance().getGerente(idGerente);
            }
            if (idEvento != 0) {
                evento = EventoDAO.getInstance().getEvento(idEvento);
            }
            if (idLocal != 0) {
                local = LocalDAO.getInstance().getLocal(idLocal);
            }

            if (operacao.equals("incluir")) {
                proposta = new Proposta(idProposta, proponente, emailProponente, tipoAtividade, tituloAtividade, finalidadeAtividade, cargaHoraria, vagasAtividade, nomeConvidado, emailConvidado, formacaoConvidado, origem, informacoesComplementares, diaria, estado, publico_alvo, publico_todos, publico_informatica, publico_edificacoes, publico_eletromecanica, publico_eletrotecnica, publico_mecanica, publico_metalurgia, publico_eventos, publico_secretariado, publico_designMoveis, publico_eletronica, publico_transacoesImobiliarias, publico_trasporteFerroviario, publico_sistemasInformacao, publico_engMecatronica, publico_engMetalurgica, publico_fisica, segunda, terca, quarta, quinta, sexta, sabado, dataInicio, dataFim, gerente, local, evento);
                PropostaDAO.getInstance().salvar(proposta);
            } else if (operacao.equals("editar")) {
                proposta.setProponente(proponente);
                proposta.setEmailProponente(emailProponente);
                proposta.setTipoAtividade(tipoAtividade);
                proposta.setTituloAtividade(tituloAtividade);
                proposta.setFinalidadeAtividade(finalidadeAtividade);
                proposta.setCargaHoraria(cargaHoraria);
                proposta.setVagasAtividade(vagasAtividade);
                proposta.setNomeConvidado(nomeConvidado);
                proposta.setEmailConvidado(emailConvidado);
                proposta.setFormacaoConvidado(formacaoConvidado);
                proposta.setOrigem(origem);
                proposta.setInformacoesComplementares(informacoesComplementares);
                proposta.setDiaria(diaria);
                proposta.setEstado(estado);
                proposta.setPublicoAlvo(publico_alvo);
                proposta.setPublicoTodos(publico_todos);
                proposta.setPublicoInformatica(publico_informatica);
                proposta.setPublicoEdificacoes(publico_edificacoes);
                proposta.setPublicoEletromecanica(publico_eletromecanica);
                proposta.setPublicoEletrotecnica(publico_eletrotecnica);
                proposta.setPublicoMecanica(publico_mecanica);
                proposta.setPublicoMetalurgia(publico_metalurgia);
                proposta.setPublicoEventos(publico_eventos);
                proposta.setPublicoSecretariado(publico_secretariado);
                proposta.setPublicodesignMoveis(publico_designMoveis);
                proposta.setPublicoEletronica(publico_eletronica);
                proposta.setPublicotransacoesImobiliarias(publico_transacoesImobiliarias);
                proposta.setPublicotransporteFerroviario(publico_trasporteFerroviario);
                proposta.setPublicosistemasInformacao(publico_sistemasInformacao);
                proposta.setPublicoengMecatronica(publico_engMecatronica);
                proposta.setPublicoengMetalurgica(publico_engMetalurgica);
                proposta.setPublicoFisica(publico_fisica);
                proposta.setSegunda(segunda);
                proposta.setTerca(terca);
                proposta.setQuarta(quarta);
                proposta.setQuinta(quinta);
                proposta.setSexta(sexta);
                proposta.setSabado(sabado);
                proposta.setEvento(evento);
                proposta.setLocal(local);
                proposta.setGerente(gerente);
                proposta.setDataInicio(dataInicio);
                proposta.setDataFim(dataFim);
                PropostaDAO.getInstance().salvar(proposta);
            } else if (operacao.equals("excluir")) {
                PropostaDAO.getInstance().excluir(proposta);
            }
            RequestDispatcher view = request.getRequestDispatcher("PesquisarPropostaController");
            view.forward(request, response);

        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        }
    }

    public static int testCheck(String s) {
        if (s == null) {
            return 0;
        } else {
            return 1;
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        processRequest(request, response);

    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);

    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>
}
