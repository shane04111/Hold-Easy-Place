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
import fi.dy.masa.litematica.config.Configs;
import fi.dy.masa.litematica.data.DataManager;
import fi.dy.masa.litematica.tool.ToolMode;
import fi.dy.masa.litematica.util.WorldUtils;
import fi.dy.masa.malilib.gui.Message;
import fi.dy.masa.malilib.util.InfoUtils;
import fi.dy.masa.malilib.util.MessageOutputType;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.ActionResult;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfoReturnable;

@Mixin(value = WorldUtils.class, remap = false)
public class MixinWorldUtils {
    @Shadow
    private static ActionResult doEasyPlaceAction(MinecraftClient mc) {
        return null;
    }

    @Inject(method = "handleEasyPlace", at = @At(value = "HEAD"), cancellable = true)
    private static void onHandleEasyPlace(MinecraftClient mc, CallbackInfoReturnable<Boolean> cir) {
        if (Configs.Generic.EASY_PLACE_MODE.getBooleanValue() && DataManager.getToolMode() != ToolMode.REBUILD) {
            ActionResult result = doEasyPlaceAction(mc);
            boolean checkTip = (ConfigExtend.Generic.DISABLE_HOLD_EASY_PLACE_FAIL_TIP.getBooleanValue() && ConfigExtend.Generic.HOLD_EASY_PLACE.getBooleanValue()) || ConfigExtend.Generic.ALWAYS_DISABLE_FAIL_TIP.getBooleanValue();
            if (!checkTip && result == ActionResult.FAIL) {
                MessageOutputType type = (MessageOutputType) Configs.Generic.PLACEMENT_RESTRICTION_WARN.getOptionListValue();
                if (type == MessageOutputType.MESSAGE) {
                    InfoUtils.showGuiOrInGameMessage(Message.MessageType.WARNING, "litematica.message.easy_place_fail");
                } else if (type == MessageOutputType.ACTIONBAR) {
                    InfoUtils.printActionbarMessage("litematica.message.easy_place_fail");
                }
                cir.setReturnValue(true);
            } else {
                cir.setReturnValue(result != ActionResult.PASS);
            }
        } else {
            cir.setReturnValue(false);
        }
        cir.cancel();
    }
}
