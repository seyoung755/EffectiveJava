import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.EmptyStackException;

public class Item7 {
}

class Stack {
    private Object[] elements;
    private int size = 0;
    private static final int DEFAULT_INITIAL_CAPACITY = 16;

    public Stack() {
        elements = new Object[DEFAULT_INITIAL_CAPACITY];
    }

    public void push(Object e) {
        ensureCapacity();
        elements[size++] = e; // 현재 size에 원소를 할당하고, size += 1해준다.
    }

    public Object pop() {
        if (size == 0) {
            throw new EmptyStackException();
        }
        Object result = elements[--size]; // 현재 크기가 배열의 size와 동일하기 때문에 size-1을 먼저 수행하여 마지막 원소를 꺼낸다.
        elements[size] = null;
        return result;
    }

    private void ensureCapacity() {
        if (elements.length == size) {
            elements = Arrays.copyOf(elements, 2*size + 1);
        }
    }
}
