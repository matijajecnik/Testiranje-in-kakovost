package ltpo.Seznami;

import org.junit.*;
import static org.junit.Assert.*;

public class SkladTest {

    static Sklad<String> instance;

    public SkladTest() {
    }

    @BeforeClass
    public static void setUpOnce() {
        instance = new Sklad<>();
    } 

    @Before
    public void setUp() {
        while (!instance.isEmpty()) {
            instance.pop();
        }
    }

    @Test
    public void testPush() {
        String a = "Test";
        instance.push(a);
    }

    @Test
    public void testPop() {
        String a = "Test";
        instance.push(a);
        String b = instance.pop();
        assertEquals("Test", b);
    }

    @Test
    public void testWithTwoElements() {
        String a = "Prvi element";
        String b = "Drugi element";
        instance.push(a);
        instance.push(b);
        assertEquals(b, instance.pop());
        assertEquals(a, instance.pop());
    }

    @Test(expected = java.util.NoSuchElementException.class)
    public void testPopOnEmptyStack() {
        String a = instance.pop();
    }

    @Test
    public void testIsEmptyOnEmpty() {
        assertTrue(instance.isEmpty());
    }

    @Test
    public void testIsEmptyOnFull() {
        instance.push("Test");
        assertFalse(instance.isEmpty());
    }

    @Test(expected = java.util.NoSuchElementException.class)
    public void testTopOnEmptyStack() {
        String a = instance.top();
    }

    @Test
    public void testTopOnFullStack() {
        String a = "Vrednost 1";
        String b = "Vrednost 2";
        instance.push(a);
        instance.push(b);
        String c = instance.top();
        assertEquals(c, b);
        assertEquals(2, instance.size());
    }

    @Test
    public void testTopSame() {
        instance.push("Test1");
        instance.push("Test2");
        instance.push("Test3");
        assertEquals("Test3", instance.top());
        assertEquals("Test3", instance.pop());
        assertEquals("Test2", instance.pop());
        assertEquals(1, instance.size());
        assertEquals("Test1", instance.pop());
        assertTrue(instance.isEmpty());
    }

    @Test
    public void testSizeEmpty() {
        assertEquals(0, instance.size());
        assertTrue(instance.isEmpty());
    }

    @Test
    public void testSizeOne() {
        instance.push("Test1");
        assertEquals(1, instance.size());
        assertEquals("Test1", instance.pop());
        assertTrue(instance.isEmpty());
    }

    @Test(timeout = 100)
    public void testSizeMore() {
        instance.push("Vrednost 1");
        instance.push("Vrednost 2");
        instance.push("Vrednost 3");
        assertEquals(3, instance.size());
        assertEquals("Vrednost 3", instance.top());
    }

    @Test
    public void testIsTopTrue() {
        instance.push("Test");
        assertTrue(instance.isTop("Test"));
    }

    @Test
    public void testIsTopFalse() {
        instance.push("Test1");
        assertFalse(instance.isTop("Test2"));
    }

    @Test(expected = java.util.NoSuchElementException.class)
    public void testIsTopEmpty() {
        assertFalse(instance.isTop("Test"));
    }

    @Test
    public void testIsTopSame() {
        instance.push("Test1");
        instance.push("Test2");
        instance.push("Test3");
        assertTrue(instance.isTop("Test3"));
        assertEquals("Test3", instance.pop());
        assertEquals("Test2", instance.pop());
        assertEquals("Test1", instance.pop());
        assertTrue(instance.isEmpty());
    }

    @Test
    public void testSearchEmpty() {
        assertEquals(-1, instance.search("Test"));
    }

    @Test(timeout = 100)
    public void testSearchFoundTop() {
        instance.push("Vrednost 1");
        instance.push("Vrednost 2");
        instance.push("Vrednost 3");
        assertEquals(0, instance.search("Vrednost 3"));
    }

    @Test(timeout = 100)
    public void testSearchFoundNonTop() {
        instance.push("Vrednost 1");
        instance.push("Vrednost 2");
        instance.push("Vrednost 3");
        assertEquals(2, instance.search("Vrednost 1"));
    }

    @Test(timeout = 100)
    public void testSearchNotFound() {
        instance.push("Vrednost 1");
        instance.push("Vrednost 2");
        instance.push("Vrednost 3");
        assertEquals(-1, instance.search("Vrednost"));
    }

    @Test
    public void testSearchSame() {
        instance.push("Test1");
        instance.push("Test2");
        instance.push("Test3");
        assertEquals(1, instance.search("Test2"));
        assertEquals("Test3", instance.pop());
        assertEquals("Test2", instance.pop());
        assertEquals("Test1", instance.pop());
        assertTrue(instance.isEmpty());
    }

}
