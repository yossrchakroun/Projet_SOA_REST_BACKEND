package DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import Model.Chambre;

import java.util.List;

public class ChambreDAO {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("CampusPU");

    public void addChambre(Chambre chambre) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(chambre);
        em.getTransaction().commit();
        em.close();
    }

    public Chambre getChambre(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Chambre.class, id);
        } finally {
            em.close();
        }
    }
    public List<Chambre> getAllChambres() {
        EntityManager em = emf.createEntityManager();
        List<Chambre> list = em.createQuery("SELECT c FROM Chambre c", Chambre.class).getResultList();
        em.close();
        return list;
    }

    public void updateChambre(Chambre chambre) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(chambre);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteChambre(int id) {
        EntityManager em = emf.createEntityManager();
        Chambre c = em.find(Chambre.class, id);
        em.getTransaction().begin();
        em.remove(c);
        em.getTransaction().commit();
        em.close();
    }
}
