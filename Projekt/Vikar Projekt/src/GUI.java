import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.sql.SQLException;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class GUI {
	
	// Login Window
	private JTextField brugernavn;
	private JTextField password;
	private JButton butLogin;

	// Main Window
	private JButton btnLoadWorker;
	private JButton btnCreatWorker;
	private JButton btnSkema;
	private JButton btnAvailSubs;

	// Load Worker
	private JButton btnLoadSub;
	private JButton btnLoadTeacher;
	private JButton btnEditWorker;

	private JTextArea loadBoth;

	// Add Worker
	private JButton btnCreateBoth;

	private JComboBox comboDropdown;

	private JTextArea info;

	private JRadioButton radTeacher;
	private JRadioButton radSubs;

	private JTextField txtFornavn;
	private JTextField txtEfternavn;
	private JTextField txtEMail;
	private JTextField txtMobil;
	private JTextField txtHjemNr;
	private String table = "teacher";

	// Skema
	private JTextField hæst;

	// Ledige Vikarer
	private JButton btnMonday;
	private JButton btnTuesday;
	private JButton btnWednesday;
	private JButton btnThursday;
	private JButton btnFriday;
	private JButton btnSaturday;
	private JButton btnSunday;

	private JTextArea txtareaAvailSubs;

	// Rediger
	private JLabel lblFornavn;
	private JLabel lblEfternavn;
	private JLabel lblMail;
	private JLabel lblMobil;
	private JLabel lblHjem;
	private JLabel loadInfo;
	private JLabel lblWorkerID;

	private JTextField txtWorkerID;

	private JButton btnLoadEmployee;
	private JButton btnEdit;
	private JButton btnWeekDays;
	private JButton btnDelete;

	// Rasmus Wanted This
	private JCheckBox chck0;
	private JCheckBox chck1;
	private JCheckBox chck2;
	private JCheckBox chck3;
	private JCheckBox chck4;
	private JCheckBox chck5;
	private JCheckBox chck6;

	private JButton btnSave;

	// Frame size
	int height = 600;
	int width = 400;

	int textFrameH = 1000;
	int textFrameW = 600;

	int textareaH = 800;
	int textareaW = 500;

	// Create employee variables
	String employee = "";
	String fName = "";
	String lName = "";
	String email = "";
	String cellPhone = "";
	String homePhone = "";

	// Skema
	private JButton btnShowSkema;
	private JLabel labImage;
	private ImageIcon icnImage;

	public GUI() {
		final Administration con = new Administration();
		
		final JFrame loginFrame = new JFrame();
		loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		loginFrame.setLocationRelativeTo(null);
		loginFrame.setSize(height, width);
		loginFrame.setTitle("Main Window");
		loginFrame.setLayout(null);
		loginFrame.setResizable(false);

		butLogin = new JButton("Login");
		butLogin.setBounds(230, 210, 125, 30);
		loginFrame.add(butLogin);

		JLabel labBruger = new JLabel("Brugernavn");
		labBruger.setBounds(230, 100, 120, 25);
		loginFrame.add(labBruger);

		brugernavn = new JTextField("");
		brugernavn.setBounds(230, 120, 120, 25);
		loginFrame.add(brugernavn);

		JLabel labPass = new JLabel("Password");
		labPass.setBounds(230, 150, 120, 25);
		loginFrame.add(labPass);

		password = new JTextField();
		password.setBounds(230, 170, 120, 25);
		loginFrame.add(password);

		butLogin.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				String[] k = new String[2];
				try {
					k = con.login();
				} catch (SQLException e) {
					e.printStackTrace();
				}
				String a, b;
				a = k[0];
				b = k[1];

				if (brugernavn.getText().equals(a)
						&& (password.getText().equals(b))) {
					mainWindow();
					loginFrame.setVisible(false);
				}
			}
		});

		loginFrame.setVisible(true);

	}

	/**
	 * MainWindow Will be updated when necessary, usually to give the user a
	 * better way of using the application
	 * 
	 * Currently: On hold
	 */

	public void mainWindow() {

		final JFrame mainFrame = new JFrame();

		mainFrame.setForeground(Color.WHITE);
		mainFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setSize(height, width);
		mainFrame.setTitle("Main Window");
		mainFrame.setLayout(new FlowLayout());
		mainFrame.setResizable(false);

		btnLoadWorker = new JButton("Indlæs Ansatte");
		mainFrame.add(btnLoadWorker);
		btnLoadWorker.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				loadWorker();
			}
		});

		btnCreatWorker = new JButton("Opret Ansat");
		mainFrame.add(btnCreatWorker);
		btnCreatWorker.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				createWorker();
			}
		});

		btnSkema = new JButton("Se Skema");
		mainFrame.add(btnSkema);
		btnSkema.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				skema();

			}
		});

		btnAvailSubs = new JButton("Ledige Vikarer");
		mainFrame.add(btnAvailSubs);
		btnAvailSubs.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {
				availSubs();
			}
		});

		mainFrame.setVisible(true);
	}

	/**
	 * Indlæs Ansatte
	 * 
	 * Currently: In Progress
	 */

	public void loadWorker() {
		final Employee con = new Employee();
		JFrame loadWorker = new JFrame();

		loadWorker.setLocationRelativeTo(null);
		loadWorker.setSize(textFrameH, textFrameW);
		loadWorker.setTitle("Indlæs Ansatte");
		loadWorker.setLayout(null);
		loadWorker.setResizable(false);

		btnLoadSub = new JButton("Indlæs Vikar");
		btnLoadSub.setBounds(10, 20, 125, 30);
		loadWorker.add(btnLoadSub);

		btnLoadTeacher = new JButton("Indlæs Lærer");
		btnLoadTeacher.setBounds(10, 60, 125, 30);
		loadWorker.add(btnLoadTeacher);

		loadBoth = new JTextArea();
		loadBoth.setEditable(false);

		btnEditWorker = new JButton("Rediger Ansatte");
		btnEditWorker.setBounds(10, 300, 125, 30);
		btnEditWorker.setToolTipText("Upcoming Feature");
		btnEditWorker.setEnabled(true);
		loadWorker.add(btnEditWorker);

		JScrollPane jpane = new JScrollPane(loadBoth);
		jpane.setBounds(155, 20, textareaH, textareaW);
		loadWorker.add(jpane, loadBoth);

		btnLoadSub.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {
				try {
					loadBoth.setText(con.getAllSub());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		btnLoadTeacher.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent arg0) {

				try {
					loadBoth.setText(con.getAllTeacher());
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		btnEditWorker.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				try {
					editWorker();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});

		loadWorker.setVisible(true);
	}

	/**
	 * CreateWorker
	 * 
	 * Currently: In progress
	 */

	public void createWorker() {
		final Employee con = new Employee();

		JFrame addWorker = new JFrame();

		addWorker.setLocationRelativeTo(null);
		addWorker.setSize(height, width);
		addWorker.setTitle("Opret Ansatte");
		addWorker.setLayout(null);
		addWorker.setResizable(false);

		btnCreateBoth = new JButton("Opret");
		btnCreateBoth.setBounds(10, 240, 225, 30);
		addWorker.add(btnCreateBoth);

		// Labels
		lblFornavn = new JLabel("Fornavn");
		lblFornavn.setBounds(10, 25, 45, 15);
		addWorker.add(lblFornavn);

		lblEfternavn = new JLabel("Efternavn");
		lblEfternavn.setBounds(240, 25, 55, 15);
		addWorker.add(lblEfternavn);

		lblMail = new JLabel("E-Mail");
		lblMail.setBounds(10, 80, 45, 15);
		addWorker.add(lblMail);

		lblMobil = new JLabel("Mobil nr.");
		lblMobil.setBounds(10, 135, 55, 15);
		addWorker.add(lblMobil);

		lblHjem = new JLabel("Hjem nr.");
		lblHjem.setBounds(240, 135, 55, 15);
		addWorker.add(lblHjem);

		// TextFields
		txtFornavn = new JTextField();
		txtFornavn.setBounds(10, 50, 225, 20);
		addWorker.add(txtFornavn);

		txtEfternavn = new JTextField();
		txtEfternavn.setBounds(240, 50, 225, 20);
		addWorker.add(txtEfternavn);

		txtEMail = new JTextField();
		txtEMail.setBounds(10, 105, 460, 20);
		addWorker.add(txtEMail);

		txtMobil = new JTextField();
		txtMobil.setBounds(10, 160, 225, 20);
		addWorker.add(txtMobil);

		txtHjemNr = new JTextField();
		txtHjemNr.setBounds(240, 160, 225, 20);
		addWorker.add(txtHjemNr);

		radTeacher = new JRadioButton("Lærer");
		radTeacher.setBounds(10, 195, 110, 25);
		addWorker.add(radTeacher);
		radTeacher.setSelected(true);

		radSubs = new JRadioButton("Vikar");
		radSubs.setBounds(125, 195, 110, 25);
		addWorker.add(radSubs);

		ButtonGroup group = new ButtonGroup();
		group.add(radSubs);
		group.add(radTeacher);

		btnCreateBoth.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				fName = txtFornavn.getText();
				lName = txtEfternavn.getText();
				email = txtEMail.getText();
				cellPhone = txtMobil.getText();
				homePhone = txtHjemNr.getText();

				if (radTeacher.isSelected()) {
					employee = "teacher";
					con.addEmployee(employee, fName, lName, email, cellPhone,
							homePhone);

				} else if (radSubs.isSelected()) {
					employee = "substitute";
					con.addEmployee(employee, fName, lName, email, cellPhone,
							homePhone);

				}
			}
		});

		// dropdown = new JComboBox<>();
		// dropdown.setBounds(315, 20, 235, 30);
		// addWorker.add(dropdown);

		addWorker.setVisible(true);
	}

	/**
	 * Skema
	 * 
	 * Currently: In progress
	 */

	public void skema() {

		final JFrame skema = new JFrame();

		skema.setLocationRelativeTo(null);
		skema.setSize(height, width);
		skema.setTitle("Skema");
		skema.setLayout(new FlowLayout());
		skema.setResizable(true);

		btnShowSkema = new JButton("Find Skema");

		skema.add(btnShowSkema);

		btnShowSkema.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFileChooser choose = new JFileChooser();
				File f = new File("src");
				choose.setCurrentDirectory(f);

				choose.showOpenDialog(null);
				String name = choose.getSelectedFile().getName();

				icnImage = new ImageIcon(getClass().getResource(name));
				labImage = new JLabel(icnImage);
				JScrollPane scrollPane = new JScrollPane(labImage);
				scrollPane.setPreferredSize(new Dimension(700, 700));
				skema.add(scrollPane, labImage);
				skema.pack();
			}
		});

		skema.pack();
		skema.setVisible(true);
	}

	/**
	 * Beta: Making a new window for Teacher and Sub information Opens after you
	 * click on a teacher name from LoadWorker and then click the Load Info
	 * button Opens a window that can be used to access buttons to edit and/or
	 * to contact the given person.
	 * 
	 * Currently: In-progress
	 */

	public void editWorker() throws SQLException {
		final Employee con = new Employee();
		JFrame loadInfo = new JFrame();

		loadInfo.setLocationRelativeTo(null);
		loadInfo.setSize(height, width);
		loadInfo.setTitle("Rediger Ansatte");
		loadInfo.setLayout(null);
		loadInfo.setResizable(false);

		// Labels
		lblFornavn = new JLabel("Fornavn");
		lblFornavn.setBounds(10, 80, 45, 15);
		loadInfo.add(lblFornavn);

		lblEfternavn = new JLabel("Efternavn");
		lblEfternavn.setBounds(240, 80, 55, 15);
		loadInfo.add(lblEfternavn);

		lblMail = new JLabel("E-Mail");
		lblMail.setBounds(10, 135, 45, 15);
		loadInfo.add(lblMail);

		lblMobil = new JLabel("Mobil");
		lblMobil.setBounds(10, 190, 55, 15);
		loadInfo.add(lblMobil);

		lblHjem = new JLabel("Hjem");
		lblHjem.setBounds(240, 190, 55, 15);
		loadInfo.add(lblHjem);

		lblWorkerID = new JLabel("Worker ID");
		lblWorkerID.setBounds(10, 20, 85, 15);
		loadInfo.add(lblWorkerID);

		// TextFields
		txtFornavn = new JTextField();
		txtFornavn.setBounds(10, 105, 225, 20);
		loadInfo.add(txtFornavn);

		txtEfternavn = new JTextField();
		txtEfternavn.setBounds(240, 105, 225, 20);
		loadInfo.add(txtEfternavn);

		txtEMail = new JTextField();
		txtEMail.setBounds(10, 160, 460, 20);
		loadInfo.add(txtEMail);

		txtMobil = new JTextField();
		txtMobil.setBounds(10, 215, 225, 20);
		loadInfo.add(txtMobil);

		txtHjemNr = new JTextField();
		txtHjemNr.setBounds(240, 215, 225, 20);
		loadInfo.add(txtHjemNr);

		txtWorkerID = new JTextField();
		txtWorkerID.setBounds(10, 50, 85, 20);
		loadInfo.add(txtWorkerID);

		// RadioButtons
		radTeacher = new JRadioButton("Lærer");
		radTeacher.setBounds(10, 250, 110, 25);
		loadInfo.add(radTeacher);

		radSubs = new JRadioButton("Vikar");
		radSubs.setBounds(125, 250, 110, 25);

		ButtonGroup g = new ButtonGroup();
		g.add(radSubs);
		g.add(radTeacher);
		loadInfo.add(radSubs);
		radTeacher.setSelected(true);

		// Buttons
		btnEdit = new JButton("Gem");
		btnEdit.setBounds(10, 280, 225, 30);
		loadInfo.add(btnEdit);

		btnLoadEmployee = new JButton("Indlæs");
		btnLoadEmployee.setBounds(110, 50, 85, 20);
		loadInfo.add(btnLoadEmployee);

		btnWeekDays = new JButton("Ugedage");
		btnWeekDays.setBounds(240, 280, 225, 30);
		btnWeekDays.setEnabled(false);
		loadInfo.add(btnWeekDays);

		radSubs.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnWeekDays.setEnabled(true);
				table = "substitute";

			}
		});
		radTeacher.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				btnWeekDays.setEnabled(false);
				table = "teacher";

			}
		});

		btnLoadEmployee.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String[] teachInfo;
				String Worker = txtWorkerID.getText();
				int WorkerID = Integer.parseInt(Worker);
				try {
					teachInfo = con.getEmployeeInfo(WorkerID, table);
					txtFornavn.setText(teachInfo[0]);
					txtEfternavn.setText(teachInfo[1]);
					txtEMail.setText(teachInfo[2]);
					txtMobil.setText(teachInfo[3]);
					txtHjemNr.setText(teachInfo[4]);

				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		btnEdit.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = txtWorkerID.getText();
				String fName = txtFornavn.getText();
				String lName = txtEfternavn.getText();
				String email = txtEMail.getText();
				String cellPhone = txtMobil.getText();
				String homePhone = txtHjemNr.getText();

				try {
					con.setEmployee(table, id, fName, lName, email, cellPhone,
							homePhone);
				} catch (SQLException e1) {

					e1.printStackTrace();
				}

			}
		});

		btnWeekDays.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent arg0) {

				weekDays();

			}
		});

		btnDelete = new JButton("Slet");
		btnDelete.setBounds(10, 320, 225, 30);
		loadInfo.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				String id = txtWorkerID.getText();
				try {
					con.deleteEmployee(id, table);
				} catch (SQLException e) {

					e.printStackTrace();
				}

			}
		});

		loadInfo.setVisible(true);

	}

	public void weekDays() {
		 final Weekday con = new Weekday();
		JFrame weekDays = new JFrame();

		weekDays.setLocationRelativeTo(null);
		weekDays.setSize(240, 320);
		weekDays.setTitle("Uge Dage");
		weekDays.setLayout(null);
		weekDays.setResizable(false);

		String[] s = new String[7];
		try {
			s = con.getAvailable(txtWorkerID.getText());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		final String man = s[0];
		final String tir = s[1];
		final String ons = s[2];
		final String tor = s[3];
		final String fre = s[4];
		final String lør = s[5];
		final String søn = s[6];

		// System.out.println(man + tir + ons + tor + fre + lør + søn);

		chck0 = new JCheckBox("Mandag");
		chck0.setBounds(15, 20, 100, 25);
		weekDays.add(chck0);
		if (man.equals("0")) {
			chck0.setSelected(false);
		} else {
			chck0.setSelected(true);
		}

		chck1 = new JCheckBox("Tirsdag");
		chck1.setBounds(15, 50, 100, 25);
		weekDays.add(chck1);
		if (tir.equals("0")) {
			chck1.setSelected(false);
		} else {
			chck1.setSelected(true);
		}

		chck2 = new JCheckBox("Onsdag");
		chck2.setBounds(16, 80, 100, 25);
		weekDays.add(chck2);
		if (ons.equals("0")) {
			chck2.setSelected(false);
		} else {
			chck2.setSelected(true);
		}

		chck3 = new JCheckBox("Torsdag");
		chck3.setBounds(16, 110, 100, 25);
		weekDays.add(chck3);
		if (tor.equals("0")) {
			chck3.setSelected(false);
		} else {
			chck3.setSelected(true);
		}

		chck4 = new JCheckBox("Fredag");
		chck4.setBounds(16, 140, 100, 25);
		weekDays.add(chck4);
		if (fre.equals("0")) {
			chck4.setSelected(false);
		} else {
			chck4.setSelected(true);
		}

		chck5 = new JCheckBox("Lørdag");
		chck5.setBounds(16, 170, 100, 25);
		weekDays.add(chck5);
		if (lør.equals("0")) {
			chck5.setSelected(false);
		} else {
			chck5.setSelected(true);
		}

		chck6 = new JCheckBox("Søndag");
		chck6.setBounds(16, 200, 100, 25);
		weekDays.add(chck6);
		if (søn.equals("0")) {
			chck6.setSelected(false);
		} else {
			chck6.setSelected(true);
		}

		btnSave = new JButton("Gem");
		btnSave.setBounds(15, 230, 175, 23);
		weekDays.add(btnSave);

		btnSave.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				String[] weekdays = new String[7];

				if (chck0.isSelected())
					weekdays[0] = "1";
				else
					weekdays[0] = "0";

				if (chck1.isSelected())
					weekdays[1] = "1";
				else
					weekdays[1] = "0";

				if (chck2.isSelected())
					weekdays[2] = "1";
				else
					weekdays[2] = "0";

				if (chck3.isSelected())
					weekdays[3] = "1";
				else
					weekdays[3] = "0";

				if (chck4.isSelected())
					weekdays[4] = "1";
				else
					weekdays[4] = "0";

				if (chck5.isSelected())
					weekdays[5] = "1";
				else
					weekdays[5] = "0";

				if (chck6.isSelected())
					weekdays[6] = "1";
				else
					weekdays[6] = "0";

				try {
					con.updateWeekdays(txtWorkerID.getText(), weekdays);
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		weekDays.setVisible(true);

	}

	public void availSubs() {
		final Weekday con = new Weekday();
		JFrame availSubs = new JFrame();

		availSubs.setLocationRelativeTo(null);
		availSubs.setSize(textFrameH, textFrameW);
		availSubs.setTitle("Ledige");
		availSubs.setLayout(null);
		availSubs.setResizable(false);

		txtareaAvailSubs = new JTextArea();
		txtareaAvailSubs.setEditable(false);

		JScrollPane jpane = new JScrollPane(txtareaAvailSubs);
		jpane.setBounds(155, 20, textareaH, textareaW);
		availSubs.add(jpane, txtareaAvailSubs);

		// Buttons
		btnMonday = new JButton("Mandag");
		btnMonday.setBounds(10, 20, 125, 30);
		availSubs.add(btnMonday);

		btnMonday.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				int day = 0;
				try {
					txtareaAvailSubs.setText("Mandag: \n"
							+ con.getAvailableWeekday(day));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		btnTuesday = new JButton("Tirsdag");
		btnTuesday.setBounds(10, 60, 125, 30);
		availSubs.add(btnTuesday);

		btnTuesday.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				int day = 1;
				try {
					txtareaAvailSubs.setText("Tirsdag: \n"
							+ con.getAvailableWeekday(day));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		btnWednesday = new JButton("Onsdag");
		btnWednesday.setBounds(10, 100, 125, 30);
		availSubs.add(btnWednesday);

		btnWednesday.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				int day = 2;
				try {
					txtareaAvailSubs.setText("Onsdag: \n"
							+ con.getAvailableWeekday(day));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		btnThursday = new JButton("Torsdag");
		btnThursday.setBounds(10, 140, 125, 30);
		availSubs.add(btnThursday);

		btnThursday.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				int day = 3;
				try {
					txtareaAvailSubs.setText("Torsday: \n"
							+ con.getAvailableWeekday(day));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		btnFriday = new JButton("Fredag");
		btnFriday.setBounds(10, 180, 125, 30);
		availSubs.add(btnFriday);

		btnFriday.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				int day = 4;
				try {
					txtareaAvailSubs.setText("Fredag: \n"
							+ con.getAvailableWeekday(day));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		btnSaturday = new JButton("Lørdag");
		btnSaturday.setBounds(10, 220, 125, 30);
		availSubs.add(btnSaturday);

		btnSaturday.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				int day = 5;
				try {
					txtareaAvailSubs.setText("Lørdag: \n"
							+ con.getAvailableWeekday(day));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		btnSunday = new JButton("Søndag");
		btnSunday.setBounds(10, 260, 125, 30);
		availSubs.add(btnSunday);

		btnSunday.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent arg0) {
				int day = 6;
				try {
					txtareaAvailSubs.setText("Søndag: \n"
							+ con.getAvailableWeekday(day));
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		availSubs.setVisible(true);

	}

}