
public class SimpleFactory {

	public static void main(String[] args){
		//创建馒头的实例			
		Factory  BreadFac = new BreadFacory();
		
		Ifood bread = BreadFac.creatInstance();
		
		//创建一个stuffed 实例
		
		Factory  stuffedFac = new StuffedFacory();
		
		Ifood stuffed = stuffedFac.creatInstance();
	}

}

/////////////////抽象产品/////////////////////////////

interface  Ifood{
	public double price();
}

//////////////////具体商品////////////////////////////


class Bread implements Ifood{
	
	public Bread(){}
	private double price=0.5;
	
	public double price(){
		return price;
	}
}

class Stuffed implements Ifood{
	
	public Stuffed(){};
	
	private double price=1.0;
	
	public double price(){
		return price;
	}
}

/////////////////抽象工厂//////////////////////////////


interface Factory {
	
	public Ifood creatInstance();
}

/////////////////具体工厂//////////////////////////////

class BreadFacory  implements Factory{
	
	public Bread creatInstance(){
	
		return new Bread();
	}
}

class StuffedFacory  implements Factory{
	
	public Stuffed creatInstance(){
	
		return new Stuffed();
	}
}


