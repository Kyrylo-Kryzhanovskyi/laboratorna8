package Task2;


import java.util.LinkedList;
import java.util.Objects;

public class MyStack<E extends Comparable<E>> implements Comparable<MyStack<E>> {
    private final LinkedList <E> elements;
    private int size = 0;

    MyStack() {
        this.elements = new LinkedList<>();
    }
    MyStack(LinkedList<E> elements) {
        this.elements = new LinkedList<>(elements);
        this.size = elements.size();
    }
    MyStack(MyStack<E> other) {
        this.elements = new LinkedList<>(other.elements);
        this.size = other.size;
    }
    void push (E elem){
        elements.add(elem);
        this.size++;
    }
    E pop (){
        if(!isEmpty()){
            E elem = elements.removeLast();
            this.size--;
            return elem;
        }
        throw new IllegalStateException("Стек пустий");
    }
    public boolean isEmpty() {
        return size == 0;
    }
    @Override
    public int compareTo(MyStack other) {
        if (this.size != other.size) {
            return Integer.compare(this.size, other.size);
        }
        for (int i = this.size - 1; i >= 0; i--) {
            E current = this.elements.get(i);
                if(current instanceof Number && other.elements.get(i) instanceof Number){
                    if(((Number) current).doubleValue()!= 0){
                        return Double.compare(((Number) current).doubleValue(), ((Number) other.elements.get(i)).doubleValue());
                    }
                }
                else if(current instanceof String && other.elements.get(i) instanceof String){
                    return current.toString().length() - other.elements.get(i).toString().length();
                    //return current.toString().compareTo(other.elements.get(i).toString());
                }
                else{
                    return -42;
                }

            }

        return 0;
    }

    @Override
    public boolean equals(Object other) {
        if (other == null || getClass() != other.getClass()) return false;
        MyStack<?> myStack = (MyStack<?>) other;
        return size == myStack.size && Objects.equals(elements, myStack.elements);
    }

    @Override
    public int hashCode() {
        return Objects.hash(elements, size);
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append("\nMyStack з ").append(getSize()).append(" елементами\n");
        for (E elem : elements.reversed()) {
            builder.append(String.format("|%6s|\n",elem));
        }
        builder.append(String.valueOf('^').repeat(8)).append('\n');
        return builder.toString();
    }
    public MyStack<E> copy() {
        return new MyStack<>(this);
    }

    public int getSize() {
        return this.size;
    }

}
