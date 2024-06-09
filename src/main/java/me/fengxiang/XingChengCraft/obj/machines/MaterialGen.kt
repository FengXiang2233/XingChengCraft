package me.fengxiang.XingChengCraft.obj.machines

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils
import me.fengxiang.XingChengCraft.obj.basic_machine.ElectricMachine
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset
import org.bukkit.inventory.ItemStack

class MaterialGen(
    itemGroup: ItemGroup,
    item: SlimefunItemStack,
    recipeType: RecipeType,
    recipe: Array<out ItemStack>?,
    private val material: SlimefunItemStack,
): ElectricMachine(itemGroup, item, recipeType, recipe) {

    override fun findNextRecipe(inv: BlockMenu): Boolean {
        inv.pushItem(material.clone(), outputSlots[0])
        return true
    }

    override fun constructMenu(preset: BlockMenuPreset) {
        val empty = arrayOf(0,1,2,3,5,6,7,8,9,10,11,15,16,17)
        for(num in empty.indices){
            preset.addItem(num, ChestMenuUtils.getBackground(),
                            ChestMenuUtils.getEmptyClickHandler())
        }
        val out = arrayOf(12,14)
        for(num in out.indices){
            preset.addItem(num, ChestMenuUtils.getOutputSlotTexture(),
                ChestMenuUtils.getEmptyClickHandler())
        }
    }

    override fun getInputSlots(): IntArray {
        return IntArray(0)
    }

    override fun getOutputSlots(): IntArray {
        return intArrayOf(13)
    }

}