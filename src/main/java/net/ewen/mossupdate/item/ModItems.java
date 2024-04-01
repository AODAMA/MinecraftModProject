package net.ewen.mossupdate.item;

//in order: Mod's contents, Minecraft's contents, Event Bus (serves as communication between classes and other components),
import net.ewen.mossupdate.MossUpdate;
import net.ewen.mossupdate.item.custom.MossSporeItem;
import net.minecraft.world.item.Item;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

//class that contains all the items of the mod !
//some complex items may require their own class (memo)
public class ModItems {

    //this method is static and final, all its content cannot be changed dynamically
    public static final DeferredRegister<Item> ITEMS =
            //DeferredRegister allows to register objects. here the arguments are to register into the Forge Items and to the Mod)
            DeferredRegister.create(ForgeRegistries.ITEMS, MossUpdate.MOD_ID);

    //This is where the items are created
    public static final RegistryObject<Item> MOSS_SPORES = ITEMS.register("moss_spores",() -> new MossSporeItem(new Item.Properties().stacksTo(64)));

    //this here sends the items to get registered, thanks to the EventBus pattern
    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}
