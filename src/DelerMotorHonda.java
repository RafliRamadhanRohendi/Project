import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.LayoutStyle.ComponentPlacement;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;
import java.awt.Color;
import javax.swing.JButton;
import java.sql.Connection;
import javax.swing.JTabbedPane;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class DelerMotorHonda extends JFrame {
	private static final JLabel Merek_Motor = null;
	private static final JLabel Warna = null;
	private static final JLabel Harga = null;
	private static final JLabel ID_Motor = null;
	private JTextField textField_2;
	private JTable table;

	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DelerMotorHonda frame = new DelerMotorHonda();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	DefaultTableModel model;
	private JTextField textField;
	public DelerMotorHonda() throws SQLException {
		String [] judul = {"Merek Motor","Warna","Harga","ID_Motor"};
		model = new DefaultTableModel(judul,0);
		table.setModel(model);
		tampilkan();
		Reset();
			
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 961, 517);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		getContentPane().add(panel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("Deler Motor Honda");
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 18));
		
		JLabel Merek_Motor = new JLabel("Merek Motor");
		Merek_Motor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel Warna = new JLabel("Warna");
		Warna.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		
		JLabel Harga = new JLabel("Harga");
		Harga.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		JLabel ID_Motor = new JLabel("ID_Motor");
		ID_Motor.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		textField = new JTextField();
		textField.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		textField.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"VARIO", "BEAT", "SCOOPY", "SUPRA", "REVO"}));
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setModel(new DefaultComboBoxModel(new String[] {"HITAM", "PUTIH", "MERAH"}));
		
		JButton btnTambah = new JButton("Tambah");
		btnTambah.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection on = DriverManager.getConnection("jdbc:mysql//localhost/dealermotor","root","");
					on.createStatement().executeUpdate("insert into dealermotor values"+"('"+Merek_Motor.getText()+"',"+ "'"+Warna.getText()+"',"+ "'"+Harga.getText()+"',"+ "'"+ID_Motor.getText()+"')");
					tampilkan();
					Reset();
				} catch (SQLException e1) {
					e1.printStackTrace();
					JOptionPane.showMessageDialog(null, "Ada Data Yang Belum Diisi!!");
				}
			}
		});
		
		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection on = DriverManager.getConnection("jdbc:mysql//localhost/dealermotor","root","");
					on.createStatement().executeUpdate("update dealermotor set Harga ='"+Harga.getText()+"',ID_Motor ='"+ID_Motor.getText()+"'Where Merek_Motor='"+Merek_Motor.getText()+"'");
					tampilkan();
					Reset();
				} catch (SQLException e1) {
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnHapus = new JButton("Hapus");
		btnHapus.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					Connection on = DriverManager.getConnection("jdbc:mysql//localhost/dealermotor","root","");
					on.createStatement().executeUpdate("delete from Merek_Motor='"+Merek_Motor.getText()+"'");
					tampilkan();
					Reset();
				} catch (SQLException e1) {				
					e1.printStackTrace();
				}
			}
		});
		
		JButton btnReset = new JButton("Reset");
		btnReset.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Reset();
			}
		});
		
		
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int i = table.getSelectedRow();
				if(i>-1) {}
				Merek_Motor.setText(model.getValueAt(i, 0).toString());
				Warna.setText(model.getValueAt(i, 0).toString());
				Harga.setText(model.getValueAt(i, 0).toString());
				ID_Motor.setText(model.getValueAt(i, 0).toString());
			}
		});
		GroupLayout gl_panel = new GroupLayout(panel);
		gl_panel.setHorizontalGroup(
			gl_panel.createParallelGroup(Alignment.TRAILING)
				.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
					.addGap(268)
					.addComponent(lblNewLabel, GroupLayout.PREFERRED_SIZE, 185, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(494, Short.MAX_VALUE))
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(25, 25, Short.MAX_VALUE)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(Warna, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
						.addComponent(Harga, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
						.addComponent(ID_Motor, GroupLayout.PREFERRED_SIZE, 77, GroupLayout.PREFERRED_SIZE)
						.addComponent(Merek_Motor, GroupLayout.PREFERRED_SIZE, 97, GroupLayout.PREFERRED_SIZE))
					.addGap(35)
					.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
						.addComponent(table, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
						.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING, false)
							.addComponent(comboBox_1, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addComponent(textField, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
							.addComponent(textField_2, Alignment.LEADING, GroupLayout.DEFAULT_SIZE, 398, Short.MAX_VALUE)
							.addComponent(comboBox, Alignment.LEADING, 0, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
							.addGroup(Alignment.LEADING, gl_panel.createSequentialGroup()
								.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
									.addComponent(btnEdit)
									.addComponent(btnTambah))
								.addGap(108)
								.addGroup(gl_panel.createParallelGroup(Alignment.TRAILING)
									.addGroup(gl_panel.createSequentialGroup()
										.addComponent(btnReset)
										.addGap(2))
									.addComponent(btnHapus)))))
					.addGap(392))
		);
		gl_panel.setVerticalGroup(
			gl_panel.createParallelGroup(Alignment.LEADING)
				.addGroup(gl_panel.createSequentialGroup()
					.addGap(32)
					.addComponent(lblNewLabel)
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(Merek_Motor)
						.addComponent(comboBox, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(23)
					.addGroup(gl_panel.createParallelGroup(Alignment.BASELINE)
						.addComponent(Warna)
						.addComponent(comboBox_1, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(19)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(Harga)
						.addComponent(textField_2, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGap(24)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addComponent(textField, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE)
						.addComponent(ID_Motor))
					.addPreferredGap(ComponentPlacement.UNRELATED)
					.addGroup(gl_panel.createParallelGroup(Alignment.LEADING)
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnTambah)
							.addPreferredGap(ComponentPlacement.UNRELATED)
							.addComponent(btnEdit))
						.addGroup(gl_panel.createSequentialGroup()
							.addComponent(btnHapus)
							.addGap(11)
							.addComponent(btnReset)))
					.addGap(18)
					.addComponent(table, GroupLayout.PREFERRED_SIZE, 104, GroupLayout.PREFERRED_SIZE)
					.addContainerGap(77, Short.MAX_VALUE))
		);
		panel.setLayout(gl_panel);
	}
	private void Reset() {
		Merek_Motor.setText("");
		Warna.setText("");
		Harga.setText("");
		ID_Motor.setText("");
		
		
	}
	private void tampilkan() throws SQLException {
		int row= table.getRowCount();
		for(int a = 0; a<row;a++) {
			model.removeRow(0);
		}
		
		Connection on = null;
		ResultSet rs = on.createStatement().executeQuery("SELECT * FROM dealermotor");
		while(rs.next()) {
			String data [] = {rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)};
			model.addRow(data);
		}
		try {
			on = DriverManager.getConnection("jdbc:mysql//localhost/dealermotor","root","");
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		
		
	}
}
