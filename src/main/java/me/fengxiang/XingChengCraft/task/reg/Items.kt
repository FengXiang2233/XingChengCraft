package me.fengxiang.XingChengCraft.task.reg

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem
import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems
import me.fengxiang.XingChengCraft.XingChengCraft
import me.fengxiang.XingChengCraft.obj.Groups
import me.fengxiang.XingChengCraft.obj.Items
import me.fengxiang.XingChengCraft.obj.machines.MachinesRecipe
import me.fengxiang.XingChengCraft.obj.machines.MaterialGen
import me.fengxiang.XingChengCraft.obj.machines.SimpleEnergyMachine
import org.bukkit.Material
import org.bukkit.entity.Item
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
            RecipeType.SMELTERY, arrayOf(
                SlimefunItemStack(Items().XingCheng, 8),
                SlimefunItems.REINFORCED_ALLOY_INGOT
            )
        ).register(inst)

        SlimefunItem(
            Groups.XC_Materials,
            Items().XingCheng_Plate,
            RecipeType.COMPRESSOR, arrayOf(
                SlimefunItemStack(Items().XingCheng_Ingot, 8)
            )
        ).register(inst)

        SlimefunItem(
            Groups.XC_Materials,
            Items().Basic_Core,
            RecipeType.ANCIENT_ALTAR, arrayOf(
                SlimefunItems.REINFORCED_ALLOY_INGOT, SlimefunItems.ELECTRO_MAGNET, SlimefunItems.REINFORCED_ALLOY_INGOT,
                SlimefunItems.ELECTRO_MAGNET, SlimefunItems.ADVANCED_CIRCUIT_BOARD, SlimefunItems.ELECTRO_MAGNET,
                SlimefunItems.REINFORCED_ALLOY_INGOT, SlimefunItems.ELECTRO_MAGNET, SlimefunItems.REINFORCED_ALLOY_INGOT
            )
        ).register(inst)

        SlimefunItem(
            Groups.XC_Materials,
            Items().XingCheng_Core,
            RecipeType.ANCIENT_ALTAR, arrayOf(
                Items().XingCheng, Items().XingCheng_Ingot, Items().XingCheng,
                Items().XingCheng_Ingot, Items().Basic_Core, Items().XingCheng_Ingot,
                Items().XingCheng, Items().XingCheng_Ingot, Items().XingCheng
            )
        ).register(inst)

        MaterialGen(
            Groups.Basic_Machine,
            Items().XingChengGen,
            RecipeType.ENHANCED_CRAFTING_TABLE, arrayOf(
                SlimefunItems.STEEL_PLATE,SlimefunItems.SYNTHETIC_DIAMOND,SlimefunItems.STEEL_PLATE,
                SlimefunItems.STEEL_INGOT,Items().Basic_Core,SlimefunItems.STEEL_INGOT,
                SlimefunItems.REINFORCED_ALLOY_INGOT,SlimefunItems.REINFORCED_ALLOY_INGOT,SlimefunItems.REINFORCED_ALLOY_INGOT
            ),
            1000,
            300,
            Items().XingCheng,
            180
        ).register(inst)

        MaterialGen(
            Groups.Basic_Machine,
            Items().Basic_Cobblestone,
            RecipeType.ENHANCED_CRAFTING_TABLE, arrayOf(
                SlimefunItems.STEEL_PLATE,ItemStack(Material.COBBLESTONE),SlimefunItems.STEEL_PLATE,
                SlimefunItems.STEEL_INGOT,Items().Basic_Core,SlimefunItems.STEEL_INGOT,
                ItemStack(Material.COBBLESTONE),Items().XingCheng,ItemStack(Material.COBBLESTONE)
            ),
            1000,
            36,
            ItemStack(Material.COBBLESTONE),
            5,
            32
        ).register(inst)

        val dustEnergyMachineRecipe:HashMap<ItemStack, MachinesRecipe> = HashMap()
        dustEnergyMachineRecipe[ItemStack(Material.REDSTONE)] = MachinesRecipe(300,120)
        dustEnergyMachineRecipe[ItemStack(Material.GUNPOWDER)] = MachinesRecipe(300,120)
        dustEnergyMachineRecipe[ItemStack(Material.BONE_MEAL)] = MachinesRecipe(70,13)

        SimpleEnergyMachine(
            Groups.Basic_Machine,
            Items().DustEnergyMachine,
            RecipeType.ENHANCED_CRAFTING_TABLE,arrayOf(
                SlimefunItems.STEEL_PLATE,Items().XingCheng,SlimefunItems.STEEL_PLATE,
                SlimefunItems.STEEL_INGOT,Items().Basic_Core,SlimefunItems.STEEL_INGOT,
                Items().XingCheng_Ingot,Items().XingCheng_Ingot,Items().XingCheng_Ingot
                ),
            1000,
            dustEnergyMachineRecipe
        ).register(inst)
    }
}