package ua.kpi.dziuba.gasstation.model.impl.builder;

import ua.kpi.dziuba.gasstation.model.impl.Tariff;

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

    public Tariff build() {
        return new Tariff(price);
    }
}
