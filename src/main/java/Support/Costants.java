package Support;

import java.util.Map;
import java.util.TreeMap;

public class Costants {

    public static String[] formats = new String[]{"flac", "dsf"};

    public static Map<String, Integer> bitDepths = new TreeMap<>() {{
        put("16bit", 16);
        put("24bit", 24);
        put("DSD", 1);
        put("Same as input", -1);
    }};

    public static Map<String, Integer> sampleRates = new TreeMap<>() {{
        put("44.1kHz", 44100);
        put("48kHz", 48000);
        put("88.2kHz", 88200);
        put("96kHz", 96000);
        put("176.4kHz", 176400);
        put("192kHz", 192000);
        put("352.8kHz", 352800);
        put("384kHz", 384000);
        put("705.6kHz", 705600);
        put("768kHz", 768000);
        put("DSD64", 2822400);
        put("DSD128", 5644800);
        put("DSD256", 11289600);
        put("DSD512", 22579200);
        put("Same as input", -1);
        put("NextSync", -2);
        put("MaxSync", -3);
    }};

    public static Map<String, String> convolutionFileFormats = new TreeMap<>() {{
        put("TEXT", "TEXT");
        put("BIN", "FLOAT32LE");
        put("DBL", "FLOAT64LE");
    }};
}
