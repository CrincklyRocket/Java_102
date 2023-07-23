import java.util.Arrays;

public class MyList<T> {
    private T[] list;
    private int capacity;
    private int size = 0;
    private T[] tempList;
    @SuppressWarnings("unchecked")
    public MyList() {
        this.list = (T[]) new Object[10];
        this.capacity = 10;
    }//Constructor method 1
    @SuppressWarnings("unchecked")
    public MyList(int capacity) {
        this.list = (T[]) new Object[capacity];
        this.capacity = capacity;
    }//Constructor method 2

    public void add(T input){
        if(isFull()){
            doubleCapacity();
        }else {
            list[getSize()] = input;
            setSizePlusOne();
        }
    }

    public int getCapacity(){
        return this.capacity;
    }
    @SuppressWarnings("unchecked")
    public void doubleCapacity() {
        this.capacity *= 2;
        this.list = (T[]) new Object[capacity];
    }

    public int getSize() {
        return this.size;
    }
    public void setSizePlusOne() {
        this.size += 1 ;
    }

    public boolean isFull(){
        return getSize() == getCapacity();
    }//Controlling if Capacity is full

    public T get(int index){
        if (index < 0 && index >= this.capacity){
            return null;
        }else
            return list[index];
    }

    public void remove(int index){
        if (index < 0 && index >= this.capacity){
           System.out.println("null");
        }else{
           for (int i = index; i < capacity - 1; i++) {
               list[i] = list[i + 1];
           }
        }
    }

    public String toString(){
        System.out.print("[");
        for (int i = 0; i < capacity; i++){
            if (i > 0)
                System.out.print(", ");
            System.out.print(list[i]);
        }
        System.out.println("]");
        return "";
    }

    public void set(int index, T newInput){
        if (index < 0 && index >= this.capacity){
            System.out.println("null");
        }else
            list[index] = newInput;
    }
    public int indexOf(T input){
        for (int i = 0; i < capacity; i++){
            if (input.equals(list[i])){
                return i;
            }
        }
        return -1;
    }
    public int lastIndexOf(T input) {
        for (int i = list.length - 1; i >= 0; i--) {
            if (input.equals(list[i])) {
                return i;
            }
        }
        return -1;
    }
    public boolean isEmpty(){
        return size == 0;
    }
    public void clear(){
        Arrays.fill(list, null);
    }
    public Object[] toArray(){
        Object[] tempObject =new Object[this.list.length];
        for (int i =0;i<this.list.length;i++){
            tempObject[i] = this.list[i];
        }
        return tempObject;
    }
    public MyList<T> sublist(int start, int finish){
        if(start < finish) {
            MyList<T> tempList = new MyList<>(finish - start );
            while (start < finish) {
                tempList.add(this.list[start]);
                start++;
            }
            return tempList;
        }else
            return null;
    }
    boolean contains(T input){
        for(int i = 0 ; i < capacity; i++){
            if (input == list[i]){
                return true;
            }
        }
        return false;
    }
    
}
