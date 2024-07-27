package me.fengxiang.XingChengCraft.obj.BasicMachine;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.EnergyNetProvider;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

abstract public class EnergyMachine extends TickMachine implements EnergyNetProvider {

    public EnergyMachine(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe){
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public void tick(Block b){
        BlockMenu inv = BlockStorage.getInventory(b);
        this.findNextRecipe(inv);
    }

    abstract void findNextRecipe(BlockMenu inv);
}
