package utils;

import java.io.InputStream;

import com.fasterxml.jackson.databind.ObjectMapper;

import data.model.CartData;
import data.model.CheckoutData;
import data.model.LoginData;

public class JsonUtils {

    public static CheckoutData carregarCheckoutData() {

        try {

            InputStream inputStream = JsonUtils.class
                    .getClassLoader()
                    .getResourceAsStream(
                            "testdata/checkout.json");

            if (inputStream == null) {

                throw new RuntimeException(
                        "Arquivo checkout.json não encontrado");
            }

            ObjectMapper mapper = new ObjectMapper();

            return mapper.readValue(
                    inputStream,
                    CheckoutData.class);

        } catch (Exception e) {

            throw new RuntimeException(
                    "Erro ao carregar checkout.json",
                    e);
        }
    }

    public static LoginData carregarLoginData() {

        try {

            InputStream inputStream = JsonUtils.class
                    .getClassLoader()
                    .getResourceAsStream(
                            "testdata/login.json");

            if (inputStream == null) {

                throw new RuntimeException(
                        "Arquivo login.json não encontrado");
            }

            ObjectMapper mapper = new ObjectMapper();

            return mapper.readValue(
                    inputStream,
                    LoginData.class);

        } catch (Exception e) {

            throw new RuntimeException(
                    "Erro ao carregar login.json",
                    e);
        }
    }

    public static CartData carregarCartData() {
        try {

            InputStream inputStream = JsonUtils.class
                    .getClassLoader()
                    .getResourceAsStream(
                            "testdata/cart.json");

            if (inputStream == null) {

                throw new RuntimeException(
                        "Arquivo cart.json não encontrado");
            }

            ObjectMapper mapper = new ObjectMapper();

            return mapper.readValue(
                    inputStream,
                    CartData.class);

        } catch (Exception e) {

            throw new RuntimeException(
                    "Erro ao carregar cart.json",
                    e);
        }
    }
}