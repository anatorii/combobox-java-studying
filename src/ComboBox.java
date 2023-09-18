import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;

public class ComboBox extends JFrame {
    static int width = 800;
    static int height = 600;
    private JComboBox comboBox;
    private JCheckBox checkBox;
    private JTextField field;
    private JLabel label;
    public ComboBox()
    {
        super("ComboBox");

        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();

        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.setSize(ComboBox.width, ComboBox.height);
        this.setLocation(d.width / 2 - ComboBox.width / 2, d.height / 2 - ComboBox.height / 2);
        this.getContentPane().setBackground(Color.orange);
        this.setLocationRelativeTo(null);
        this.setLayout(new BorderLayout());

        JPanel panelUp = new JPanel(new GridBagLayout());
        this.add(panelUp, BorderLayout.CENTER);

        JPanel panelDown = new JPanel(new GridLayout());
        panelDown.setPreferredSize(new Dimension(0, 70));
        panelDown.setBackground(Color.white);
        this.add(panelDown, BorderLayout.SOUTH);

        comboBox = new JComboBox<>(new String[] {"Красный","Желтый","Фиолетовый","Коричневый","Оранжевый"});

        checkBox = new JCheckBox("Свой вариант");

        field = new JTextField("");
        field.setEnabled(false);

        JButton button = new JButton("Ответить");

        label = new JLabel("Ответ:");
        label.setHorizontalAlignment(SwingConstants.CENTER);

        panelUp.add(comboBox, new GridBagConstraints(0, 0, 3, 1, 0, 0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(20, 20, 10, 20), 0, 0));
        panelUp.add(checkBox, new GridBagConstraints(0, 1, 1, 1, 0, 0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(20, 20, 10, 20), 0, 0));
        panelUp.add(field, new GridBagConstraints(0, 2, 3, 1, 0, 0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(20, 20, 10, 20), 0, 0));
        panelUp.add(button, new GridBagConstraints(0, 3, 1, 1, 0, 0,
                GridBagConstraints.NORTH, GridBagConstraints.HORIZONTAL,
                new Insets(20, 20, 10, 20), 0, 0));

        panelDown.add(label);

        this.setVisible(true);

        button.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
            if (checkBox.isSelected()) {
                label.setText("Ответ: " + field.getText());
            } else {
                label.setText("Ответ: " + comboBox.getItemAt(comboBox.getSelectedIndex()));
            }
            }
        });

        checkBox.addActionListener(new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
            field.setEnabled(((JCheckBox)e.getSource()).isSelected());
            }
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                ComboBox frame = new ComboBox();
            }
        });
    }
}
