package me.constantin.bookbot.mixin;

import me.constantin.bookbot.GlobalProvider;
import net.minecraft.client.MinecraftClient;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.nbt.ListTag;
import net.minecraft.nbt.StringTag;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Mixin(net.minecraft.network.packet.c2s.play.BookUpdateC2SPacket.class)
public class BookUpdateC2SPacket {
    private static String dupeString;

    private static String dupeString2;

    static {
        for(int i = 0;i<256;i++) dupeString += "a";
        for(int i = 0;i<21845;i++) dupeString2 += (char) 2048;
    }
    @Shadow
    private ItemStack book;

    @Inject(at=@At("RETURN"),method="<init>(Lnet/minecraft/item/ItemStack;ZI)V")
    public void onInit(ItemStack book, boolean signed, int slot, CallbackInfo ci) {
        System.out.println("Called");
        System.out.println(book.getTag().get("pages").getType());
        if (signed && GlobalProvider.runNext) {
            GlobalProvider.runNext = false;
            ListTag listTag = new ListTag();
            listTag.add(0, StringTag.of(dupeString2));
            for(int i = 1;i<38;i++) {
                listTag.add(i,StringTag.of(dupeString));
            }

            this.book.putSubTag("pages",listTag);
        } else System.out.println("Bypassed");
    }
}
