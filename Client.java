import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.net.*;
import java.io.*;

public class Client implements ActionListener {

    static JFrame f = new JFrame();
    JPanel p1;
    static JPanel p2;
    JButton send;
    JTextField text;
    static Box vertical = Box.createVerticalBox();
    static DataOutputStream dout;

    Client() {
        f.setLayout(null);
        p1 = new JPanel();
        p1.setBounds(0, 0, 450, 70);
        p1.setBackground(new Color(7, 94, 84));
        f.add(p1);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/3.png"));
        Image i2 = i1.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel back = new JLabel(i3);
        back.setBounds(5, 20, 25, 25);
        p1.add(back);

        ImageIcon i4 = new ImageIcon(ClassLoader.getSystemResource("icons/2.png"));
        Image i5 = i4.getImage().getScaledInstance(50, 50, Image.SCALE_DEFAULT);
        ImageIcon i6 = new ImageIcon(i5);
        JLabel profile = new JLabel(i6);
        profile.setBounds(40, 10, 50, 50);
        p1.add(profile);

        ImageIcon i7 = new ImageIcon(ClassLoader.getSystemResource("icons/video.png"));
        Image i8 = i7.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon i9 = new ImageIcon(i8);
        JLabel video = new JLabel(i9);
        video.setBounds(300, 15, 35, 35);
        p1.add(video);

        ImageIcon i10 = new ImageIcon(ClassLoader.getSystemResource("icons/phone.png"));
        Image i11 = i10.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon i12 = new ImageIcon(i11);
        JLabel call = new JLabel(i12);
        call.setBounds(360, 17, 35, 30);
        p1.add(call);

        ImageIcon i13 = new ImageIcon(ClassLoader.getSystemResource("icons/3icon.png"));
        Image i14 = i13.getImage().getScaledInstance(25, 25, Image.SCALE_DEFAULT);
        ImageIcon i15 = new ImageIcon(i14);
        JLabel moree = new JLabel(i15);
        moree.setBounds(420, 20, 10, 25);
        p1.add(moree);

        p1.setLayout(null);

        JLabel name = new JLabel("Atharva Bomle");
        name.setBounds(110, 20, 180, 15);
        name.setForeground(Color.WHITE);
        name.setFont(new Font("SAN SERIF", Font.BOLD, 18));
        p1.add(name);

        JLabel status = new JLabel("Online");
        status.setBounds(110, 45, 100, 12);
        status.setForeground(Color.WHITE);
        status.setFont(new Font("Arial", Font.PLAIN, 14));
        p1.add(status);

        p2 = new JPanel();
        p2.setBounds(0, 72, 440, 530);
        p2.setBackground(Color.LIGHT_GRAY);
        f.add(p2);

        text = new JTextField();
        text.setBounds(0, 605, 290, 50);
        text.setFont(new Font("SAN SERIF", Font.PLAIN, 16));
        f.add(text);

        send = new JButton("Send");
        send.setBounds(290, 605, 150, 50);
        send.setFont(new Font("SAN SERIF", Font.BOLD, 16));
        send.setForeground(Color.WHITE);
        send.setBackground(new Color(7, 94, 84));
        send.addActionListener(this);
        f.add(send);

        back.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent me) {
                System.exit(0);
            }
        });

        f.getContentPane().setBackground(Color.WHITE);
        f.setBounds(200, 100, 450, 700);
        f.setTitle("Client Side");
        f.setVisible(true);

    }

    public static void main(String[] args) {
        Client obj = new Client();

        try {
            Socket skt = new Socket("127.0.0.1", 6001);
            DataInputStream dinp = new DataInputStream(skt.getInputStream());
            dout = new DataOutputStream(skt.getOutputStream());

            while (true) {
                p2.setLayout(new BorderLayout());
                String msg = dinp.readUTF();
                JPanel panel = formatLabel(msg);

                JPanel left = new JPanel(new BorderLayout());
                left.add(panel, BorderLayout.LINE_START);
                vertical.add(left);
                vertical.add(Box.createVerticalStrut(15));
                p2.add(vertical, BorderLayout.PAGE_START);
                f.validate();

            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void actionPerformed(ActionEvent e) {

        try {
            String str = text.getText();
            JPanel p3 = formatLabel(str);

            p2.setLayout(new BorderLayout());

            JPanel left = new JPanel(new BorderLayout());
            left.add(p3, BorderLayout.LINE_END);
            vertical.add(left);
            vertical.add(Box.createVerticalStrut(15));

            p2.add(vertical, BorderLayout.PAGE_START);

            dout.writeUTF(str);
            text.setText("");
            f.repaint();
            f.invalidate();
            f.validate();
        } catch (IOException e1) {
            e1.printStackTrace();
        }
    }

    public static JPanel formatLabel(String str) {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

        JLabel output = new JLabel("<html><p style=\"width: 80px\">" + str + "</p></html>");
        output.setFont(new Font("Tahoma", Font.PLAIN, 16));
        output.setBackground(new Color(37, 211, 102));
        output.setOpaque(true);
        output.setBorder(new EmptyBorder(15, 15, 15, 50));

        panel.add(output);

        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");

        JLabel time = new JLabel();
        time.setText(sdf.format(cal.getTime()));

        panel.add(time);

        return panel;

    }

}
