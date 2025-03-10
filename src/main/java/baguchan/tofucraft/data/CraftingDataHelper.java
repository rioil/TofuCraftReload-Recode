package baguchan.tofucraft.data;

import baguchan.tofucraft.TofuCraftReload;
import baguchan.tofucraft.registry.TofuBlocks;
import net.minecraft.data.DataGenerator;
import net.minecraft.data.recipes.*;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.Tag;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.ItemLike;
import net.minecraft.world.level.block.Block;
import net.minecraftforge.common.crafting.NBTIngredient;
import net.minecraftforge.registries.RegistryObject;

import java.lang.reflect.Constructor;
import java.util.function.Consumer;

public abstract class CraftingDataHelper extends RecipeProvider {
	public CraftingDataHelper(DataGenerator generator) {
		super(generator);
	}

	protected final Ingredient itemWithNBT(RegistryObject<? extends ItemLike> item, Consumer<CompoundTag> nbtSetter) {
		return itemWithNBT(item.get(), nbtSetter);
	}

	protected final Ingredient itemWithNBT(ItemLike item, Consumer<CompoundTag> nbtSetter) {
		ItemStack stack = new ItemStack(item);

		CompoundTag nbt = new CompoundTag();
		nbtSetter.accept(nbt);
		stack.setTag(nbt);

		try {
			Constructor<NBTIngredient> constructor = NBTIngredient.class.getDeclaredConstructor(ItemStack.class);

			constructor.setAccessible(true);

			return constructor.newInstance(stack);
		} catch (Throwable e) {
			e.printStackTrace();
		}

		// This will just defer to the regular Ingredient method instead of some overridden thing, but whatever.
		// Forge PRs are too slow to even feel motivated about fixing it on the Forge end.
		return Ingredient.of(stack);
	}

