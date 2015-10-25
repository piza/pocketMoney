package com.piza.generator.view;

import com.piza.model.WeixinAccount;
import org.apache.commons.beanutils.BeanUtils;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class FormTemplateView extends JDialog {
    private JPanel contentPane;
    private JButton generateButton;
    private JButton cancelButton;
    private JTextArea resultArea;
    private JPanel attrListPanel;
    private JButton copyCloseButton;
    private JLabel objectNameLbl;
    private List<AttributePanel> attributePanelList;

    public FormTemplateView() {
        setContentPane(contentPane);
        setModal(true);
        getRootPane().setDefaultButton(generateButton);

        generateButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onGenerate();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        });

// call onCancel() when cross is clicked
        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                onCancel();
            }
        });

// call onCancel() on ESCAPE
        contentPane.registerKeyboardAction(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                onCancel();
            }
        }, KeyStroke.getKeyStroke(KeyEvent.VK_ESCAPE, 0), JComponent.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT);

        copyCloseButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onCopyAndClose();
            }
        });

    }


    private void onGenerate(){
        for(AttributePanel attributePanel:attributePanelList){
            System.out.println(attributePanel.getAttrName()+":"+attributePanel.getTypeText());
        }
    }
    private void onCopyAndClose(){

    }
    private void onCancel() {
// add your code here if necessary
        dispose();
    }

    public void renderObject(Object obj){
        try {
            this.objectNameLbl.setText(obj.getClass().getSimpleName());
            Map proList=BeanUtils.describe(obj);
            GridLayout layout=new GridLayout(0,1);
            this.attrListPanel.setLayout(layout);
            for(Object key:proList.keySet()){
//                System.out.println("key:"+key);
//                System.out.println("val:"+proList.get(key));
                if(!key.equals("class")){
                  AttributePanel attributePanel=new AttributePanel();
                    this.attrListPanel.add(attributePanel.getPanel());
                    attributePanel.setAttrName(key.toString());
                    attributePanelList.add(attributePanel);
                    pack();
                    repaint();
                }
            }
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {

        FormTemplateView dialog = new FormTemplateView();
        dialog.renderObject(new WeixinAccount());

        dialog.pack();
        dialog.setVisible(true);
        System.exit(0);
    }

    private void createUIComponents() {
        this.attrListPanel=new JPanel();
        this.objectNameLbl=new JLabel();
        attributePanelList=new ArrayList<AttributePanel>();
    }
}
