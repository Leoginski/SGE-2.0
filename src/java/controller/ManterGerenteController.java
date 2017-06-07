/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.GerenteDAO;
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
import model.Gerente;

/**
 *
 * @author Math
 */
@WebServlet(name = "ManterGerenteController", urlPatterns = {"/ManterGerenteController"})
public class ManterGerenteController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private Gerente gerente;
    
protected void processRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, ClassNotFoundException{
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
            Logger.getLogger(ManterGerenteController.class.getName()).log(Level.SEVERE, null, ex);
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
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        try {
            processRequest(request, response);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(ManterGerenteController.class.getName()).log(Level.SEVERE, null, ex);
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

    
    private void prepararOperacao(HttpServletRequest request, HttpServletResponse response) throws ServletException, ClassNotFoundException {
         try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            //request.setAttribute("gerentes", GerenteDAO.getInstance().getAllGerentes());
            if (!operacao.equals("incluir")) {
                int codGerente = Integer.parseInt(request.getParameter("codGerente"));
                gerente = GerenteDAO.getInstance().getGerente(codGerente);
                //request.setAttribute("gerente", codGerente);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterGerente.jsp");
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
        int codGerente = Integer.parseInt(request.getParameter("txtCodGerente"));
        String nome = request.getParameter("txtNomeGerente");
        String email = request.getParameter("txtEmailGerente");
        String senha = request.getParameter("txtSenhaGerente");
        String dataNascimento = request.getParameter("txtDataNascimentoGerente");
        
        if(operacao.equals("incluir")){
            gerente = new Gerente(codGerente, nome, email, senha, dataNascimento);
            GerenteDAO.getInstance().salvar(gerente);
        } else if(operacao.equals("editar")){
            gerente.setCodGerente(codGerente);
            gerente.setNome(nome);
            gerente.setEmail(email);
            gerente.setSenha(senha);
            gerente.setDataNascimento(dataNascimento);
            GerenteDAO.getInstance().salvar(gerente);
        }else if(operacao.equals("excluir")){
            GerenteDAO.getInstance().excluir(gerente);
        }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaGerenteController");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        }
    }
}
