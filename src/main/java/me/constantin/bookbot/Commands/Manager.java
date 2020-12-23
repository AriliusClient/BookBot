package me.constantin.bookbot.Commands;

import org.lwjgl.system.CallbackI;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

public class Manager {
    List<Base> commands = new ArrayList<>();
    public Manager() {
        commands.add(new Test());
        commands.add(new Help());
        commands.add(new AsciiBook());
        commands.add(new BinaryBook());
    }
    public List<Base> get() {
        return commands;
    }
    public Base getByName(String name) {
        AtomicReference<Base> ref = new AtomicReference<>(new CommandNotFound());
        this.commands.forEach(base -> {
            if (base.name.equalsIgnoreCase(name)) ref.set(base);
        });
        return ref.get();
    }
}
