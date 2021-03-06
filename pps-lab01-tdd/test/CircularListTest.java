import lab01.tdd.CircularList;
import lab01.tdd.CircularListImpl;
import lab01.tdd.StrategyFactoryImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.stream.IntStream;

import static org.junit.jupiter.api.Assertions.*;

/**
 * The test suite for testing the CircularList implementation
 */
public class CircularListTest {
    private CircularList list;
    private final StrategyFactoryImpl factory = new StrategyFactoryImpl();

    @BeforeEach
    public void beforeEach() {
        list = new CircularListImpl();
    }

    @Test
    public void addElement() {
        IntStream.range(0, 6).forEach(list::add);
        list.add(0);
        assertEquals(7, list.size());
    }

    @Test
    public void addMultipleElement() {
        IntStream.range(0, 6).forEach(list::add);
        list.add(0);
        list.add(1);
        assertEquals(8, list.size());
    }

    @Test
    public void testIsEmpty() {
        assertTrue(list.isEmpty());
    }

    @Test
    public void testIsNotEmpty() {
        IntStream.range(0, 6).forEach(list::add);
        assertFalse(list.isEmpty());
    }

    @Test
    public void nextElementTest() {
        IntStream.range(0, 6).forEach(list::add);
        list.next().ifPresentOrElse(i -> assertEquals(0, i), () -> fail("test fail"));
    }

    @Test
    public void nextOnCircular() {
        IntStream.range(0, 6).forEach(list::add);
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
        IntStream.range(0, 6).forEach(list::add);
        list.previous().ifPresentOrElse(i -> assertEquals(0, i), () -> fail("Test fail"));
    }

    @Test
    public void prevOnCircular() {
        IntStream.range(0, 6).forEach(list::add);
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
        IntStream.range(0, 6).forEach(list::add);
        list.next().ifPresentOrElse(i -> assertEquals(0, i), () -> fail("Test fail"));
        list.next().ifPresentOrElse(i -> assertEquals(1, i), () -> fail("Test fail"));
        list.reset();
        list.next().ifPresentOrElse(i -> assertEquals(0, i), () -> fail("Test fail"));
        list.next().ifPresentOrElse(i -> assertEquals(1, i), () -> fail("Test fail"));
    }

    @Test
    public void evenStrategy() {
        IntStream.range(0, 6).forEach(list::add);
        list.next();
        list.next(factory.getEvenStrategy()).ifPresentOrElse(i -> assertEquals(2, i), () -> fail("Test fail"));
    }

    @Test
    public void equalStrategy() {
        IntStream.range(0, 6).forEach(list::add);
        list.next(factory.getEqualStrategy(5)).ifPresentOrElse(i -> assertEquals(5, i), () -> fail("Test fail"));
    }

    @Test
    public void multipleOfStrategy() {
        IntStream.range(0, 6).forEach(list::add);
        list.next();
        list.next();
        list.next();
        list.next(factory.getMultipleOfStrategy(2)).ifPresentOrElse(i -> assertEquals(4, i), () -> fail("Test Fail"));
    }

    @Test
    public void noMatchingStrategy() {
        IntStream.range(0, 6).forEach(list::add);
        list.next(factory.getEqualStrategy(15)).ifPresentOrElse(i -> fail("No match element should found"), () -> { });
    }
}
