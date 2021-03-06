import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import lab01.tdd.StrategyFactoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {
    private CircularList list;
    private final StrategyFactoryImpl factory = new StrategyFactoryImpl();
    private static final List<Integer> EXAMPLE_LIST = List.of(0, 1, 2, 3, 4, 5);
    private static final List<Integer> SINGLE_ELEMENT_LIST = List.of(1);
    private static final int EXPECTED_LIST_SIZE = 6;

    @BeforeEach
    public void beforeEach() {
        list = new CircularListImpl();
    }

    @Test
    public void addElement() {
        addElementsToList(EXAMPLE_LIST);
        list.add(0);
        assertEquals(EXPECTED_LIST_SIZE + 1, list.size());
    }

    @Test
    public void addMultipleElement() {
        addElementsToList(EXAMPLE_LIST);
        list.add(0);
        list.add(1);
        assertEquals(EXPECTED_LIST_SIZE + 2, list.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
    }

    @Test
    public void testIsNotEmpty() {
        addElementsToList(EXAMPLE_LIST);
        assertFalse(list.isEmpty());
    }

    @Test
    public void nextElementTest() {
        addElementsToList(EXAMPLE_LIST);
        list.next().ifPresentOrElse(i -> assertEquals(0, i), () -> fail("test fail"));
    }

    @Test
    public void nextOnSingleElement() {
        addElementsToList(SINGLE_ELEMENT_LIST);
        list.next().ifPresentOrElse(i -> assertEquals(1, i), () -> fail("Test fail"));
    }

    @Test
    public void nextOnCircular() {
        addElementsToList(EXAMPLE_LIST);
        IntStream.range(0, 5).forEach(i -> list.next());
        list.next().ifPresentOrElse(i -> assertEquals(5, i), () -> fail("Test fail"));
        list.next().ifPresentOrElse(i -> assertEquals(0, i), () -> fail("Test fail"));
    }

    @Test
    public void nextOnEmptyList() {
        list.next().ifPresentOrElse(i -> fail("No element should be present"), () -> {});
    }

    @Test
    public void prevElementTest() {
        addElementsToList(EXAMPLE_LIST);
        list.previous().ifPresentOrElse(i -> assertEquals(0, i), () -> fail("Test fail"));
    }

    @Test
    public void prevOnSingleElement() {
        addElementsToList(SINGLE_ELEMENT_LIST);
        list.previous().ifPresentOrElse(i -> assertEquals(1, i), () -> fail("Test Fail"));
    }

    @Test
    public void prevOnCircular() {
        addElementsToList(EXAMPLE_LIST);
        list.previous();
        list.previous().ifPresentOrElse(i -> assertEquals(5, i), () -> fail("Test fail"));
        list.previous().ifPresentOrElse(i -> assertEquals(4, i), () -> fail("Test fail"));
    }

    @Test
    public void prevOnEmptyList() {
        list.previous().ifPresentOrElse(i -> fail("No element should be present"), () -> {});
    }

    @Test
    public void resetCursor() {
        addElementsToList(EXAMPLE_LIST);
        list.next().ifPresentOrElse(i -> assertEquals(0, i), () -> fail("Test fail"));
        list.next().ifPresentOrElse(i -> assertEquals(1, i), () -> fail("Test fail"));
        list.reset();
        list.next().ifPresentOrElse(i -> assertEquals(0, i), () -> fail("Test fail"));
        list.next().ifPresentOrElse(i -> assertEquals(1, i), () -> fail("Test fail"));
    }

    @Test
    public void evenStrategy() {
        addElementsToList(EXAMPLE_LIST);
        list.next();
        list.next(factory.getEvenStrategy()).ifPresentOrElse(i -> assertEquals(2, i), () -> fail("Test fail"));
    }

    @Test
    public void equalStrategy() {
        addElementsToList(EXAMPLE_LIST);
        list.next(factory.getEqualStrategy(5)).ifPresentOrElse(i -> assertEquals(5, i), () -> fail("Test fail"));
    }

    @Test
    public void multipleOfStrategy() {
        addElementsToList(EXAMPLE_LIST);
        list.next();
        list.next();
        list.next();
        list.next(factory.getMultipleOfStrategy(2)).ifPresentOrElse(i -> assertEquals(4, i), () -> fail("Test Fail"));
    }

    @Test
    public void noMatchingStrategy() {
        addElementsToList(EXAMPLE_LIST);
        list.next(factory.getEqualStrategy(15)).ifPresentOrElse(i -> fail("No match element should found"), () -> { });
    }

    private void addElementsToList(List<Integer> newList) {
        newList.forEach(this.list::add);
    }
}
