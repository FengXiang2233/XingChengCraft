package me.fengxiang.XingChengCraft;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import me.fengxiang.XingChengCraft.task.reg.Groups;
import me.fengxiang.XingChengCraft.task.reg.Items;
import net.byteflux.libby.BukkitLibraryManager;
import net.byteflux.libby.LibraryManager;
import org.bukkit.plugin.java.JavaPlugin;


public class XingChengCraft extends JavaPlugin implements SlimefunAddon{

    @Override
    public void onEnable(){
        // 粘液相关加载
        new Groups().setup(this);
        new Items().setup(this);
    }

    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }

    @Override
    public String getBugTrackerURL() {
        return "https://github.com/FengXiang2233/XingChengCraft/issues";
    }
}