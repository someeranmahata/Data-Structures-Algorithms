
public class stackArrayImplementation {

    static class Stack{
        private int[] ar = new int[5];
        private int ind = -1;

        //push function
        Stack(){

        }
        void push(int data){
            if (isFull())
                return;
            ind++;
            ar[ind] = data;
        }
        //pop function
        int pop(){
            if(isEmpty()){
                System.out.print("Under flow");
                return -1;
            }
            int temp = ar[ind];
            ar[ind] = 0;
            ind--;
            System.out.println(temp);
            return temp;
        }
        boolean isEmpty(){
            return ind <= -1;
        }
        boolean isFull(){
            if(ind == ar.length - 1){
                System.out.println("Stack is full");
                return true;
            }
            return false;
        }
        void display() {
            if (isEmpty()){
                return;
            }
            for(int i = 0; i<=ind; i++){
                System.out.print(ar[i] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args){
        Stack stack = new Stack();
        stack.pop();
        stack.display();

    }

}
