package ua.nanit.limbo.protocol.packets.play;

import net.kyori.adventure.nbt.CompoundBinaryTag;
import net.kyori.adventure.nbt.TagStringIO;
import ua.nanit.limbo.protocol.ByteMessage;
import ua.nanit.limbo.protocol.PacketOut;
import ua.nanit.limbo.protocol.registry.Version;


public class PacketSetContainerSlot implements PacketOut {
    private byte windowID = 0;
    private int stateId = 0;
    private int slot = 0;

    public PacketSetContainerSlot() {}

    public PacketSetContainerSlot(int slot) {
        this.slot = slot;
    }

    @Override
    public void encode(ByteMessage msg, Version version) {
        if (version.moreOrEqual(Version.V1_18)) {
            msg.writeByte(0);
            msg.writeVarInt(0);
            msg.writeShort(slot);
            msg.writeBoolean(true);
            msg.writeVarInt(1);
            msg.writeByte(1);
            try {
                TagStringIO build = TagStringIO.builder().build();
                CompoundBinaryTag compound = build.asCompound("{display:{Name:'[{\"text\":\"点击返回大厅\",\"color\":\"green\",\"bold\":false,\"italic\":false,\"underlined\":false,\"strikethrough\":false,\"obfuscated\":false}]'}}");
                msg.writeCompoundTag(compound);
            } catch (Exception e) {
            }
        }
    }

    public int incrementStateId() {
        this.stateId = this.stateId + 1 & 32767;
        System.out.println(this.stateId);
        return this.stateId;
    }
}
