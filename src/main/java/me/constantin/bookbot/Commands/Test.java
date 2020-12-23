package me.constantin.bookbot.Commands;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class Test extends Base {

    public Test() {
        super("test", "test", "Cum");
    }

    @Override
    public void run(String[] args) {
        MinecraftClient.getInstance().player.sendMessage(Text.of("Cum"),false);
    }
}
