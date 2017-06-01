/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.EventoDAO;
import DAO.NoticiaDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Evento;
import modelo.Noticia;

/**
 *
 * @author Math
 */
@WebServlet(name = "ManterNoticiaController", urlPatterns = {"/ManterNoticiaController"})
public class ManterNoticiaController extends HttpServlet {

    private Noticia noticia;
    
    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException, SQLException{
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterNoticiaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterNoticiaController.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterNoticiaController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterNoticiaController.class.getName()).log(Level.SEVERE, null, ex);
        }
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

    
    private void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, ClassNotFoundException{
         try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            //request.setAttribute("gerentes", LocalDAO.getInstance().getAllLocais());
            if (!operacao.equals("incluir")) {
                int idNoticia = Integer.parseInt(request.getParameter("idNoticia"));
                noticia = NoticiaDAO.getInstance().getNoticia(idNoticia);
                request.setAttribute("noticia", noticia);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterNoticia.jsp");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        }
        }

    private void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException, SQLException, ClassNotFoundException{
        try{
        String operacao = request.getParameter("operacao");
        int idNoticia = Integer.parseInt(request.getParameter("txtIdNoticia"));
        String data = request.getParameter("txtDataNoticia");
        String descricao = request.getParameter("txtDescricaoNoticia");
        //int idEvento = Integer.parseInt(request.getParameter("optEvento"));
         int idEvento = Integer.parseInt(request.getParameter("evento"));
            
            Evento evento = null;
            if (idEvento != 0) {
                evento = EventoDAO.getInstance().getEvento(idEvento);
            }
        
        if(operacao.equals("incluir")){
            noticia = new Noticia(idNoticia, data, descricao, evento);
            NoticiaDAO.getInstance().salvar(noticia);
        } else if(operacao.equals("editar")){
            noticia.setData(data);
            noticia.setDescricao(descricao);
            noticia.setEventoidEvento(evento);
        }else if(operacao.equals("excluir")){
            NoticiaDAO.getInstance().excluir(noticia);
        }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaNoticiaController");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        }
    }
    
}