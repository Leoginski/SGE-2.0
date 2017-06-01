/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.ExternoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import modelo.Externo;

/**
 *
 * @author Math
 */
@WebServlet(name = "ManterExternoController", urlPatterns = {"/ManterExternoController"})
public class ManterExternoController extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    
    private Externo externo;
    
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
            //request.setAttribute("administradores", AdministradorDAO.getInstance().obterTodosAdministradores());
            if (!operacao.equals("incluir")) {
                int idExterno = Integer.parseInt(request.getParameter("idExterno"));
                externo = ExternoDAO.getInstance().getExterno(idExterno);
                //request.setAttribute("administrador", codAdministrador);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterExterno.jsp");
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
        int idExterno = Integer.parseInt(request.getParameter("txtIdExterno"));
        String conhecimento = request.getParameter("txtConhecimentoExterno");
        String nome = request.getParameter("txtNomeExterno");
        String email = request.getParameter("txtEmailExterno");
        String dataNascimento = request.getParameter("txtDataNascimentoExterno");
        String senha = request.getParameter("txtSenhaExterno");        
        
        if(operacao.equals("incluir")){
            externo = new Externo(idExterno, conhecimento, nome, email, dataNascimento, senha);
            ExternoDAO.getInstance().salvar(externo);
        } else if(operacao.equals("editar")){
            externo.setIdExterno(idExterno);
            externo.setConhecimento(conhecimento);
            externo.setNome(nome);
            externo.setEmail(email);
            externo.setDataNascimento(dataNascimento);
            externo.setSenha(senha);
            ExternoDAO.getInstance().salvar(externo);
        }else if(operacao.equals("excluir")){
            ExternoDAO.getInstance().excluir(externo);
        }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaAdministradorController");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        }
    }
    
}
//}
