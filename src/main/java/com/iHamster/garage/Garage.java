package com.iHamster.garage;

import com.iHamster.garage.blocks.WindowTileEntity;
import com.iHamster.garage.blocks.WindowTileEntityRenderer;
import com.iHamster.garage.util.RegistryHandler;
import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.eventbus.api.IEventBus;
import net.minecraftforge.fml.client.registry.ClientRegistry;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.event.lifecycle.FMLClientSetupEvent;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

// The value here should match an entry in the META-INF/mods.toml file
@Mod("garage")
public class Garage {
    // Directly reference a log4j logger.
    private static final Logger LOGGER = LogManager.getLogger();

    public static final String MOD_ID = "garage";
    public static IEventBus MOD_EVENT_BUS;


    public Garage() {
        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::setup);

        FMLJavaModLoadingContext.get().getModEventBus().addListener(this::doClientStuff);

        RegistryHandler.init();

        MinecraftForge.EVENT_BUS.register(this);
    }

    private void setup(final FMLCommonSetupEvent event) {
        // some preinit code

    }
    public static TileEntityType <WindowTileEntity> windowTileEntityTileEntityType;
    private void doClientStuff(final FMLClientSetupEvent event) {
            ClientRegistry.bindTileEntityRenderer(windowTileEntityTileEntityType, WindowTileEntityRenderer::new);
            System.out.println("renderer registered");
    }



}
