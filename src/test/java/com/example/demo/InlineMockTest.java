package com.example.demo;

import org.junit.jupiter.api.Test;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class InlineMockTest {

    @Test
    void testInlineMock() {
        Map mapMock = mock(Map.class);
        assertEquals(mapMock.size(), 0);
    }

    @Test
    void testInlineMock2() {
        Map<String, String> mapMock = mock(Map.class);
        assertEquals(0, mapMock.size());
        when(mapMock.get("hej")).thenReturn("ehej");
        //mapMock.put("hej", "ehej");
        assertEquals("ehej", mapMock.get("hej"));
    }
}
