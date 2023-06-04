/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/NetBeansModuleDevelopment-files/actionListener.java to edit this template
 */
package com.data.acquisition;

import com.data.acquisition.progressBar.ProgressBarFrame;
import com.data.acquisition.wizard.DataAcquisitionWizardAction;
import com.data.acquisition.wizard.DataAcquisitionWizardPanel1;
import com.data.acquisition.wizard.DataAcquisitionWizardPanel2;
import com.data.acquisition.wizard.DataAcquisitionWizardPanel3;
import com.data.acquisition.wizard.DataAcquisitionWizardPanel4;
import java.awt.Component;
import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.file.*;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
    private static JPanel jPanel;
    private static JProgressBar jProgressBar;
    public static ProgressBarFrame jProgressBarFrame;
    
    private DataAcquisitionWizardAction wizardListener;
    
    public void constructor(DataAcquisitionWizardAction dawa, ProgressBarFrame pbf) {
        this.wizardListener = dawa;
        this.jProgressBarFrame = pbf;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
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

        this.initialProgressBar();

        if (DialogDisplayer.getDefault().notify(wiz) == WizardDescriptor.FINISH_OPTION) {
            // JOptionPane.showMessageDialog(null, sourcePath + " - " + destinationPath + destinationFileName + destinationFileExtention, "Result", JOptionPane.INFORMATION_MESSAGE);
//            Path source = (Path) FileSystems.getDefault().getPath(sourcePath);
//            Path res = this.mountOf(source);
//            File currDir = new File(sourcePath);
//            Path root = currDir.toPath().getRoot();
//            System.out.println(res + " - " + currDir + " - " + root);
            this.runProcess(sourcePath, destinationPath, destinationFileName, destinationFileExtention);
        }
    }

    public void runProcess(String a, String b, String c, String d) {
        try {
//            this.jProgressBarFrame.setVisible(true);
            DataAcquisitionAction.jFrame.setVisible(true);

            System.out.println("Start the process.");
            System.out.println("Initiate state...");
            System.out.println("Source: " + a.replace("\\", ""));
            System.out.println("Target: " + b + c + d);

            String dcflddCommand    = "dcfldd\\dcfldd.exe if=" + a + " of=" + b + c + d;
            String ddPath           = "dd\\";
            String ddFile           = "dd.exe";
            String ddSubCommand1    = "if=\\\\.\\" + a.replace("\\", "");
            String ddSubCommand2    = "of=\\\\.\\" + b + c + d;
            String ddCommand[]   = new String[]{ddPath + ddFile, ddSubCommand1, ddSubCommand2, "bs=1M", "--size", "--progress"};
            System.out.println("Command: " + ddPath + ddFile + " " + ddSubCommand1 + " " + ddSubCommand2);

            // Create the proccess in JAVA
            System.out.println("Begind the command...");
            ProcessBuilder process  = new ProcessBuilder(ddCommand);
            Process p               = process.start();

            // Using the stream to get the messages from another program

            // Receive outputs from another program inside Java by a stream
            InputStream inputStream = p.getInputStream();
            int inputState = -1;
            while ((inputState = inputStream.read()) != -1) {
                System.out.print((char) inputState);
            }

            // Receive outputs from another program inside Java by a stream
            InputStream errorStream = p.getErrorStream();
            int errorState = -1;
            while ((errorState = errorStream.read()) != -1) {
                System.out.print((char) errorState);
            }
            //p.destroy();
            
            DataAcquisitionAction.jFrame.setVisible(false);
            System.out.println("Finish the command.");
        } catch (Exception e) {
            DataAcquisitionAction.jFrame.setVisible(false);
            JOptionPane.showMessageDialog(null, e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            System.err.println(e.getMessage());
            System.out.println("Stop the command with error.");
        }

        System.out.println("Stop the process.");
    }

    private void initialProgressBar() {
        DataAcquisitionAction.jFrame          = new JFrame("Run the command...");
        DataAcquisitionAction.jPanel          = new JPanel();
        DataAcquisitionAction.jProgressBar    = new JProgressBar();

        DataAcquisitionAction.jProgressBar.setValue(0);
        DataAcquisitionAction.jProgressBar.setIndeterminate(true);
        DataAcquisitionAction.jPanel.setSize(500, 500);
        DataAcquisitionAction.jPanel.add(DataAcquisitionAction.jProgressBar);
        DataAcquisitionAction.jFrame.add(DataAcquisitionAction.jPanel);
        DataAcquisitionAction.jFrame.setSize(500, 500);
        DataAcquisitionAction.jFrame.setResizable(false);
        DataAcquisitionAction.jFrame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        DataAcquisitionAction.jFrame.setUndecorated(true);
    }

}
