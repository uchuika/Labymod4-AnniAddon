package net.uchuika.core.listener;

import net.labymod.api.Laby;
import net.labymod.api.client.Minecraft;
import net.labymod.api.event.Subscribe;
import net.labymod.api.event.client.lifecycle.GameTickEvent;
import net.labymod.api.reference.annotation.Referenceable;
import net.labymod.api.util.reflection.Reflection;
import org.jetbrains.annotations.NotNull;

@Referenceable
public interface AnniActionbarListener {

  @NotNull String getActionbar();

}
