public abstract class AbstractQueue implements Queue{

    private int size;
    
    public int size(){
       return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

}
