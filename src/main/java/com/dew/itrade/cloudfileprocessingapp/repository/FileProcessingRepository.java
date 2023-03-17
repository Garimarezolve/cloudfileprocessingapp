package com.dew.itrade.cloudfileprocessingapp.repository;

import com.dew.itrade.cloudfileprocessingapp.entity.FileInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FileProcessingRepository  extends JpaRepository<FileInfo,Long> {
 @Query(value="SELECT * from file_info where created_at > CURRENT_DATE - INTERVAL '6 months' and checksum=?1", nativeQuery = true)
 FileInfo findByChecksum(String checksum);
}
