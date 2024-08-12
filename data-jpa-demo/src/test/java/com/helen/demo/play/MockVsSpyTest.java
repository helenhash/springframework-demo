package com.helen.demo.play;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class MockVsSpyTest {

    @Mock
    private List<String> mockList;
    @Spy
    private List<String> spyList = new ArrayList<>();

    @Test
    void testMockList() {
        mockList.add("test");
        assertNull(mockList.get(0));
    }
    @Test
    void testMockWithStub() {
        String expected = "Mock 100";
        when(mockList.get(100)).thenReturn(expected);
        assertEquals(expected, mockList.get(100));
    }

    @Test
    void testSpyList() {
        spyList.add("test");
        assertEquals("test", spyList.get(0));
    }
    @Test
    void testSpyWithStub() {
        String expected = "Spy 100";
        Mockito.doReturn(expected).when(spyList).get(100);
        assertEquals(expected, spyList.get(100));
    }
}
