/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import DAO.BD;
import DAO.ExternoDAO;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperExportManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;

/**
 *
 * @author Math
 */
@WebServlet(name = "RelatorioExternoController", urlPatterns = {"/RelatorioExternoController"})
public class RelatorioExternoController extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        
        String acao = request.getParameter("acao");
        if(acao.equals("prepararRelatorio")){
            prepararRelatorio(request, response);
        }else{
            if(acao.equals("exibirRelatorio")){
                exibirRelatorio(request, response);
            }
        }
        }
        private void exibirRelatorio(HttpServletRequest request, HttpServletResponse response) throws SQLException {
        Connection conexao = null;
        try {
            conexao = BD.getConexao();
            String nomeRelatorio = "Externo";
            String pConhecimento = request.getParameter("formaConhecimento");
            HashMap parametros = new HashMap();
            String relatorio = null;

            if (pConhecimento != null && !pConhecimento.equals("")) {
                parametros.put("P_Conhecimento", pConhecimento);
                relatorio = getServletContext().getRealPath("/WEB-INF/reports") + "/report" + nomeRelatorio + "Parametro.jasper";
                response.setHeader("Content-Disposition", "attachment;filename=Relatorio" + nomeRelatorio + "Parametro.pdf");

            } else {
                relatorio = getServletContext().getRealPath("/WEB-INF/reports") + "/report" + nomeRelatorio + ".jasper";
                response.setHeader("Content-Disposition", "attachment;filename=Relatorio" + nomeRelatorio + ".pdf");
            }

            JasperPrint jp = JasperFillManager.fillReport(relatorio, parametros, conexao);
            byte[] relat = JasperExportManager.exportReportToPdf(jp);
            response.setContentType("application/pdf");
            response.getOutputStream().write(relat);

        } catch (IOException | ClassNotFoundException | SQLException | JRException ex) {
            ex.printStackTrace();
        } finally {
            BD.fecharConexao(conexao);
        }
    }

        
        private void prepararRelatorio(HttpServletRequest request, HttpServletResponse response) {
        try{
            request.setAttribute("operacao", "Imprimir");
            request.setAttribute("externos", ExternoDAO.getAllExternos());
            RequestDispatcher view = request.getRequestDispatcher("/relatorioExterno.jsp");
            view.forward(request, response);
        }catch(ServletException ex){
        }catch(IOException ex){
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
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioExternoController.class.getName()).log(Level.SEVERE, null, ex);
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
        } catch (SQLException ex) {
            Logger.getLogger(RelatorioExternoController.class.getName()).log(Level.SEVERE, null, ex);
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
