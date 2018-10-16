package me.sumithpuri.github.london.methodhandles;

import java.lang.invoke.MethodHandle;
import java.lang.invoke.MethodHandles;

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
 * MethodHandles were introduced first in Java 7. You have to think them as an alternative for  Java Reflection API, but
 * with an advantage of better performance as they are specified at creation time. Enhanced Method Handles has primarily
 * added new static methods to better/widen the functionality provided  by Method Handles.
 * 
 * Note that Method Handles are Enhanced in Java 9, to introduce very many changes and methods. I will  be  covering the
 * ones that are the most important, only to introduce this topic. 
 * 
 * arrayLength, arrayConstructor, zero, empty, 
 * loop, countedloop, iteratedloop, dowhileloop, whileloop, try/finally
 */
public class jdk9_EnhancedMethodHandles {

	public void enhancedMethodHandleDemo() {

		try {

			// arrayLenth
			MethodHandle methodHandleLength = MethodHandles.arrayLength(int[].class);
			int[] ageArray = new int[] { 21, 28, 36 };
			int arrayLength;

			arrayLength = (int) methodHandleLength.invoke(ageArray);

			System.out.println("Length of Array using Method Handle is " + arrayLength);

			// arrayConstructor
			MethodHandle methodHandleConstructor = MethodHandles.arrayConstructor(int[].class);
			int[] newAgeArray = (int[]) methodHandleConstructor.invoke(3);
			System.out.println("Array Constructed using Method Handle of Size " + newAgeArray.length);

			// zero
			int x = (int) MethodHandles.zero(int.class).invoke();
			System.out.println("Default Value of Primitive Integer using Method Handles is " + x);
			String y = (String) MethodHandles.zero(String.class).invoke();
			System.out.println("Default Value of String using Method Handles is " + y);

			System.out.println();
			System.out.println("Reader/Developer - Left as an Exercise for You :-)");
			System.out.println("Refer Loop, CountedLoop, DoWhileLoop, WhileLoop, IteratedLoop, TryFinally");

		} catch (Throwable e) {

			System.out.println("Was Hungry as Ever - Gulped Everything I Got!");
		}

		// refer to, https://goo.gl/JCyo7N (official javadoc)
		// also use, https://goo.gl/i8wNJ8 (individual blog)
	}

	
	public static void main(String[] args) {

		new jdk9_EnhancedMethodHandles().enhancedMethodHandleDemo();
	}
}
