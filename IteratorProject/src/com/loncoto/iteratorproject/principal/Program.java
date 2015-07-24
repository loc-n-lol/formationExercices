package com.loncoto.iteratorproject.principal;

import java.util.Arrays;

import com.loncoto.iteratorproject.reseau.IPInterval;

public class Program {

	public static void main(String[] args) {

		IPInterval ipi1 = new IPInterval(192, 100, 100, 50, 192, 100, 110, 25);
		
		System.out.println("192.100.100.40 dedans ? -> " + ipi1.isInInterval(192, 100, 100, 40));
		System.out.println("192.100.100.60 dedans ? -> " + ipi1.isInInterval(192, 100, 100, 60));
		System.out.println("192.100.105.10 dedans ? -> " + ipi1.isInInterval(192, 100, 105, 10));
		System.out.println("192.100.110.30 dedans ? -> " + ipi1.isInInterval(192, 100, 110, 30));
		
		for (Integer[] ip : ipi1) {
			System.out.println("1e parcours "+Arrays.toString(ip));
			for (Integer[] ip2 : ipi1) {
				System.out.println("2e parcours "+Arrays.toString(ip2));
			}
		}
		
	}

}
