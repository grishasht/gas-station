package ua.kpi.dziuba.gasstation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import ua.kpi.dziuba.gasstation.model.impl.Template;

@Component
public interface ITemplateRepository extends CrudRepository<Template, Integer> {
}
