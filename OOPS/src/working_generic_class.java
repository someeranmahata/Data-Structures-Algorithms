import java.util.*;
class GenericClass<T>{
    T data;
    GenericClass(T data){
      this.data = data;
    }
    public T getData(){
        return data;
    }
}
public class working_generic_class {

    public static void main(String[] args) {
        GenericClass<Integer> intobj = new GenericClass<>(5);
        GenericClass<String> stringobj = new GenericClass<>("hi !!");
        System.out.println("Generic class output: " + intobj.getData());
        System.out.println("Generic class output: " + stringobj.getData());

    }
}
