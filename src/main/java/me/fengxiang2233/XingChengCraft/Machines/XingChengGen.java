package me.fengxiang2233.XingChengCraft.Machines;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import me.fengxiang2233.XingChengCraft.Items;
import me.fengxiang2233.XingChengCraft.Machines.BasicMachine.BasicMachine;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import org.bukkit.inventory.ItemStack;

import javax.annotation.Nonnull;

public class XingChengGen extends BasicMachine {
    protected XingChengGen(ItemGroup itemGroup, String id, ItemStack it, RecipeType recipeType, ItemStack[] recipe) {
        super(itemGroup, id, it, recipeType, recipe);
    }

    @Override
    public int getCapacity() {
        return 10000;
    }

    @Override
    public int getEnergyConsumption() {
        return 100;
    }

    @Override
    public int getSpeed() {
        return 1;
    }

    @Override
    public int[] IN(){
        return new int[0];
    }

    @Override
    public int[] OUT(){
        return new int[] {12,14};
    }

    @Override
    public int[] EMPTY(){
        return new int[] {0,1,2,3,5,6,7,8,9,10,11,15,16,17};
    }

    @Nonnull
    @Override
    public String getMachineIdentifier() {
        return "XINGCHENG_XINGCHENGGEN";
    }

    @Override
    public int[] getInputSlots() {
        return new int[0];
    }

    @Override
    public int[] getOutputSlots() {
        return new int[] {13};
    }

    @Override
    protected boolean findNextRecipe(BlockMenu inv) {
        inv.pushItem(Items.XingCheng.getItem(), getOutputSlots());
        return true;
    }
}
