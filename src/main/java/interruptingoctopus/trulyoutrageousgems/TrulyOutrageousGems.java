package interruptingoctopus.trulyoutrageousgems;

import interruptingoctopus.trulyoutrageousgems.init.ModBlocks;
import interruptingoctopus.trulyoutrageousgems.init.ModCrafting;
import interruptingoctopus.trulyoutrageousgems.init.ModItems;
import interruptingoctopus.trulyoutrageousgems.proxy.CommonProxy;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.Mod.Instance;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = Reference.MOD_ID, name = Reference.NAME, version = Reference.VERSION, acceptedMinecraftVersions = Reference.ACCEPTED_VERSIONS)
public class TrulyOutrageousGems {

	@Mod.Instance(Reference.MOD_ID)
	public static TrulyOutrageousGems instance;
	
	@SidedProxy(clientSide = Reference.CLIENT_PROXY_CLASS, serverSide = Reference.SERVER_PROXY_CLASS)
	public static CommonProxy proxy;
	
	@EventHandler
	public void preinit(FMLPreInitializationEvent event)
	{
		System.out.println("Pre Init");
		
		ModItems.init();
		ModItems.register();
		
		ModBlocks.init();
		ModBlocks.register();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event)
	{
		System.out.println("Init");
		proxy.init();
		
		ModCrafting.register();
	}
	
	@EventHandler
	public void postinit(FMLPostInitializationEvent event)
	{
		System.out.println("Post Init");
	}
}
