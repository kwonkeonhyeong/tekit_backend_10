package ch01;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

class MaxValueTest {
    @Test
    void max() {
        assertEquals(4,MaxValue.max(4,1,2));
        assertEquals(5,MaxValue.max(4,5,5));
        assertEquals(9,MaxValue.max(9,9,9));
        assertEquals(8,MaxValue.max(8,7,8));
    }
}