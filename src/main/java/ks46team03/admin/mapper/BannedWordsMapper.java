package ks46team03.admin.mapper;

import ks46team03.dto.BannedWords;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
@Mapper
public interface BannedWordsMapper {

    //금칙어 목록 조회
    public List<BannedWords> getBannedWordsList();

    //금칙어 삭제
    public int removeBannedWordsByCode(String bannedWordsCode);

    //금칙어 등록
    public int addBannedWords(BannedWords bannedWords);
}
