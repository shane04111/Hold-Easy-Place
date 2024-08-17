/*
 * MIT License
 *
 * Copyright (c) 2024 Fallen_Breath
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */

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