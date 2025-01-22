package com.xworkz.gym.repository;

import com.xworkz.gym.DTO.RegisterDto;
import com.xworkz.gym.Entity.EnquiryEntity;


import com.xworkz.gym.Entity.RegisterEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.*;
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
    public Long countName(String name) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Long count = (Long) em.createNamedQuery("countByName").setParameter("setName",name).getSingleResult();
        try {
            et.begin();
            et.commit();
        } catch (Exception e){
            if(et.isActive()){
                et.rollback();
            }
        }finally {
            em.close();
        }
        return count;
    }

//    @Override
//    public Long countByEmail(String email) {
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction et = em.getTransaction();
//
//        Long count = (Long) em.createNamedQuery("countByEmail").setParameter("setEmail",email).getSingleResult();
//
//        try {
//            et.begin();
//            et.commit();
//        } catch (Exception e){
//            if(et.isActive()){
//                et.rollback();
//            }
//        }finally {
//            em.close();
//        }
//        return count;
//    }


//    @Override
//    public Long countByPassword(String password) {
//        EntityManager em = emf.createEntityManager();
//        EntityTransaction et = em.getTransaction();
//
//        Long count = (Long) em.createNamedQuery("countByPassword").setParameter("setPassword",password).getSingleResult();
//        try {
//            et.begin();
//            et.commit();
//        } catch (Exception e){
//            if(et.isActive()){
//                et.rollback();
//            }
//        } finally {
//            em.close();
//        }
//        return count;
//    }

    @Override
    public Long countArea(String area) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        Long count = (Long) em.createNamedQuery("countByArea").setParameter("setArea",area).getSingleResult();

        try{
            et.begin();
            et.commit();
        } catch (Exception e){
            if (et.isActive()){
                et.rollback();
            }
        } finally {
            em.close();
        }
        return count;
    }

    @Override
    public Long countPhone(long phone) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        Long count = (Long) em.createNamedQuery("countByPhone").setParameter("setPhone",phone).getSingleResult();

        try{
            et.begin();
            et.commit();
        } catch (Exception e){
            if (et.isActive()){
                et.rollback();
            }
        } finally {
            em.close();
        }
        return count;
    }

    @Override
    public Long countDistance(int distance) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        Long count = (Long) em.createNamedQuery("countByDistance").setParameter("setDistance",distance).getSingleResult();

        try{
            et.begin();
            et.commit();
        } catch (Exception e){
            if (et.isActive()){
                et.rollback();
            }
        } finally {
            em.close();
        }
        return count;
    }

    @Override
    public Long countAge(int age) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        Long count = (Long) em.createNamedQuery("countByAge").setParameter("setAge",age).getSingleResult();

        try{
            et.begin();
            et.commit();
        } catch (Exception e){
            if (et.isActive()){
                et.rollback();
            }
        } finally {
            em.close();
        }
        return count;
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

    @Override
    public boolean saveRegister(RegisterEntity registerEntity) {
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        try {
            entityTransaction.begin();
            entityManager.merge(registerEntity);
            entityTransaction.commit();
            return true;
        } catch (Exception e){
            if(entityTransaction.isActive()){
                entityTransaction.rollback();
            }
            return false;
        }
        finally {
            entityManager.close();
        }
    }

    @Override
    public RegisterEntity updateRegister(String name, long phone) {
        System.out.println("findByNameAndPhone in GymRepositoryImpl");
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        String queryStr = "Select p FROM RegisterEntity p WHERE p.name = :nameBy AND p.phone = :phoneBy";
        RegisterEntity result = null;

        try {
            entityTransaction.begin();
            Query query = entityManager.createQuery(queryStr);
            query.setParameter("nameBy",name);
            query.setParameter("phoneBy",phone);
            result = (RegisterEntity) query.getSingleResult();
            entityTransaction.commit();

        } catch (Exception e){
            System.out.println("error in update:" +e.getMessage());
            if(entityTransaction.isActive()) {
                entityTransaction.isActive();
            }
        } finally {
            entityManager.close();
        }
        return result;
    }


//    @Override
//    public boolean updateDetails(String name, RegisterDto registerDto) {
//        System.out.println("updateDetails in GymRepositoryImpl:" + registerDto.toString());
//        EntityManager entityManager = emf.createEntityManager();
//        EntityTransaction entityTransaction = entityManager.getTransaction();
//        boolean isUpdated = false;
//        System.out.println("to know thje vslue of pscksge.."+registerDto.getPackages());
//
//        try {
//            entityTransaction.begin();
//
//            int value = entityManager.createNamedQuery("updatedDetailsByName")
//                    .setParameter("packagesBy", registerDto.getPackages())
//                    .setParameter("trainerBy", registerDto.getTrainer())
//                    .setParameter("amountBy", registerDto.getAmount())
//                    .setParameter("balanceBy", registerDto.getBalance())
//                    .setParameter("nameBy", name)
//                    .executeUpdate();
//            System.out.println("==================RepoImpl============");
//            isUpdated = value > 0;
//            entityTransaction.commit();
//
//
//        } catch (Exception e) {
//            if (entityTransaction.isActive()) {
//                entityTransaction.rollback();
//            }
//        } finally {
//            entityManager.close();
//        }
//
//        return isUpdated;
//    }

}





