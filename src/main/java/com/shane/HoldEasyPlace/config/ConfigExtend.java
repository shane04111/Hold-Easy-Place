/*
 * MIT License
 *
 * Copyright (c) 2024 Shane0411
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

package com.shane.HoldEasyPlace.config;

import com.google.common.collect.ImmutableList;
import fi.dy.masa.malilib.config.IConfigBase;
import fi.dy.masa.malilib.config.options.ConfigBoolean;

public class ConfigExtend {
    public static class Generic {
        public static final ConfigBoolean HOLD_EASY_PLACE = InitialBoolean("holdEasyPlace", false);
        public static final ConfigBoolean DISABLE_HOLD_EASY_PLACE_FAIL_TIP = InitialBoolean("disableHoldEasyPlaceFailTip", true);
        public static final ConfigBoolean ALWAYS_DISABLE_FAIL_TIP = InitialBoolean("alwaysDisableFailTip", false);

        public static final ImmutableList<IConfigBase> EXTENDED_OPTIONS = ImmutableList.of(
                HOLD_EASY_PLACE,
                DISABLE_HOLD_EASY_PLACE_FAIL_TIP,
                ALWAYS_DISABLE_FAIL_TIP
        );

        private static ConfigBoolean InitialBoolean(String name, boolean defaultValue) {
            return new ConfigBoolean("holdeasyplace.generic." + name, defaultValue, "holdeasyplace.generic." + name + ".comment");
        }
    }
}
