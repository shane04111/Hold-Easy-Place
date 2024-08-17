package com.shane.HoldEasyPlace.mixin;

import com.google.common.collect.ImmutableList;
import com.shane.HoldEasyPlace.config.HotkeyExtended;
import fi.dy.masa.litematica.config.Hotkeys;
import fi.dy.masa.malilib.config.options.ConfigHotkey;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.Shadow;

import java.util.List;

@Pseudo
@Mixin(value = Hotkeys.class, remap = false)
public class MixinHotkeys {
    @Final
    @Shadow
    public static List<ConfigHotkey> HOTKEY_LIST = new ImmutableList.Builder<ConfigHotkey>().addAll(HotkeyExtended.EXTENDED_HOTKEY_LIST).addAll(Hotkeys.HOTKEY_LIST).build();
}
