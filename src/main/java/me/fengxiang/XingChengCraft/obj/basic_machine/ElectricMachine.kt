package me.fengxiang.XingChengCraft.obj.basic_machine

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType
import io.github.thebusybiscuit.slimefun4.core.attributes.EnergyNetComponent
import io.github.thebusybiscuit.slimefun4.core.networks.energy.EnergyNetComponentType
import me.mrCookieSlime.Slimefun.api.BlockStorage
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu
import org.bukkit.Location
import org.bukkit.block.Block
import org.bukkit.inventory.ItemStack
import javax.annotation.Nonnull

abstract class ElectricMachine(
    itemGroup: ItemGroup,
    item: SlimefunItemStack,
    recipeType: RecipeType,
    recipe: Array<out ItemStack>?
) : TickMachine(itemGroup, item, recipeType, recipe), EnergyNetComponent {

    override fun tick(b: Block) {
        val inv = BlockStorage.getInventory(b)
        if (takeCharge(b.location)) {
            if (findNextRecipe(inv)) setCharge(b.location,
                this.getCharge(b.location) - getEnergyConsumption())
        }else{
            notElectric(inv)
        }
    }

    private fun takeCharge(@Nonnull l: Location): Boolean {
        return if (this.isChargeable) {
            val charge = this.getCharge(l)
            charge >= getEnergyConsumption()
        } else {
            true
        }
    }

    override fun getEnergyComponentType(): EnergyNetComponentType {
        return EnergyNetComponentType.CONSUMER
    }

    open fun notElectric(inv: BlockMenu){
    }

    abstract fun getEnergyConsumption(): Int

    abstract fun findNextRecipe(inv: BlockMenu):Boolean

}