package com.example.transfer.repository;



	import java.sql.Timestamp;
	import java.util.Date;

	import com.example.db.entity.Transfer;
	import com.example.db.repository.AccountRepositoryDb;
	import com.example.db.repository.AccountRepositoryDbimpl;
	import com.example.db.repository.TransferRepository;
	import com.example.db.repository.TransferRepositoryImpl;
	import com.example.transfer.exceptions.InsufficientAmountException;
	import com.example.transfer.exceptions.InvalidAccountDetailsException;

	public class AccountRepositoryImpl implements AccountRepository {

		AccountRepositoryDb accountDb = new AccountRepositoryDbimpl();
		TransferRepository transferDb = new TransferRepositoryImpl();
		
//		private int trans_id = 1230;

		public void loadAccount(int accountNumber) throws InvalidAccountDetailsException {
			if(accountDb.check(accountNumber)) {
			}else {
				throw new InvalidAccountDetailsException();
			}
		}

		public void debit(int accountNumber, double amount) throws InsufficientAmountException {
			if (accountDb.balance(accountNumber) >= amount) {
				updateAccount(accountNumber, accountDb.balance(accountNumber) - amount);
				Timestamp time=new Timestamp(new Date().getTime());
				transferDb.save(new Transfer(accountNumber, time, (int)amount, "debit"));
			} else {
				throw new InsufficientAmountException();
			}
		}

		public void credit(int accountNumber, double amount) {
			updateAccount(accountNumber, accountDb.balance(accountNumber) + amount);
			Timestamp time=new Timestamp(new Date().getTime());
			transferDb.save(new Transfer(accountNumber, time, (int)amount, "credit"));
//			trans_id += 1;
		}

		public void updateAccount(int accountNumber, double updatedAmount) {
			accountDb.update(accountNumber, (int)updatedAmount);
		}

	}


