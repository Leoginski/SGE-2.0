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
import model.Galeria;
import model.Galeria;

/**
 *
 * @author Aluno
 */
public class GaleriaDAO {
    
    private static GaleriaDAO instance = new GaleriaDAO();

    public static GaleriaDAO getInstance() {
        return instance;
    }

    private GaleriaDAO() {
    }
    

    public static List<Galeria> getAllGalerias(){
            EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Galeria> galerias = null;
        try {
            tx.begin();
            TypedQuery<Galeria> query = em.createQuery("select c from Galeria c", Galeria.class);
            galerias = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return galerias;
    }
    
    public static Galeria getGaleria(int idGaleria){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Galeria galeria = null;
        try {
            tx.begin();
            galeria = em.find(Galeria.class, idGaleria);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return galeria;
    }

    public static void salvar(Galeria galeria) throws SQLException, ClassNotFoundException{
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if(galeria.getIdGaleria()!=null){
                em.merge(galeria);
            }else{
                em.persist(galeria);
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
    
    public static void excluir(Galeria galeria){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.getReference(Galeria.class, galeria.getIdGaleria()));
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