package com.metadesign.exercise.machine.components;

import com.metadesign.exercise.nutsAndbolts.IPromptingDevice;
import com.metadesign.exercise.nutsAndbolts.IReadingDevice;


public class CustomerChoiceAcceptor {
	
	private IPromptingDevice  promptingDevice;
	private IReadingDevice    readingDevice; 
	
	public CustomerChoiceAcceptor(IPromptingDevice passedPromptingDevice,IReadingDevice passedReadingDevice) { 
		this.promptingDevice = passedPromptingDevice;
		this.readingDevice   = passedReadingDevice;
	}
	
	public String guideToGetAChoice(String withPrompt) {
		this.promptingDevice.showPrompt(withPrompt);
		return(this.readingDevice.takeInput());
	}
	
	

}

