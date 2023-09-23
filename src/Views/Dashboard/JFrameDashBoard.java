package Views.Dashboard;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Entities.Employees;
import Models.CSS.StyleColor;
import Models.Employees.EmployeeModel;
import Views.Index;
import Views.Employees.JPanelChangePassword;
import Views.Invoices.JPanelInvoices;
import Views.Product.AddProduct;
import Views.Product.JPanelProduct;

import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JMenuBar;
import java.awt.FlowLayout;

import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JMenuItem;
import javax.swing.JMenu;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JDialog;

import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Dimension;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Component;
import java.awt.Dialog.ModalityType;

import javax.swing.JSeparator;
import java.awt.SystemColor;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;
import java.awt.Color;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;

public class JFrameDashBoard extends JFrame {

	private JPanel JPanelContentDashboard;
	private JPanel jpanelContent;
	private static int employeeId;
	private JMenu jMenuUser;
	private EmployeeModel employeeModel = new EmployeeModel();
	private JButton jbtnInventory;
	private JButton jbtnInvoices;
	private JButton jbtnInformManager;
	private JButton jbtnHelp;
	private JButton jbtnSaleRequest;
	private JButton jbtnValidateInventory;
	private JButton jbtnReportInventory;
	private JButton jbtnInventoryTrends;
	private JButton jbtnInvoiceToday;
	private JButton jbtnTransaction;
	private JButton jbtnReturnedToday;
	private JButton jbtnSalesTrend;
	private JButton jbtnAddProductCategory;

	/**
	 * Launch the application.
	 */
	

