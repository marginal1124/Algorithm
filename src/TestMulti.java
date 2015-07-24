
public class TestMulti {

	 public static void main(String[] args) {
         Pet dog1 = new Dog();  
         Dog dog2 = new Dog();  

         dog1.show(dog1);      //show:Dog:pet
         dog1.display(dog2);   // display:Pet:pet
         dog2.show(dog1);      //show:Dog:pet
    }
}
class Pet{
    void show(Pet pet){
            System.out.println("show:Pet:pet");
    }

   static void display(Pet Pet){
            System.out.println("display:Pet:pet");
    }
}
class Dog extends Pet{
    //子类重写父类方法
    void show(Pet pet){
            System.out.println("show:Dog:pet");
    }
   void show(Dog dog){
            System.out.println("show:Dog:dog");
    }
    static void display(Pet pet){
            System.out.println("display:Dog:pet");
    }
}
