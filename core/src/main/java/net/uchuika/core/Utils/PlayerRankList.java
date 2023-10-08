package net.uchuika.core.Utils;

import net.labymod.api.Laby;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class PlayerRankList {
  private static Map<String, String> playerRankList = new HashMap<>();

  public static void setPlayerRankList(String playerName, String rank){

    playerRankList.put(playerName, rank);
    System.out.println("rank data put name:" + playerName + " rank:" + rank);
  }

  public static Map getPlayerRankList(){
    return playerRankList;
  }

}
