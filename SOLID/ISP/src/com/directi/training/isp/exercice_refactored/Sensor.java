package com.directi.training.isp.exercise_refactored;

import java.util.Random;

public class Sensor
{
    public void register(SensorClient sensorUser)
    {
        while (true) {
            if (isPersonClose()) {
                sensorUser.proximityCallback();
                break;
            }
        }
    }

    private boolean isPersonClose()
    {
        return new Random().nextBoolean();
    }
}