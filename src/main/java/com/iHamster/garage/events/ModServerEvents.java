package com.iHamster.garage.events;

/*
@Mod.EventBusSubscriber(modid = "garage", bus =  Mod.EventBusSubscriber.Bus.FORGE, value = Dist.DEDICATED_SERVER)

// You can use EventBusSubscriber to automatically subscribe events on the contained class (this is subscribing to the MOD
// Event bus for receiving Registry Events)

public class ModServerEvents {

    public static DirectionProperty facing;

    @SubscribeEvent
    public static void power (BlockEvent.NeighborNotifyEvent event){
        BlockState blockState = event.getState();
        BlockPos pos = event.getPos();
        Direction direction = blockState.get(facing);
        World world = (World) event.getWorld();
        Boolean power = world.isBlockPowered(pos);


        if (blockState.getBlock()== RegistryHandler.BLOCKBREAKERUNPOWERED_BLOCK.get().getBlock() && power){
            world.setBlockState(pos,RegistryHandler.BLOCKBREAKERPOWERED_BLOCK.get().getDefaultState().with(facing, direction));
        }

    }
}
*/