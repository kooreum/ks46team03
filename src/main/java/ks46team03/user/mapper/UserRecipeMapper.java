package ks46team03.user.mapper;

import ks46team03.dto.Member;
import ks46team03.dto.Recipe;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface UserRecipeMapper {



    // 레시피 목록조회
    public List<Recipe> getRecipeList(String searchKey, String searchValue);


}
