package com.xworkz.module.repository;

import com.xworkz.module.dto.ModuleDTO;
import com.xworkz.module.entity.ModuleEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;
import java.time.LocalDateTime;
import java.util.List;

@Repository
public class ModuleRepositoryImpl implements ModuleRepository {

    @Autowired
    EntityManagerFactory emf;

    @Override
    public boolean onModule(ModuleEntity entity) {
        System.out.println("running in repository implementation");
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        try {
            et.begin();
            em.persist(entity);
            et.commit();
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
            e.printStackTrace();
        }
        finally {
            em.close();
        }
        return true;
    }

    @Override
    public ModuleEntity getName(String email, String password) {
        EntityManager entityManager = emf.createEntityManager();
        try {
            String queryStr = "SELECT p FROM ModuleEntity p WHERE p.email = :email";
            Query query = entityManager.createQuery(queryStr);
            query.setParameter("email", email);
            List<ModuleEntity> result = query.getResultList();

            if (result != null && !result.isEmpty()) {
                return result.get(0);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            entityManager.close();
        }
        return null;
    }

    @Override
    public List<ModuleEntity> getAll(String email, String password) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        List<ModuleEntity> list = em.createNamedQuery("getAll").setParameter("setEmail", email).setParameter("setPassword", password).getResultList();

        try {
            et.begin();
            et.commit();
        } catch (Exception e) {
            if (et.isActive()) {
                em.close();
            }
        } finally {
            em.close();
        }
        if (!list.isEmpty()) {
            return list;
        }
        return null;
    }


