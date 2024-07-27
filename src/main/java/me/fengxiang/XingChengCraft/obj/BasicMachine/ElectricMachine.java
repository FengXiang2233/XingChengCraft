package me.fengxiang.XingChengCraft.obj.BasicMachine;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.core.attributes.EnergyNetComponent;
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import org.bukkit.Location;
import org.bukkit.block.Block;
import org.bukkit.inventory.ItemStack;

abstract public class ElectricMachine extends TickMachine implements EnergyNetComponent {

    public ElectricMachine(ItemGroup itemGroup, SlimefunItemStack item, RecipeType recipeType, ItemStack[] recipe){
        super(itemGroup, item, recipeType, recipe);
    }

    @Override
    public void tick(Block b){
        BlockMenu inv = BlockStorage.getInventory(b);
        if(this.takeCharge(b.getLocation())){
            if(this.findNextRecipe(inv)){
                this.setCharge(b.getLocation(),this.getCharge(b.getLocation())-this.getEnergyConsumption());
            } else {
                this.notElectric(inv);
            }
        }
    }

    private boolean takeCharge(Location l){
        if(this.isChargeable()){
            int charge = this.getCharge(l);
            return charge >= this.getEnergyConsumption();
        } else {
            return true;
        }
    }

    @Override
    public EnergyNetComponentType getEnergyComponentType(){
        return EnergyNetComponentType.CONSUMER;
    }

    abstract int getEnergyConsumption();

    abstract boolean findNextRecipe(BlockMenu inv);

    public void notElectric(BlockMenu inv){
    }
}
