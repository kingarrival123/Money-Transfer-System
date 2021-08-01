package com.example.db.repository;




	import java.util.List;

	import com.example.db.entity.*;

	public interface TransferRepository {

		void save(Transfer transfer);
		
		List<Transfer> getTransfers();
		
		List<Transfer> getTransfers(int limit);

		List<Transfer> getTransfers(String fromDate, String toDate);
	}



