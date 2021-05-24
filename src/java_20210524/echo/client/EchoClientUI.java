package java_20210524.echo.client;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

//UI 채팅을 위해서 이벤트 클래스
public class EchoClientUI implements ActionListener{
	private String id;
	private String ip;
	private int port;
	private JFrame jframe;
	private JTextArea jta;
	private JTextField jtf;
	private JButton jbtn;
	private BufferedReader br;
	private BufferedWriter bw; 
	//UI => 나중에 안드로이드 할 때 / Python 도 UI 있음. 근데 잘 안씀 why?
	//Web에서 다 만들수 있음.
	public EchoClientUI(String id, String ip, int port) {
		this.id= id;
		this.ip=ip;
		this.port =port;
		
		jframe = new JFrame("Unicast Chatting");
		/******************************************************************************/
			
		/************************중앙 시작**************************************/
		//JTextArea 는 거의 항상 JScrollPane이랑 같이써서 스크롤 될 수 있는 텍스트 만든다.
		jta = new JTextArea("",20,50);
		jta.setEditable(false); //텍스트 에 직접 쓸 수 없게 만듬. 
		jta.setBackground(new Color(244,201,107));
		
		JScrollPane jsp = new JScrollPane(
				jta,
				JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
				JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		
		/************************중앙 끝***********************************************/
		/************************하단 시작***********************************/

		jtf= new JTextField(30);
		//이벤트 등록 
		jtf.addActionListener(this);
		jbtn = new JButton("SEND");
		//이벤트 등록
		jbtn.addActionListener(this);
		JPanel j1 = new JPanel();
		j1.setLayout(new BorderLayout());
		j1.add(jtf, BorderLayout.CENTER);
		j1.add(jbtn,BorderLayout.EAST);
		/************************하단 끝**********************************************/
		
		/************************상단 시작********************************************/
		JLabel jl1 = new JLabel("User ID : ["+id+"]");
		JLabel jl2 = new JLabel("Server IP : ["+ip+"]");
		
		JPanel j2 = new JPanel();
		j2.setLayout(new BorderLayout());
		j2.add(jl1,BorderLayout.CENTER);
		j2.add(jl2,BorderLayout.EAST);
		j2.setBackground(new Color(0,255,255));
		/************************상단 끝********************************************/
		jframe.add(jsp,BorderLayout.CENTER);
		jframe.add(j1,BorderLayout.SOUTH);
		jframe.add(j2,BorderLayout.NORTH);
		jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);
		
		jframe.pack();
		jframe.setResizable(true);
		jframe.setVisible(true);
		
	}
	public void connect() {
		try {
			Socket socket = new Socket(ip,port);
			bw = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));
			br = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		} catch (IOException e) {
			System.err.println("서버 접속에 실패하였습니다.");
		}
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object obj = e.getSource();
		if(obj == jtf) {
			//텍스트 필드이 입력 내용을 가져오기
			String message = jtf.getText();
			try {
				bw.write(id+" : "+message);
				bw.newLine();
				bw.flush();
				
				String readLine = br.readLine();
				jta.append(readLine+"\r\n");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			jtf.setText("");
			
			
		}else if(obj == jbtn) {
			String message = jtf.getText();
			try {
				bw.write(id+" : "+message);
				bw.newLine();
				bw.flush();
				
				String readLine = br.readLine();
				jta.append(readLine+"\r\n");
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			jtf.setText("");

		}
	}
	public static void main(String[] args) {
		JFrame.setDefaultLookAndFeelDecorated(true);
		new EchoClientUI("syh1011", "192.168.0.28", 3000).connect();
	}
	
}
