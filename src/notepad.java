import javax.swing.*;
import javax.swing.event.UndoableEditEvent;
import javax.swing.event.UndoableEditListener;
import javax.swing.undo.UndoManager;

import java.awt.event.*;
public class notepad implements ActionListener{
    JFrame window;
    // Text Area
    JTextArea textArea;
    boolean wordWrapOn = false;
    JScrollPane scrollPane;
    // Menu Bar
    JMenuBar menuBar;
    JMenu menuFile , menuEdit, menuFormat, menuColor;
    // File Menu
    JMenuItem iNew, iOpen, iSave, iSaveAs, iExit;
    // Edit Menu
    JMenuItem iUndo, iRedo;
    // Format Menu
    JMenuItem iWrap ,iFontArial, iFontCSMS, iFontTNR, iFontSize8, iFontSize12, iFontSize16, iFontSize20, iFontSize24, iFontSize28;
    JMenu imenuFont, imenuFontSize;
    // Color Menu
    JMenuItem iColor1, iColor2, iColor3;

    Function_File file = new Function_File(this);
    Function_Format format = new Function_Format(this);
    Function_Color color = new Function_Color(this);
    Function_Edit edit = new Function_Edit(this);
    UndoManager um = new UndoManager();
 
    public notepad(){
        createWindow();
        createTextArea();
        createMenuBar();
        createFileMenu();
        createEditMenu();
        createColorMenu();
        createFormatMenu();
        format.selectedFont="Arial";
        format.createFont(16);
        format.wordWrap();
        window.setVisible(true);
    }
    public void createWindow(){
        window = new JFrame("Notepad");
        window.setSize(800,600);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
    }
    public void createTextArea(){
        textArea = new JTextArea();

        textArea.getDocument().addUndoableEditListener(
            new UndoableEditListener() {
                public void undoableEditHappened(UndoableEditEvent e){
                    um.addEdit(e.getEdit());
                }
            }
        );
        scrollPane = new JScrollPane(textArea, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setBorder(BorderFactory.createEmptyBorder(0, 0, 0, 0));
        window.add(scrollPane);
    }
    public void createMenuBar(){
        menuBar = new JMenuBar();
        window.setJMenuBar(menuBar);

        menuFile = new JMenu("File");
        menuBar.add(menuFile);

        menuEdit = new JMenu("Edit");
        menuBar.add(menuEdit);

        menuFormat = new JMenu("Format");
        menuBar.add(menuFormat);

        menuColor = new JMenu("Color");
        menuBar.add(menuColor);

    }
    public void createFileMenu(){
        iNew = new JMenuItem("New");
        iNew.addActionListener(this);
        iNew.setActionCommand("New");
        menuFile.add(iNew);
        
        iOpen = new JMenuItem("Open");
        iOpen.addActionListener(this);
        iOpen.setActionCommand("Open");
        menuFile.add(iOpen);

        iSave = new JMenuItem("Save");
        iSave.addActionListener(this);
        iSave.setActionCommand("save");
        menuFile.add(iSave);

        iSaveAs = new JMenuItem("SaveAs");
        iSaveAs.addActionListener(this);
        iSaveAs.setActionCommand("saveAs");
        menuFile.add(iSaveAs);

        iExit = new JMenuItem("Exit");
        iExit.addActionListener(this);
        iExit.setActionCommand("exit");
        menuFile.add(iExit);
    }
    public void createEditMenu(){
        iUndo = new JMenuItem("Undo");
        iUndo.addActionListener(this);
        iUndo.setActionCommand("Undo");
        menuEdit.add(iUndo);

        iRedo = new JMenuItem("Redo");
        iRedo.addActionListener(this);
        iRedo.setActionCommand("Redo");
        menuEdit.add(iRedo);
        
    }
    public void createFormatMenu(){
        iWrap = new JMenuItem("Word Wrap : Off");
        iWrap.addActionListener(this);
        iWrap.setActionCommand("Word Wrap");
        menuFormat.add(iWrap);

        imenuFont = new JMenu("Font");
        menuFormat.add(imenuFont);

        
        imenuFontSize = new JMenu("Font Size");
        menuFormat.add(imenuFontSize);

        iFontArial = new JMenuItem("Arial");
        iFontArial.addActionListener(this);
        iFontArial.setActionCommand("Arial");
        imenuFont.add(iFontArial);

        iFontCSMS = new JMenuItem("Comic Sans MS");
        iFontCSMS.addActionListener(this);
        iFontCSMS.setActionCommand("Comic Sans MS");
        imenuFont.add(iFontCSMS);

        iFontTNR = new JMenuItem("Times New Roman");
        iFontTNR.addActionListener(this);
        iFontTNR.setActionCommand("Times New Roman");
        imenuFont.add(iFontTNR);

        iFontSize8 = new JMenuItem("8");
        iFontSize8.addActionListener(this);
        iFontSize8.setActionCommand("size8");
        imenuFontSize.add(iFontSize8);

        iFontSize12 = new JMenuItem("12");
        iFontSize12.addActionListener(this);
        iFontSize12.setActionCommand("size12");
        imenuFontSize.add(iFontSize12);

        iFontSize16 = new JMenuItem("16");
        iFontSize16.addActionListener(this);
        iFontSize16.setActionCommand("size16");
        imenuFontSize.add(iFontSize16);

        iFontSize20 = new JMenuItem("20");
        iFontSize20.addActionListener(this);
        iFontSize20.setActionCommand("size20");
        imenuFontSize.add(iFontSize20);

        iFontSize24 = new JMenuItem("24");
        iFontSize24.addActionListener(this);
        iFontSize24.setActionCommand("size24");
        imenuFontSize.add(iFontSize24);

        iFontSize28 = new JMenuItem("28");
        iFontSize28.addActionListener(this);
        iFontSize28.setActionCommand("size28");
        imenuFontSize.add(iFontSize28);


    }
    public void createColorMenu(){
        iColor1 = new JMenuItem("White");
        iColor1.addActionListener(this);
        iColor1.setActionCommand("White");
        menuColor.add(iColor1);

        iColor2 = new JMenuItem("Black");
        iColor2.addActionListener(this);
        iColor2.setActionCommand("Black");
        menuColor.add(iColor2);

        iColor3 = new JMenuItem("Blue");
        iColor3.addActionListener(this);
        iColor3.setActionCommand("Blue");
        menuColor.add(iColor3);
    }

    public void actionPerformed(ActionEvent e){
        String command = e.getActionCommand();

        switch (command) {
            case "New":
                file.newFile();
                break;
            case "Open":
                file.open();
                break;
            case "saveAs":
                file.saveAs();
                break;
            case "save":
                file.save();
                break;
            case "exit":
                file.exit();
                break;
            case "Undo":
                edit.undo();
                break;
            case "Redo":
                edit.redo();
                break;
            case "Word Wrap":
                format.wordWrap();
                break;
            case "size8":
                format.createFont(8);
                break;
            case "size12":
                format.createFont(12);
                break;
            case "size16":
                format.createFont(16);
                break;
            case "size20":
                format.createFont(20);
                break;
            case "size24":
                format.createFont(24);
                break;
            case "size28":
                format.createFont(28);
                break;
            case "Arial":
                format.setFont(command);
                break;
            case "Comic Sans MS":
                format.setFont(command);
                break;
            case "Times New Roman":
                format.setFont(command);
                break;
            case "White":
                color.changeColor(command);
                break;
            case "Black":
                color.changeColor(command);
                break;
            case "Blue":
                color.changeColor(command);
                break;
        }
    }
    public static void main(String[] args) {
        new notepad();

    }
}