package net.uchuika.core.listener;

import net.labymod.api.Laby;
import net.labymod.api.addon.LabyAddon;
import net.labymod.api.client.Minecraft;
import net.labymod.api.client.component.Component;
import net.labymod.api.client.scoreboard.DisplaySlot;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.network.playerinfo.PlayerInfoUpdateEvent;
import net.labymod.api.event.client.render.PlayerNameTagRenderEvent;
import net.labymod.api.event.client.render.PlayerNameTagRenderEvent.Context;
import net.uchuika.core.AnniStatsAddon;
import net.uchuika.core.Utils.PlayerRankList;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ANNIPlayerListListener {

  private AnniStatsAddon addon;

  private static List<String> playerList = new ArrayList<String>();

  private static String PLayerNameString;

  private static String displayName;

  public ANNIPlayerListListener(AnniStatsAddon addon) {
    this.addon = addon;
  }

  @Subscribe
  public void onPlayer(PlayerNameTagRenderEvent e) {

    String[] split = null;

    String minecraftVersion = Laby.labyAPI().minecraft().getVersion();

    Map<String, String> playerRankList = new HashMap<>();
    playerRankList = PlayerRankList.getPlayerRankList();

    if (!(e.playerInfo() == null)) {
      split = e.playerInfo().displayName().toString().split((" "));
    }

    if (!(Laby.labyAPI().minecraft().getScoreboard().getObjective(DisplaySlot.SIDEBAR) == null)
        && Laby.labyAPI().minecraft().getScoreboard().getObjective(DisplaySlot.SIDEBAR).getTitle()
        .toString().contains("ANNI")) {


      if (!(e.playerInfo() == null)) {

        if(minecraftVersion.contains("1.16.5") || minecraftVersion.contains("1.17.1") || minecraftVersion.contains("1.18.2")){
          if(!(e.playerInfo().displayName().toString().contains("text=''"))) {
            PLayerNameString = e.playerInfo().displayName().toString();
            //System.out.println("nameString:" + PLayerNameString);

            int Beginindex = PLayerNameString.indexOf("ponent{text='");
            int EndIndex = PLayerNameString.indexOf("',");
            displayName = PLayerNameString.substring(Beginindex + 13, EndIndex);
          } else if (split.length >= 100) {

            PLayerNameString = split[65];
            //System.out.println("nameString:" + PLayerNameString);

            int Beginindex = PLayerNameString.indexOf("TextComponent{text='");
            int EndIndex = PLayerNameString.indexOf("',");
            displayName = PLayerNameString.substring(Beginindex + 20, EndIndex);
          }

        }else{
          if (!(e.playerInfo().displayName().toString().contains("empty["))) {
            PLayerNameString = e.playerInfo().displayName().toString();
            //System.out.println("nameString:" + PLayerNameString);

            int Beginindex = PLayerNameString.indexOf("literal{");
            int EndIndex = PLayerNameString.indexOf("}");
            displayName = PLayerNameString.substring(Beginindex + 8, EndIndex);
          } else if (split.length >= 7) {

            PLayerNameString = split[5];
            //System.out.println("nameString:" + PLayerNameString);

            int Beginindex = PLayerNameString.indexOf("literal{");
            int EndIndex = PLayerNameString.indexOf("}[");
            displayName = PLayerNameString.substring(Beginindex + 8, EndIndex);
          }
        }
      }

      if (!playerList.contains(displayName)) {
        if (displayName == null) {
          displayName = Laby.labyAPI().minecraft().getClientPlayer().getName();
        }

        String str1 = "/rank ";
        String testMessage = str1.concat(displayName);
        Laby.labyAPI().minecraft().chatExecutor().chat(testMessage);

        playerList.add(displayName);
      }
    }

    //System.out.println(Laby.labyAPI().minecraft().getVersion());
    /*

    if (!(e.playerInfo() == null)) {
      if (!(playerRankList.get(displayName) == null)) {

        //System.out.println(e.playerInfo().displayName().toString());
        if (!(e.context().equals(Context.TAB_LIST))) {

          if (!(e.playerInfo().displayName().toString().contains("empty["))) {
            String playerNameString = e.playerInfo().displayName().toString();
            int Beginindex = playerNameString.indexOf("literal{");
            int EndIndex = playerNameString.indexOf("}");
            String displayNameString = playerNameString.substring(Beginindex + 8, EndIndex);

            e.setNameTag(e.nameTag().append(Component.text(":" + playerRankList.get(displayNameString))));
          } else if (split.length >= 7) {
            String playerNameString = split[5];
            int Beginindex = playerNameString.indexOf("literal{");
            int EndIndex = playerNameString.indexOf("}[");
            String displayNameString = playerNameString.substring(Beginindex + 8, EndIndex);

            if(!(displayNameString==null)){
              if (playerRankList.get(displayNameString).contains("Novice") || playerRankList.get(displayNameString).contains("Unranked")) {
                e.setNameTag(e.nameTag().append(Component.text(":§a" + playerRankList.get(displayNameString))));
              }else if (playerRankList.get(displayNameString).contains("Silver")) {
                e.setNameTag(e.nameTag().append(Component.text(":§b" + playerRankList.get(displayNameString))));
              }else if (playerRankList.get(displayNameString).contains("Gold")) {
                e.setNameTag(e.nameTag().append(Component.text(":§6" + playerRankList.get(displayNameString))));
              }else if (playerRankList.get(displayNameString).contains("GrandMaster")) {
                e.setNameTag(e.nameTag().append(Component.text(":§4" + playerRankList.get(displayNameString))));
              }else if (playerRankList.get(displayNameString).contains("Master")) {
                e.setNameTag(e.nameTag().append(Component.text(":§c" + playerRankList.get(displayNameString))));
              }else if (playerRankList.get(displayNameString).contains("Annihilator")) {
                e.setNameTag(e.nameTag().append(Component.text(":§5" + playerRankList.get(displayNameString))));
              } else{
                e.setNameTag(e.nameTag().append(Component.text(":" + playerRankList.get(displayNameString))));
              }
            }
          }
        }
      }
    }

     */
  }
}
