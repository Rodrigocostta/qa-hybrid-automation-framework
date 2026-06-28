package utils;

import java.io.InputStream;

import com.fasterxml.jackson.databind.ObjectMapper;

import data.model.CartData;
import data.model.CheckoutData;
import data.model.LoginData;

public class JsonUtils {

    private static final ObjectMapper mapper = new ObjectMapper();

    private JsonUtils() {
    }

    /**
     * Método genérico responsável por carregar qualquer arquivo JSON.
     */
    private static <T> T carregarJson(
            String arquivo,
            Class<T> classe) {

        try {

            InputStream inputStream = JsonUtils.class
                    .getClassLoader()
                    .getResourceAsStream(arquivo);

            if (inputStream == null) {

                throw new RuntimeException(
                        "Arquivo " + arquivo + " não encontrado.");
            }

            return mapper.readValue(
                    inputStream,
                    classe);

        } catch (Exception e) {

            throw new RuntimeException(
                    "Erro ao carregar " + arquivo,
                    e);
        }
    }

    /**
     * Carrega os dados de login.
     */
    public static LoginData carregarLoginData() {

        return carregarJson(
                "testdata/login.json",
                LoginData.class);
    }

    /**
     * Carrega os dados de checkout.
     */
    public static CheckoutData carregarCheckoutData() {

        return carregarJson(
                "testdata/checkout.json",
                CheckoutData.class);
    }

    /**
     * Carrega os dados do carrinho.
     */
    public static CartData carregarCartData() {

        return carregarJson(
                "testdata/cart.json",
                CartData.class);
    }

}