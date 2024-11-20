package Task3;


import java.util.LinkedList;
import java.util.Objects;

public class MyStack2<E> {
    private final LinkedList <E> elements;
    private int size = 0;

    MyStack2() {
        this.elements = new LinkedList<>();
    }
    MyStack2(LinkedList<E> elements) {
        this.elements = new LinkedList<>(elements);
        this.size = elements.size();
    }
    MyStack2(MyStack2<E> other) {
        this.elements = new LinkedList<>(other.elements);
        this.size = other.size;
    }
    void push (E elem){
        elements.add(elem);
        this.size++;
    }
    E pop (){
        if(!this.isEmpty()){
            E elem = elements.removeLast();
            this.size--;
            return elem;
        }
        throw new IllegalStateException("Стек пустий");
    }

    public boolean isEmpty() {
        return size == 0;
    }
    public void addAll( MyStack2<? extends E> other){ // дозволяє працювати з типами, які успадковують E
        while(!other.isEmpty()){
            this.push(other.pop());
        }
    }
    public void moveElementsTo( MyStack2<? super E> other){ // дозволяє працювати з типами, які є суперкласами E
        while(!isEmpty()){
            other.push(this.pop());
        }
    }
    @Override
    public boolean equals(Object other) {
        if (other == null || getClass() != other.getClass()) return false;
        MyStack2<?> myStack = (MyStack2<?>) other;
        return size == myStack.size && Objects.equals(elements, myStack.elements);
    }

    @Override
    public int hashCode() {
        if (size == 0) return 0;
        int hash = 0;
        for (E element : elements) {
            hash = hash * 5 + element.hashCode() + 7;
        }
        return hash;
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
    public MyStack2<E> copy() {
        return new MyStack2<>(this);
    }

    public int getSize() {
        return this.size;
    }

}
