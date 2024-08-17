package com.shane.HoldEasyPlace.mixin;

import com.google.common.collect.ImmutableList;
import com.shane.HoldEasyPlace.config.ConfigExtend;
import fi.dy.masa.litematica.config.Configs;
import fi.dy.masa.malilib.config.IConfigBase;
import org.spongepowered.asm.mixin.Final;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Pseudo;
import org.spongepowered.asm.mixin.Shadow;

@Pseudo
@Mixin(value = Configs.Generic.class, remap = false)
public class MixinGenericConfigs {
    @Final
    @Shadow
    public static ImmutableList<IConfigBase> OPTIONS = new ImmutableList.Builder<IConfigBase>().addAll(ConfigExtend.Generic.EXTENDED_OPTIONS).addAll(Configs.Generic.OPTIONS).build();
}
