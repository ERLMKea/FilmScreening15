package com.example.demo;

import org.junit.jupiter.api.Test;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class InlineMockTest2 {

    @Test
    void testInlineMock() {
        Map mapMock = mock(Map.class);
        //mapMock.put("hej", "viggo");
        when(mapMock.get("hej")).thenReturn("viggo");
        assertEquals(0, mapMock.size());
        assertEquals("viggo", mapMock.get("hej"));
    }
}
