TestRandom
==========

Trivial static methods to create random numbers for testing.

Just do a static import for ...
```java
  import static com.indexoutofbounds.random.Numbers.*;
```
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
        assertTrue(testObject.isFoo(2));
        // which could technically lead to implementation of isEven to look
        // like...
        // return number.intValue() == 2;
        // which would technically pass the test.

        // we could do
        assertTrue(testObject.isFoo(getRandomNumber(1, 5)));
        // which, depeneding on what isFoo needs to do would make our tests less fragile.
    }

    public class TestObject {

        public boolean isFoo(Number number) {
            return false;
        }
    }
}
```
Not the best example but you should be smart enough to get the point.
