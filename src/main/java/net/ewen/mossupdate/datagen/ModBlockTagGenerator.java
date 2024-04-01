package net.ewen.mossupdate.datagen;

import net.ewen.mossupdate.MossUpdate;
import net.ewen.mossupdate.block.ModBlocks;
import net.ewen.mossupdate.util.ModTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.PackOutput;
import net.minecraft.tags.BlockTags;
import net.minecraftforge.common.data.BlockTagsProvider;
import net.minecraftforge.common.data.ExistingFileHelper;
import org.jetbrains.annotations.Nullable;
import net.minecraftforge.common.Tags;

import java.util.concurrent.CompletableFuture;

public class ModBlockTagGenerator extends BlockTagsProvider {
    public ModBlockTagGenerator(PackOutput output, CompletableFuture<HolderLookup.Provider> lookupProvider, @Nullable ExistingFileHelper existingFileHelper) {
        super(output, lookupProvider, MossUpdate.MOD_ID, existingFileHelper);
    }

    @Override
    protected void addTags(HolderLookup.Provider pProvider) {
        this.tag(BlockTags.LOGS_THAT_BURN)
                .add(ModBlocks.MOSSY_OAK_LOG.get());
    }
}
