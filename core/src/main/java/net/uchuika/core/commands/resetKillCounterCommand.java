package net.uchuika.core.commands;

import net.labymod.api.Laby;
import net.labymod.api.client.chat.command.Command;
import net.labymod.api.client.component.Component;
import net.labymod.api.client.component.format.NamedTextColor;
import net.labymod.api.notification.NotificationController;
import net.uchuika.core.AnniPlayerData;
import java.awt.*;

public class resetKillCounterCommand extends Command {
  private final NotificationController notificationController;

  public resetKillCounterCommand() {
    super("resetkills");
    this.notificationController = Laby.references().notificationController();
  }

  @Override
  public boolean execute(String prefix, String[] arguments) {
    AnniPlayerData.meleekillCount = 0;
    AnniPlayerData.activekillCount = 0;
    this.displayMessage(Component.text("resetKills", NamedTextColor.AQUA));
    return true;
  }
}
