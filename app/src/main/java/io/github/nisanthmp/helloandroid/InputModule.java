package io.github.nisanthmp.helloandroid;

public class InputModule {
    int charIdx = 0;
    byte[] inputChars = {0b00101100, 0b00100110, 0b00011101, 0b00000000, 0b00100000, 0b00101110,
                         0b00100100, 0b00000000, 0b00110111, 0b00100110, 0b00100011, 0b00001011};
    public byte getNextChar() {
        if (charIdx < inputChars.length) return inputChars[charIdx ++];
        return 0;
    }
    public boolean isThereNextChar() {
        return charIdx < inputChars.length;
    }
}
