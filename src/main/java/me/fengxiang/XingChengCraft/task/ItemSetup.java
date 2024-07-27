package me.fengxiang.XingChengCraft.task;

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems;
import me.fengxiang.XingChengCraft.XingChengCraft;
import me.fengxiang.XingChengCraft.obj.Groups;
import me.fengxiang.XingChengCraft.obj.Items;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

public final class ItemSetup {

    public void setup(XingChengCraft inst){
        new SlimefunItem(
                Groups.BASIC_MATERIALS,
                Items.STEEL_MACHINE_FRAME,
                RecipeType.ENHANCED_CRAFTING_TABLE,
                new ItemStack[]{
                        SlimefunItems.DAMASCUS_STEEL_INGOT,SlimefunItems.DAMASCUS_STEEL_INGOT,SlimefunItems.DAMASCUS_STEEL_INGOT,
                        SlimefunItems.STEEL_PLATE,new ItemStack(Material.SCAFFOLDING),SlimefunItems.STEEL_PLATE,
                        SlimefunItems.DAMASCUS_STEEL_INGOT,SlimefunItems.DAMASCUS_STEEL_INGOT,SlimefunItems.DAMASCUS_STEEL_INGOT
                }
        ).register(inst);
    }
}
