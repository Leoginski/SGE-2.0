/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import modelo.Gerente;

/**
 *
 * @author Aluno
 */
public class GerenteDAO {

    public static List<Gerente> getAllGerentes() throws ClassNotFoundException {
        EntityManager em = dao.PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Gerente> gerentes = null;
        try {
            tx.begin();
            TypedQuery<Gerente> query = em.createQuery("select c from Gerente c", Gerente.class);
            gerentes = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            dao.PersistenceUtil.close(em);
        }

        return gerentes;
    }

    public static Gerente getGerente(int codGerente) throws ClassNotFoundException {
        EntityManager em = dao.PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Gerente gerente = null;
        try {
            tx.begin();
            gerente = em.find(Gerente.class, codGerente);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            dao.PersistenceUtil.close(em);
        }
        return gerente;
    }

    public static void salvar(Gerente gerente) {
        EntityManager em = dao.PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if (gerente.getCodGerente() != null) {
                em.merge(gerente);
            } else {
                em.persist(gerente);
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

    public static void excluir(Gerente gerente) {
        EntityManager em = dao.PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.getReference(Gerente.class, gerente.getCodGerente()));
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
