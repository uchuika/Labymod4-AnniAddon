package net.uchuika.core.listener;

import com.google.gson.internal.reflect.ReflectionAccessor;
import net.labymod.api.Laby;
import net.labymod.api.client.Minecraft;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.chat.ChatMessageSendEvent;
import net.labymod.api.event.client.chat.ChatMessageUpdateEvent;
import net.labymod.api.event.client.chat.ChatReceiveEvent;
import net.labymod.api.util.reflection.Reflection;
import net.uchuika.core.AnniPlayerData;
import net.uchuika.core.AnniStatsAddon;
import net.uchuika.core.Utils.PlayerRankList;
import javax.swing.*;

public class AnniMessageReciveListener {

  private final AnniStatsAddon addon;

  private static String rankPlayerName = null;

  public AnniMessageReciveListener(AnniStatsAddon addon) {
    this.addon = addon;
  }

  @Subscribe
  public void onChat(ChatReceiveEvent event) {
    String chat = event.chatMessage().getPlainText();
    //String ActionBar = AnniStatsAddon.getActionbar();

   // System.out.println("ActionBar is:" + ActionBar);
    System.out.println("chatis:" + chat);
    onReceiveChat(chat);
  }

  public static void onReceiveChat(String chat) {
    String[] split = chat.split((" "));

    if(split.length>=3){
      if(split[1].contains("Rank")){
        rankPlayerName = split[4];
      }

      if(split[0].contains("Current")){       //Current rank: GrandMaster-I
        if(split[1].contains("rank")){
          String rank = split[2];
          PlayerRankList.setPlayerRankList(rankPlayerName, rank);
        }
      }
    }

    if(split.length>=3&&chat.contains("killed") || chat.contains("shot")) {
      String killer=split[0].substring(0, split[0].length()-5);

      //"killed"と"shot"の場合のkillカウント
      if(killer.contains(Laby.labyAPI().minecraft().getClientPlayer().getName())) {
        if(split.length>=4) {
          String addinfo = split[3];
          if(addinfo.contains("attacking")){
            AnniPlayerData.meleekillCount++;
            AnniPlayerData.activekillCount++;
           //AnniStatsAddon.get().labyAPI().minecraft().chatExecutor().displayClientMessage("Attacking kill");
          }else if(addinfo.contains("defending")) {
            AnniPlayerData.meleekillCount++;
            AnniPlayerData.activekillCount++;
            //AnniStatsAddon.get().labyAPI().minecraft().chatExecutor().displayClientMessage("defending kill");
          }else if(addinfo.contains("in")) {
            AnniPlayerData.meleekillCount++;
            AnniPlayerData.activekillCount++;
            //AnniStatsAddon.get().labyAPI().minecraft().chatExecutor().displayClientMessage("in kill");
          }
        }else {
          //Minecraft.getInstance().player.sendMessage(new StringTextComponent("kill"), Util.DUMMY_UUID);
          //AnniStatsAddon.get().labyAPI().minecraft().chatExecutor().displayClientMessage("kill");

          AnniPlayerData.meleekillCount++;
          AnniPlayerData.activekillCount++;
        }
      }
    }
    if (chat.contains("Killing a recently re-spawned player doesn't count towards your Annihilation stats, rank points & Shotbow XP.") || chat.contains("Killing a recently re-spawned player doesn't count towards your Berserker health, Annihilation stats, rank points & Shotbow XP.")){
      AnniPlayerData.activekillCount--;
    }
  }
}
