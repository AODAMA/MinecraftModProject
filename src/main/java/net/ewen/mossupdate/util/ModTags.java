package net.ewen.mossupdate.util;

import net.ewen.mossupdate.MossUpdate;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

public class ModTags {
    public static class Blocks {
    public static final TagKey<Block> MOSSY_OAK_LOG = tag("mossy_oak_log");
        private static TagKey<Block> tag(String name){
            return BlockTags.create(new ResourceLocation(MossUpdate.MOD_ID, name));
        }
    }

    public static class Items {
        public static final TagKey<Item> MOSS_SPORES = tag("moss_spores");
        private static TagKey<Item> tag(String name){
            return ItemTags.create(new ResourceLocation(MossUpdate.MOD_ID, name));
        }
    }
}
