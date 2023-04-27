package ks46team03.admin.mapper;

import ks46team03.dto.BannedWords;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface BannedWordsMapper {

    //재료 목록 조회
    public List<BannedWords> getBannedWordsList();
}
