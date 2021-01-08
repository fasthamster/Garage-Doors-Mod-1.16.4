package com.iHamster.garage.blocks;

import com.mojang.blaze3d.matrix.MatrixStack;
import com.mojang.blaze3d.vertex.IVertexBuilder;
import net.minecraft.block.BlockState;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.BlockRendererDispatcher;
import net.minecraft.client.renderer.IRenderTypeBuffer;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.model.IBakedModel;
import net.minecraft.client.renderer.tileentity.TileEntityRenderer;
import net.minecraft.client.renderer.tileentity.TileEntityRendererDispatcher;
import net.minecraftforge.client.model.data.EmptyModelData;

import static com.iHamster.garage.util.RegistryHandler.WINDOW_TILE;

public class WindowTileEntityRenderer extends TileEntityRenderer <WindowTileEntity> {
    public WindowTileEntityRenderer(TileEntityRendererDispatcher rendererDispatcherIn) {
        super(rendererDispatcherIn);

    }

    @Override
    public void render(WindowTileEntity tileEntityIn, float partialTicks, MatrixStack matrixStackIn, IRenderTypeBuffer bufferIn, int combinedLightIn, int combinedOverlayIn) {
        BlockState state = WINDOW_TILE.get().getDefaultState();
        System.out.println("state " + state.toString());
        matrixStackIn.push();
        matrixStackIn.translate(0,2,0);
        BlockRendererDispatcher dispatcher = Minecraft.getInstance().getBlockRendererDispatcher();
        IBakedModel model = dispatcher.getModelForState(state);
        MatrixStack.Entry currentMatrix = matrixStackIn.getLast();

        float red = 5;
        float green = 5;
        float blue = 3;


        IVertexBuilder vertexBuffer = bufferIn.getBuffer(RenderType.getCutout());
        dispatcher.getBlockModelRenderer().renderModel(currentMatrix, vertexBuffer, state, model,
                red, green, blue, combinedLightIn, combinedOverlayIn, EmptyModelData.INSTANCE);

        matrixStackIn.pop();

    }


}

