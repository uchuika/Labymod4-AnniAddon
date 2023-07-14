package net.uchuika.core;

import net.labymod.api.addon.LabyAddon;
import net.labymod.api.client.gui.hud.HudWidgetRegistry;
import net.labymod.api.models.addon.annotation.AddonMain;
import net.uchuika.core.HudWidget.AnniActiveKillHudWidget;
import net.uchuika.core.HudWidget.AnniTotalKillHudWidget;
import net.uchuika.core.commands.ExamplePingCommand;
import net.uchuika.core.commands.resetKillCounterCommand;
import net.uchuika.core.listener.AnniMessageReciveListener;
import net.uchuika.core.listener.ExampleGameTickListener;

@AddonMain
public class AnniStatsAddon extends LabyAddon<AnniAddonConfiguration> {

  private static AnniStatsAddon instance;

  @Override
  protected void enable() {
    this.registerSettingCategory();

    instance = this;

    //AnniPlayerData.meleekillCount = 0;
    //AnniPlayerData.activekillCount = 0;
    //AnniPlayerData.nexus = 0;


    HudWidgetRegistry registry = this.labyAPI().hudWidgetRegistry();
    registry.register(new AnniTotalKillHudWidget());
    registry.register(new AnniActiveKillHudWidget());

    this.registerListener(new ExampleGameTickListener(this));
    this.registerListener(new AnniMessageReciveListener(this));

    this.registerCommand(new resetKillCounterCommand());
    this.registerCommand(new ExamplePingCommand());

    this.logger().info("Enabled the Addon");
  }

  @Override
  protected Class<AnniAddonConfiguration> configurationClass() {
    return AnniAddonConfiguration.class;
  }

  public static AnniStatsAddon get() {
    return instance;
  }
}
