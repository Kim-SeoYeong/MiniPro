package com.javaex.ex01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Scanner;

public class NumberApp {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		
		String name;
		String hp;
		String company;
		
		int num;
		
		System.out.println("******************************************");
		System.out.println("*         전화번호 관리 프로그램         *");
		System.out.println("******************************************");
		
		ArrayList<Number> nList = new ArrayList<Number>();
		
		while(true) {
			System.out.println("1.리스트  2.등록  3.삭제  4.검색  5.종료");
			System.out.println("-----------------------------------------");
			System.out.print(">> 메뉴번호 : ");
			//메뉴 번호 입력
			num = sc.nextInt();
			//5번을 입력하면 프로그램 종료
			if (num == 5) {
				System.out.println("******************************************");
				System.out.println("*               감사합니다               *");
				System.out.println("******************************************");
				break;
			}
			//1번을 입력하면 리스트 불러오기
			if (num == 1) {
				System.out.println("<1. 리스트>");
				//불러올때 리스트 클리어를 해줌
				nList.clear();
				Reader rd = new FileReader("C:\\javaStudy\\미니프로젝트\\PhoneDB.txt");
				BufferedReader br = new BufferedReader(rd);
				
				while(true) {
					String str = br.readLine();
					
					if(str == null) {
						break;
					}
					
					String[] strarr = str.split(",");
					Number n01 = new Number(strarr[0], strarr[1], strarr[2]);
					nList.add(n01);
				}
				
				for (int i = 0; i < nList.size(); i++) {
					System.out.println((i+1) + ".\t" + nList.get(i).getName() +
										"\t" + nList.get(i).getHp() + "\t" + nList.get(i).getCompany());
					
				}
				System.out.println("");
				br.close();
				
			} else if (num == 2) {	//2번을 입력시 목록 등록
				System.out.println("<2. 등록>");
				
				//불러올때 리스트 클리어를 해줌
				nList.clear();
				Reader rd = new FileReader("C:\\javaStudy\\미니프로젝트\\PhoneDB.txt");
				BufferedReader br = new BufferedReader(rd);
				
				while(true) {
					String str = br.readLine();
					
					if(str == null) {
						break;
					}
					
					String[] strarr = str.split(",");
					Number n02 = new Number(strarr[0], strarr[1], strarr[2]);
					nList.add(n02);
				}
				
				Writer wr = new FileWriter("C:\\javaStudy\\미니프로젝트\\PhoneDB.txt");
				BufferedWriter bw = new BufferedWriter(wr);
				
				System.out.print("> 이름 : ");
				name = sc.next();
				System.out.print("> 휴대전화 : ");
				hp = sc.next();
				System.out.print("> 회사전화 : ");
				company = sc.next();
				
				Number n03 = new Number(name, hp, company);
				nList.add(n03);

				for(int i = 0; i < nList.size(); i++) {
					bw.write(nList.get(i).getName() + "," + nList.get(i).getHp() + 
							"," + nList.get(i).getCompany());
					bw.newLine();
				}
				
				System.out.println("[등록되었습니다.]");
				bw.close();
			} else if (num == 3) {	//3번을 입력시 원하는 번호 삭제
				nList.clear();
				System.out.print(">> 번호 : ");
				int number = sc.nextInt();
				
				Reader rd = new FileReader("C:\\javaStudy\\미니프로젝트\\PhoneDB.txt");
				BufferedReader br = new BufferedReader(rd);
				
				while(true) {
					String str = br.readLine();
					
					if(str == null) {
						break;
					}
					
					String[] strarr = str.split(",");
					Number n04 = new Number(strarr[0], strarr[1], strarr[2]);
					nList.add(n04);
				}
				
				for(int i=0; i < nList.size(); i++) {
					if((number-1) == i) {
						nList.remove(i);
					}
				}
				
				Writer wr = new FileWriter("C:\\javaStudy\\미니프로젝트\\PhoneDB.txt");
				BufferedWriter bw = new BufferedWriter(wr);
				
				for(int i = 0; i < nList.size(); i++) {
					bw.write(nList.get(i).getName() + "," + nList.get(i).getHp() + 
							"," + nList.get(i).getCompany());
					bw.newLine();
				}
				
				System.out.println("삭제되었습니다.");
				br.close();
				bw.close();
			} else if(num == 4) {
				
			} else {
				System.out.println("[다시 입력해 주세요.]");
			}
		}	
		sc.close();
	}

}
