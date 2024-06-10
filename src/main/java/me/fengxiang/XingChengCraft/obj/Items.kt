package me.fengxiang.XingChengCraft.obj

import io.github.thebusybiscuit.slimefun4.api.items.SlimefunItemStack
import me.fengxiang.XingChengCraft.obj.basic_machine.ElectricLore
import org.bukkit.Material

class Items {
    val XingCheng = SlimefunItemStack("XINGCHENGCRAFT_XINGCHENG",
                            Material.GUNPOWDER, "§8星尘", "星际间飘散的渺小尘埃")

    val XingCheng_Ingot = SlimefunItemStack("XINGCHENGCRAFT_XINGCHENG_INGOT",
                            Material.BRICK, "§s星尘§7锭", "渺小尘埃聚集成的锭")

    val Basic_Core = SlimefunItemStack("XINGCHENGCRAFT_BASIC_CORE",
                            Material.FIREWORK_STAR, "§8基础§7核心", "em..小玩意不值得一提")

    val XingCheng_Core = SlimefunItemStack("XINGCHENGCRAFT_XINGCHENG_CORE",
                            Material.FIREWORK_STAR, "§s星尘§7核心", "em..就加了点东西")

    val XingChengGen = SlimefunItemStack("XINGCHENGCRAFT_XINGCHENG_GEN", Material.CAULDRON,
                                            "§s星尘§7生成器", ElectricLore().capacityLore(1000),ElectricLore().energyConsumptionLore(300))
}