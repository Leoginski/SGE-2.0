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
import modelo.Aluno;

/**
 *
 * @author Math
 */
@WebServlet(name = "ManterAlunoController", urlPatterns = {"/ManterAlunoController"})
public class ManterAlunoController extends HttpServlet {

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
            //request.setAttribute("professores"), Professor.obterProfessores();
            RequestDispatcher view = request.getRequestDispatcher("/manterAluno.jsp");
            view.forward(request, response);
        }catch(ServletException ex){
        }catch(IOException ex){
        }//catch(ClassNotFoundException ex){
        }

    private void confirmarIncluir(HttpServletRequest request, HttpServletResponse response) throws ServletException {
        int idAluno = Integer.parseInt(request.getParameter("txtIdAluno"));
        String nome = request.getParameter("txtNomeAluno");
        String email = request.getParameter("txtEmailAluno");
        String dataNascimento = request.getParameter("txtDataNascimentoAluno");
        String senha = request.getParameter("txtSenhaAluno");
        
        
        //se tiver uma comboBox
        //int coordenador = Integer.parseInt(request.getParameter(optCoordenador);
        try{
//            Professor professor = null;
//            if(coordenador != 0){
//                professor = Professor.obterProfessor(coodenador);
            //}
            Aluno aluno = new Aluno(idAluno, nome, email, dataNascimento, senha);
            aluno.gravar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaAlunoController");
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
            int idAluno = Integer.parseInt(request.getParameter("idAluno"));
            Aluno aluno = Aluno.obterAluno(idAluno);
            request.setAttribute("aluno", aluno);
            RequestDispatcher view = request.getRequestDispatcher("/manterAluno.jsp");
            view.forward(request, response);
        }catch(ServletException ex){
        }catch(IOException ex){
        }catch(ClassNotFoundException ex){
        }{
    }
    }

    private void confirmarEditar(HttpServletRequest request, HttpServletResponse response) {
        int idAluno = Integer.parseInt(request.getParameter("txtIdAluno"));
        String nome = request.getParameter("txtNomeAluno");
        String email = request.getParameter("txtEmailAluno");
        String dataNascimento = request.getParameter("txtDataNascimentoAluno");
        String senha = request.getParameter("txtSenhaAluno");
        //se tiver uma comboBox
        //int coordenador = Integer.parseInt(request.getParameter(optCoordenador);
        try{
//            Professor professor = null;
//            if(coordenador != 0){
//                professor = Professor.obterProfessor(coodenador);
            //}
            Aluno aluno = new Aluno(idAluno, nome, email, dataNascimento, senha);
            aluno.alterar();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaAlunoController");
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
            int idAluno = Integer.parseInt(request.getParameter("idAluno"));
            Aluno aluno = Aluno.obterAluno(idAluno);
            request.setAttribute("aluno", aluno);
            RequestDispatcher view = request.getRequestDispatcher("/manterAluno.jsp");
            view.forward(request, response);
        }catch(ServletException ex){
        }catch(IOException ex){
        }catch(ClassNotFoundException ex){
        }{
    }
    }

    private void confirmarExcluir(HttpServletRequest request, HttpServletResponse response) {
        int idAluno = Integer.parseInt(request.getParameter("txtIdAluno"));
        String nome = request.getParameter("txtNomeAluno");
        String email = request.getParameter("txtEmailAluno");
        String dataNascimento = request.getParameter("txtDataNascimentoAluno");
        String senha = request.getParameter("txtSenhaAluno");
        //se tiver uma comboBox
        //int coordenador = Integer.parseInt(request.getParameter(optCoordenador);
        try{
//            Professor professor = null;
//            if(coordenador != 0){
//                professor = Professor.obterProfessor(coodenador);
            //}
            Aluno aluno = new Aluno(idAluno, nome, email, dataNascimento, senha);
            aluno.excluir();
            RequestDispatcher view = request.getRequestDispatcher("PesquisaAlunoController");
            view.forward(request, response);
        }catch(IOException ex){
        }catch(SQLException ex){
        }catch(ClassNotFoundException ex){
        }catch(ServletException ex){
    }
    }

}