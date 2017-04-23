package com.matt.forgehax.mods;

import com.matt.forgehax.util.TickManager;
import com.matt.forgehax.util.draw.SurfaceUtils;
import com.matt.forgehax.util.Utils;
import net.minecraftforge.client.event.RenderGameOverlayEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class ActiveModListMod extends ToggleMod {
    public ActiveModListMod() {
        super("ActiveMods", false, "Shows list of all active mods");
        setHidden(true);
    }

    @SubscribeEvent
    public void onRenderScreen(RenderGameOverlayEvent.Text event) {
        int posX = 1;
        int posY = 1;
        SurfaceUtils.drawTextShadow(String.format("Tick-rate: %.2f", TickManager.getInstance().getData().getAverage()), posX, posY, Utils.Colors.WHITE);
        posY += SurfaceUtils.getTextHeight() + 1;
        for(BaseMod mod : MOD.mods.values()) {
            if(mod.isEnabled() && !mod.isHidden()) {
                SurfaceUtils.drawTextShadow(">" + mod.getDisplayText(), posX, posY, Utils.Colors.WHITE);
                posY += SurfaceUtils.getTextHeight() + 1;
            }
        }
        /*
        posY += (Render2DUtils.getTextHeight() + 1) * 2;
        Render2DUtils.drawTextShadow(String.format("Pitch: %.4f", MC.thePlayer.rotationPitch), posX, posY, Utils.toRGBA(255, 255, 255, 255));
        posY += Render2DUtils.getTextHeight() + 1;
        Render2DUtils.drawTextShadow(String.format("Yaw: %.4f", MC.thePlayer.rotationYaw), posX, posY, Utils.toRGBA(255, 255, 255, 255));*/
    }
}
