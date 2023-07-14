package net.uchuika.core.commands;

import net.labymod.api.Laby;
import net.labymod.api.client.chat.command.Command;
import net.labymod.api.client.component.Component;
import net.labymod.api.client.component.format.NamedTextColor;
import net.labymod.api.notification.NotificationController;
import net.uchuika.core.AnniPlayerData;

public class resetNexusCounterCommand extends Command {
  private final NotificationController notificationController;

  public resetNexusCounterCommand() {
    super("resetnexus");
    this.notificationController = Laby.references().notificationController();
  }

  @Override
  public boolean execute(String prefix, String[] arguments) {
    AnniPlayerData.nexus = 0;
    this.displayMessage(Component.text("resetnexus!!!!!!", NamedTextColor.AQUA));
    return true;
  }
}
