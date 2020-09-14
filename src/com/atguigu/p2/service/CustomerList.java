package com.atguigu.p2.service;

import com.atguigu.p2.bean.Customer;

public class CustomerList {
	
	private Customer[] customerlist;
	private int customerNumber;
	private int total;
	

	public CustomerList(int total) {
		// TODO Auto-generated constructor stub
		customerlist = new Customer[total];
	}


	public boolean addCustomer(Customer customer){
		if(total>=customerlist.length){
			return false;
		}else{
			customerlist[customerNumber] = customer;
			customerNumber++;
			return true;
		}
	}
	
	public Customer getCustomer(int index){
		if(index < 0 || index > customerNumber){
			return null;
		}
			return customerlist[index];
		
	} 
	
	public boolean replaceCustomer(int index, Customer cust){
		if(index < 0 || index > customerNumber){
			return false;			
		}else{
		customerlist[index] = cust;
		return true;
		}
	}
	
	public boolean deleteCustomer(int index){
		if(index < 0 || index > customerNumber){
			return false;
		}else{
			for(int i=index; i<customerNumber-1; i++){
				customerlist[i] = customerlist[i+1];
			}
			customerlist[customerNumber] = null;
			customerNumber--;
			return true;
		}
	}
	
	public void forPrintList(){
		for(int i=0; i<customerNumber; i++){
			int id = i+1;
			String name = customerlist[i].getName();
			char sex = customerlist[i].getSex();
			int age = customerlist[i].getAge();
			String phone = customerlist[i].getPhone();
			String email = customerlist[i].getEmail();
			System.out.print(id + "\t" + name + "\t" + sex + "\t" + age + "\t\t" + phone + "\t" + email);
			System.out.println();
		}

	}
	
}
