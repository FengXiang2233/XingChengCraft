package me.fengxiang.XingChengCraft

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems
import org.bukkit.Material
import org.bukkit.inventory.ItemStack

class Items {
    val XingCheng = SlimefunItem(
        Groups().Materials,
        SlimefunItemStack("XINGCHENGCRAFT_XINGCHENG", Material.GUNPOWDER, "§8星尘", "星际间飘散的渺小尘埃"),
        RecipeType.NULL, null
    )
    val XingCheng_Ingot = SlimefunItem(
        Groups().Materials,
        SlimefunItemStack("XINGCHENGCRAFT_XINGCHENG_INGOT", Material.BRICK, "§s星尘§7锭", "渺小尘埃聚集成的锭"),
        RecipeType.ANCIENT_ALTAR, arrayOf<ItemStack>(
            XingCheng.item, XingCheng.item, XingCheng.item,
            XingCheng.item, SlimefunItems.REINFORCED_ALLOY_INGOT, XingCheng.item,
            XingCheng.item, XingCheng.item, XingCheng.item
        )
    )
    val Basic_Core = SlimefunItem(
        Groups().Materials,
        SlimefunItemStack("XINGCHENGCRAFT_BASIC_CORE", Material.FIREWORK_STAR, "§8基础§7核心", "em..小玩意不值得一提"),
        RecipeType.ANCIENT_ALTAR, arrayOf<ItemStack>(
            SlimefunItems.REINFORCED_ALLOY_INGOT, SlimefunItems.ELECTRO_MAGNET, SlimefunItems.REINFORCED_ALLOY_INGOT,
            SlimefunItems.ELECTRO_MAGNET, SlimefunItems.ADVANCED_CIRCUIT_BOARD, SlimefunItems.ELECTRO_MAGNET,
            SlimefunItems.REINFORCED_ALLOY_INGOT, SlimefunItems.ELECTRO_MAGNET, SlimefunItems.REINFORCED_ALLOY_INGOT
        )
    )
    val XingCheng_Core = SlimefunItem(
        Groups().Materials,
        SlimefunItemStack("XINGCHENGCRAFT_XINGCHENG_CORE", Material.FIREWORK_STAR, "§s星尘§7核心", "em..就加了点东西"),
        RecipeType.ANCIENT_ALTAR, arrayOf<ItemStack>(
            XingCheng.item, XingCheng_Ingot.item, XingCheng.item,
            XingCheng_Ingot.item, Basic_Core.item, XingCheng_Ingot.item,
            XingCheng.item, XingCheng_Ingot.item, XingCheng.item
        )
    )

    fun setup(inst: XingChengCraft) {
        XingCheng.register(inst)
        XingCheng_Ingot.register(inst)
        Basic_Core.register(inst)
        XingCheng_Core.register(inst)
    }
}