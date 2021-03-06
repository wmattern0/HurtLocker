package mattern.william;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class StringToItemConverterTest {
    StringToItemConverter stringToItemConverter;
    String sampleLittleJerksonString1;
    String sampleLittleJerksonString2;
    String sampleLittleJerksonString3;
    String sampleLittleJerksonString4;
    String sampleLittleJerksonString5;


    @Before
    public void setUp(){
        stringToItemConverter = new StringToItemConverter();
        sampleLittleJerksonString1 = "naMe:Milk;price:3.23;type:Food;expiration:1/25/2016";
        sampleLittleJerksonString2 = "naMe:COOkieS;price:2.25;type:Food;expiration:1/25/2016";
        sampleLittleJerksonString3 = "naMe:MiLK;priCe:;type:Food;expiration:1/11/2016";
        sampleLittleJerksonString4 = "NAME:MilK;price:3.23;type:Food;expiration:1/17/2016";
        sampleLittleJerksonString5 = "naMe:;price:3.23;type:Food^expiration:1/04/2016";
    }

    @Test
    public void getLittleJerksonStringToGLIConverterTest1() throws Exception {
       String expected = "Milk,3.23,Food,1/25/2016";
       String actual = stringToItemConverter.convertLittleJerksonStringToGLI(sampleLittleJerksonString1).toString();
       assertEquals(expected,actual);
    }

    @Test
    public void getLittleJerksonStringToGLIConverterTest2() throws Exception {
        String expected = "Cookies,2.25,Food,1/25/2016";
        String actual = stringToItemConverter.convertLittleJerksonStringToGLI(sampleLittleJerksonString2).toString();
        assertEquals(expected,actual);
    }

    @Test
    public void getLittleJerksonStringToGLIConverterTest3()throws Exception {
        int expected = 1;
        stringToItemConverter.convertLittleJerksonStringToGLI(sampleLittleJerksonString3);
        int actual = InputHandler.jerksonExceptions;
        assertEquals(expected,actual);
    }

    @Test
    public void getLittleJerksonStringToGLIConverterTest4() throws Exception{
        String expected = "Milk,3.23,Food,1/17/2016";
        String actual = stringToItemConverter.convertLittleJerksonStringToGLI(sampleLittleJerksonString4).toString();
        assertEquals(expected,actual);
    }

    @Test
    public void getLittleJerksonStringToGLIConverterTest5() throws Exception {
        int expected = 1;
        stringToItemConverter.convertLittleJerksonStringToGLI(sampleLittleJerksonString5);
        int actual = InputHandler.jerksonExceptions;
        assertEquals(expected,actual);
    }

    @Test
    public void nameKeyValuePairFinderTest3(){
        String expected = "naMe:;";
        String actual = stringToItemConverter.nameKeyValuePairFinder(sampleLittleJerksonString5);
        assertEquals(expected,actual);
    }

    @Test
    public void cookieFinderTest(){
        assertTrue(stringToItemConverter.cookieFinder("naMe:COOkieS;"));
    }

    @Test
    public void milkFinderTest(){
        assertTrue(stringToItemConverter.milkFinder("naMe:Milk;"));
    }

    @Test
    public void breadFinderTest(){
        assertTrue(stringToItemConverter.breadFinder("NAMe:BrEAD"));
    }

    @Test
    public void applesFinderTest(){
        assertTrue(stringToItemConverter.applesFinder("NAMe:apPles"));
    }

    @Test
    public void nameKeyValuePairFinderTest1(){
        String expected = "naMe:Milk;";
        String actual = stringToItemConverter.nameKeyValuePairFinder(sampleLittleJerksonString1);
        assertEquals(expected,actual);
    }

    @Test
    public void nameKeyValuePairFinderTest2(){
        String expected = "naMe:COOkieS;";
        String actual = stringToItemConverter.nameKeyValuePairFinder(sampleLittleJerksonString2);
        assertEquals(expected,actual);
    }

    @Test
    public void priceFinderTest() throws Exception{
        String expected = "3.23";
        String actual = stringToItemConverter.priceFinder(sampleLittleJerksonString1);
        assertEquals(expected,actual);
    }

    @Test
    public void dateFinderTest(){
        String expected = "1/25/2016";
        String actual = stringToItemConverter.dateFinder(sampleLittleJerksonString1);
        assertEquals(expected,actual);
    }

    @Test
    public void littleJerksonStringNameParserTest1()   {
        String expected = "Milk";
        try {
            String actual = stringToItemConverter.littleJerksonStringNameParser(sampleLittleJerksonString1);
            assertEquals(expected,actual);
        } catch (GroceryItemNotFoundException e){
            e.printStackTrace(System.out);
        }
    }

    @Test
    public void littleJerksonStringNameParserTest2()   {
        String expected = "Cookies";
        try {
            String actual = stringToItemConverter.littleJerksonStringNameParser(sampleLittleJerksonString2);
            assertEquals(expected, actual);
        } catch (Exception e){
            e.printStackTrace(System.out);
        }
    }

    @Test
    public void littleJerksonStringNameParserTest3() throws Exception  {
        String expected = "Milk";
        String actual = stringToItemConverter.littleJerksonStringNameParser(sampleLittleJerksonString3);
        assertEquals(expected,actual);
    }

    @Test
    public void littleJerksonStringNameParserTest4() throws Exception  {
        String expected = "Milk";
        String actual = stringToItemConverter.littleJerksonStringNameParser(sampleLittleJerksonString4);
        assertEquals(expected,actual);
    }


    @Test
    public void littleJerksonStringPriceParserTest1()  throws Exception {
        String expected = "3.23";
        String actual = stringToItemConverter.littleJerksonStringPriceParser(sampleLittleJerksonString1);
        assertEquals(expected,actual);
    }

    @Test
    public void littleJerksonStringPriceParserTest2()  throws Exception {
        String expected = "2.25";
        String actual = stringToItemConverter.littleJerksonStringPriceParser(sampleLittleJerksonString2);
        assertEquals(expected,actual);
    }

    @Test
    public void littleJerksonStringPriceParserTest3()  throws Exception {
        int expected = 2;
        stringToItemConverter.convertLittleJerksonStringToGLI(sampleLittleJerksonString3);
        stringToItemConverter.convertLittleJerksonStringToGLI(sampleLittleJerksonString5);
        int actual = InputHandler.jerksonExceptions;
        assertEquals(expected,actual);
    }

    @Test
    public void littleJerksonStringPriceParserTest4()  throws Exception {
        String expected = "3.23";
        String actual = stringToItemConverter.littleJerksonStringPriceParser(sampleLittleJerksonString4);
        assertEquals(expected,actual);
    }

    @Test
    public void littleJerksonStringTypeParserTest1()   {
        String expected = "Food";
        String actual = stringToItemConverter.littleJerksonStringTypeParser(sampleLittleJerksonString1);
        assertEquals(expected,actual);
    }

    @Test
    public void littleJerksonStringTypeParserTest2()   {
        String expected = "Food";
        String actual = stringToItemConverter.littleJerksonStringTypeParser(sampleLittleJerksonString2);
        assertEquals(expected,actual);
    }

    @Test
    public void littleJerksonStringTypeParserTest3()   {
        String expected = "Food";
        String actual = stringToItemConverter.littleJerksonStringTypeParser(sampleLittleJerksonString3);
        assertEquals(expected,actual);
    }

    @Test
    public void littleJerksonStringTypeParserTest4()   {
        String expected = "Food";
        String actual = stringToItemConverter.littleJerksonStringTypeParser(sampleLittleJerksonString4);
        assertEquals(expected,actual);
    }

    @Test
    public void littleJerksonStringExpirationDateParserTest1()   {
        String expected = "1/25/2016";
        String actual = stringToItemConverter.littleJerksonStringExpirationDateParser(sampleLittleJerksonString1);
        assertEquals(expected,actual);
    }

    @Test
    public void littleJerksonStringExpirationDateParserTest2()   {
        String expected = "1/25/2016";
        String actual = stringToItemConverter.littleJerksonStringExpirationDateParser(sampleLittleJerksonString2);
        assertEquals(expected,actual);
    }

    @Test
    public void littleJerksonStringExpirationDateParserTest3()   {
        String expected = "1/11/2016";
        String actual = stringToItemConverter.littleJerksonStringExpirationDateParser(sampleLittleJerksonString3);
        assertEquals(expected,actual);
    }

    @Test
    public void littleJerksonStringExpirationDateParserTest4()   {
        String expected = "1/17/2016";
        String actual = stringToItemConverter.littleJerksonStringExpirationDateParser(sampleLittleJerksonString4);
        assertEquals(expected,actual);
    }

    @After
    public void takeDown(){
        InputHandler.jerksonExceptions = 0;
    }
}