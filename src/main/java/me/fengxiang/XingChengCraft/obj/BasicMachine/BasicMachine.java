package me.fengxiang.XingChengCraft.obj.BasicMachine;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.interfaces.InventoryBlock;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import org.bukkit.inventory.ItemStack;

abstract public class BasicMachine extends SlimefunItem implements InventoryBlock {

    public BasicMachine(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe){
        super(itemGroup, item, recipeType, recipe);
        this.createPreset(this,this.getInventoryTitle(),this::constructMenu);
    }

    private void constructMenu(BlockMenuPreset blockMenuPreset) {

    }

    private String getInventoryTitle(){
        return this.getItemName();
    }

    // 通过重写constructMenu实现自定义菜单
    abstract void constructMenu(BlockMenu preset);
}
