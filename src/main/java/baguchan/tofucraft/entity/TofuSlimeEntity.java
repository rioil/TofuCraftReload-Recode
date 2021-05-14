package baguchan.tofucraft.entity;

import baguchan.tofucraft.registry.TofuItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.SpawnReason;
import net.minecraft.entity.monster.SlimeEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.particles.IParticleData;
import net.minecraft.particles.ItemParticleData;
import net.minecraft.particles.ParticleTypes;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.Difficulty;
import net.minecraft.world.IServerWorld;
import net.minecraft.world.LightType;
import net.minecraft.world.World;

import java.util.Random;

public class TofuSlimeEntity extends SlimeEntity {
	public TofuSlimeEntity(EntityType<? extends TofuSlimeEntity> p_i48552_1_, World p_i48552_2_) {
		super(p_i48552_1_, p_i48552_2_);
	}

	public static boolean checkTofuSlimeSpawnRules(EntityType<? extends TofuSlimeEntity> p_223366_0_, IServerWorld p_223366_1_, SpawnReason p_223366_2_, BlockPos p_223366_3_, Random p_223366_4_) {
		if (p_223366_1_.getDifficulty() != Difficulty.PEACEFUL) {
			if (!(p_223366_1_ instanceof net.minecraft.world.ISeedReader))
				return false;
			if (p_223366_4_.nextInt(10) == 0)
				return isDarkEnoughToSpawn(p_223366_1_, p_223366_3_, p_223366_4_);
		}
		return false;
	}

	public static boolean isDarkEnoughToSpawn(IServerWorld p_223323_0_, BlockPos p_223323_1_, Random p_223323_2_) {
		if (p_223323_0_.getBrightness(LightType.SKY, p_223323_1_) > p_223323_2_.nextInt(32)) {
			return false;
		} else {
			int i = p_223323_0_.getLevel().isThundering() ? p_223323_0_.getMaxLocalRawBrightness(p_223323_1_, 10) : p_223323_0_.getMaxLocalRawBrightness(p_223323_1_);
			return i <= p_223323_2_.nextInt(8);
		}
	}


	@Override
	protected IParticleData getParticleType() {
		return new ItemParticleData(ParticleTypes.ITEM, new ItemStack(TofuItems.TOFUKINU));
	}
}
