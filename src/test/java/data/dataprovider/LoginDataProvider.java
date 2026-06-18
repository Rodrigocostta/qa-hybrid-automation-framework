package data.dataprovider;

import data.model.LoginData;
import utils.JsonUtils;

public class LoginDataProvider {

    public static LoginData obterDadosLogin() {

        return JsonUtils.carregarLoginData();

    }
}
