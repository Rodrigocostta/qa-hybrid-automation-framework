package data.dataprovider;

import data.model.CartData;
import utils.JsonUtils;

public class CartDataProvider {

    public static CartData getDados() {

        return JsonUtils.carregarCartData();

    }

}
