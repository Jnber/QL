package com.directi.training.dip.exercise_refactored;

import java.io.IOException;

public class EncodingModuleClient
{
    public static void main(String[] args) throws IOException
    {
        EncodingModule encodingModule = new EncodingModule();

        IReader reader = new FileReader(
            "DIP/src/com/directi/training/dip/exercise_refactored/beforeEncryption.txt");
        IWriter writer = new FileWriter(
            "DIP/src/com/directi/training/dip/exercise_refactored/afterEncryption.txt");
        encodingModule.encode(reader, writer);

        reader = new BufferReader("http", "myfirstappwith.appspot.com", "/index.html");
        writer = new BufferWriter();
        encodingModule.encode(reader, writer);
    }
}