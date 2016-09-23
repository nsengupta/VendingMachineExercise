package com.metadesign.exercise.machine.components;

import java.util.Scanner;

import com.metadesign.exercise.nutsAndbolts.IReadingDevice;

public class CoinSlot implements IReadingDevice {
	private String    keys        =  "[12345]";
	private Scanner   inputSource =  new Scanner(System.in);
	
	public CoinSlot() { /* Just to install our own Constructor, rather than JVM-supplied */ }

	@Override
	public String takeInput() {
		
		while (true) {	
			String s = this.inputSource.nextLine();
			if (s.matches(keys + "+"))
				return (s);
			else
				continue;
		}
	}

}
