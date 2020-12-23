package me.constantin.bookbot.Commands;

import net.minecraft.client.MinecraftClient;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.*;
import net.minecraft.text.Text;

import java.util.Random;

public class AsciiBook extends Base {
    public AsciiBook() {
        super("asciibook","asciibook","Generates a book with random ascii chars");
    }

    @Override
    public void run(String[] args) {
        ItemStack stack = MinecraftClient.getInstance().player.inventory.getMainHandStack();
        if (Item.getRawId(stack.getItem()) != 825) {
            MinecraftClient.getInstance().player.sendMessage(Text.of("Man please hold a book and quill so this shit WORKS"),false);
            return;
        }
        //MinecraftClient.getInstance().player.sendMessage(Text.of(Item.getRawId(stack.getItem())+""),true);
        MinecraftClient.getInstance().player.sendMessage(Text.of("Writing book data..."),false);
        ListTag l = new net.minecraft.nbt.ListTag();
        for(int i = 0;i<100;i++) {
            String data = "";
            Random rnd = new Random();
            for(int n = 0;n<266;n++) {
                String crt = ((char) (rnd.nextInt(25)+97)+"");
                if (rnd.nextBoolean()) crt = crt.toUpperCase();
                data += crt;
            }
            l.add(StringTag.of(data));
        }
        CompoundTag tag = new CompoundTag();
        tag.put("pages",l);
        MinecraftClient.getInstance().player.sendMessage(Text.of("Setting book NBT..."),false);
        stack.setTag(tag);
        MinecraftClient.getInstance().player.sendMessage(Text.of("Done!"),false);
    }
}
