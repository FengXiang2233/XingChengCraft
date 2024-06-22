package me.fengxiang.XingChengCraft.obj.machines;

public class MachinesRecipe {

    public int time;
    public int EnergyConsumption;

    public MachinesRecipe(int time, int EnergyConsumption){
        this.time = time;
        this.EnergyConsumption = EnergyConsumption;
        return;
    }

    public int getTime(){
        return this.time;
    }

    public int getEnergyConsumption(){
        return this.EnergyConsumption;
    }
}
