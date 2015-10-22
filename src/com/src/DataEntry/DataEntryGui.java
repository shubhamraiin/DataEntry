/*
 * Name: Shubham Rai
 * Net-id: scr130130
 * Assignment 2
 * Cs 6301: User interface design and development for mobile devices
 */


package com.src.DataEntry;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JSeparator;
import java.awt.Color;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.swing.JButton;
import java.awt.Font;

public class DataEntryGui extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	ArrayList<DataTransfer> myArray;
	DataTransfer dt;
	private JPanel contentPane;
	private JTextField fname;
	private JTextField mi;
	private JTextField lname;
	private JLabel lblAddress;
	private JTextField addrs1;
	private JTextField addrs2;
	private JLabel lblCity;
	private JTextField city;
	private JLabel lblState;
	private JTextField state;
	private JLabel lblZipCode;
	private JTextField zcode;
	private JLabel lblCountry;
	private JTextField country;
	private JLabel lblPhone;
	private JTextField phone;
	private JLabel lblEmail;
	private JTextField email;
	private JSeparator separator_2;
	private JTable table;
	private DefaultTableModel mytable;
	private JLabel lblNote;
	private JLabel statusPos;
	private JLabel statusNeg;
	private JLabel statusMessage;
	private JPanel panel;

	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DataEntryGui frame = new DataEntryGui();
					frame.setVisible(true);
					
					
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Creates the frame.
	 *  Frame hold the various Text fields and buttons  for entering information into the table and file

	 */
	@SuppressWarnings("serial")
	public DataEntryGui() {
		super("Data Entry");

		myArray = new ArrayList<DataTransfer>();
		myArray = DataEntryUtility.read();

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 847, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		statusNeg = new JLabel("");
		statusNeg.setForeground(Color.RED);
		statusNeg.setBounds(10, 267, 401, 14);
		contentPane.add(statusNeg);

		statusPos = new JLabel("", SwingConstants.CENTER);
		statusPos.setForeground(new Color(0, 128, 0));
		statusPos.setBounds(446, 297, 375, 18);
		contentPane.add(statusPos);

		statusMessage = new JLabel("");
		statusMessage.setForeground(new Color(0, 51, 255));
		statusMessage.setBounds(79, 246, 332, 14);
		contentPane.add(statusMessage);

		JLabel lblFirstName = new JLabel("First Name*");
		lblFirstName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFirstName.setBounds(4, 14, 67, 14);
		contentPane.add(lblFirstName);

		fname = new JTextField(20);
		fname.addKeyListener(new KeyAdapter() {

			public void keyTyped(KeyEvent arg0) {
				statusMessage.setText("Enter max 20 characters");
				statusNeg.setText("");
			}
		});
		fname.setBounds(79, 11, 86, 20);
		contentPane.add(fname);
		fname.setColumns(10);
		fname.setDocument(new JTextFieldLimit(20));

		JLabel lblMi = new JLabel("M.I");
		lblMi.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMi.setBounds(175, 14, 26, 14);
		contentPane.add(lblMi);

		mi = new JTextField(1);
		mi.addKeyListener(new KeyAdapter() {

			public void keyTyped(KeyEvent e) {
				statusMessage.setText("");
				statusNeg.setText("");
			}
		});
		mi.setBounds(215, 11, 34, 20);
		contentPane.add(mi);
		mi.setColumns(10);
		mi.setDocument(new JTextFieldLimit(1));

		JLabel lblLastName = new JLabel("Last Name*");
		lblLastName.setHorizontalAlignment(SwingConstants.RIGHT);
		lblLastName.setBounds(258, 14, 67, 14);
		contentPane.add(lblLastName);

		lname = new JTextField(20);
		lname.addKeyListener(new KeyAdapter() {

			public void keyTyped(KeyEvent e) {
				statusMessage.setText("Enter max 20 characters");
				statusNeg.setText("");
			}
		});
		lname.setToolTipText("Enter max 20 charcaters");
		lname.setBounds(330, 11, 86, 20);
		contentPane.add(lname);
		lname.setColumns(10);
		lname.setDocument(new JTextFieldLimit(20));

		lblAddress = new JLabel("Address*");
		lblAddress.setHorizontalAlignment(SwingConstants.RIGHT);
		lblAddress.setBounds(10, 53, 59, 14);
		contentPane.add(lblAddress);

		addrs1 = new JTextField(35);
		addrs1.setToolTipText("Line 1");
		addrs1.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				statusMessage.setText("Enter Address,Line 1 is mandatory");
			}
		});
		addrs1.setBounds(78, 50, 247, 20);
		contentPane.add(addrs1);
		addrs1.setColumns(10);
		addrs1.setDocument(new JTextFieldLimit(35));

		addrs2 = new JTextField(35);
		addrs2.setToolTipText("Line 2");
		addrs2.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {
				statusMessage.setText("");
				statusNeg.setText("");
			}
		});
		addrs2.setText("");
		addrs2.setBounds(78, 81, 247, 20);
		contentPane.add(addrs2);
		addrs2.setColumns(10);
		addrs2.setDocument(new JTextFieldLimit(35));

		lblCity = new JLabel("City*");
		lblCity.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCity.setBounds(23, 115, 46, 14);
		contentPane.add(lblCity);

		city = new JTextField(25);
		city.addKeyListener(new KeyAdapter() {

			public void keyTyped(KeyEvent e) {
				char c = e.getKeyChar();
				if ((Character.isDigit(c))) {

					getToolkit().beep();
					e.consume();
				}
				statusMessage.setText("Enter max 25 characters");
				statusNeg.setText("");

			}
		});
		city.setBounds(79, 112, 67, 20);
		contentPane.add(city);
		city.setColumns(10);
		city.setDocument(new JTextFieldLimit(25));

		lblState = new JLabel("State*");
		lblState.setHorizontalAlignment(SwingConstants.RIGHT);
		lblState.setBounds(155, 112, 46, 14);
		contentPane.add(lblState);

		state = new JTextField(2);
		state.addKeyListener(new KeyAdapter() {

			public void keyTyped(KeyEvent e) {

				char c = e.getKeyChar();
				if ((Character.isDigit(c))) {

					getToolkit().beep();
					e.consume();
				}

				statusMessage.setText("Enter max 2 characters");
				statusNeg.setText("");
			}
		});
		state.setBounds(215, 112, 34, 20);
		contentPane.add(state);
		state.setColumns(10);
		state.setDocument(new JTextFieldLimit(2));

		lblZipCode = new JLabel("Zip Code*");
		lblZipCode.setHorizontalAlignment(SwingConstants.RIGHT);
		lblZipCode.setBounds(10, 146, 59, 14);
		contentPane.add(lblZipCode);

		zcode = new JTextField(9);
		zcode.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {

					statusMessage.setText("Enter Digits Only");
					statusNeg.setText("");
					getToolkit().beep();
					arg0.consume();

				}

			}
		});
		zcode.setBounds(79, 143, 67, 20);
		contentPane.add(zcode);
		zcode.setColumns(10);
		zcode.setDocument(new JTextFieldLimit(9));

		lblCountry = new JLabel("Country*");
		lblCountry.setHorizontalAlignment(SwingConstants.RIGHT);
		lblCountry.setBounds(147, 146, 58, 14);
		contentPane.add(lblCountry);

		country = new JTextField(30);
		country.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent e) {

				char c = e.getKeyChar();
				if ((Character.isDigit(c))) {

					getToolkit().beep();
					e.consume();
				}

				statusNeg.setText("");
				statusMessage.setText("Enetr max 30 charcters");
			}
		});
		country.setBounds(215, 143, 67, 20);
		contentPane.add(country);
		country.setColumns(10);
		country.setDocument(new JTextFieldLimit(30));

		lblPhone = new JLabel("Phone *");
		lblPhone.setHorizontalAlignment(SwingConstants.RIGHT);
		lblPhone.setBounds(23, 189, 46, 14);
		contentPane.add(lblPhone);

		phone = new JTextField();
		phone.addKeyListener(new KeyAdapter() {
			@Override
			public void keyTyped(KeyEvent arg0) {
				char c = arg0.getKeyChar();
				if (!(Character.isDigit(c) || (c == KeyEvent.VK_BACK_SPACE) || c == KeyEvent.VK_DELETE)) {
					getToolkit().beep();
					arg0.consume();
					statusMessage.setText("Enter Digits Only");
					statusNeg.setText("");

				}
			}
		});
		phone.setBounds(79, 186, 86, 20);
		contentPane.add(phone);
		phone.setColumns(10);
		phone.setDocument(new JTextFieldLimit(21));

		lblEmail = new JLabel("Email*");
		lblEmail.setHorizontalAlignment(SwingConstants.RIGHT);
		lblEmail.setBounds(23, 220, 46, 14);
		contentPane.add(lblEmail);

		email = new JTextField(100);
		email.addKeyListener(new KeyAdapter() {

			public void keyTyped(KeyEvent e) {
				email.setBorder(BorderFactory.createLineBorder(Color.gray));
				statusMessage.setText("");
				statusNeg.setText("");

			}
		});
		email.setBounds(78, 217, 247, 20);
		contentPane.add(email);
		email.setColumns(10);
		email.setDocument(new JTextFieldLimit(100));

		lblNote = new JLabel("* Fields must be filled!");
		lblNote.setForeground(new Color(0, 0, 128));
		lblNote.setFont(new Font("Times New Roman", Font.ITALIC, 15));
		lblNote.setBounds(2, 326, 163, 14);
		contentPane.add(lblNote);

		JSeparator separator = new JSeparator();
		separator.setBounds(37, 39, 374, 5);
		contentPane.add(separator);

		JSeparator separator_1 = new JSeparator();
		separator_1.setBounds(37, 171, 374, 2);
		contentPane.add(separator_1);

		separator_2 = new JSeparator();
		separator_2.setOrientation(SwingConstants.VERTICAL);
		separator_2.setBounds(434, 11, 2, 304);
		contentPane.add(separator_2);

		
		//Creating an instance of DefaultTable Model
		mytable = new DefaultTableModel() {

			//  this method disallows cells of the table to be editable
			public boolean isCellEditable(int rowIndex, int colIndex) {
				return false; 
			}
		};

		mytable.addColumn(" First Name");
		mytable.addColumn(" Middle Initial");
		mytable.addColumn(" Last Name");
		mytable.addColumn("Phone");

		// Code for displaying initial data
		BufferedReader brd = null;
		try {
			brd = new BufferedReader(new InputStreamReader(new FileInputStream(
					new File("DataEntry.txt"))));
		} catch (FileNotFoundException e) {

			e.printStackTrace();
		}

		int count = 0;
		String lines[] = new String[100];
		try {
			while (((lines[count] = brd.readLine()) != null)) {
				String line = lines[count];
				String[] splitArray = line.split("\t");
				if (splitArray.length == 11) {

					String[] record = new String[4];
					record[0] = splitArray[0];
					record[1] = splitArray[1];
					record[2] = splitArray[2];
					record[3] = splitArray[9];
					mytable.addRow(record);
				}
			}
		} catch (IOException e1) {

			e1.printStackTrace();
		}

		//The Add button is used to add data to the file and to the table
		  

		final JButton Save = new JButton("Add");
		Save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				saveInFile();           //Validates the data entered by the user and writes to file.It also maps the data to Data Transfer class

				statusMessage.setText("");

			}

		});
		Save.setBounds(10, 292, 86, 23);
		contentPane.add(Save);
        
		//The Update button is used to modify data,changes are then reflected in the file as well as in table
		  
		JButton Modify = new JButton("Update");
		Modify.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int selRow = table.getSelectedRow();
				if (selRow != -1) {

					myArray.remove(selRow);
					DataEntryUtility.save(myArray);    //Saves the changes in the array list
					mytable.removeRow(selRow);  
					saveInFile();                      //Validates the data entered by the user and writes to file

					statusPos.setText("Record Modified Successfully!");
					makeFieldsEmpty();                 //Clears the information in the fields
					statusNeg.setText("");
					statusMessage.setText("");

				} else
					statusNeg.setText("Select a row from the table!");

			}
		});
		Modify.setBounds(115, 292, 86, 23);
		contentPane.add(Modify);
		
		//The Delete button is used to delete a record from table as well as from file

		JButton Delete = new JButton("Delete");
		Delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				int selRow = table.getSelectedRow();

				if (selRow != -1) {
					String fnm = (String) table.getValueAt(selRow, 0);
					String mdi = (String) table.getValueAt(selRow, 1);
					String lnm = (String) table.getValueAt(selRow, 2);

					mytable.removeRow(selRow);                          //removes the record from table
					DataEntryUtility.deleteSelectedRow(fnm, mdi, lnm);  //removes the record from file after comparing the first,middle initial and last name

					statusPos.setText("Record Deleted Successfully!");
					statusNeg.setText("");
					statusMessage.setText("");
					makeFieldsEmpty();

				} else
					statusNeg.setText("Select a row from the table!");

			}

		});
		Delete.setBounds(218, 292, 86, 23);
		contentPane.add(Delete);

		//The Reset button clears all fields
		
		JButton Reset = new JButton("Reset");
		Reset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				fname.setText("");
				mi.setText("");
				lname.setText("");
				city.setText("");
				addrs1.setText("");
				addrs2.setText("");
				city.setText("");
				state.setText("");
				zcode.setText("");
				country.setText("");
				phone.setText("");
				email.setText("");
				Save.setEnabled(true);
				statusNeg.setText("");
				statusPos.setText("");
				statusMessage.setText("");
				email.setBorder(BorderFactory.createLineBorder(Color.gray));

			}
		});
		Reset.setBounds(325, 292, 86, 23);
		contentPane.add(Reset);

		panel = new JPanel();
		panel.setBounds(446, 11, 375, 270);
		contentPane.add(panel);
		panel.setLayout(null);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(0, 0, 375, 270);
		panel.add(scrollPane);

		table = new JTable();
		table.setBackground(Color.WHITE);
		table.setBounds(496, 255, 302, -205);
		table.getSelectionModel().addListSelectionListener(
				new ListSelectionListener() {

					// calls the method to display the content in each field and  Checks for any changes made in a field 

					public void valueChanged(ListSelectionEvent arg0) {
						try {

							if (arg0.getValueIsAdjusting()) {
								DataEntryUtility.displayInFields(fname, mi,
										lname, addrs1, addrs2, city, state,
										phone, zcode, country, email,
										table.getSelectedRow());
							}

						} catch (IOException e) {

							e.printStackTrace();
						}
					}
				});

		scrollPane.setViewportView(table);
		scrollPane.setVisible(true);
		scrollPane.repaint();
		table.setFillsViewportHeight(true);
		table.setModel(mytable);

	}
	
	//This method is used for saving data to the file and maps the data to DataTranser Class

	public void saveInFile() {
		dt = new DataTransfer();
		if ((!fname.getText().equalsIgnoreCase(""))
				&& !(lname.getText().equalsIgnoreCase(""))
				&& !(addrs1.getText().equalsIgnoreCase(""))
				&& !(city.getText().equalsIgnoreCase(""))
				&& !(state.getText().equalsIgnoreCase(""))
				&& !(zcode.getText().equalsIgnoreCase(""))
				&& !(country.getText().equalsIgnoreCase(""))
				&& !(phone.getText().equalsIgnoreCase(""))
				&& !(email.getText().equalsIgnoreCase(""))) {
				//Validating email id
			if (!(DataEntryUtility.isValidEmailAddress(email.getText()))) {                   

				email.setBorder(BorderFactory.createLineBorder(Color.red));
				statusNeg.setText(" Enter valid Email id,Eg: abc@gmail.com");
				//Checking if the record already exist 
			} else if (DataEntryUtility.duplicate(fname.getText(),
					mi.getText(), lname.getText())) {
				statusNeg.setText("Record Already Exists!");

			} else {
				dt.setFname(fname.getText());
				dt.setMi(mi.getText());
				dt.setLname(lname.getText());
				dt.setAddrs1(addrs1.getText());
				dt.setAddrs2(addrs2.getText());
				dt.setCity(city.getText());
				dt.setState(state.getText());
				dt.setZcode(zcode.getText());
				dt.setCountry(country.getText());
				dt.setPhone(phone.getText());
				dt.setEmail(email.getText());

				myArray.add(dt);

				DataEntryUtility.save(myArray);
				String[] reocrd = new String[4];
				reocrd[0] = fname.getText();
				reocrd[1] = mi.getText();
				reocrd[2] = lname.getText();
				reocrd[3] = phone.getText();
				mytable.addRow(reocrd);
				statusPos.setText("Record Added Successfully!");

			}

		}

		else {
			statusNeg.setText("Fields marked as * must be filled!");
		}

	}
//Clears all fields.Invoked after deletion or modification of record
	public void makeFieldsEmpty() {
		fname.setText("");
		mi.setText("");
		lname.setText("");
		city.setText("");
		addrs1.setText("");
		addrs2.setText("");
		city.setText("");
		state.setText("");
		zcode.setText("");
		country.setText("");
		phone.setText("");
		email.setText("");

	}
}
