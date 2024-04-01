package net.ewen.mossupdate.item;

import net.ewen.mossupdate.MossUpdate;
import net.ewen.mossupdate.block.ModBlocks;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.RegistryObject;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TABS =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, MossUpdate.MOD_ID);

    public static final RegistryObject<CreativeModeTab> MOSS_UPDATE = CREATIVE_MODE_TABS.register("moss_update_tab",
            () -> CreativeModeTab.builder().icon(() -> new ItemStack(Items.MOSS_BLOCK))
                    .title(Component.translatable("creativetab.moss_update_tab"))
                    .displayItems((pParameters, pOutput) -> {

                    pOutput.accept(ModItems.MOSS_SPORES.get());
                    pOutput.accept(ModBlocks.MOSSY_OAK_LOG.get());
                    pOutput.accept(Items.MOSS_BLOCK);
                    pOutput.accept(Items.MOSS_CARPET);

                    })
                    .build());

    public static void register(IEventBus eventBus){
        CREATIVE_MODE_TABS.register(eventBus);
    }
}
