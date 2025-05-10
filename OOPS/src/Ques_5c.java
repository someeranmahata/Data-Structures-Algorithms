import java.util.*;
class CreditCard{
    int cardNumber;
    int cardOutstanding;
    final int maxPurchaseLimit;

    CreditCard(int cardNumber, int cardOutstanding, int maxPurchaseLimit){
        this.cardNumber = cardNumber;
        this.cardOutstanding = cardOutstanding;
        this.maxPurchaseLimit = maxPurchaseLimit;
    }
    void purchase(int amount){
        cardOutstanding += amount;
    }
    void display(){
        try{
            if(cardOutstanding > maxPurchaseLimit){
                throw new CreditLimitCrossedException("Insufficient Balance");
            }
        else{
            System.out.println("cardNumber : "+ cardNumber);
            System.out.println("max limit : "+ maxPurchaseLimit);
            System.out.println("card outstanding : "+ cardOutstanding);
            }
        }
        catch(CreditLimitCrossedException ob){
            System.out.println(ob);
        }
    }
}
class CreditLimitCrossedException extends Exception{
    String mesg;
    CreditLimitCrossedException(String mesg){
        this.mesg = mesg;
    }
    public String toString(){
        return mesg;
    }
}
public class Ques_5c {
    public static void main(String[] args) {
        CreditCard ob = new CreditCard(123, 0, 10000);
        ob.purchase(10000);
        ob.display();
        ob.purchase(1);
        ob.display();

    }
}
