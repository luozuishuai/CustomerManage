package com.atguigu.p2.ui;

import com.atguigu.p2.service.*;
import com.atguigu.p2.bean.Customer;
import com.atguigu.p2.util.*;

public class CustomerView {

	boolean loopFlag = true;

	public static void main(String[] args) {

		CustomerList cslist = new CustomerList(99);
		Customer customer = new Customer("张三", '男', 18, "17617179214", "84654471@qq.com");
		cslist.addCustomer(customer);
		
		CustomerView cstv = new CustomerView();	
		cstv.entermain();
	}

	public void entermain() {
		
		// CMUtility tool = new CMUtility();
		while (loopFlag) {
			System.out.println("\n-----------------客户信息管理软件-----------------\n");
			System.out.println("                        1 添 加 客 户");
			System.out.println("                        2 修 改 客 户");
			System.out.println("                        3 删 除 客 户");
			System.out.println("                        4 客 户 列 表");
			System.out.println("                        5 退           出\n");
			System.out.print("                \t请选择(1-5)：");
			char select = CMUtility.readMenuSelection();
			switch (select) {
			case '1':
				addNewCustomer();
				break;
			case '2':
				updateCustomer();
				break;
			case '3':
				deleteCustomer();
				break;
			case '4':
				showAllCustomer();
				break;
			case '5':
				exitCustomer();
				break;
			}
		}
	}

	private void addNewCustomer() {

		System.out.println("\n---------------------添加客户---------------------");
		System.out.print("姓名：");
		String name = CMUtility.readString(5);
		System.out.print("性别：");
		char sex = CMUtility.readChar();
		System.out.print("年龄：");
		int age = CMUtility.readInt(2);
		System.out.print("电话：");
		String phone = CMUtility.readString(15);
		System.out.print("邮箱：");
		String email = CMUtility.readString(20);

		Customer customer = new Customer(name, sex, age, phone, email);
		boolean flag = cslist.addCustomer(customer);
		if (flag) {
			System.out.println("---------------------添加完成---------------------\n");
		} else {
			System.out.println("----------------记录已满,无法添加-----------------\n");
		}

	}

	private void updateCustomer() {
		Customer cust = null;
		System.out.println("\n---------------------修改客户---------------------");
		int index = 0;
		for (;;) {
			System.out.print("请选择待修改客户编号(-1退出)：");
			index = CMUtility.readInt();

			if (index == -1) {
				return;
			}

			cust = cslist.getCustomer(index - 1);
			if (cust == null) {
				System.out.println("没有找到该客户信息");
			} else {
				break;
			}
		}
		System.out.print("姓名(" + cust.getName() + "):");
		String name = CMUtility.readString(5, cust.getName());

		System.out.print("性别(" + cust.getSex() + "):");
		char sex = CMUtility.readChar(cust.getSex());

		System.out.print("年龄(" + cust.getAge() + "):");
		int age = CMUtility.readInt(cust.getAge());

		System.out.print("电话(" + cust.getPhone() + "):");
		String phone = CMUtility.readString(15, cust.getPhone());

		System.out.print("邮箱(" + cust.getEmail() + "):");
		String email = CMUtility.readString(20, cust.getEmail());

		cust = new Customer(name, sex, age, phone, email);
		boolean flag = cslist.replaceCustomer(index-1, cust);

		if (flag) {
			System.out.println("---------------------修改完成---------------------\n");
		} else {
			System.out.println("---------------------修改失败---------------------\n");
		}
	}

	public void deleteCustomer() {
		int index = 0;
		Customer cust = null;
		System.out.println("\n---------------------删除客户---------------------");
		for (;;) {
			System.out.print("请选择待删除客户编号(-1退出)：");
			index = CMUtility.readInt();
			if (index == -1) {
				return;
			} else {
				cust = cslist.getCustomer(index - 1);
				if (cust == null) {
					System.out.println("无法找到指定客户");
				} else {
					break;
				}
			}
		}
		System.out.println("确认是否删除(Y/N)：");
		char choose = CMUtility.readConfirmSelection();
		if (choose == 'Y') {
			boolean flag = cslist.deleteCustomer(index - 1);
			if (flag) {
				System.out.println("---------------------删除完成---------------------");
			}else{
				System.out.println("----------无法找到指定客户,删除失败--------------");
			}

		}else{
			return;
		}
	}
	
	public void showAllCustomer(){
		System.out.println("\n---------------------------客户列表---------------------------");
		System.out.println("编号\t姓名\t性别\t年龄\t\t电话\t\t邮箱");
		cslist.forPrintList();
	}
	
	public void exitCustomer(){
		System.out.print("确认是否退出(Y/N)：");
		char choose = CMUtility.readConfirmSelection();
		if (choose == 'Y') {
			loopFlag = false;
		}
	}
}
