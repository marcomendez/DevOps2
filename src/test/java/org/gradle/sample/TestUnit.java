package org.gradle.sample;




import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;


public class TestUnit {

    @Test
    public void testTrueEqualtTrue()
    {
        assertEquals(true,true);
    }
    @Test
    public void testOneEqualsOne()
    {
        assertEquals(1,1);
    }
    @Test
    public void testSumAAndBEqualsFive()
    {
        final int valueA = 1;
        final int valueB = 4;
        final int actualResuult = valueA + valueB;
        final int expectResult = 5;
        assertEquals(actualResuult,expectResult);
    }

    @Test
    public void test2()
    {
        assertEquals(true,true);
    }
    @Test
    public void test3()
    {
       assertTrue(true);
    }
    @Test
    public void test4()
    {
        assertEquals(true,true);
    }
    @Test
    public void test5()
    {
        assertTrue(true);
    }
    @Test
    public void test6()
    {
        assertEquals(true,true);
    }
    @Test
    public void test7()
    {
        assertEquals(20.5,20.5,0);
    }

    @Test
    public void test8()
    {
        assertFalse(false);
    }
}
