package com.directi.training.ocp.exercise_refactored;

public class ResourceAllocator
{
    public int allocate(Resource resource)
    {
        int resource = resource.findFreeSlot();
        resource.markBusySlot(resource);
        return resource;
    }

    public void free(Resource resource, int resourceId)
    {
        resource.markFreeSlot(resourceId);
    }
}