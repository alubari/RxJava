package ana.characters.controller;

import ana.characters.dto.PeopleDto;
import ana.characters.services.PeopleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import rx.Observable;

@RestController

public class CharacterController {
    @Autowired
    private PeopleService peopleService;

    @GetMapping("/people/{id}")
    public Observable<PeopleDto> getPeople(@PathVariable("id") String id){

        return peopleService.modelADto(peopleService.getPeople(id));
    }

    @GetMapping("people/darth")
    public Observable<PeopleDto> getDarthVader(){
        return peopleService.modelADto(peopleService.getDarthVader());
    }
}
