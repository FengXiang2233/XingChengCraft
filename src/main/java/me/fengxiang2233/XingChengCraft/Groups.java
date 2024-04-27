package me.fengxiang2233.XingChengCraft;

import io.github.thebusybiscuit.slimefun4.api.items.groups.NestedItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;

public class Groups {
    public static NestedItemGroup Group_Main;
    public static SubItemGroup Materials;
    public static SubItemGroup Basic_Machine;

    public static void setup(XingChengCraft inst) {

        // 物品组设置
        Group_Main = new NestedItemGroup(new NamespacedKey(inst, "xingchengcraft_main"),
                new CustomItemStack(Material.GUNPOWDER, "&7星辰工艺"), 3);
        Materials = new SubItemGroup(new NamespacedKey(inst, "xingchengcraft_materials"),
                Group_Main, new CustomItemStack(Material.GUNPOWDER, "&7材料"));
        Basic_Machine = new SubItemGroup(new NamespacedKey(inst, "xingchengcraft_basic_machine"),
                Group_Main, new CustomItemStack(Material.SMOOTH_STONE,"&7基础机器"));

        // 物品组注册
        Group_Main.register(inst);
        Materials.register(inst);
        Basic_Machine.register(inst);
    }
}
