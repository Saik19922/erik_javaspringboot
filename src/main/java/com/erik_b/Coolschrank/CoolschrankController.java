package com.erik_b.Coolschrank;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class CoolschrankController {
    @Autowired
    private CoolschrankService coolschrankService;


    @RequestMapping("/hello")
    public String hello(String world){
        return String.format("Hello "+ world);
    }

    @GetMapping(value = "/callclienthello")
    public Object getHelloClient() {
        String uri = "http://localhost:8080/hello";
        RestTemplate restTemplate = new RestTemplate();
        return restTemplate.getForObject(uri, Object.class);
    }
    @PostMapping(value = "/fridge")
    public Object createFridge() {
        return coolschrankService.createCoolschrank(new RestTemplate());
    }
    @GetMapping(value = "/fridge/{id}")
    public Object getFridge(@PathVariable String id) {
        return coolschrankService.getCoolschrank(id);
    }

    @PostMapping(value = "/fridge/{id}/item")
    public Object createItem(@PathVariable String id, @RequestBody RequestInventory inventory) {
        return coolschrankService.createCoolschrankItem(id, inventory);
    }

    @GetMapping(value = "/fridge/{id}/item/{itemId}")
    public Object getItem(@PathVariable String id, @PathVariable String itemId) {
        return coolschrankService.getCoolschrankItem(id, itemId);
    }

    @PostMapping (value = "/fridge/{id}/item/{itemId}")
    public Object changeItem(@PathVariable String id, @PathVariable String itemId, @RequestBody RequestInventory inventory) {
        return coolschrankService.changeCoolschrankItem(id, itemId, inventory);
    }

    //Anforderung 1
    @PostMapping (value = "/fridge/{id}/newshoppinglist")
    public Object createShoppingList(@PathVariable String id){
        return coolschrankService.createShoppinglist(id);
    }

    // Anforderung 2
    @GetMapping (value = "/fridge/{id}/shoppinglist")
    public Object getShoppingList(@PathVariable String id){
        return coolschrankService.getShoppinglistvalue(id);
    }

    //Anforderung 3
    @PostMapping(value = "/fridge/{id}/shopping/{itemId}")
    public Object shoppingProduct(@PathVariable String id, @PathVariable String itemId) {
        return coolschrankService.changeShoppinglistProduct(id, itemId);
    }


}
