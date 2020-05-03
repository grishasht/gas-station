package ua.kpi.dziuba.gasstation.service;

import org.springframework.stereotype.Component;
import ua.kpi.dziuba.gasstation.model.ITemplate;

import java.util.List;
import java.util.UUID;

@Component
public interface ITemplateService {

    List<ITemplate> getAllTemplatesByUserGuid(UUID userGuid);

    ITemplate createTemplate(ITemplate newTemplate);

    ITemplate updateTemplate(ITemplate newTemplateInfo);

    void removeTemplateById(Integer id, UUID userGuid);
}
