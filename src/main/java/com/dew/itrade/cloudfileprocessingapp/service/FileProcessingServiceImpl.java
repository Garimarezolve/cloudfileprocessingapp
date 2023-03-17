package com.dew.itrade.cloudfileprocessingapp.service;

import com.dew.itrade.cloudfileprocessingapp.constant.ApplicationConstant;
import com.dew.itrade.cloudfileprocessingapp.dto.FileInfoDto;
import com.dew.itrade.cloudfileprocessingapp.dto.ResponseDto;
import com.dew.itrade.cloudfileprocessingapp.dto.SuccessResponseDto;
import com.dew.itrade.cloudfileprocessingapp.entity.FileInfo;
import com.dew.itrade.cloudfileprocessingapp.exception.ServiceException;
import com.dew.itrade.cloudfileprocessingapp.repository.FileProcessingRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FileProcessingServiceImpl implements FileProcessingService{

    private  final FileProcessingRepository repository;
    @Override
    public ResponseDto saveFileInfo(FileInfoDto fileInfoDto) {
        FileInfo existingFile= repository.findByChecksum(fileInfoDto.getChecksum());
        if(existingFile!=null){
             throw  new ServiceException(ApplicationConstant.ERROR_STATUS_CODE, HttpStatus.OK,ApplicationConstant.FILE_ALREADY_EXIST);
        }
        FileInfo fileInfo=FileInfo.builder()
                .checksum(fileInfoDto.getChecksum())
                .filename(fileInfoDto.getFilename())
                .process(fileInfoDto.getProcess()).build();
        setDefaultFileAttributes(fileInfo);
        repository.save(fileInfo);
        return new SuccessResponseDto(FileInfoDto.builder().checksum(fileInfo.getChecksum()).filename(fileInfo.getFilename()).process(fileInfo.getProcess()).build()
                , ApplicationConstant.CREATED_MSG,ApplicationConstant.HTTP_RESPONSE_CREATED_CODE);
    }

    private void setDefaultFileAttributes(FileInfo fileInfo){
        fileInfo.setStatus(ApplicationConstant.FILE_STATUS);
    }
}
