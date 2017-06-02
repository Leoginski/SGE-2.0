/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import modelo.Proposta;

/**
 *
 * @author Pc
 */
public class PropostaDAO {

    /**
     *
     * @return
     * @throws ClassNotFoundException
     */

    private static PropostaDAO instance = new PropostaDAO();

    public static PropostaDAO getInstance() {
        return instance;
    }

    
    public static List<Proposta> getAllPropostas(){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Proposta> propostas = null;
        try {
            tx.begin();
            TypedQuery<Proposta> query = em.createQuery("select c from Proposta c", Proposta.class);
            propostas = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        
        return propostas;
    }

    public static Proposta getProposta(int idProposta){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Proposta proposta = null;
        try {
            tx.begin();
            proposta = em.find(Proposta.class, idProposta);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return proposta;
    }
    
        public static void salvar(Proposta proposta) throws SQLException, ClassNotFoundException{
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if(proposta.getIdProposta()!=null){
                em.merge(proposta);
            }else{
                em.persist(proposta);
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
        
        public static void excluir(Proposta proposta){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.getReference(Proposta.class, proposta.getIdProposta()));
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
