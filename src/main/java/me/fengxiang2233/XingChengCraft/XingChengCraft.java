package me.fengxiang2233.XingChengCraft;

import io.github.thebusybiscuit.slimefun4.api.SlimefunAddon;
import me.fengxiang2233.XingChengCraft.Machines.Machines;
import org.bukkit.plugin.java.JavaPlugin;

import javax.annotation.Nonnull;

public class XingChengCraft extends JavaPlugin implements SlimefunAddon {

    @Override
    public void onEnable() {
        Groups.setup(this);
        Items.setup(this);
        Machines.setup(this);
    }

    @Override
    public String getBugTrackerURL() {
        // 你可以在这里返回你的问题追踪器的网址，而不是 null
        return "https://github.com/FengXiang2233/XingChengCraft/issues";
    }

    @Nonnull
    @Override
    public JavaPlugin getJavaPlugin() {
        return this;
    }

}