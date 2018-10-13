package me.sumithpuri.github.london.spinwaithints;

import java.util.List;
import java.util.Vector;

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
 * For a Single Line Demonstration, I wrote the Non-Pure Threaded form of Producer-Consumer. Run the Code Multiple Times
 * On a Machine, where you can Understand how the Temperature Changes and Extra Cooling Fan Kicks Off. Even though I did
 * not do it myself, Take it up as an Experiment, by removing the Thread.onSpinWait() [Compare Before/After and also try
 * with Data Set of 1 Million to 10 Million]
 * 
 * Thread.onSpinWait() will Optimize Latency and Reduce/Optimize Power Consumption
 */
public class jdk9_SpinWaitHints {

	public void demoSpinWait() {

		List<String> itemQueue = new Vector<String>();

		Producer producer = new Producer(itemQueue);
		Consumer consumer = new Consumer(itemQueue);

		producer.start();
		consumer.start();
	}

}

class Producer extends Thread {

	List<String> itemQueue;

	Producer(List<String> itemQueue) {
		this.itemQueue = itemQueue;
	}

	public void run() {

		try {
			produce();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	public void produce() throws InterruptedException {

		while (true) {

			while (itemQueue.size() < 100000) // produce 1 lac items
			{
				String item = "Sumith Puri " + (itemQueue.size());
				itemQueue.add(item);
				System.out.println("Item Produced: " + item);
			}

			while (itemQueue.size() > 0) {
				// spin waiting - x86 architectures will now optimize
				Thread.onSpinWait();
			}

		}
	}
}

class Consumer extends Thread {

	List<String> itemQueue;

	public Consumer(List<String> itemQueue) {
		this.itemQueue = itemQueue;
	}

	public void consume() throws InterruptedException {

		while (true) {

			while (itemQueue.size() < 100000) {
				// spin waiting - x86 architectures will now optimize
				Thread.onSpinWait();
			}

			int x = itemQueue.size();
			while (x >= 1) {
				x = x - 1;
				if (x >= 0) {
					String item = itemQueue.remove(x);
					System.out.println("Item Consumed: " + item);
				}
			}
			if (itemQueue.size() > 0)
				itemQueue.remove(0);

		}
	}

	public void run() {
		try {
			consume();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
}
