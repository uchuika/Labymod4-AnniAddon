package net.uchuika.core.listener;

import net.labymod.api.Laby;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.chat.ActionBarReceiveEvent;
import net.uchuika.core.AnniPlayerData;
import net.uchuika.core.AnniStatsAddon;

public class NewAnniActionBarListener {

  private final AnniStatsAddon addon;

  public NewAnniActionBarListener(AnniStatsAddon addon){
    this.addon = addon;
  }

  @Subscribe
  public void onActionBar(ActionBarReceiveEvent event) {
    String ActionBarMessage = event.message().toString();

    int Beginindex = ActionBarMessage.indexOf("literal");
    int EndIndex = ActionBarMessage.indexOf("}[style");
    String message = ActionBarMessage.substring(Beginindex+8, EndIndex);

    //System.out.println(ActionBarMessage);
    //System.out.println("Beginindex is:" + Beginindex);
   // System.out.println("EndIndex is:" + EndIndex);
    System.out.println("ActionBar message is:" + message);

    String[] split = message.split(" ");

    //Nexusカウンター
    if(split.length>=7){
      if(split[6].equals("nexus!")){
        String user = split[0];
        AnniPlayerData.NexusTemp++;

        if(user.contains(Laby.labyAPI().minecraft().getClientPlayer().getName())){
          if(AnniPlayerData.NexusTemp % 2 == 0){
            AnniPlayerData.nexus++;
          }
        }
      }
    }
  }
}
