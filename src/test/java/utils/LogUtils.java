package utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LogUtils {

    private static final DateTimeFormatter FORMATO = DateTimeFormatter.ofPattern("HH:mm:ss");

    public static void info(String mensagem) {

        String horario = LocalDateTime.now().format(FORMATO);

        System.out.println(
                "[INFO] [" + horario + "] "
                        + mensagem);
    }

    public static void warn(String mensagem) {

        String horario = LocalDateTime.now().format(FORMATO);

        System.out.println(
                "[WARN] [" + horario + "] "
                        + mensagem);
    }

    public static void error(String mensagem) {

        String horario = LocalDateTime.now().format(FORMATO);

        System.out.println(
                "[ERROR] [" + horario + "] "
                        + mensagem);
    }
}