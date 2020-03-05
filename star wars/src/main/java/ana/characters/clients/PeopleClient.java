package ana.characters.clients;

import ana.characters.responses.PeopleResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rx.Observable;

import java.io.IOException;

@Service
public class PeopleClient {

    RestTemplate restTemplate;
    @Autowired
    private ObjectMapper objectMapper;

    private String URL = "https://swapi.co/api/people/";
    private String finalURL = "/?format=json";

    @Bean
    public RestTemplate restTemplate() {
        restTemplate = new RestTemplate();
        return restTemplate;
    }

    public Observable<PeopleResponse> getPeople(String id) {
        try {
            final String uri = URL + id + "/";
            String json = restTemplate.getForObject(uri, String.class);
            PeopleResponse people = objectMapper.readValue(json, PeopleResponse.class);
            return Observable.just(people);
        } catch (IOException ioe) {
            throw new RuntimeException("problem in serialization", ioe);
        }
    }


    public Observable<PeopleResponse> getDarthVader(){
        try {
            final String uri = URL + "4" + finalURL;
            String json = restTemplate.getForObject(uri, String.class);
            PeopleResponse people = objectMapper.readValue(json, PeopleResponse.class);
            return Observable.just(people);
        } catch (IOException ioe) {
            throw new RuntimeException("problem in serialization", ioe);
        }
    }
}

