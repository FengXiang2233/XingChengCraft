package me.fengxiang.XingChengCraft.task.reg

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItem
import io.github.thebusybiscuit.slimefun4.api.recipes.RecipeType
import io.github.thebusybiscuit.slimefun4.implementation.SlimefunItems
import me.fengxiang.XingChengCraft.XingChengCraft
import me.fengxiang.XingChengCraft.obj.Groups
import me.fengxiang.XingChengCraft.obj.Items
import me.fengxiang.XingChengCraft.obj.machines.MachinesRecipe
import me.fengxiang.XingChengCraft.obj.machines.MaterialGen
import me.fengxiang.XingChengCraft.obj.machines.SimpleEnergyMachine
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
            RecipeType.SMELTERY, arrayOf<ItemStack>(
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
            1000,
            300,
            Items().XingCheng,
            30
        ).register(inst)

        val DustEnergyMachineRecipe:HashMap<ItemStack, MachinesRecipe> = HashMap()
        DustEnergyMachineRecipe.put(Items().XingCheng, MachinesRecipe(100,10))

        SimpleEnergyMachine(
            Groups.Basic_Machine,
            Items().DustEnergyMachine,
            RecipeType.NULL,null,
            1000,
            DustEnergyMachineRecipe
        ).register(inst)
    }
}