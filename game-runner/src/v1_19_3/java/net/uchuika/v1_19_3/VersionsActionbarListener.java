package net.uchuika.v1_19_3;


import com.mojang.datafixers.kinds.IdF.Mu;
import net.labymod.api.client.component.TextComponent;
import net.labymod.api.models.Implements;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;
import net.minecraft.network.chat.MutableComponent;
import net.uchuika.core.listener.AnniActionbarListener;
import org.w3c.dom.Text;
import javax.inject.Singleton;
import java.lang.reflect.Field;

@Singleton
@Implements(AnniActionbarListener.class)
public class VersionsActionbarListener implements AnniActionbarListener {


  @Override
  public String getActionbar() {
    try {
      ///title @s actionbar {"text":"some text"}
      //Class<?> sampleClass = Class.forName("net.minecraft.client.gui.Gui");
      Field f = Gui.class.getDeclaredField("overlayMessageString");
      f.setAccessible(true);
      MutableComponent act = (MutableComponent) f.get(Minecraft.getInstance().gui);
      if(!(act == null)){
        return act.getContents().toString();
      }
      return "null";
    } catch(Exception e) {
      e.printStackTrace();
    }
    return "null";
  }


}
