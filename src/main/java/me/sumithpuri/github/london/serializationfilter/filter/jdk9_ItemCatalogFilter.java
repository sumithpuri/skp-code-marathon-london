package me.sumithpuri.github.london.serializationfilter.filter;

import java.io.ObjectInputFilter;

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
 * Demonstrates Java 9 Serialization/De-Serialization Filters for Incoming Data. Do Refer https://goo.gl/bRezWt for more
 * on Filters, with more Details and Examples.
 */
public class jdk9_ItemCatalogFilter implements ObjectInputFilter {
	
	private long maxStreamBytes = 400; // Maximum allowed bytes in the stream.
	private long maxDepth = 2; // Maximum depth of the graph allowed.
	private long maxReferences = 5; // Maximum number of references in a graph.

	@Override
	public Status checkInput(FilterInfo filterInfo) {
		
		if (filterInfo.references() < 0 || filterInfo.depth() < 0 || filterInfo.streamBytes() < 0
				|| filterInfo.references() > maxReferences || filterInfo.depth() > maxDepth
				|| filterInfo.streamBytes() > maxStreamBytes) {

			// reject this, as it seems malicious, incorrect or tampered with
			return Status.REJECTED;
		}

		Class<?> clazz = filterInfo.serialClass();

		if (clazz != null) {

			if (jdk9_CatalogCustomer.class == filterInfo.serialClass()) {

				// we are expecting a customer of our product catalog
				System.out.println("Incoming Serialization Data Verified for Structure and Vulnerabilities");
				return Status.ALLOWED;
			} else {

				// seems like some tampered, unexpected or malicious data here
				return Status.REJECTED;
			}
		}

		// the status as undecided, when we cannot infer - or + for sure
		// left for the developer to decide as per business/security process
		return Status.UNDECIDED;
	}
}
