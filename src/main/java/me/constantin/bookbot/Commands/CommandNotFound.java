package me.constantin.bookbot.Commands;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class CommandNotFound extends Base {
    public CommandNotFound() {
        super("commandnotfound", "commandnotfound", "");
    }

    @Override
    public void run(String[] args) {
        MinecraftClient.getInstance().player.sendMessage(Text.of("Command not found. Please refer to the help command"), false);
    }
}
