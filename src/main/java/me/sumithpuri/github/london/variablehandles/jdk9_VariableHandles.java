package me.sumithpuri.github.london.variablehandles;

import java.lang.invoke.MethodHandles;
import java.lang.invoke.VarHandle;


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
 * VarHandle allows developers to assign different types to the same reference (dynamically typed reference).It can also 
 * take care of performing atomic operations on the held variable, including compare and swap (set/exchange) operations. 
 * It also provides memory fencing operations, to order the in-memory representation of the object, by  providing  finer 
 * grain control. 
 * 
 * I am providing an Example of the Read Operations using VarHandle. Please refer to the link provided below for further
 * info on VarHandle on Public Variable, VarHandle for Private Variables, VarHandle for Array Types 
 * 
 * https://www.baeldung.com/java-variable-handles
 */
class VarHandleStore {
	
	public int varIntHandle01 = 5;
	public int varIntHandle02 = 9;
	public byte varByteHandle03 = 21;
}

public class jdk9_VariableHandles {

	public void useVariableHandle() {

		System.out.println("Java 9 Introduces.... Variable Handles!");

		try {

			VarHandleStore varHandleStore = new VarHandleStore();

			VarHandle varHandle = MethodHandles.lookup().in(VarHandleStore.class).findVarHandle(VarHandleStore.class,
					"varIntHandle01", int.class);

			// value using get() in varhandle
			int plainValue = (int) varHandle.get(varHandleStore);
			System.out.println("Value using get() in VarHandle: " + plainValue);

			// value is written to using set() - plain access
			// you can also use set(), setOpaque(), setVolatile(), setRelease()
			varHandle.set(varHandleStore, 21);
			plainValue = (int) varHandle.get(varHandleStore);
			System.out.println("Set Value using set(), then get() in VarHandle: " + plainValue);

			// value is written to using getandadd()
			int oldValue = (int) varHandle.getAndAdd(varHandleStore, 51);
			plainValue = (int) varHandle.get(varHandleStore);
			System.out.println("Using getAndAdd() in VarHandle, Old Value: " + oldValue + ", New Value: " + plainValue);

			varHandle = MethodHandles.lookup().in(VarHandleStore.class).findVarHandle(VarHandleStore.class,
					"varIntHandle02", int.class);

			// please do try out the compareandset() - atomic updates
			// have left this due to time constraints

			// value is written to using getandbitwiseor()
			varHandle = MethodHandles.lookup().in(VarHandleStore.class).findVarHandle(VarHandleStore.class,
					"varByteHandle03", byte.class);

			byte before = (byte) varHandle.getAndBitwiseOr(varHandleStore, (byte) 127);
			byte after = (byte) varHandle.get(varHandleStore);
			System.out.println("Get Byte Value, Then Or, using getAndBitwiseOr()");
			System.out.println("Old Byte Value: " + before + "; New Byte Value: " + after);

		} catch (NoSuchFieldException | IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		
		new jdk9_VariableHandles().useVariableHandle();
	}
}



