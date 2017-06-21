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
import model.Administrador;
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

    public static List<Administrador> getAllAdministradores() {
        EntityManager em = PersistenceUtil.getEntityManager();
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
            PersistenceUtil.close(em);
        }
        return administradores;
    }
    
    public static Administrador getAdministrador(int codAdministrador){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Administrador administrador = new Administrador();
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
            PersistenceUtil.close(em);
        }
        return administrador;
    }
    
    
    public static void salvar(Administrador administrador){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if(administrador.getCodAdministrador()!=null){
                em.merge(administrador);
            }else{
                em.persist(administrador);
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
    
    
    
        public static void excluir(Administrador administrador){
        EntityManager em = PersistenceUtil.getEntityManager();
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
            PersistenceUtil.close(em);
        }
    }
    
    
}
    
