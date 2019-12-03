## Reference 
```
Course taken: Practical Test-Driven Development for Java Programmers
```

```
What to test? 
Each test will cover a single scenario for a single piece of logic 

Rules of TDD
1. Test the expected outcome of an example 
2. Don't pre-judge design... let your tests drive it 
3. Write minimum code required to get your tests to pass 
4. Each test should validate one single piece of logic

What is a "good" or "bad" test? 
Red -> Green -> Refactor 
1. A new test will initially 
2. We work to get the test to pass 
3. We finally optimise our code, and tests 

Rules of testing 
test one item of functionality only 
test business logic, not methods 
tests must be repeatable, and consistent 
tests must be thorough
```

```
Mockito Methods 
MyClass myClass = mock(MyClass.class);

when(myClass.myMethod(params)).thenReturn(return-value);

Verify(myClass, times(?)).myMethod(params);
```