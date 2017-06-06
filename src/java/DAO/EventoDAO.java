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

import model.Evento;

/**
 *
 * @author Aluno
 */
public class EventoDAO {

    
    private static final EventoDAO instance = new EventoDAO();

    public static EventoDAO getInstance() {
        return instance;
    }

    private EventoDAO() {
    }
    
    public static List<Evento> getAllEventos(){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Evento> eventos = null;
        try {
            tx.begin();
            TypedQuery<Evento> query = em.createQuery("select c from Evento c", Evento.class);
            eventos = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return eventos;
    }

    public static Evento getEvento(int idEvento){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Evento evento = null;
        try {
            tx.begin();
            evento = em.find(Evento.class, idEvento);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return evento;
    }
    
    

    public static void salvar(Evento evento) throws SQLException, ClassNotFoundException{
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if(evento.getIdEvento()!=null){
                em.merge(evento);
            }else{
                em.persist(evento);
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
    
    public static void excluir(Evento evento) throws SQLException, ClassNotFoundException{
    EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.getReference(Evento.class, evento.getIdEvento()));
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
