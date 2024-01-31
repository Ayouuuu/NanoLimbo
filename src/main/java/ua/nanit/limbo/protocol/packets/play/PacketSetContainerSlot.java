package ua.nanit.limbo.protocol.packets.play;

import ua.nanit.limbo.connection.ClientConnection;
import ua.nanit.limbo.protocol.ByteMessage;
import ua.nanit.limbo.protocol.PacketOut;
import ua.nanit.limbo.protocol.registry.Version;
import ua.nanit.limbo.server.LimboServer;
import ua.nanit.limbo.server.data.SlotData;

import java.util.Arrays;

public class PacketSetContainerSlot implements PacketOut {
    private byte windowID = 0;
    private int stateId = 0;
    private int slot = 36;


    @Override
    public void encode(ByteMessage msg, Version version) {
        if (version.moreOrEqual(Version.V1_18)) {
            msg.writeByte(0);
            msg.writeVarInt(0);
            msg.writeShort(slot);
            msg.writeBoolean(true);
            msg.writeVarInt(1);
            msg.writeByte(1);
            msg.writeCompoundTag(null);
        }
    }

    // [22, 0, 6, 0, 38, 1, 1, 7, 0]
    public int incrementStateId() {
        this.stateId = this.stateId + 1 & 32767;
        System.out.println(this.stateId);
        return this.stateId;
    }
}
