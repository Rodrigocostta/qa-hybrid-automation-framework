package data.dataprovider;

import data.model.LoginData;
import utils.JsonUtils;

public class CheckoutDataProvider {

    public static LoginData getDados() {

        return JsonUtils.carregarLoginData();

    }
}
