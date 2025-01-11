package com.xworkz.module.repository;
import com.xworkz.module.dto.ModuleDTO;
import com.xworkz.module.entity.ModuleEntity;
import java.util.List;

public interface ModuleRepository {

    boolean onModule(ModuleEntity moduleEntity);

    ModuleEntity getName(String email,String password);
    List<ModuleEntity> getAll(String email, String password);

    Long countName(String name);
    Long countByEmail(String email);
    Long countByAltEmail(String alterEmail);
    Long countByPhone(long phone);
    Long countByAltPhone(long alterPhone);
    Long countByLocation(String location);

    String updatePasswordByEmail(String newPassword, String email);
    ModuleEntity findByName(String name);
    ModuleEntity getEmail(String email);

    boolean updatePasswordAndCount(String email, String confirmPassword, int count);
    void updateCount(String email, int count);
    boolean resetCount(String email, int count);

    ModuleEntity getByEmailPassword(String email,String password);

   // public ModuleEntity getByName(String name) ;
    boolean updateDetails(String userName, ModuleDTO moduleDTO,String filePath);
}



