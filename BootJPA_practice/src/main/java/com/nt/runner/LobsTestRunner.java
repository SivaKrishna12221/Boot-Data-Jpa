package com.nt.runner;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.InputStream;
import java.io.Reader;
import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import com.nt.entity.Matrimony;
import com.nt.serviceLobs.IMatrimonyService;

//@Component
public class LobsTestRunner implements CommandLineRunner {
	@Autowired
	private IMatrimonyService service;

	@Override
	public void run(String... args) throws Exception {
		Matrimony matri = new Matrimony();
		matri.setName("siva");
		matri.setAddress("k.jangampalli village ");
		String dob = "2000-10-21T10:10:10";
		matri.setDob(LocalDateTime.parse(dob));
		String photoString = "C:\\Users\\SIVA VELPULA\\OneDrive\\Pictures\\00.jpg";
		InputStream is = new FileInputStream(photoString);
		byte[] photoArray = is.readAllBytes();
		matri.setPhoto(photoArray);
		String bioString = "C:\\Users\\SIVA VELPULA\\OneDrive\\Documents\\java files\\siva resume sample.txt";
		// prepare char representing data
		File file = new File(bioString);
		Reader reader = new FileReader(file);
		char[] bioArray = new char[(int) file.length()];
		reader.read(bioArray);
		matri.setBio(bioArray);
		Matrimony matrimony = service.savePersonData(matri);
		System.out.println(matrimony.getName() + "," + matrimony.getAddress() + "," + matrimony.getDob());
	}
}
