package net.uchuika.core.HudWidget;

import net.labymod.api.client.gui.hud.binding.category.HudWidgetCategory;
import net.labymod.api.client.gui.hud.hudwidget.text.TextHudWidget;
import net.labymod.api.client.gui.hud.hudwidget.text.TextHudWidgetConfig;
import net.labymod.api.client.gui.hud.hudwidget.text.TextLine;
import net.labymod.api.client.gui.icon.Icon;
import net.labymod.api.client.resources.ResourceLocation;
import net.uchuika.core.AnniPlayerData;

public class AnniActiveKillHudWidget extends TextHudWidget<TextHudWidgetConfig> {
    private TextLine totalkillline;

    private ResourceLocation resourceLocation = ResourceLocation.create("minecraft", "textures/item/diamond_sword.png");
    private Icon activekillhudIcon = Icon.texture(resourceLocation);

    public AnniActiveKillHudWidget() {
      super("activekillWidget");

      this.bindCategory(HudWidgetCategory.INGAME);
    }
    public void load(TextHudWidgetConfig config) {
      super.load(config);
      this.totalkillline = super.createLine("ActiveKill", 0);

      this.setIcon(activekillhudIcon);
    }

    public void onTick() {
      this.totalkillline.updateAndFlush(""+AnniPlayerData.activekillCount);
    }
}
