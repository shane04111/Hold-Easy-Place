package com.shane.HoldEasyPlace.config;

import com.google.common.collect.ImmutableList;
import fi.dy.masa.malilib.config.options.ConfigHotkey;

import java.util.List;

public class HotkeyExtended {
    public static final ConfigHotkey HOLD_EASY_PLACE_TOGGLE = InitialHotkey("holdEasyPlaceToggle");

    public static final List<ConfigHotkey> EXTENDED_HOTKEY_LIST = ImmutableList.of(
            HOLD_EASY_PLACE_TOGGLE
    );

    private static ConfigHotkey InitialHotkey(String hotkey) {
        return new ConfigHotkey("holdeasyplace.hotkey." + hotkey, "", "holdeasyplace.hotkey." + hotkey + ".comment");
    }
}
