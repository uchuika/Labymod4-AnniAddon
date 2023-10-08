package net.uchuika.core.listener;

import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.render.overlay.IngameOverlayElementRenderEvent;
import net.labymod.api.event.client.render.overlay.IngameOverlayRenderEvent;
import net.labymod.api.event.client.scoreboard.ScoreboardObjectiveUpdateEvent;
import net.uchuika.core.AnniStatsAddon;

public class AnniScoreboardListener {

  private final AnniStatsAddon addon;

  public AnniScoreboardListener(AnniStatsAddon addon){
    this.addon = addon;
  }

  @Subscribe
  public void onScoreboard(IngameOverlayRenderEvent e){
    System.out.println("score Title" + e.isGuiHidden());
  }
}
