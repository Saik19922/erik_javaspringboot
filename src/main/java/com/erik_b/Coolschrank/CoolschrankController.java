package com.erik_b.Coolschrank;

import com.fasterxml.jackson.annotation.JsonTypeId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
public class CoolschrankController {
    @Autowired
    private CoolschrankService coolschrankService;


    @RequestMapping("/hello")
    public String hello(){
        return "hello";
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
        //System.out.println(inventory);
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

    @RequestMapping (value = "/fridge/{id}/newshoppinglist")
    public Object createShoppingList(@PathVariable String id){

        coolschrankService.getCoolschrank(id).createShoppingList();
        return "Einkaufsliste erstellt";
    }


}
