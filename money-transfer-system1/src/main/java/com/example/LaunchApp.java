package com.example;

import java.util.Scanner;

import com.example.transfer.services.TransferService;
import com.example.transfer.services.TransferServiceImpl;

public class LaunchApp {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scan = new Scanner(System.in);
		int choice;
		boolean flag = true;
		TransferService startApp = new TransferServiceImpl();
		while (flag) {
			System.out.println("Select option");
			System.out.println(
					"1. To do Transaction,\n2. Transaction history of last 10 transactions,\n3. Transaction history from date range,\n4. All transaction history,\n5. Exit");
			choice = scan.nextInt();
			switch (choice) {
			case 1:
				System.out.println("Enter amount to be transfered: ");
				double amount = scan.nextDouble();
				System.out.println("Enter from account details: ");
				int fromAccount = scan.nextInt();
				System.out.println("Enter to account details: ");
				int toAccount = scan.nextInt();

				startApp.transfer(amount, fromAccount, toAccount);
//				System.out.println("Money transfered successfully");
				startApp.transactions(2);
				break;
			case 2:
				startApp.transactions(20);
				break;
			case 3:
				System.out.println("Enter from date in yyyy-mm-dd format:");
				String fromDate = scan.next();
				System.out.println("Enter to date in yyyy-mm-dd format:");
				String toDate = scan.next();
				startApp.transactions(fromDate + " 00:00:00", toDate + " 23:59:59");
				break;
			case 4:
				startApp.transactions();
				break;
			case 5:
				flag = false;
				break;
			default:
				System.out.println("Choose correct option");
			}

		}
	}

}
