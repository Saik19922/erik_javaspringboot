package com.erik_b.Coolschrank;

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
    public Object createItem(@PathVariable String id, @RequestBody Inventory inventory) {
        return coolschrankService.createCoolschrankItem(inventory, id);
    }

    @GetMapping(value = "/fridge/{id}/item/{itemId}")
    public Object getItem(@PathVariable String id, @PathVariable String itemId) {
        return coolschrankService.getCoolschrankItem(id, itemId);
    }
    //ToDo
}
