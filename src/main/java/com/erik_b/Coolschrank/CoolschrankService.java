package com.erik_b.Coolschrank;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.client.RestTemplate;

@Service
public class CoolschrankService {

    public Coolschrank createCoolschrank(RestTemplate restTemplate) {
        ResponseEntity<Coolschrank> response = restTemplate.exchange(
            "https://innovations.rola.com/build/rola/coolschrank/ongoing/application/fridge/", 
            HttpMethod.POST,
            null, 
            Coolschrank.class);
        return response.getBody();
    }

    public Coolschrank getCoolschrank(String id) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://innovations.rola.com/build/rola/coolschrank/ongoing/application/fridge/"+id,
                Coolschrank.class);
    }

    public ResponseInventory createCoolschrankItem(String id, RequestInventory inventory) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject( "https://innovations.rola.com/build/rola/coolschrank/ongoing/application/fridge/"+id+"/item", inventory, ResponseInventory.class);
    }

    public RequestInventory getCoolschrankItem(String id, String itemId) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://innovations.rola.com/build/rola/coolschrank/ongoing/application/fridge/"+id+"/item/"+itemId,
                RequestInventory.class);
    }

    public RequestInventory changeCoolschrankItem(String id, String itemId, RequestInventory inventory) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject( "https://innovations.rola.com/build/rola/coolschrank/ongoing/application/fridge/"+id+"/item/"+itemId, inventory, RequestInventory.class);
    }

    /*public ShoppingList addShoppingItem(String id){
        RestTemplate restTemplate = new RestTemplate();
        //return restTemplate.getForObject("https://innovations.rola.com/build/rola/coolschrank/ongoing/application/fridge/"+id;
    }*/

}
