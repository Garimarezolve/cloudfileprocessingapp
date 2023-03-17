package com.dew.itrade.cloudfileprocessingapp.dto;


import lombok.Builder;
import lombok.Data;

import javax.validation.constraints.NotEmpty;

@Data
@Builder
public class FileInfoDto {
    @NotEmpty(message = "file name can not be empty")
    private String filename;

    @NotEmpty(message = "checksum can not be empty")
    private String checksum;

    @NotEmpty(message = "process can not be empty")
    private String process;
}
