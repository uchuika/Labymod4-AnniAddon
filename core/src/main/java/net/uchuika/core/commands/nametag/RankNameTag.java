package net.uchuika.core.commands.nametag;

import net.labymod.api.client.component.Component;
import net.labymod.api.client.entity.LivingEntity;
import net.labymod.api.client.entity.player.Player;
import net.uchuika.core.AnniStatsAddon;
import net.uchuika.core.Utils.PlayerRankList;
import java.util.HashMap;
import java.util.Map;

public class RankNameTag extends ComponentAnniNameTag {

  public RankNameTag(AnniStatsAddon anniStatsAddon) {
    super(anniStatsAddon);
  }

  @Override
  protected Component component(LivingEntity entity) {
    //int health = (int) Math.ceil(entity.getHealth());
    //int maxHealth = (int) Math.ceil(entity.getMaximalHealth());
    Map<String, String> playerRankList = new HashMap<>();
    playerRankList = PlayerRankList.getPlayerRankList();

    Component returnComponent= Component.text("");

    if(entity instanceof Player){
      Player player = (Player) entity;
      String playerName = player.getName();

      if(!(playerRankList.get(playerName)==null)) {
        if (playerRankList.get(playerName).contains("Novice") || playerRankList.get(playerName).contains("Unranked")) {
          returnComponent = Component.text("§a" + playerRankList.get(playerName));
        }else if (playerRankList.get(playerName).contains("Silver")) {
          returnComponent = Component.text("§b" + playerRankList.get(playerName));
        }else if (playerRankList.get(playerName).contains("Gold")) {
          returnComponent = Component.text("§6" + playerRankList.get(playerName));
        }else if (playerRankList.get(playerName).contains("GrandMaster")) {
          returnComponent = Component.text("§4" + playerRankList.get(playerName));
        }else if (playerRankList.get(playerName).contains("Master")) {
          returnComponent = Component.text("§c" + playerRankList.get(playerName));
        }else if (playerRankList.get(playerName).contains("Annihilator")) {
          returnComponent = Component.text("§5" + playerRankList.get(playerName));
        } else{
          returnComponent = Component.text("" + playerRankList.get(playerName));
        }
      }
    }

    return returnComponent;
  }
}
