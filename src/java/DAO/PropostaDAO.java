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

    private static PropostaDAO instance = new PropostaDAO();

    public static PropostaDAO getInstance() {
        return instance;
    }

    private PropostaDAO() {
    }

    public void salvar(Proposta proposta) {
        EntityManager em = dao.PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if (proposta.getIdProposta() != null) {
                em.merge(proposta);
            } else {
                em.persist(proposta);
            }
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            dao.PersistenceUtil.close(em);
        }
    }

    public List<Proposta> getAllPropostas() {
        EntityManager em = dao.PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Proposta> propostas = null;
        try {
            tx.begin();
            TypedQuery<Proposta> query = em.createQuery("select p from Proposta p", Proposta.class);
            propostas = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            dao.PersistenceUtil.close(em);
        }
        return propostas;
    }

    public Proposta getProposta(int id) {
        EntityManager em = dao.PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Proposta proposta = null;
        try {
            tx.begin();
            proposta = em.find(Proposta.class, id);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            dao.PersistenceUtil.close(em);
        }
        return proposta;
    }

    public void excluir(Proposta proposta) {
        EntityManager em = dao.PersistenceUtil.getEntityManager();
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
            dao.PersistenceUtil.close(em);
        }
    }
}
