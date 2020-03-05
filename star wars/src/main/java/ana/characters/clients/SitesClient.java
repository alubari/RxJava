package ana.characters.clients;

import ana.characters.responses.SiteResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import rx.Observable;

import java.io.IOException;

@Service
public class SitesClient {

    RestTemplate restTemplate;

    @Autowired
    private ObjectMapper objectMapper;

    @Bean
    public RestTemplate restTemplate(){
        restTemplate = new RestTemplate();
        return restTemplate;
    }

    private String URL = "http://api.internal.ml.com/sites/";

//    public SiteResponse getSites(){
//        try{
//            final String uri = URL;
//            String json = restTemplate.getForObject(uri, String.class);
//            SiteResponse response = objectMapper.readValue(json, SiteResponse.class);
//            return response;
//        }
//        catch (IOException ioe){
//            throw new RuntimeException("problem in seralization");
//        }
//    }

    public Observable<SiteResponse> getSite(String id){
        try{
            final String uri = URL + id;
            String json = restTemplate.getForObject(uri, String.class);
            SiteResponse response = objectMapper.readValue(json, SiteResponse.class);
            return Observable.just(response);
        }
        catch (IOException ioe){
            throw new RuntimeException("problem in seralization");
        }
    }

}
