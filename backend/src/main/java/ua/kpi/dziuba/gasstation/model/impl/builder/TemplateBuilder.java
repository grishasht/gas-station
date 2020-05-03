package ua.kpi.dziuba.gasstation.model.impl.builder;

import ua.kpi.dziuba.gasstation.model.impl.Template;

public class TemplateBuilder {

    TemplateBuilder() {
    }

    public static TemplateBuilder newBuilder(){
        return new TemplateBuilder();
    }

    public Template build(){
        return new Template();
    }
}
