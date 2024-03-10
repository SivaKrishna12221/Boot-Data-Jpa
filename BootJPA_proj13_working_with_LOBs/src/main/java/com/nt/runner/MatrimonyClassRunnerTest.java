package com.nt.runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.time.LocalDateTime;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.MarriageSeekar;
import com.nt.service.IMarriageService;

@Component
public class MatrimonyClassRunnerTest implements CommandLineRunner {
	@Autowired
	private IMarriageService service;
	@Override
	public void run(String... args) throws Exception {
		Scanner sc = new Scanner(System.in);
		System.out.println("enter id:");
		int num=sc.nextInt();
		sc.nextLine();
		System.out.println("Enter name:");
		String name = sc.nextLine();
		System.out.println("Enter address:");
		String address = sc.nextLine();
		System.out.println("enter person photo file complete classpath:");
		String photo = sc.nextLine().replace("?", "");
		System.out.println("enter person biodata file complete path:");
		String bioData = sc.nextLine().replace("?", "");
		System.out.println("enter date of birth(yyyy-mm-ddThh:mm:ss):");
		String dob=sc.nextLine();
		System.out.println("are you indian?");
		Boolean indian = sc.nextBoolean();
		// convert the photo file into byte array:
		InputStream fis = new FileInputStream(photo);
		byte[] photoBytes = new byte[fis.available()];
		photoBytes = fis.readAllBytes();
		
		
		File file = new File(bioData);
		
		Reader fr = new FileReader(file);
		char[] bioChar = new char[(int) file.length()];
		fr.read(bioChar);// here reading characters
		LocalDateTime ldt=LocalDateTime.parse(dob);
		MarriageSeekar seekar=new MarriageSeekar(num,name,address,photoBytes,bioChar,ldt,indian);
		
		String result=service.submitPersonDetails(seekar);
		System.out.println(result);
		/*Optional<MarriageSeekar> opt=service.showMarriageSeekarById(100);
		if(opt.isPresent())
		{
			MarriageSeekar seekar=opt.get();
			System.out.println(seekar.getId()+","+seekar.getName()+","+seekar.getAddress()+","+seekar.getPhoto()+","+seekar.getLocalDateTime());
			FileOutputStream fos=new FileOutputStream("retrive_photo.gfif");
			fos.write(seekar.getPhoto());
			System.out.println("photo retrived successfully");
			fos.flush();
			fos.close();
			
			FileWriter fw=new FileWriter("retrive_bio.txt");
			fw.write(seekar.getBioData());
			fw.flush();
			fw.close();
			
		}
		else
		{
			throw new IllegalArgumentException("no id found");
		}*/
	}
}
