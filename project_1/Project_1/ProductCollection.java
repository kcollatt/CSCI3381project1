package Project_1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class ProductCollection {

	

	private int size;
	private static final int DEFAULT_SIZE = 10;
	private Product[] myData;
	private String collectionName;
	private String fileName;

	public ProductCollection() {
		// default constructor
		size = 0;
		myData = new Product[DEFAULT_SIZE];
		collectionName = "a collection";
		fileName = null;
		
	}
	public ProductCollection(String fn) {
		// constructor with given course name and input file
		this();
		fileName = fn;
		readFile();
		
	}	
	
	public void addProduct(Product p) {
		// method that adds the input Product to the myData array
		if (size >= myData.length)
			doubleArray();
		myData[size] = p;
		size++;
	}
	
	private void doubleArray () {
		// private method used to double the size of the array when needed
		Product[] newProduct = new Product[myData.length*2];
		for (int i = 0; i < size; i++) {
			newProduct[i] = myData[i];
		}		
		myData = newProduct;
	}
	
	public String toString() {
		// returns a string representation of this collection
		String toReturn = collectionName+"\n";
		for (int i = 0; i < size; i++) {
			if (myData[i] instanceof Product)
				toReturn += "Product:  "+myData[i]+"\n";
		}
		return toReturn;
	}
	
	public void removeProduct (String id) {
		// method that removes the product from the array with the input id decrement size

		for(int i=0; i<size; i++){
			if(myData[i].getId().equals(id)){
				for(int j=i; j<size-1; j++){
					myData[j] = myData[j+1];
				}
				size--;
			}
		}
		
	}
	
	
	
	private void readFile () {
		BufferedReader lineReader = null;
		try {
			FileReader fr = new FileReader(fileName);
			lineReader = new BufferedReader(fr);
			String line = null;
			while ((line = lineReader.readLine())!=null) {
				String name = lineReader.readLine();
				String id = lineReader.readLine();
				String size2 = lineReader.readLine();
				String collection = lineReader.readLine();
				String image = lineReader.readLine();
				String quantity = lineReader.readLine();
				
					addProduct(new Product(name,id,size2,collection,image,quantity));
				
			}
		} catch (Exception e) {
			System.err.println("there was a problem with the file reader, try different read type.");
			try {
				lineReader = new BufferedReader(new InputStreamReader(this.getClass().getResourceAsStream(fileName.substring(1))));
				String line = null;
				while ((line = lineReader.readLine())!=null) {
					String name = lineReader.readLine();
					String id = lineReader.readLine();
					String size2 = lineReader.readLine();
					String collection = lineReader.readLine();
					String image = lineReader.readLine();
					String quantity = lineReader.readLine();
					
						addProduct(new Product(name,id,size2,collection,image,quantity));
					
					}
			} catch (Exception e2) {
				System.err.println("there was a problem with the file reader, try again.  either no such file or format error");
			} finally {
				if (lineReader != null)
					try {
						lineReader.close();
					} catch (IOException e2) {
						System.err.println("could not close BufferedReader");
					}
			}			
		} finally {
			if (lineReader != null)
				try {
					lineReader.close();
				} catch (IOException e) {
					System.err.println("could not close BufferedReader");
				}
		}
	} // end of readFile method	
	
	
	
	
	
		
	public void writeFile () {
		// overloaded method: this calls doWrite with file used to read data
		// use this for saving data between runs
		doWrite(fileName);
	} // end of writeFile method

	public void writeFile(String altFileName) {
		// overloaded method: this calls doWrite with different file name 
		// use this for testing write
		doWrite(altFileName);		
	}// end of writeFile method

	private void doWrite(String fn) {
		// this method writes all of the data in the persons array to a file
		try
		{

			FileWriter fw = new FileWriter(fn);
			BufferedWriter myOutfile = new BufferedWriter(fw);			

			for (int i = 0; i < size; i++) {
				Product product1 = myData[i];
				if (product1 instanceof Product) {
					myOutfile.write ("product\n");
					myOutfile.write (product1.getName()+"\n");
					myOutfile.write (product1.getId()+"\n");
					myOutfile.write (((Product) product1).getSize()+"\n");
					myOutfile.write (product1.getCollection()+"\n");
					myOutfile.write (product1.getImage()+"\n");
					myOutfile.write (product1.getQuantity()+"\n");
				}	
				else {
					System.err.println("error in array, instance type not found");
				}
			}
			myOutfile.flush();
			myOutfile.close();
		}
		catch (Exception e) {
			e.printStackTrace();
			System.err.println("Didn't save to " + fn);
		}
	}	
		
		
}
