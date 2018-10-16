package me.sumithpuri.github.london.versionstring;

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
 * $MAJOR.$MINOR.$SECURITY+$BUILD  is the Naming Scheme for Version String in Java. 
 */
public class jdk9_JavaVersionStringChanges {

	
	public void printVersionInformation() {
		
		Runtime.Version versionInfo = Runtime.version();
		
		System.out.println("Version String Changes in Java 9");
		System.out.println("Major Version: " + versionInfo.major());
		System.out.println("Minor Version: " + versionInfo.minor());
		System.out.println("Security Version: " + versionInfo.security());
		System.out.println("Build Version: " + versionInfo.build());
		
		System.out.println("\nIn Java 9, Version Naming is Major.Minor.Security.Build");
		System.out.println("Currently Running in Java Version: " + versionInfo.toString());
	}
	
	public static void main(String[] args) {
		
		new jdk9_JavaVersionStringChanges().printVersionInformation();
	}
}
