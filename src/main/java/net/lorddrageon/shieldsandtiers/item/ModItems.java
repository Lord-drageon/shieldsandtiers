package net.lorddrageon.shieldsandtiers.item;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.lorddrageon.shieldsandtiers.ShieldsAndTiers;
import net.lorddrageon.shieldsandtiers.item.custom.DiamondShield;
import net.lorddrageon.shieldsandtiers.item.custom.IronShield;
import net.lorddrageon.shieldsandtiers.item.custom.LeatherShield;
import net.lorddrageon.shieldsandtiers.item.custom.NetheriteShield;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

public class ModItems {
    public static Item LEATHER_SHIELD= new LeatherShield(new
            FabricItemSettings().maxDamage(1000).group(ItemGroup.COMBAT));
    public static Item LSHIELD=Registry.register(Registry.ITEM, new Identifier(ShieldsAndTiers.MOD_ID,"leather_shield"), LEATHER_SHIELD);

    public static Item IRON_SHIELD=new IronShield(new
            FabricItemSettings().maxDamage(1600).group(ItemGroup.COMBAT));
    public static Item ISHIELD=Registry.register(Registry.ITEM, new Identifier(ShieldsAndTiers.MOD_ID,"iron_shield"),
            IRON_SHIELD);

    public static Item DIAMOND_SHIELD=new DiamondShield(new FabricItemSettings().maxDamage(2000).group(ItemGroup.COMBAT));
    public static Item DSHIELD=Registry.register(Registry.ITEM, new Identifier(ShieldsAndTiers.MOD_ID, "diamond_shield"),
            DIAMOND_SHIELD);

    public static Item NETHERITE_SHIELD=new NetheriteShield(new FabricItemSettings().maxDamage(2500).group(ItemGroup.COMBAT));
    public static Item NSHIELD=Registry.register(Registry.ITEM, new Identifier(ShieldsAndTiers.MOD_ID, "netherite_shield"),
            NETHERITE_SHIELD);
    public static void registerModItems(){
        //ShieldsAndTiers.LOGGER.info("registering mod items for "+ShieldsAndTiers.MOD_ID);
    }
}
