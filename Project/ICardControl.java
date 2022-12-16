package Project;

import javax.swing.JPanel;

public interface ICardControl {
    void next();
    void previous();
    void show(String cardName);
    void addPanel(String name, JPanel panel);
    void connect();
}