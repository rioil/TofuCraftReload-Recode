package baguchan.tofucraft.registry;

import baguchan.tofucraft.TofuCraftReload;
import baguchan.tofucraft.item.*;
import baguchan.tofucraft.utils.RecipeHelper;
import net.minecraft.core.BlockPos;
import net.minecraft.core.BlockSource;
import net.minecraft.core.dispenser.DefaultDispenseItemBehavior;
import net.minecraft.core.dispenser.DispenseItemBehavior;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.*;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.ComposterBlock;
import net.minecraft.world.level.block.DispenserBlock;
import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluids;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraftforge.event.RegistryEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.fml.common.Mod.EventBusSubscriber;

@EventBusSubscriber(modid = TofuCraftReload.MODID, bus = EventBusSubscriber.Bus.MOD)
public class TofuItems {
	public static final Item TOFUKINU = new Item((new Item.Properties()).food(TofuFoods.TOFU).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item TOFUMOMEN = new Item((new Item.Properties()).food(TofuFoods.TOFU).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item TOFUISHI = new Item((new Item.Properties()).food(TofuFoods.ISHITOFU).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item TOFUMETAL = new Item((new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item TOFUDIAMOND = new Item((new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item TOFUDIAMOND_NUGGET = new Item((new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item TOFUHELL = new Item((new Item.Properties()).food(TofuFoods.TOFUHELL).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item TOFUSOUL = new Item((new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item TOFUGRILLED = new Item((new Item.Properties()).food(TofuFoods.TOFUGRILLED).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item TOFUZUNDA = new Item((new Item.Properties()).food(TofuFoods.TOFUZUNDA).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item TOFUMISO = new Item((new Item.Properties()).food(TofuFoods.TOFUMISO).tab(TofuCreativeModeTab.TOFUCRAFT));

	public static final Item BITTERN = new BitternItem((new Item.Properties()).craftRemainder(Items.GLASS_BOTTLE).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item SALT = new Item((new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item SEEDS_SOYBEANS = new ItemNameBlockItem(TofuBlocks.SOYBEAN, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item SEEDS_SOYBEANS_NETHER = new ItemNameBlockItem(TofuBlocks.SOYBEAN_NETHER, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item SEEDS_SOYBEANS_SOUL = new ItemNameBlockItem(TofuBlocks.SOYBEAN_SOUL, (new Item.Properties()).rarity(Rarity.UNCOMMON).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item SOYBEAN_PARCHED = new Item((new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item KINAKO = new Item((new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item EDAMAME = new Item((new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item BOILED_EDAMAME = new Item((new Item.Properties()).food(TofuFoods.BOILED_EDAMAME).tab(TofuCreativeModeTab.TOFUCRAFT));

	public static final Item KOUJI_BASE = new KoujiBaseItem((new Item.Properties()).stacksTo(1).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item KOUJI = new Item((new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));

	public static final Item MISO = new Item((new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item BOTTLE_SOYSAUSE = new Item((new Item.Properties()).craftRemainder(Items.GLASS_BOTTLE).stacksTo(16).tab(TofuCreativeModeTab.TOFUCRAFT));

	public static final Item LEEK = new Item((new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item YUBA = new Item((new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item ZUNDA = new Item((new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item ZUNDAMA = new Item((new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item ZUNDARUBY = new Item((new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item TOFU_HAMBURG_RAW = new Item((new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item TOFU_HAMBURG = new Item((new Item.Properties()).food(TofuFoods.TOFU_HAMBURG).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item RAW_TOFU_FISH = new Item((new Item.Properties()).food(TofuFoods.RAW_TOFUFISH).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item COOKED_TOFU_FISH = new Item((new Item.Properties()).food(TofuFoods.COOKED_TOFUFISH).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item TOFUCOOKIE = new Item((new Item.Properties()).food(TofuFoods.TOFUCOOKIE).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item SOYSTICK = new Item((new Item.Properties()).food(TofuFoods.SOYSTICK).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item SALTYMELON = new Item((new Item.Properties()).food(TofuFoods.SALTYMELON).tab(TofuCreativeModeTab.TOFUCRAFT));

	public static final Item SOYMILK = new SoymilkBottleItem(MobEffects.REGENERATION, MobEffects.HEALTH_BOOST, (new Item.Properties()).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item SOYMILK_APPLE = new SoymilkBottleItem(MobEffects.DAMAGE_RESISTANCE, MobEffects.ABSORPTION, (new Item.Properties()).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item SOYMILK_COCOA = new SoymilkBottleItem(MobEffects.JUMP, MobEffects.MOVEMENT_SPEED, (new Item.Properties()).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item SOYMILK_KINAKO = new SoymilkBottleItem(MobEffects.MOVEMENT_SPEED, MobEffects.DIG_SPEED, (new Item.Properties()).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item SOYMILK_PUDDING = new SoymilkBottleItem(MobEffects.REGENERATION, MobEffects.HEALTH_BOOST, (new Item.Properties()).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item SOYMILK_PUMPKIN = new SoymilkBottleItem(MobEffects.DAMAGE_BOOST, MobEffects.DIG_SPEED, (new Item.Properties()).stacksTo(16).craftRemainder(Items.GLASS_BOTTLE).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item KINAKO_MANJU = new Item((new Item.Properties()).food(TofuFoods.KINAKO_MANJU).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item ZUNDA_MANJU = new Item((new Item.Properties()).food(TofuFoods.ZUNDA_MANJU).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item NETHER_MANJU = new Item((new Item.Properties()).food(TofuFoods.NETHER_MANJU).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item SOUL_MANJU = new Item((new Item.Properties()).food(TofuFoods.SOUL_MANJU).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item ZUNDA_MOCHI = new Item((new Item.Properties()).food(TofuFoods.ZUNDA_MOCHI).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item KINAKO_MOCHI = new Item((new Item.Properties()).food(TofuFoods.KINAKO_MOCHI).tab(TofuCreativeModeTab.TOFUCRAFT));


	public static final Item SOY_CHOCOLATE = new Item((new Item.Properties()).food(TofuFoods.SOY_CHOCOLATE).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item TOFUNIAN_SOY_CHOCOLATE = new Item((new Item.Properties()).food(TofuFoods.SOY_CHOCOLATE).tab(TofuCreativeModeTab.TOFUCRAFT));

	public static final Item BUCKET_SOYMILK = new BucketItem(TofuFluids.SOYMILK, (new Item.Properties()).craftRemainder(Items.BUCKET).stacksTo(1).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item BUCKET_SOYMILK_NETHER = new BucketItem(TofuFluids.SOYMILK_HELL, (new Item.Properties()).craftRemainder(Items.BUCKET).stacksTo(1).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item BUCKET_SOYMILK_SOUL = new BucketItem(TofuFluids.SOYMILK_SOUL, (new Item.Properties()).craftRemainder(Items.BUCKET).stacksTo(1).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item TOFUFISH_BUCKET = new MobBucketItem(TofuEntityTypes.TOFUFISH, Fluids.WATER, SoundEvents.BUCKET_EMPTY_FISH, (new Item.Properties()).craftRemainder(Items.BUCKET).stacksTo(1).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item TOFUFISH_SOYMILK_BUCKET = new MobBucketItem(TofuEntityTypes.TOFUFISH, TofuFluids.SOYMILK, SoundEvents.BUCKET_EMPTY_FISH, (new Item.Properties()).craftRemainder(Items.BUCKET).stacksTo(1).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item BUCKET_BITTERN = new BucketItem(TofuFluids.BITTERN, (new Item.Properties()).craftRemainder(Items.BUCKET).stacksTo(1).tab(TofuCreativeModeTab.TOFUCRAFT));

	public static final Item TOFU_KINU_SWORD = new SwordItem(TofuItemTier.KINU, 0, -2.2F, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item TOFU_KINU_AXE = new AxeItem(TofuItemTier.KINU, 0.0F, -2.25F, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item TOFU_KINU_PICKAXE = new PickaxeItem(TofuItemTier.KINU, 0, -2.2F, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item TOFU_KINU_SHOVEL = new ShovelItem(TofuItemTier.KINU, 0.0F, -2.2F, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));

	public static final Item TOFU_MOMEN_SWORD = new SwordItem(TofuItemTier.MOMEN, 0, -2.2F, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item TOFU_MOMEN_AXE = new AxeItem(TofuItemTier.MOMEN, 1.0F, -2.5F, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item TOFU_MOMEN_PICKAXE = new PickaxeItem(TofuItemTier.MOMEN, 0, -2.25F, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item TOFU_MOMEN_SHOVEL = new ShovelItem(TofuItemTier.MOMEN, 0.0F, -2.25F, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));

	public static final Item TOFU_SOLID_SWORD = new SwordItem(TofuItemTier.SOLID, 3, -2.3F, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item TOFU_SOLID_AXE = new AxeItem(TofuItemTier.SOLID, 6.0F, -2.9F, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item TOFU_SOLID_PICKAXE = new PickaxeItem(TofuItemTier.SOLID, 1, -2.7F, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item TOFU_SOLID_SHOVEL = new ShovelItem(TofuItemTier.SOLID, 1.5F, -2.9F, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));

	public static final Item TOFU_METAL_SWORD = new SwordItem(TofuItemTier.METAL, 3, -2.3F, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item TOFU_METAL_AXE = new AxeItem(TofuItemTier.METAL, 5.0F, -3.1F, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item TOFU_METAL_PICKAXE = new PickaxeItem(TofuItemTier.METAL, 1, -2.7F, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item TOFU_METAL_SHOVEL = new ShovelItem(TofuItemTier.METAL, 1.5F, -2.9F, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));

	public static final Item TOFU_DIAMOND_SWORD = new SwordItem(TofuItemTier.TOFUDIAMOND, 3, -2.4F, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item TOFU_DIAMOND_AXE = new AxeItem(TofuItemTier.TOFUDIAMOND, 5.0F, -3.2F, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item TOFU_DIAMOND_PICKAXE = new PickaxeItem(TofuItemTier.TOFUDIAMOND, 1, -2.8F, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item TOFU_DIAMOND_SHOVEL = new ShovelItem(TofuItemTier.TOFUDIAMOND, 1.5F, -3.0F, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));

	public static final Item ARMOR_TOFU_KINUHELMET = new ArmorItem(TofuArmorMaterial.KINU, EquipmentSlot.HEAD, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item ARMOR_TOFU_KINUCHESTPLATE = new ArmorItem(TofuArmorMaterial.KINU, EquipmentSlot.CHEST, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item ARMOR_TOFU_KINULEGGINGS = new ArmorItem(TofuArmorMaterial.KINU, EquipmentSlot.LEGS, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item ARMOR_TOFU_KINUBOOTS = new ArmorItem(TofuArmorMaterial.KINU, EquipmentSlot.FEET, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));

	public static final Item ARMOR_TOFU_MOMENHELMET = new ArmorItem(TofuArmorMaterial.MOMEN, EquipmentSlot.HEAD, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item ARMOR_TOFU_MOMENCHESTPLATE = new ArmorItem(TofuArmorMaterial.MOMEN, EquipmentSlot.CHEST, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item ARMOR_TOFU_MOMENLEGGINGS = new ArmorItem(TofuArmorMaterial.MOMEN, EquipmentSlot.LEGS, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item ARMOR_TOFU_MOMENBOOTS = new ArmorItem(TofuArmorMaterial.MOMEN, EquipmentSlot.FEET, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));

	public static final Item ARMOR_TOFU_SOLIDHELMET = new ArmorItem(TofuArmorMaterial.SOLID, EquipmentSlot.HEAD, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item ARMOR_TOFU_SOLIDCHESTPLATE = new ArmorItem(TofuArmorMaterial.SOLID, EquipmentSlot.CHEST, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item ARMOR_TOFU_SOLIDLEGGINGS = new ArmorItem(TofuArmorMaterial.SOLID, EquipmentSlot.LEGS, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item ARMOR_TOFU_SOLIDBOOTS = new ArmorItem(TofuArmorMaterial.SOLID, EquipmentSlot.FEET, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));

	public static final Item ARMOR_TOFU_METALHELMET = new ArmorItem(TofuArmorMaterial.METAL, EquipmentSlot.HEAD, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item ARMOR_TOFU_METALCHESTPLATE = new ArmorItem(TofuArmorMaterial.METAL, EquipmentSlot.CHEST, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item ARMOR_TOFU_METALLEGGINGS = new ArmorItem(TofuArmorMaterial.METAL, EquipmentSlot.LEGS, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item ARMOR_TOFU_METALBOOTS = new ArmorItem(TofuArmorMaterial.METAL, EquipmentSlot.FEET, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));

	public static final Item ARMOR_TOFU_DIAMONDHELMET = new ArmorItem(TofuArmorMaterial.DIAMOND, EquipmentSlot.HEAD, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item ARMOR_TOFU_DIAMONDCHESTPLATE = new ArmorItem(TofuArmorMaterial.DIAMOND, EquipmentSlot.CHEST, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item ARMOR_TOFU_DIAMONDLEGGINGS = new ArmorItem(TofuArmorMaterial.DIAMOND, EquipmentSlot.LEGS, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item ARMOR_TOFU_DIAMONDBOOTS = new ArmorItem(TofuArmorMaterial.DIAMOND, EquipmentSlot.FEET, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));

	public static final Item BUGLE = new BugleItem((new Item.Properties()).stacksTo(1).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item TOFUSCOOP = new TofuScoopItem((new Item.Properties()).stacksTo(1).durability(264).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item TOFUSTICK = new TofuStickItem((new Item.Properties()).stacksTo(1).durability(264).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item FUKUMAME = new FukumameItem((new Item.Properties()).stacksTo(1).durability(64).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item NETHER_FUKUMAME = new NetherFukumameItem((new Item.Properties()).stacksTo(1).durability(64).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item SOUL_FUKUMAME = new SoulFukumameItem((new Item.Properties()).stacksTo(1).durability(64).rarity(Rarity.UNCOMMON).tab(TofuCreativeModeTab.TOFUCRAFT));

	public static final Item TOFUNIAN_SPAWNEGG = new SpawnEggItem(TofuEntityTypes.TOFUNIAN, 15460584, 13291425, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item TOFUCOW_SPAWNEGG = new SpawnEggItem(TofuEntityTypes.TOFUCOW, 15460584, 10724259, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item TOFUSLIME_SPAWNEGG = new SpawnEggItem(TofuEntityTypes.TOFUSLIME, 15460584, 3026478, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));
	public static final Item TOFUSPIDER_SPAWNEGG = new SpawnEggItem(TofuEntityTypes.TOFUSPIDER, 15460584, 3026478, (new Item.Properties()).tab(TofuCreativeModeTab.TOFUCRAFT));

	//Tofu delight item
	public static final Item TOMATO_SOYBEAN_STEW = new StackableBowlItem((new Item.Properties()).stacksTo(16).craftRemainder(Items.BOWL).food(TofuFoods.TOMATO_SOYBEAN_STEW).tab(TofuCreativeModeTab.TOFU_DELIGHT));
	public static final Item YUDOFU = new StackableBowlItem((new Item.Properties()).stacksTo(16).craftRemainder(Items.BOWL).food(TofuFoods.YUDOFU).tab(TofuCreativeModeTab.TOFU_DELIGHT));
	public static final Item EDAMAME_RICE = new StackableBowlItem((new Item.Properties()).stacksTo(16).craftRemainder(Items.BOWL).food(TofuFoods.EDAMAME_RICE).tab(TofuCreativeModeTab.TOFU_DELIGHT));
	public static final Item BOTTLE_DASHI = new Item((new Item.Properties()).stacksTo(1).craftRemainder(Items.GLASS_BOTTLE).tab(TofuCreativeModeTab.TOFU_DELIGHT));
	public static final Item TOFU_EGG = new Item((new Item.Properties()).food(TofuFoods.TOFU_EGG).tab(TofuCreativeModeTab.TOFU_DELIGHT));
	public static final Item SOYSAUSE_RAMEN = new StackableBowlItem((new Item.Properties()).stacksTo(16).craftRemainder(Items.BOWL).food(TofuFoods.SOYSAUSE_RAMEN).tab(TofuCreativeModeTab.TOFU_DELIGHT));


	public static void register(RegistryEvent.Register<Item> registry, Item item, String id) {
		item.setRegistryName(new ResourceLocation(TofuCraftReload.MODID, id));
		registry.getRegistry().register(item);
	}

	public static void register(RegistryEvent.Register<Item> registry, Item item) {
		if (item instanceof BlockItem && item.getRegistryName() == null) {
			item.setRegistryName(((BlockItem) item).getBlock().getRegistryName());
		}
		registry.getRegistry().register(item);
	}

	@SubscribeEvent
	public static void registerItems(RegistryEvent.Register<Item> registry) {
		register(registry, TOFUKINU, "tofukinu");
		register(registry, TOFUMOMEN, "tofumomen");
		register(registry, TOFUISHI, "tofuishi");
		register(registry, TOFUMETAL, "tofumetal");
		register(registry, TOFUDIAMOND, "tofudiamond");
		register(registry, TOFUDIAMOND_NUGGET, "tofudiamondnugget");
		register(registry, TOFUHELL, "tofuhell");
		register(registry, TOFUSOUL, "tofusoul");
		register(registry, TOFUGRILLED, "tofugrilled");
		register(registry, TOFUZUNDA, "tofuzunda");
		register(registry, TOFUMISO, "tofumiso");

		register(registry, BITTERN, "bittern_bottle");
		register(registry, SALT, "salt");

		register(registry, BUGLE, "bugle");
		register(registry, TOFUSCOOP, "tofuscoop");
		register(registry, TOFUSTICK, "tofustick");
		register(registry, FUKUMAME, "fukumame");
		register(registry, NETHER_FUKUMAME, "nether_fukumame");
		register(registry, SOUL_FUKUMAME, "soul_fukumame");

		register(registry, SEEDS_SOYBEANS, "seeds_soybeans");
		register(registry, SEEDS_SOYBEANS_NETHER, "seeds_soybeans_nether");
		register(registry, SEEDS_SOYBEANS_SOUL, "seeds_soybeans_soul");
		register(registry, SOYBEAN_PARCHED, "soybeans_parched");
		register(registry, KINAKO, "kinako");
		register(registry, EDAMAME, "edamame");
		register(registry, BOILED_EDAMAME, "edamame_boild");

		register(registry, KOUJI_BASE, "koujibase");
		register(registry, KOUJI, "kouji");

		register(registry, MISO, "miso");
		register(registry, BOTTLE_SOYSAUSE, "bottle_soysause");

		register(registry, LEEK, "leek");
		register(registry, YUBA, "yuba");

		register(registry, ZUNDA, "zunda");
		register(registry, ZUNDAMA, "zundama");
		register(registry, ZUNDARUBY, "zundaruby");
		register(registry, TOFU_HAMBURG_RAW, "tofuhamburg_raw");
		register(registry, TOFU_HAMBURG, "tofuhamburg");
		register(registry, RAW_TOFU_FISH, "raw_tofufish");
		register(registry, COOKED_TOFU_FISH, "cooked_tofufish");
		register(registry, TOFUCOOKIE, "tofucookie");
		register(registry, SOYSTICK, "soystick");
		register(registry, SALTYMELON, "saltymelon");
		register(registry, SOYMILK, "soymilk");
		register(registry, SOYMILK_APPLE, "soymilk_apple");
		register(registry, SOYMILK_COCOA, "soymilk_cocoa");
		register(registry, SOYMILK_KINAKO, "soymilk_kinako");
		register(registry, SOYMILK_PUDDING, "soymilk_pudding");
		register(registry, SOYMILK_PUMPKIN, "soymilk_pumpkin");

		register(registry, KINAKO_MANJU, "kinakomanju");
		register(registry, ZUNDA_MANJU, "zundamanju");
		register(registry, NETHER_MANJU, "nethermanju");
		register(registry, SOUL_MANJU, "soulmanju");

		register(registry, KINAKO_MOCHI, "kinako_mochi");
		register(registry, ZUNDA_MOCHI, "zunda_mochi");

		register(registry, SOY_CHOCOLATE, "soy_chocolate");
		register(registry, TOFUNIAN_SOY_CHOCOLATE, "tofunian_soy_chocolate");
		register(registry, BUCKET_SOYMILK, "bucket_soymilk");
		register(registry, BUCKET_SOYMILK_NETHER, "bucket_soymilk_nether");
		register(registry, BUCKET_SOYMILK_SOUL, "bucket_soymilk_soul");
		register(registry, TOFUFISH_BUCKET, "tofufish_bucket");
		register(registry, TOFUFISH_SOYMILK_BUCKET, "tofufish_soymilk_bucket");
		register(registry, BUCKET_BITTERN, "bucket_bittern");
		register(registry, TOFU_KINU_SWORD, "tofu_kinu_sword");
		register(registry, TOFU_KINU_AXE, "tofu_kinu_axe");
		register(registry, TOFU_KINU_PICKAXE, "tofu_kinu_pickaxe");
		register(registry, TOFU_KINU_SHOVEL, "tofu_kinu_shovel");
		register(registry, TOFU_MOMEN_SWORD, "tofu_momen_sword");
		register(registry, TOFU_MOMEN_AXE, "tofu_momen_axe");
		register(registry, TOFU_MOMEN_PICKAXE, "tofu_momen_pickaxe");
		register(registry, TOFU_MOMEN_SHOVEL, "tofu_momen_shovel");
		register(registry, TOFU_SOLID_SWORD, "tofu_solid_sword");
		register(registry, TOFU_SOLID_AXE, "tofu_solid_axe");
		register(registry, TOFU_SOLID_PICKAXE, "tofu_solid_pickaxe");
		register(registry, TOFU_SOLID_SHOVEL, "tofu_solid_shovel");
		register(registry, TOFU_METAL_SWORD, "tofu_metal_sword");
		register(registry, TOFU_METAL_PICKAXE, "tofu_metal_pickaxe");
		register(registry, TOFU_METAL_AXE, "tofu_metal_axe");
		register(registry, TOFU_METAL_SHOVEL, "tofu_metal_shovel");
		register(registry, TOFU_DIAMOND_SWORD, "tofu_diamond_sword");
		register(registry, TOFU_DIAMOND_AXE, "tofu_diamond_axe");
		register(registry, TOFU_DIAMOND_PICKAXE, "tofu_diamond_pickaxe");
		register(registry, TOFU_DIAMOND_SHOVEL, "tofu_diamond_shovel");
		register(registry, ARMOR_TOFU_KINUHELMET, "tofu_kinu_helmet");
		register(registry, ARMOR_TOFU_KINUCHESTPLATE, "tofu_kinu_chestplate");
		register(registry, ARMOR_TOFU_KINULEGGINGS, "tofu_kinu_leggings");
		register(registry, ARMOR_TOFU_KINUBOOTS, "tofu_kinu_boots");
		register(registry, ARMOR_TOFU_MOMENHELMET, "tofu_momen_helmet");
		register(registry, ARMOR_TOFU_MOMENCHESTPLATE, "tofu_momen_chestplate");
		register(registry, ARMOR_TOFU_MOMENLEGGINGS, "tofu_momen_leggings");
		register(registry, ARMOR_TOFU_MOMENBOOTS, "tofu_momen_boots");
		register(registry, ARMOR_TOFU_SOLIDHELMET, "tofu_solid_helmet");
		register(registry, ARMOR_TOFU_SOLIDCHESTPLATE, "tofu_solid_chestplate");
		register(registry, ARMOR_TOFU_SOLIDLEGGINGS, "tofu_solid_leggings");
		register(registry, ARMOR_TOFU_SOLIDBOOTS, "tofu_solid_boots");
		register(registry, ARMOR_TOFU_METALHELMET, "tofu_metal_helmet");
		register(registry, ARMOR_TOFU_METALCHESTPLATE, "tofu_metal_chestplate");
		register(registry, ARMOR_TOFU_METALLEGGINGS, "tofu_metal_leggings");
		register(registry, ARMOR_TOFU_METALBOOTS, "tofu_metal_boots");
		register(registry, ARMOR_TOFU_DIAMONDHELMET, "tofu_diamond_helmet");
		register(registry, ARMOR_TOFU_DIAMONDCHESTPLATE, "tofu_diamond_chestplate");
		register(registry, ARMOR_TOFU_DIAMONDLEGGINGS, "tofu_diamond_leggings");
		register(registry, ARMOR_TOFU_DIAMONDBOOTS, "tofu_diamond_boots");

		register(registry, TOFUNIAN_SPAWNEGG, "tofunian_spawnegg");
		register(registry, TOFUCOW_SPAWNEGG, "tofucow_spawnegg");
		register(registry, TOFUSLIME_SPAWNEGG, "tofuslime_spawnegg");
		register(registry, TOFUSPIDER_SPAWNEGG, "tofuspider_spawnegg");

		register(registry, TOMATO_SOYBEAN_STEW, "tomato_soybean_stew");
		register(registry, YUDOFU, "yudofu");
		register(registry, EDAMAME_RICE, "edamame_rice");
		register(registry, BOTTLE_DASHI, "bottle_dashi");
		register(registry, TOFU_EGG, "tofuegg");
		register(registry, SOYSAUSE_RAMEN, "soysause_ramen");

		DispenseItemBehavior dispenseitembehavior1 = new DefaultDispenseItemBehavior() {
			private final DefaultDispenseItemBehavior defaultDispenseItemBehavior = new DefaultDispenseItemBehavior();

			public ItemStack execute(BlockSource p_123561_, ItemStack p_123562_) {
				DispensibleContainerItem dispensiblecontaineritem = (DispensibleContainerItem) p_123562_.getItem();
				BlockPos blockpos = p_123561_.getPos().relative(p_123561_.getBlockState().getValue(DispenserBlock.FACING));
				Level level = p_123561_.getLevel();
				if (dispensiblecontaineritem.emptyContents((Player) null, level, blockpos, (BlockHitResult) null)) {
					dispensiblecontaineritem.checkExtraContent((Player) null, level, p_123562_, blockpos);
					return new ItemStack(Items.BUCKET);
				} else {
					return this.defaultDispenseItemBehavior.dispense(p_123561_, p_123562_);
				}
			}
		};
		DispenserBlock.registerBehavior(BUCKET_SOYMILK, dispenseitembehavior1);
		DispenserBlock.registerBehavior(BUCKET_SOYMILK_NETHER, dispenseitembehavior1);
		DispenserBlock.registerBehavior(BUCKET_SOYMILK_SOUL, dispenseitembehavior1);
		DispenserBlock.registerBehavior(BUCKET_BITTERN, dispenseitembehavior1);
		DispenseItemBehavior dispenseitembehavior2 = new DefaultDispenseItemBehavior() {
			private final DefaultDispenseItemBehavior defaultDispenseItemBehavior = new DefaultDispenseItemBehavior();

			public ItemStack execute(BlockSource p_123561_, ItemStack p_123562_) {
				BlockPos blockpos = p_123561_.getPos().relative(p_123561_.getBlockState().getValue(DispenserBlock.FACING));
				FluidState fluidState = p_123561_.getLevel().getFluidState(blockpos);
				ItemStack result = RecipeHelper.getBitternResult(fluidState.getType());
				if (result != null) {
					p_123561_.getLevel().setBlock(blockpos, Block.byItem(result.getItem()).defaultBlockState(), 11);
					p_123561_.getLevel().levelEvent(2001, blockpos, Block.getId(p_123561_.getLevel().getBlockState(blockpos)));
					p_123562_.shrink(1);
					this.defaultDispenseItemBehavior.dispense(p_123561_, new ItemStack(Items.GLASS_BOTTLE));
				}
				return p_123562_;
			}
		};
		DispenserBlock.registerBehavior(BITTERN, dispenseitembehavior2);
		DispenseItemBehavior dispenseitembehavior3 = new DefaultDispenseItemBehavior() {
			private boolean success = false;
			private final DefaultDispenseItemBehavior defaultDispenseItemBehavior = new DefaultDispenseItemBehavior();

			public ItemStack execute(BlockSource p_123561_, ItemStack p_123562_) {
				BlockPos blockpos = p_123561_.getPos().relative(p_123561_.getBlockState().getValue(DispenserBlock.FACING));
				if (p_123561_.getLevel().getBlockState(blockpos).is(TofuTags.Blocks.SOFT_TOFU)) {
					ItemStack stack = new ItemStack(Item.BY_BLOCK.get(p_123561_.getLevel().getBlockState(blockpos).getBlock()));
					p_123561_.getLevel().levelEvent(2001, blockpos, Block.getId(p_123561_.getLevel().getBlockState(blockpos)));
					p_123561_.getLevel().removeBlock(blockpos, false);
					this.defaultDispenseItemBehavior.dispense(p_123561_, stack);
					p_123562_.hurt(1, p_123561_.getLevel().getRandom(), null);
					setSuccess(true);
				}
				return p_123562_;
			}

			public boolean isSuccess() {
				return this.success;
			}

			public void setSuccess(boolean p_123574_) {
				this.success = p_123574_;
			}

			protected void playSound(BlockSource p_123572_) {
				p_123572_.getLevel().levelEvent(this.isSuccess() ? 1000 : 1001, p_123572_.getPos(), 0);
			}
		};
		DispenserBlock.registerBehavior(TOFUSCOOP, dispenseitembehavior3);

		ComposterBlock.COMPOSTABLES.put(TofuItems.EDAMAME, 0.1F);
		ComposterBlock.COMPOSTABLES.put(TofuItems.BOILED_EDAMAME, 0.1F);
		ComposterBlock.COMPOSTABLES.put(TofuItems.SEEDS_SOYBEANS, 0.3F);
		ComposterBlock.COMPOSTABLES.put(TofuItems.SEEDS_SOYBEANS_NETHER, 0.3F);
		ComposterBlock.COMPOSTABLES.put(TofuItems.SEEDS_SOYBEANS_SOUL, 0.3F);
	}
}
