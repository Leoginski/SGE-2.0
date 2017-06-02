/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.AlunoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import model.Administrador;
import model.Aluno;

/**
 *
 * @author Math
 */
@WebServlet(name = "ManterAlunoController", urlPatterns = {"/ManterAlunoController"})
public class ManterAlunoController extends HttpServlet {

        private Aluno aluno;
    
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
            //request.setAttribute("alunos", AlunoDAO.getInstance().getAllAlunos());
            if (!operacao.equals("incluir")) {
                int idAluno = Integer.parseInt(request.getParameter("idAluno"));
                aluno = AlunoDAO.getInstance().getAluno(idAluno);
                //request.setAttribute("aluno", idAluno);
            }
            RequestDispatcher view = request.getRequestDispatcher("/manterAluno.jsp");
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
        int idAluno = Integer.parseInt(request.getParameter("txtIdAluno"));
        String nome = request.getParameter("txtNomeAluno");
        String email = request.getParameter("txtEmailAluno");
        String dataNascimento = request.getParameter("txtDataNascimentoAluno");
        String senha = request.getParameter("txtSenhaAluno");
        
        if(operacao.equals("incluir")){
            aluno = new Aluno(idAluno, nome, email, senha, dataNascimento);
            AlunoDAO.getInstance().salvar(aluno);
        } else if(operacao.equals("editar")){
            aluno.setIdAluno(idAluno);
            aluno.setNome(nome);
            aluno.setEmail(email);
            aluno.setSenha(senha);
            aluno.setDataNascimento(dataNascimento);
            AlunoDAO.getInstance().salvar(aluno);
        }else if(operacao.equals("excluir")){
            AlunoDAO.getInstance().excluir(aluno);
        }
            RequestDispatcher view = request.getRequestDispatcher("PesquisaAlunoController");
            view.forward(request, response);
        } catch (ServletException e) {
            throw e;
        } catch (IOException e) {
            throw new ServletException(e);
        }
    }
}