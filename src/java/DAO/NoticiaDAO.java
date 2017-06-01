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
import modelo.Noticia;
import modelo.Noticia;

/**
 *
 * @author Math
 */
public class NoticiaDAO {

     private static NoticiaDAO instance = new NoticiaDAO();

    public static NoticiaDAO getInstance() {
        return instance;
    }

    private NoticiaDAO() {
    }
    
    
    public static List<Noticia> getAllNoticias() throws ClassNotFoundException {
        EntityManager em = dao.PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Noticia> noticias = null;
        try {
            tx.begin();
            TypedQuery<Noticia> query = em.createQuery("select c from Noticia c", Noticia.class);
            noticias = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            dao.PersistenceUtil.close(em);
        }
        return noticias;
    }

    public static Noticia getNoticia(int idNoticia) {
        EntityManager em = dao.PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Noticia noticia = null;
        try {
            tx.begin();
            noticia = em.find(Noticia.class, idNoticia);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            dao.PersistenceUtil.close(em);
        }
        return noticia;
    }
    
    public static void salvar(Noticia noticia){
        EntityManager em = dao.PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if(noticia.getIdNoticia()!=null){
                em.merge(noticia);
            }else{
                em.persist(noticia);
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

public static void excluir(Noticia noticia){
        EntityManager em = dao.PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.getReference(Noticia.class, noticia.getIdNoticia()));
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
