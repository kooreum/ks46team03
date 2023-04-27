package ks46team03.admin.service;


import ks46team03.admin.mapper.MemberMapper;
import ks46team03.dto.Ingredient;
import ks46team03.admin.mapper.IngredientMapper;
import ks46team03.dto.Member;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class IngredientService {
    private final IngredientMapper ingredientMapper;
    private final MemberMapper memberMapper;

    /**
     * 재료삭제
     * @param ingredientMapper
     */
    public IngredientService(IngredientMapper ingredientMapper, MemberMapper memberMapper) {
        this.ingredientMapper = ingredientMapper;
        this.memberMapper = memberMapper;
    }
    public void removeIngredient(String ingredientCode) {
        Ingredient ingredientInfo = ingredientMapper.getIngredientInfoById(ingredientCode);

        if(ingredientInfo != null) {
            String infoIngredientCode = ingredientInfo.getIngredientCode();

            //재료이력삭제
            ingredientMapper.removeIngredientListById(ingredientCode);
            //재료삭제
            ingredientMapper.removeIngredientById(ingredientCode);
        }

    }

    /**
     * 재료정보수정
     * @param ingredient
     */
    public void modifyIngredient(Ingredient ingredient) {
            ingredientMapper.
                    modifyIngredient(ingredient);
        }


    /**
     * 특정 재료조회
     * @param ingredientCode
     * @return
     */
    public Ingredient getIngredientInfoById(String ingredientCode) {
            Ingredient ingredientInfo = ingredientMapper.getIngredientInfoById(ingredientCode);
            return ingredientInfo;
        }

    /**
     * 재료 등록
     * @param ingredient
     * @return
     */
    public int addIngredient(Ingredient ingredient) {
            int result =
                ingredientMapper.addIngredient(ingredient);

            return result;
        }

    /**
     * 재료목록 조회
     * @return
     */
    public List<Ingredient> getIngredientList(String searchKey, String searchValue) {
        if (searchKey != null){
            switch (searchKey){
                case "memberId":
                    searchKey = "i.member_id";
                    break;
                case "ingredientCode":
                    searchKey = "i.ingredient_code";
                break;
                case "ingredientName":
                    searchKey = "i.ingredient_name";
                break;
                default:
                    searchKey = "i.ingredient_category_code";
                    break;

            }
        }
        List<Ingredient> ingredientList = ingredientMapper.getIngredientList(searchKey, searchValue);

        return ingredientList;


    }
}
