package net.aaron2599.Mixin;

import net.aaron2599.Event.Events.EventKey;
import net.aaron2599.Notice;
import net.aaron2599.Utils.Globals;
import net.minecraft.client.Keyboard;
import org.lwjgl.glfw.GLFW;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Keyboard.class)
public class MixinKeyboard implements Globals {

    @Inject(method = "onKey", at = @At("HEAD"), cancellable = true)
    private void onKey(long window, int key, int scancode, int action, int modifiers, CallbackInfo ci){
        if(mc.currentScreen == null && key != GLFW.GLFW_KEY_UNKNOWN) {
            if(action == GLFW.GLFW_PRESS) Notice.Modules.handleKeyPress(key);
            if(action == GLFW.GLFW_RELEASE) Notice.Modules.handleKeyRelease(key);
            EventKey event = new EventKey(key, action);
            Notice.EventBus.post(event);
            if(event.isCanceled()){
                ci.cancel();
            }
        }
    }

}
