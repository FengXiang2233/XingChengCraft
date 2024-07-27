package me.fengxiang.XingChengCraft.task;

import io.github.thebusybiscuit.slimefun4.api.items.groups.NestedItemGroup;
import io.github.thebusybiscuit.slimefun4.api.items.groups.SubItemGroup;
import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack;
import me.fengxiang.XingChengCraft.XingChengCraft;
import me.fengxiang.XingChengCraft.obj.Groups;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;

public final class GroupSetup {

    public void setup(XingChengCraft inst){

        Groups.GROUP_MAIN = new NestedItemGroup(
                new NamespacedKey(inst,"xingchengcraft_main"),
                new CustomItemStack(Material.GUNPOWDER,"&7星辰工艺"),
                3
        );
        Groups.GROUP_MAIN.register(inst);

        Groups.BASIC_MATERIALS = new SubItemGroup(
                new NamespacedKey(inst,"xingchengcraft_materials"),
                Groups.GROUP_MAIN,
                new CustomItemStack(Material.FLINT,"&7材料")
        );
        Groups.BASIC_MATERIALS.register(inst);
    }
}
