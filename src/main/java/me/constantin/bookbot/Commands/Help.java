package me.constantin.bookbot.Commands;

import me.constantin.bookbot.GlobalProvider;
import net.minecraft.client.MinecraftClient;
import net.minecraft.text.LiteralText;
import net.minecraft.text.StringVisitable;
import net.minecraft.text.Text;

import java.awt.*;

public class Help extends Base {
    public Help() {
        super("help","help","Lists all commands");
    }

    @Override
    public void run(String[] args) {
        MinecraftClient.getInstance().player.sendMessage(Text.of("here are all commands you can use mf"),false);
        GlobalProvider.commandManager.get().forEach(base -> {
            MinecraftClient.getInstance().player.sendMessage(Text.of("  - "+base.name+": "+base.description),false);
        });
    }
}
