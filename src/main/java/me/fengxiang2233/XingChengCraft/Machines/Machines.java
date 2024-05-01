package me.fengxiang2233.XingChengCraft.Machines;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import me.fengxiang2233.XingChengCraft.Groups;
import me.fengxiang2233.XingChengCraft.XingChengCraft;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public class Machines {
    public static XingChengGen XingChengGen=new XingChengGen(Groups.Basic_Machine,"XINGCHENG_XINGCHENGGEN",
            new SlimefunItemStack("XINGCHENG_XINGCHENGGEN", Material.CAULDRON,"§s星尘§7收集器","耗电 1500J/t\n可存储 10000J"),
            RecipeType.ANCIENT_ALTAR,
            new ItemStack[]{
                    SlimefunItems.REINFORCED_ALLOY_INGOT,SlimefunItems.ELECTRO_MAGNET,SlimefunItems.REINFORCED_ALLOY_INGOT,
                    SlimefunItems.ELECTRO_MAGNET,SlimefunItems.ADVANCED_CIRCUIT_BOARD,SlimefunItems.ELECTRO_MAGNET,
                    SlimefunItems.REINFORCED_ALLOY_INGOT,SlimefunItems.ELECTRO_MAGNET,SlimefunItems.REINFORCED_ALLOY_INGOT
            });
    public static void setup(XingChengCraft inst){
        XingChengGen.register(inst);
    }
}
