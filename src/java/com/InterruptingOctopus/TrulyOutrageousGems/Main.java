package com.InterruptOctopus.TrullyOutrageousGems;

import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Main.MODID, name = Main.MODNAME, version = Main.VERSION)
public class Main {
	
	public static final String MODID = "trullyOutrageousGems";
    public static final String MODNAME = "Trully Outrageus Gems";
    public static final String VERSION = "1.0.0";
        
    @Instance
    public static Main instance;
        
     
    @EventHandler
    public void preInit(FMLPreInitializationEvent e) {
                
    }
        
    @EventHandler
    public void init(FMLInitializationEvent e) {
                
    }
        
    @EventHandler
    public void postInit(FMLPostInitializationEvent e) {
                
    }
}
