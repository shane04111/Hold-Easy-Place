package com.shane.HoldEasyPlace.mixin;

import com.shane.HoldEasyPlace.config.ConfigExtend;
import com.shane.HoldEasyPlace.config.HotkeyExtended;
import fi.dy.masa.litematica.event.KeyCallbacks;
import fi.dy.masa.litematica.util.SchematicWorldRefresher;
import fi.dy.masa.malilib.hotkeys.KeyCallbackToggleBooleanConfigWithMessage;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Pseudo
@Mixin(value = KeyCallbacks.class, remap = false)
public class MixinKeyCallbacks {
    @Inject(method = "init", at = @At("RETURN"))
    private static void init(CallbackInfo ci) {
        HotkeyExtended.HOLD_EASY_PLACE_TOGGLE.getKeybind().setCallback(new KeyCallbackToggleBooleanConfigWithMessage(ConfigExtend.Generic.HOLD_EASY_PLACE));
        ConfigExtend.Generic.HOLD_EASY_PLACE.setValueChangeCallback((config) -> SchematicWorldRefresher.INSTANCE.updateAll());
    }
}