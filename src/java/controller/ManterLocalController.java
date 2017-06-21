/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.LocalDAO;
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
import model.Local;

/**
 *
 * @author Math
 */
@WebServlet(name = "ManterLocalController", urlPatterns = {"/ManterLocalController"})
public class ManterLocalController extends HttpServlet {

    private Local local;
    
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
        
        private void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, ClassNotFoundException{
         try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            //request.setAttribute("gerentes", LocalDAO.getInstance().getAllLocais());
            if (!operacao.equals("incluir")) {
                int idLocal = Integer.parseInt(request.getParameter("idLocal"));
                local = LocalDAO.getInstance().getLocal(idLocal);
                request.setAttribute("local", local);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterLocal.jsp");
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
        int idLocal = Integer.parseInt(request.getParameter("txtIdLocal"));
        String descricao = request.getParameter("txtDescricaoLocal");
        int capacidade = Integer.parseInt(request.getParameter("txtCapacidadeLocal")); 
        
        if(operacao.equals("incluir")){
            local = new Local(idLocal, descricao,capacidade);
            LocalDAO.getInstance().salvar(local);
        } else if(operacao.equals("editar")){
            local.setDescricao(descricao);
            local.setCapacidade(capacidade);
            LocalDAO.getInstance().salvar(local);
        }else if(operacao.equals("excluir")){
            LocalDAO.getInstance().excluir(local);
        }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaLocalController");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        }
    }
    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">

    /**
     * Handles the HTTP
     * <code>GET</code> method.
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
            Logger.getLogger(ManterLocalController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterLocalController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Handles the HTTP
     * <code>POST</code> method.
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
            Logger.getLogger(ManterLocalController.class.getName()).log(Level.SEVERE, null, ex);
        } catch (SQLException ex) {
            Logger.getLogger(ManterLocalController.class.getName()).log(Level.SEVERE, null, ex);
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
}
