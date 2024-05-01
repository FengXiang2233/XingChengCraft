package me.fengxiang2233.XingChengCraft.Machines;

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup;
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils;
import me.fengxiang2233.XingChengCraft.Items;
import me.fengxiang2233.XingChengCraft.Machines.BasicMachine.BasicMachine;
import me.mrCookieSlime.Slimefun.api.BlockStorage;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu;
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset;
import org.bukkit.Material;
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
        return 1500;
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
    public void AddconstructMenu(BlockMenuPreset preset){
        preset.addItem(4, new CustomItemStack(Material.RED_STAINED_GLASS_PANE, "&a进度", "&fmd 电呢?"), ChestMenuUtils.getEmptyClickHandler());
    }

    @Override
    protected boolean findNextRecipe(BlockMenu inv) {
        String now=BlockStorage.getLocationInfo(inv.getLocation(),"process");
        if(now==null || now.equals("0")){
            init_Process(inv,420);
        }
        if(Process(inv,420)){
            inv.pushItem(Items.XingCheng.getItem().clone(), getOutputSlots());}
        return true;
    }

    public void init_Process(BlockMenu inv,int max_process){
        BlockStorage.addBlockInfo(inv.getLocation(),"process","0");
        ItemStack it = new CustomItemStack(Material.GREEN_STAINED_GLASS_PANE, "§a进度", "&f0/"+max_process+" sft");
        inv.toInventory().setItem(4, it);
    }

    public void update_Process(BlockMenu inv,int max_process){
        String now=BlockStorage.getLocationInfo(inv.getLocation(),"process");
        ItemStack it = new CustomItemStack(Material.GREEN_STAINED_GLASS_PANE, "§a进度", "&f"+now+"/"+max_process+" sft");
        inv.toInventory().setItem(4, it);
    }

    public boolean Process(BlockMenu inv,int max_process){
        int now = Integer.parseInt(BlockStorage.getLocationInfo(inv.getLocation(),"process"))+1;
        BlockStorage.addBlockInfo(inv.getLocation(),"process",""+now);
        update_Process(inv,max_process);
        if(max_process==now){
            BlockStorage.addBlockInfo(inv.getLocation(),"process","0");
            return true;
        }
        return false;
    }
}
