package baguchan.tofucraft.api.tfenergy;

import baguchan.tofucraft.registry.TofuItems;
import net.minecraft.world.item.ItemStack;
import net.minecraftforge.fluids.FluidStack;

import java.util.HashMap;
import java.util.Map;

public class TofuEnergyMap {
	private static HashMap<ItemStack, Integer> recipes = new HashMap<>();
	private static HashMap<FluidStack, Integer> fluidRecipes = new HashMap<>();

	public static void init() {
		register(new ItemStack(TofuItems.TOFUKINU, 1), 100);
		register(new ItemStack(TofuItems.TOFUMOMEN, 1), 100);
		register(new ItemStack(TofuItems.TOFUISHI, 1), 100);
	}

	public static void register(ItemStack item, int loader) {
		recipes.put(item, loader);
	}

	public static void register(FluidStack fluid, int loader) {
		fluidRecipes.put(fluid, loader);
	}

	public static int getFuel(ItemStack item) {
		for (ItemStack rep : recipes.keySet()) {
			if (rep.getItem().equals(item.getItem()))
				return recipes.get(rep);
		}
		return -1;
	}

	public static Map.Entry<FluidStack, Integer> getLiquidFuel(FluidStack fluid) {
		for (Map.Entry<FluidStack, Integer> rep : fluidRecipes.entrySet()) {
			if (rep.getKey().getFluid().equals(fluid.getFluid()))
				return rep;
		}
		return null;
	}
}