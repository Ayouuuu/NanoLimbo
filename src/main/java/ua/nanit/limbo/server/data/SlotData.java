package ua.nanit.limbo.server.data;

import net.kyori.adventure.nbt.CompoundBinaryTag;

public class SlotData {
    private boolean present;
    private int itemId;
    private int itemCount;
    private CompoundBinaryTag nbtData;

    public SlotData() {
        nbtData = CompoundBinaryTag.builder().build();

    }

    public boolean isPresent() {
        return present;
    }

    public void setPresent(boolean present) {
        this.present = present;
    }

    public CompoundBinaryTag getNbtData() {
        return nbtData;
    }

    public void setNbtData(CompoundBinaryTag nbtData) {
        this.nbtData = nbtData;
    }
}
