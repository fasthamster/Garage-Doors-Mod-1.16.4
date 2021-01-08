package com.iHamster.garage.blocks;

import com.iHamster.garage.util.RegistryHandler;
import net.minecraft.block.BlockState;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.state.BooleanProperty;
import net.minecraft.state.DirectionProperty;
import net.minecraft.state.properties.BlockStateProperties;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityType;
import net.minecraft.util.Direction;

public class WindowTileEntity extends TileEntity {
    public static Direction direction;
    private static DirectionProperty facing = BlockStateProperties.HORIZONTAL_FACING;
    public static BooleanProperty isPowered =  BlockStateProperties.POWERED;

    public WindowTileEntity(TileEntityType<?> tileEntityTypeIn) {
        super(tileEntityTypeIn);
    }

    @Override
    public CompoundNBT getUpdateTag()
    {
        CompoundNBT nbtTagCompound = new CompoundNBT();
        write(nbtTagCompound);
        return nbtTagCompound;
    }

    /* Populates this TileEntity with information from the tag, used by vanilla to transmit from server to client
     */
    @Override
    public void handleUpdateTag(BlockState blockState, CompoundNBT parentNBTTagCompound)
    {
        this.read(blockState, parentNBTTagCompound);
    }

    public WindowTileEntity() {
        super(RegistryHandler.WINDOW_TILE_ENTITY.get());
    }
}
