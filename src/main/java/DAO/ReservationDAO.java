package DAO;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;
import Model.Reservation;

import java.util.List;

public class ReservationDAO {
    private static final EntityManagerFactory emf =
            Persistence.createEntityManagerFactory("CampusPU");

    public void addReservation(Reservation reservation) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.persist(reservation);
        em.getTransaction().commit();
        em.close();
    }

    public Reservation getReservation(int id) {
        EntityManager em = emf.createEntityManager();
        Reservation r = em.find(Reservation.class, id);
        em.close();
        return r;
    }

    public List<Reservation> getAllReservations() {
        EntityManager em = emf.createEntityManager();
        List<Reservation> list = em.createQuery("SELECT r FROM Reservation r", Reservation.class).getResultList();
        em.close();
        return list;
    }

    public void updateReservation(Reservation reservation) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        em.merge(reservation);
        em.getTransaction().commit();
        em.close();
    }

    public void deleteReservation(int id) {
        EntityManager em = emf.createEntityManager();
        Reservation r = em.find(Reservation.class, id);
        em.getTransaction().begin();
        em.remove(r);
        em.getTransaction().commit();
        em.close();
    }
}
