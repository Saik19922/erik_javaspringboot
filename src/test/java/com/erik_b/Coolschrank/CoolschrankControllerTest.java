package com.erik_b.Coolschrank;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;

import static org.junit.jupiter.api.Assertions.*;

class CoolschrankControllerTest {
    CoolschrankController controller = new CoolschrankController();
    @Test
    void hello() {
        String response = controller.hello("World");
        assertEquals("Hello World", response);
    }


}