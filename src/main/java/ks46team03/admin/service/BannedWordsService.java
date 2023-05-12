package ks46team03.admin.service;

import ks46team03.admin.mapper.BannedWordsMapper;
import ks46team03.dto.BannedWords;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BannedWordsService {
    private final BannedWordsMapper bannedWordsMapper;

    public BannedWordsService(BannedWordsMapper bannedWordsMapper){

        this.bannedWordsMapper = bannedWordsMapper;
    }

    public List<BannedWords> getBannedWordsList(){
        List<BannedWords> bannedWordsList = bannedWordsMapper.getBannedWordsList();

        return bannedWordsList;
    }

    /*
    금칙어 삭제
     */
    public void removeBannedWords(String bannedWordsCode){

        bannedWordsMapper.removeBannedWordsByCode(bannedWordsCode);

    }

    /* 금칙어 등록 */

    public int addBannedWords(BannedWords bannedWords){
        int result = bannedWordsMapper.addBannedWords(bannedWords);
        return result;
    }

    public void removeCheckedBannedWords(List<String> valueArr) {
        for (int i = 0; i < valueArr.size(); i++) {
            bannedWordsMapper.removeBannedWordsByCode(valueArr.get(i));
        }
    }

}
