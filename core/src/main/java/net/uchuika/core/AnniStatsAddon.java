package net.uchuika.core;

import net.labymod.api.addon.LabyAddon;
import net.labymod.api.client.gui.hud.HudWidgetRegistry;
import net.labymod.api.models.addon.annotation.AddonMain;
import net.uchuika.core.HudWidget.AnniActiveKillHudWidget;
import net.uchuika.core.HudWidget.AnniNexusHudWidget;
import net.uchuika.core.HudWidget.AnniTotalKillHudWidget;
import net.uchuika.core.commands.ExamplePingCommand;
import net.uchuika.core.commands.resetKillCounterCommand;
import net.uchuika.core.commands.resetNexusCounterCommand;
import net.uchuika.core.generated.DefaultReferenceStorage;
import net.uchuika.core.listener.AnniGameTickListener;
import net.uchuika.core.listener.AnniMessageReciveListener;
import net.uchuika.core.listener.NewAnniActionBarListener;

@AddonMain
public class AnniStatsAddon extends LabyAddon<AnniAddonConfiguration> {

  private static AnniStatsAddon instance;

  public static DefaultReferenceStorage defaultReferenceStorage;

  public static String Actionbar = "null";

  @Override
  protected void enable() {
    this.registerSettingCategory();

    instance = this;

    AnniPlayerData.meleekillCount = 0;
    AnniPlayerData.activekillCount = 0;
    AnniPlayerData.nexus = 0;

    /*Actionbar */

     /*.anniActionbarListener()*/
    defaultReferenceStorage = ((DefaultReferenceStorage) this.referenceStorageAccessor());

    HudWidgetRegistry registry = this.labyAPI().hudWidgetRegistry();
    registry.register(new AnniTotalKillHudWidget());
    registry.register(new AnniActiveKillHudWidget());
    registry.register(new AnniNexusHudWidget());

    this.registerListener(new AnniGameTickListener(this));
    this.registerListener(new AnniMessageReciveListener(this));
    this.registerListener(new NewAnniActionBarListener(this));

    this.registerCommand(new resetNexusCounterCommand());
    this.registerCommand(new resetKillCounterCommand());
    this.registerCommand(new ExamplePingCommand());

    this.logger().info("Enabled the Addon");
  }



  public static String getActionbar(){
    Actionbar = String.valueOf(defaultReferenceStorage.anniActionbarListener().getActionbar());
    return Actionbar;
  }



  @Override
  protected Class<AnniAddonConfiguration> configurationClass() {
    return AnniAddonConfiguration.class;
  }

  public static AnniStatsAddon get() {
    return instance;
  }
}
