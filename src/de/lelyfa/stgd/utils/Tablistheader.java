package de.lelyfa.stgd.utils;

import net.minecraft.server.v1_8_R3.IChatBaseComponent;
import net.minecraft.server.v1_8_R3.PacketPlayOutPlayerListHeaderFooter;
import net.minecraft.server.v1_8_R3.PlayerConnection;
import org.bukkit.craftbukkit.v1_8_R3.entity.CraftPlayer;
import org.bukkit.entity.Player;

import java.lang.reflect.Field;

public class Tablistheader {

    public static void send(String headerT, String footerT, Player... players) {

        Player[] arrayOfPlayer;

        int j = (arrayOfPlayer = players).length;
        for (int i = 0; i < j; i++) {
            Player p = arrayOfPlayer[i];

            CraftPlayer craftplayer = (CraftPlayer) p;

            PlayerConnection connection = craftplayer.getHandle().playerConnection;

            IChatBaseComponent header = IChatBaseComponent.ChatSerializer.a("{ text: \"" + headerT + "\"}");
            IChatBaseComponent footer = IChatBaseComponent.ChatSerializer.a("{ text: \"" + footerT + "\"}");

            PacketPlayOutPlayerListHeaderFooter packet = new PacketPlayOutPlayerListHeaderFooter();

            try {

                Field headerField = packet.getClass().getDeclaredField("a");

                headerField.setAccessible(true);
                headerField.set(packet, header);
                headerField.setAccessible(!headerField.isAccessible());

                Field footerField = packet.getClass().getDeclaredField("b");

                footerField.setAccessible(true);
                footerField.set(packet, footer);
                footerField.setAccessible(!footerField.isAccessible());

                connection.sendPacket(packet);

            } catch (Exception ex) {

                ex.printStackTrace();
            }

        }

    }

}