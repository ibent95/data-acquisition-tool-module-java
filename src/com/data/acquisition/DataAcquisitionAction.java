/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/NetBeansModuleDevelopment-files/actionListener.java to edit this template
 */
package com.data.acquisition;

import com.data.acquisition.wizard.DataAcquisitionWizardAction;
import com.data.acquisition.wizard.DataAcquisitionWizardPanel1;
import com.data.acquisition.wizard.DataAcquisitionWizardPanel2;
import com.data.acquisition.wizard.DataAcquisitionWizardPanel3;
import com.data.acquisition.wizard.DataAcquisitionWizardPanel4;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JProgressBar;
import org.openide.DialogDisplayer;
import org.openide.WizardDescriptor;
import org.openide.awt.ActionID;
import org.openide.awt.ActionReference;
import org.openide.awt.ActionReferences;
import org.openide.awt.ActionRegistration;
import org.openide.util.NbBundle.Messages;

@ActionID(
        category = "Case",
        id = "com.data.acquisition.DataAcquisitionAction"
)
@ActionRegistration(
        iconBase = "com/data/acquisition/Hard-Disk.png",
        displayName = "#CTL_DataAcquisitionAction"
)
@ActionReferences({
    @ActionReference(path = "Menu/Tools", position = 2075, separatorAfter = 2087),
    @ActionReference(path = "Toolbars/Case", position = -100),
    @ActionReference(path = "Shortcuts", name = "D-D D-D")
})
@Messages("CTL_DataAcquisitionAction=Data Acquisition")
public final class DataAcquisitionAction implements ActionListener {
    
    public static String sourcePath;
    public static String destinationPath;
    public static String destinationFileName;
    public static String destinationFileExtention = ".dd";
    
    private static JFrame jFrame;
    private static JProgressBar jProgressBar;  
    
    private DataAcquisitionWizardAction wizardListener;
    
    public void constructor() {
        this.wizardListener = new DataAcquisitionWizardAction();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // JOptionPane.showMessageDialog(null, "Hallo", "Test", JOptionPane.INFORMATION_MESSAGE);
        
        // this.wizardListener.actionPerformed(e);

        List<WizardDescriptor.Panel<WizardDescriptor>> panels = new ArrayList<WizardDescriptor.Panel<WizardDescriptor>>();
        panels.add(new DataAcquisitionWizardPanel1());
        panels.add(new DataAcquisitionWizardPanel2());
        panels.add(new DataAcquisitionWizardPanel3());
        panels.add(new DataAcquisitionWizardPanel4());

        String[] steps = new String[panels.size()];
        String[] stepNames = {"Perangkat sumber", "Lokasi tujuan", "Informasi tambahan", "Konfirmasi"};

        for (int i = 0; i < panels.size(); i++) {
            Component c = panels.get(i).getComponent();

            // Default step name to component name of panel.
            steps[i] = "Langkah " + (i + 1) + " - " + stepNames[i]; // c.getName() + stepNames[i]

            if (c instanceof JComponent) { // assume Swing components
                JComponent jc = (JComponent) c;
                jc.putClientProperty(WizardDescriptor.PROP_CONTENT_SELECTED_INDEX, i);
                jc.putClientProperty(WizardDescriptor.PROP_CONTENT_DATA, steps);
                jc.putClientProperty(WizardDescriptor.PROP_AUTO_WIZARD_STYLE, true);
                jc.putClientProperty(WizardDescriptor.PROP_CONTENT_DISPLAYED, true);
                jc.putClientProperty(WizardDescriptor.PROP_CONTENT_NUMBERED, true);
            }
        }

        WizardDescriptor wiz = new WizardDescriptor(new WizardDescriptor.ArrayIterator<WizardDescriptor>(panels));
        // {0} will be replaced by WizardDesriptor.Panel.getComponent().getName()
        wiz.setTitleFormat(new MessageFormat("{0}"));
        wiz.setTitle("...dialog title...");

        if (DialogDisplayer.getDefault().notify(wiz) == WizardDescriptor.FINISH_OPTION) {
            // JOptionPane.showMessageDialog(null, sourcePath + " - " + destinationPath + destinationFileName + destinationFileExtention, "Result", JOptionPane.INFORMATION_MESSAGE);
            this.runProcess(sourcePath, destinationPath, destinationFileName, destinationFileExtention);
        }
    }
    
    public void runProcess(String a, String b, String c, String d) {
        try {
            jFrame = new JFrame( " Progress Bar " ) ;  
            jProgressBar = new JProgressBar();
            jProgressBar.setValue(0);
            jProgressBar.setStringPainted(true);
            jFrame.add(jProgressBar);
            jFrame.setSize(500,500) ;  
            jFrame.setVisible(true);
            
            System.out.println("Run ...");
            System.out.println(a + " - " + b + c + d);
            // Create the proccess in JAVA
            Process proc = Runtime.getRuntime().exec("dcfldd/dcfldd.exe if=" + a + " of=" + b + c + d);

            // Receive outputs from another program inside Java by a stream
            InputStream ips = proc.getInputStream();

            // Using the stream to get the messages from another program
            String output = "";
            int in = 0;
            while ((in = ips.read()) != -1){
                output += (char) in;
                System.out.println("Process " + output);
            }
            
            System.out.println(output);
            
            //Inputs messages into another program
            OutputStream ops = proc.getOutputStream();
            ops.write(in); // "an byte array"
            
            System.out.println("End 1");
        } catch (Exception e) {
            System.err.println(e.getMessage());
            System.out.println(" End 2");
        }
        
        System.out.println(" End 3 ");
    }
}
