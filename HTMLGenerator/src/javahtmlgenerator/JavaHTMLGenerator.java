package javahtmlgenerator;

import java.awt.Color;
import java.awt.Font;
import java.io.File;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.swing.JButton;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

/**
 * The JavaHTMLGeneratorGUI class displays the GUI to a frame.
 * @author Keith McKiernan
 * @date 01/04/14
 */
public class JavaHTMLGenerator extends JPanel
{
	private static final long serialVersionUID = 1L;
	
	// Declared Instance variables
    private Scanner newFile = null;
    private File inFile = null;
    private Color color;
    private String[] data;
    private String filename, newFilename, line;   
    private boolean isFileSelected = false; 
    
    // Declared GUI elements
    JPanel topLeftPanel, mainLeftPanel, mainRightPanel, bottomPanel;
    JLabel pencilIconLabel, mainContentLabel, fileLabel, titleLabel, subTitleLabel, descriptionLabel;
    JLabel featuresLabel, newFileNameLabel, imageLabel, infoLabel, companyLabel, emailLabel;
    JLabel eBayViewOtherItemsLabel, eBayFeedbackLabel;
    JTextField fileTextField, titleTextField, subTitleTextField, borderColorTextField;
    JTextField newFileNameTextField, imageTextField, companyTextField, emailTextField;
    JTextField eBayFeedbackTextField, eBayViewOtherItemsTextField;
    JSeparator topSeparator, bottomSeparator, verticalSeparatorMain;  
    JTextArea mainTextArea, descriptionTextArea, featuresTextArea; 
    JButton browseButton, generateButton, colorButton;
    JScrollPane mainTextScrollPane, jScrollPane, featuresTextScrollPane, descriptionTextScrollPane;    
    JFileChooser chooser;
    
    
    // Constructor
    public JavaHTMLGenerator()
    {
        /* ****************************** *
           *      TOP LEFT CONTENT      *
         * ****************************** */      
        
        // Top Left Panel
        topLeftPanel = new JPanel();
        topLeftPanel.setLayout(null);
        topLeftPanel.setBounds(0, 0, 900, 43);
        topLeftPanel.setBackground(new Color(255, 255, 255));
        topLeftPanel.setVisible(true);
        add(topLeftPanel);       
        
        // Top Left Panel - Heading Icon
        pencilIconLabel = new JLabel();
        pencilIconLabel.setText("");
        pencilIconLabel.setIcon(new javax.swing.ImageIcon(getClass().getResource("/javahtmlgenerator/images/pencil.png")));
        pencilIconLabel.setBounds(336, 10, 92, 26);
        topLeftPanel.add(pencilIconLabel);   
        
        // Top Left Panel - Heading Text Label
        mainContentLabel = new JLabel();
        mainContentLabel.setText("Edit Template Content");
        mainContentLabel.setFont(new java.awt.Font("Franklin Gothic Book", 1, 18));
        mainContentLabel.setBounds(368, 10, 225, 22);
        topLeftPanel.add(mainContentLabel);

        // Top Left Panel - Bottom Horizontal Separator
        topSeparator = new JSeparator();
        topSeparator.setBounds(0, 38, 900, 5);
        topSeparator.setBackground(new Color(0, 0, 0));
        topLeftPanel.add(topSeparator);
        
 
        /* ******************************* *
           *      MAIN LEFT CONTENT      *
         * ******************************* */
        
        
        // Main Left Panel
        mainLeftPanel = new JPanel();
        mainLeftPanel.setLayout(null);
        mainLeftPanel.setBounds(0, 43, 450, 615);
        mainLeftPanel.setBackground(new Color(251, 251, 251));
        mainLeftPanel.setVisible(true);
        add(mainLeftPanel);
        
        // Main Left Panel - File Import Label
        fileLabel = new JLabel();
        fileLabel.setText("Import (ebay.txt) File:");
        fileLabel.setForeground(new Color(60, 60, 60));
        fileLabel.setFont(new java.awt.Font("Franklin Gothic Book", 1, 14));
        fileLabel.setBounds(40, 20, 135, 18);
        mainLeftPanel.add(fileLabel);
            
        // Main Left Panel - File Import Text Field
        fileTextField = new JTextField();
        fileTextField.setBounds(40, 45, 265, 35);
        fileTextField.setBackground(Color.WHITE);
        fileTextField.setForeground(new Color(150, 150, 150));
        fileTextField.setToolTipText("<html><p style=\"padding: 10px;\">Please select the ebay.txt file from the directory</p></html>");
        fileTextField.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new Color(230, 230, 230), 1, true), null));
        mainLeftPanel.add(fileTextField);
        
        // Main Left Panel - Browse Button
        browseButton = new JButton();
        browseButton.setText("Browse");
        browseButton.setBackground(new Color(240, 240, 240));
        browseButton.setForeground(new Color(100, 100, 100));
        browseButton.setFont(new java.awt.Font("Franklin Gothic Book", Font.BOLD, 14));
        browseButton.setOpaque(true);
        browseButton.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new Color(230, 230, 230), 1, true), null));
        browseButton.setBounds(320, 45, 90, 35);
        browseButton.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                browseButtonActionPerformed(evt);
            }
        });
        mainLeftPanel.add(browseButton);
            
        // Main Left Panel - Title Label
        titleLabel = new JLabel();
        titleLabel.setText("Title:");
        titleLabel.setForeground(new Color(60, 60, 60));
        titleLabel.setFont(new java.awt.Font("Franklin Gothic Book", 1, 14));
        titleLabel.setBounds(42, 110, 35, 18);
        mainLeftPanel.add(titleLabel);
            
        // Main Left Panel - Title Text Field
        titleTextField = new JTextField();
        titleTextField.setBounds(40, 135, 170, 35);
        titleTextField.setBackground(Color.WHITE);
        titleTextField.setForeground(new Color(150, 150, 150));
        titleTextField.setToolTipText("<html><p style=\"padding: 10px;\">Enter the title of your product.</p></html>");
        titleTextField.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new Color(230, 230, 230), 1, true), null));
        mainLeftPanel.add(titleTextField);
            
        // Main Left Panel - SubTitle Label
        subTitleLabel = new JLabel();
        subTitleLabel.setText("Sub Title:");
        subTitleLabel.setForeground(new Color(60, 60, 60));
        subTitleLabel.setFont(new java.awt.Font("Franklin Gothic Book", 1, 14));
        subTitleLabel.setBounds(242, 110, 75, 18);
        mainLeftPanel.add(subTitleLabel);
           
        // Main Left Panel - SubTitle Text Field
        subTitleTextField = new JTextField();
        subTitleTextField.setBounds(240, 135, 170, 35);
        subTitleTextField.setBackground(Color.WHITE);
        subTitleTextField.setForeground(new Color(150, 150, 150));
        subTitleTextField.setToolTipText("<html><p style=\"padding: 10px;\">Enter the sub title of your product.</p></html>");
        subTitleTextField.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new Color(230, 230, 230), 1, true), null));
        mainLeftPanel.add(subTitleTextField); 
        
        // Main Left Panel - File Import Label
        imageLabel = new JLabel();
        imageLabel.setText("Image URL Address:");
        imageLabel.setForeground(new Color(60, 60, 60));
        imageLabel.setFont(new java.awt.Font("Franklin Gothic Book", 1, 14));
        imageLabel.setBounds(40, 200, 135, 18);
        mainLeftPanel.add(imageLabel);
            
        // Main Left Panel - File Import Text Field
        imageTextField = new JTextField();
        imageTextField.setBounds(40, 225, 370, 35);
        imageTextField.setBackground(Color.WHITE);
        imageTextField.setForeground(new Color(150, 150, 150));
        imageTextField.setToolTipText("<html><p style=\"padding: 10px;\">Enter the Web Address (URL) where your product image is hosted.<br />e.g. On your own server or image hosting sites such as www.photobucket.com</p></html>");
        imageTextField.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new Color(230, 230, 230), 1, true), null));
        mainLeftPanel.add(imageTextField);
        
        // Main Left Panel - Description Label
        descriptionLabel = new JLabel();
        descriptionLabel.setText("Description:");
        descriptionLabel.setForeground(new Color(60, 60, 60));
        descriptionLabel.setFont(new java.awt.Font("Franklin Gothic Book", 1, 14));
        descriptionLabel.setBounds(40, 290, 75, 18);
        mainLeftPanel.add(descriptionLabel);
        
        // Main Left Panel - Description Text Area
        descriptionTextArea = new JTextArea();
        descriptionTextArea.setText("");
        descriptionTextArea.setEditable(true);
        descriptionTextArea.setForeground(new Color(150, 150, 150));
        descriptionTextArea.setToolTipText("<html><p style=\"padding: 10px;\">Enter the description of your product.</p></html>");
        mainLeftPanel.add(descriptionTextArea);
        descriptionTextScrollPane = new JScrollPane(descriptionTextArea);
        descriptionTextScrollPane.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new Color(230, 230, 230), 1, true), null));   
        descriptionTextScrollPane.setBounds(40, 315, 370, 100);
        mainLeftPanel.add(descriptionTextScrollPane);        
        
        // Main Left Panel - Features Label
        featuresLabel = new JLabel();
        featuresLabel.setText("Features:");
        featuresLabel.setForeground(new Color(60, 60, 60));
        featuresLabel.setFont(new java.awt.Font("Franklin Gothic Book", 1, 14));
        featuresLabel.setBounds(40, 443, 75, 18);
        mainLeftPanel.add(featuresLabel);
        
        // Main Left Panel - Features Text Area
        featuresTextArea = new JTextArea();
        featuresTextArea.setText("");
        featuresTextArea.setEditable(true);
        featuresTextArea.setForeground(new Color(150, 150, 150));
        mainLeftPanel.add(featuresTextArea);
        featuresTextScrollPane = new JScrollPane(featuresTextArea);
        featuresTextScrollPane.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new Color(230, 230, 230), 1, true), null));   
        featuresTextScrollPane.setBounds(40, 468, 370, 100);
        mainLeftPanel.add(featuresTextScrollPane);
        
        // Main Left Panel - Right Vertical Separator
        verticalSeparatorMain = new JSeparator();
        verticalSeparatorMain.setOrientation(SwingConstants.VERTICAL);
        verticalSeparatorMain.setBounds(445, 0, 450, 625);
        verticalSeparatorMain.setBackground(new Color(0, 0, 0));
        mainLeftPanel.add(verticalSeparatorMain);
        
        
        /* ******************************** *
           *      MAIN RIGHT CONTENT      *
         * ******************************** */


        // Main Right Panel
        mainRightPanel = new JPanel();
        mainRightPanel.setLayout(null);
        mainRightPanel.setBounds(450, 43, 900, 615);
        mainRightPanel.setBackground(new Color(251, 251, 251));
        mainRightPanel.setVisible(true);
        add(mainRightPanel);
        
        // Main Right Panel - Company Label
        companyLabel = new JLabel();
        companyLabel.setText("Company Name:");
        companyLabel.setForeground(new Color(60, 60, 60));
        companyLabel.setFont(new java.awt.Font("Franklin Gothic Book", 1, 14));
        companyLabel.setBounds(40, 20, 135, 18);
        mainRightPanel.add(companyLabel);
            
        // Main Right Panel - Company Text Field
        companyTextField = new JTextField();
        companyTextField.setBounds(40, 45, 170, 35);
        companyTextField.setBackground(Color.WHITE);
        companyTextField.setForeground(new Color(150, 150, 150));
        companyTextField.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new Color(230, 230, 230), 1, true), null));
        mainRightPanel.add(companyTextField);
        
        // Main Right Panel - Email Label
        emailLabel = new JLabel();
        emailLabel.setText("Email Address:");
        emailLabel.setForeground(new Color(60, 60, 60));
        emailLabel.setFont(new java.awt.Font("Franklin Gothic Book", 1, 14));
        emailLabel.setBounds(242, 20, 135, 18);
        mainRightPanel.add(emailLabel);
            
        // Main Right Panel - Email Text Field
        emailTextField = new JTextField();
        emailTextField.setBounds(240, 45, 170, 35);
        emailTextField.setBackground(Color.WHITE);
        emailTextField.setForeground(new Color(150, 150, 150));
        emailTextField.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new Color(230, 230, 230), 1, true), null));
        mainRightPanel.add(emailTextField);
        
        // Main Right Panel - eBay Feedback Label
        eBayFeedbackLabel = new JLabel();
        eBayFeedbackLabel.setText("eBay Feedback Page URL Address:");
        eBayFeedbackLabel.setForeground(new Color(60, 60, 60));
        eBayFeedbackLabel.setFont(new java.awt.Font("Franklin Gothic Book", 1, 14));
        eBayFeedbackLabel.setBounds(40, 110, 235, 18);
        mainRightPanel.add(eBayFeedbackLabel);
            
        // Main Right Panel - eBay Feedback Text Field
        eBayFeedbackTextField = new JTextField();
        eBayFeedbackTextField.setBounds(40, 135, 370, 35);
        eBayFeedbackTextField.setBackground(Color.WHITE);
        eBayFeedbackTextField.setForeground(new Color(150, 150, 150));
        eBayFeedbackTextField.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new Color(230, 230, 230), 1, true), null));
        mainRightPanel.add(eBayFeedbackTextField);
        
        // Main Right Panel - eBay View Other Items Label
        eBayViewOtherItemsLabel = new JLabel();
        eBayViewOtherItemsLabel.setText("eBay View Other Items URL Address:");
        eBayViewOtherItemsLabel.setForeground(new Color(60, 60, 60));
        eBayViewOtherItemsLabel.setFont(new java.awt.Font("Franklin Gothic Book", 1, 14));
        eBayViewOtherItemsLabel.setBounds(40, 200, 235, 18);
        mainRightPanel.add(eBayViewOtherItemsLabel);
            
        // Main Right Panel - eBay View Other Items Text Field
        eBayViewOtherItemsTextField = new JTextField();
        eBayViewOtherItemsTextField.setBounds(40, 225, 370, 35);
        eBayViewOtherItemsTextField.setBackground(Color.WHITE);
        eBayViewOtherItemsTextField.setForeground(new Color(150, 150, 150));
        eBayViewOtherItemsTextField.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new Color(230, 230, 230), 1, true), null));
        mainRightPanel.add(eBayViewOtherItemsTextField);   
        
        // Main Right Panel - Information Label
        infoLabel = new JLabel();
        infoLabel.setText("Template Changes:");
        infoLabel.setForeground(new Color(60, 60, 60));
        infoLabel.setFont(new java.awt.Font("Franklin Gothic Book", 1, 14));
        infoLabel.setBounds(40, 290, 135, 18);
        mainRightPanel.add(infoLabel);

        // Main Right Panel - Main Text Area
        mainTextArea = new JTextArea();
        mainTextArea.setText("");
        mainTextArea.setEditable(false);
        mainTextArea.setForeground(new Color(150, 150, 150));
        mainRightPanel.add(mainTextArea);
        mainTextScrollPane = new JScrollPane(mainTextArea);
        mainTextScrollPane.setBounds(40, 315, 370, 253);
        mainTextScrollPane.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new Color(230, 230, 230), 1, true), null));
        mainRightPanel.add(mainTextScrollPane); 
   
        
        /* ******************************** *
           *        BOTTOM CONTENT        *
         * ******************************** */
        
        
        // Bottom Panel
        bottomPanel = new JPanel();
        bottomPanel.setLayout(null);
        bottomPanel.setBounds(0, 615, 900, 740);
        bottomPanel.setBackground(new Color(254, 254, 254));
        bottomPanel.setVisible(true);
        add(bottomPanel);
        
        // Bottom Panel - Border Color Chooser Button
        colorButton = new JButton();
        colorButton.setText("Choose Template Color");
        colorButton.setBackground(new Color(160, 160, 160));
        colorButton.setForeground(new Color(255, 255, 255));
        colorButton.setFont(new java.awt.Font("Franklin Gothic Book", Font.BOLD, 14));
        colorButton.setOpaque(true);
        colorButton.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new Color(200, 200, 200), 1, true), null));
        colorButton.setBounds(40, 53, 170, 40);
        colorButton.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                colorButtonActionPerformed(evt);
            }
        }); 
        bottomPanel.add(colorButton);
        
        // Bottom Panel - Color Hidden Text Field 
        borderColorTextField = new JTextField();
        borderColorTextField.setBounds(0, 0, 0, 0);
        mainRightPanel.add(borderColorTextField);
        
        // Bottom Panel - Save As Label
        newFileNameLabel = new JLabel();
        newFileNameLabel.setText("Save File As:");
        newFileNameLabel.setForeground(new Color(60, 60, 60));
        newFileNameLabel.setFont(new java.awt.Font("Franklin Gothic Book", 1, 14));
        newFileNameLabel.setBounds(300, 64, 75, 18);
        bottomPanel.add(newFileNameLabel);
        
        // Bottom Panel - Save As Text Field
        newFileNameTextField = new JTextField();
        newFileNameTextField.setBackground(Color.WHITE);
        newFileNameTextField.setForeground(new Color(150, 150, 150));
        newFileNameTextField.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new Color(230, 230, 230), 1, true), null));
        newFileNameTextField.setBounds(400, 53, 290, 40);
        bottomPanel.add(newFileNameTextField);
        
        // Bottom Panel - Generate HTML Button
        generateButton = new JButton();
        generateButton.setText("Generate HTML");
        generateButton.setBackground(new Color(26, 188, 156));
        generateButton.setForeground(new Color(255, 255, 255));
        generateButton.setFont(new java.awt.Font("Franklin Gothic Book", Font.BOLD, 14));
        generateButton.setOpaque(true);
        generateButton.setBorder(javax.swing.BorderFactory.createCompoundBorder(new javax.swing.border.LineBorder(new Color(26, 188, 156), 1, true), null));
        generateButton.setBounds(708, 53, 150, 40);
        generateButton.addActionListener(new java.awt.event.ActionListener() 
        {
            public void actionPerformed(java.awt.event.ActionEvent evt) 
            {
                generateButtonActionPerformed(evt);
            }
        });
        bottomPanel.add(generateButton);
        
        // Bottom Panel - Bottom Horizontal Separator
        bottomSeparator = new JSeparator();
        bottomSeparator.setBounds(0, 600, 900, 620);
        bottomSeparator.setBackground(new Color(0, 0, 0));
        bottomPanel.add(bottomSeparator);   
    }
     
    /**
     * The convertToHexValue class converts the RGB values to a Hexadecimal value.
     * @param color Gets the color and converts to a hexadecimal value.
     * @return The hexadecimal value.
     */
    public String convertToHexValue(Color color) 
    {  
        String hexString = "#";

        if (color.getRed() < 16) 
        {
            hexString += '0';   
        }
        hexString += Integer.toHexString(color.getRed());

        if (color.getGreen() < 16) 
        {
            hexString += '0';
        }
        hexString += Integer.toHexString(color.getGreen());

        if (color.getBlue() < 16) 
        {
            hexString += '0';
        }
        hexString += Integer.toHexString(color.getBlue());
        
        return hexString.toString();
    }  
    
    /**
     * The getImportFile class browses for a txt file on the users computer
     * and imports the selected txt file to the GUI.
     */
    public void getImportFile() 
    {
        chooser = new JFileChooser();
        chooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
        chooser.setAcceptAllFileFilterUsed(false);
        
        while (!isFileSelected) 
        {      
            int option = chooser.showOpenDialog(null);

            if (option == JFileChooser.APPROVE_OPTION) 
            {
                inFile = chooser.getSelectedFile();
                filename = inFile.getAbsolutePath();
            }

            try 
            {    
                newFile = new Scanner(inFile);
                fileTextField.setText(filename);
                isFileSelected = true;
            } 

            catch (Exception ex) 
            {
                 JOptionPane.showMessageDialog(null, "No input file selected. Please select a file.", "Selection Error", JOptionPane.ERROR_MESSAGE);     
            }
        }     
    }
     
    /**
     * The getTemplate class allows the user to open up a color chooser
     * and pick any color they wish the template to be, 
     * this class changes the color of the borders and main headings in the program.
     *
     */
    public void getTemplateColor() 
    {
       JColorChooser colorChooser = new JColorChooser(); 
       color = colorChooser.showDialog(mainLeftPanel, "Pick a Color", Color.BLUE);
       
       if (color != null) 
       {
            borderColorTextField.setText(convertToHexValue(color));
       }
       
       else 
       {
            JOptionPane.showMessageDialog(null, "No Template Color Chosen", "Color Not Chosen", JOptionPane.INFORMATION_MESSAGE);
       } 
    }
        
    /**
     * The checkTextFields class checks if an input field is empty, 
     * if the field is empty default text / image is inserted.
     */
    public void checkTextFields() 
    {        
        /* Check if a color has been selected. */      
        if (borderColorTextField.getText().isEmpty()) {
            borderColorTextField.setText("#079ade");
        }

        else {
            borderColorTextField.getText();
        }

        /* Check if the title field is empty. */
        if (titleTextField.getText().isEmpty()) {
            titleTextField.setText("New Title Text Goes Here...");
        }
        
        else {
            titleTextField.getText();
        }
        
        /* Check if the sub title field is empty. */        
        if (subTitleTextField.getText().isEmpty()) {
            subTitleTextField.setText("New Sub Title Text Goes Here...");
        }
        
        else {
            subTitleTextField.getText();
        }
        
        /* Check if the sub title field is empty. */        
        if (descriptionTextArea.getText().isEmpty()) {
            descriptionTextArea.setText("Description Text Goes Here...");
        }
        
        else {
            descriptionTextArea.getText();
        }
        
        /* Check if the sub title field is empty. */        
        if (featuresTextArea.getText().isEmpty()) {
            featuresTextArea.setText("Features Text Goes Here...");
        }
        
        else {
            featuresTextArea.getText();
        }

        /* Check if the image field is empty. */
        if (imageTextField.getText().isEmpty()) {
            imageTextField.setText("http://i871.photobucket.com/albums/ab277/keito-1/noimage_zps98b7be9f.png");
        }
        
        else {
            imageTextField.getText();
        }

        /* Check if the company field is empty. */        
        if (companyTextField.getText().isEmpty()) {
            companyTextField.setText("CompanyName");
        }
        
        else {
            companyTextField.getText();
        } 

        /* Check if the email field is empty. */        
        if (emailTextField.getText().isEmpty()) {
            emailTextField.setText("sales@examplecompany.com");
        }
        
        else {
            emailTextField.getText();
        } 
        
        /* Check if the eBay View Other Items field is empty. */        
        if (eBayViewOtherItemsTextField.getText().isEmpty()) {
            eBayViewOtherItemsTextField.setText("#");
        }
        
        else {
            eBayViewOtherItemsTextField.getText();
        } 
        
        /* Check if the eBay Feedback field is empty. */        
        if (eBayFeedbackTextField.getText().isEmpty()) {
            eBayFeedbackTextField.setText("#");
        }
        
        else {
            eBayFeedbackTextField.getText();
        }  

        /* Check if the newFilename field is empty. */  
        if (newFileNameTextField.getText().isEmpty()) {
            newFilename = "template";
        }
        
        else {
            newFilename = newFileNameTextField.getText();
        } 
    }
    
    /**
     * The generateButton class creates the HTML template when the user clicks on it.
     */ 
    public void generateButtonClick() 
    {
       PrintWriter outputTemplate = null; 
        
        if (isFileSelected) 
        {
            try 
            { 
                checkTextFields();
                outputTemplate = new PrintWriter(newFilename + ".html"); 
            } 

            catch (Exception ex) 
            { 
                JOptionPane.showMessageDialog(null, "Error: Failed To Create File..", "File Error", JOptionPane.ERROR_MESSAGE);
                System.exit(0);
            }  
        }
        
        else 
        {
            JOptionPane.showMessageDialog(null, "Error: No File Selected. Failed To Create File.", "File Error", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
	
	while (newFile.hasNextLine()) 
        {            
            line = newFile.nextLine(); 
            data = line.split("~"); 
            
            data[1]     = borderColorTextField.getText();
            data[3]     = borderColorTextField.getText();
            data[5]     = borderColorTextField.getText();
            data[7]     = borderColorTextField.getText();
            data[9]     = borderColorTextField.getText();
            data[11]    = companyTextField.getText();
            data[13]    = emailTextField.getText();
            data[15]    = eBayViewOtherItemsTextField.getText();
            data[17]    = eBayFeedbackTextField.getText();
            data[19]    = emailTextField.getText();
            data[21]    = titleTextField.getText();
            data[23]    = subTitleTextField.getText();
            data[25]    = imageTextField.getText();
            data[27]    = descriptionTextArea.getText();
            data[29]    = featuresTextArea.getText();
            data[31]    = companyTextField.getText();
            
            for (String fileData : data) 
            {                
                outputTemplate.print(fileData);
            }

            mainTextArea.append("------------- Template Information --------------\n\n");
            mainTextArea.append("- Template Colour:     \t" + data[1]  + "\n");
            mainTextArea.append("- Product Title:       \t" + data[21] + "\n");
            mainTextArea.append("- Product SubTitle:    \t" + data[23] + "\n");
            mainTextArea.append("- Product Description: \t" + data[27] + "\n");
            mainTextArea.append("- Product Features:    \t" + data[29] + "\n");
            mainTextArea.append("- Company Name:        \t" + data[31] + "\n");
            mainTextArea.append("- Email Address:       \t" + data[13] + "\n");
            mainTextArea.append("- Feedback Address:    \t" + data[17] + "\n");
            mainTextArea.append("- Other Items Address: \t" + data[15] + "\n");
            mainTextArea.append("\n-----------------------------------------------");
        }
        
        // Import Success Icon for Success JOptionPane
        ImageIcon successIcon = new ImageIcon(JavaHTMLGenerator.class.getResource("images/success.png"));
        
        // Check the file is not empty and display a Success Message
        if (outputTemplate != null) 
        {
            JOptionPane.showMessageDialog(null, "<html><div>HTML File Created Successfully.<br /><br />New HTML File Located At:<br /> " + new File(" ").getAbsolutePath() + newFilename + ".html</div></html>", "Success", JOptionPane.INFORMATION_MESSAGE, successIcon);     
        }  
        
        // Close the PrintWriter Files
	outputTemplate.close();
        
	// Close the file
        newFile.close();
    }
 
    private void browseButtonActionPerformed(java.awt.event.ActionEvent evt) 
    {    
        getImportFile();
    }  
    
    private void colorButtonActionPerformed(java.awt.event.ActionEvent evt) 
    { 
        getTemplateColor();
    } 
      
    private void generateButtonActionPerformed(java.awt.event.ActionEvent evt) 
    {    
        generateButtonClick();
    }   
}