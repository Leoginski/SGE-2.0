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

/**
 *
 * @author Math
 */
@WebServlet(name = "ManterPropostaController", urlPatterns = {"/ManterPropostaController"})
public class ManterPropostaController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
  protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String acao = request.getParameter("acao");
        if(acao.equals("prepararIncluir")){
            prepararIncluir(request, response);
        }else{
            if(acao.equals("confirmarIncluir")){
                confirmarIncluir(request, response);
            }else{
                if(acao.equals("prepararEditar")){
                    prepararEditar(request, response);
                }else{
                    if(acao.equals("confirmarEditar")){
                        confirmarEditar(request, response);
                    }else{
                        if (acao.equals("prepararExcluir")){
                            prepararExcluir(request, response);
                        }else{
                            if(acao.equals("confirmarExcluir")){
                                confirmarExcluir(request, response);
                            }
                        }
                    }
                }
            }
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

    private void prepararIncluir(HttpServletRequest request, HttpServletResponse response) {
        try{
            request.setAttribute("operacao", "Incluir");
            request.setAttribute(("eventos"), Evento.obterEventos());
            request.setAttribute(("gerentes"), Gerente.obterGerentes());
            request.setAttribute(("locais"), Local.obterLocais());
            RequestDispatcher view = request.getRequestDispatcher("/manterProposta.jsp");
            view.forward(request, response);
        }catch(ServletException ex){
        }catch(IOException ex){
        }catch(ClassNotFoundException ex){
        }
    }

    private void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) throws ServletException {
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
       int segunda =testCheck(request.getParameter("checkSegunda"));
       int terca = testCheck(request.getParameter("checkTerca"));
       int quarta = testCheck(request.getParameter("checkQuarta"));
       int quinta = testCheck(request.getParameter("checkQuinta"));
       int sexta = testCheck(request.getParameter("checkSexta"));
       int sabado = testCheck(request.getParameter("checkSabado"));
       int idEvento =Integer.parseInt(request.getParameter("optEvento"));
       int idLocal =Integer.parseInt(request.getParameter("optLocal"));
       int idGerente =Integer.parseInt(request.getParameter("optGerente"));
       String dataInicio = request.getParameter("txtDataInicioProposta");
       String dataFim = request.getParameter("txtDataFimProposta");
       
       try{
           Evento evento = null;
           if(idEvento != 0){
               evento = Evento.obterEvento(idEvento);
           }
           Local local = null;
           if(idLocal != 0){
               local = Local.obterLocal(idLocal);
           }
           Gerente gerente = null;
           if(idGerente!= 0){
               gerente = Gerente.obterGerente(idGerente);
           }
            Proposta proposta = new Proposta(idProposta,proponente,emailProponente,tipoAtividade,tituloAtividade,finalidadeAtividade,cargaHoraria,vagasAtividade,nomeConvidado,emailConvidado,formacaoConvidado,origem,informacoesComplementares,diaria,estado,publico_alvo,publico_todos,publico_informatica,publico_edificacoes,publico_eletromecanica,publico_eletrotecnica,publico_mecanica,publico_metalurgia,publico_eventos,publico_secretariado,publico_designMoveis,publico_eletronica,publico_transacoesImobiliarias,publico_trasporteFerroviario,publico_sistemasInformacao,publico_engMecatronica,publico_engMetalurgica,publico_fisica,segunda,terca,quarta,quinta,sexta,sabado,idEvento,idLocal,idGerente,dataInicio,dataFim);
            proposta.gravar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaPropostaController");
            view.forward(request, response);
        }catch(IOException ex){
        }catch(SQLException ex){
        }catch(ClassNotFoundException ex){
        }catch(ServletException ex){
    }
    }

        private void prepararEditar(HttpServletRequest request, HttpServletResponse response) {
        try{
            request.setAttribute("operacao", "Editar");
            request.setAttribute(("eventos"), Evento.obterEventos());
            request.setAttribute(("gerentes"), Gerente.obterGerentes());
            request.setAttribute(("locais"), Local.obterLocais());
            int idProposta = Integer.parseInt(request.getParameter("idProposta"));
            Proposta proposta = Proposta.obterProposta(idProposta);
            request.setAttribute("proposta", proposta);
            RequestDispatcher view = request.getRequestDispatcher("/manterProposta.jsp");
            view.forward(request, response);
        }catch(ServletException ex){
        }catch(IOException ex){
        }catch(ClassNotFoundException ex){
        }
    }
    
    public static int testCheck(String s){
       if(s == null){
            return 0;
       }else{
           return 1;
       }
    }

    
    
        private void confirmarEditar(HttpServletRequest request, HttpServletResponse response) throws ServletException {
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
       int publico_todos = testCheck(request.getParameter("checkEdificacoes"));
       int publico_informatica = testCheck(request.getParameter("checkEdificacoes"));
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
       int segunda =testCheck(request.getParameter("checkSegunda"));
       int terca = testCheck(request.getParameter("checkTerca"));
       int quarta = testCheck(request.getParameter("checkQuarta"));
       int quinta = testCheck(request.getParameter("checkQuinta"));
       int sexta = testCheck(request.getParameter("checkSexta"));
       int sabado = testCheck(request.getParameter("checkSabado"));
       int idGerente = Integer.parseInt(request.getParameter("optGerente"));
       int idLocal = Integer.parseInt(request.getParameter("optLocal"));
       int idEvento = Integer.parseInt(request.getParameter("optEvento"));
       String dataInicio = request.getParameter("txtDataInicioProposta");
       String dataFim = request.getParameter("txtDataFimProposta");
       
       try{
           Evento evento = null;
           if(idEvento != 0){
               evento = Evento.obterEvento(idEvento);
           }
           Local local = null;
           if(idLocal != 0){
               local = Local.obterLocal(idLocal);
           }
           Gerente gerente = null;
           if(idGerente!= 0){
               gerente = Gerente.obterGerente(idGerente);
           }

            Proposta proposta = new Proposta(idProposta,proponente,emailProponente,tipoAtividade,tituloAtividade,finalidadeAtividade,cargaHoraria,vagasAtividade,nomeConvidado,emailConvidado,formacaoConvidado,origem,informacoesComplementares,diaria,estado,publico_alvo,publico_todos,publico_informatica,publico_edificacoes,publico_eletromecanica,publico_eletrotecnica,publico_mecanica,publico_metalurgia,publico_eventos,publico_secretariado,publico_designMoveis,publico_eletronica,publico_transacoesImobiliarias,publico_trasporteFerroviario,publico_sistemasInformacao,publico_engMecatronica,publico_engMetalurgica,publico_fisica,segunda,terca,quarta,quinta,sexta,sabado,idGerente,idLocal,idEvento,dataInicio,dataFim);
            proposta.alterar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaPropostaController");
            view.forward(request, response);
        }catch(IOException ex){
        }catch(SQLException ex){
        }catch(ClassNotFoundException ex){
        }catch(ServletException ex){
    }
}
        
        private void prepararExcluir(HttpServletRequest request, HttpServletResponse response) {
        try{
            request.setAttribute("operacao", "Excluir");
            request.setAttribute(("eventos"), Evento.obterEventos());
            request.setAttribute(("gerentes"), Gerente.obterGerentes());
            request.setAttribute(("locais"), Local.obterLocais());
            int idProposta = Integer.parseInt(request.getParameter("idProposta"));
            Proposta proposta = Proposta.obterProposta(idProposta);
            request.setAttribute("proposta", proposta);
            RequestDispatcher view = request.getRequestDispatcher("/manterProposta.jsp");
            view.forward(request, response);
        }catch(ServletException ex){
        }catch(IOException ex){
        }catch(ClassNotFoundException ex){
        }
    }
    
        private void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) throws ServletException {
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
       int publico_trasporteFerroviario = testCheck(request.getParameter("checkTrasnporteFerroviario"));
       int publico_sistemasInformacao = testCheck(request.getParameter("checkSistemasInformacao"));
       int publico_engMecatronica = testCheck(request.getParameter("checkEngMecatronica"));
       int publico_engMetalurgica = testCheck(request.getParameter("checkEngMetalurgica"));
       int publico_fisica = testCheck(request.getParameter("checkFisica"));
       int segunda =testCheck(request.getParameter("checkSegunda"));
       int terca = testCheck(request.getParameter("checkTerca"));
       int quarta = testCheck(request.getParameter("checkQuarta"));
       int quinta = testCheck(request.getParameter("checkQuinta"));
       int sexta = testCheck(request.getParameter("checkSexta"));
       int sabado = testCheck(request.getParameter("checkSabado"));
       int idEvento =Integer.parseInt(request.getParameter("optEvento"));
       int idLocal =Integer.parseInt(request.getParameter("optLocal"));
       int idGerente =Integer.parseInt(request.getParameter("optGerente"));
       String dataInicio = request.getParameter("txtDataInicioProposta");
       String dataFim = request.getParameter("txtDataFimProposta");
       
       try{
           Evento evento = null;
           if(idEvento != 0){
               evento = Evento.obterEvento(idEvento);
           }
           Local local = null;
           if(idLocal != 0){
               local = Local.obterLocal(idLocal);
           }
           Gerente gerente = null;
           if(idGerente!= 0){
               gerente = Gerente.obterGerente(idGerente);
           }

            Proposta proposta = new Proposta(idProposta,proponente,emailProponente,tipoAtividade,tituloAtividade,finalidadeAtividade,cargaHoraria,vagasAtividade,nomeConvidado,emailConvidado,formacaoConvidado,origem,informacoesComplementares,diaria,estado,publico_alvo,publico_todos,publico_informatica,publico_edificacoes,publico_eletromecanica,publico_eletrotecnica,publico_mecanica,publico_metalurgia,publico_eventos,publico_secretariado,publico_designMoveis,publico_eletronica,publico_transacoesImobiliarias,publico_trasporteFerroviario,publico_sistemasInformacao,publico_engMecatronica,publico_engMetalurgica,publico_fisica,segunda,terca,quarta,quinta,sexta,sabado,idEvento,idLocal,idGerente,dataInicio,dataFim);
            proposta.excluir();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaPropostaController");
            view.forward(request, response);
        }catch(IOException ex){
        }catch(SQLException ex){
        }catch(ClassNotFoundException ex){
        }catch(ServletException ex){
    }
}
        
}

    
    


