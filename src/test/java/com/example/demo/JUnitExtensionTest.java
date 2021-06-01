package com.example.demo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(MockitoExtension.class)
public class JUnitExtensionTest {

    @Mock
    Map<String, Object> mapMock;

    @Test
    void TestMock() {
        mapMock.put("key", "value");
        assertEquals(1, mapMock.size());
    }
}
