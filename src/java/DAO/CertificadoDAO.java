/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import model.Certificado;

/**
 *
 * @author Aluno
 */
public class CertificadoDAO {

     private static CertificadoDAO instance = new CertificadoDAO();

    public static CertificadoDAO getInstance() {
        return instance;
    }

    private CertificadoDAO() {
    }

    public static List<Certificado> getAllCertificadoes() {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Certificado> certificados = null;
        try {
            tx.begin();
            TypedQuery<Certificado> query = em.createQuery("select c from Certificado c", Certificado.class);
            certificados = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return certificados;
    }
    
    public static Certificado getCertificado(int codCertificado){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Certificado certificador = null;
        try {
            tx.begin();
            certificador = em.find(Certificado.class, codCertificado);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return certificador;
    }
    
    
    public static void salvar(Certificado certificador){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if(certificador.getCodAutencidade()!=null){
                em.merge(certificador);
            }else{
                em.persist(certificador);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
    }
    
    
    
        public static void excluir(Certificado certificador){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.getReference(Certificado.class, certificador.getCodAutencidade()));
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
    }
    
}
