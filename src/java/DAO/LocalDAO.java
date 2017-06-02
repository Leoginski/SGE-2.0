    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;


import java.sql.SQLException;
import java.sql.Statement;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.TypedQuery;

import modelo.Local;

/**
 *
 * @author Aluno
 */
public class LocalDAO {
    
     private static LocalDAO instance = new LocalDAO();

    public static LocalDAO getInstance() {
        return instance;
    }
    
        private LocalDAO() {
    }

    public static List<Local> getAllLocais() throws ClassNotFoundException {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Local> locais = null;
        try {
            tx.begin();
            TypedQuery<Local> query = em.createQuery("select c from Local c", Local.class);
            locais = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return locais;
    }
    
    public static Local getLocal(int idLocal) throws ClassNotFoundException {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Local local = null;
        try {
            tx.begin();
            local = em.find(Local.class, idLocal);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return local;
    }

    public static void salvar(Local local) throws SQLException, ClassNotFoundException{
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if(local.getIdLocal()!=null){
                em.merge(local);
            }else{
                em.persist(local);
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
    
    
    
        public static void excluir(Local local) throws SQLException, ClassNotFoundException{
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.getReference(Local.class, local.getIdLocal()));
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
