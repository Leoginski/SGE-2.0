/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.EventoDAO;
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

/**
 *
 * @author Math
 */
@WebServlet(name = "ManterEventoController", urlPatterns = {"/ManterEventoController"})
public class ManterEventoController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
      private Evento evento;
    
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

    
    private void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException {
         try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("eventos", EventoDAO.getInstance().getAllEventos());
            if (!operacao.equals("incluir")) {
                int codEvento = Integer.parseInt(request.getParameter("idEvento"));
                evento = EventoDAO.getInstance().getEvento(codEvento);
                request.setAttribute("evento", codEvento);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterEvento.jsp");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        }
        }

    private void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try{
        String operacao = request.getParameter("operacao");
        int idEvento = Integer.parseInt(request.getParameter("txtIdEvento"));
        String nomeEvento = request.getParameter("txtNomeEvento");
        String duracao = request.getParameter("txtDuracaoEvento");
        String tema = request.getParameter("txtTemaEvento");
        String dataInicioEvento = request.getParameter("txtDataInicioEvento");
        String dataFimEvento = request.getParameter("txtDataFimEvento");
        String dataInicioInscricao = request.getParameter("txtDataInicioInscricao");
        String dataFimInscricao = request.getParameter("txtDataFimInscricao");
        
        if(operacao.equals("incluir")){
            evento = new Evento(idEvento, nomeEvento, duracao, tema, dataInicioEvento, dataFimEvento, dataInicioInscricao, dataFimInscricao,);
            EventoDAO.getInstance().salvar(evento);
        } else if(operacao.equals("editar")){
            evento.setIdEvento(idEvento);
            evento.setNomeEvento(nomeEvento);
            evento.setDuracao(duracao);
            evento.setTema(tema);
            evento.setDataInicioEvento(dataInicioEvento);
            evento.setDataFimEvento(dataFimEvento);
            evento.setDataInicioInscricao(dataInicioInscricao);
            evento.setDataFimInscricao(dataFimInscricao);
            EventoDAO.getInstance().salvar(evento);
        }else if(operacao.equals("excluir")){
            EventoDAO.getInstance().excluir(evento);
        }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaEventoController");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        }
    }

    

}

