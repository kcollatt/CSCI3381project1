package Project_1;

import java.util.Random;

public class Tester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		
		// test creating productcollection from scratch
				Product p1 = new Product();
				System.out.println(p1);
				Product p2 = new Product("Red Grapes ","100 ","25 oz ","Grapes ","grape1.png ","5 ");
				System.out.println(p2);
				ProductCollection myData = new ProductCollection();
				System.out.println(myData);
				myData.addProduct(p1);
				myData.addProduct(p2);
		
		//add from text file
				ProductCollection Apples = new ProductCollection("./project_1/Project_1/inventory.txt");
				System.out.print("\ntest reading text file--");
				System.out.println(Apples);
				//Apples.addProduct(p4);
				
				
				//add extra products
				Product p3 = new Product("Granny Smith ","101 ","8 oz ","Apples ","apple1.png ","8 ");
				Product p4 = new Product("Green Grapes ","102 ","20 oz ","Grapes ","grape2.png ","12 ");
				Product p5 = new Product("Cutie ","103 ","5 oz ","Oranges ","orange1.png ","30 ");
				
				System.out.println("\ntest combined data from file and data added manually");
				System.out.println(Apples);		
				Apples.writeFile("./project_1/Project_1/inventory.txt");
				
				ProductCollection testWrite = new ProductCollection("./project_1/Project_1/inventory.txt");
				System.out.println("\ntest reading just created file");
				System.out.println(testWrite);
				
				
				
	}

}
