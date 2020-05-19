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
        brailleByteToChar.put((byte)(0b00110100), "D");
        brailleByteToChar.put((byte)(0b00100100), "E");
        brailleByteToChar.put((byte)(0b00111000), "F");
        brailleByteToChar.put((byte)(0b00111100), "G");
        brailleByteToChar.put((byte)(0b00101100), "H");
        brailleByteToChar.put((byte)(0b00011000), "I");
        brailleByteToChar.put((byte)(0b00011100), "J");
        brailleByteToChar.put((byte)(0b00100010), "K");
        brailleByteToChar.put((byte)(0b00101010), "L");
        brailleByteToChar.put((byte)(0b00110010), "M");
        brailleByteToChar.put((byte)(0b00110110), "N");
        brailleByteToChar.put((byte)(0b00100110), "O");
        brailleByteToChar.put((byte)(0b00111010), "P");
        brailleByteToChar.put((byte)(0b00111110), "Q");
        brailleByteToChar.put((byte)(0b00101110), "R");
        brailleByteToChar.put((byte)(0b00011010), "S");
        brailleByteToChar.put((byte)(0b00011110), "T");
        brailleByteToChar.put((byte)(0b00100011), "U");
        brailleByteToChar.put((byte)(0b00101011), "V");
        brailleByteToChar.put((byte)(0b00011101), "W");
        brailleByteToChar.put((byte)(0b00110011), "X");
        brailleByteToChar.put((byte)(0b00110111), "Y");
        brailleByteToChar.put((byte)(0b00100111), "Z");
        brailleByteToChar.put((byte)(0b00011001), "OW");
        brailleByteToChar.put((byte)(0b00101101), "OU");
        brailleByteToChar.put((byte)(0b00111101), "ER");
        //brailleByteToChar.put("", (byte)(0b00010100)); // currency prefix
        //brailleByteToChar.put("", (byte)(0b00010101)); // contraction
        brailleByteToChar.put((byte)(0b00000000), " "); // space
        brailleByteToChar.put((byte)(0b00011011), "THE");
        //brailleByteToChar.put("", (byte)(0b00000100)); // contraction
        //brailleByteToChar.put("", (byte)(0b00010111)); // number prefix
        brailleByteToChar.put((byte)(0b00111001), "ED");
        brailleByteToChar.put((byte)(0b00110001), "SH");
        brailleByteToChar.put((byte)(0b00111011), "AND");
        brailleByteToChar.put((byte)(0b00000010), "\'");
        brailleByteToChar.put((byte)(0b00101111), "OF");
        brailleByteToChar.put((byte)(0b00011111), "WITH");
        brailleByteToChar.put((byte)(0b00100001), "CH");
        brailleByteToChar.put((byte)(0b00010011), "ING");
        //brailleByteToChar.put("", (byte)(0b00000001)); // uppercase prefix
        brailleByteToChar.put((byte)(0b00000011), "-");
        //brailleByteToChar.put("", (byte)(0b00010001)); // italic prefix
        brailleByteToChar.put((byte)(0b00010010), "ST");
        brailleByteToChar.put((byte)(0b00000111),"\"");
        brailleByteToChar.put((byte)(0b00001000), ",");
        brailleByteToChar.put((byte)(0b00001010), ";");
        brailleByteToChar.put((byte)(0b00001100), ":");
        brailleByteToChar.put((byte)(0b00001101), ".");
        brailleByteToChar.put((byte)(0b00001001), "EN");
        brailleByteToChar.put((byte)(0b00001110), "!");
        brailleByteToChar.put((byte)(0b00001111), "(");
        brailleByteToChar.put((byte)(0b00001011), "?");
        //brailleByteToChar.put("“", (byte)(0b00001011));
        brailleByteToChar.put((byte)(0b00000110), "IN");
        brailleByteToChar.put((byte)(0b00100101), "WH");
        //brailleByteToChar.put("", (byte)(0b00000101)); // letter prefix
        brailleByteToChar.put((byte)(0b00101001), "GH");
        brailleByteToChar.put((byte)(0b00111111), "FOR");
        brailleByteToChar.put((byte)(0b00010110), "AR");
        brailleByteToChar.put((byte)(0b00110101), "TH");
        //brailleByteToChar.put("", (byte)(0b00010000)); //accent prefix

    }

}
