package ua.kpi.dziuba.gasstation.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ua.kpi.dziuba.gasstation.model.ITemplate;
import ua.kpi.dziuba.gasstation.service.ITemplateService;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/{userGuid}")
public class TemplateController {
    public static final Logger LOGGER = LoggerFactory.getLogger(TemplateController.class);

    private final ITemplateService templateService;

    @Autowired
    public TemplateController(ITemplateService templateService) {
        this.templateService = templateService;
    }

    @GetMapping("/templates")
    public List<ITemplate> getAllUserTemplates(@PathVariable UUID userGuid) {

        final List<ITemplate> templateList = templateService.getAllTemplatesByUserGuid(userGuid);

        LOGGER.info("All templates retrieved successfully!");

        return templateList;

    }

    @PostMapping("/templates")
    public void createTemplate(@RequestBody ITemplate template) {

        templateService.createTemplate(template);

        LOGGER.info("New template '{}' successfully created!", template.getName());
    }

    @PutMapping("/template")
    public void updateTemplate(@RequestBody ITemplate newTemplateInfo) {

        templateService.updateTemplate(newTemplateInfo);

        LOGGER.info("Template '{}' data successfully updated!", newTemplateInfo.getName());

    }

    @DeleteMapping("/templates/{templateId}")
    public void removeTemplateById(@PathVariable UUID userGuid, @PathVariable Integer templateId) {

        templateService.removeTemplateById(templateId, userGuid);

        LOGGER.info("Template with id {} successfully removed from the database!", templateId);
    }
}
