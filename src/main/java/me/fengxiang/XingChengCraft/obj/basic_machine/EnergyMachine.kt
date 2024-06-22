package me.fengxiang.XingChengCraft.obj.basic_machine

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType
import io.github.thebusybiscuit.slimefun4.core.attributes.EnergyNetProvider
import me.mrCookieSlime.Slimefun.api.BlockStorage
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu
import org.bukkit.block.Block
import org.bukkit.inventory.ItemStack

abstract class EnergyMachine(
    itemGroup: ItemGroup,
    item: SlimefunItemStack,
    recipeType: RecipeType,
    recipe: Array<out ItemStack>?
) : TickMachine(itemGroup, item, recipeType, recipe), EnergyNetProvider {

    override fun tick(b: Block) {
        val inv = BlockStorage.getInventory(b)
        findNextRecipe(inv)
    }

    abstract fun findNextRecipe(inv: BlockMenu)
}
