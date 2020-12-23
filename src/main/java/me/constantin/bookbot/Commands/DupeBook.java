package me.constantin.bookbot.Commands;
import me.constantin.bookbot.GlobalProvider;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.ItemConvertible;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.item.WrittenBookItem;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import net.minecraft.network.packet.c2s.play.BookUpdateC2SPacket;

public class DupeBook extends Base{

    public DupeBook() {

        super("dupebook","dupebook","Generates a dupe book");

    }

    @Override
    public void run(String[] args) {
        GlobalProvider.runNext = true;
        ItemStack stack = new ItemStack(Items.WRITABLE_BOOK,1);
        ListTag p = new ListTag();
        p.add(0,StringTag.of("DUPE"));
        stack.putSubTag("pages",p);
        stack.putSubTag("title",StringTag.of("a"));
        MinecraftClient.getInstance().getNetworkHandler().sendPacket(new BookUpdateC2SPacket(stack,true,MinecraftClient.getInstance().player.inventory.selectedSlot));
        super.run(args);
    }
}
