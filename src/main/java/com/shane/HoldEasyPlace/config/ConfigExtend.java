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
