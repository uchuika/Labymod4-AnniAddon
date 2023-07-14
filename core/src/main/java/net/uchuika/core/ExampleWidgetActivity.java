package net.uchuika.core;

import net.labymod.api.client.component.format.NamedTextColor;
import net.labymod.api.client.gui.screen.Parent;
import net.labymod.api.client.gui.screen.activity.AutoActivity;
import net.labymod.api.client.gui.screen.activity.types.SimpleActivity;
import net.labymod.api.client.gui.screen.widget.attributes.WidgetAlignment;
import net.labymod.api.client.gui.screen.widget.attributes.bounds.Bounds;
import net.labymod.api.client.gui.screen.widget.widgets.ComponentWidget;

@AutoActivity
public class ExampleWidgetActivity extends SimpleActivity {

  private ComponentWidget componentWidget;

  @Override
  public void initialize(Parent parent) {
    super.initialize(parent);

    this.componentWidget = ComponentWidget.text(
        "I am an example text rendered with a ComponentWidget",
        NamedTextColor.GOLD
    );
    this.document().addChild(this.componentWidget);
  }

  @Override
  protected void postStyleSheetLoad() {
    super.postStyleSheetLoad();

    Bounds activityBounds = this.bounds();
    /*
    Bounds widgetBounds = this.componentWidget.bounds();
    componentWidget.x.setPosition(
        activityBounds.getCenterX(),
        activityBounds.getCenterY()
    );

     */

    this.componentWidget.alignmentX().set(WidgetAlignment.CENTER);
    this.componentWidget.alignmentY().set(WidgetAlignment.CENTER);
  }
}