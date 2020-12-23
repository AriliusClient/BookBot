package me.constantin.bookbot.mixin;

import me.constantin.bookbot.Commands.Base;
import me.constantin.bookbot.GlobalProvider;
import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(ClientPlayerEntity.class)
public class ChatController {
    @Inject(at = @At("HEAD"), method = "sendChatMessage", cancellable = true)
    public void sendChatMessage(String msg, CallbackInfo cbi) {
        if (msg.toLowerCase().startsWith("@bb")) {
            cbi.cancel();
            String[] args = msg.substring(3).trim().split(" +");
            String command = args[0].toLowerCase();
            Base cmd = GlobalProvider.commandManager.getByName(command);
            cmd.run(args);
        }
    }
}
