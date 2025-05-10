import java.util.LinkedList;

public class Main {

    public static void main(String[] args){

        linklist LL = new linklist();

        LL.firstInsert(-4);
        LL.firstInsert(0);
        LL.firstInsert(2);
        LL.firstInsert(3);



        LL.display();

        linklist LL2 = new linklist();
        LL2.firstInsert(1);
        LL.display();

//        LL.insertAt(20, 3);
//        LL.display();
//        System.out.println(LL.deleteFist());
//        LL.display();
//        System.out.println(LL.deleteLast());
//        LL.display();
//        System.out.println(LL.getIndex(30));
//        System.out.println(LL.delete(30));
//        LL.display();
        LL.reorderList(LL.get(0));
        LL.display();

    }
}
