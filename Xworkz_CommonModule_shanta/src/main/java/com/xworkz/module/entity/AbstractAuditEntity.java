package com.xworkz.module.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;

@MappedSuperclass
@Data

public class AbstractAuditEntity implements Serializable {

    private String createdBy;
    private LocalDateTime createdDate = LocalDateTime.now();
    private String updatedBy;
    private LocalDateTime updatedDate = LocalDateTime.now();

    @Column(name="file_path")
    private String filePath;

//    @Column(name="account_locked_time")
//    private LocalDateTime accountLockedTime;

}
