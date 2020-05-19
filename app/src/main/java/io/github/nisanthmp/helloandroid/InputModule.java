package io.github.nisanthmp.helloandroid;

import android.util.Log;

import java.util.HashMap;
import java.util.Map;

public class InputModule {
    int charIdx = 0;
    Map<String, Byte> charToBrailleByte;
    byte whiteSpace = 0b00000000;

    // HOW ARE YOU?
    byte[] inputChars = {0b00101100, 0b00100110, 0b00011101, 0b00000000, 0b00100000, 0b00101110,
                         0b00100100, 0b00000000, 0b00110111, 0b00100110, 0b00100011, 0b00001011};

    public static String inputString = "";

    public byte getNextChar() {
        //if (charIdx < inputChars.length) return inputChars[charIdx ++];
        if (charIdx < inputString.length()) {
            Byte brailleByte = charToBrailleByte.get(Character.toString(inputString.charAt(charIdx ++)));
            if (brailleByte == null) {
                return whiteSpace;
            } else {
                return brailleByte.byteValue();
            }
        }
        return 0;
    }

    public boolean isThereNextChar() {
        //return charIdx < inputChars.length;
        return charIdx < inputString.length();
    }

    public InputModule() {
        charToBrailleByte = new HashMap<String, Byte>();
        /* Braille script has to be understood better
        *  - Ways to represent numbers
        *  - Showing capital letters
        *  - Other prefixes etc*/
        charToBrailleByte.put("a", (byte)(0b00100000));
        charToBrailleByte.put("A", (byte)(0b00100000));
        charToBrailleByte.put("b", (byte)(0b00101000));
        charToBrailleByte.put("B", (byte)(0b00101000));
        charToBrailleByte.put("c", (byte)(0b00110000));
        charToBrailleByte.put("C", (byte)(0b00110000));
        charToBrailleByte.put("d", (byte)(0b00110100));
        charToBrailleByte.put("D", (byte)(0b00110100));
        charToBrailleByte.put("e", (byte)(0b00100100));
        charToBrailleByte.put("E", (byte)(0b00100100));
        charToBrailleByte.put("f", (byte)(0b00111000));
        charToBrailleByte.put("F", (byte)(0b00111000));
        charToBrailleByte.put("g", (byte)(0b00111100));
        charToBrailleByte.put("G", (byte)(0b00111100));
        charToBrailleByte.put("h", (byte)(0b00101100));
        charToBrailleByte.put("H", (byte)(0b00101100));
        charToBrailleByte.put("i", (byte)(0b00011000));
        charToBrailleByte.put("I", (byte)(0b00011000));
        charToBrailleByte.put("j", (byte)(0b00011100));
        charToBrailleByte.put("J", (byte)(0b00011100));
        charToBrailleByte.put("k", (byte)(0b00100010));
        charToBrailleByte.put("K", (byte)(0b00100010));
        charToBrailleByte.put("l", (byte)(0b00101010));
        charToBrailleByte.put("L", (byte)(0b00101010));
        charToBrailleByte.put("m", (byte)(0b00110010));
        charToBrailleByte.put("M", (byte)(0b00110010));
        charToBrailleByte.put("n", (byte)(0b00110110));
        charToBrailleByte.put("N", (byte)(0b00110110));
        charToBrailleByte.put("o", (byte)(0b00100110));
        charToBrailleByte.put("O", (byte)(0b00100110));
        charToBrailleByte.put("p", (byte)(0b00111010));
        charToBrailleByte.put("P", (byte)(0b00111010));
        charToBrailleByte.put("q", (byte)(0b00111110));
        charToBrailleByte.put("Q", (byte)(0b00111110));
        charToBrailleByte.put("r", (byte)(0b00101110));
        charToBrailleByte.put("R", (byte)(0b00101110));
        charToBrailleByte.put("s", (byte)(0b00011010));
        charToBrailleByte.put("S", (byte)(0b00011010));
        charToBrailleByte.put("t", (byte)(0b00011110));
        charToBrailleByte.put("T", (byte)(0b00011110));
        charToBrailleByte.put("u", (byte)(0b00100011));
        charToBrailleByte.put("U", (byte)(0b00100011));
        charToBrailleByte.put("v", (byte)(0b00101011));
        charToBrailleByte.put("V", (byte)(0b00101011));
        charToBrailleByte.put("w", (byte)(0b00011101));
        charToBrailleByte.put("W", (byte)(0b00011101));
        charToBrailleByte.put("x", (byte)(0b00110011));
        charToBrailleByte.put("X", (byte)(0b00110011));
        charToBrailleByte.put("y", (byte)(0b00110111));
        charToBrailleByte.put("Y", (byte)(0b00110111));
        charToBrailleByte.put("z", (byte)(0b00100111));
        charToBrailleByte.put("Z", (byte)(0b00100111));
        charToBrailleByte.put("ow", (byte)(0b00011001));
        charToBrailleByte.put("oW", (byte)(0b00011001));
        charToBrailleByte.put("Ow", (byte)(0b00011001));
        charToBrailleByte.put("OW", (byte)(0b00011001));
        charToBrailleByte.put("ou", (byte)(0b00101101));
        charToBrailleByte.put("oU", (byte)(0b00101101));
        charToBrailleByte.put("Ou", (byte)(0b00101101));
        charToBrailleByte.put("OU", (byte)(0b00101101));
        charToBrailleByte.put("er", (byte)(0b00111101));
        charToBrailleByte.put("eR", (byte)(0b00111101));
        charToBrailleByte.put("Er", (byte)(0b00111101));
        charToBrailleByte.put("ER", (byte)(0b00111101));
        //charToBrailleByte.put("", (byte)(0b00010100)); // currency prefix
        //charToBrailleByte.put("", (byte)(0b00010101)); // contraction
        charToBrailleByte.put(" ", (byte)(0b00000000)); // space
        charToBrailleByte.put("the", (byte)(0b00011011));
        charToBrailleByte.put("The", (byte)(0b00011011));
        charToBrailleByte.put("THE", (byte)(0b00011011));
        //charToBrailleByte.put("", (byte)(0b00000100)); // contraction
        //charToBrailleByte.put("", (byte)(0b00010111)); // number prefix
        charToBrailleByte.put("ed", (byte)(0b00111001));
        charToBrailleByte.put("eD", (byte)(0b00111001));
        charToBrailleByte.put("Ed", (byte)(0b00111001));
        charToBrailleByte.put("ED", (byte)(0b00111001));
        charToBrailleByte.put("sh", (byte)(0b00110001));
        charToBrailleByte.put("sH", (byte)(0b00110001));
        charToBrailleByte.put("Sh", (byte)(0b00110001));
        charToBrailleByte.put("SH", (byte)(0b00110001));
        charToBrailleByte.put("and", (byte)(0b00111011));
        charToBrailleByte.put("And", (byte)(0b00111011));
        charToBrailleByte.put("AND", (byte)(0b00111011));
        charToBrailleByte.put("\'", (byte)(0b00000010));
        charToBrailleByte.put("of", (byte)(0b00101111));
        charToBrailleByte.put("Of", (byte)(0b00101111));
        charToBrailleByte.put("OF", (byte)(0b00101111));
        charToBrailleByte.put("with", (byte)(0b00011111));
        charToBrailleByte.put("With", (byte)(0b00011111));
        charToBrailleByte.put("WITH", (byte)(0b00011111));
        charToBrailleByte.put("ch", (byte)(0b00100001));
        charToBrailleByte.put("cH", (byte)(0b00100001));
        charToBrailleByte.put("Ch", (byte)(0b00100001));
        charToBrailleByte.put("CH", (byte)(0b00100001));
        charToBrailleByte.put("ing", (byte)(0b00010011));
        charToBrailleByte.put("Ing", (byte)(0b00010011));
        charToBrailleByte.put("ING", (byte)(0b00010011));
        //charToBrailleByte.put("", (byte)(0b00000001)); // uppercase prefix
        charToBrailleByte.put("-", (byte)(0b00000011));
        //charToBrailleByte.put("", (byte)(0b00010001)); // italic prefix
        charToBrailleByte.put("st", (byte)(0b00010010));
        charToBrailleByte.put("sT", (byte)(0b00010010));
        charToBrailleByte.put("St", (byte)(0b00010010));
        charToBrailleByte.put("ST", (byte)(0b00010010));
        charToBrailleByte.put("\"", (byte)(0b00000111));
        //charToBrailleByte.put("”", (byte)(0b00000111));
        charToBrailleByte.put(",", (byte)(0b00001000));
        charToBrailleByte.put(";", (byte)(0b00001010));
        charToBrailleByte.put(":", (byte)(0b00001100));
        charToBrailleByte.put(".", (byte)(0b00001101));
        charToBrailleByte.put("en", (byte)(0b00001001));
        charToBrailleByte.put("eN", (byte)(0b00001001));
        charToBrailleByte.put("En", (byte)(0b00001001));
        charToBrailleByte.put("EN", (byte)(0b00001001));
        charToBrailleByte.put("!", (byte)(0b00001110));
        charToBrailleByte.put("(", (byte)(0b00001111));
        charToBrailleByte.put(")", (byte)(0b00001111));
        charToBrailleByte.put("?", (byte)(0b00001011));
        //charToBrailleByte.put("“", (byte)(0b00001011));
        charToBrailleByte.put("in", (byte)(0b00000110));
        charToBrailleByte.put("iN", (byte)(0b00000110));
        charToBrailleByte.put("In", (byte)(0b00000110));
        charToBrailleByte.put("IN", (byte)(0b00000110));
        charToBrailleByte.put("wh", (byte)(0b00100101));
        charToBrailleByte.put("wH", (byte)(0b00100101));
        charToBrailleByte.put("Wh", (byte)(0b00100101));
        charToBrailleByte.put("WH", (byte)(0b00100101));
        //charToBrailleByte.put("", (byte)(0b00000101)); // letter prefix
        charToBrailleByte.put("gh", (byte)(0b00101001));
        charToBrailleByte.put("gH", (byte)(0b00101001));
        charToBrailleByte.put("Gh", (byte)(0b00101001));
        charToBrailleByte.put("GH", (byte)(0b00101001));
        charToBrailleByte.put("for", (byte)(0b00111111));
        charToBrailleByte.put("For", (byte)(0b00111111));
        charToBrailleByte.put("FOR", (byte)(0b00111111));
        charToBrailleByte.put("ar", (byte)(0b00010110));
        charToBrailleByte.put("aR", (byte)(0b00010110));
        charToBrailleByte.put("Ar", (byte)(0b00010110));
        charToBrailleByte.put("AR", (byte)(0b00010110));
        charToBrailleByte.put("th", (byte)(0b00110101));
        charToBrailleByte.put("tH", (byte)(0b00110101));
        charToBrailleByte.put("Th", (byte)(0b00110101));
        charToBrailleByte.put("TH", (byte)(0b00110101));
        //charToBrailleByte.put("", (byte)(0b00010000)); //accent prefix
    }
}
