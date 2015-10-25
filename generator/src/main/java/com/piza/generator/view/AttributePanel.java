package com.piza.generator.view;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

/**
 * Created by Peter on 15/10/25.
 */
public class AttributePanel {
    private JRadioButton textRadioButton;
    private JRadioButton selectRadioButton;
    private JRadioButton radioRadioButton;
    private JRadioButton passwordRadioButton;
    private JRadioButton hiddenRadioButton;
    private JRadioButton checkboxRadioButton;
    private JRadioButton textAreaRadioButton;
    private JLabel nameLabel;
    private JPanel panel;
    private JRadioButton noneRadioButton;
    private ButtonGroup buttonGroup;

    private String attrName;
    private String typeText="text";
    public AttributePanel(){
        ChangeListener listener = new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent e) {
                JRadioButton currentBtn=((JRadioButton)e.getSource());
                if(currentBtn.isSelected()){
                    typeText=currentBtn.getText();
                }
            }
        };
        textRadioButton.addChangeListener(listener);
        selectRadioButton.addChangeListener(listener);
        checkboxRadioButton.addChangeListener(listener);
        textAreaRadioButton.addChangeListener(listener);
        radioRadioButton.addChangeListener(listener);
        passwordRadioButton.addChangeListener(listener);
        hiddenRadioButton.addChangeListener(listener);
        noneRadioButton.addChangeListener(listener);
    }

    public String getTypeText() {
        return typeText;
    }

    public void setTypeText(String typeText) {
        this.typeText = typeText;
    }

    public String getAttrName() {
        return attrName;
    }

    public void setAttrName(String attrName) {
        this.attrName = attrName;
        this.nameLabel.setText(attrName);
    }

    public void setData(AttrData data) {
    }

    public void getData(AttrData data) {
    }

    public boolean isModified(AttrData data) {
        return false;
    }

    public JPanel getPanel() {
        return panel;
    }

    public void setPanel(JPanel panel) {
        this.panel = panel;
    }


    private void createUIComponents() {
        buttonGroup=new ButtonGroup();
        buttonGroup.add(this.checkboxRadioButton);
        buttonGroup.add(this.hiddenRadioButton);
        buttonGroup.add(this.passwordRadioButton);
        buttonGroup.add(this.radioRadioButton);
        buttonGroup.add(this.selectRadioButton);
        buttonGroup.add(this.textAreaRadioButton);
        buttonGroup.add(this.textRadioButton);
        buttonGroup.add(noneRadioButton);
        this.nameLabel=new JLabel(this.attrName);
    }
}
