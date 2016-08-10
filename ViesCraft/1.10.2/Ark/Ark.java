import net.minecraft.util.text.TextFormatting;

import com.viesis.viescraft.ViesCraft;
import com.viesis.viescraft.network.GuiHandler;


public class Ark {

	
//KeyBinds.java

	/**
	 * 
	 * 
	// Define the "ping" binding, with (unlocalized) name "key.ping" and
	       // the category with (unlocalized) name "key.categories.mymod" and
	       // key code 24 ("O", LWJGL constant: Keyboard.KEY_O)
	       
		//ping = new KeyBinding("key.vc.inventory", Keyboard.KEY_O, "key.categories.viescraft");
	       
		// Define the "pong" binding, with (unlocalized) name "key.pong" and
	       // the category with (unlocalized) name "key.categories.mymod" and
	       // key code 25 ("P", LWJGL constant: Keyboard.KEY_P)
	    
	// Register both KeyBindings to the ClientRegistry
	       //ClientRegistry.registerKeyBinding(ping);
	       //ClientRegistry.registerKeyBinding(pong);
		
		
		
	public static void init1()
	{
		// declare an array of key bindings
		keyBindings = new KeyBinding[2]; 
		
		// instantiate the key bindings
		keyBindings[0] = new KeyBinding("key.structure.desc", Keyboard.KEY_P, "key.magicbeans.category");
		keyBindings[1] = new KeyBinding("key.hud.desc", Keyboard.KEY_H, "key.magicbeans.category");
		
		// register all the key bindings
		for (int i = 0; i < keyBindings.length; ++i) 
		{
			ClientRegistry.registerKeyBinding(keyBindings[i]);
		}
	
	}
	
	@SideOnly(Side.CLIENT)
	@SubscribeEvent(priority=EventPriority.NORMAL, receiveCanceled=true)
	public void onEvent(KeyInputEvent event)
	{
	    // DEBUG
	    System.out.println("Key Input Event");

	    // make local copy of key binding array
	    KeyBinding[] keyBindings = Keybinds.keyBindings;
	   
	    // check each enumerated key binding type for pressed and take appropriate action
	    if (keyBindings[0].isPressed()) 
	    {
	        // DEBUG
	    //System.out.println("Key binding ="+keyBindings[0].getKeyDescription());
	            
	        // do stuff for this key binding here
	        // remember you may need to send packet to server
	    }
	    if (keyBindings[1].isPressed()) 
	    {
	        // DEBUG
	    //System.out.println("Key binding ="+keyBindings[1].getKeyDescription());
	            
	        // do stuff for this key binding here
	        // remember you may need to send packet to server
	    }
	}

	*/
	
//MessageGuiOpenBlack.java
	/**
	 * 
	 * 
	//if(player.openContainer instanceof ContainerAirshipBlack) {
	//Unused
	//	LogHelper.info("Gui is NOT airship!");
	//	player.closeScreen();
		
		
	//}else {
		player.openGui(ViesCraft.instance, GuiHandler.GUI_AIRSHIP_BLACK, player.worldObj, player.getPosition().getX(), player.getPosition().getY(), player.getPosition().getZ());
		
	//	LogHelper.info("Gui IS airship!");
		
	//}
	//LogHelper.info("Gui opened successfully!");
	//LogHelper.info(" ");
	
	*/
	
	
//InitEntityVC.java
	/**
	 * 
	 * 
	//register(EntityItemViesdenburg.class, "EnchantedEbonheart", 64, 20, true);
	//register(EntityAirshipVC.class, "AirshipEbonheart", 64, 1, true);
	
	//register(EntityItemAirship.class, "item.airship", 64, 20, true);
	//register(EntityAirshipVCtest.class, "AirshipEbonheartNEW", 64, 1, true);
	
	//register(EntityItemAirshipFurnace.class, "vc.ItemAirshipFurnace", 64, 20, true);
	
	
	////register(EntityAirshipNormal.class, "airship." + EntityAirshipNormal.Type.BLACK.getName(), 64, 1, true);
	////register(EntityAirshipNormal.class, "airship." + EntityAirshipNormal.Type.RED.getName(), 64, 1, true);
	
	
	
	//register(EntityAirshipBase.class, "AirshipEbonheart", 64, 1, true);
	//register(EntityAirshipBase2.class, "AirshipV2", 64, 1, true);
	
	//register(EntityAirshipFurnace.class, "AirshipVCFurnace", 64, 1, true);
	
	
	*/
	
//InitBlocksVC.java
	/**
	 * 
	 *
draconium_ore = registerBlock(new BlockOreDraconium(2, 0.4f, 10f));
		velious_ore = registerBlock(new BlockOreVelious(2, 15f));
		arcanite_ore = registerBlock(new BlockOreArcanite(2, 20f));
		katcheen_ore = registerBlock(new BlockOreKatcheen(3, 30f));
		necrocite_ore = registerBlock(new BlockOreNecrocite(3, 30f));
		soularite_ore = registerBlock(new BlockOreSoularite(3, 30f));
		ebonheart_ore = registerBlock(new BlockOreEbonheart(3, 30f));
		ebon_ore = registerBlock(new BlockMultiOre("ore/ebon_ore"));
		ebon_ore_nether = registerBlock(new BlockMultiOre("ore/ebon_ore_nether"));
		
		draconium_block = registerBlock(new BlockEA("gem/draconium/draconium_block").setResistance(4.0F));
		velious_block = registerBlock(new BlockEA("gem/velious/velious_block").setResistance(15.0F));
		arcanite_block = registerBlock(new BlockEA("gem/arcanite/arcanite_block").setResistance(30.0F));
		katcheen_block = registerBlock(new BlockEA("gem/katcheen/katcheen_block").setResistance(100.0F));
		necrocite_block = registerBlock(new BlockEA("gem/necrocite/necrocite_block").setResistance(45.0F));
		soularite_block = registerBlock(new BlockEA("gem/soularite/soularite_block").setResistance(45.0F));
		ebonheart_block = registerBlock(new BlockEA("gem/ebonheart/ebonheart_block").setResistance(2000.0F));
		obsidian_block = registerBlock(new BlockEA("gem/obsidian/obsidian_block").setResistance(2000.0F));
		glowstone_block = registerBlock(new BlockEA("gem/glowstone/glowstone_block").setResistance(45.0F).setLightLevel(1.0f));
		
		draconium_block_brick = registerBlock(new BlockEA("gem/draconium/draconium_block_brick").setResistance(4.0F));
		velious_block_brick = registerBlock(new BlockEA("gem/velious/velious_block_brick").setResistance(15.0F));
		arcanite_block_brick = registerBlock(new BlockEA("gem/arcanite/arcanite_block_brick").setResistance(30.0F));
		katcheen_block_brick = registerBlock(new BlockEA("gem/katcheen/katcheen_block_brick").setResistance(100.0F));
		necrocite_block_brick = registerBlock(new BlockEA("gem/necrocite/necrocite_block_brick").setResistance(45.0F));
		soularite_block_brick = registerBlock(new BlockEA("gem/soularite/soularite_block_brick").setResistance(45.0F));
		ebonheart_block_brick = registerBlock(new BlockEA("gem/ebonheart/ebonheart_block_brick").setResistance(2000.0F));
		obsidian_block_brick = registerBlock(new BlockEA("gem/obsidian/obsidian_block_brick").setResistance(2000.0F));
		glowstone_block_brick = registerBlock(new BlockEA("gem/glowstone/glowstone_block_brick").setResistance(45.0F).setLightLevel(1.0f));
		
		double_draconium_slab = new BlockDoubleSlab("slab/draconium/double_draconium_slab").setResistance(4.0F);
		double_velious_slab = new BlockDoubleSlab("slab/velious/double_velious_slab").setResistance(15.0F);
		double_arcanite_slab = new BlockDoubleSlab("slab/arcanite/double_arcanite_slab").setResistance(30.0F);
		double_katcheen_slab = new BlockDoubleSlab("slab/katcheen/double_katcheen_slab").setResistance(100.0F);
		double_necrocite_slab = new BlockDoubleSlab("slab/necrocite/double_necrocite_slab").setResistance(45.0F);
		double_soularite_slab = new BlockDoubleSlab("slab/soularite/double_soularite_slab").setResistance(45.0F);
		double_ebonheart_slab = new BlockDoubleSlab("slab/ebonheart/double_ebonheart_slab").setResistance(2000.0F);
		double_obsidian_slab = new BlockDoubleSlab("slab/obsidian/double_obsidian_slab").setResistance(2000.0F);
		double_glowstone_slab = new BlockDoubleSlab("slab/glowstone/double_glowstone_slab").setResistance(45.0F).setLightLevel(1.0f);
		
		draconium_slab = new BlockHalfSlab("slab/draconium/draconium_slab").setResistance(4.0F).setCreativeTab(EbonArtsMod.tabEbonArtsBlocks);
		velious_slab = new BlockHalfSlab("slab/velious/velious_slab").setResistance(15.0F).setCreativeTab(EbonArtsMod.tabEbonArtsBlocks);
		arcanite_slab = new BlockHalfSlab("slab/arcanite/arcanite_slab").setResistance(30.0F).setCreativeTab(EbonArtsMod.tabEbonArtsBlocks);
		katcheen_slab = new BlockHalfSlab("slab/katcheen/katcheen_slab").setResistance(100.0F).setCreativeTab(EbonArtsMod.tabEbonArtsBlocks);
		necrocite_slab = new BlockHalfSlab("slab/necrocite/necrocite_slab").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsBlocks);
		soularite_slab = new BlockHalfSlab("slab/soularite/soularite_slab").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsBlocks);
		ebonheart_slab = new BlockHalfSlab("slab/ebonheart/ebonheart_slab").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsBlocks);
		obsidian_slab = new BlockHalfSlab("slab/obsidian/obsidian_slab").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsBlocks);
		glowstone_slab = new BlockHalfSlab("slab/glowstone/glowstone_slab").setResistance(45.0F).setLightLevel(1.0f).setCreativeTab(EbonArtsMod.tabEbonArtsBlocks);
		
		
		
		GameRegistry.registerBlock(double_draconium_slab, ItemBlockSlab.class, "slab/draconium/double_draconium_slab", draconium_slab, double_draconium_slab, true);
		GameRegistry.registerBlock(double_velious_slab, ItemBlockSlab.class, "slab/velious/double_velious_slab", velious_slab, double_velious_slab, true);
		GameRegistry.registerBlock(double_arcanite_slab, ItemBlockSlab.class, "slab/arcanite/double_arcanite_slab", arcanite_slab, double_arcanite_slab, true);
		GameRegistry.registerBlock(double_katcheen_slab, ItemBlockSlab.class, "slab/katcheen/double_katcheen_slab", katcheen_slab, double_katcheen_slab, true);
		GameRegistry.registerBlock(double_necrocite_slab, ItemBlockSlab.class, "slab/necrocite/double_necrocite_slab", necrocite_slab, double_necrocite_slab, true);
		GameRegistry.registerBlock(double_soularite_slab, ItemBlockSlab.class, "slab/soularite/double_soularite_slab", soularite_slab, double_soularite_slab, true);
		GameRegistry.registerBlock(double_ebonheart_slab, ItemBlockSlab.class, "slab/ebonheart/double_ebonheart_slab", ebonheart_slab, double_ebonheart_slab, true);
		GameRegistry.registerBlock(double_obsidian_slab, ItemBlockSlab.class, "slab/obsidian/double_obsidian_slab", obsidian_slab, double_obsidian_slab, true);
		GameRegistry.registerBlock(double_glowstone_slab, ItemBlockSlab.class, "slab/glowstone/double_glowstone_slab", glowstone_slab, double_glowstone_slab, true);
		
		GameRegistry.registerBlock(draconium_slab, ItemBlockSlab.class, "slab/draconium/draconium_slab", draconium_slab, double_draconium_slab, false);
		GameRegistry.registerBlock(velious_slab, ItemBlockSlab.class, "slab/velious/velious_slab", velious_slab, double_velious_slab, false);
		GameRegistry.registerBlock(arcanite_slab, ItemBlockSlab.class, "slab/arcanite/arcanite_slab", arcanite_slab, double_arcanite_slab, false);
		GameRegistry.registerBlock(katcheen_slab, ItemBlockSlab.class, "slab/katcheen/katcheen_slab", katcheen_slab, double_katcheen_slab, false);
		GameRegistry.registerBlock(necrocite_slab, ItemBlockSlab.class, "slab/necrocite/necrocite_slab", necrocite_slab, double_necrocite_slab, false);
		GameRegistry.registerBlock(soularite_slab, ItemBlockSlab.class, "slab/soularite/soularite_slab", soularite_slab, double_soularite_slab, false);
		GameRegistry.registerBlock(ebonheart_slab, ItemBlockSlab.class, "slab/ebonheart/ebonheart_slab", ebonheart_slab, double_ebonheart_slab, false);
		GameRegistry.registerBlock(obsidian_slab, ItemBlockSlab.class, "slab/obsidian/obsidian_slab", obsidian_slab, double_obsidian_slab, false);
		GameRegistry.registerBlock(glowstone_slab, ItemBlockSlab.class, "slab/glowstone/glowstone_slab", glowstone_slab, double_glowstone_slab, false);
		
		
		
		draconium_stairs = registerBlock(new EABlockStairs("stairs/draconium_stairs", draconium_block).setResistance(4.0F));
		velious_stairs = registerBlock(new EABlockStairs("stairs/velious_stairs", velious_block).setResistance(15.0F));
		arcanite_stairs = registerBlock(new EABlockStairs("stairs/arcanite_stairs", arcanite_block).setResistance(30.0F));
		katcheen_stairs = registerBlock(new EABlockStairs("stairs/katcheen_stairs", katcheen_block).setResistance(100.0F));
		necrocite_stairs = registerBlock(new EABlockStairs("stairs/necrocite_stairs", necrocite_block).setResistance(45.0F));
		soularite_stairs = registerBlock(new EABlockStairs("stairs/soularite_stairs", soularite_block).setResistance(45.0F));
		ebonheart_stairs = registerBlock(new EABlockStairs("stairs/ebonheart_stairs", ebonheart_block).setResistance(2000.0F));
		obsidian_stairs = registerBlock(new EABlockStairs("stairs/obsidian_stairs", obsidian_block).setResistance(2000.0F));
		glowstone_stairs = registerBlock(new EABlockStairs("stairs/glowstone_stairs", glowstone_block).setResistance(45.0F).setLightLevel(1.0f));
		
		draconium_fence = registerBlock(new EABlockFence("fence/draconium_fence").setResistance(4.0F));
		velious_fence = registerBlock(new EABlockFence("fence/velious_fence").setResistance(15.0F));
		arcanite_fence = registerBlock(new EABlockFence("fence/arcanite_fence").setResistance(30.0F));
		katcheen_fence = registerBlock(new EABlockFence("fence/katcheen_fence").setResistance(100.0F));
		necrocite_fence = registerBlock(new EABlockFence("fence/necrocite_fence").setResistance(45.0F));
		soularite_fence = registerBlock(new EABlockFence("fence/soularite_fence").setResistance(45.0F));
		ebonheart_fence = registerBlock(new EABlockFence("fence/ebonheart_fence").setResistance(2000.0F));
		obsidian_fence = registerBlock(new EABlockFence("fence/obsidian_fence").setResistance(2000.0F));
		glowstone_fence = registerBlock(new EABlockFence("fence/glowstone_fence").setResistance(45.0F).setLightLevel(1.0f));
		
		draconium_fence_gate = registerBlock(new EABlockFenceGate("fence/draconium_fence_gate").setResistance(4.0F));
		velious_fence_gate = registerBlock(new EABlockFenceGate("fence/velious_fence_gate").setResistance(15.0F));
		arcanite_fence_gate = registerBlock(new EABlockFenceGate("fence/arcanite_fence_gate").setResistance(30.0F));
		katcheen_fence_gate = registerBlock(new EABlockFenceGate("fence/katcheen_fence_gate").setResistance(100.0F));
		necrocite_fence_gate = registerBlock(new EABlockFenceGate("fence/necrocite_fence_gate").setResistance(45.0F));
		soularite_fence_gate = registerBlock(new EABlockFenceGate("fence/soularite_fence_gate").setResistance(45.0F));
		ebonheart_fence_gate = registerBlock(new EABlockFenceGate("fence/ebonheart_fence_gate").setResistance(2000.0F));
		obsidian_fence_gate = registerBlock(new EABlockFenceGate("fence/obsidian_fence_gate").setResistance(2000.0F));
		glowstone_fence_gate = registerBlock(new EABlockFenceGate("fence/glowstone_fence_gate").setResistance(45.0F).setLightLevel(1.0f));
		
		draconium_wall = registerBlock(new EABlockWall("wall/draconium_wall", draconium_block).setResistance(4.0F));
		velious_wall = registerBlock(new EABlockWall("wall/velious_wall", velious_block).setResistance(15.0F));
		arcanite_wall = registerBlock(new EABlockWall("wall/arcanite_wall", arcanite_block).setResistance(30.0F));
		katcheen_wall = registerBlock(new EABlockWall("wall/katcheen_wall", katcheen_block).setResistance(100.0F));
		necrocite_wall = registerBlock(new EABlockWall("wall/necrocite_wall", necrocite_block).setResistance(45.0F));
		soularite_wall = registerBlock(new EABlockWall("wall/soularite_wall", soularite_block).setResistance(45.0F));
		ebonheart_wall = registerBlock(new EABlockWall("wall/ebonheart_wall", ebonheart_block).setResistance(2000.0F));
		obsidian_wall = registerBlock(new EABlockWall("wall/obsidian_wall", obsidian_block).setResistance(2000.0F));
		glowstone_wall = registerBlock(new EABlockWall("wall/glowstone_wall", glowstone_block).setResistance(45.0F).setLightLevel(1.0f));
		
		draconium_torch = registerBlock(new EABlockTorchDraconium().setResistance(4.0F));
		velious_torch = registerBlock(new EABlockTorchVelious().setResistance(15.0F));
		arcanite_torch = registerBlock(new EABlockTorchArcanite().setResistance(30.0F));
		katcheen_torch = registerBlock(new EABlockTorchKatcheen().setResistance(100.0F));
		necrocite_torch = registerBlock(new EABlockTorchNecrocite().setResistance(45.0F));
		soularite_torch = registerBlock(new EABlockTorchSoularite().setResistance(45.0F));
		ebonheart_torch = registerBlock(new EABlockTorchEbonheart().setResistance(2000.0F));
		obsidian_torch = registerBlock(new EABlockTorchObsidian().setResistance(2000.0F));
		glowstone_torch = registerBlock(new EABlockTorchGlowstone().setResistance(45.0F));
		
		draconium_trapdoor = registerBlock(new EABlockTrapDoor("door/draconium_trapdoor").setResistance(4.0F));
		velious_trapdoor = registerBlock(new EABlockTrapDoor("door/velious_trapdoor").setResistance(4.0F));
		arcanite_trapdoor = registerBlock(new EABlockTrapDoor("door/arcanite_trapdoor").setResistance(4.0F));
		katcheen_trapdoor = registerBlock(new EABlockTrapDoor("door/katcheen_trapdoor").setResistance(4.0F));
		necrocite_trapdoor = registerBlock(new EABlockTrapDoor("door/necrocite_trapdoor").setResistance(4.0F));
		soularite_trapdoor = registerBlock(new EABlockTrapDoor("door/soularite_trapdoor").setResistance(4.0F));
		ebonheart_trapdoor = registerBlock(new EABlockTrapDoor("door/ebonheart_trapdoor").setResistance(4.0F));
		obsidian_trapdoor = registerBlock(new EABlockTrapDoor("door/obsidian_trapdoor").setResistance(4.0F));
		glowstone_trapdoor = registerBlock(new EABlockTrapDoor("door/glowstone_trapdoor").setResistance(4.0F));
		
		draconium_ladder = registerBlock(new EABlockLadder("ladder/draconium_ladder"));
		velious_ladder = registerBlock(new EABlockLadder("ladder/velious_ladder"));
		arcanite_ladder = registerBlock(new EABlockLadder("ladder/arcanite_ladder"));
		katcheen_ladder = registerBlock(new EABlockLadder("ladder/katcheen_ladder"));
		necrocite_ladder = registerBlock(new EABlockLadder("ladder/necrocite_ladder"));
		soularite_ladder = registerBlock(new EABlockLadder("ladder/soularite_ladder"));
		ebonheart_ladder = registerBlock(new EABlockLadder("ladder/ebonheart_ladder"));
		obsidian_ladder = registerBlock(new EABlockLadder("ladder/obsidian_ladder"));
		glowstone_ladder = registerBlock(new EABlockLadder("ladder/glowstone_ladder").setLightLevel(1.0f));
		
		draconium_pillar = registerBlock(new EABlockPillar("pillar/draconium_pillar").setResistance(4.0F));
		velious_pillar = registerBlock(new EABlockPillar("pillar/velious_pillar").setResistance(15.0F));
		arcanite_pillar = registerBlock(new EABlockPillar("pillar/arcanite_pillar").setResistance(30.0F));
		katcheen_pillar = registerBlock(new EABlockPillar("pillar/katcheen_pillar").setResistance(100.0F));
		necrocite_pillar = registerBlock(new EABlockPillar("pillar/necrocite_pillar").setResistance(45.0F));
		soularite_pillar = registerBlock(new EABlockPillar("pillar/soularite_pillar").setResistance(45.0F));
		ebonheart_pillar = registerBlock(new EABlockPillar("pillar/ebonheart_pillar").setResistance(2000.0F));
		obsidian_pillar = registerBlock(new EABlockPillar("pillar/obsidian_pillar").setResistance(2000.0F));
		glowstone_pillar = registerBlock(new EABlockPillar("pillar/glowstone_pillar").setResistance(45.0F).setLightLevel(1.0f));
		
		draconium_block_fancybrick = registerBlock(new BlockEA("gem/draconium/draconium_block_fancybrick").setResistance(4.0F));
		velious_block_fancybrick = registerBlock(new BlockEA("gem/velious/velious_block_fancybrick").setResistance(15.0F));
		arcanite_block_fancybrick = registerBlock(new BlockEA("gem/arcanite/arcanite_block_fancybrick").setResistance(30.0F));
		katcheen_block_fancybrick = registerBlock(new BlockEA("gem/katcheen/katcheen_block_fancybrick").setResistance(100.0F));
		necrocite_block_fancybrick = registerBlock(new BlockEA("gem/necrocite/necrocite_block_fancybrick").setResistance(45.0F));
		soularite_block_fancybrick = registerBlock(new BlockEA("gem/soularite/soularite_block_fancybrick").setResistance(45.0F));
		ebonheart_block_fancybrick = registerBlock(new BlockEA("gem/ebonheart/ebonheart_block_fancybrick").setResistance(2000.0F));
		obsidian_block_fancybrick = registerBlock(new BlockEA("gem/obsidian/obsidian_block_fancybrick").setResistance(2000.0F));
		glowstone_block_fancybrick = registerBlock(new BlockEA("gem/glowstone/glowstone_block_fancybrick").setResistance(45.0F).setLightLevel(1.0f));
		
		
		
		cobble_mystic_block_normal = registerBlock(new BlockMysticCobblestone("gem/mystic/cobblestone/cobble_mystic_block_normal"));
		cobble_mystic_block_glass = registerBlock(new BlockMysticCobblestoneGlass("gem/mystic/cobblestone/cobble_mystic_block_glass"));
		cobble_mystic_block_white = registerBlock(new BlockMysticCobblestone("gem/mystic/cobblestone/cobble_mystic_block_white"));
		cobble_mystic_block_orange = registerBlock(new BlockMysticCobblestone("gem/mystic/cobblestone/cobble_mystic_block_orange"));
		cobble_mystic_block_magenta = registerBlock(new BlockMysticCobblestone("gem/mystic/cobblestone/cobble_mystic_block_magenta"));
		cobble_mystic_block_lightblue = registerBlock(new BlockMysticCobblestone("gem/mystic/cobblestone/cobble_mystic_block_lightblue"));
		cobble_mystic_block_yellow = registerBlock(new BlockMysticCobblestone("gem/mystic/cobblestone/cobble_mystic_block_yellow"));
		cobble_mystic_block_lime = registerBlock(new BlockMysticCobblestone("gem/mystic/cobblestone/cobble_mystic_block_lime"));
		cobble_mystic_block_pink = registerBlock(new BlockMysticCobblestone("gem/mystic/cobblestone/cobble_mystic_block_pink"));
		cobble_mystic_block_gray = registerBlock(new BlockMysticCobblestone("gem/mystic/cobblestone/cobble_mystic_block_gray"));
		cobble_mystic_block_lightgray = registerBlock(new BlockMysticCobblestone("gem/mystic/cobblestone/cobble_mystic_block_lightgray"));
		cobble_mystic_block_cyan = registerBlock(new BlockMysticCobblestone("gem/mystic/cobblestone/cobble_mystic_block_cyan"));
		cobble_mystic_block_purple = registerBlock(new BlockMysticCobblestone("gem/mystic/cobblestone/cobble_mystic_block_purple"));
		cobble_mystic_block_blue = registerBlock(new BlockMysticCobblestone("gem/mystic/cobblestone/cobble_mystic_block_blue"));
		cobble_mystic_block_brown = registerBlock(new BlockMysticCobblestone("gem/mystic/cobblestone/cobble_mystic_block_brown"));
		cobble_mystic_block_green = registerBlock(new BlockMysticCobblestone("gem/mystic/cobblestone/cobble_mystic_block_green"));
		cobble_mystic_block_red = registerBlock(new BlockMysticCobblestone("gem/mystic/cobblestone/cobble_mystic_block_red"));
		cobble_mystic_block_black = registerBlock(new BlockMysticCobblestone("gem/mystic/cobblestone/cobble_mystic_block_black"));
		
		mystic_block_normal = registerBlock(new BlockMysticStone("gem/mystic/stone/mystic_block_normal"));
		mystic_block_glass = registerBlock(new BlockMysticStoneGlass("gem/mystic/stone/mystic_block_glass"));
		mystic_block_white = registerBlock(new BlockMysticStone("gem/mystic/stone/mystic_block_white"));
		mystic_block_orange = registerBlock(new BlockMysticStone("gem/mystic/stone/mystic_block_orange"));
		mystic_block_magenta = registerBlock(new BlockMysticStone("gem/mystic/stone/mystic_block_magenta"));
		mystic_block_lightblue = registerBlock(new BlockMysticStone("gem/mystic/stone/mystic_block_lightblue"));
		mystic_block_yellow = registerBlock(new BlockMysticStone("gem/mystic/stone/mystic_block_yellow"));
		mystic_block_lime = registerBlock(new BlockMysticStone("gem/mystic/stone/mystic_block_lime"));
		mystic_block_pink = registerBlock(new BlockMysticStone("gem/mystic/stone/mystic_block_pink"));
		mystic_block_gray = registerBlock(new BlockMysticStone("gem/mystic/stone/mystic_block_gray"));
		mystic_block_lightgray = registerBlock(new BlockMysticStone("gem/mystic/stone/mystic_block_lightgray"));
		mystic_block_cyan = registerBlock(new BlockMysticStone("gem/mystic/stone/mystic_block_cyan"));
		mystic_block_purple = registerBlock(new BlockMysticStone("gem/mystic/stone/mystic_block_purple"));
		mystic_block_blue = registerBlock(new BlockMysticStone("gem/mystic/stone/mystic_block_blue"));
		mystic_block_brown = registerBlock(new BlockMysticStone("gem/mystic/stone/mystic_block_brown"));
		mystic_block_green = registerBlock(new BlockMysticStone("gem/mystic/stone/mystic_block_green"));
		mystic_block_red = registerBlock(new BlockMysticStone("gem/mystic/stone/mystic_block_red"));
		mystic_block_black = registerBlock(new BlockMysticStone("gem/mystic/stone/mystic_block_black"));
		
		wood_mystic_block_normal = registerBlock(new BlockMysticWood("gem/mystic/wood/wood_mystic_block_normal"));
		wood_mystic_block_glass = registerBlock(new BlockMysticWoodGlass("gem/mystic/wood/wood_mystic_block_glass"));
		wood_mystic_block_white = registerBlock(new BlockMysticWood("gem/mystic/wood/wood_mystic_block_white"));
		wood_mystic_block_orange = registerBlock(new BlockMysticWood("gem/mystic/wood/wood_mystic_block_orange"));
		wood_mystic_block_magenta = registerBlock(new BlockMysticWood("gem/mystic/wood/wood_mystic_block_magenta"));
		wood_mystic_block_lightblue = registerBlock(new BlockMysticWood("gem/mystic/wood/wood_mystic_block_lightblue"));
		wood_mystic_block_yellow = registerBlock(new BlockMysticWood("gem/mystic/wood/wood_mystic_block_yellow"));
		wood_mystic_block_lime = registerBlock(new BlockMysticWood("gem/mystic/wood/wood_mystic_block_lime"));
		wood_mystic_block_pink = registerBlock(new BlockMysticWood("gem/mystic/wood/wood_mystic_block_pink"));
		wood_mystic_block_gray = registerBlock(new BlockMysticWood("gem/mystic/wood/wood_mystic_block_gray"));
		wood_mystic_block_lightgray = registerBlock(new BlockMysticWood("gem/mystic/wood/wood_mystic_block_lightgray"));
		wood_mystic_block_cyan = registerBlock(new BlockMysticWood("gem/mystic/wood/wood_mystic_block_cyan"));
		wood_mystic_block_purple = registerBlock(new BlockMysticWood("gem/mystic/wood/wood_mystic_block_purple"));
		wood_mystic_block_blue = registerBlock(new BlockMysticWood("gem/mystic/wood/wood_mystic_block_blue"));
		wood_mystic_block_brown = registerBlock(new BlockMysticWood("gem/mystic/wood/wood_mystic_block_brown"));
		wood_mystic_block_green = registerBlock(new BlockMysticWood("gem/mystic/wood/wood_mystic_block_green"));
		wood_mystic_block_red = registerBlock(new BlockMysticWood("gem/mystic/wood/wood_mystic_block_red"));
		wood_mystic_block_black = registerBlock(new BlockMysticWood("gem/mystic/wood/wood_mystic_block_black"));
		
		paper_block = registerBlock(new EABlockDirectional("paper_block").setResistance(4.0F));
		leather_block = registerBlock(new EABlockDirectional("leather_block").setResistance(4.0F));
		reed_block = registerBlock(new EABlockDirectional("reed_block").setResistance(4.0F));
		
		hellion_fruit = registerBlock(new HellionFruitCrop());
		sacred_fruit = registerBlock(new SacredFruitCrop());
		dragon_fruit = registerBlock(new DragonFruitCrop());
		
		
		
		//----------------------------------------------
		
		
		
		cryptic_draconium_block = registerBlock(new BlockEA("cryptic/block/cryptic_draconium_block").setResistance(4.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_velious_block = registerBlock(new BlockEA("cryptic/block/cryptic_velious_block").setResistance(15.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_arcanite_block = registerBlock(new BlockEA("cryptic/block/cryptic_arcanite_block").setResistance(30.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_katcheen_block = registerBlock(new BlockEA("cryptic/block/cryptic_katcheen_block").setResistance(100.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_necrocite_block = registerBlock(new BlockEA("cryptic/block/cryptic_necrocite_block").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_soularite_block = registerBlock(new BlockEA("cryptic/block/cryptic_soularite_block").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_ebonheart_block = registerBlock(new BlockEA("cryptic/block/cryptic_ebonheart_block").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_obsidian_block = registerBlock(new BlockEA("cryptic/block/cryptic_obsidian_block").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_glowstone_block = registerBlock(new BlockEA("cryptic/block/cryptic_glowstone_block").setResistance(45.0F).setLightLevel(1.0f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		
		cryptic_draconium_block_brick = registerBlock(new BlockEA("cryptic/block/cryptic_draconium_block_brick").setResistance(4.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_velious_block_brick = registerBlock(new BlockEA("cryptic/block/cryptic_velious_block_brick").setResistance(15.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_arcanite_block_brick = registerBlock(new BlockEA("cryptic/block/cryptic_arcanite_block_brick").setResistance(30.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_katcheen_block_brick = registerBlock(new BlockEA("cryptic/block/cryptic_katcheen_block_brick").setResistance(100.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_necrocite_block_brick = registerBlock(new BlockEA("cryptic/block/cryptic_necrocite_block_brick").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_soularite_block_brick = registerBlock(new BlockEA("cryptic/block/cryptic_soularite_block_brick").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_ebonheart_block_brick = registerBlock(new BlockEA("cryptic/block/cryptic_ebonheart_block_brick").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_obsidian_block_brick = registerBlock(new BlockEA("cryptic/block/cryptic_obsidian_block_brick").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_glowstone_block_brick = registerBlock(new BlockEA("cryptic/block/cryptic_glowstone_block_brick").setResistance(45.0F).setLightLevel(1.0f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		
		double_cryptic_draconium_slab = new BlockDoubleSlab("cryptic/slab/double_cryptic_draconium_slab").setResistance(4.0F);
		double_cryptic_velious_slab = new BlockDoubleSlab("cryptic/slab/double_cryptic_velious_slab").setResistance(15.0F);
		double_cryptic_arcanite_slab = new BlockDoubleSlab("cryptic/slab/double_cryptic_arcanite_slab").setResistance(30.0F);
		double_cryptic_katcheen_slab = new BlockDoubleSlab("cryptic/slab/double_cryptic_katcheen_slab").setResistance(100.0F);
		double_cryptic_necrocite_slab = new BlockDoubleSlab("cryptic/slab/double_cryptic_necrocite_slab").setResistance(45.0F);
		double_cryptic_soularite_slab = new BlockDoubleSlab("cryptic/slab/double_cryptic_soularite_slab").setResistance(45.0F);
		double_cryptic_ebonheart_slab = new BlockDoubleSlab("cryptic/slab/double_cryptic_ebonheart_slab").setResistance(2000.0F);
		double_cryptic_obsidian_slab = new BlockDoubleSlab("cryptic/slab/double_cryptic_obsidian_slab").setResistance(2000.0F);
		double_cryptic_glowstone_slab = new BlockDoubleSlab("cryptic/slab/double_cryptic_glowstone_slab").setResistance(45.0F).setLightLevel(1.0f);
		
		cryptic_draconium_slab = new BlockHalfSlab("cryptic/slab/cryptic_draconium_slab").setResistance(4.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic);
		cryptic_velious_slab = new BlockHalfSlab("cryptic/slab/cryptic_velious_slab").setResistance(15.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic);
		cryptic_arcanite_slab = new BlockHalfSlab("cryptic/slab/cryptic_arcanite_slab").setResistance(30.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic);
		cryptic_katcheen_slab = new BlockHalfSlab("cryptic/slab/cryptic_katcheen_slab").setResistance(100.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic);
		cryptic_necrocite_slab = new BlockHalfSlab("cryptic/slab/cryptic_necrocite_slab").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic);
		cryptic_soularite_slab = new BlockHalfSlab("cryptic/slab/cryptic_soularite_slab").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic);
		cryptic_ebonheart_slab = new BlockHalfSlab("cryptic/slab/cryptic_ebonheart_slab").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic);
		cryptic_obsidian_slab = new BlockHalfSlab("cryptic/slab/cryptic_obsidian_slab").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic);
		cryptic_glowstone_slab = new BlockHalfSlab("cryptic/slab/cryptic_glowstone_slab").setResistance(45.0F).setLightLevel(1.0f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic);
		
		
		
		GameRegistry.registerBlock(double_cryptic_draconium_slab, ItemBlockSlab.class, "cryptic/slab/double_cryptic_draconium_slab", cryptic_draconium_slab, double_cryptic_draconium_slab, true);
		GameRegistry.registerBlock(double_cryptic_velious_slab, ItemBlockSlab.class, "cryptic/slab/double_cryptic_velious_slab", cryptic_velious_slab, double_cryptic_velious_slab, true);
		GameRegistry.registerBlock(double_cryptic_arcanite_slab, ItemBlockSlab.class, "cryptic/slab/double_cryptic_arcanite_slab", cryptic_arcanite_slab, double_cryptic_arcanite_slab, true);
		GameRegistry.registerBlock(double_cryptic_katcheen_slab, ItemBlockSlab.class, "cryptic/slab/double_cryptic_katcheen_slab", cryptic_katcheen_slab, double_cryptic_katcheen_slab, true);
		GameRegistry.registerBlock(double_cryptic_necrocite_slab, ItemBlockSlab.class, "cryptic/slab/double_cryptic_necrocite_slab", cryptic_necrocite_slab, double_cryptic_necrocite_slab, true);
		GameRegistry.registerBlock(double_cryptic_soularite_slab, ItemBlockSlab.class, "cryptic/slab/double_cryptic_soularite_slab", cryptic_soularite_slab, double_cryptic_soularite_slab, true);
		GameRegistry.registerBlock(double_cryptic_ebonheart_slab, ItemBlockSlab.class, "cryptic/slab/double_cryptic_ebonheart_slab", cryptic_ebonheart_slab, double_cryptic_ebonheart_slab, true);
		GameRegistry.registerBlock(double_cryptic_obsidian_slab, ItemBlockSlab.class, "cryptic/slab/double_cryptic_obsidian_slab", cryptic_obsidian_slab, double_cryptic_obsidian_slab, true);
		GameRegistry.registerBlock(double_cryptic_glowstone_slab, ItemBlockSlab.class, "cryptic/slab/double_cryptic_glowstone_slab", cryptic_glowstone_slab, double_cryptic_glowstone_slab, true);
		
		GameRegistry.registerBlock(cryptic_draconium_slab, ItemBlockSlab.class, "cryptic/slab/cryptic_draconium_slab", cryptic_draconium_slab, double_cryptic_draconium_slab, false);
		GameRegistry.registerBlock(cryptic_velious_slab, ItemBlockSlab.class, "cryptic/slab/cryptic_velious_slab", cryptic_velious_slab, double_cryptic_velious_slab, false);
		GameRegistry.registerBlock(cryptic_arcanite_slab, ItemBlockSlab.class, "cryptic/slab/cryptic_arcanite_slab", cryptic_arcanite_slab, double_cryptic_arcanite_slab, false);
		GameRegistry.registerBlock(cryptic_katcheen_slab, ItemBlockSlab.class, "cryptic/slab/cryptic_katcheen_slab", cryptic_katcheen_slab, double_cryptic_katcheen_slab, false);
		GameRegistry.registerBlock(cryptic_necrocite_slab, ItemBlockSlab.class, "cryptic/slab/cryptic_necrocite_slab", cryptic_necrocite_slab, double_cryptic_necrocite_slab, false);
		GameRegistry.registerBlock(cryptic_soularite_slab, ItemBlockSlab.class, "cryptic/slab/cryptic_soularite_slab", cryptic_soularite_slab, double_cryptic_soularite_slab, false);
		GameRegistry.registerBlock(cryptic_ebonheart_slab, ItemBlockSlab.class, "cryptic/slab/cryptic_ebonheart_slab", cryptic_ebonheart_slab, double_cryptic_ebonheart_slab, false);
		GameRegistry.registerBlock(cryptic_obsidian_slab, ItemBlockSlab.class, "cryptic/slab/cryptic_obsidian_slab", cryptic_obsidian_slab, double_cryptic_obsidian_slab, false);
		GameRegistry.registerBlock(cryptic_glowstone_slab, ItemBlockSlab.class, "cryptic/slab/cryptic_glowstone_slab", cryptic_glowstone_slab, double_cryptic_glowstone_slab, false);
		
		
		
		cryptic_draconium_stairs = registerBlock(new EABlockStairs("cryptic/stairs/cryptic_draconium_stairs", cryptic_draconium_block).setResistance(4.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_velious_stairs = registerBlock(new EABlockStairs("cryptic/stairs/cryptic_velious_stairs", cryptic_velious_block).setResistance(15.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_arcanite_stairs = registerBlock(new EABlockStairs("cryptic/stairs/cryptic_arcanite_stairs", cryptic_arcanite_block).setResistance(30.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_katcheen_stairs = registerBlock(new EABlockStairs("cryptic/stairs/cryptic_katcheen_stairs", cryptic_katcheen_block).setResistance(100.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_necrocite_stairs = registerBlock(new EABlockStairs("cryptic/stairs/cryptic_necrocite_stairs", cryptic_necrocite_block).setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_soularite_stairs = registerBlock(new EABlockStairs("cryptic/stairs/cryptic_soularite_stairs", cryptic_soularite_block).setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_ebonheart_stairs = registerBlock(new EABlockStairs("cryptic/stairs/cryptic_ebonheart_stairs", cryptic_ebonheart_block).setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_obsidian_stairs = registerBlock(new EABlockStairs("cryptic/stairs/cryptic_obsidian_stairs", cryptic_obsidian_block).setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_glowstone_stairs = registerBlock(new EABlockStairs("cryptic/stairs/cryptic_glowstone_stairs", cryptic_glowstone_block).setResistance(45.0F).setLightLevel(1.0f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		
		cryptic_draconium_fence = registerBlock(new EABlockFence("cryptic/fence/cryptic_draconium_fence").setResistance(4.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_velious_fence = registerBlock(new EABlockFence("cryptic/fence/cryptic_velious_fence").setResistance(15.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_arcanite_fence = registerBlock(new EABlockFence("cryptic/fence/cryptic_arcanite_fence").setResistance(30.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_katcheen_fence = registerBlock(new EABlockFence("cryptic/fence/cryptic_katcheen_fence").setResistance(100.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_necrocite_fence = registerBlock(new EABlockFence("cryptic/fence/cryptic_necrocite_fence").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_soularite_fence = registerBlock(new EABlockFence("cryptic/fence/cryptic_soularite_fence").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_ebonheart_fence = registerBlock(new EABlockFence("cryptic/fence/cryptic_ebonheart_fence").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_obsidian_fence = registerBlock(new EABlockFence("cryptic/fence/cryptic_obsidian_fence").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_glowstone_fence = registerBlock(new EABlockFence("cryptic/fence/cryptic_glowstone_fence").setResistance(45.0F).setLightLevel(1.0f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		
		cryptic_draconium_fence_gate = registerBlock(new EABlockFenceGate("cryptic/fence/cryptic_draconium_fence_gate").setResistance(4.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_velious_fence_gate = registerBlock(new EABlockFenceGate("cryptic/fence/cryptic_velious_fence_gate").setResistance(15.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_arcanite_fence_gate = registerBlock(new EABlockFenceGate("cryptic/fence/cryptic_arcanite_fence_gate").setResistance(30.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_katcheen_fence_gate = registerBlock(new EABlockFenceGate("cryptic/fence/cryptic_katcheen_fence_gate").setResistance(100.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_necrocite_fence_gate = registerBlock(new EABlockFenceGate("cryptic/fence/cryptic_necrocite_fence_gate").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_soularite_fence_gate = registerBlock(new EABlockFenceGate("cryptic/fence/cryptic_soularite_fence_gate").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_ebonheart_fence_gate = registerBlock(new EABlockFenceGate("cryptic/fence/cryptic_ebonheart_fence_gate").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_obsidian_fence_gate = registerBlock(new EABlockFenceGate("cryptic/fence/cryptic_obsidian_fence_gate").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_glowstone_fence_gate = registerBlock(new EABlockFenceGate("cryptic/fence/cryptic_glowstone_fence_gate").setResistance(45.0F).setLightLevel(1.0f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		
		cryptic_draconium_wall = registerBlock(new EABlockWall("cryptic/wall/cryptic_draconium_wall", cryptic_draconium_block).setResistance(4.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_velious_wall = registerBlock(new EABlockWall("cryptic/wall/cryptic_velious_wall", cryptic_velious_block).setResistance(15.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_arcanite_wall = registerBlock(new EABlockWall("cryptic/wall/cryptic_arcanite_wall", cryptic_arcanite_block).setResistance(30.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_katcheen_wall = registerBlock(new EABlockWall("cryptic/wall/cryptic_katcheen_wall", cryptic_katcheen_block).setResistance(100.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_necrocite_wall = registerBlock(new EABlockWall("cryptic/wall/cryptic_necrocite_wall", cryptic_necrocite_block).setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_soularite_wall = registerBlock(new EABlockWall("cryptic/wall/cryptic_soularite_wall", cryptic_soularite_block).setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_ebonheart_wall = registerBlock(new EABlockWall("cryptic/wall/cryptic_ebonheart_wall", cryptic_ebonheart_block).setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_obsidian_wall = registerBlock(new EABlockWall("cryptic/wall/cryptic_obsidian_wall", cryptic_obsidian_block).setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_glowstone_wall = registerBlock(new EABlockWall("cryptic/wall/cryptic_glowstone_wall", cryptic_glowstone_block).setResistance(45.0F).setLightLevel(1.0f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		
		//cryptic_draconium_torch = registerBlock(new EABlockTorchDraconium().setResistance(4.0F));
		//cryptic_velious_torch = registerBlock(new EABlockTorchVelious().setResistance(15.0F));
		//cryptic_arcanite_torch = registerBlock(new EABlockTorchArcanite().setResistance(30.0F));
		//cryptic_katcheen_torch = registerBlock(new EABlockTorchKatcheen().setResistance(100.0F));
		//cryptic_necrocite_torch = registerBlock(new EABlockTorchNecrocite().setResistance(45.0F));
		//cryptic_soularite_torch = registerBlock(new EABlockTorchSoularite().setResistance(45.0F));
		//cryptic_ebonheart_torch = registerBlock(new EABlockTorchEbonheart().setResistance(2000.0F));
		//cryptic_obsidian_torch = registerBlock(new EABlockTorchObsidian().setResistance(2000.0F));
		//cryptic_glowstone_torch = registerBlock(new EABlockTorchGlowstone().setResistance(45.0F));
		
		cryptic_draconium_trapdoor = registerBlock(new EABlockTrapDoor("cryptic/door/cryptic_draconium_trapdoor").setResistance(4.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_velious_trapdoor = registerBlock(new EABlockTrapDoor("cryptic/door/cryptic_velious_trapdoor").setResistance(4.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_arcanite_trapdoor = registerBlock(new EABlockTrapDoor("cryptic/door/cryptic_arcanite_trapdoor").setResistance(4.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_katcheen_trapdoor = registerBlock(new EABlockTrapDoor("cryptic/door/cryptic_katcheen_trapdoor").setResistance(4.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_necrocite_trapdoor = registerBlock(new EABlockTrapDoor("cryptic/door/cryptic_necrocite_trapdoor").setResistance(4.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_soularite_trapdoor = registerBlock(new EABlockTrapDoor("cryptic/door/cryptic_soularite_trapdoor").setResistance(4.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_ebonheart_trapdoor = registerBlock(new EABlockTrapDoor("cryptic/door/cryptic_ebonheart_trapdoor").setResistance(4.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_obsidian_trapdoor = registerBlock(new EABlockTrapDoor("cryptic/door/cryptic_obsidian_trapdoor").setResistance(4.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_glowstone_trapdoor = registerBlock(new EABlockTrapDoor("cryptic/door/cryptic_glowstone_trapdoor").setResistance(4.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		
		cryptic_draconium_ladder = registerBlock(new EABlockLadder("cryptic/ladder/cryptic_draconium_ladder").setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_velious_ladder = registerBlock(new EABlockLadder("cryptic/ladder/cryptic_velious_ladder").setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_arcanite_ladder = registerBlock(new EABlockLadder("cryptic/ladder/cryptic_arcanite_ladder").setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_katcheen_ladder = registerBlock(new EABlockLadder("cryptic/ladder/cryptic_katcheen_ladder").setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_necrocite_ladder = registerBlock(new EABlockLadder("cryptic/ladder/cryptic_necrocite_ladder").setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_soularite_ladder = registerBlock(new EABlockLadder("cryptic/ladder/cryptic_soularite_ladder").setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_ebonheart_ladder = registerBlock(new EABlockLadder("cryptic/ladder/cryptic_ebonheart_ladder").setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_obsidian_ladder = registerBlock(new EABlockLadder("cryptic/ladder/cryptic_obsidian_ladder").setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_glowstone_ladder = registerBlock(new EABlockLadder("cryptic/ladder/cryptic_glowstone_ladder").setLightLevel(1.0f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		
		cryptic_draconium_pillar = registerBlock(new EABlockPillar("cryptic/pillar/cryptic_draconium_pillar").setResistance(4.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_velious_pillar = registerBlock(new EABlockPillar("cryptic/pillar/cryptic_velious_pillar").setResistance(15.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_arcanite_pillar = registerBlock(new EABlockPillar("cryptic/pillar/cryptic_arcanite_pillar").setResistance(30.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_katcheen_pillar = registerBlock(new EABlockPillar("cryptic/pillar/cryptic_katcheen_pillar").setResistance(100.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_necrocite_pillar = registerBlock(new EABlockPillar("cryptic/pillar/cryptic_necrocite_pillar").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_soularite_pillar = registerBlock(new EABlockPillar("cryptic/pillar/cryptic_soularite_pillar").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_ebonheart_pillar = registerBlock(new EABlockPillar("cryptic/pillar/cryptic_ebonheart_pillar").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_obsidian_pillar = registerBlock(new EABlockPillar("cryptic/pillar/cryptic_obsidian_pillar").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_glowstone_pillar = registerBlock(new EABlockPillar("cryptic/pillar/cryptic_glowstone_pillar").setResistance(45.0F).setLightLevel(1.0f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		
		cryptic_draconium_block_fancybrick = registerBlock(new BlockEA("cryptic/block/cryptic_draconium_block_fancybrick").setResistance(4.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_velious_block_fancybrick = registerBlock(new BlockEA("cryptic/block/cryptic_velious_block_fancybrick").setResistance(15.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_arcanite_block_fancybrick = registerBlock(new BlockEA("cryptic/block/cryptic_arcanite_block_fancybrick").setResistance(30.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_katcheen_block_fancybrick = registerBlock(new BlockEA("cryptic/block/cryptic_katcheen_block_fancybrick").setResistance(100.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_necrocite_block_fancybrick = registerBlock(new BlockEA("cryptic/block/cryptic_necrocite_block_fancybrick").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_soularite_block_fancybrick = registerBlock(new BlockEA("cryptic/block/cryptic_soularite_block_fancybrick").setResistance(45.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_ebonheart_block_fancybrick = registerBlock(new BlockEA("cryptic/block/cryptic_ebonheart_block_fancybrick").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_obsidian_block_fancybrick = registerBlock(new BlockEA("cryptic/block/cryptic_obsidian_block_fancybrick").setResistance(2000.0F).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		cryptic_glowstone_block_fancybrick = registerBlock(new BlockEA("cryptic/block/cryptic_glowstone_block_fancybrick").setResistance(45.0F).setLightLevel(1.0f).setCreativeTab(EbonArtsMod.tabEbonArtsCryptic));
		
		*/
	
//ViesCraftConfig.java
	/**
	 * 
	 *
	//final String RECIPES = ViesCraft.config.CATEGORY_GENERAL + ViesCraft.config.CATEGORY_SPLITTER + TextFormatting.GREEN + "Recipes";
	final String PARTICLES = ViesCraft.config.CATEGORY_GENERAL + ViesCraft.config.CATEGORY_SPLITTER + TextFormatting.AQUA + "Animation";
	
	//ViesCraft.config.addCustomCategoryComment(RECIPES, "Enable, disable, or modify item recipes.");
	//weaponRecipe = ViesCraft.config.get(RECIPES, TextFormatting.YELLOW + WEAPONRECIPE_NAME, WEAPONRECIPE_DEFAULT).getBoolean(WEAPONRECIPE_DEFAULT);
	//armorRecipe = ViesCraft.config.get(RECIPES, TextFormatting.YELLOW + ARMORRECIPE_NAME, ARMORRECIPE_DEFAULT).getBoolean(ARMORRECIPE_DEFAULT);
	//toolRecipe = ViesCraft.config.get(RECIPES, TextFormatting.YELLOW + TOOLRECIPE_NAME, TOOLRECIPE_DEFAULT).getBoolean(TOOLRECIPE_DEFAULT);
	//decraftRecipe1 = ViesCraft.config.get(RECIPES, TextFormatting.YELLOW + DECRAFTRECIPE1_NAME, DECRAFTRECIPE1_DEFAULT).getBoolean(DECRAFTRECIPE1_DEFAULT);
	
	//vanillaRecipe = ViesCraft.config.get(RECIPES, TextFormatting.WHITE + VANILLARECIPE_NAME, VANILLARECIPE_DEFAULT).getBoolean(VANILLARECIPE_DEFAULT);
	//horseRecipe = ViesCraft.config.get(RECIPES, TextFormatting.WHITE + HORSERECIPE_NAME, HORSERECIPE_DEFAULT).getBoolean(HORSERECIPE_DEFAULT);
	//musicRecipe = ViesCraft.config.get(RECIPES, TextFormatting.WHITE + MUSICRECIPE_NAME, MUSICRECIPE_DEFAULT).getBoolean(MUSICRECIPE_DEFAULT);
	
	
	//decraftRecipe2 = ViesCraft.config.get(RECIPES, DECRAFTRECIPE2_NAME, DECRAFTRECIPE2_DEFAULT).getBoolean(DECRAFTRECIPE2_DEFAULT);
	
	
	ViesCraft.config.addCustomCategoryComment(PARTICLES, "Enable or disable airship animation.");
	modelAnimation = ViesCraft.config.get(PARTICLES, TextFormatting.YELLOW + MODELANIMATION_NAME, MODELANIMATION_DEFAULT).getBoolean(MODELANIMATION_DEFAULT);
	modelTurnAngle = ViesCraft.config.get(PARTICLES, TextFormatting.YELLOW + MODELTURNANGLE_NAME, MODELTURNANGLE_DEFAULT).getBoolean(MODELTURNANGLE_DEFAULT);
	
	//plantParticle = ViesCraft.config.get(PARTICLES, TextFormatting.YELLOW + PLANTANIMATION_NAME, PLANTANIMATION_DEFAULT).getBoolean(PLANTANIMATION_DEFAULT);
	
	*/
	
	
//AirshipHandler.java
	/**
	 * 
	 *
	@SubscribeEvent
    public void onPlayerTick1(PlayerInteractEvent.EntityInteract event) 
    {
		
		//EntityPlayer player = Minecraft.getMinecraft().thePlayer;
		
		if(event.getTarget() instanceof EntityAirshipBlack
		&& Minecraft.getMinecraft().thePlayer.isSneaking()
				)
		{
			//LogHelper.info("Test successful!");
			//LogHelper.info(event.getTarget());
			
			//event.getEntityPlayer().openGui(Reference.MOD_ID, GuiHandler.GUI_AIRSHIP_BLACK, event.getEntityPlayer().worldObj, event.getEntityPlayer().getPosition().getX(), event.getEntityPlayer().getPosition().getY(), event.getEntityPlayer().getPosition().getZ());
			
			
		}
    }
    
    //================================
     
    ///if (event.player.getRidingEntity() instanceof EntityAirshipBlack 
			///	&& EntityAirshipBlack.openInputDown)
            ///{
				/////PacketDispatcher.sendToServer(new OpenGuiMessage(GuiHandler.GUI_AIRSHIP_BLACK));

				//event.player.openGui(Reference.MOD_ID, GuiHandler.GUI_AIRSHIP_BLACK, event.player.worldObj, event.player.getPosition().getX(), event.player.getPosition().getY(), event.player.getPosition().getZ());
				
				//LogHelper.info("Test 3 successful!");
            	//this.openGUI(this.worldObj, playerVC);
            	
            			//Minecraft.getMinecraft().thePlayer
            			
            			
            	//ViesCraft.network.sendToServer(new VCMessage("foobar"));
            			
            ///}
			//if (EntityAirshipBlack.openInputDown
			//		&& Minecraft.getMinecraft().currentScreen instanceof GuiEntityAirshipBlack
					
			//		)
            //{
				
				//event.player.closeScreen();//openGui(Reference.MOD_ID, GuiHandler.GUI_AIRSHIP_BLACK, event.player.worldObj, event.player.getPosition().getX(), event.player.getPosition().getY(), event.player.getPosition().getZ());
				
			//	LogHelper.info("Test 4 successful!");
            	//this.openGUI(this.worldObj, playerVC);
            	
            			//Minecraft.getMinecraft().thePlayer
            			
            			
            	//ViesCraft.network.sendToServer(new VCMessage("foobar"));
            			
            //}
			
			
			//if (//event.player.getRidingEntity().getPassengers()
				//event.player.getRidingEntity().isBeingRidden() instanceof EntityAnimal
				//&& 
			//	event.player.getRidingEntity().isRidingOrBeingRiddenBy(entityIn) == entityIn instanceof EntityAnimal
			//	) 
			//{
			//	isAnimalPassenger = true;
			//}
			
		//if (isAnimalPassenger) 
    	//{
		//	LogHelper.info("Airship's passenger is an animal!");
			//event.player.addStat(InitAchievementsVC.airship_lava);
    	//}
    	 * 
    	 * 
    	 * || event.player.getRidingEntity() instanceof EntityAirshipBlack
		|| event.player.getRidingEntity() instanceof EntityAirshipBlue
		|| event.player.getRidingEntity() instanceof EntityAirshipBrown
		|| event.player.getRidingEntity() instanceof EntityAirshipCyan
		|| event.player.getRidingEntity() instanceof EntityAirshipGray
		|| event.player.getRidingEntity() instanceof EntityAirshipGreen
		|| event.player.getRidingEntity() instanceof EntityAirshipLightBlue
		|| event.player.getRidingEntity() instanceof EntityAirshipLightGray
		|| event.player.getRidingEntity() instanceof EntityAirshipLime
		|| event.player.getRidingEntity() instanceof EntityAirshipMagenta
		|| event.player.getRidingEntity() instanceof EntityAirshipOrange
		|| event.player.getRidingEntity() instanceof EntityAirshipPink
		|| event.player.getRidingEntity() instanceof EntityAirshipPurple
		|| event.player.getRidingEntity() instanceof EntityAirshipRed
		|| event.player.getRidingEntity() instanceof EntityAirshipWhite
		//|| event.player.getRidingEntity() instanceof EntityAirshipYellow
	
				
    	 * 
	*/
	
	
	
	
	
	
}
