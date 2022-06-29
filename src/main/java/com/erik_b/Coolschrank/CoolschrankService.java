package com.erik_b.Coolschrank;

import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Service
public class CoolschrankService {
    ShoppingList shoppingList = new ShoppingList();

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



    public ResponseInventory changeCoolschrankItem(String id, String itemId, RequestInventory inventory) {
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.postForObject( "https://innovations.rola.com/build/rola/coolschrank/ongoing/application/fridge/"+id+"/item/"+itemId, inventory, ResponseInventory.class);
    }


    // Anforderung 1
    public List<ShoppingList> createShoppinglist(String id){
        Coolschrank coolschrank = getCoolschrank(id);
        shoppingList.deleteAll();
        shoppingList.setFridgeId(id);
        shoppingList.addItem(coolschrank.getInventory());
        return List.of(shoppingList);

    }
     //Anforderung 2: Es wird eine neue Schnittstelle benötigt, die in der Frontend-App verwendet werden soll. Diese soll ermöglichen bei einem Einkauf einfach abfragen zu können, welche Produkte in welcher Menge eingekauft werden müssen.
     public ArrayList<ProductResponse> getShoppinglistvalue(String id){
            ArrayList<ProductResponse> productResponses = new ArrayList<>();
            for (Product a : shoppingList.getShoppinglist()) {
                ProductResponse productResponse = new ProductResponse();
                productResponse.setName(a.getName());
                productResponse.setNeedvalue((Double) a.getProductvalue());
                productResponses.add(productResponse);
            }
        return productResponses;
    }

    //Anforderung 3
    public ResponseInventory changeShoppinglistProduct(String id, String itemId){
        shoppingList.changeItem(itemId, id);
        return changeCoolschrankItemWithShoppinglist(id, itemId, new RestTemplate());
        //return "Item filled";
    }
    public ResponseInventory changeCoolschrankItemWithShoppinglist(String id, String itemId, RestTemplate restTemplate) {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        headers.setAccept(List.of(MediaType.APPLICATION_JSON));
        HttpEntity<Product> request = new HttpEntity<>(shoppingList.findItem(itemId), headers);
        System.out.println(request.getBody());
        ResponseEntity<ResponseInventory> response = restTemplate.exchange(
                "https://innovations.rola.com/build/rola/coolschrank/ongoing/application/fridge/"+id+"/item/"+itemId,
                HttpMethod.POST,
                request,
                ResponseInventory.class);
        return response.getBody();
    }

}
