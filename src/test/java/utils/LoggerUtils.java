package utils;

import com.aventstack.extentreports.ExtentTest;

public class LoggerUtils {

        private LoggerUtils() {
        }

        public static void info(
                        ExtentTest test,
                        String mensagem) {

                if (test != null) {
                        test.info(mensagem);
                }

                System.out.println(
                                "[INFO] " + mensagem);
        }

        public static void sucesso(
                        ExtentTest test,
                        String mensagem) {

                if (test != null) {
                        test.pass(mensagem);
                }

                System.out.println(
                                "[SUCESSO] " + mensagem);
        }

        public static void erro(
                        ExtentTest test,
                        String mensagem) {

                if (test != null) {
                        test.fail(mensagem);
                }

                System.out.println(
                                "[ERRO] " + mensagem);
        }

}