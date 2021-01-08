package com.iHamster.garage.util;


import com.iHamster.garage.Garage;
import com.iHamster.garage.blocks.*;

import net.minecraft.block.Block;
import net.minecraft.item.Item;


import net.minecraft.tileentity.TileEntityType;
import net.minecraftforge.fml.RegistryObject;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;

public class RegistryHandler {

    public static final DeferredRegister<Item> ITEMS =  DeferredRegister.create(ForgeRegistries.ITEMS, Garage.MOD_ID);
    public static final DeferredRegister<Block> BLOCKS = DeferredRegister.create(ForgeRegistries.BLOCKS, Garage.MOD_ID);
    public static final DeferredRegister<TileEntityType<?>> TILES = DeferredRegister.create(ForgeRegistries.TILE_ENTITIES, Garage.MOD_ID);



    public static void init(){

        ITEMS.register(FMLJavaModLoadingContext.get().getModEventBus());
        BLOCKS.register(FMLJavaModLoadingContext.get().getModEventBus());
        TILES.register(FMLJavaModLoadingContext.get().getModEventBus());

    }


    public static final RegistryObject<Block> WINDOW_TILE = BLOCKS.register("window_tile", WindowTile::new);

    public static final RegistryObject<Item> WINDOW_TILE_ITEM = ITEMS.register("window_tile", ()-> new BlockItemBase(WINDOW_TILE.get()));
//    public static final RegistryObject<Item> BLOCKBREAKERPOWERED_ITEM = ITEMS.register("block_breaker_powered", ()-> new BlockItemBase(BLOCKBREAKERPOWERED_BLOCK.get()));

    public static final RegistryObject<TileEntityType<WindowTileEntity>> WINDOW_TILE_ENTITY = TILES.register("window_tile", ()-> TileEntityType.Builder.create(WindowTileEntity::new,WINDOW_TILE.get()).build(null));
}
