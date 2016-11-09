package interruptingoctopus.trulyoutrageousgems;

public class Reference {

	public static final String MOD_ID = "togems";
	public static final String NAME = "Truly Outrageous Gems";
	public static final String VERSION = "indev 0.0.1";
	public static final String ACCEPTED_VERSIONS = "[1.10.2]";
	
	public static final String CLIENT_PROXY_CLASS = "interruptingoctopus.trulyoutrageousgems.proxy.ClientProxy";
	public static final String SERVER_PROXY_CLASS = "interruptingoctopus.trulyoutrageousgems.proxy.ServerProxy";
	
	public static enum TogemsItems{
		GARNET("garnet", "ItemGarnet");
		
		private String unlocalizedName;
		private String registryName;
		
		TogemsItems(String unlocalizedName, String registryName){
			this.unlocalizedName = unlocalizedName;
			this.registryName = registryName;
		}
		
		public String getRegistryName() 
		{
			return registryName;
		}
		
		public String getUnlocalizedName() 
		{
			return unlocalizedName;
		}
	}
	public static enum TogemsBlocks{
		GARNETBLOCK("garnetBlock", "BlockGarnetBLock");
		
		private String unlocalizedName;
		private String registryName;
		
		TogemsBlocks(String unlocalizedName, String registryName){
			this.unlocalizedName = unlocalizedName;
			this.registryName = registryName;
		}
		
		public String getRegistryName() 
		{
			return registryName;
		}
		
		public String getUnlocalizedName() 
		{
			return unlocalizedName;
		}
	}
		
}
