package com.metadesign.exercise.machine.components;

import com.metadesign.exercise.nutsAndbolts.IPromptingDevice;
import com.metadesign.exercise.nutsAndbolts.IReadingDevice;

public class CustomerPaymentAcceptor {
	
	private IPromptingDevice  promptingDevice;
	private IReadingDevice    readingDevice; 
	
	public CustomerPaymentAcceptor(IPromptingDevice passedPromptingDevice,IReadingDevice passedReadingDevice) {
		
		this.promptingDevice = passedPromptingDevice;
		this.readingDevice   = passedReadingDevice;
	}
	
	public int  acceptCoins(String withPrompt) {
		this.promptingDevice.showPrompt(withPrompt);
		String coins = this.readingDevice.takeInput();
		return(Integer.parseInt(coins));
	}
	
	public int  acceptCoins(String withPrompt,int howMany) {
		return(0);
	}
}
