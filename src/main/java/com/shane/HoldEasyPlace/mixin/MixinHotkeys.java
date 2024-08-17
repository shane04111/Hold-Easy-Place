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
