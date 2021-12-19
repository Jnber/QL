package com.directi.training.dip.exercise_refactored;

public class BufferWriter implements IWriter
{
    @Override
    public void write(String input)
    {
        MyDatabase database = new MyDatabase();
        database.write(input);
    }
}