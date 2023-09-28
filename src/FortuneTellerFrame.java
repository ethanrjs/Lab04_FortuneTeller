import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

public class FortuneTellerFrame extends JFrame {
    private int lastIndex = -1;
    private final JTextArea textArea;
    private final ArrayList<String> fortunes;

    public FortuneTellerFrame() {
        setTitle("Fortune Teller");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        setLayout(new BorderLayout());

        // Top Panel
        JPanel topPanel = new JPanel();

        URL imageUrl = getClass().getResource("fortune-teller.png");
        ImageIcon imageIcon = new ImageIcon(imageUrl);

        // Resize the image icon because otherwise it's way too big
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(100, 100, java.awt.Image.SCALE_SMOOTH);  // set the width and height
        imageIcon = new ImageIcon(scaledImage);

        JLabel label = new JLabel("Fortune Teller", imageIcon, JLabel.CENTER);
        label.setFont(new Font("Arial", Font.BOLD, 36));

        // Position text below image
        label.setVerticalTextPosition(JLabel.BOTTOM);
        label.setHorizontalTextPosition(JLabel.CENTER);

        topPanel.add(label);
        add(topPanel, BorderLayout.NORTH);

        // Middle Panel
        textArea = new JTextArea(10, 40);
        textArea.setFont(new Font("Verdana", Font.PLAIN, 24));
        JScrollPane scrollPane = new JScrollPane(textArea);
        add(scrollPane, BorderLayout.CENTER);

        // Bottom Panel
        JPanel bottomPanel = new JPanel();
        JButton readButton = new JButton("Read My Fortune!");
        JButton quitButton = new JButton("Quit");
        readButton.setFont(new Font("Arial", Font.PLAIN, 24));
        quitButton.setFont(new Font("Arial", Font.PLAIN, 24));
        bottomPanel.add(readButton);
        bottomPanel.add(quitButton);
        add(bottomPanel, BorderLayout.SOUTH);

        // Fortunes
        fortunes = new ArrayList<>();
        fortunes.add("You will find love soon, or maybe it's just indigestion.");
        fortunes.add("Great wealth is coming your way. Don't spend it all in one place, like a vending machine.");
        fortunes.add("You will embark on a great journey. Hopefully not during rush hour.");
        fortunes.add("You will find eternal happiness. Just not today.");
        fortunes.add("You'll meet the person of your dreams. Wake up, it's a dream.");
        fortunes.add("A long-lost relative will contact you. Keep your spam folder ready.");
        fortunes.add("You'll be surrounded by admirers. They'll be the ones pointing and laughing.");
        fortunes.add("Your intelligence will open doors for you. Hopefully not the ones marked 'Exit'.");
        fortunes.add("The future is uncertain but the end is always near. That's poetic, not a prophecy.");
        fortunes.add("You'll stumble upon hidden talents. Probably while searching for the remote.");
        fortunes.add("You will be given a great responsibility. Don't worry, it's just taking out the trash.");
        fortunes.add("Your life will be filled with magical moments. Mostly disappearing acts by your socks.");

        readButton.addActionListener((ActionEvent e) -> readFortune());
        quitButton.addActionListener((ActionEvent e) -> System.exit(0));
    }

    private void readFortune() {
        Random random = new Random();
        int index;
        do {
            index = random.nextInt(fortunes.size());
        } while (index == lastIndex);
        lastIndex = index;
        String fortune = fortunes.get(index);
        textArea.append(fortune + "\n"); // add new line to end of fortune for readability
    }
}
