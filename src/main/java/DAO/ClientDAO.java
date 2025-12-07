package DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import Model.Client;
import java.util.List;

public class ClientDAO {

    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("CampusPU");

    // Méthode utilitaire pour avoir un EntityManager propre
    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }

    public void addClient(Client client) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.persist(client);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public Client getClient(int id) {
        EntityManager em = emf.createEntityManager();
        try {
            return em.find(Client.class, id);
        } finally {
            em.close();
        }
    }

    public List<Client> getAllClients() {
        EntityManager em = getEntityManager();
        try {
            return em.createQuery("SELECT c FROM Client c", Client.class)
                    .getResultList();
        } finally {
            em.close();
        }
    }

    public void updateClient(Client client) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            em.merge(client);
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

    public void deleteClient(int id) {
        EntityManager em = getEntityManager();
        try {
            em.getTransaction().begin();
            Client c = em.find(Client.class, id);
            if (c != null) {
                em.remove(c);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) em.getTransaction().rollback();
            throw e;
        } finally {
            em.close();
        }
    }

}