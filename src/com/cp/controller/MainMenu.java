package com.cp.controller;
import com.cpa.jdbc.*;
import java.util.Scanner;

import com.cp.demo.controller.DemoController;
import com.cp.demo.exception.CPException;


/**
 * 
 */

/**
 * @author
 *
 */
public class MainMenu {

//	private HashMap<String, Customer> custCache = null;
//	private HashMap<String, Customer> deptCache = null;
//	private HashMap<String, Customer> prodCache = null;

	public MainMenu() {
//		initCache();
	}

	public static void main(String[] args) throws CPException {

		while (true) {
			System.out.println("============= Main Menu ============");
			System.out.println("1. Create Department Store");
			System.out.println("2. Add New Product");
			System.out.println("3. Generate Invoice");
			System.out.println("4. Exit");
			Scanner sc1 = new Scanner(System.in);
			int option = sc1.nextInt();
			switch (option) {
			case 1:
				DemoController dc = new DemoController();
				dc.CreatConnection();
				break;
			case 2:
				break;

			case 3:
				break;
			case 4:
				DBManager dbm = DBManager.getDBManager();
				dbm.cleanPool();
				sc1.close();
				System.exit(0);
				break;
			case 5:
				System.out.println("Please enter options between 1 to 4 ");
				break;
			}
		}

	}

}
