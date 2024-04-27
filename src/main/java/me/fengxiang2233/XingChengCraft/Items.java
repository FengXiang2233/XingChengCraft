package me.fengxiang2233.XingChengCraft;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Items {
    public static SlimefunItem XingCheng = new SlimefunItem(Groups.Materials,
            new SlimefunItemStack("XINGCHENGCRAFT_XINGCHENG", Material.GUNPOWDER,"§8星尘","星际间飘散的渺小尘埃"),
            RecipeType.NULL,null);
    public static SlimefunItem XingCheng_Ingot =new SlimefunItem(Groups.Materials,
            new SlimefunItemStack("XINGCHENGCRAFT_XINGCHENG_INGOT",Material.BRICK,"§s星尘§7锭","渺小尘埃聚集成的锭"),
            RecipeType.ANCIENT_ALTAR,
            new  ItemStack[]{
                    XingCheng.getItem(), XingCheng.getItem(), XingCheng.getItem(),
                    XingCheng.getItem(),SlimefunItems.REINFORCED_ALLOY_INGOT, XingCheng.getItem(),
                    XingCheng.getItem(), XingCheng.getItem(), XingCheng.getItem()
            });
    public static SlimefunItem Basic_Core = new SlimefunItem(Groups.Materials,
            new SlimefunItemStack("XINGCHENGCRAFT_BASIC_CORE",Material.FIREWORK_STAR,"§8基础§7核心","em..小玩意不值得一提"),
            RecipeType.ANCIENT_ALTAR,
            new ItemStack[]{
                    SlimefunItems.REINFORCED_ALLOY_INGOT,SlimefunItems.ELECTRO_MAGNET,SlimefunItems.REINFORCED_ALLOY_INGOT,
                    SlimefunItems.ELECTRO_MAGNET,SlimefunItems.ADVANCED_CIRCUIT_BOARD,SlimefunItems.ELECTRO_MAGNET,
                    SlimefunItems.REINFORCED_ALLOY_INGOT,SlimefunItems.ELECTRO_MAGNET,SlimefunItems.REINFORCED_ALLOY_INGOT
            });
    public static SlimefunItem XingCheng_Core = new SlimefunItem(Groups.Materials,
            new SlimefunItemStack("XINGCHENGCRAFT_XINGCHENG_CORE",Material.FIREWORK_STAR,"§s星尘§7核心","em..就加了点东西"),
            RecipeType.ANCIENT_ALTAR,
            new ItemStack[]{
                    XingCheng.getItem(), XingCheng_Ingot.getItem(), XingCheng.getItem(),
                    XingCheng_Ingot.getItem(), Basic_Core.getItem(), XingCheng_Ingot.getItem(),
                    XingCheng.getItem(), XingCheng_Ingot.getItem(), XingCheng.getItem()
            });

    public static void setup(XingChengCraft inst){
        XingCheng.register(inst);
        XingCheng_Ingot.register(inst);
        Basic_Core.register(inst);
        XingCheng_Core.register(inst);
    }
}
