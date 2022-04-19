package HomeWork_Java_lvl_2.ChatServer;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Client extends JFrame implements ActionListener, Thread.UncaughtExceptionHandler, MouseListener, KeyListener {
    private static final int WIDTH = 400;
    private static final int HEIGHT = 300;

    private final JTextArea log = new JTextArea();

    private final JPanel panelTop = new JPanel(new GridLayout(2, 3));
    private final JTextField tfIPAddress = new JTextField("127.0.0.1");
    private final JTextField tfPort = new JTextField("80");
    private final JCheckBox cbAlwaysOnTop = new JCheckBox("Always on top");
    private final JTextField tfLogin = new JTextField("ivan_igorevich");
    private final JPasswordField tfPassword = new JPasswordField("123456");
    private final JButton btnLogin = new JButton("Login");

    private final JPanel panelBottom = new JPanel(new BorderLayout());
    private final JButton btnDisconnect = new JButton("Disconnect");
    private final JTextField tfMessage = new JTextField();
    private final JButton btnSend = new JButton("Send");
    private final JList<String> userList = new JList<>();

    File file = new File("C:\\Users\\User\\Desktop\\Any_Folder\\Another_Any_Folder\\Log.txt");

    PrintWriter printWriter = null;

    private Client() {
        Thread.setDefaultUncaughtExceptionHandler(this);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationRelativeTo(null); //РїРѕСЃСЂРµРґРё СЌРєСЂР°РЅР°
        setSize(WIDTH, HEIGHT);
        setTitle("Chat Client");
        log.setEditable(false);
        JScrollPane spLog = new JScrollPane(log);
        JScrollPane spUsers = new JScrollPane(userList);
        String[] users = {"user1", "user2",
                "user3", "user4", "user5", "user6",
                "user7", "user8", "user9",
                "user10_with_a_exceptionally_long_nickname", };
        userList.setListData(users);
        spUsers.setPreferredSize(new Dimension(100, 0));
        cbAlwaysOnTop.addActionListener(this);

        panelTop.add(tfIPAddress);
        panelTop.add(tfPort);
        panelTop.add(cbAlwaysOnTop);
        panelTop.add(tfLogin);
        panelTop.add(tfPassword);
        panelTop.add(btnLogin);
        panelBottom.add(btnDisconnect, BorderLayout.WEST);
        panelBottom.add(tfMessage, BorderLayout.CENTER);
        panelBottom.add(btnSend, BorderLayout.EAST);

        add(panelBottom, BorderLayout.SOUTH);
        add(panelTop, BorderLayout.NORTH);
        add(spLog, BorderLayout.CENTER);
        add(spUsers, BorderLayout.EAST);

        setVisible(true);

        btnSend.addMouseListener(this);
        tfMessage.addKeyListener(this);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new Client();
            }
        });
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object src = e.getSource();
        if (src == cbAlwaysOnTop) {
            setAlwaysOnTop(cbAlwaysOnTop.isSelected());
        } else {
            throw new RuntimeException("Action for component unimplemented");
        }
    }

    @Override
    public void uncaughtException(Thread t, Throwable e) {
        e.printStackTrace();
        String msg = "Exception in thread " + t.getName() +
                " " + e.getClass().getCanonicalName() +
                ": " + e.getMessage() +
                "\n\t" + e.getStackTrace()[0];
        JOptionPane.showMessageDialog(null, msg,
                "Exception", JOptionPane.ERROR_MESSAGE);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        Object send = e.getSource();
        if (send == btnSend) {
            try {
                log.setText(tfMessage.getText());
                tfMessage.setText(null);
                printWriter = new PrintWriter(file);
                printWriter.print(log.getText());
            } catch (FileNotFoundException exception) {
                exception.printStackTrace();
            } finally {
                printWriter.close();
            }
        }
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            try {
                log.setText(tfMessage.getText());
                tfMessage.setText(null);
                printWriter = new PrintWriter(file);
                printWriter.print(log.getText());
            } catch (FileNotFoundException exception) {
                exception.printStackTrace();
            } finally {
                printWriter.close();
            }
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}

