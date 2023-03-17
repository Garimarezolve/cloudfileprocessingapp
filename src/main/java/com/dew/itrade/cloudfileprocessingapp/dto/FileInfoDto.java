package com.dew.itrade.cloudfileprocessingapp.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Builder;
import lombok.Data;

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
