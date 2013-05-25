TestRandom
==========

Trivial static methods to create random numbers for testing.

Just do a static import for ...
        import static com.indexoutofbounds.random.Numbers.*;
And that's it.

```java
public class DemoTest {

    private TestObject testObject;

    @Before
    public void setUp() {
        testObject = new TestObject();
    }

    @Test
    public void testSomething() {
        // Pretend we're driving out the design for the TestObject below.
        // Insted of writing tests like
        assertTrue(testObject.isEven(2));
        // which could technically lead to implementation of isEven to look
        // like...
        // return number.intValue() == 2;
        // which would technically pass the test.

        // we could do
        assertTrue(testObject.isEven(getRandomNumber(1, 5)));
    }

    public class TestObject {

        public boolean isEven(Number number) {
            return false;
        }
    }
}
```