package com.secui.healthone.domain.meal.dto;

import com.secui.healthone.domain.food.dto.CustomFoodResDto;
import com.secui.healthone.domain.food.dto.FoodResponseDto;
import com.secui.healthone.domain.meal.entity.Meal;
import com.secui.healthone.domain.meal.entity.MealType;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Schema(description = "식사 응답 요청 DTO")
public class MealResDto {
    @Schema(description = "식사 식별번호")
    private Integer no;
    @Schema(description = "회원 식별번호")
    private Integer userNo;
    @Schema(description = "일반 음식 객체")
    private FoodResponseDto food;
    @Schema(description = "사용자 음식 식별번호")
    private CustomFoodResDto customfood;
    @Schema(description = "식사 기록 시간")
    private LocalDateTime createTime;
    @Schema(description = "식사 타입 (BREAKFAST, LUNCH, DINNER, SNACK)")
    private MealType mealType;
    @Schema(description = "섭취한 인분 수")
    private Float portion;
    @Schema(description = "섭취한 그램 수")
    private Float gram;
    @Schema(description = "섭취한 칼로리 수")
    private Integer kcal;

    @Builder
    public MealResDto(Meal entity) {
        this.no = entity.getNo();
        this.userNo = entity.getUserNo();
        this.food = entity.getFood() != null ? new FoodResponseDto(entity.getFood()) : null;
        this.customfood = entity.getCustomfood() != null ? new CustomFoodResDto(entity.getCustomfood()) : null;
        this.createTime = entity.getCreateTime();
        this.mealType = entity.getMealType();
        this.portion = entity.getPortion();
        this.gram = entity.getGram();
        this.kcal = entity.getKcal();
    }
}
