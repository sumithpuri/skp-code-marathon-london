package me.sumithpuri.github.london.serializationfilter.vo;

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
 * rights to use, copy, modify, merge, publish, distribute, sub-license and/or sell copies of the Software and to permit 
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
 * Value Object that will be Sent Over the Wire with Critical Customer Information.
 * 
 * Used to Demonstrate Serialization / De-Serialization (Filters in Java 9).
 */
public class jdk9_CatalogCustomer implements java.io.Serializable {

	private static final long serialVersionUID = 24092018L;

	// very poor oo and bean code :-)
	// do change to private, add getters / setters
	public String customerUsername;
	public String customerPassword;
	public String customerCreditCd;
	public boolean isPrivilegedCustomer;
	public double customerSiteCash;

	public jdk9_CatalogCustomer(String customerUsername, String customerPassword, String customerCreditCd,
						boolean isPrivilegedCustomer, double customerSiteCash) {
		super();
		this.customerUsername = customerUsername;
		this.customerPassword = customerPassword;
		this.customerCreditCd = customerCreditCd;
		this.isPrivilegedCustomer = isPrivilegedCustomer;
		this.customerSiteCash = customerSiteCash;
	}

	public jdk9_CatalogCustomer() {
		// TODO Auto-generated constructor stub
	}
}
