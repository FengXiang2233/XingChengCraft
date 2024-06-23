package me.fengxiang.XingChengCraft.obj.basic_machine

import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack
import me.mrCookieSlime.Slimefun.api.BlockStorage
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu
import org.bukkit.Material
import org.bukkit.inventory.ItemStack


interface Process {

    fun IsProcess(inv: BlockMenu, MaxProcess: Int, slot: Int): Boolean{
        val now: String? = BlockStorage.getLocationInfo(inv.location,"process")
        if(now==null) inv.toInventory().setItem(slot, InitProcess(inv,MaxProcess))
        return if(CheckProcess(inv)){
            inv.toInventory().setItem(slot, InitProcess(inv,MaxProcess))
            true
        }else{
            inv.toInventory().setItem(slot, UpdateProcess(inv))
            false
        }
    }

    fun InitProcess(inv: BlockMenu, MaxProcess: Int): ItemStack {
        BlockStorage.addBlockInfo(inv.location, "max_process", ""+MaxProcess)
        BlockStorage.addBlockInfo(inv.location, "process", ""+MaxProcess)
        return CustomItemStack(
            Material.GREEN_STAINED_GLASS_PANE,
            "§a进度", "&f还剩余 $MaxProcess/$MaxProcess tick"
        )
    }

    fun UpdateProcess(inv: BlockMenu): ItemStack {
        val now: Int = Integer.parseInt(BlockStorage.getLocationInfo(inv.location, "process")) - 1
        val maxProcess: Int = Integer.parseInt(BlockStorage.getLocationInfo(inv.location, "max_process"))
        BlockStorage.addBlockInfo(inv.location, "process", "" + now)
        return CustomItemStack(
            Material.GREEN_STAINED_GLASS_PANE,
            "§a进度", "&f还剩余 $now/$maxProcess tick"
        )
    }

    fun CheckProcess(inv: BlockMenu): Boolean{
        val now:Int = Integer.parseInt(BlockStorage.getLocationInfo(inv.location,"process"))
        return now==0
    }
}