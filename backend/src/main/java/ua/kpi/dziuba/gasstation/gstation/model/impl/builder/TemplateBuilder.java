package ua.kpi.dziuba.gasstation.gstation.model.impl.builder;

import ua.kpi.dziuba.gasstation.gstation.model.ITemplate;
import ua.kpi.dziuba.gasstation.gstation.model.impl.Template;

public class TemplateBuilder {

    TemplateBuilder() {
    }

    public static TemplateBuilder newBuilder(){
        return new TemplateBuilder();
    }

    public ITemplate build(){
        return new Template();
    }
}
