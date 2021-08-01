package com.example.transfer.services;



	public interface TransferService {
		void transfer(double amount, int fromAccount, int toAccount);
		void transactions();
		void transactions(int limit);
		void transactions(String fromDate, String toDate);
	}


