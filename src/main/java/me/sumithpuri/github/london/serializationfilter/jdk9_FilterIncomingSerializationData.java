package me.sumithpuri.github.london.serializationfilter;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import me.sumithpuri.github.london.serializationfilter.filter.jdk9_ItemCatalogFilter;
import me.sumithpuri.github.london.serializationfilter.vo.jdk9_CatalogCustomer;

/**
 * MIT License
 *
 * Copyright (c) 2018-19,	Sumith Kumar Puri

 * GitHub URL 			https://github.com/sumithpuri
 * Blog Post URL		http://www.techilashots.com/2018/09/java-se-9-whats-new-code-samples-0202.html	
 * Blog Short URL		https://goo.gl/r1LQda
 * Package Prefix 		me.sumithpuri.github.london
 * Project Codename		london
 * Contact E-Mail		code@sumithpuri.me
 * Contact WhatsApp		+91 9591497974
 *
 *
 * Permission is hereby  granted,  free  of  charge, to  any person  obtaining a  copy of  this  software and associated 
 * documentation files (the "Software"), to deal in the  Software without  restriction, including without limitation the 
 * rights to use, copy, modify, merge, publish, distribute, sublicense,and/or sell copies of the Software, and to permit 
 * persons to whom the Software is furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in  all copies or substantial portions of the 
 * Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS  OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE 
 * WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR 
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES  OR  OTHER  LIABILITY, WHETHER IN AN ACTION  OF  CONTRACT, TORT OR 
 * OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

/*
 * Used to Demonstrate Serialization / De-Serialization (Filters in Java 9). 
 *
 */
public class jdk9_FilterIncomingSerializationData {

	
	public void serializeData() {
		
		try {
			
			//you may chose a simpler path as well, ideally a relative path or load from a properties file
			String incomingSerialFile = "src\\main\\java\\me\\sumithpuri\\github\\london"
														+ "\\serializationfilter\\file\\jdk9_catalog_customer.txt";


			File file = new File(incomingSerialFile);
			file.createNewFile();
			// Store Serialized User Object in File
			FileOutputStream fileOutputStream = new FileOutputStream(file);
	
			jdk9_CatalogCustomer catalogCustomer = new jdk9_CatalogCustomer("skp", "skp", "4240123488889001",
					 true, 12432232.56);
		
			ObjectOutputStream output = new ObjectOutputStream(fileOutputStream);
			output.writeObject(catalogCustomer);
			output.close();
		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} 
	}
	
	
	public void filterAndDeSerializeData() {
		
		try {

			//you may chose a simpler path as well, ideally a relative path or load from a properties file
			String incomingSerialFile = "src\\main\\java\\me\\sumithpuri\\github\\london"
														+ "\\serializationfilter\\file\\jdk9_catalog_customer.txt";

			// Read from the stored file
			FileInputStream fileInputStream = new FileInputStream(new File(incomingSerialFile));
			ObjectInputStream input = new ObjectInputStream(fileInputStream);
			
			//set the filter that we had created
			input.setObjectInputFilter(new jdk9_ItemCatalogFilter());
			jdk9_CatalogCustomer catalogCustomer = (jdk9_CatalogCustomer) input.readObject();
			
			System.out.println("Customer Details String Follows (Filtered then De-Serialized)");
			System.out.println(catalogCustomer.customerUsername+":"+catalogCustomer.customerPassword+":"+
								catalogCustomer.customerCreditCd+":"+catalogCustomer.customerSiteCash);
			
			input.close();

		} catch (FileNotFoundException e) {
			
			e.printStackTrace();
		} catch (IOException e) {
			
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			
			e.printStackTrace();
		}
	}
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		jdk9_FilterIncomingSerializationData fISD = new jdk9_FilterIncomingSerializationData();
		fISD.serializeData();
		fISD.filterAndDeSerializeData();
	}
}
