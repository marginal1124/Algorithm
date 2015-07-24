/*
 * 装饰模式
 * 
 * */
public class Decorate {

	public static void main(String[] args) {
		
		  Beverage beverage = new CoffeeBean1(); 

		  beverage = new Mocha(beverage);
		  beverage = new Milk(beverage);
		  System.out.println(beverage.getDescription()+"\n加了摩卡和牛奶的咖啡价格："+beverage.getPrice());  
	}
}	
	
/************************  1 ***************************/
	
	/*
	 * component 抽象构件角色
	 * 
	 * 饮料接口
	 * */
	 interface Beverage{
		//返回商品描述
		 public String getDescription();
		 //返回价格
		 public double getPrice();
	}
	
	
/***********************   2   **************************/
	
	/*
	 * ConcreteComponent 具体构件角色
	 * 
	 * 具体被装饰的类对象
	 * */
	
	//第一种咖啡豆
	 class CoffeeBean1  implements Beverage{
		 private String des = "选了第1种咖啡豆";
		 public String getDescription(){
			 return des;
		 }
		
		 public double getPrice(){
			 return 30;
		 }		
	}
	
	//第二种咖啡豆
	class CoffeeBean2  implements Beverage{
		 private String des = "选了第2种咖啡豆";
		 public String getDescription(){
			 return des;
		 }
		
		 public double getPrice(){
			 return 60;
		 }		
	}
	
	
/**********************  3  *************************/	
	
	/*
	 * Decorator 装饰类
	 * 持有一个构件(Component)对象的实例，并定义一个与抽象构件接口一致的接口
	 * 
	 * */
	
	class Decorator implements Beverage{
		 private String des = "装饰器";
		 public String getDescription(){
			 return des;
		 }
		
		 public double getPrice(){
			 //装饰器，没有价格，价格由豆子来定
			 return 0;
		 }		
	}
	

/************************   4   **************************/
	
	
	/*
	 * ConcreteDecorator 具体装饰类
	 * 
	 * 给构件对象“贴上”附加的责任
	 * 
	 * */
	//装饰类1
	
	class Milk extends Decorator{
		 private String des = "加了牛奶";
		 private Beverage  beverage = null;
		 public Milk(Beverage  beverage){
			 this.beverage = beverage;
		 }
		 
		 public String getDescription(){
			 return beverage.getDescription()+"----"+ des;
		 }
		
		 public double getPrice(){
			 
			 return beverage.getPrice()+20;//牛奶20
		 }	
	}
	
	//装饰类2
	
	class Mocha extends Decorator{
		 private String des = "加了摩卡";
		 private Beverage  beverage = null;
		 public Mocha(Beverage  beverage){
			 this.beverage = beverage;
		 }
		 
		 public String getDescription(){
			 return beverage.getDescription()+"----"+ des;
		 }
		
		 public double getPrice(){
			 
			 return beverage.getPrice()+40;
		 }	
	}
	

