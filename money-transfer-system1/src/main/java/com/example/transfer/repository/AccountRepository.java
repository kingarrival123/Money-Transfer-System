package com.example.transfer.repository;



	import com.example.transfer.exceptions.InsufficientAmountException;
	import com.example.transfer.exceptions.InvalidAccountDetailsException;

	public interface AccountRepository {
		void loadAccount(int accountNumber) throws InvalidAccountDetailsException;
		void debit(int accountNumber, double amount) throws InsufficientAmountException;
		void credit(int accountNumber, double amount);
		void updateAccount(int accountNumber, double updatedAmount);
	}


