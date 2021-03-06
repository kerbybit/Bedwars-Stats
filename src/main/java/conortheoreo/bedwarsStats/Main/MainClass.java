package conortheoreo.bedwarsStats.Main;

import conortheoreo.bedwarsStats.Config.ConfigManager;
import net.minecraft.client.Minecraft;
import net.minecraft.util.EnumChatFormatting;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.FMLCommonHandler;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.Mod.EventHandler;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

import java.io.File;

@Mod(modid = MainClass.MODID, version = MainClass.VERSION, acceptedMinecraftVersions = MainClass.MCVERSION)
public class MainClass {
    public static final String MODID = "bedwars-stats";
    public static final String VERSION = "1";
    public static final String MCVERSION = "[1.8.9]";

    public int totalStars;

    private File ConfigFile = ConfigManager.getConfigFile();

    @EventHandler
    public void init(FMLInitializationEvent event) {
        FMLCommonHandler.instance().bus().register(this);
        ConfigManager.loadSettings();
        System.out.println("[BedwarsStats] MCDIR Found! " + ConfigFile);
    }

    @SubscribeEvent
    public void render(RenderGameOverlayEvent event) {
        if (event.isCancelable() || event.type != RenderGameOverlayEvent.ElementType.EXPERIENCE) {
            return;
        }
        Minecraft.getMinecraft().fontRendererObj.drawString(EnumChatFormatting.GREEN + "Total Stars:" + EnumChatFormatting.WHITE + totalStars, 5, 5, 0);
    }

}
