package utils;

import java.io.File;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class ExecutionManager {

    private static final String EXECUTION_ID = LocalDateTime.now()
            .format(
                    DateTimeFormatter.ofPattern(
                            "yyyyMMdd_HHmmss"));

    private ExecutionManager() {
    }

    public static String getExecutionFolder() {

        return "target"
                + File.separator
                + "execution_"
                + EXECUTION_ID;
    }

}