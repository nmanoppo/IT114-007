package Project;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ContainerEvent;
import java.awt.event.ContainerListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
 /*
import Project.Card;
import Project.Client;
import Project.GeneralUtils;
import Project.ICardControl;
 */
public class ChatPanel extends JPanel {
    private static Logger logger = Logger.getLogger(ChatPanel.class.getName());
    private JPanel chatArea = null;
    private UserListPanel userListPanel;
    public ChatPanel(ICardControl controls){
        super(new BorderLayout(10, 10));
        JPanel wrapper = new JPanel();
        wrapper.setLayout(new BoxLayout(wrapper, BoxLayout.Y_AXIS));
        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setAlignmentY(Component.BOTTOM_ALIGNMENT);

        // wraps a viewport to provide scroll capabilities
        JScrollPane scroll = new JScrollPane(content);
        scroll.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.setBorder(BorderFactory.createEmptyBorder());
        // no need to add content specifically because scroll wraps it
        wrapper.add(scroll);
        this.add(wrapper, BorderLayout.CENTER);

        JPanel input = new JPanel(); //Nadia Manoppo, nm94
        input.setLayout(new BoxLayout(input, BoxLayout.X_AXIS));
        JTextField textValue = new JTextField();
        input.add(textValue);
        JButton button = new JButton("Send");
        // lets us submit with the enter key instead of just the button click

        JPanel exportBox = new JPanel();
        exportBox.setLayout(new BoxLayout(exportBox, BoxLayout.X_AXIS));
        JButton exportButton = new JButton("Export");
        input.add(exportButton);

        
        exportButton.addActionListener((export) ->
        {
            try
            {
                File chathistory = new File("chathistory.txt");
                String history = textValue.getText().trim();
                Client.INSTANCE.sendMessage(history);
                PrintWriter out = new PrintWriter(new FileWriter("chathistory.txt", true));
                out.println(history);
                out.close();

                //PrintWriter PW = new PrintWriter(file);
                if (chathistory.createNewFile())
                {
                    System.out.println("File created: " + chathistory.getName());
                }
                else
                {
                    System.out.println("The File already exists.");
                }
            }
            catch (IOException e)
            {
                System.out.println("Error Occurred.");
                e.printStackTrace();
            }
        }
        );

        JPanel mutedBox = new JPanel();
        mutedBox.setLayout(new BoxLayout(mutedBox, BoxLayout.X_AXIS));
        JButton mutedButton = new JButton("Muted");
        input.add(mutedButton);

        mutedButton.addActionListener((muted) ->
        {
            try
            {
                File mutedList = new File("mutedlist.txt");
                String mutedC = textValue.getText().trim();
                Client.INSTANCE.sendMessage(mutedC);
                PrintWriter out = new PrintWriter(new FileWriter("mutedlist.txt", true));
                out.println(mutedC);
                out.close();

                if (mutedList.createNewFile())
                {
                    System.out.println("File created: " + mutedList.getName());
                }
                else
                {
                    System.out.println("The File already exists.");
                }
            }
            catch (IOException e)
            {
                System.out.println("Error Occurred.");
                e.printStackTrace();
            }
        }
    );

        textValue.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    button.doClick();
                }
            }

            @Override
            public void keyReleased(KeyEvent e) {

            }

        });
        button.addActionListener((event) -> {
            try {
                String text = textValue.getText().trim();
                if (text.length() > 0) {
                    Client.INSTANCE.sendMessage(text);
                    textValue.setText("");// clear the original text

                    // debugging
                    logger.log(Level.FINEST, "Content: " + content.getSize());
                    logger.log(Level.FINEST, "Parent: " + this.getSize());

                }
            } catch (NullPointerException e) {
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
        });
        chatArea = content;
        input.add(button);
        userListPanel = new UserListPanel(controls);
        this.add(userListPanel, BorderLayout.EAST);
        this.add(input, BorderLayout.SOUTH);
        this.setName(Card.CHAT.name());
        controls.addPanel(Card.CHAT.name(), this);
        chatArea.addContainerListener(new ContainerListener() {

            @Override
            public void componentAdded(ContainerEvent e) {
                if (chatArea.isVisible()) {
                    chatArea.revalidate();
                    chatArea.repaint();
                }
            }

            @Override
            public void componentRemoved(ContainerEvent e) {
                if (chatArea.isVisible()) {
                    chatArea.revalidate();
                    chatArea.repaint();
                }
            }

        });
        this.addComponentListener(new ComponentAdapter() {
            @Override
            public void componentResized(ComponentEvent e) {
                // System.out.println("Resized to " + e.getComponent().getSize());
                // rough concepts for handling resize
                // set the dimensions based on the frame size
                Dimension frameSize = wrapper.getParent().getParent().getSize();
                int w = (int) Math.ceil(frameSize.getWidth() * .3f);
                
                userListPanel.setPreferredSize(new Dimension(w, (int)frameSize.getHeight()));
                userListPanel.revalidate();
                userListPanel.repaint();
            }

            @Override
            public void componentMoved(ComponentEvent e) {
                // System.out.println("Moved to " + e.getComponent().getLocation());
            }
        });
    }
    public void addUserListItem(long clientId, String clientName){
        userListPanel.addUserListItem(clientId, clientName);
    }
    public void removeUserListItem(long clientId){
        userListPanel.removeUserListItem(clientId);
    }
    public void clearUserList(){
        userListPanel.clearUserList();
    }
    public void addText(String text) {
        JPanel content = chatArea;
        // add message
        JEditorPane textContainer = new JEditorPane("text/html", text);

        // sizes the panel to attempt to take up the width of the container
        // and expand in height based on word wrapping
        textContainer.setLayout(null);
        textContainer.setPreferredSize(
                new Dimension(content.getWidth(), GeneralUtils.calcHeightForText(this,text, content.getWidth())));
        textContainer.setMaximumSize(textContainer.getPreferredSize());
        textContainer.setEditable(false);
        GeneralUtils.clearBackground(textContainer);
        // add to container and tell the layout to revalidate
        content.add(textContainer);
        // scroll down on new message
        JScrollBar vertical = ((JScrollPane) chatArea.getParent().getParent()).getVerticalScrollBar();
        vertical.setValue(vertical.getMaximum());
    }
}