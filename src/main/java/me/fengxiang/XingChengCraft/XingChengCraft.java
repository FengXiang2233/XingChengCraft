package me.fengxiang.XingChengCraft;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import me.fengxiang.XingChengCraft.task.GroupSetup;
import me.fengxiang.XingChengCraft.task.ItemSetup;
import org.bukkit.plugin.java.JavaPlugin;

import javax.annotation.Nonnull;

public class XingChengCraft extends JavaPlugin implements SlimefunAddon {

    @Override
    public void onEnable(){
        new GroupSetup().setup(this);
        new ItemSetup().setup(this);
    }

    @Nonnull
    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }

    @Override
    public String getBugTrackerURL() {
        return "https://github.com/FengXiang2233/XingChengCraft/issues";
    }
}
