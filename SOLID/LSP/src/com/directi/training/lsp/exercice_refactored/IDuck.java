package com.directi.training.lsp.exercise_refactored;

public interface IDuck
{
    public void quack() throw DException;
    
    public void swim() throw DException;

    class DException (){
        println("Doesn't work");
    }

}