
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class RleProgramTest {

    @Test
    public void toHexStringTest() {
        byte[] test = {1,15,13,2,6,7};
        String expected = "1fd267";

        assertEquals(expected, RleProgram.toHexString(test));

    }
    @Test
    public void countRunsTest() {
        byte[] flatData = {1,2,3,4,5,1,2,3,4,5,1,2,3,4,5,1,2,3,4,5,1,2,3,4,5};
        int expected = 25;

        assertEquals(expected, RleProgram.countRuns(flatData));

    }

    @Test
    public void encodeRleTest() {
        byte[] flatData = {1,2,3,4,1,2,3,4};

        byte[] expected = {1,1,1,2,1,3,1,4,1,1,1,2,1,3,1,4};

        byte[] actual = RleProgram.encodeRle(flatData);

        assertArrayEquals(expected, actual);
    }

    @Test
    public void getDecodedLengthTest() {
        byte[] rleData = {8, 15, 6, 4, 2, 6, 15, 3, 15, 6, 0, 8};

        int expected = 46;

        assertEquals(expected, RleProgram.getDecodedLength(rleData));
    }

    @Test
    public void decodeRleTest() {
        byte[] rleData = {2,4,15,1,15,1,5,1,1,8,1,7};

        byte[] expected = {4,4,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,1,8,7};

        assertArrayEquals(expected, RleProgram.decodeRle(rleData));
    }

    @Test
    public void stringToDataTest() {
        String rleData = "3f64";

        byte[] expected = {3, 15, 6, 4};

        assertArrayEquals(expected, RleProgram.stringToData(rleData));
    }

    @Test
    public void toRleStringTest() {
        byte [] rleData = {15, 15, 6, 4};

        String expected = "15f:64";

        assertEquals(expected, RleProgram.toRleString(rleData));
    }

    @Test
    public void stringToRleTest() {
        String rleString = "19:14:151:151:61";

        byte[] expected = {1, 9, 1, 4, 15, 1, 15, 1, 6, 1};

        assertArrayEquals(expected, RleProgram.stringToRle(rleString));
    }





}

