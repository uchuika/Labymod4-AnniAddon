package net.uchuika.core.commands.nametag;

import net.labymod.api.client.component.Component;
import net.labymod.api.client.entity.Entity;
import net.labymod.api.client.entity.LivingEntity;
import net.labymod.api.client.entity.player.tag.tags.NameTag;
import net.labymod.api.client.render.RenderPipeline;
import net.labymod.api.client.render.draw.ResourceRenderer;
import net.labymod.api.client.render.font.RenderableComponent;
import net.labymod.api.client.render.matrix.Stack;
import net.uchuika.core.AnniStatsAddon;

public abstract class ComponentAnniNameTag extends NameTag {

  private final RenderPipeline renderPipeline;
  private final ResourceRenderer resourceRenderer;
  private float startX;

  public ComponentAnniNameTag(AnniStatsAddon anniStatsAddon) {
    this.renderPipeline = anniStatsAddon.labyAPI().renderPipeline();
    this.resourceRenderer = this.renderPipeline.resourceRenderer();
  }

  @Override
  public void render(Stack stack, Entity entity) {
    super.render(stack, entity);
    RenderPipeline renderPipeline = this.renderPipeline;
    renderPipeline.renderNoneStandardNameTag(entity, () -> {
          LivingEntity livingEntity = (LivingEntity) entity;
        }
    );
  }

  @Override
  protected RenderableComponent getRenderableComponent() {
    if (!(this.entity instanceof LivingEntity) || this.entity.isCrouching()) {
      return null;
    }

    RenderableComponent renderableComponent = RenderableComponent.of(
        this.component((LivingEntity) this.entity)
    );

    this.startX = renderableComponent.getWidth() + 2;
    return renderableComponent;
  }

  @Override
  public float getWidth() {
    return super.getWidth() + 9;
  }

  @Override
  public float getScale() {
    return .7F;
  }

  @Override
  protected boolean withDepthTest() {
    return false;
  }

  protected abstract Component component(LivingEntity livingEntity);
}

