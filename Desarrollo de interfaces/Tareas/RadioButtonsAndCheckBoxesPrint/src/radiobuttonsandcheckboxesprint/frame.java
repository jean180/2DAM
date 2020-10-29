/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package radiobuttonsandcheckboxesprint;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.TitledBorder;

/**
 *
 * @author jeaagu
 */
public class frame extends JFrame {

    private JRadioButton Micros1, Micros2, Micros3, Micros4, RAM1, RAM2, RAM3, RAM4, Monitor1, Monitor2, Monitor3, Monitor4;
    private ButtonGroup groupMicros, groupRAM, groupMonitor, groupMisc;
    private JCheckBox Misc1, Misc2, Misc3, Misc4;
    private JPanel panel = new JPanel();
    private JPanel panel2 = new JPanel();
    private JButton print = new JButton("Print");
    private JPanel panelMicros, panelRAM, panelMonitors, panelMisc, panelUnion;

    public frame() {
        setTitle("Choose a computer");
        setSize(700, 500);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        panel.setLayout(new BorderLayout());

        //Panel Micros
        panel2.setLayout(new GridLayout(1, 4));
        panelMicros = new JPanel();
        panelMicros.setLayout(new GridLayout(4, 1));

        TitledBorder titleMicros = BorderFactory.createTitledBorder("Micros");
        panelMicros.setBorder(titleMicros);
        Micros1 = new JRadioButton("Intel 1", false);
        Micros2 = new JRadioButton("Intel 2", false);
        Micros3 = new JRadioButton("AMD 1", false);
        Micros4 = new JRadioButton("AMD 2", false);
        groupMicros = new ButtonGroup();
        groupMicros.add(Micros1);
        groupMicros.add(Micros2);
        groupMicros.add(Micros3);
        groupMicros.add(Micros4);
        panelMicros.add(Micros1);
        panelMicros.add(Micros2);
        panelMicros.add(Micros3);
        panelMicros.add(Micros4);

        panel2.add(panelMicros);

        //Panel RAM
        panelRAM = new JPanel();
        panelRAM.setLayout(new GridLayout(4, 1));
        TitledBorder titleRAM = BorderFactory.createTitledBorder("RAM");
        panelRAM.setBorder(titleRAM);
        RAM1 = new JRadioButton("RAM 1 GB", false);
        RAM2 = new JRadioButton("RAM 2 GB", false);
        RAM3 = new JRadioButton("RAM 3 GB", false);
        RAM4 = new JRadioButton("RAM 4 GB", false);
        groupRAM = new ButtonGroup();
        groupRAM.add(RAM1);
        groupRAM.add(RAM2);
        groupRAM.add(RAM3);
        groupRAM.add(RAM4);
        panelRAM.add(RAM1);
        panelRAM.add(RAM2);
        panelRAM.add(RAM3);
        panelRAM.add(RAM4);
        panel2.add(panelRAM);

        //Panel Monitors
        panelMonitors = new JPanel();
        panelMonitors.setLayout(new GridLayout(4, 1));
        TitledBorder titleMonitors = BorderFactory.createTitledBorder("Monitors");
        panelMonitors.setBorder(titleMonitors);
        Monitor1 = new JRadioButton("LG1", false);
        Monitor2 = new JRadioButton("LG2", false);
        Monitor3 = new JRadioButton("HP1", false);
        Monitor4 = new JRadioButton("HP2", false);
        groupMonitor = new ButtonGroup();
        groupMonitor.add(Monitor1);
        groupMonitor.add(Monitor2);
        groupMonitor.add(Monitor3);
        groupMonitor.add(Monitor4);
        panelMonitors.add(Monitor1);
        panelMonitors.add(Monitor2);
        panelMonitors.add(Monitor3);
        panelMonitors.add(Monitor4);
        panel2.add(panelMonitors);

        //Panel Miscellanea
        panelMisc = new JPanel();
        panelMisc.setLayout(new GridLayout(4, 1));
        TitledBorder titleMisc = BorderFactory.createTitledBorder("Miscellanea");
        panelMisc.setBorder(titleMisc);
        Misc1 = new JCheckBox("Mouse normal");
        Misc2 = new JCheckBox("Mouse pro");
        Misc3 = new JCheckBox("Keyboard normal");
        Misc4 = new JCheckBox("Keyboard pro");
        panelMisc.add(Misc1);
        panelMisc.add(Misc2);
        panelMisc.add(Misc3);
        panelMisc.add(Misc4);
        panel2.add(panelMisc);
        panel.add(panel2);
        panel.add(print, BorderLayout.SOUTH);
        add(panel);
    }

}
