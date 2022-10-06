package net.aaron2599.Mixin;

import net.aaron2599.Event.Events.EventScroll;
import net.aaron2599.Notice;
import net.minecraft.client.Mouse;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(Mouse.class)
public class MixinMouse {

    @Inject(method = "onMouseScroll", at = @At("HEAD"), cancellable = true)
    private void mouseScroll(long window, double horizontal, double vertical, CallbackInfo ci){
        EventScroll event = new EventScroll(vertical);
        Notice.EventBus.post(event);
        if(event.isCanceled()){
            ci.cancel();
        }
    }


}
