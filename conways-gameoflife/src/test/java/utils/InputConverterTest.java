package utils;

import grid.Coordinate;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.Assert.assertEquals;

public class InputConverterTest {
    @Test
    public void shouldReturnExpectedListCoordinates_WhenConverted() {
        ArrayList<Coordinate> expectedCoordinates = new ArrayList<>(Arrays.asList(
                new Coordinate(1, 2),
                new Coordinate(2,3)));

        assertEquals(expectedCoordinates, InputConverter.parseInputToCoordinates("2,3 3,4"));
    }
}
