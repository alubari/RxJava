package ana.characters.controller;

import ana.characters.dto.SiteDto;
import ana.characters.services.SiteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class SitesController {
    @Autowired
    private SiteService siteService;

    @GetMapping("sites/{id}")
    public SiteDto getSiteById(@PathVariable("id")String id){
        return siteService.modelADto(siteService.getSiteById(id)).toBlocking().first();
    }
}
