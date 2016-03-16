package com.xin.demo.batchdeal;

import java.awt.Container;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

/**
 * 因为看很多朋友在问试用临时抽时间写了个简单的案例 源码放上去，需要的可以看看，由于时间匆忙做得很粗糙 2011年1月4日23:22:31
 * 
 * @author 漆艾林 QQ 172794299 邮箱 qiailing.ok@163.com
 * 
 */
public class Jexample implements ActionListener {
	DealExcelInfoJ dealExcelInfoJ = new DealExcelInfoJ();
	private String filePath;
	JFrame frame = new JFrame("选择文件框");// 框架布局
	JTabbedPane tabPane = new JTabbedPane();// 选项卡布局
	Container con = new Container();//
	JLabel label2 = new JLabel("选择文件");
	JTextField text1 = new JTextField();// TextField 目录的路径
	JTextField text2 = new JTextField();// 文件的路径
	JButton chooseFile = new JButton("...");// 选择
	JFileChooser jfc = new JFileChooser();// 文件选择器
	JButton submit = new JButton("提交文件");//

	Jexample() {
		jfc.setCurrentDirectory(new File("d://"));// 文件选择器的初始目录定为d盘

		double lx = Toolkit.getDefaultToolkit().getScreenSize().getWidth();

		double ly = Toolkit.getDefaultToolkit().getScreenSize().getHeight();

		frame.setLocation(new Point((int) (lx / 2) - 150, (int) (ly / 2) - 150));// 设定窗口出现位置
		frame.setSize(280, 200);// 设定窗口大小
		frame.setContentPane(tabPane);// 设置布局
		label2.setBounds(10, 35, 70, 20);
		text2.setBounds(75, 35, 120, 20);
		chooseFile.setBounds(205, 35, 50, 20);
		submit.setBounds(80, 90, 60, 0);
		submit.setSize(100, 30);
		chooseFile.addActionListener(this); // 添加事件处理
		submit.addActionListener(this); // 添加事件处理
		con.add(label2);
		con.add(text2);
		con.add(chooseFile);
		con.add(submit);
		frame.setVisible(true);// 窗口可见
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);// 使能关闭窗口，结束程序
		tabPane.add("1面板", con);// 添加布局1
	}

	/**
	 * 时间监听的方法
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource().equals(chooseFile)) {
			jfc.setFileSelectionMode(0);// 设定只能选择到文件
			int state = jfc.showOpenDialog(null);// 此句是打开文件选择器界面的触发语句
			if (state == 1) {
				return;// 撤销则返回
			} else {
				File f = jfc.getSelectedFile();// f为选择到的文件
				System.out.println(f);
				filePath = f.toString();
				text2.setText(f.getAbsolutePath());
			}
		}
		if (e.getSource().equals(submit)) {
//			JOptionPane.showMessageDialog(null, filePath, "提示", 2);
			try {
				dealExcelInfoJ.readExcel(filePath);
			} catch (Exception e1) {
				e1.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		new Jexample();
	}
}
