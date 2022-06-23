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

    public Coolschrank createCoolschrankItem(Inventory inventory, String id) { // ToDO: Ausgabe, Speicherung in Array Inventory evtl. Fehlerhaft (Ausgabe Inventory = null)
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject( "https://innovations.rola.com/build/rola/coolschrank/ongoing/application/fridge/"+id+"/item", inventory, Coolschrank.class);
    }

    public Coolschrank getCoolschrankItem(String id, String itemId) { // ToDo: Inventory Class evtl fehlerhaft mit Responsebody probieren
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject("https://innovations.rola.com/build/rola/coolschrank/ongoing/application/fridge/"+id+"/item/"+itemId,
                Inventory.class);
    }

   /* public Coolschrank changeCoolschrankItem() {
        //ToDo
    }*/
}
