package com.metadesign.exercise.machine.components;

import java.util.Scanner;

import com.metadesign.exercise.nutsAndbolts.IReadingDevice;

public class KeyPad implements IReadingDevice {

	private String    keys      =  "[0-9]";
	private Scanner   inputSource =  new Scanner(System.in);
	
	public KeyPad() { /* Just to install our own Constructor, rather than JVM-supplied */ }
	
	@Override
	public String takeInput() {
		
		while (true) {	
			String s = this.inputSource.nextLine();
			if (s.matches(keys + "+") && s.length() <= 2)
				return (s);
			else
				continue;
		}
	}

}
