package net.mshm.stoobidity.item;

import net.minecraft.component.type.FoodComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;

public class ModFoodComponents {
    public static final FoodComponent HALLS = new FoodComponent.Builder().snack().nutrition(0).saturationModifier(1.5f)
            .statusEffect(new StatusEffectInstance(StatusEffects.STRENGTH, 160), 0.95f)
            .statusEffect(new StatusEffectInstance(StatusEffects.MINING_FATIGUE, 160, 1), 0.05f)
            .statusEffect(new StatusEffectInstance(StatusEffects.HUNGER, 200, 2), 0.0000001f).build();

}
