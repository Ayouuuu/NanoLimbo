package com.ayou;

import net.kyori.adventure.nbt.CompoundBinaryTag;
import org.junit.jupiter.api.Test;
import ua.nanit.limbo.util.CodecUtil;

import java.io.IOException;

public class SetSloTest {

    @Test
    public void nbtbinary() throws IOException {
        CompoundBinaryTag tag = CodecUtil.readCodecFile("/itemstack/diamond_sword.snbt");
        System.out.println(tag);
    }
}
