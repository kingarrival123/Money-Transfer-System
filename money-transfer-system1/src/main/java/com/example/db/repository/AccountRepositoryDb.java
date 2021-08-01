package com.example.db.repository;

public interface AccountRepositoryDb {
	
	boolean check(int account);
	
	int balance(int account);

	void update(int accountNumber, int balance);
}
