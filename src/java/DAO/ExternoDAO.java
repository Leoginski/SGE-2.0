/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import exception.ErroSistema;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;
import model.Aluno;
import model.Externo;

/**
 *
 * @author Aluno
 */
public class ExternoDAO implements CrudDAO<Externo> {

    private static ExternoDAO instance = new ExternoDAO();

    public static ExternoDAO getInstance() {
        return instance;
    }

    public ExternoDAO(){
    }
    
    public static List<Externo> getAllExternos() {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Externo> externos = null;
        try {
            tx.begin();
            TypedQuery<Externo> query = em.createQuery("select c from Externo c", Externo.class);
            externos = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return externos;
    }

    public static Externo getExterno(int idExterno) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Externo externo = null;
        try {
            tx.begin();
            externo = em.find(Externo.class, idExterno);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return externo;
    }

    @Override
    public void salvar(Externo externo) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if (externo.getIdExterno() != null) {
                em.merge(externo);
            } else {
                em.persist(externo);
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
    public void excluir(Externo externo) {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.getReference(Externo.class, externo.getIdExterno()));
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
    public List<Externo> buscar() throws ErroSistema {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Externo> externos = null;
        try {
            tx.begin();
            TypedQuery<Externo> query = em.createQuery("select c from Externo c", Externo.class);
            externos = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return externos;
    }

}
