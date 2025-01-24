package com.xworkz.gym.repository;

import com.xworkz.gym.Entity.RegisterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    @Autowired
    private EntityManagerFactory emf;

    @Override
    public RegisterEntity getName(String email, String password) {
        EntityManager em = emf.createEntityManager();
        try {
            String queryStr = "SELECT p FROM RegisterEntity p WHERE p.email = :emailBy";
            Query query = em.createQuery(queryStr);
            query.setParameter("emailBy", email);
            List<RegisterEntity> result = query.getResultList();

            if (result != null && !result.isEmpty()) {
                return result.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return null;
    }

    @Override
    public RegisterEntity getEmail(String email) {
        EntityManager em = emf.createEntityManager();
        try {
            Query query = em.createNamedQuery("getAllByEmail");
            query.setParameter("byEmail", email);
            List<RegisterEntity> result = query.getResultList();

            if (!result.isEmpty()) {
                return result.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return null;
    }

    @Override
    public void updateCount(String email, int count) {
        int result = count + 1; // Increment the count
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.createNamedQuery("updateCount")
                    .setParameter("setLoginCount", result)
                    .setParameter("byEmail", email)
                    .executeUpdate();
            et.commit();
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
    }


    @Override
    public boolean loginCount(String email, int count) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        int value = 0;
        try {
            et.begin();
            value = em.createNamedQuery("resetCount")
                    .setParameter("setLoginCount", 0)
                    .setParameter("byEmail", email)
                    .executeUpdate();
            et.commit();
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
        return value > 0;
    }

    @Override
    public String updateLockedAccountTimeByEmail(String email) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            Query query = em.createNamedQuery("accountLockedTimeByEmail");
            query.setParameter("accountLockedTimeBy", LocalDateTime.now());
            query.setParameter("emailBy", email);
            int value = query.executeUpdate();
            et.commit();

            if (value > 0) {
                return "Account lock time is set";
            }
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
        return "Failed to set account lock time";
    }
}
