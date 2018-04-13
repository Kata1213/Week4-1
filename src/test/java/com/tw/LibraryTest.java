package com.tw;

import org.junit.Test;

import java.util.LinkedList;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import java.io.ByteArrayOutputStream;

public class LibraryTest {
    @Test
    public void testAddScore() {
        String s1 = "张三,000001,数学:60,语文:60,英语:60,编程:60";
        String should_result="学生张三的成绩被添加";
        String real_result=new Library().toString();
        assertEquals(should_result, real_result);

    }
    @Test
    public void testPtrintScore() {
        String s1 = "张三,000001,数学:60,语文:60,英语:60,编程:60";
        String s2 = "李四,000002,数学:90,语文:90,英语:90,编程:90";
        String should_result="学生张三的成绩被添加\n" +
                "学生李四的成绩被添加\n" +
                "成绩单\n" +
                "姓名|数学|语文|英语|编程|平均分|总分\n" +
                "========================\n" +
                "张三|60|60|60|60|60|300\n" +
                "李四|95|90|90|90|90|450\n" +
                "========================\n" +
                "全班总分平均数：375\n" +
                "全班总分中位数：375\n";
        String real_result=new Library().toString();
        assertEquals(should_result, real_result);

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

}
