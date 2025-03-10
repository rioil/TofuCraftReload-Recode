package baguchan.tofucraft.inventory;

import baguchan.tofucraft.registry.TofuContainers;
import net.minecraft.world.Container;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.inventory.ContainerData;
import net.minecraft.world.inventory.SimpleContainerData;
import net.minecraft.world.inventory.Slot;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.Level;
import net.minecraftforge.api.distmarker.Dist;
import net.minecraftforge.api.distmarker.OnlyIn;

public class SaltFurnaceMenu extends AbstractContainerMenu {
	private final Container container;

	private final ContainerData data;

	protected final Level level;

	public SaltFurnaceMenu(int i, Inventory playerInventory) {
		this(i, playerInventory, new SimpleContainer(4), new SimpleContainerData(4));
	}

	public SaltFurnaceMenu(int id, Inventory playerInventoryIn, Container furnaceInventoryIn, ContainerData dataIn) {
		super(TofuContainers.SALT_FURNACE, id);
		this.container = furnaceInventoryIn;
		this.data = dataIn;
		this.level = playerInventoryIn.player.level;
		furnaceInventoryIn.startOpen(playerInventoryIn.player);
		addSlot(new Slot(this.container, 0, 23, 53));
		addSlot(new Slot(this.container, 1, 80, 53) {
			@Override
			public boolean mayPlace(ItemStack p_40231_) {
				return false;
			}
		});
		addSlot(new Slot(this.container, 2, 124, 20));
		addSlot(new Slot(this.container, 3, 102, 53) {
			@Override
			public boolean mayPlace(ItemStack p_40231_) {
				return false;
			}
		});
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 9; j++)
				addSlot(new Slot(playerInventoryIn, j + i * 9 + 9, 8 + j * 18, 84 + i * 18));
		}
		for (int k = 0; k < 9; k++)
			addSlot(new Slot(playerInventoryIn, k, 8 + k * 18, 142));
		this.addDataSlots(dataIn);
	}

	public boolean stillValid(Player p_75145_1_) {
		return this.container.stillValid(p_75145_1_);
	}


	public ItemStack quickMoveStack(Player p_82846_1_, int slotIndex) {
		ItemStack itemstack = ItemStack.EMPTY;
		Slot slot = this.slots.get(slotIndex);
		if (slot != null && slot.hasItem()) {
			ItemStack itemstack1 = slot.getItem();
			itemstack = itemstack1.copy();
			switch (slotIndex) {
				case 0:
					if (!moveItemStackTo(itemstack1, 4, 40, true))
						return ItemStack.EMPTY;
					break;
				default:
					if (!moveItemStackTo(itemstack1, 0, 0, false))
						return ItemStack.EMPTY;
					break;
			}

			slot.onQuickCraft(itemstack1, itemstack);
			if (itemstack1.isEmpty()) {
				slot.set(ItemStack.EMPTY);
			} else {
				slot.setChanged();
			}
			if (itemstack1.getCount() == itemstack.getCount())
				return ItemStack.EMPTY;
			slot.onTake(p_82846_1_, itemstack1);
		}
		return itemstack;
	}

	@OnlyIn(Dist.CLIENT)
	public int getBurnProgress() {
		int i = this.data.get(2);
		int j = this.data.get(3);
		return (j != 0 && i != 0) ? (i * 24 / j) : 0;
	}

	@OnlyIn(Dist.CLIENT)
	public int getLitProgress() {
		int i = this.data.get(1);
		if (i == 0)
			i = 200;
		return this.data.get(0) * 13 / i;
	}

	@OnlyIn(Dist.CLIENT)
	public boolean isLit() {
		return (this.data.get(0) > 0);
	}
}
