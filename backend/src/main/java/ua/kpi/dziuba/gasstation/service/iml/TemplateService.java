package ua.kpi.dziuba.gasstation.service.iml;

import org.springframework.beans.factory.annotation.Autowired;
import ua.kpi.dziuba.gasstation.model.ITemplate;
import ua.kpi.dziuba.gasstation.model.IUser;
import ua.kpi.dziuba.gasstation.model.impl.Template;
import ua.kpi.dziuba.gasstation.model.impl.builder.TemplateBuilder;
import ua.kpi.dziuba.gasstation.repository.ITemplateRepository;
import ua.kpi.dziuba.gasstation.repository.IUserRepository;
import ua.kpi.dziuba.gasstation.service.ITemplateService;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class TemplateService implements ITemplateService {

    @Autowired
    private ITemplateRepository templateRepository;

    @Override
    public List<ITemplate> getAllTemplatesByUserGuid(UUID userGuid) {

        final Iterable<Template> templateIterable = templateRepository.findAll();

        return StreamSupport.stream(templateIterable.spliterator(), false)
                .collect(Collectors.toList());
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
                .setTariff(newTemplateInfo.getTariff())
                .build();

        return templateRepository.save((Template) newTemplate);
    }

    @Override
    public void removeTemplateById(Integer id, UUID userGuid) {

        templateRepository.removeByIdAndUserGuid(id, userGuid);
    }
}
