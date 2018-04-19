package com.dz;

import java.util.concurrent.CountDownLatch;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;


/**
 * 
 */
/**
* @author DongZhong
* @version 创建时间: 2018年4月19日 上午9:54:42
*/
public class Application {

	private static final Logger logger = LogManager.getLogger(Application.class);
	private static int totalThread = 50;
	/**
	 * @param args
	 * @throws InterruptedException 
	 */
	public static void main(String[] args) throws InterruptedException {
		fixedLargePrinting();
	}

	private static void fixedPrinting() throws InterruptedException {
		System.out.println("log4j 100w start fixedPrinting");
		final CountDownLatch cdl = new CountDownLatch(totalThread);
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < totalThread; i++) {
			new Thread(new Runnable() {
				public void run() {
					for (int j = 0; j < 2*10000; j++)
						logger.info("Hello World large fixedPrinting");
					cdl.countDown();
				}
			}).start();;
		}
		cdl.await();
		long endTime = System.currentTimeMillis();
		System.out.println("log4j 100w: " + (endTime - startTime) + "ms");
	}


	private static void fixedLargePrinting() throws InterruptedException {
		System.out.println("log4j 100w start fixedPrinting");
		final CountDownLatch cdl = new CountDownLatch(totalThread);
		long startTime = System.currentTimeMillis();
		for (int i = 0; i < totalThread; i++) {
			new Thread(new Runnable() {
				public void run() {
					for (int j = 0; j < 2*10000; j++)
						logger.info("Hello World large fixedPrinting");
					cdl.countDown();
				}
			}).start();;
		}
		cdl.await();
		long endTime = System.currentTimeMillis();
		System.out.println("log4j 100w: " + (endTime - startTime) + "ms");
	}	
}
