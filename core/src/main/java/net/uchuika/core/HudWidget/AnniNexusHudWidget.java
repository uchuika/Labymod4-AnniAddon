package net.uchuika.core.HudWidget;

import net.labymod.api.client.gui.hud.binding.category.HudWidgetCategory;
import net.labymod.api.client.gui.hud.hudwidget.text.TextHudWidget;
import net.labymod.api.client.gui.hud.hudwidget.text.TextHudWidgetConfig;
import net.labymod.api.client.gui.hud.hudwidget.text.TextLine;
import net.labymod.api.client.gui.icon.Icon;
import net.labymod.api.client.resources.ResourceLocation;
import net.uchuika.core.AnniPlayerData;

public class AnniNexusHudWidget extends TextHudWidget<TextHudWidgetConfig> {

  private TextLine nexuscountline;

  private ResourceLocation resourceLocation = ResourceLocation.create("minecraft", "textures/block/end_stone.png");
  private Icon nexusCounthudIcon = Icon.texture(resourceLocation);

  public AnniNexusHudWidget() {
    super("NexusCountWidget");

    this.bindCategory(HudWidgetCategory.INGAME);
  }
  public void load(TextHudWidgetConfig config) {
    super.load(config);
    this.nexuscountline = super.createLine("Nexus", 0);

    this.setIcon(nexusCounthudIcon);
  }

  public void onTick() {
    this.nexuscountline.updateAndFlush(""+ AnniPlayerData.nexus);
  }

}
