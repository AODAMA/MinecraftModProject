package net.ewen.mossupdate.block.custom;

import net.ewen.mossupdate.block.ModBlocks;
import net.ewen.mossupdate.item.ModItems;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.item.AxeItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraftforge.common.ToolAction;

import javax.annotation.Nullable;
import javax.naming.Context;

public class ModFlammableRotatedPillarBlock extends RotatedPillarBlock {
    public ModFlammableRotatedPillarBlock(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public boolean isFlammable(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return true;
    }

    @Override
    public int getFlammability(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public int getFireSpreadSpeed(BlockState state, BlockGetter level, BlockPos pos, Direction direction) {
        return 5;
    }

    @Override
    public @Nullable BlockState getToolModifiedState(BlockState state, UseOnContext context, ToolAction toolAction, boolean simulate) {
        Item itemInHand = context.getItemInHand().getItem();
        BlockState clickedBlockState = context.getLevel().getBlockState(context.getClickedPos());

        if (itemInHand instanceof AxeItem) {
            // Drop an item and return the modified block state
            dropItem(context.getLevel(), context.getClickedPos());

            // Check if the clicked block is oak log
            if (clickedBlockState.getBlock() == ModBlocks.MOSSY_OAK_LOG.get()) {
                return Blocks.OAK_LOG.defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            // Add more conditions for other log types here
            else if (clickedBlockState.getBlock() == ModBlocks.MOSSY_BIRCH_LOG.get()) {
                return Blocks.BIRCH_LOG.defaultBlockState().setValue(AXIS, state.getValue(AXIS));
            }
            // Add more conditions for other log types here
            // Add more conditions for other log types here
        }
        return super.getToolModifiedState(state, context, toolAction, simulate);
    }

    private void dropItem(Level level, BlockPos pos) {
        // Drop the specified item
        level.setBlockAndUpdate(pos, Blocks.AIR.defaultBlockState());
        level.addFreshEntity(new ItemEntity(level, pos.getX(), pos.getY(), pos.getZ(), new ItemStack(ModItems.MOSS_SPORES.get())));
    }

}




