package me.fengxiang.XingChengCraft.task.reg

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems
import me.fengxiang.XingChengCraft.XingChengCraft
import me.fengxiang.XingChengCraft.obj.Groups
import me.fengxiang.XingChengCraft.obj.Items
import me.fengxiang.XingChengCraft.obj.machines.MaterialGen
import org.bukkit.inventory.ItemStack

class Items{
    fun setup(inst: XingChengCraft) {

        SlimefunItem(
            Groups.XC_Materials,
            Items().XingCheng,
            RecipeType.NULL, null
        ).register(inst)

        SlimefunItem(
            Groups.XC_Materials,
            Items().XingCheng_Ingot,
            RecipeType.ANCIENT_ALTAR, arrayOf<ItemStack>(
                Items().XingCheng,Items().XingCheng, Items().XingCheng,
                Items().XingCheng, SlimefunItems.REINFORCED_ALLOY_INGOT, Items().XingCheng,
                Items().XingCheng, Items().XingCheng, Items().XingCheng
            )
        ).register(inst)

        SlimefunItem(
            Groups.XC_Materials,
            Items().Basic_Core,
            RecipeType.ANCIENT_ALTAR, arrayOf<ItemStack>(
                SlimefunItems.REINFORCED_ALLOY_INGOT, SlimefunItems.ELECTRO_MAGNET, SlimefunItems.REINFORCED_ALLOY_INGOT,
                SlimefunItems.ELECTRO_MAGNET, SlimefunItems.ADVANCED_CIRCUIT_BOARD, SlimefunItems.ELECTRO_MAGNET,
                SlimefunItems.REINFORCED_ALLOY_INGOT, SlimefunItems.ELECTRO_MAGNET, SlimefunItems.REINFORCED_ALLOY_INGOT
            )
        ).register(inst)

        SlimefunItem(
            Groups.XC_Materials,
            Items().XingCheng_Core,
            RecipeType.ANCIENT_ALTAR, arrayOf<ItemStack>(
                Items().XingCheng, Items().XingCheng_Ingot, Items().XingCheng,
                Items().XingCheng_Ingot, Items().Basic_Core, Items().XingCheng_Ingot,
                Items().XingCheng, Items().XingCheng_Ingot, Items().XingCheng
            )
        ).register(inst)

        MaterialGen(
            Groups.Basic_Machine,
            Items().XingChengGen,
            RecipeType.NULL, null,
            Items().XingCheng
        ).register(inst)
    }
}