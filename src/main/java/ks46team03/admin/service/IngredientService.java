package ks46team03.admin.service;


import ks46team03.dto.Ingredient;
import ks46team03.admin.mapper.IngredientMapper;
import ks46team03.dto.Member;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class IngredientService {
    private final IngredientMapper ingredientMapper;

    public IngredientService(IngredientMapper ingredientMapper) {
        this.ingredientMapper = ingredientMapper;
    }
    public void removeIngredient(String ingredientCode) {
        Ingredient ingredientInfo = ingredientMapper.getIngredientInfoById(ingredientCode);

        if(ingredientInfo != null) {
            String infoIngredientCode = ingredientInfo.getIngredientCode();


            ingredientMapper.removeIngredientListById(ingredientCode);
            //회원탈퇴
            ingredientMapper.removeIngredientById(ingredientCode);
        }

    }

    public void modifyIngredient(Ingredient ingredient) {
            ingredientMapper.
                    modifyIngredient(ingredient);
        }


        public Ingredient getIngredientInfoById(String ingredientCode) {
            Ingredient ingredientInfo = ingredientMapper.getIngredientInfoById(ingredientCode);
            return ingredientInfo;
        }


        public int addIngredient(Ingredient ingredient) {
            int result =
                ingredientMapper.addIngredient(ingredient);

            return result;
        }

    public List<Ingredient> getIngredientList() {
        List<Ingredient> ingredientList = ingredientMapper.getIngredientList();

        return ingredientList;


    }
}
