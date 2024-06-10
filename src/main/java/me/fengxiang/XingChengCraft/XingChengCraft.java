package me.fengxiang.XingChengCraft;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import me.fengxiang.XingChengCraft.plugin.util.LibrariesLoader;
import me.fengxiang.XingChengCraft.task.reg.Groups;
import me.fengxiang.XingChengCraft.task.reg.Items;
import net.byteflux.libby.BukkitLibraryManager;
import net.byteflux.libby.LibraryManager;
import org.bukkit.plugin.java.JavaPlugin;


public class XingChengCraft extends JavaPlugin implements SlimefunAddon{

    @Override
    public void onEnable(){
        // 初始化load
        LibraryManager libraryManager;
        libraryManager = new BukkitLibraryManager(this);
        LibrariesLoader.setManager(libraryManager);
        // 加载依赖项
        LibrariesLoader.load("org.xerial", "sqlite-jdbc", "3.41.2.2");
        LibrariesLoader.load("org.jetbrains.kotlin", "kotlin-stdlib", "2.0.0-Beta1");
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