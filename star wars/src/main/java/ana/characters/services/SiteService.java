package ana.characters.services;

import ana.characters.clients.SitesClient;
import ana.characters.dto.SiteDto;
import ana.characters.model.SiteModel;
import ana.characters.responses.SiteResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import rx.Observable;


@Service
public class SiteService {
    @Autowired
    public SitesClient sitesClient;

    public Observable<SiteModel> getSiteById(String id){
        return responseAModel(sitesClient.getSite(id));
    }


    public Observable<SiteModel> responseAModel(Observable<SiteResponse> responseObservable){
        SiteModel model = new SiteModel();
        SiteResponse response = responseObservable.toBlocking().first();

        model.default_currency_id = response.default_currency_id;
        model.id = response.id;
        model.name = response.name;
        model.immediate_payment = response.immediate_payment;
        model.payment_method_ids = response.payment_method_ids;
        model.mercadopago_version = response.mercadopago_version;
        model.sale_fees_mode = response.sale_fees_mode;

        return Observable.just(model);
    }

    public Observable<SiteDto> modelADto(Observable<SiteModel> siteModelObservable){
        SiteDto dto = new SiteDto();
        SiteModel model = siteModelObservable.toBlocking().first();

        dto.default_currency_id = model.default_currency_id;
        dto.id = model.id;
        dto.name = model.name;
        dto.immediate_payment = model.immediate_payment;
        dto.mercadopago_version = model.mercadopago_version;
        dto.default_currency_id = model.default_currency_id;
        dto.sale_fees_mode = model.sale_fees_mode;

        return Observable.just(dto);
    }

}
