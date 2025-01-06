package com.xworkz.xworkzCommonModuleGunashreeB.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import java.io.Serializable;
import java.time.LocalDateTime;


@Data
@NoArgsConstructor
@MappedSuperclass
public class AbstractAuditEntity implements Serializable {

    @Column(name="created_by")
    private String createdBy;
    @Column(name="created_date")
    private LocalDateTime createdDate=LocalDateTime.now();
    @Column(name="updated_by")
    private String updatedBy;
    @Column(name="updated_date")
    private LocalDateTime updatedDate=LocalDateTime.now();
    @Column(name="file_path")
    private String filePath;


}
