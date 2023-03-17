package com.dew.itrade.cloudfileprocessingapp.entity;


import lombok.*;

import javax.persistence.*;


@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "file_info", uniqueConstraints = {
        @UniqueConstraint(columnNames = {"checksum"}),
})
public class FileInfo extends  AuditEntiy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String checksum;
    private String filename;
    private String process;
    private String status;

    @Builder
    public FileInfo(String checksum, String filename, String process) {
        this.checksum = checksum;
        this.filename = filename;
        this.process = process;
    }
}
