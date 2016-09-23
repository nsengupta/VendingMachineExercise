package com.metadesign.exercise.machine.components;

import java.util.List;

import com.metadesign.exercise.nutsAndbolts.ItemsAvailable;

public class ColdDrinksVendingMachine {
	
	private  Rack                    racks[]; 
	private  CollectionBin           collectionBin;
	private  KeyPad                  keyPad;
	private  CoinSlot                coinSlot;
	private  CustomerChoiceAcceptor  customerChoiceAcceptor;
	private  CustomerPaymentAcceptor customerPaymentAcceptor;
	private  int                     totalCoinsEarnedSofar;        
	
	public ColdDrinksVendingMachine
	       (Rack[] racks,  CollectionBin collectionBin, 
	    	KeyPad keyPad, CoinSlot coinSlot,
	    	ScreenPrompter screenPrompter) {
		
		super();
		this.racks         =  racks;
		this.collectionBin = collectionBin;
		this.keyPad        = keyPad;
		this.coinSlot      = coinSlot;
		this.customerChoiceAcceptor  = new CustomerChoiceAcceptor (screenPrompter,keyPad);
		this.customerPaymentAcceptor = new CustomerPaymentAcceptor(screenPrompter,coinSlot);
		this.totalCoinsEarnedSofar = 0;
	}
	
	public ColdDrinksVendingMachine() {
		
		throw new IllegalArgumentException("You are not supposed to call me this way!");
	}

	public int  onStartBusiness() {
		
		Integer coldDrinkChosen = 
				Integer
				.valueOf(
					this
					.customerChoiceAcceptor
					.guideToGetAChoice(
						"Please enter your choice!"
					)
				);
		
		 while (coldDrinkChosen != 0) {
			 
			 Integer coldDrinkCount = 
						Integer
						.valueOf(
							this
							.customerChoiceAcceptor
							.guideToGetAChoice(
								"How many do you want?"
							)
						);
			 
			 Integer paymentInCoins = 
						this
						.customerPaymentAcceptor
						.acceptCoins(
								"Please put in (" + coldDrinkCount + ") 50p coins", 
								coldDrinkCount
						);
			 
			 this.totalCoinsEarnedSofar += paymentInCoins;
			 
			 List<ItemsAvailable> drinkContainersDispensed = dispense(coldDrinkChosen,coldDrinkCount);
			 
			 this.collectionBin.dropInBin(drinkContainersDispensed);
			 
			 coldDrinkChosen = 
					 Integer
						.valueOf(
								this
								.customerChoiceAcceptor
								.guideToGetAChoice(
									"Please enter your choice!"
								)
							);
		 }
		 
		 return (1);
	}
	
	public int onCloseBusiness() {
		
		// TODO:
		return 0;
	}


	private List<ItemsAvailable> dispense(Integer coldDrinkChosen, Integer coldDrinkCount) {
		
		return(this.racks[coldDrinkChosen].releaseFromRack(coldDrinkCount));
			
	}


}
