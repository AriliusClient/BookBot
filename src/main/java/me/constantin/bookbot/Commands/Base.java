package me.constantin.bookbot.Commands;

import net.minecraft.client.MinecraftClient;
import net.minecraft.text.Text;

public class Base {
    public final String description;
    public final String name;
    final String syntax;
    public Base(String name, String syntax, String description) {
        this.name = name;
        this.syntax = syntax;
        this.description = description;
    }
    public final void PrintSyntaxError() {
        MinecraftClient.getInstance().player.sendMessage(Text.of("["+this.name+"] Invalid syntax.\n"+this.syntax),false);
    }
    public void run(String[] args) {

    }
}
