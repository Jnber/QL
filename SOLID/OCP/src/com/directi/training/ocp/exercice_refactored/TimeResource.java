package com.directi.training.ocp.exercise_refactored;

public class TimeResource implements Resource
{
    @Override
    public int findFreeSlot(){return 0;}

    @Override
    public void markBusySlot(int resourceId){}

    @Override
    public void markFreeSlot(int resourceId){}
}