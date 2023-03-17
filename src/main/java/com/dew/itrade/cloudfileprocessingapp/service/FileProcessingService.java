package com.dew.itrade.cloudfileprocessingapp.service;


import com.dew.itrade.cloudfileprocessingapp.dto.FileInfoDto;
import com.dew.itrade.cloudfileprocessingapp.dto.ResponseDto;

public interface FileProcessingService {
    ResponseDto saveFileInfo(FileInfoDto fileInfoDto);
}