	protected final void foodCooking(Item material, Item result, float xp, Consumer<FinishedRecipe> consumer) {
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(material), result, xp, 200).unlockedBy("has_item", has(material)).save(consumer, TofuCraftReload.prefix("smelting_" + result.getRegistryName().getPath()));
		SimpleCookingRecipeBuilder.smoking(Ingredient.of(material), result, xp, 100).unlockedBy("has_item", has(material)).save(consumer, TofuCraftReload.prefix("smoking_" + result.getRegistryName().getPath()));
		SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(material), result, xp, 600).unlockedBy("has_item", has(material)).save(consumer, TofuCraftReload.prefix("campfire_cooking_" + result.getRegistryName().getPath()));
	}

	protected final void foodCooking(Item material, Item result, float xp, Consumer<FinishedRecipe> consumer, String recipeName) {
		SimpleCookingRecipeBuilder.smelting(Ingredient.of(material), result, xp, 200).unlockedBy("has_item", has(material)).save(consumer, TofuCraftReload.prefix("smelting_" + recipeName));
		SimpleCookingRecipeBuilder.smoking(Ingredient.of(material), result, xp, 100).unlockedBy("has_item", has(material)).save(consumer, TofuCraftReload.prefix("smoking_" + recipeName));
		SimpleCookingRecipeBuilder.campfireCooking(Ingredient.of(material), result, xp, 600).unlockedBy("has_item", has(material)).save(consumer, TofuCraftReload.prefix("campfire_cooking_" + recipeName));
	}

	public static void cuttingRecipe(Consumer<FinishedRecipe> consumer, Item cuttingItem, Item result) {
		SingleItemRecipeBuilder.stonecutting(Ingredient.of(cuttingItem), result).unlockedBy("has_item", has(cuttingItem)).save(consumer, TofuCraftReload.prefix("cutting_" + result.getRegistryName().getPath()));
	}

	public static void tofuDiamondSmithing(Consumer<FinishedRecipe> consumer, Item smithItem, Item result) {
		UpgradeRecipeBuilder.smithing(Ingredient.of(smithItem), Ingredient.of(TofuBlocks.DIAMONDTOFU), result).unlocks("has_tofudiamond", has(TofuBlocks.DIAMONDTOFU)).save(consumer, TofuCraftReload.prefix("smithing_" + result.getRegistryName().getPath()));
	}

	protected final void helmetItem(Consumer<FinishedRecipe> consumer, String name, Item result, Item material) {
		ShapedRecipeBuilder.shaped(result)
				.pattern("###")
				.pattern("# #")
				.define('#', material)
				.unlockedBy("has_item", has(material))
				.save(consumer, locEquip(name));
	}

	protected final void chestplateItem(Consumer<FinishedRecipe> consumer, String name, Item result, Item material) {
		ShapedRecipeBuilder.shaped(result)
				.pattern("# #")
				.pattern("###")
				.pattern("###")
				.define('#', material)
				.unlockedBy("has_item", has(material))
				.save(consumer, locEquip(name));
	}

	protected final void leggingsItem(Consumer<FinishedRecipe> consumer, String name, Item result, Item material) {
		ShapedRecipeBuilder.shaped(result)
				.pattern("###")
				.pattern("# #")
				.pattern("# #")
				.define('#', material)
				.unlockedBy("has_item", has(material))
				.save(consumer, locEquip(name));
	}

	protected final void bootsItem(Consumer<FinishedRecipe> consumer, String name, Item result, Item material) {
		ShapedRecipeBuilder.shaped(result)
				.pattern("# #")
				.pattern("# #")
				.define('#', material)
				.unlockedBy("has_item", has(material))
				.save(consumer, locEquip(name));
	}

	protected final void pickaxeItem(Consumer<FinishedRecipe> consumer, String name, Item result, Item material, Tag.Named<Item> handle) {
		ShapedRecipeBuilder.shaped(result)
				.pattern("###")
				.pattern(" X ")
				.pattern(" X ")
				.define('#', material)
				.define('X', handle)
				.unlockedBy("has_item", has(material))
				.save(consumer, locEquip(name));
	}

	protected final void swordItem(Consumer<FinishedRecipe> consumer, String name, Item result, Item material, Tag.Named<Item> handle) {
		ShapedRecipeBuilder.shaped(result)
				.pattern("#")
				.pattern("#")
				.pattern("X")
				.define('#', material)
				.define('X', handle)
				.unlockedBy("has_item", has(material))
				.save(consumer, locEquip(name));
	}

	protected final void axeItem(Consumer<FinishedRecipe> consumer, String name, Item result, Item material, Tag.Named<Item> handle) {
		ShapedRecipeBuilder.shaped(result)
				.pattern("##")
				.pattern("#X")
				.pattern(" X")
				.define('#', material)
				.define('X', handle)
				.unlockedBy("has_item", has(material))
				.save(consumer, locEquip(name));
	}

	protected final void shovelItem(Consumer<FinishedRecipe> consumer, String name, Item result, Item material, Tag.Named<Item> handle) {
		ShapedRecipeBuilder.shaped(result)
				.pattern("#")
				.pattern("X")
				.pattern("X")
				.define('#', material)
				.define('X', handle)
				.unlockedBy("has_item", has(material))
				.save(consumer, locEquip(name));
	}

	protected final void tofuBlockItem(Consumer<FinishedRecipe> consumer, Item result, Item material) {
		ShapedRecipeBuilder.shaped(result)
				.pattern("##")
				.pattern("##")
				.define('#', material)
				.unlockedBy("has_item", has(material))
				.save(consumer);
	}

	protected final void tofuBlockItem(Consumer<FinishedRecipe> consumer, Item result, Item material, String name) {
		ShapedRecipeBuilder.shaped(result)
				.pattern("##")
				.pattern("##")
				.define('#', material)
				.unlockedBy("has_item", has(material))
				.save(consumer, TofuCraftReload.prefix(name));
	}

	protected final void ladderItem(Consumer<FinishedRecipe> consumer, Item result, Item material) {
		ShapedRecipeBuilder.shaped(result, 6)
				.pattern("# #")
				.pattern("###")
				.pattern("# #")
				.define('#', material)
				.unlockedBy("has_item", has(material))
				.save(consumer);
	}

	protected final void decorationTofuBlockItem(Consumer<FinishedRecipe> consumer, Item result, Item material) {
		ShapedRecipeBuilder.shaped(result, 4)
				.pattern("##")
				.pattern("##")
				.define('#', material)
				.unlockedBy("has_item", has(material))
				.save(consumer);
	}

	public void makeStairs(Consumer<FinishedRecipe> consumer, Block stairsOut, Block blockIn) {
		ShapedRecipeBuilder.shaped(stairsOut, 4)
				.pattern("M  ")
				.pattern("MM ")
				.pattern("MMM")
				.define('M', blockIn)
				.unlockedBy("has_" + blockIn.getRegistryName().getPath(), has(blockIn)).save(consumer);
	}

	public void makeStairsCraftingOrCutting(Consumer<FinishedRecipe> consumer, Block stairsOut, Block blockIn) {
		makeStairs(consumer, stairsOut, blockIn);
		cuttingRecipe(consumer, blockIn.asItem(), stairsOut.asItem());
	}

	public void makeSlab(Consumer<FinishedRecipe> consumer, Block slabOut, Block blockIn) {
		ShapedRecipeBuilder.shaped(slabOut, 6)
				.pattern("MMM")
				.define('M', blockIn)
				.unlockedBy("has_" + blockIn.getRegistryName().getPath(), has(blockIn)).save(consumer);
	}

	public void makeSlabCraftingOrCutting(Consumer<FinishedRecipe> consumer, Block slabOut, Block blockIn) {
		makeSlab(consumer, slabOut, blockIn);
		cuttingRecipe(consumer, blockIn.asItem(), slabOut.asItem());
	}

	public void makeFence(Consumer<FinishedRecipe> consumer, Block fenceOut, Block blockIn) {
		ShapedRecipeBuilder.shaped(fenceOut, 6)
				.pattern("MMM")
				.pattern("MMM")
				.define('M', blockIn)
				.unlockedBy("has_" + blockIn.getRegistryName().getPath(), has(blockIn)).save(consumer);
	}

	public void makeTorch(Consumer<FinishedRecipe> consumer, Block torchOut, Block blockIn) {
		ShapedRecipeBuilder.shaped(torchOut, 4)
				.pattern("C")
				.pattern("M")
				.define('C', ItemTags.COALS)
				.define('M', blockIn)
				.unlockedBy("has_" + blockIn.getRegistryName().getPath(), has(blockIn)).save(consumer);
	}


	protected final ResourceLocation locEquip(String name) {
		return TofuCraftReload.prefix("equipment/" + name);
	}
}