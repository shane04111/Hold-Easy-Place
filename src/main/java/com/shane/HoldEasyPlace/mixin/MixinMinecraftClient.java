package com.shane.HoldEasyPlace.mixin;

import com.shane.HoldEasyPlace.config.ConfigExtend;
import fi.dy.masa.litematica.config.Configs;
import fi.dy.masa.litematica.util.WorldUtils;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.gui.screen.Screen;
import org.jetbrains.annotations.Nullable;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(MinecraftClient.class)
public class MixinMinecraftClient {
    @Shadow
    @Nullable
    public Screen currentScreen;

    @Inject(method = "tick", at = @At("HEAD"))
    private void onHoldEasyPlace(CallbackInfo ci) {
        MinecraftClient mc = (MinecraftClient) (Object) this;
        boolean onHoldEasyPlace = ConfigExtend.Generic.HOLD_EASY_PLACE.getBooleanValue() && Configs.Generic.EASY_PLACE_MODE.getBooleanValue();
        if (this.currentScreen == null && mc.player != null && onHoldEasyPlace) {
            WorldUtils.handleEasyPlace(mc);
        }
    }
}
