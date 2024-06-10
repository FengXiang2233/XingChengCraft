package me.fengxiang.XingChengCraft.obj.basic_machine

class ElectricLore {

    fun capacityLore(capacity: Int): String{
        return "&f§8⇨ §e⚡ §7$capacity J 可存储"
    }

    fun energyConsumptionLore(energyConsumption: Int): String{
        return "&f§8⇨ §e⚡ §7$energyConsumption J/t"
    }
}