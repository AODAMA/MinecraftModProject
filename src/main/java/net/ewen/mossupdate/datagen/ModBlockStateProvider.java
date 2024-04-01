package net.ewen.mossupdate.datagen;

import net.ewen.mossupdate.MossUpdate;
import net.ewen.mossupdate.block.ModBlocks;
import net.minecraft.data.PackOutput;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.RotatedPillarBlock;
import net.minecraftforge.client.model.generators.BlockStateProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import net.minecraftforge.registries.RegistryObject;

public class ModBlockStateProvider extends BlockStateProvider {
    public ModBlockStateProvider(PackOutput output, ExistingFileHelper exFileHelper) {
        super(output, MossUpdate.MOD_ID, exFileHelper);
    }

    @Override
    protected void registerStatesAndModels() {
    logBlock(((RotatedPillarBlock) ModBlocks.MOSSY_OAK_LOG.get()));
    }

    private void blockWithItem(RegistryObject<Block> blockRegistryObject){
        simpleBlockWithItem(blockRegistryObject.get(), cubeAll(blockRegistryObject.get()));
    }
}
