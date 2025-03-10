package baguchan.tofucraft.world.gen.feature;

import baguchan.tofucraft.registry.TofuBlocks;
import com.mojang.serialization.Codec;
import net.minecraft.core.BlockPos;
import net.minecraft.world.level.WorldGenLevel;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.levelgen.feature.Feature;
import net.minecraft.world.level.levelgen.feature.FeaturePlaceContext;
import net.minecraft.world.level.levelgen.feature.configurations.NoneFeatureConfiguration;

import java.util.Random;

public class BigLeekFeature extends Feature<NoneFeatureConfiguration> {
	public BigLeekFeature(Codec<NoneFeatureConfiguration> codec) {
		super(codec);
	}

	@Override
	public boolean place(FeaturePlaceContext<NoneFeatureConfiguration> p_159749_) {
		if (!p_159749_.level().isEmptyBlock(p_159749_.origin()))
			return false;
		BlockState blockstate = p_159749_.level().getBlockState(p_159749_.origin().below());
		if (!blockstate.is(TofuBlocks.TOFU_TERRAIN))
			return false;
		if (p_159749_.random().nextInt(6) != 0) {
			setBigLeekBlock(p_159749_.level(), p_159749_.random(), p_159749_.origin());
		} else {
			setLeekBlock(p_159749_.level(), p_159749_.random(), p_159749_.origin());
		}

		return true;
	}

	private void setBigLeekBlock(WorldGenLevel level, Random rand, BlockPos pos) {
		int height = 8 + rand.nextInt(4);
		for (int i = 0; i < height; i++) {
			for (BlockPos blockpos1 : BlockPos.betweenClosed(pos.offset(-1, -0, -1), pos.offset(1, 0, 1))) {
				if ((height - i) < height / 2.5D) {
					level.setBlock(blockpos1.above(i), TofuBlocks.LEEK_GREEN_STEM.defaultBlockState(), 2);
				} else {
					level.setBlock(blockpos1.above(i), TofuBlocks.LEEK_STEM.defaultBlockState(), 2);
				}
			}
		}
	}

	private void setLeekBlock(WorldGenLevel level, Random rand, BlockPos pos) {
		int height = 4 + rand.nextInt(4);
		for (int i = 0; i < height; i++) {
			if ((height - i) < height / 2.5D) {
				level.setBlock(pos.above(i), TofuBlocks.LEEK_GREEN_STEM.defaultBlockState(), 2);
			} else {
				level.setBlock(pos.above(i), TofuBlocks.LEEK_STEM.defaultBlockState(), 2);
			}
		}
	}
}
