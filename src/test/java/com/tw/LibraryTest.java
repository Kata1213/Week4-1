package com.tw;

import org.junit.Before;
import org.junit.Test;

import java.io.PrintStream;
import java.util.Arrays;
import java.util.LinkedList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.io.ByteArrayOutputStream;

public class LibraryTest {
    private ByteArrayOutputStream outContent;

    @Before
    public void setUp() throws Exception {
        outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Library.report.clear();
    }

    private String systemOut() {
        return outContent.toString();
    }

    @Test
    public void testAddScore() {
        String s1 = "张三,123,数学:60,语文:60,英语:60,编程:60";
        assertTrue(Library.addStudentInfo(Arrays.asList(s1.split(","))));
        assertTrue(systemOut().endsWith("学生张三的成绩被添加\n"));

    }
    @Test
    public void testPtrintScore() {
        String s1 = "张三,123,数学:60,语文:60,英语:60,编程:60";
        assertTrue(Library.addStudentInfo(Arrays.asList(s1.split(","))));
        assertTrue(systemOut().endsWith("学生张三的成绩被添加\n"));
        String s2 = "123";
        assertTrue(Library.generateGrades(Arrays.asList(s2)));
        assertEquals("学生张三的成绩被添加\n" +
                "成绩单\n" +
                "姓名|数学|语文|英语|编程|平均分|总分\n" +
                "========================\n" +
                "张三|60|60|60|60|60|240\n" +
                "========================\n" +
                "全班总分平均数：240\n" +
                "全班总分中位数：240\n", systemOut());
    }

    }


   /* @Test
    public void testSomeLibraryMethod() {
        Library classUnderTest = new Library();
        assertTrue("someLibraryMethod should return 'true'", classUnderTest.someLibraryMethod());
    }

    @Test
    public void testMockClass() throws Exception {
        // you can mock concrete classes, not only interfaces
        LinkedList mockedList = mock(LinkedList.class);

        // stubbing appears before the actual execution
        String value = "first";
        when(mockedList.get(0)).thenReturn(value);

        assertEquals(mockedList.get(0), value);

    }*/


