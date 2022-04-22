package com.sbi.project;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sbi.project.layer2.Account;
import com.sbi.project.layer2.Payee;
import com.sbi.project.layer3.PayeeRepository;

@SpringBootTest
public class PayeeRepoTesting {
	
	@Autowired
	PayeeRepository payeeRepo;
	
	@Test
	public void allPayeeLoadingRepotest(){
		List<Payee> payeeList=payeeRepo.findAllPayee(10001);
		for (Payee payee : payeeList) {
			//System.out.println("All payees.. of....:"+payee.getAccountNumber());
			System.out.println("Payee Id ............:"+payee.getPayeeId());
			System.out.println("Payee Name ..........:"+payee.getPayeeName());
			System.out.println("Payee Account Number.:"+payee.getPayeeAccountNumber());
			System.out.println("Payee nick Name .....:"+payee.getNickName());
			
			
		}
		
	}
	
	@Test
	public void loadPayeeDetailsByIdTest()
	{
		Payee payee=new Payee();
		payee=payeeRepo.findPayee(2);
		System.out.println("Payee details are........");
		System.out.println("Payee Id ............:"+payee.getPayeeId());
		System.out.println("Payee Name ..........:"+payee.getPayeeName());
		System.out.println("Payee Account Number.:"+payee.getPayeeAccountNumber());
		System.out.println("Payee nick Name .....:"+payee.getNickName());
	}
	
	
	
	@Test
	public void addPayeeTest()
	{
		Account account=new Account();
		
		account.setAccountNumber(10006);
//		account.setAccountHolderName("Deepmala");
//		account.setBalance(60000f);
//		account.setPassword("Password@1");
		
		
		Payee payee=new Payee();
		payee.setNickName("Rob");
		payee.setPayeeAccountNumber(1003);
		payee.setPayeeName("Robert");
		
		payee.setAccount(account);
		payeeRepo.addPayee(payee);
		
		//account.setPayee(payee);
	}
	
	@Test
	public void removePayeeTest()
	{
		payeeRepo.deletePayee(11);
	}
	
	
	
	

}
