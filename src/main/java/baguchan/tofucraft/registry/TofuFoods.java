package baguchan.tofucraft.registry;


import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.food.FoodProperties;

public class TofuFoods {
	public static final FoodProperties TOFU = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.12F).fast().build();

	public static final FoodProperties ISHITOFU = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.1F).fast().build();

	public static final FoodProperties TOFUHELL = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.12F).alwaysEat().effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600), 1.0F).build();

	public static final FoodProperties TOFUSOUL = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.12F).fast().build();

	public static final FoodProperties TOFUGRILLED = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.15F).fast().build();

	public static final FoodProperties TOFUZUNDA = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.2F).fast().build();

	public static final FoodProperties BOILED_EDAMAME = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).fast().build();

	public static final FoodProperties TOFU_HAMBURG = (new FoodProperties.Builder()).nutrition(6).saturationMod(0.6F).build();

	public static final FoodProperties RAW_TOFUFISH = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).build();

	public static final FoodProperties COOKED_TOFUFISH = (new FoodProperties.Builder()).nutrition(5).saturationMod(0.6F).build();

	public static final FoodProperties TOFUCOOKIE = (new FoodProperties.Builder()).nutrition(1).saturationMod(0.1F).build();

	public static final FoodProperties SOYSTICK = (new FoodProperties.Builder()).nutrition(4).saturationMod(0.3F).fast().build();

	public static final FoodProperties SALTYMELON = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.32F).build();

	public static final FoodProperties KINAKO_MANJU = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.24F).fast().build();

	public static final FoodProperties ZUNDA_MANJU = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.26F).fast().build();

	public static final FoodProperties NETHER_MANJU = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.26F).fast().alwaysEat().effect(() -> new MobEffectInstance(MobEffects.FIRE_RESISTANCE, 600), 1.0F).build();

	public static final FoodProperties SOUL_MANJU = (new FoodProperties.Builder()).nutrition(3).saturationMod(0.26F).fast().alwaysEat().effect(() -> new MobEffectInstance(MobEffects.ABSORPTION, 1200), 1.0F).build();

	public static final FoodProperties SOY_CHOCOLATE = (new FoodProperties.Builder()).nutrition(2).saturationMod(0.16F).fast().build();
}
