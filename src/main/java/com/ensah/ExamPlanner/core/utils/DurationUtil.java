package com.ensah.ExamPlanner.core.utils;

import java.time.Duration;

public class DurationUtil {

    public static Duration convertToDuration(float hours) {
        int wholeHours = (int) hours;
        int minutes = Math.round((hours - wholeHours) * 60);
        return Duration.ofHours(wholeHours).plusMinutes(minutes);
    }

    public static float convertToFloat(Duration duration) {
        float hours = duration.toHours();
        float minutes = duration.toMinutes() - (hours * 60);
        return hours + minutes / 60;
    }
}
