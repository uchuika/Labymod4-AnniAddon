package net.uchuika.core.listener;

import net.labymod.api.event.Phase;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.lifecycle.GameTickEvent;
import net.uchuika.core.AnniStatsAddon;

public class AnniGameTickListener {

  private final AnniStatsAddon addon;


  public String ActionBar;

  public AnniGameTickListener(AnniStatsAddon addon) {
    this.addon = addon;
  }
  public String temp1ActionBar = "";
  public String temp2ActionBar = "";

  @Subscribe
  public void onGameTick(GameTickEvent event) {
    if (event.phase() != Phase.PRE) {
      return;
    }

    /*
    if(!(temp1ActionBar.equals(temp2ActionBar))){
      temp1ActionBar = temp2ActionBar;
    }else{
      temp2ActionBar
    }

     */
  }
}
