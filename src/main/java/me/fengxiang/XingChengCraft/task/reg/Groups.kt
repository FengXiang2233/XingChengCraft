package me.fengxiang.XingChengCraft.task.reg

import io.github.thebusybiscuit.slimefun4.api.items.groups.NestedItemGroup
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack
import me.fengxiang.XingChengCraft.XingChengCraft
import me.fengxiang.XingChengCraft.obj.Groups
import org.bukkit.Material
import org.bukkit.NamespacedKey

class Groups {
    fun setup(inst: XingChengCraft) {

        // 物品组设置
        Groups.Group_Main = NestedItemGroup(
            NamespacedKey(inst, "xingchengcraft_main"),
            CustomItemStack(Material.GUNPOWDER, "&7星辰工艺"), 3
        )
            Groups.XC_Materials = SubItemGroup(
            NamespacedKey(inst, "xingchengcraft_materials"),
            Groups.Group_Main, CustomItemStack(Material.GUNPOWDER, "&7材料")
        )
        Groups.Basic_Machine = SubItemGroup(
            NamespacedKey(inst, "xingchengcraft_basic_machine"),
            Groups.Group_Main, CustomItemStack(Material.SMOOTH_STONE, "&7基础机器")
        )

        // 物品组注册
        Groups.Group_Main.register(inst)
        Groups.XC_Materials.register(inst)
        Groups.Basic_Machine.register(inst)
    }
}