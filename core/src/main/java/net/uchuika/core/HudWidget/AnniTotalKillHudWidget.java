package net.uchuika.core.HudWidget;

import net.labymod.api.Constants.NamedThemeResource;
import net.labymod.api.client.gfx.pipeline.material.Material;
import net.labymod.api.client.gfx.pipeline.material.SimpleMaterial;
import net.labymod.api.client.gui.hud.binding.category.HudWidgetCategory;
import net.labymod.api.client.gui.hud.hudwidget.text.TextHudWidget;
import net.labymod.api.client.gui.hud.hudwidget.text.TextHudWidgetConfig;
import net.labymod.api.client.gui.hud.hudwidget.text.TextLine;
import net.labymod.api.client.gui.icon.Icon;
import net.labymod.api.client.render.ItemStackRenderer;
import net.labymod.api.client.resources.ResourceLocation;
import net.labymod.api.client.resources.texture.TextureImage;
import net.uchuika.core.AnniPlayerData;

public class AnniTotalKillHudWidget extends TextHudWidget<TextHudWidgetConfig> {

  private TextLine totalkillline;

  private ResourceLocation resourceLocation = ResourceLocation.create("minecraft", "textures/item/iron_sword.png");
  private Icon totalkillhudIcon = Icon.texture(resourceLocation);

  public AnniTotalKillHudWidget() {
    super("totalkillWidget");

    this.bindCategory(HudWidgetCategory.INGAME);
  }

  public void load(TextHudWidgetConfig config) {
    super.load(config);
    this.totalkillline = super.createLine("TotalKill", 0);

    this.setIcon(totalkillhudIcon);
  }

  public void onTick() {
    this.totalkillline.updateAndFlush(""+AnniPlayerData.meleekillCount);
  }

}
