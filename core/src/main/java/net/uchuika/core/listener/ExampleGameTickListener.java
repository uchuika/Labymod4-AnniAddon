package net.uchuika.core.listener;

import net.labymod.api.event.Phase;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.lifecycle.GameTickEvent;
import net.uchuika.core.AnniStatsAddon;

public class ExampleGameTickListener {

  private final AnniStatsAddon addon;

  public ExampleGameTickListener(AnniStatsAddon addon) {
    this.addon = addon;
  }

  @Subscribe
  public void onGameTick(GameTickEvent event) {
    if (event.phase() != Phase.PRE) {
      return;
    }

    //this.addon.logger().info(this.addon.configuration().enabled().get() ? "enabled" : "disabled");
  }
}
