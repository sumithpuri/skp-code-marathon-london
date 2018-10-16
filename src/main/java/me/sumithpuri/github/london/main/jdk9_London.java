package me.sumithpuri.github.london.main;

import me.sumithpuri.github.london.methodhandles.jdk9_EnhancedMethodHandles;
import me.sumithpuri.github.london.serializationfilter.jdk9_FilterIncomingSerializationData;
import me.sumithpuri.github.london.spinwaithints.jdk9_SpinWaitHints;
import me.sumithpuri.github.london.stackwalkingapi.jdk9_StackWalkingService;
import me.sumithpuri.github.london.variablehandles.jdk9_VariableHandles;
import me.sumithpuri.github.london.versionstring.jdk9_JavaVersionStringChanges;

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
 * You may run this main class to run all the Demo Code of  the [London] Project. It demonstrates most important changes 
 * in Java 9. This shows next set of changes in Java 9, the top changes are covered in the [Singapore] Project. 
 * 
 * You may access the code repository of the [Singapore] Project by browsing at https://github.com/sumithpuri
 */
public class jdk9_London {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		System.out.println("Copyright (c) 2018-19,	Sumith Kumar Puri");
		System.out.println();
		System.out.println("Project Codename      London");
		System.out.println("Project Description   Java 9 Companion Code Samples");
		System.out.println("Technical Blog        http://www.techilashots.com");
		System.out.println("Technical Blog Post   https://goo.gl/r1LQda");
		System.out.println("[Developer Notes]     [01] Use Java Version 9.0+ Compiler");

		jdk9_London java9Application = new jdk9_London();

		//new features of java 9
		//java language changes in java 9 
		java9Application.java9LanguageChanges();	
		
		//new features of java 9
		//core java library changes in java 9 
		java9Application.java9CoreLibraryChanges();
	}
	
	//new features of java 9
	//java language changes in java 9 
	private void java9LanguageChanges() {
		
	}
	
	//new features of java 9
	//core java library changes in java 9
	private void java9CoreLibraryChanges() {
		
		//[part 02/02 of the article starts here]//
		
		//new features of java 9 (core library changes)
		//stack walking service for ease of use and performance		
		this.stackWalkingAPI();
		
		//new features of java 9 (core library changes)
		//spin wait now allows processor hints to improve power consumption	
		this.spinWaitHints();
		
		//new features of java 9 (core library changes)
		//java version naming changes	
		this.versionNaming();
		
		//new features of java 9 (core library changes)
		//enhanced method handles introduces new helpful static methods
		this.enhancedMethodHandles();
		
		//new features of java 9 (core library changes)
		//variable handles allow us to assign different types to same reference
		this.varHandle();
		
		//new features of java 9 (core library changes)
		//filter incoming serialization data for security and to check vulnerabilities
		this.filterIncomingSerialization();
	}

	//new features of java 9 (core library changes)
	//stack walking service for ease of use and performance	
	private void stackWalkingAPI() {
		
		System.out.println("09. Stack Walking API");
		System.out.println("---------------------");
		
		
		jdk9_StackWalkingService stackWalkingService = new jdk9_StackWalkingService();
		stackWalkingService.uiDisplay();
		
		System.out.println("");
		System.out.println("================================");
		System.out.println("");
	}
	
	//new features of java 9 (core library changes)
	//spin wait now allows processor hints to improve power consumption	
	private void spinWaitHints() {
		
		System.out.println("11. Spin Wait Hints");
		System.out.println("-------------------");
		
		System.out.println("Spin Wait Hints Makes Power Consumption Efficient");
		jdk9_SpinWaitHints spinWaitHints = new jdk9_SpinWaitHints();
		
		System.out.println("[Uncomment Method Call in Code, To Run (Non-Terminating) Demo]");
		//spinWaitHints.demoSpinWait();
		
		System.out.println("");
		System.out.println("================================");
		System.out.println("");
	}
	
	//new features of java 9 (core library changes)
	//java version string changes	
	private void versionNaming() {
		
		System.out.println("12. Java Version Naming");
		System.out.println("----------------------");
		
		System.out.println("Java 9 changes the way Java Version String Format");
		jdk9_JavaVersionStringChanges javaVersionChanges = new jdk9_JavaVersionStringChanges();
		javaVersionChanges.printVersionInformation();
		
		System.out.println("");
		System.out.println("================================");
		System.out.println("");
	}
	
	//new features of java 9 (core library changes)
	//enhanced method handles introduces new helpful static methods
	private void enhancedMethodHandles() {
		
		System.out.println("13. Enhanced Method Handles");
		System.out.println("---------------------------");
		
		System.out.println("Java 9 has Enhanced Method Handles for Multitude of Operations");
		jdk9_EnhancedMethodHandles enhancedMethodHandles = new jdk9_EnhancedMethodHandles();
		enhancedMethodHandles.enhancedMethodHandleDemo();
		
		System.out.println("");
		System.out.println("================================");
		System.out.println("");
	}	
	
	//new features of java 9 (core library changes)
	//variable handles allow us to assign different types to same reference
	private void varHandle() {
		
		System.out.println("14. Variable Handles");
		System.out.println("--------------------");
		
		System.out.println("Java 9 Introduces Variable Handles, Different Types for Same Reference");
		jdk9_VariableHandles variableHandles = new jdk9_VariableHandles();
		variableHandles.useVariableHandle();
		
		System.out.println("");
		System.out.println("================================");
		System.out.println("");
	}	
	
	//new features of java 9 (core library changes)
	//variable handles allow us to assign different types to same reference
	private void filterIncomingSerialization() {
		
		System.out.println("15. Filter Incoming Serialization Data");
		System.out.println("-------------------------------------");
		
		System.out.println("Java 9 Allows Filtering of Serialization Data, through Object Input Filters");
		jdk9_FilterIncomingSerializationData fISD = new jdk9_FilterIncomingSerializationData();
		fISD.serializeData();
		fISD.filterAndDeSerializeData();
		
		System.out.println("");
		System.out.println("================================");
		System.out.println("");
	}	
}