    @Override
    public Long countName(String name) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        Long count = (Long) em.createNamedQuery("countName").setParameter("SetName", name).getSingleResult();
        try {
            et.begin();
            et.commit();
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();

        }
        return count;

    }

    @Override
    public Long countByEmail(String email) {
        EntityManager em = emf.createEntityManager();
        Long count = 0L;
        try {
            count = (Long) em.createNamedQuery("countByEmail")
                    .setParameter("SetEmail", email)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }
        return count;
    }

    @Override
    public Long countByAltEmail(String alterEmail) {
        EntityManager em = emf.createEntityManager();
        Long count = 0L;
        try {
            count = (Long) em.createNamedQuery("countByAltEmail")
                    .setParameter("SetAlterEmail", alterEmail)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(); // Log the error
        } finally {
            em.close();
        }
        return count;

    }

    @Override
    public Long countByPhone(long phone) {
        EntityManager em = emf.createEntityManager();
        Long count = 0L;
        try {
            count = (Long) em.createNamedQuery("countByPhone")
                    .setParameter("SetPhone", phone)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(); // Log the error
        } finally {
            em.close();
        }
        return count;

    }

    @Override
    public Long countByAltPhone(long alterPhone) {
        EntityManager em = emf.createEntityManager();
        Long count = 0L;
        try {
            count = (Long) em.createNamedQuery("countByAltPhone")
                    .setParameter("SetAlterPhone", alterPhone)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(); // Log the error
        } finally {
            em.close();
        }
        return count;
    }

    @Override
    public Long countByLocation(String location) {
        EntityManager em = emf.createEntityManager();
        Long count = 0L;
        try {
            count = (Long) em.createNamedQuery("countByLocation")
                    .setParameter("SetLocation", location)
                    .getSingleResult();
        } catch (Exception e) {
            e.printStackTrace(); // Log the error
        } finally {
            em.close();
        }
        return count;
    }

    @Override
    public String updatePasswordByEmail(String newPassword, String email) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        try {
            et.begin();
            System.out.println("Email:" + email);
            System.out.println("newPassword:" + newPassword);

            Query query = em.createNamedQuery("updatePasswordByEmail");
            query.setParameter("setNewPassword", newPassword);
            query.setParameter("setResetStatus", 0);
            query.setParameter("emailBy", email);

            int value = query.executeUpdate();
            et.commit();

            if (value > 0) {
                return "Password updated successfully";
            } else {
                return "Password is not updated";
            }
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
            e.printStackTrace();
        } finally {
            {
                em.close();
            }
            return "An error occured while updating the password";
        }
    }

    @Override
    public ModuleEntity findByName(String name) {
        EntityManager em = emf.createEntityManager();

        try {
            String queryStr = "SELECT ls FROM ModuleEntity ls WHERE ls.name =:name";
            Query query = em.createQuery(queryStr);
            query.setParameter("name", name);

            List<ModuleEntity> result = query.getResultList();
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
        int result = count + 1;
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        int value;
        try {
            et.begin();
            value = em.createNamedQuery("updateCount")
                    .setParameter("setResetStatus", result).setParameter("byEmail", email).executeUpdate();
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
    public boolean resetCount(String email, int count) {
        int result = 0;
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        int value = 0;
        try {
            et.begin();
            value = em.createNamedQuery("resetCount").setParameter("setResetStatus", 0).setParameter("byEmail", email).executeUpdate();
            et.commit();
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
        if (value > 0) {
            return true;
        } else {
            return false;
        }
    }

    @Override
    public ModuleEntity getByEmailPassword(String email, String password) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        ModuleEntity entity = null;
        try {
            Query query = em.createNamedQuery("getByEmailPassword");
            query.setParameter("setEmail", email).setParameter("setPassword", password);

            entity = (ModuleEntity) query.getSingleResult();
            System.out.println("Entity from repository" + entity.toString());
        } catch(Exception e){
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
        return entity;
    }


    @Override
    public ModuleEntity getEmail(String email) {
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();
        ModuleEntity entity = null;
        try {
            Query query = em.createNamedQuery("getAllByEmail");
            query.setParameter("byEmail", email);

            List<ModuleEntity> result = query.getResultList();

            if (!result.isEmpty()) {
                entity = result.get(0);  // You can select the first or handle according to your logic
                System.out.println("Entity from repository: " + entity);

//            entity = (ModuleEntity) query.getSingleResult();
//           entity = (ModuleEntity) query.getResultList();
//            System.out.println("Entity from repository :" + entity.toString());

            }
        }catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            em.close();
        }
        return entity;
    }

    @Override
    public boolean updatePasswordAndCount(String email, String confirmPassword, int count) {
        int loginValue = count + 1;
        System.out.println(confirmPassword);
        System.out.println(loginValue);
        EntityManager em = emf.createEntityManager();
        EntityTransaction et = em.getTransaction();

        boolean isUpdated = false;
        try {
            et.begin();
            int value = em.createNamedQuery("updatePassword").setParameter("SetPassword", confirmPassword).setParameter("SetResetStatus", loginValue)
                    .setParameter("ByEmail", email).executeUpdate();
            if (value > 0) {
                isUpdated = true;

                System.out.println("Updated");
            } else {
                isUpdated = false;
                System.out.println("Not Updated");
            }
            et.commit();
        } catch (Exception e) {
            if (et.isActive()) {
                et.rollback();
            }
        } finally {
            em.close();
        }
        if (isUpdated) {
            System.out.println("updated");
            return true;
        } else {
            System.out.println("not updated");
            return false;
        }
    }

    @Override
    public boolean updateDetails(String userName, ModuleDTO moduleDTO,String filePath) {
        System.out.println("repository:"+moduleDTO.toString());
        System.out.println(userName);
        EntityManager entityManager = emf.createEntityManager();
        EntityTransaction entityTransaction = entityManager.getTransaction();

        boolean isUpdated = false;

        try {
            entityTransaction.begin();
            int value = (entityManager.createNamedQuery("updatedDetailsByName").setParameter("emailBy", moduleDTO.getEmail()).setParameter("phoneNumberBy", moduleDTO.getPhone())
                    .setParameter("alterEmailBy", moduleDTO.getAlterEmail()).setParameter("alternatePhoneNumberBy", moduleDTO.getAlterPhone())
                    .setParameter("locationBy", moduleDTO.getLocation()).setParameter("updateName",moduleDTO.getName()).setParameter("filePathBy",filePath).setParameter("updatedOn",LocalDateTime.now()).setParameter("nameBy", userName)).executeUpdate();

            if (value > 0) {
                isUpdated = true;
                System.out.println("updated");
            } else {
                isUpdated = false;
                System.out.println("Not updated");
            }
            entityTransaction.commit();

        } catch (Exception e) {
            if (entityTransaction.isActive()) {
                entityTransaction.rollback();
            }
        }
            finally {
                entityManager.close();
            }
            if (isUpdated) {
                System.out.println("updated");
                return true;
            } else {
                System.out.println("it is not updated");
                return false;
            }
        }
    }

//    @Override
//    public ModuleEntity getByName(String name) {
//        EntityManager entityManager = emf.createEntityManager();
//        try {
//
//            Query query = entityManager.createNamedQuery("getModuleEntityListByName");
//            query.setParameter("name", name);
//
//            List<ModuleEntity> result = query.getResultList();
//            if (!result.isEmpty()) {
//                return result.get(0);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        } finally {
//
//            entityManager.close();
//        }
//        return null;
//    }



