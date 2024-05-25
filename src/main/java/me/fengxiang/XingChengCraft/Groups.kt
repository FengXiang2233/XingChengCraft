package me.fengxiang.XingChengCraft

import io.github.thebusybiscuit.slimefun4.api.items.groups.NestedItemGroup
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack
import me.fengxiang.XingChengCraft.XingChengCraft
import org.bukkit.Material
import org.bukkit.NamespacedKey

class Groups {
    var Group_Main: NestedItemGroup? = null
    var Materials: SubItemGroup? = null
    var Basic_Machine: SubItemGroup? = null

    fun setup(inst: XingChengCraft) {

        // 物品组设置
        Group_Main = NestedItemGroup(
            NamespacedKey(inst, "xingchengcraft_main"),
            CustomItemStack(Material.GUNPOWDER, "&7星辰工艺"), 3
        )
        Materials = SubItemGroup(
            NamespacedKey(inst, "xingchengcraft_materials"),
            Group_Main, CustomItemStack(Material.GUNPOWDER, "&7材料")
        )
        Basic_Machine = SubItemGroup(
            NamespacedKey(inst, "xingchengcraft_basic_machine"),
            Group_Main, CustomItemStack(Material.SMOOTH_STONE, "&7基础机器")
        )

        // 物品组注册
        Group_Main!!.register(inst)
        Materials!!.register(inst)
        Basic_Machine!!.register(inst)
    }

}