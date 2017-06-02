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
import modelo.Album;

/**
 *
 * @author Aluno
 */
public class AlbumDAO {

     private static AlbumDAO instance = new AlbumDAO();

    public static AlbumDAO getInstance() {
        return instance;
    }

    private AlbumDAO() {
    }

    public static List<Album> getAllAlbuns() {
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        List<Album> albuns = null;
        try {
            tx.begin();
            TypedQuery<Album> query = em.createQuery("select c from Album c", Album.class);
            albuns = query.getResultList();
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return albuns;
    }
    
    public static Album getAlbum(int idAlbum){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        Album album = null;
        try {
            tx.begin();
            album = em.find(Album.class, idAlbum);
            tx.commit();
        } catch (Exception e) {
            if (tx != null && tx.isActive()) {
                tx.rollback();
            }
            throw new RuntimeException(e);
        } finally {
            PersistenceUtil.close(em);
        }
        return album;
    }
    
    
    public static void salvar(Album album){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            if(album.getIdAlbum()!=null){
                em.merge(album);
            }else{
                em.persist(album);
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
    
    
    
        public static void excluir(Album album){
        EntityManager em = PersistenceUtil.getEntityManager();
        EntityTransaction tx = em.getTransaction();
        try {
            tx.begin();
            em.remove(em.getReference(Album.class, album.getIdAlbum()));
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
