package ua.nanit.limbo.util;

import net.kyori.adventure.nbt.CompoundBinaryTag;
import net.kyori.adventure.nbt.TagStringIO;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.stream.Collectors;

public class CodecUtil {

    public static CompoundBinaryTag readCodecFile(String resPath) throws IOException {
        InputStream in = CodecUtil.class.getResourceAsStream(resPath);

        if (in == null)
            throw new FileNotFoundException("Cannot find dimension registry file");

        return TagStringIO.get().asCompound(streamToString(in));
    }

    private static String streamToString(InputStream in) throws IOException {
        InputStreamReader isReader = new InputStreamReader(in, StandardCharsets.UTF_8);
        BufferedReader bufReader = new BufferedReader(isReader);
        String content = bufReader.lines()
                .collect(Collectors.joining("\n"));

        isReader.close();
        bufReader.close();

        return content;
    }
}
