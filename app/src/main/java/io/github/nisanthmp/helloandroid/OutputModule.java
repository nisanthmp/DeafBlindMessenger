package io.github.nisanthmp.helloandroid;

import android.telephony.SmsManager;

import java.lang.reflect.Array;
import java.util.HashMap;
import java.util.Map;

public class OutputModule {
    Object[] outputBrailleByteArray;
    String[] charStringsArray;
    Map<Byte, String> brailleByteToChar;
    public static String messageString;
    public void setOutputBrailleByteArray(Object[] array) {
        outputBrailleByteArray = array;
    }

    public void sendMessage() {
        convertFromBytesToString();
        SmsManager smsManager = SmsManager.getDefault();
        smsManager.sendTextMessage("8547071009", null, messageString, null, null);
    }

    private void convertFromBytesToString() {
        charStringsArray = new String[outputBrailleByteArray.length];
        messageString = "";
        for (int i = 0; i < outputBrailleByteArray.length; i++) {
            messageString += brailleByteToChar.get((Byte)outputBrailleByteArray[i]);
        }

    }
    public OutputModule() {
        brailleByteToChar = new HashMap<Byte, String>();
        brailleByteToChar.put((byte)(0b00100000), "A");
        brailleByteToChar.put((byte)(0b00101000), "B");
        brailleByteToChar.put((byte)(0b00110000), "C");
        // done up to this. One key should have only one value.
        // To make it that way,
        // for the alphabet ones, keep only the whole capital letter ones.
/*
        brailleByteToChar.put("d", (byte)(0b00110100));
        brailleByteToChar.put("D", (byte)(0b00110100));
        brailleByteToChar.put("e", (byte)(0b00100100));
        brailleByteToChar.put("E", (byte)(0b00100100));
        brailleByteToChar.put("f", (byte)(0b00111000));
        brailleByteToChar.put("F", (byte)(0b00111000));
        brailleByteToChar.put("g", (byte)(0b00111100));
        brailleByteToChar.put("G", (byte)(0b00111100));
        brailleByteToChar.put("h", (byte)(0b00101100));
        brailleByteToChar.put("H", (byte)(0b00101100));
        brailleByteToChar.put("i", (byte)(0b00011000));
        brailleByteToChar.put("I", (byte)(0b00011000));
        brailleByteToChar.put("j", (byte)(0b00011100));
        brailleByteToChar.put("J", (byte)(0b00011100));
        brailleByteToChar.put("k", (byte)(0b00100010));
        brailleByteToChar.put("K", (byte)(0b00100010));
        brailleByteToChar.put("l", (byte)(0b00101010));
        brailleByteToChar.put("L", (byte)(0b00101010));
        brailleByteToChar.put("m", (byte)(0b00110010));
        brailleByteToChar.put("M", (byte)(0b00110010));
        brailleByteToChar.put("n", (byte)(0b00110110));
        brailleByteToChar.put("N", (byte)(0b00110110));
        brailleByteToChar.put("o", (byte)(0b00100110));
        brailleByteToChar.put("O", (byte)(0b00100110));
        brailleByteToChar.put("p", (byte)(0b00111010));
        brailleByteToChar.put("P", (byte)(0b00111010));
        brailleByteToChar.put("q", (byte)(0b00111110));
        brailleByteToChar.put("Q", (byte)(0b00111110));
        brailleByteToChar.put("r", (byte)(0b00101110));
        brailleByteToChar.put("R", (byte)(0b00101110));
        brailleByteToChar.put("s", (byte)(0b00011010));
        brailleByteToChar.put("S", (byte)(0b00011010));
        brailleByteToChar.put("t", (byte)(0b00011110));
        brailleByteToChar.put("T", (byte)(0b00011110));
        brailleByteToChar.put("u", (byte)(0b00100011));
        brailleByteToChar.put("U", (byte)(0b00100011));
        brailleByteToChar.put("v", (byte)(0b00101011));
        brailleByteToChar.put("V", (byte)(0b00101011));
        brailleByteToChar.put("w", (byte)(0b00011101));
        brailleByteToChar.put("W", (byte)(0b00011101));
        brailleByteToChar.put("x", (byte)(0b00110011));
        brailleByteToChar.put("X", (byte)(0b00110011));
        brailleByteToChar.put("y", (byte)(0b00110111));
        brailleByteToChar.put("Y", (byte)(0b00110111));
        brailleByteToChar.put("z", (byte)(0b00100111));
        brailleByteToChar.put("Z", (byte)(0b00100111));
        brailleByteToChar.put("ow", (byte)(0b00011001));
        brailleByteToChar.put("oW", (byte)(0b00011001));
        brailleByteToChar.put("Ow", (byte)(0b00011001));
        brailleByteToChar.put("OW", (byte)(0b00011001));
        brailleByteToChar.put("ou", (byte)(0b00101101));
        brailleByteToChar.put("oU", (byte)(0b00101101));
        brailleByteToChar.put("Ou", (byte)(0b00101101));
        brailleByteToChar.put("OU", (byte)(0b00101101));
        brailleByteToChar.put("er", (byte)(0b00111101));
        brailleByteToChar.put("eR", (byte)(0b00111101));
        brailleByteToChar.put("Er", (byte)(0b00111101));
        brailleByteToChar.put("ER", (byte)(0b00111101));
        //brailleByteToChar.put("", (byte)(0b00010100)); // currency prefix
        //brailleByteToChar.put("", (byte)(0b00010101)); // contraction
        brailleByteToChar.put(" ", (byte)(0b00000000)); // space
        brailleByteToChar.put("the", (byte)(0b00011011));
        brailleByteToChar.put("The", (byte)(0b00011011));
        brailleByteToChar.put("THE", (byte)(0b00011011));
        //brailleByteToChar.put("", (byte)(0b00000100)); // contraction
        //brailleByteToChar.put("", (byte)(0b00010111)); // number prefix
        brailleByteToChar.put("ed", (byte)(0b00111001));
        brailleByteToChar.put("eD", (byte)(0b00111001));
        brailleByteToChar.put("Ed", (byte)(0b00111001));
        brailleByteToChar.put("ED", (byte)(0b00111001));
        brailleByteToChar.put("sh", (byte)(0b00110001));
        brailleByteToChar.put("sH", (byte)(0b00110001));
        brailleByteToChar.put("Sh", (byte)(0b00110001));
        brailleByteToChar.put("SH", (byte)(0b00110001));
        brailleByteToChar.put("and", (byte)(0b00111011));
        brailleByteToChar.put("And", (byte)(0b00111011));
        brailleByteToChar.put("AND", (byte)(0b00111011));
        brailleByteToChar.put("\'", (byte)(0b00000010));
        brailleByteToChar.put("of", (byte)(0b00101111));
        brailleByteToChar.put("Of", (byte)(0b00101111));
        brailleByteToChar.put("OF", (byte)(0b00101111));
        brailleByteToChar.put("with", (byte)(0b00011111));
        brailleByteToChar.put("With", (byte)(0b00011111));
        brailleByteToChar.put("WITH", (byte)(0b00011111));
        brailleByteToChar.put("ch", (byte)(0b00100001));
        brailleByteToChar.put("cH", (byte)(0b00100001));
        brailleByteToChar.put("Ch", (byte)(0b00100001));
        brailleByteToChar.put("CH", (byte)(0b00100001));
        brailleByteToChar.put("ing", (byte)(0b00010011));
        brailleByteToChar.put("Ing", (byte)(0b00010011));
        brailleByteToChar.put("ING", (byte)(0b00010011));
        //brailleByteToChar.put("", (byte)(0b00000001)); // uppercase prefix
        brailleByteToChar.put("-", (byte)(0b00000011));
        //brailleByteToChar.put("", (byte)(0b00010001)); // italic prefix
        brailleByteToChar.put("st", (byte)(0b00010010));
        brailleByteToChar.put("sT", (byte)(0b00010010));
        brailleByteToChar.put("St", (byte)(0b00010010));
        brailleByteToChar.put("ST", (byte)(0b00010010));
        brailleByteToChar.put("\"", (byte)(0b00000111));
        //brailleByteToChar.put("”", (byte)(0b00000111));
        brailleByteToChar.put(",", (byte)(0b00001000));
        brailleByteToChar.put(";", (byte)(0b00001010));
        brailleByteToChar.put(":", (byte)(0b00001100));
        brailleByteToChar.put(".", (byte)(0b00001101));
        brailleByteToChar.put("en", (byte)(0b00001001));
        brailleByteToChar.put("eN", (byte)(0b00001001));
        brailleByteToChar.put("En", (byte)(0b00001001));
        brailleByteToChar.put("EN", (byte)(0b00001001));
        brailleByteToChar.put("!", (byte)(0b00001110));
        brailleByteToChar.put("(", (byte)(0b00001111));
        brailleByteToChar.put(")", (byte)(0b00001111));
        brailleByteToChar.put("?", (byte)(0b00001011));
        //brailleByteToChar.put("“", (byte)(0b00001011));
        brailleByteToChar.put("in", (byte)(0b00000110));
        brailleByteToChar.put("iN", (byte)(0b00000110));
        brailleByteToChar.put("In", (byte)(0b00000110));
        brailleByteToChar.put("IN", (byte)(0b00000110));
        brailleByteToChar.put("wh", (byte)(0b00100101));
        brailleByteToChar.put("wH", (byte)(0b00100101));
        brailleByteToChar.put("Wh", (byte)(0b00100101));
        brailleByteToChar.put("WH", (byte)(0b00100101));
        //brailleByteToChar.put("", (byte)(0b00000101)); // letter prefix
        brailleByteToChar.put("gh", (byte)(0b00101001));
        brailleByteToChar.put("gH", (byte)(0b00101001));
        brailleByteToChar.put("Gh", (byte)(0b00101001));
        brailleByteToChar.put("GH", (byte)(0b00101001));
        brailleByteToChar.put("for", (byte)(0b00111111));
        brailleByteToChar.put("For", (byte)(0b00111111));
        brailleByteToChar.put("FOR", (byte)(0b00111111));
        brailleByteToChar.put("ar", (byte)(0b00010110));
        brailleByteToChar.put("aR", (byte)(0b00010110));
        brailleByteToChar.put("Ar", (byte)(0b00010110));
        brailleByteToChar.put("AR", (byte)(0b00010110));
        brailleByteToChar.put("th", (byte)(0b00110101));
        brailleByteToChar.put("tH", (byte)(0b00110101));
        brailleByteToChar.put("Th", (byte)(0b00110101));
        brailleByteToChar.put("TH", (byte)(0b00110101));
        //brailleByteToChar.put("", (byte)(0b00010000)); //accent prefix
*/
    }

}
