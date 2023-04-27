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


}
