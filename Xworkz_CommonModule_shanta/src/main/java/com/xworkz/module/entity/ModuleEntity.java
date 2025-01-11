package com.xworkz.module.entity;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity
@Table(name="module_table")

@NamedQuery(name="getNameByPassword", query = "SELECT c FROM ModuleEntity c WHERE c.name= :name")

@NamedQuery(name="countName" , query ="select count(e) from ModuleEntity e where e.name =:SetName")
@NamedQuery(name = "countByEmail", query = "select count(e) from ModuleEntity e where e.email = :SetEmail")
@NamedQuery(name = "countByAltEmail", query = "select count(e) from ModuleEntity e where e.alterEmail = :SetAlterEmail")
@NamedQuery(name = "countByPhone", query = "select count(e) from ModuleEntity e where e.phone = :SetPhone")
@NamedQuery(name = "countByAltPhone", query = "select count(e) from ModuleEntity e where e.alterPhone = :SetAlterPhone")
@NamedQuery(name = "countByLocation", query = "select count(e) from ModuleEntity e where e.location =:SetLocation")

@NamedQuery(name="getAll", query="select ls from ModuleEntity ls where ls.email = :setEmail and ls.password = :setPassword")
@NamedQuery(name="updatePasswordByEmail", query="update ModuleEntity ls set ls.password =:setNewPassword, ls.resetStatus =:setResetStatus where ls.email =:emailBy")
@NamedQuery(name= "getAllByEmail", query = "select ls from ModuleEntity ls where ls.email =:byEmail")

@NamedQuery(name = "updateCount", query="update ModuleEntity ls set ls.resetStatus =:setResetStatus where ls.email =: byEmail")
@NamedQuery(name = "resetCount", query="update ModuleEntity ls set ls.resetStatus =: setResetStatus where ls.email =: byEmail")
@NamedQuery(name = "getByEmailPassword", query="select ls from ModuleEntity ls where ls.email =: setEmail and ls.password =: setPassword")

@NamedQuery(name="updatedDetailsByName", query = "update ModuleEntity p set p.email = :emailBy, p.phone = :phoneNumberBy, p.alterEmail = :alterEmailBy, p.alterPhone = :alternatePhoneNumberBy, p.location = :locationBy, p.updatedBy = :updateName, p.updatedDate =  :updatedOn,p.filePath= :filePathBy where p.name = :nameBy")
public class ModuleEntity extends AbstractAuditEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private String email;
    private long phone;
    private String alterEmail;
    private long alterPhone;
    private String location;
    private String password;

    @Column(name="reset_status")
    private int resetStatus;
}


