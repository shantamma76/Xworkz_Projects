package com.xworkz.gym.repository;

import com.xworkz.gym.Entity.EnquiryEntity;


import com.xworkz.gym.Entity.GymEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.util.Collections;
import java.util.List;

@Repository
public class GymRepositoryImpl implements GymRepository {

    @Autowired
    EntityManagerFactory emf;

    @Override
    public boolean getNameByEmail(String email, String password) {
        System.out.println("getNameByEmailAndPassword in GymRepositoryImpl");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            Query query = entityManager.createNamedQuery("getNameByEmailAndPassword");
            query.setParameter("byEmail", email);
            query.setParameter("byPassword", password);
            Object singleResult = query.getSingleResult();
            entityTransaction.commit();

            if (singleResult != null) {
                System.out.println("result is not null");
                return true;
            }

            System.out.println("it is null");
            return false;
        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            return false;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public boolean saveEnquiry(EnquiryEntity enquiryEntity) {
        System.out.println("Running saveEnquiry in GymRepositoryImpl");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            entityManager.persist(enquiryEntity);
            entityTransaction.commit();
            return true;
        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            return false;
        } finally {
            entityManager.close();
        }
    }

    @Override
    public List<EnquiryEntity> findAll() {
        System.out.println(" findAll in GymRepositoryImpl");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        String query = "SELECT e FROM EnquiryEntity e ";
        return entityManager.createQuery(query, EnquiryEntity.class).getResultList();

    }

    @Override
    public List<EnquiryEntity> findByStatus(String status) {
        System.out.println("findByStatus in GymRepositoryImpl");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        String query = "SELECT e FROM EnquiryEntity e WHERE e.status = :status";
        return entityManager.createQuery(query, EnquiryEntity.class).setParameter("status", status).getResultList();
    }


    @Override
    public boolean updateStatusAndReason(String name, String status, String reason) {
        System.out.println("updateStatusAndReason in GymRepositoryImpl");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();
        boolean isUpdated = false;
        try {
            entityTransaction.begin();
            String query = "UPDATE EnquiryEntity e SET e.status = :status, e.reason = :reason WHERE e.name = :name";
            int rowsAffected = entityManager.createQuery(query).setParameter("status", status)
                    .setParameter("reason", reason)
                    .setParameter("name", name)
                    .executeUpdate();

            entityTransaction.commit();
            isUpdated = rowsAffected > 0;

        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
            return false;
        } finally {
            entityManager.close();
        }

        return isUpdated;
    }
}

//    @Override
//    public boolean savedData(EnquiryEntity enquiryEntity) {
//        System.out.println("savedData in GymRepositoryImpl");
//        EntityManager entityManager = emf.createEntityManager();
//        EntityTransaction entityTransaction = entityManager.getTransaction();
//
//        try {
//            entityTransaction.begin();
//            entityManager.persist(enquiryEntity);
//            entityTransaction.commit();
//            return true;
//        } catch (Exception e) {
//            if (entityTransaction.isActive()) {
//                entityTransaction.rollback();
//            }
//            return false;
//        } finally {
//            entityManager.close();
//        }
//    }


//    @Override
//    public boolean saveFollow(FollowEntity followEntity) {
//        System.out.println("saveFollow in GymRepositoryImpl");
//        EntityManager entityManager = emf.createEntityManager();
//        EntityTransaction entityTransaction = entityManager.getTransaction();
//
//        try {
//            entityTransaction.begin();
//            entityManager.persist(followEntity);
//            entityTransaction.commit();
//            return true;
//        } catch (Exception e) {
//            if (entityTransaction.isActive()) {
//                entityTransaction.rollback();
//            }
//            return false;
//        } finally {
//            entityManager.close();
//        }
//    }



