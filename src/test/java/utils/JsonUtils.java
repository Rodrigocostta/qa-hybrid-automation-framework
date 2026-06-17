package utils;

import java.io.InputStream;

import com.fasterxml.jackson.databind.ObjectMapper;

import model.CheckoutData;

public class JsonUtils {

    public static CheckoutData carregarCheckoutData() {

        try {

            ObjectMapper mapper = new ObjectMapper();

            InputStream inputStream = JsonUtils.class
                    .getClassLoader()
                    .getResourceAsStream(
                            "testdata/checkout.json");

            if (inputStream == null) {

                throw new RuntimeException(
                        "Arquivo checkout.json não encontrado");
            }

            return mapper.readValue(
                    inputStream,
                    CheckoutData.class);

        } catch (Exception e) {

            throw new RuntimeException(
                    "Erro ao carregar arquivo JSON",
                    e);
        }
    }
}
