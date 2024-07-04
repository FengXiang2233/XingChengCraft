package me.fengxiang.XingChengCraft.obj

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack
import me.fengxiang.XingChengCraft.obj.basic_machine.ElectricLore
import org.bukkit.Material

class Items {
    val XingCheng = SlimefunItemStack("XINGCHENGCRAFT_XINGCHENG",
                            Material.GUNPOWDER, "§8星尘", "星际间飘散的渺小尘埃")

    val XingCheng_Ingot = SlimefunItemStack("XINGCHENGCRAFT_XINGCHENG_INGOT",
                            Material.BRICK, "§s星尘§7锭", "渺小尘埃聚集成的锭")

    val XingCheng_Plate = SlimefunItemStack("XINGCHENGCRAFT_XINGCHENG_PLATE",
                            Material.PAPER, "§s星尘§7板", "由渺小尘埃聚集成的锭所压成的板")

    val Basic_Core = SlimefunItemStack("XINGCHENGCRAFT_BASIC_CORE",
                            Material.FIREWORK_STAR, "§8基础§7核心", "em..小玩意不值得一提")

    val XingCheng_Core = SlimefunItemStack("XINGCHENGCRAFT_XINGCHENG_CORE",
                            Material.FIREWORK_STAR, "§s星尘§7核心", "em..就加了点东西")

    val XingChengGen = SlimefunItemStack("XINGCHENGCRAFT_XINGCHENG_GEN", Material.CAULDRON,
                                            "§s基本§7星尘生成器", ElectricLore().capacityLore(1000),ElectricLore().energyConsumptionLore(300))

    val Basic_Cobblestone = SlimefunItemStack("XINGCHENGCRAFT_COBBLESTONE_GEN", Material.SMOOTH_STONE,
        "§s基本§7圆石生成器", ElectricLore().capacityLore(1000),ElectricLore().energyConsumptionLore(36))


    val DustEnergyMachine = SlimefunItemStack("XINGCHENGCRAFT_DUST_ENERGY_MACHINE", Material.SMOOTH_SANDSTONE,
                                                "§s星尘§7粉尘爆发器", ElectricLore().capacityLore(1000))

}