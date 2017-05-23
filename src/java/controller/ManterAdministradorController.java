/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
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
import modelo.Administrador;
/**
 *
 * @author Math
 */
@WebServlet(name = "ManterAdministradorController", urlPatterns = {"/ManterAdministradorController"})
public class ManterAdministradorController extends HttpServlet {

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

    private void prepararOperacao(HttpServletRequest request, HttpServletResponse response) {
        
         try {
            String operacao = request.getParameter("operacao");
            request.setAttribute("operacao", operacao);
            request.setAttribute("administradores", AdministradorDAO.getInstance().getAllProfessores());
            if (!operacao.equals("incluir")) {
                long codAdministrador = Long.parseLong(request.getParameter("codAdministrador"));
                administrador = AdministradorDAO.getInstance().getCurso(codAdministrador);
                request.setAttribute("administrador", codAdministrador);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterAdministrador.jsp");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        }
        }

    private void confirmarOperacao(HttpServletRequest request, HttpServletResponse response) {
        int codAdministrador = Integer.parseInt(request.getParameter("txtCodAdministrador"));
        String nome = request.getParameter("txtNomeAdministrador");
        String email = request.getParameter("txtEmailAdministrador");
        String senha = request.getParameter("txtSenhaAdministrador");
        String dataNascimento = request.getParameter("txtDataNascimentoAdministrador");
        try{
            Administrador administrador = new Administrador(codAdministrador, nome, email, senha, dataNascimento);
            administrador.gravar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaAdministradorController");
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
            //request.setAttribute("professores"), Professor.obterProfessores();
            int codAdministrador = Integer.parseInt(request.getParameter("codAdministrador"));
            Administrador administrador = Administrador.obterAdministrador(codAdministrador);
            request.setAttribute("administrador", administrador);
            RequestDispatcher view = request.getRequestDispatcher("/manterAdministrador.jsp");
            view.forward(request, response);
        }catch(ServletException ex){
        }catch(IOException ex){
        }catch(ClassNotFoundException ex){
        }
    }
    
    private void confirmarEditar(HttpServletRequest request, HttpServletResponse response) {
        int codAdministrador = Integer.parseInt(request.getParameter("txtCodAdministrador"));
        String nome = request.getParameter("txtNomeAdministrador");
        String email = request.getParameter("txtEmailAdministrador");
        String senha = request.getParameter("txtSenhaAdministrador");
        String dataNascimento = request.getParameter("txtDataNascimentoAdministrador");
        try{
            Administrador administrador = new Administrador(codAdministrador, nome, email, senha, dataNascimento);
            administrador.alterar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaAdministradorController");
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
            //request.setAttribute("professores"), Professor.obterProfessores();
            int codAdministrador = Integer.parseInt(request.getParameter("codAdministrador"));
            Administrador administrador = Administrador.obterAdministrador(codAdministrador);
            request.setAttribute("administrador", administrador);
            RequestDispatcher view = request.getRequestDispatcher("/manterAdministrador.jsp");
            view.forward(request, response);
        }catch(ServletException ex){
        }catch(IOException ex){
        }catch(ClassNotFoundException ex){
        }
    }
    
    private void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) {
        int codAdministrador = Integer.parseInt(request.getParameter("txtCodAdministrador"));
        String nome = request.getParameter("txtNomeAdministrador");
        String email = request.getParameter("txtEmailAdministrador");
        String senha = request.getParameter("txtSenhaAdministrador");
        String dataNascimento = request.getParameter("txtDataNascimentoAdministrador");
        try{
            Administrador administrador = new Administrador(codAdministrador, nome, email, senha, dataNascimento);
            administrador.excluir();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaAdministradorController");
            view.forward(request, response);
        }catch(IOException ex){
        }catch(SQLException ex){
        }catch(ClassNotFoundException ex){
        }catch(ServletException ex){
    }
    }
    
}
