package com.xworkz.gym.repository;

import com.xworkz.gym.Entity.EnquiryEntity;
import com.xworkz.gym.Entity.FollowEntity;
import com.xworkz.gym.Entity.GymEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;

@Repository
public class GymRepositoryImpl implements GymRepository{

    @Autowired
    EntityManagerFactory emf;

    @Override
    public boolean saveData(GymEntity gymEntity) {
        System.out.println("Running saveData in GymRepositoryImpl");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try{
            entityTransaction.begin();
            entityManager.persist(gymEntity);
            entityTransaction.commit();
            return true;
        }
        catch (Exception e){
            if(entityTransaction.isActive()){
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
        } catch(Exception e){
            if(entityTransaction.isActive()){
                entityTransaction.rollback();
            }
            return false;
        } finally {
            entityManager.close();
        }
    }

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
}
