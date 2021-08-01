package com.example.transfer.services;


	import com.example.db.repository.TransferRepositoryImpl;
	import com.example.transfer.exceptions.InsufficientAmountException;
	import com.example.transfer.exceptions.InvalidAccountDetailsException;
	import com.example.transfer.repository.AccountRepository;
	import com.example.transfer.repository.AccountRepositoryImpl;

	public class TransferServiceImpl implements TransferService{
		
		private AccountRepository accountRepository = new AccountRepositoryImpl();
		
		int count;
		
		public void transfer(double amount, int fromAccount, int toAccount) {
			try {
				count = 1;
				accountRepository.loadAccount(fromAccount);
				count = 2;
				accountRepository.loadAccount(toAccount);
				accountRepository.debit(fromAccount, amount);
				accountRepository.credit(toAccount, amount);
			} catch (InvalidAccountDetailsException e) {
				if(count == 1) {
					System.out.println(e.getMessage()+fromAccount);
				}else {
					System.out.println(e.getMessage()+toAccount);
				}
				
			} catch (InsufficientAmountException e) {
				System.out.println(e.getMessage()+fromAccount);
			}
			
		}

		public void transactions() {
			new TransferRepositoryImpl().getTransfers().forEach(transaction->System.out.println(transaction));
		}
		
		public void transactions(int limit) {
			new TransferRepositoryImpl().getTransfers(limit).forEach(transaction->System.out.println(transaction));
		}
		
		public void transactions(String fromDate, String toDate) {
			new TransferRepositoryImpl().getTransfers(fromDate, toDate).forEach(transaction->System.out.println(transaction));
		}
		
	}
