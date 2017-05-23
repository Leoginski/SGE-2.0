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
import modelo.Administrador;
//import org.apache.coyote.http11.Constants;

//**
// *
// * @author Leonardo
// */
public class AdministradorDAO {
    
     private static AdministradorDAO instance = new AdministradorDAO();

    public static AdministradorDAO getInstance() {
        return instance;
    }

    private AdministradorDAO() {
    }

    public static List<Administrador> obterTodosAdministradores() throws ClassNotFoundException {
        EntityManager em = dao.PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Administrador> administradores = null;
        try {
            tx.begin();
            TypedQuery<Administrador> query = em.createQuery("select c from Administrador c", Administrador.class);
            administradores = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            dao.PersistenceUtil.close(em);
        }
        return administradores;
    }
    
    public static void gravar(Administrador administrador) throws SQLException, ClassNotFoundException{
        EntityManager em = dao.PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.persist(administrador);
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
    
    public static Administrador obterAdministrador(int codAdministrador) throws ClassNotFoundException {
        EntityManager em = dao.PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Administrador administrador = null;
        try {
            tx.begin();
            administrador = em.find(Administrador.class, codAdministrador);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            dao.PersistenceUtil.close(em);
        }
        return administrador;
    }

    public static void alterar(Administrador administrador) throws SQLException, ClassNotFoundException{
        EntityManager em = dao.PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.merge(administrador);
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
    
        public static void excluir(Administrador administrador) throws SQLException, ClassNotFoundException{
        EntityManager em = dao.PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.getReference(Administrador.class, administrador.getCodAdministrador()));
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
    
