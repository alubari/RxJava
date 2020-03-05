package ana.characters.model;

import java.util.List;

public class SiteModel {
    public String id;
    public String name;
    public String sale_fees_mode;
    public String default_currency_id;
    public Integer mercadopago_version;
    public String immediate_payment;
    public List<String> payment_method_ids;

    public SiteModel(String id, String name, String sale_fees_mode, String default_currency_id, Integer mercadopago_version, String immediate_payment, List<String> payment_method_ids) {
        this.id = id;
        this.name = name;
        this.sale_fees_mode = sale_fees_mode;
        this.default_currency_id = default_currency_id;
        this.mercadopago_version = mercadopago_version;
        this.immediate_payment = immediate_payment;
        this.payment_method_ids = payment_method_ids;
    }

    public SiteModel() {
    }

    public String getSale_fees_mode() {
        return sale_fees_mode;
    }

    public void setSale_fees_mode(String sale_fees_mode) {
        this.sale_fees_mode = sale_fees_mode;
    }

    public Integer getMercadopago_version() {
        return mercadopago_version;
    }

    public void setMercadopago_version(Integer mercadopago_version) {
        this.mercadopago_version = mercadopago_version;
    }

    public String getImmediate_payment() {
        return immediate_payment;
    }

    public void setImmediate_payment(String immediate_payment) {
        this.immediate_payment = immediate_payment;
    }

    public List<String> getPayment_method_ids() {
        return payment_method_ids;
    }

    public void setPayment_method_ids(List<String> payment_method_ids) {
        this.payment_method_ids = payment_method_ids;
    }

    public String getDefault_currency_id() {
        return default_currency_id;
    }

    public void setDefault_currency_id(String default_currency_id) {
        this.default_currency_id = default_currency_id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
