package me.fengxiang.XingChengCraft.obj.machines

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType
import io.github.thebusybiscuit.slimefun4.core.attributes.RecipeDisplayItem
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils
import me.fengxiang.XingChengCraft.obj.basic_machine.EnergyMachine
import me.fengxiang.XingChengCraft.obj.basic_machine.Process
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config
import me.mrCookieSlime.Slimefun.api.BlockStorage
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset
import org.bukkit.Location
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class SimpleEnergyMachine(
    itemGroup: ItemGroup,
    item: SlimefunItemStack,
    recipeType: RecipeType,
    recipe: Array<out ItemStack>?,
    private val electricCapacity: Int,
    private val Recipe: Map<ItemStack, MachinesRecipe>
) : EnergyMachine(itemGroup, item, recipeType, recipe),Process, RecipeDisplayItem {

    private var SelfGeneratedOutput: Int = 0

    override fun findNextRecipe(inv: BlockMenu) {
        val now: String? = BlockStorage.getLocationInfo(inv.location,"process")
        if(now==null) InitProcess(inv, 0)
        if(CheckProcess(inv)){
            SelfGeneratedOutput=0
            for(item in Recipe.keys){
                if(item.isSimilar(inv.getItemInSlot(13))){
                    SelfGeneratedOutput= Recipe[item]?.EnergyConsumption ?: 0
                    inv.consumeItem(13 )
                    inv.toInventory().setItem(4, InitProcess(inv, Recipe[item]?.time ?: 0))
                    break
                }
            }
        }else{
            inv.toInventory().setItem(4, UpdateProcess(inv))
        }
    }

    override fun constructMenu(preset: BlockMenuPreset) {
        val empty = arrayOf(0,1,2,3,5,6,7,8,9,10,11,15,16,17)
        for(num in empty){
            preset.addItem(num, ChestMenuUtils.getBackground(),
                ChestMenuUtils.getEmptyClickHandler())
        }
        val on = arrayOf(12,14)
        for(num in on){
            preset.addItem(num, ChestMenuUtils.getInputSlotTexture(),
                ChestMenuUtils.getEmptyClickHandler())
        }
        preset.addItem(4, CustomItemStack(Material.RED_STAINED_GLASS_PANE, "&a进度", "&fmd 电呢?"),
            ChestMenuUtils.getEmptyClickHandler())
    }

    override fun getInputSlots(): IntArray {
        return intArrayOf(13)
    }

    override fun getOutputSlots(): IntArray {
        return IntArray(0)
    }

    override fun getGeneratedOutput(p0: Location, p1: Config): Int {
        return SelfGeneratedOutput
    }

    override fun getCapacity(): Int {
        return electricCapacity
    }

    override fun getDisplayRecipes(): MutableList<ItemStack> {
        val recipeList: MutableList<ItemStack> = mutableListOf()
        for(item in Recipe.keys){
            val loreList: MutableList<String> = mutableListOf("可持续时间 "+(Recipe[item]?.time?:0)+" 粘液刻",
                                                                "发电功率 "+(Recipe[item]?.energyConsumption?:0)+" J/t")
            val meta=item.itemMeta
            meta!!.setLore(loreList)
            item.setItemMeta(meta)
            recipeList.add(item)
        }
        return recipeList
    }
}