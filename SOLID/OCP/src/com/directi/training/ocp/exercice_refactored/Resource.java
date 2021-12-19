package com.directi.training.ocp.exercise_refactored;

public interface Resource
{
    int findFreeSlot();

    void markBusySlot(int resourceId);

    void markFreeSlot(int resourceId);
}
