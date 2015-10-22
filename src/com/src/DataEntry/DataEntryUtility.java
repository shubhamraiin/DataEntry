/*
 * This class contains all the methods for carrying out the different functionalities of the program.
 */



package com.src.DataEntry;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;
import javax.swing.JTextField;



public class DataEntryUtility {

	@SuppressWarnings("resource")
	
	//The read method stores all the data from the file  into an array list.
	public static ArrayList<DataTransfer> read() {

		String dataguitxt = "DataEntry.txt";
		DataTransfer dat;
		ArrayList<DataTransfer> myArray = new ArrayList<DataTransfer>();

		BufferedReader brd = null;
		try

		{
			String tuple;
			brd = new BufferedReader(new FileReader(dataguitxt));
			while ((tuple = brd.readLine()) != null) {
				dat = new DataTransfer();
				String val[] = tuple.split("\t");
				if (val.length == 11) {
					dat.setFname(val[0]);
					dat.setMi(val[1]);
					dat.setLname(val[2]);
					dat.setAddrs1(val[3]);
					dat.setAddrs2(val[4]);
					dat.setCity(val[5]);
					dat.setState(val[6]);
					dat.setZcode(val[7]);
					dat.setCountry(val[8]);
					dat.setPhone(val[9]);
					dat.setEmail(val[10]);
				}

				myArray.add(dat);

			}

		} catch (IOException e) {
		}
		return myArray;

	}


	public static void save(ArrayList<DataTransfer> myarray) {

		BufferedWriter buffWriter;
		try {
			buffWriter = new BufferedWriter(new FileWriter("DataEntry.txt"));
			for (Iterator<DataTransfer> iterator = myarray.iterator(); iterator
					.hasNext();) {

				DataTransfer addText = (DataTransfer) iterator.next();
				String temp = addText.getFname() + "\t" + addText.getMi()
						+ "\t" + addText.getLname() + "\t"
						+ addText.getAddrs1() + "\t" + addText.getAddrs2()
						+ "\t" + addText.getCity() + "\t" + addText.getState()
						+ "\t" + addText.getZcode() + "\t"
						+ addText.getCountry() + "\t" + addText.getPhone()
						+ "\t" + addText.getEmail();
				buffWriter.write(temp);
				buffWriter.newLine();

			}

			buffWriter.close();
		} catch (IOException e) {

			e.printStackTrace();
		}

	}
	
	
	//This method is for validating the email address entered by the user
	public static boolean isValidEmailAddress(String email) {
		boolean stricterFilter = true;
		String stricterFilterString = "[A-Z0-9a-z._%+-]+@[A-Za-z0-9.-]+\\.[A-Za-z]{2,4}";
		String laxString = ".+@.+\\.[A-Za-z]{2}[A-Za-z]*";
		String emailRegex = stricterFilter ? stricterFilterString : laxString;
		java.util.regex.Pattern p = java.util.regex.Pattern.compile(emailRegex);
		java.util.regex.Matcher m = p.matcher(email);
		return m.matches();
	}
	
	//Displaying all the content of record in the text fields
	public static void displayInFields(JTextField fname, JTextField mi,
			JTextField lname, JTextField addrs1, JTextField addrs2,
			JTextField city, JTextField state, JTextField phone,
			JTextField zcode, JTextField country, JTextField email, int row)
			throws IOException {
		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(new FileInputStream(
					new File("DataEntry.txt"))));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}
		String line;
		int count = 0;
		String lines[] = new String[100];

		while (((lines[count++] = br.readLine()) != null)) {

		}

		line = lines[row];
		br.close();
		String setFields[] = line.split("\t");
		if (setFields.length == 11)
			fname.setText(setFields[0]);
		mi.setText(setFields[1]);
		lname.setText(setFields[2]);
		addrs1.setText(setFields[3]);
		addrs2.setText(setFields[4]);
		city.setText(setFields[5]);
		state.setText(setFields[6]);
		zcode.setText(setFields[7]);
		country.setText(setFields[8]);
		phone.setText(setFields[9]);
		email.setText(setFields[10]);
	}

	@SuppressWarnings("resource")
	//Checking for duplicate records,if the first name,middle initial and last name are same it return true,i.e record already exist in the file
	public static boolean duplicate(String firstName, String mddlName,
			String lastName) {

		String txtfile = "DataEntry.txt";
		BufferedReader brd = null;
		try {
			brd = new BufferedReader(new FileReader(txtfile));

			String tuple;
			while ((tuple = brd.readLine()) != null) {
				String val[] = tuple.split("\t");
				if (val[0].equalsIgnoreCase(firstName)
						&& val[1].equalsIgnoreCase(mddlName)
						&& val[2].equalsIgnoreCase(lastName)) {

					return true;
				}

			}
		} catch (IOException e) {
		}

		return false;
	}
	//Deleted the record from the file ,if the first name,middle initial and last name selected matches a record in the file, it deletes that record
	public static void deleteSelectedRow(String fnm, String mdi, String lnm) {
		ArrayList<DataTransfer> del = new ArrayList<DataTransfer>();
		del = read();
		Iterator<DataTransfer> dataIterator = del.iterator();
		DataTransfer currentData;
		while (dataIterator.hasNext()) {
			currentData = new DataTransfer();
			currentData = (DataTransfer) dataIterator.next();
			if ((currentData.getFname().equalsIgnoreCase(fnm))
					&& (currentData.getMi().equalsIgnoreCase(mdi))
					&& (currentData.getLname().equalsIgnoreCase(lnm)))
				dataIterator.remove();
		}
		save(del);

	}

	

}