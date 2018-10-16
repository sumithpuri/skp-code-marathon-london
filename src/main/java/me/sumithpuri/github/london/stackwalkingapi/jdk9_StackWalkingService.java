package me.sumithpuri.github.london.stackwalkingapi;

import java.lang.StackWalker.Option;  
import java.util.List;  
import java.util.stream.Collectors;  

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
 * Stack Walker API is a new feature of Java 9, aimed  at Improving Performance  of the predecessor Stack Track Element,  
 * as also for providing a way to filter the Stack Elements, in case of Exception or to Understand Application Behavior.   
 * Although, there have been  multiple  changes, I am  covering  only  Stack Frame Attributes and also the walk() method   
 * for walking the Stack Frame.   
 */  
public class jdk9_StackWalkingService { 

     private int databaseService() {  

          int x = 3;  

          // Usage 01: Walking All Stack Frames  
          System.out.println("Java 9 Stack Walker API - Showing All Stack Frames");  
          StackWalker stackWalker = StackWalker.getInstance();  
          stackWalker.forEach(System.out::println);  
          System.out.println("");  

          // Usage 02 : Filtering or Walking Stack Frames  
          System.out.println("Java 9 Stack Walker API - Walking / Filtering Stack Frames");  
          List<StackWalker.StackFrame> stackFrames;  
          stackFrames = stackWalker.walk(frames -> frames.limit(2).collect(Collectors.toList()));  
          stackFrames.forEach(System.out::println);  
          System.out.println("");  

          // Usage 03 : Show All Attributes of a Stack Frame  
          System.out.println("Java 9 Stack Walker API - Show All Attributes in Stack Frame");  
          StackWalker newWalker = StackWalker.getInstance(Option.RETAIN_CLASS_REFERENCE);  
          stackFrames = newWalker.walk(frames -> frames.limit(1).collect(Collectors.toList()));  
          stackFrames.forEach(sfRecord->   
          {  
               System.out.printf("[Bytecode Index] %d%n", sfRecord.getByteCodeIndex());  
               System.out.printf("[Class Name] %s%n", sfRecord.getClassName());  
               System.out.printf("[Declaring Class] %s%n", sfRecord.getDeclaringClass());  
               System.out.printf("[File Name] %s%n", sfRecord.getFileName());  
               System.out.printf("[Method Name] %s%n", sfRecord.getFileName());  
               System.out.printf("[Is Native] %b%n", sfRecord.isNativeMethod());  
               System.out.printf("[Line Number] %d%n", sfRecord.getLineNumber());  
          });  
          return x;  
     }  

     private float persistenceService() {  
          float x = databaseService();  
          return x;  
     }  

     private double businessService() {  
          double x = persistenceService();  
          return x;  
     }  

     private double presentationService() {  
          long x = (long) businessService();  
          return x;  
     }  

     public void uiDisplay() {  
          System.out.println("Java 9 Stack Walker API for Debugging and Application Behavior");  
          double x = presentationService();  
          System.out.println("\n[Method to Display On User Interface]");  
          System.out.println("Old MacDonald had a Farm. In that Farm, He had " + x + " Cows!");  
     }  

     /**  
      * @param args  
      */  
     public static void main(String[] args) {  
    	 
          jdk9_StackWalkingService stackWalkingService = new jdk9_StackWalkingService();  
          stackWalkingService.uiDisplay();  
     }  
       
}  
