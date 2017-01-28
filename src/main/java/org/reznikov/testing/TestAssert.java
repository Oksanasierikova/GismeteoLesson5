package org.reznikov.testing;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

public class TestAssert {

        @Test
        public void test1() {
            try {
                Assert.assertTrue(2 < 1);
                System.out.println("Assertion Failed in Test 1");
                Assert.assertFalse(1 > 0);
                System.out.println("Assertion Failed in Test 1");
                Assert.assertEquals("Sample", "Sample");
                System.out.println("Assertion Passed in Test 1");
            } catch (AssertionError ae) {
                ae.printStackTrace();
            }
        }

        @Test
        public void test2() {
            try {
                Assert.assertTrue(2 > 1);
                System.out.println("Assertion passed in Test 2");
                Assert.assertFalse(1 < 0);
                System.out.println("Assertion passed in Test 2");
                Assert.assertEquals("Sample", "Sample");
                System.out.println("Assertion Passed in Test 2");
            } catch (AssertionError ae) {
                ae.printStackTrace();
            }
        }
    @Test

    public void test3(){
        SoftAssert sa= new SoftAssert();
        sa.assertTrue(2<1);
        System.out.println("Assertion Failed");
        sa.assertFalse(1<2);
        System.out.println("Assertion Failed");
        sa.assertEquals("Sample", "Failed");
        System.out.println("Assertion Failed");
    }

    @Test
    public void test4(){
        SoftAssert sa= new SoftAssert();
        sa.assertTrue(2<1);
        System.out.println("Assertion Failed");
        sa.assertFalse(1<2);
        System.out.println("Assertion Failed");
        sa.assertEquals("Sample", "Failed");
        System.out.println("Assertion Failed");
        sa.assertAll();
    }
}

