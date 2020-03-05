package ana.characters.services;

import ana.characters.clients.PeopleClient;
import ana.characters.dto.PeopleDto;
import ana.characters.model.PeopleModel;
import ana.characters.responses.PeopleResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rx.Observable;

@Service
public class PeopleService {

    @Autowired
    private PeopleClient peopleClient;

    public Observable<PeopleModel> getPeople(String id){

        if(id != null) {
            return responsaAModel(peopleClient.getPeople(id));
        }
        else{
            System.out.print("wrong id");
            return null;
        }
    }

    public Observable<PeopleModel> responsaAModel(Observable<PeopleResponse> responseObservable){
        PeopleModel model = new PeopleModel();
        PeopleResponse response = responseObservable.toBlocking().first();

        model.name = response.name;
        model.height = response.height;
        model.mass = response.mass;
        model.hair_color = response.hair_color;
        model.eye_color = response.eye_color;
        model.birth_year = response.birth_year;
        model.gender = response.gender;
        model.homeworld = response.homeworld;
        model.films = response.films;
        model.species = response.species;
        model.vehicles = response.vehicles;
        model.starships = response.starships;
        model.created = response.created;
        model.edited = response.edited;
        model.url = response.url;


        return Observable.just(model);
    }

    public Observable<PeopleDto> modelADto(Observable<PeopleModel> peopleModelObservable){
        PeopleDto dto = new PeopleDto();
        PeopleModel model = peopleModelObservable.toBlocking().first();

        dto.name = model.name;
        dto.height = model.height;
        dto.mass = model.mass ;
        dto.hair_color = model.hair_color;
        dto.eye_color = model.eye_color;
        dto.birth_year = model.birth_year;
        dto.gender = model.gender;
        dto.homeworld = model.homeworld ;
        dto.films = model.films ;
        dto.species = model.species;
        dto.vehicles = model.vehicles;
        dto.starships = model.starships;
        dto.created = model.created;
        dto.edited = model.edited;
        dto.url = model.url;

        return Observable.just(dto);
    }

    public Observable<PeopleModel> getDarthVader(){
        return responsaAModel(peopleClient.getDarthVader());
    }
}
