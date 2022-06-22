package com.erik_b.Coolschrank;

import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class CoolschrankService {

    public static Coolschrank createCoolschrank(RestTemplate restTemplate) {
        ResponseEntity<Coolschrank> response = restTemplate.exchange(
            "https://innovations.rola.com/build/rola/coolschrank/ongoing/application/fridge/", 
            HttpMethod.POST,
            null, 
            Coolschrank.class);
        Coolschrank coolschrank = response.getBody();
        return coolschrank;
    }
}
