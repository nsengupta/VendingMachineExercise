package com.metadesign.exercise.machine.components;

import java.io.PrintStream;

import com.metadesign.exercise.nutsAndbolts.IPromptingDevice;

public class ScreenPrompter implements IPromptingDevice {
	
	private PrintStream  outputStream  = System.out;
	
	public ScreenPrompter() { /* just to facilitate creation, override to use other mechanisms */ }

	@Override
	public void showPrompt(String prompt) {
		this.outputStream.println(prompt);
	}

}
