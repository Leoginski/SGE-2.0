/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import exception.ErroSistema;
import java.sql.SQLException;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import model.Proposta;

/**
 *
 * @author Pc
 */
public class PropostaDAO implements CrudDAO<Proposta> {

    /**
     *
     * @return @throws ClassNotFoundException
     */
    private static PropostaDAO instance = new PropostaDAO();

    public static PropostaDAO getInstance() {
        return instance;
    }

    public PropostaDAO() {

    }

    public static List<Proposta> getAllPropostas() {
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

    public static Proposta getProposta(int idProposta) {
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

    @Override
    public void salvar(Proposta proposta) {
        EntityManager em = PersistenceUtil.getEntityManager();
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
            PersistenceUtil.close(em);
        }
    }

    @Override
    public void excluir(Proposta proposta) {
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

    @Override
    public List<Proposta> buscar() throws ErroSistema {
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

}
