import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JTable;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;
import javax.swing.table.DefaultTableModel;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JOptionPane;
import rootfindingmethods.BisectionQuad;
import rootfindingmethods.EmptyStackException;
import rootfindingmethods.ArrayStack;
import rootfindingmethods.Stack;

public class AlgorithmsMain extends JFrame implements ActionListener {

    private JPanel contentPane;

    private JComboBox functions = new JComboBox();
    private JRadioButton method1 = new JRadioButton("Newton-Raphson");
    private JRadioButton method2 = new JRadioButton("Bisection");
    private JRadioButton method3 = new JRadioButton("Secant");
    private JButton displayRoots = new JButton("Display Roots");
   // private JTextArea iterationArea = new JTextArea("Output");
    //private JScrollPane scrollPane = new JScrollPane(iterationArea);
    private JScrollPane scrollPane1 = new JScrollPane();
    private JTable table;
    private JTextField minStartingPoint = new JTextField(4);
    private JTextField maxStartingPoint = new JTextField(4);

    Object[] message = {
        "Min:", minStartingPoint,
        "Max:", maxStartingPoint
            
    };

    int cellToMark = -1; //Holds the array that goes in JTable

    Object[][] data;

    String[] columnNames = {"Iteration No.", "Iteration Results"};

    DefaultTableModel dTableModel = new DefaultTableModel(data, columnNames);
    BisectionQuad bs = new BisectionQuad();

    public static void main(String[] args) {
        new AlgorithmsMain();

    }

    public AlgorithmsMain() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
        setSize(850, 600);
        setResizable(false);
        setTitle("Roots Finding Application");

        functions.addItem("Select Function");
        functions.addItem("f(x) = x-x^2");
        functions.addItem("f(x) = ln(x+1)+1");
        functions.addItem("f(x) = e^x-3x");

//        iterationArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
//        iterationArea.setLineWrap(true);
//        iterationArea.setWrapStyleWord(true);
//        iterationArea.setText("");
//        scrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
//        scrollPane.setPreferredSize(new Dimension(500, 300));
        scrollPane1.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        scrollPane1.setPreferredSize(new Dimension(600, 400));
        ButtonGroup methodGroup = new ButtonGroup();
        methodGroup.add(method1);
        methodGroup.add(method2);
        methodGroup.add(method3);

        JPanel top = new JPanel();
        top.add(functions);
        top.add(method1);
        top.add(method2);
        top.add(method3);
        add("North", top);

        JPanel middle = new JPanel();
        middle.add(scrollPane1);
        add("Center", middle);

//        JPanel right = new JPanel();
//        right.add(scrollPane);
//        add("East", right);

        JPanel bottom = new JPanel();
        bottom.add(displayRoots);
        add("South", bottom);

        table = new JTable(dTableModel);
        // Set the font for the table column titles
        table.getTableHeader().setFont(new Font("Dialog", Font.BOLD, 15));
        // Set the font for the data in the columns	             
        table.setFont(new Font("Dialog", Font.BOLD, 15));
        // Increase the row height so that the larger font fits	             
        table.setRowHeight(table.getRowHeight() + 5);
        scrollPane1.setViewportView(table);

        method1.addActionListener(this);
        method2.addActionListener(this);
        method3.addActionListener(this);
        displayRoots.addActionListener(this);
        functions.addActionListener(this);

        setVisible(true);
    }

    public void updateTheTable(Object s) {
        Object[] tempRow;
        int rows = 0;
        dTableModel.setRowCount(0); // Clear JTable

        for (int i = 0; i < rows; i++) {

            if (i == this.cellToMark) {
                tempRow = new Object[]{i, s};
            } else {
                tempRow = new Object[]{i, s};
            }

            dTableModel.addRow(tempRow);

        }

    }


    class AlgorithmsController {

        private AlgorithmsMain theView;
        private BisectionQuad theModel;

        public AlgorithmsController(AlgorithmsMain theView, BisectionQuad theModel) {
            this.theView = theView;
            this.theModel = theModel;
            

        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == displayRoots) {
            if (method1.isSelected()) {
                JOptionPane.showInputDialog(null, "Starting point is");
                
            }
            if (method2.isSelected()) {
                //double result = JOptionPane.showConfirmDialog(null, message, "Starting points", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
                //if (functions.getSelectedItem().toString().equals("f(x) = x - x^2")) {
                        bs.getBisection();
                        Object[][] obj = bs.returnBisectionResults();
                        int size = bs.getArraySize();
                        for(int i = 0; i<size; i++) {
//                            iterationArea.append("x = " + data[i][0]);
//                            iterationArea.append("\nf(x) = " + data[i][1]);
                            JTable table = new JTable(dTableModel);
                            dTableModel.insertRow(table.getRowCount(),new Object[]{obj[i][0],obj[i][1]});
                        }
                        System.out.println("size  "+size);
            }

        }

    }

}
    

