package ua.kpi.dziuba.gasstation.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;
import ua.kpi.dziuba.gasstation.model.ITemplate;
import ua.kpi.dziuba.gasstation.model.impl.Template;

import java.util.List;
import java.util.UUID;

@Component
public interface ITemplateRepository extends CrudRepository<Template, Integer> {

    List<ITemplate> findAllByUserGuid(UUID userGuid);

    ITemplate findByName(String name);

    void removeByIdAndUserGuid(Integer id, UUID userGuid);

    ITemplate findByUserGuidAndName(UUID userGuid, String name);
}
