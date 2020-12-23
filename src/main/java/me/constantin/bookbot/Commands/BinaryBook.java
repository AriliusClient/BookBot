package me.constantin.bookbot.Commands;

import net.minecraft.client.MinecraftClient;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.text.Text;

import java.util.Random;

public class BinaryBook extends Base{
    public BinaryBook() {
        super("binarybook","binarybook (boundary: Integer)","Generates a block with completely random data.");
    }

    @Override
    public void run(String[] args) {
        int boundary = 256;
        String boundaryI = "";
        if (args.length > 1) {
            boundaryI = args[1];
            try {
                boundary = Integer.parseInt(boundaryI);
            } catch (Exception exc) {}
        }
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
                String crt = ((char) (rnd.nextInt(boundary))+"");
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
        super.run(args);
    }
}
