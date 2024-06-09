package me.fengxiang.XingChengCraft.obj.basic_machine

import io.github.thebusybiscuit.slimefun4.api.items.ItemGroup
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType
import me.mrCookieSlime.CSCoreLibPlugin.Configuration.Config
import me.mrCookieSlime.Slimefun.Objects.SlimefunItem.interfaces.InventoryBlock
import me.mrCookieSlime.Slimefun.Objects.handlers.BlockTicker
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenuPreset
import org.bukkit.block.Block
import org.bukkit.inventory.ItemStack


abstract class BasicMachine(
        itemGroup: ItemGroup,
        item: SlimefunItemStack,
        recipeType: RecipeType,
        recipe: Array<out ItemStack>?
) : SlimefunItem(itemGroup, item, recipeType, recipe), InventoryBlock{

    init {
        this.createPreset(this, this.getInventoryTitle(), this::constructMenu)
    }

    private fun getInventoryTitle(): String {
        return this.itemName
    }

    // 通过重写constructMenu实现gui
    abstract fun constructMenu(preset: BlockMenuPreset)

    override fun preRegister() {
        addItemHandler(object : BlockTicker() {
            override fun tick(b: Block, sf: SlimefunItem, data: Config) {
                this@BasicMachine.tick(b)
            }

            override fun isSynchronized(): Boolean {
                return false
            }
        })
    }

    // 通过重写tick来工作
    abstract fun tick(b:Block)

}