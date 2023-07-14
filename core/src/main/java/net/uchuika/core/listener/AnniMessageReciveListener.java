package net.uchuika.core.listener;

import net.labymod.api.Laby;
import net.labymod.api.client.Minecraft;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.chat.ChatReceiveEvent;
import net.uchuika.core.AnniPlayerData;
import net.uchuika.core.AnniStatsAddon;

public class AnniMessageReciveListener {
  @Subscribe
  public void onChat(ChatReceiveEvent event) {
    String chat = event.chatMessage().component().toString();

    onReceiveChat(chat);
  }

  public static void onReceiveChat(String chat) {
    String[] split = chat.split((" "));

    //Nexusカウンター
    if(split.length>=7){
      if(split[6].equals("nexus!")){
        String user = split[0];
        if(user.contains(Laby.labyAPI().minecraft().getClientPlayer().getName())){
          AnniPlayerData.nexus++;
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
           AnniStatsAddon.get().labyAPI().minecraft().chatExecutor().displayClientMessage("Attacking kill");
          }else if(addinfo.contains("defending")) {
            AnniPlayerData.meleekillCount++;
            AnniPlayerData.activekillCount++;
            AnniStatsAddon.get().labyAPI().minecraft().chatExecutor().displayClientMessage("defending kill");
          }else if(addinfo.contains("in")) {
            AnniPlayerData.meleekillCount++;
            AnniPlayerData.activekillCount++;
            AnniStatsAddon.get().labyAPI().minecraft().chatExecutor().displayClientMessage("in kill");
          }
        }else {
          //Minecraft.getInstance().player.sendMessage(new StringTextComponent("kill"), Util.DUMMY_UUID);
          AnniStatsAddon.get().labyAPI().minecraft().chatExecutor().displayClientMessage("kill");

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
