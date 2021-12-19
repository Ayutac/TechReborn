package techreborn.blockentity.machine.tier3;

import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import reborncore.client.screen.BuiltScreenHandlerProvider;
import reborncore.client.screen.builder.BlockEntityScreenHandlerBuilder;
import reborncore.client.screen.builder.BuiltScreenHandler;
import reborncore.client.screen.builder.ScreenHandlerBuilder;
import reborncore.common.blockentity.MachineBaseBlockEntity;
import reborncore.common.util.RebornInventory;
import techreborn.blockentity.machine.GenericMachineBlockEntity;
import techreborn.config.TechRebornConfig;
import techreborn.init.TRBlockEntities;
import techreborn.init.TRContent;
import techreborn.items.DynamicCellItem;

public class QuarryBlockEntity extends GenericMachineBlockEntity implements BuiltScreenHandlerProvider {

	public static final int TOOL_SLOT_AMOUNT = 5;

	public static final int LOOT_SLOT_AMOUNT = 5;

	public QuarryBlockEntity(BlockPos pos, BlockState state) {
		super(TRBlockEntities.QUARRY, pos, state, "Quarry", TechRebornConfig.quarryMaxInput, TechRebornConfig.quarryMaxEnergy, TRContent.Machine.QUARRY.block, 10);
		this.inventory = new RebornInventory<>(TOOL_SLOT_AMOUNT + LOOT_SLOT_AMOUNT + 1, "QuarryBlockEntity", 64, this);
	}

	public BuiltScreenHandler createScreenHandler(int syncID, PlayerEntity player) {
		BlockEntityScreenHandlerBuilder builder = new ScreenHandlerBuilder("quarry").player(player.getInventory()).inventory().hotbar().addInventory().blockEntity(this);
		for (int k = 0; k < TOOL_SLOT_AMOUNT; k++) // tool slots
			builder = builder.filterSlot(k, 18 * k + 44, 22, stack -> stack.isDamageable() || stack.isOf(Items.BUCKET) || ItemStack.areNbtEqual(stack, DynamicCellItem.getEmptyCell(1)));
		for (int k = 0; k < LOOT_SLOT_AMOUNT; k++) // output slots
			builder = builder.outputSlot(TOOL_SLOT_AMOUNT + k, 18 * k + 44, 54);
		return builder.energySlot(TOOL_SLOT_AMOUNT + LOOT_SLOT_AMOUNT, 8, 72).syncEnergyValue().addInventory().create(this, syncID);
	}
}
