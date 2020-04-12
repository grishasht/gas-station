package ua.kpi.dziuba.gasstation.gstation.model.impl.builder;

import ua.kpi.dziuba.gasstation.gstation.model.ITariff;
import ua.kpi.dziuba.gasstation.gstation.model.impl.Tariff;

public class TariffBuilder {
    private Float price;

    TariffBuilder() {
    }

    public static TariffBuilder newBuilder() {
        return new TariffBuilder();
    }

    public TariffBuilder setPrice(Float price) {
        this.price = price;

        return this;
    }

    public ITariff build() {
        return new Tariff(price);
    }
}
