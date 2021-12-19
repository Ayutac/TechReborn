package techreborn.blockentity.machine.tier3;

import net.minecraft.block.BlockState;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.util.math.BlockPos;
import reborncore.client.screen.BuiltScreenHandlerProvider;
import reborncore.client.screen.builder.BuiltScreenHandler;
import reborncore.client.screen.builder.ScreenHandlerBuilder;
import reborncore.common.blockentity.MachineBaseBlockEntity;
import techreborn.init.TRBlockEntities;

public class QuarryBlockEntity extends MachineBaseBlockEntity implements BuiltScreenHandlerProvider {

	public QuarryBlockEntity(BlockPos pos, BlockState state) {
		super(TRBlockEntities.QUARRY, pos, state);
	}

	public BuiltScreenHandler createScreenHandler(int syncID, PlayerEntity player) {
		return new ScreenHandlerBuilder("quarry").player(player.getInventory()).inventory().hotbar().addInventory()
				//.blockEntity(this).sync(this::getRadius, this::setRadius).addInventory()
				.create(this, syncID);
	}
}
