package net.ewen.mossupdate.item.custom;

import net.minecraft.core.BlockPos;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import org.jetbrains.annotations.NotNull;
import net.ewen.mossupdate.block.ModBlocks;

public class MossSporeItem extends Item {
    public MossSporeItem(Properties pProperties) {
        super(pProperties);
    }

    @Override
    public @NotNull InteractionResult useOn(UseOnContext pContext) {
        Level world = pContext.getLevel();
        BlockPos pos = pContext.getClickedPos();
        BlockState state = world.getBlockState(pos);
        Block block = state.getBlock();

        // Check if the clicked block is of your desired type
        if (block == Blocks.OAK_LOG) {
            // Replace the block with your desired block
            world.setBlockAndUpdate(pos, ModBlocks.MOSSY_OAK_LOG.get().defaultBlockState());

            // Remove the item from the player's inventory
            if (!pContext.getPlayer().isCreative()) {
                pContext.getItemInHand().shrink(1);
            }

            // Return success result
            return InteractionResult.SUCCESS;
        }
        else if(block == Blocks.BIRCH_LOG){
            // Replace the block with your desired block
            world.setBlockAndUpdate(pos, ModBlocks.MOSSY_BIRCH_LOG.get().defaultBlockState());

            // Remove the item from the player's inventory
            if (!pContext.getPlayer().isCreative()) {
                pContext.getItemInHand().shrink(1);
            }

            // Return success result
            return InteractionResult.SUCCESS;
        }

        // If the clicked block is not of your desired type, let Minecraft handle it
        return super.useOn(pContext);
    }
}