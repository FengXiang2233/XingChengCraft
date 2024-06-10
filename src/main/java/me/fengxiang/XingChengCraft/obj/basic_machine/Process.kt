package me.fengxiang.XingChengCraft.obj.basic_machine

import io.github.thebusybiscuit.slimefun4.libraries.dough.items.CustomItemStack
import io.github.thebusybiscuit.slimefun4.utils.ChestMenuUtils
import me.mrCookieSlime.Slimefun.api.BlockStorage
import me.mrCookieSlime.Slimefun.api.inventory.BlockMenu
import org.bukkit.Material
import org.bukkit.inventory.ItemStack


interface Process {

    fun IsProcess(inv: BlockMenu, MaxProcess: Int,slot: Int): Boolean{
        val now: String? = BlockStorage.getLocationInfo(inv.getLocation(),"process")
        if(now==null){
            inv.addItem(slot,InitProcess(inv,MaxProcess),
                ChestMenuUtils.getEmptyClickHandler())
        }
        return if(CheckProcess(inv, MaxProcess)){
            inv.addItem(slot,InitProcess(inv,MaxProcess))
            true
        }else{
            inv.addItem(slot,UpdateProcess(inv, MaxProcess))
            false
        }
    }

    fun InitProcess(inv: BlockMenu, MaxProcess: Int): ItemStack {
        BlockStorage.addBlockInfo(inv.location, "process", "0")
        return CustomItemStack(
            Material.GREEN_STAINED_GLASS_PANE,
            "§a进度", "&f0/$MaxProcess sft"
        )
    }

    fun UpdateProcess(inv: BlockMenu, MaxProcess: Int): ItemStack {
        val now: Int = Integer.parseInt(BlockStorage.getLocationInfo(inv.location, "process")) + 1
        BlockStorage.addBlockInfo(inv.location, "process", "" + now)
        return CustomItemStack(
            Material.GREEN_STAINED_GLASS_PANE,
            "§a进度", "&f$now/$MaxProcess sft"
        )
    }

    fun CheckProcess(inv: BlockMenu,MaxProcess: Int): Boolean{
        val now:Int = Integer.parseInt(BlockStorage.getLocationInfo(inv.location,"process"))
        return now==MaxProcess
    }
}