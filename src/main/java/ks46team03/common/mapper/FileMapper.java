package ks46team03.common.mapper;

import ks46team03.dto.FileDto;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FileMapper {
    public int addFile(List<FileDto> fileList);

    public List<FileDto> getFileList();

    public FileDto getFileInfoByIdx(String fileIdx);
}