	public static void main(String[] args) {
		try {
			UIManager.setLookAndFeel("javax.swing.plaf.nimbus.NimbusLookAndFeel");
			UIManager.put("Button.focusPainted", false);
			UIManager.put("Button.borderPainted", false);

		} catch (Throwable e) {
			e.printStackTrace();
		}
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameDashBoard frame = new JFrameDashBoard();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public JFrameDashBoard() {

		setTitle("Warehouse Management");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 903, 685);

		JMenuBar menuBar = new JMenuBar();
		menuBar.setForeground(new Color(135, 206, 250));
		menuBar.setAlignmentY(Component.CENTER_ALIGNMENT);
		menuBar.setOpaque(true);
		menuBar.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		menuBar.setBackground(new Color(230, 230, 250));
		setJMenuBar(menuBar);

		jMenuUser = new JMenu("User");
		jMenuUser.setBorderPainted(true);
		jMenuUser.setMargin(new Insets(3, 8, 3, 8));
		jMenuUser.setFont(new Font("MesloLGM Nerd Font Mono", Font.BOLD, 14));
		menuBar.add(jMenuUser);

		JMenuItem jMenuItemInformation = new JMenuItem("Information");
		jMenuUser.add(jMenuItemInformation);

		JMenuItem jMenuItemChangePassword = new JMenuItem("Change Password");
		jMenuItemChangePassword.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jMenuItemChangePassword_actionPerformed(e);
			}
		});
		jMenuUser.add(jMenuItemChangePassword);

		JMenuItem jMenuItemLogout = new JMenuItem("Logout");
		jMenuItemLogout.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jMenuItemLogout_actionPerformed(e);
			}
		});
		jMenuUser.add(jMenuItemLogout);

		JMenu jMenuListEmployees = new JMenu("Eployees");
		jMenuListEmployees.setVisible(false);
		jMenuListEmployees.setFont(new Font("MesloLGM Nerd Font Mono", jMenuUser.getFont().getStyle(), 14));
		jMenuListEmployees.setMargin(new Insets(3, 8, 3, 8));
		menuBar.add(jMenuListEmployees);
		JPanelContentDashboard = new JPanel() {
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				ImageIcon backgroundImage = new ImageIcon("src/Resources/Images/Background-Blue.png");
				g.drawImage(backgroundImage.getImage(), 0, 0, getWidth(), getHeight(), null);
			}
		};
		JPanelContentDashboard.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(JPanelContentDashboard);
		JPanelContentDashboard.setLayout(new BorderLayout(0, 0));

		JPanel jpanelLeft = new JPanel();
		jpanelLeft.setOpaque(false);
		jpanelLeft.setPreferredSize(new Dimension(180, 0));
		jpanelLeft.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(100, 149, 237), new Color(135, 206, 235), new Color(100, 149, 237), new Color(135, 206, 235)));
		JPanelContentDashboard.add(jpanelLeft, BorderLayout.WEST);

		jbtnInventory = new JButton("Kho Hang -1,2");
		jbtnInventory.setForeground(new Color(102, 0, 102));
		jbtnInventory.setFont(new Font("MesloLGM Nerd Font Mono", jbtnInventory.getFont().getStyle() | Font.BOLD, 14));
		jbtnInventory.setMaximumSize(new Dimension(150, 35));
		jbtnInventory.setSize(new Dimension(150, 25));
		jbtnInventory.setAlignmentX(Component.CENTER_ALIGNMENT);
		jbtnInventory.setHorizontalTextPosition(SwingConstants.CENTER);
		jbtnInventory.setMinimumSize(new Dimension(150, 35));
		jbtnInventory.setPreferredSize(new Dimension(150, 35));
		jbtnInventory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnInventory_actionPerformed(e);
			}
		});
		jpanelLeft.setLayout(new BoxLayout(jpanelLeft, BoxLayout.PAGE_AXIS));

		JSeparator separator_12 = new JSeparator();
		separator_12.setPreferredSize(new Dimension(0, 20));
		separator_12.setMinimumSize(new Dimension(0, 20));
		separator_12.setMaximumSize(new Dimension(0, 20));
		jpanelLeft.add(separator_12);
		jpanelLeft.add(jbtnInventory);

		jbtnInvoices = new JButton("hoa don ban hang-1");
		jbtnInvoices.setForeground(new Color(102, 0, 102));
		jbtnInvoices.setFont(new Font("MesloLGM Nerd Font Mono", jbtnInventory.getFont().getStyle() | Font.BOLD, 14));
		jbtnInvoices.setMaximumSize(new Dimension(150, 35));
		jbtnInvoices.setSize(new Dimension(150, 25));
		jbtnInvoices.setAlignmentX(Component.CENTER_ALIGNMENT);
		jbtnInvoices.setMinimumSize(new Dimension(150, 35));
		jbtnInvoices.setPreferredSize(new Dimension(150, 35));
		jbtnInvoices.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnInvoices_actionPerformed(e);
			}
		});

		JSeparator separator = new JSeparator();
		separator.setMaximumSize(new Dimension(0, 5));
		separator.setMinimumSize(new Dimension(0, 5));
		separator.setPreferredSize(new Dimension(0, 5));
		jpanelLeft.add(separator);
		jpanelLeft.add(jbtnInvoices);

		JSeparator separator_1 = new JSeparator();
		separator_1.setMaximumSize(new Dimension(0, 5));
		separator_1.setMinimumSize(new Dimension(0, 5));
		separator_1.setPreferredSize(new Dimension(0, 5));
		jpanelLeft.add(separator_1);

		jbtnInformManager = new JButton("Thong bao qly -1");
		jbtnInformManager.setForeground(new Color(102, 0, 102));
		jbtnInformManager.setFont(new Font("MesloLGM Nerd Font Mono", jbtnInventory.getFont().getStyle() | Font.BOLD, 14));
		jbtnInformManager.setMaximumSize(new Dimension(150, 35));
		jbtnInformManager.setSize(new Dimension(150, 25));
		jbtnInformManager.setAlignmentX(Component.CENTER_ALIGNMENT);
		jbtnInformManager.setMinimumSize(new Dimension(150, 35));
		jbtnInformManager.setPreferredSize(new Dimension(150, 35));
		jpanelLeft.add(jbtnInformManager);

		JSeparator separator_2 = new JSeparator();
		separator_2.setMaximumSize(new Dimension(0, 5));
		separator_2.setMinimumSize(new Dimension(0, 5));
		separator_2.setPreferredSize(new Dimension(0, 5));
		jpanelLeft.add(separator_2);

		jbtnHelp = new JButton("tro giup -1");
		jbtnHelp.setForeground(new Color(102, 0, 102));
		jbtnHelp.setFont(new Font("MesloLGM Nerd Font Mono", jbtnInventory.getFont().getStyle() | Font.BOLD, 14));
		jbtnHelp.setMaximumSize(new Dimension(150, 35));
		jbtnHelp.setSize(new Dimension(150, 25));
		jbtnHelp.setAlignmentX(Component.CENTER_ALIGNMENT);
		jbtnHelp.setMinimumSize(new Dimension(150, 35));
		jbtnHelp.setPreferredSize(new Dimension(150, 35));
		jpanelLeft.add(jbtnHelp);

		JSeparator separator_3 = new JSeparator();
		separator_3.setMaximumSize(new Dimension(0, 5));
		separator_3.setMinimumSize(new Dimension(0, 5));
		separator_3.setPreferredSize(new Dimension(0, 5));
		jpanelLeft.add(separator_3);

		jbtnSaleRequest = new JButton("yeu cau - 2,3");
		jbtnSaleRequest.setForeground(new Color(102, 0, 102));
		jbtnSaleRequest.setFont(new Font("MesloLGM Nerd Font Mono", jbtnInventory.getFont().getStyle() | Font.BOLD, 14));
		jbtnSaleRequest.setMaximumSize(new Dimension(150, 35));
		jbtnSaleRequest.setSize(new Dimension(150, 25));
		jbtnSaleRequest.setAlignmentX(Component.CENTER_ALIGNMENT);
		jbtnSaleRequest.setMinimumSize(new Dimension(150, 35));
		jbtnSaleRequest.setPreferredSize(new Dimension(150, 35));
		jpanelLeft.add(jbtnSaleRequest);

		JSeparator separator_4 = new JSeparator();
		separator_4.setMaximumSize(new Dimension(0, 5));
		separator_4.setMinimumSize(new Dimension(0, 5));
		separator_4.setPreferredSize(new Dimension(0, 5));
		jpanelLeft.add(separator_4);

		jbtnValidateInventory = new JButton("Xac thuc ton kho - 2");
		jbtnValidateInventory.setForeground(new Color(102, 0, 102));
		jbtnValidateInventory.setFont(new Font("MesloLGM Nerd Font Mono", jbtnInventory.getFont().getStyle() | Font.BOLD, 14));
		jbtnValidateInventory.setMaximumSize(new Dimension(150, 35));
		jbtnValidateInventory.setSize(new Dimension(150, 25));
		jbtnValidateInventory.setAlignmentX(Component.CENTER_ALIGNMENT);
		jbtnValidateInventory.setMinimumSize(new Dimension(150, 35));
		jbtnValidateInventory.setPreferredSize(new Dimension(150, 35));
		jpanelLeft.add(jbtnValidateInventory);

		JSeparator separator_5 = new JSeparator();
		separator_5.setMaximumSize(new Dimension(0, 5));
		separator_5.setMinimumSize(new Dimension(0, 5));
		separator_5.setPreferredSize(new Dimension(0, 5));
		jpanelLeft.add(separator_5);

		jbtnReportInventory = new JButton("Bao cao -2 ");
		jbtnReportInventory.setForeground(new Color(102, 0, 102));
		jbtnReportInventory.setFont(new Font("MesloLGM Nerd Font Mono", jbtnInventory.getFont().getStyle() | Font.BOLD, 14));
		jbtnReportInventory.setMaximumSize(new Dimension(150, 35));
		jbtnReportInventory.setSize(new Dimension(150, 25));
		jbtnReportInventory.setAlignmentX(Component.CENTER_ALIGNMENT);
		jbtnReportInventory.setMinimumSize(new Dimension(150, 35));
		jbtnReportInventory.setPreferredSize(new Dimension(150, 35));
		jpanelLeft.add(jbtnReportInventory);

		JSeparator separator_6 = new JSeparator();
		separator_6.setMaximumSize(new Dimension(0, 5));
		separator_6.setMinimumSize(new Dimension(0, 5));
		separator_6.setPreferredSize(new Dimension(0, 5));
		jpanelLeft.add(separator_6);

		jbtnInventoryTrends = new JButton("Thong ke - 2");
		jbtnInventoryTrends.setForeground(new Color(102, 0, 102));
		jbtnInventoryTrends.setFont(new Font("MesloLGM Nerd Font Mono", jbtnInventory.getFont().getStyle() | Font.BOLD, 14));
		jbtnInventoryTrends.setMaximumSize(new Dimension(150, 35));
		jbtnInventoryTrends.setSize(new Dimension(150, 25));
		jbtnInventoryTrends.setAlignmentX(Component.CENTER_ALIGNMENT);
		jbtnInventoryTrends.setMinimumSize(new Dimension(150, 35));
		jbtnInventoryTrends.setPreferredSize(new Dimension(150, 35));
		jpanelLeft.add(jbtnInventoryTrends);

		JSeparator separator_7 = new JSeparator();
		separator_7.setMaximumSize(new Dimension(0, 5));
		separator_7.setMinimumSize(new Dimension(0, 5));
		separator_7.setPreferredSize(new Dimension(0, 5));
		jpanelLeft.add(separator_7);

		jbtnInvoiceToday = new JButton("hoa don  -3");
		jbtnInvoiceToday.setForeground(new Color(102, 0, 102));
		jbtnInvoiceToday.setFont(new Font("MesloLGM Nerd Font Mono", jbtnInventory.getFont().getStyle() | Font.BOLD, 14));
		jbtnInvoiceToday.setMaximumSize(new Dimension(150, 35));
		jbtnInvoiceToday.setSize(new Dimension(150, 25));
		jbtnInvoiceToday.setAlignmentX(Component.CENTER_ALIGNMENT);
		jbtnInvoiceToday.setMinimumSize(new Dimension(150, 35));
		jbtnInvoiceToday.setPreferredSize(new Dimension(150, 35));
		jpanelLeft.add(jbtnInvoiceToday);

		JSeparator separator_8 = new JSeparator();
		separator_8.setMaximumSize(new Dimension(0, 5));
		separator_8.setMinimumSize(new Dimension(0, 5));
		separator_8.setPreferredSize(new Dimension(0, 5));
		jpanelLeft.add(separator_8);

		jbtnTransaction = new JButton("giao dich - 3");
		jbtnTransaction.setForeground(new Color(102, 0, 102));
		jbtnTransaction.setFont(new Font("MesloLGM Nerd Font Mono", jbtnInventory.getFont().getStyle() | Font.BOLD, 14));
		jbtnTransaction.setMaximumSize(new Dimension(150, 35));
		jbtnTransaction.setSize(new Dimension(150, 25));
		jbtnTransaction.setAlignmentX(Component.CENTER_ALIGNMENT);
		jbtnTransaction.setMinimumSize(new Dimension(150, 35));
		jbtnTransaction.setPreferredSize(new Dimension(150, 35));
		jpanelLeft.add(jbtnTransaction);

		JSeparator separator_9 = new JSeparator();
		separator_9.setMaximumSize(new Dimension(0, 5));
		separator_9.setMinimumSize(new Dimension(0, 5));
		separator_9.setPreferredSize(new Dimension(0, 5));
		jpanelLeft.add(separator_9);

		jbtnReturnedToday = new JButton("Hang tra ve - 3");
		jbtnReturnedToday.setForeground(new Color(102, 0, 102));
		jbtnReturnedToday.setFont(new Font("MesloLGM Nerd Font Mono", jbtnInventory.getFont().getStyle() | Font.BOLD, 14));
		jbtnReturnedToday.setMaximumSize(new Dimension(150, 35));
		jbtnReturnedToday.setSize(new Dimension(150, 25));
		jbtnReturnedToday.setAlignmentX(Component.CENTER_ALIGNMENT);
		jbtnReturnedToday.setMinimumSize(new Dimension(150, 35));
		jbtnReturnedToday.setPreferredSize(new Dimension(150, 35));
		jpanelLeft.add(jbtnReturnedToday);

		JSeparator separator_10 = new JSeparator();
		separator_10.setMaximumSize(new Dimension(0, 5));
		separator_10.setMinimumSize(new Dimension(0, 5));
		separator_10.setPreferredSize(new Dimension(0, 5));
		jpanelLeft.add(separator_10);

		jbtnSalesTrend = new JButton("bieu do - 3");
		jbtnSalesTrend.setForeground(new Color(102, 0, 102));
		jbtnSalesTrend.setFont(new Font("MesloLGM Nerd Font Mono", jbtnInventory.getFont().getStyle() | Font.BOLD, 14));
		jbtnSalesTrend.setMaximumSize(new Dimension(150, 35));
		jbtnSalesTrend.setSize(new Dimension(150, 25));
		jbtnSalesTrend.setAlignmentX(Component.CENTER_ALIGNMENT);
		jbtnSalesTrend.setMinimumSize(new Dimension(150, 35));
		jbtnSalesTrend.setPreferredSize(new Dimension(150, 35));
		jpanelLeft.add(jbtnSalesTrend);

		JSeparator separator_11 = new JSeparator();
		separator_11.setMaximumSize(new Dimension(0, 5));
		separator_11.setMinimumSize(new Dimension(0, 5));
		separator_11.setPreferredSize(new Dimension(0, 5));
		jpanelLeft.add(separator_11);

		jbtnAddProductCategory = new JButton("them moi - 4");
		jbtnAddProductCategory.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				jbtnAddProductCategory_actionPerformed(e);
			}
		});
		jbtnAddProductCategory.setForeground(new Color(102, 0, 102));
		jbtnAddProductCategory.setFont(new Font("MesloLGM Nerd Font Mono", jbtnInventory.getFont().getStyle() | Font.BOLD, 14));
		jbtnAddProductCategory.setMaximumSize(new Dimension(150, 35));
		jbtnAddProductCategory.setSize(new Dimension(150, 25));
		jbtnAddProductCategory.setAlignmentX(Component.CENTER_ALIGNMENT);
		jbtnAddProductCategory.setMinimumSize(new Dimension(150, 35));
		jbtnAddProductCategory.setPreferredSize(new Dimension(150, 35));
		jpanelLeft.add(jbtnAddProductCategory);

		JPanel panel = new JPanel();
		panel.setOpaque(false);
		jpanelLeft.add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		

		jpanelContent = new JPanel();
		jpanelContent.setOpaque(false);
		jpanelContent.setBorder(new CompoundBorder(new LineBorder(new Color(135, 206, 250), 5, true), new LineBorder(new Color(100, 149, 237), 3)));
		JPanelContentDashboard.add(jpanelContent, BorderLayout.CENTER);
		jpanelContent.setLayout(new BoxLayout(jpanelContent, BoxLayout.X_AXIS));

		// color button
		jbtnInventory.setBackground(StyleColor.BtnBackground());
		jbtnInvoices.setBackground(StyleColor.BtnBackground());
		jbtnInformManager.setBackground(StyleColor.BtnBackground());
		jbtnHelp.setBackground(StyleColor.BtnBackground());
		jbtnSaleRequest.setBackground(StyleColor.BtnBackground());
		jbtnSalesTrend.setBackground(StyleColor.BtnBackground());
		jbtnValidateInventory.setBackground(StyleColor.BtnBackground());
		jbtnReportInventory.setBackground(StyleColor.BtnBackground());
		jbtnInventoryTrends.setBackground(StyleColor.BtnBackground());
		jbtnInvoiceToday.setBackground(StyleColor.BtnBackground());
		jbtnTransaction.setBackground(StyleColor.BtnBackground());
		jbtnReturnedToday.setBackground(StyleColor.BtnBackground());
		jbtnSalesTrend.setBackground(StyleColor.BtnBackground());
		jbtnAddProductCategory.setBackground(StyleColor.BtnBackground());
		
		

		

	}

	public void jbtnInvoices_actionPerformed(ActionEvent e) {
		clearScreen();
		JPanelInvoices jpanelInvoices = new JPanelInvoices();
		jpanelContent.setVisible(true);
		jpanelContent.add(jpanelInvoices);
	}

	public JFrameDashBoard(int employeeId) {
		this();
		this.employeeId = employeeId;
		init();

	}

	private void init() {
		Employees employees = employeeModel.FindByEmployeeID(employeeId);
		String username = employees.getUsername();
		// convert upperCase
		String TitleUser = username.substring(0, 1).toUpperCase() + username.substring(1);
		jMenuUser.setText(TitleUser);

	}

	private void clearScreen() {
		jpanelContent.removeAll();
		jpanelContent.revalidate();
		jpanelContent.repaint();
	}

	public void jbtnInventory_actionPerformed(ActionEvent e) {
		clearScreen();
		JPanelProduct jPanelProduct = new JPanelProduct();
		jpanelContent.setVisible(true);
		jpanelContent.add(jPanelProduct);
	}

	public static int getEmployeeId() {
		int id = employeeId;
		return id;
	}
	public void jbtnAddProductCategory_actionPerformed(ActionEvent e) {
		clearScreen();
		AddProduct addProduct = new AddProduct();
		jpanelContent.setVisible(true);
		jpanelContent.add(addProduct);
	}
	
	
	// menu logout
	public void jMenuItemLogout_actionPerformed(ActionEvent e) {
		Index index = new Index();
		setVisible(false);
		index.setVisible(true);
	}
	
	public void jMenuItemChangePassword_actionPerformed(ActionEvent e) {

		JDialog jChangePasswordDialog = new JDialog(this, "Change Password", true);
        JPanelChangePassword jChangePassword = new JPanelChangePassword(employeeId);
        jChangePasswordDialog.getContentPane().add(jChangePassword);
        jChangePasswordDialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
        jChangePasswordDialog.pack();
        jChangePasswordDialog.setLocationRelativeTo(this);
        jChangePasswordDialog.setVisible(true);
	}

}

