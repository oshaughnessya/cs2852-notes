package oshaughnessya.week2;

import org.junit.jupiter.api.*;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {
    private List<String> list;

    @BeforeEach
    void setUp() {
        list = new LinkedList<>();
    }

    @AfterEach
    void tearDown() {
        list = null;
    }

    @Test
    void size() {
        assertEquals(0, list.size());
        list.add("one");
        assertEquals(1, list.size());
    }

    @Test
    void isEmpty() {
        assertTrue(list.isEmpty());
        list.add("one");
        assertFalse(list.isEmpty());
    }

    @Test
    void add() {
        list.add("one");
        assertEquals(1, list.size());
        list.add("two");
        assertEquals(2, list.size());
    }

    @Test
    void clear() {
        list.clear();
        assertTrue(list.isEmpty());
        list.add("one");
        list.clear();
        assertTrue(list.isEmpty());
        list.add("one");
        list.add("one");
        list.add("one");
        list.clear();
        assertTrue(list.isEmpty());
    }

    @Test
    void addInt() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(1, null));
        assertThrows(IndexOutOfBoundsException.class, () -> list.add(-1, null));

        list.add(0, "one");
        assertEquals(1, list.size());

        list.add(0, "two");
        assertEquals(1, list.indexOf("one"));
        assertEquals(0, list.indexOf("two"));

        list.add(2, "three");
        assertEquals(2, list.indexOf("three"));
        assertEquals(1, list.indexOf("one"));
        assertEquals(0, list.indexOf("two"));

        list.add(1, "four");
        assertEquals(1, list.indexOf("four"));
        assertEquals(3, list.indexOf("three"));
        assertEquals(2, list.indexOf("one"));
        assertEquals(0, list.indexOf("two"));
    }

    @Test
    void contains() {
        list.add("one");
        list.add("two");
        list.add("three");
        list.add(null);
        assertFalse(list.contains(""));
        assertTrue(list.contains("two"));
        assertTrue(list.contains(null));
        assertFalse(list.contains(3));
    }

    @Test
    void get() {
        list.add("one");
        list.add("two");
        list.add("three");
        assertEquals("one", list.get(0));
        assertEquals("two", list.get(1));
        assertEquals("three", list.get(2));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(3));
        assertThrows(IndexOutOfBoundsException.class, () -> list.get(-1));
    }

    @Test
    void set() {
        list.add("one");
        list.add("two");
        list.add("three");
        list.set(0, "1");
        assertEquals("1", list.get(0));
        list.set(2, "3");
        assertEquals("3", list.get(2));
        list.set(2, null);
        assertNull(list.get(2));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(3, ""));
        assertThrows(IndexOutOfBoundsException.class, () -> list.set(-1, ""));
    }

    @Test
    void remove() {
        assertFalse(list.remove(""));
        assertFalse(list.remove("two"));
        list.add("one");
        list.add("two");
        list.add("three");
        assertTrue(list.remove("two"));
        assertFalse(list.remove("two"));
    }

    @Test
    void removeIntBad() {
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(0));
        list.add("one");
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(-1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(1));
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(3));
    }

    @Test
    void removeIntFirst() {
        list.add("one");
        assertEquals("one", list.remove(0));
        list.add("one");
        list.add("two");
        assertEquals("two", list.remove(1));
        assertFalse(list.contains("two"));
        assertTrue(list.contains("one"));
        assertEquals("one", list.remove(0));
        assertFalse(list.contains("one"));
    }

    @Test
    void removeIntLast() {
        list.add("one");
        list.add("two");
        list.add("three");
        assertThrows(IndexOutOfBoundsException.class, () -> list.remove(3));
        assertEquals("three", list.remove(2));
        assertFalse(list.contains("three"));
        assertTrue(list.contains("two"));
        assertEquals("two", list.remove(1));
        assertTrue(list.contains("one"));
    }

    @Test
    void removeIntNull() {
        list.add(null);
        assertNull(list.remove(0));
        assertEquals(0, list.size());
    }

    @Test
    void indexOf() {
        assertEquals(-1, list.indexOf("not found"));
        list.add("one");
        list.add("two");
        list.add("three");
        list.add(null);
        assertEquals(-1, list.indexOf(""));
        assertEquals(1, list.indexOf("two"));
        assertEquals(3, list.indexOf(null));
        assertEquals(-1, list.indexOf(3));
    }

    @Test
    void toArray() {
        list.add("one");
        list.add("two");
        list.add("three");
        Object[] expected = {"one", "two", "three"};
        assertArrayEquals(expected, list.toArray());
    }

    @Test
    void toArrayEmpty() {
        Object[] expected = {};
        assertArrayEquals(expected, list.toArray());
    }
}