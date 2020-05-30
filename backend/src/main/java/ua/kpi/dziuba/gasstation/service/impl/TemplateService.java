package ua.kpi.dziuba.gasstation.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import ua.kpi.dziuba.gasstation.model.ITemplate;
import ua.kpi.dziuba.gasstation.model.impl.Template;
import ua.kpi.dziuba.gasstation.model.impl.builder.TemplateBuilder;
import ua.kpi.dziuba.gasstation.repository.ITemplateRepository;
import ua.kpi.dziuba.gasstation.service.ITemplateService;

import java.util.List;
import java.util.UUID;

public class TemplateService implements ITemplateService {

    @Autowired
    private ITemplateRepository templateRepository;

    @Override
    public List<ITemplate> getAllTemplatesByUserGuid(UUID userGuid) {

        return templateRepository.findAllByUserGuid(userGuid);
    }

    @Override
    public List<ITemplate> getAllTemplatesByName(UUID userGuid, String templateName) {

        return templateRepository.findByUserGuidAndName(userGuid, templateName);
    }

    @Override
    public ITemplate createTemplate(ITemplate newTemplate) {

        return templateRepository.save((Template) newTemplate);
    }

    @Override
    public ITemplate updateTemplate(ITemplate newTemplateInfo) {

        final ITemplate templateByName = templateRepository.findByName(newTemplateInfo.getName());

        final ITemplate newTemplate = TemplateBuilder.newBuilder()
                .setId(templateByName.getId())
                .setFuel(newTemplateInfo.getFuel())
                .build();

        return templateRepository.save((Template) newTemplate);
    }

    @Override
    public void removeTemplateById(Integer id, UUID userGuid) {

        templateRepository.removeByIdAndUserGuid(id, userGuid);
    }
}
