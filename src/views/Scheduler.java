/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package views;

import controllers.Events;
import controllers.Instructors;
import java.time.LocalDate;
import java.util.List;
import javax.swing.JOptionPane;
import models.Instructor;
import models.Event;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author andre
 */
public class Scheduler extends javax.swing.JFrame {

    /**
     * Creates new form Scheduler
     */
    Instructors instructors = new Instructors();
    List<Instructor> allInstructors;
    Events events;
    Instructor instructor;
    List<Event> allEventsInstructor;
    int inst = 0;
    int rowSelected = -1;
    int currentMonth;
    String[] months = {"January", "February", "March", "April", "May", "June", "July", "August", "September", "October", "November", "December"};
    
    
    DefaultTableModel model;
    
    public Scheduler() {
        initComponents();
        this.currentMonth = LocalDate.now().getMonthValue();
        jLabelSelectedMonth.setText(months[currentMonth - 1] + " / 2021");
        events = new Events();
        allInstructors = instructors.findAllInstructors();
         
         for (Instructor i: allInstructors ) {
             comboInstructores.addItem(i.getName());
        }
    }
    
    public void updateTable() {
        rowSelected = -1;
        //update total days
        jLabelTotalDays.setText("Total days for selected instructor: " + events.totalDaysPerInstructor(instructor.getId()));
        
        //set events
        allEventsInstructor = events.EventsPerInstructor(instructor.getId(), this.currentMonth);
        
        String[] colName = new String[] {
           "Start Date", "End Date", "Type", "Description"
        };
        Object[][] value = new Object[allEventsInstructor.size()][4];
       
        for (int i=0; i<allEventsInstructor.size(); i++ ) {
            //System.out.println(e.toString());
            Event current = allEventsInstructor.get(i);
            value[i][0] = current.getStart().toString();
            value[i][1] = current.getEnd().toString();
            value[i][2] = current.getType();
            value[i][3] = current.getDescription();
        }

       jTable1.setModel(new DefaultTableModel(value,colName));
       jButton1.setEnabled(false);
       jButton2.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    @SuppressWarnings("serial")
	private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTable1 = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        jButtonPrevMonth = new javax.swing.JButton();
        jButtonNextMonth = new javax.swing.JButton();
        jLabelSelectedMonth = new javax.swing.JLabel();
        comboInstructores = new javax.swing.JComboBox<>();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabelTotalDays = new javax.swing.JLabel();
        buttonNewEvent = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jTable1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Start date", "End date", "Type", "Description"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        jTable1.setToolTipText("");
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                jTable1PropertyChange(evt);
            }
        });
        jScrollPane1.setViewportView(jTable1);

        jButton1.setText("Delete Selected Event");
        jButton1.setEnabled(false);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Update Selected Event");
        jButton2.setEnabled(false);
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel4.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel4.setText("Appointments scheduled for the selected month");

        jButtonPrevMonth.setText("<");
        jButtonPrevMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonPrevMonthActionPerformed(evt);
            }
        });

        jButtonNextMonth.setText(">");
        jButtonNextMonth.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonNextMonthActionPerformed(evt);
            }
        });

        jLabelSelectedMonth.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabelSelectedMonth.setText("December / 2021");
        jLabelSelectedMonth.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(87, 87, 87)
                .addComponent(jButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(72, 72, 72))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jLabel4)
                        .addGap(24, 24, 24)
                        .addComponent(jButtonPrevMonth)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jLabelSelectedMonth, javax.swing.GroupLayout.DEFAULT_SIZE, 96, Short.MAX_VALUE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButtonNextMonth))
                    .addComponent(jScrollPane1)
                    .addComponent(jSeparator1))
                .addContainerGap(40, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jButtonPrevMonth)
                    .addComponent(jButtonNextMonth)
                    .addComponent(jLabelSelectedMonth))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2)
                    .addComponent(jButton1))
                .addContainerGap(33, Short.MAX_VALUE))
        );

        comboInstructores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                comboInstructoresActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel1.setText("Birthday:");

        jLabel2.setText("jLabel2");

        jLabel3.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jLabel3.setText("Select Instructor:");

        jLabelTotalDays.setText("jLabel3");

        buttonNewEvent.setText("New Event");
        buttonNewEvent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                buttonNewEventActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabelTotalDays, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(comboInstructores, javax.swing.GroupLayout.PREFERRED_SIZE, 137, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel3)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel1)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 33, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(buttonNewEvent)))
                .addGap(37, 37, 37)
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(52, 52, 52)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(comboInstructores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(29, 29, 29)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jLabel2))
                .addGap(61, 61, 61)
                .addComponent(jLabelTotalDays)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(buttonNewEvent)
                .addGap(32, 32, 32))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void comboInstructoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_comboInstructoresActionPerformed
        inst = comboInstructores.getSelectedIndex();
        
        instructor = allInstructors.get(inst);
        jLabel2.setText(instructor.getBirthday().toString());     
        updateTable();
    }//GEN-LAST:event_comboInstructoresActionPerformed

    private void buttonNewEventActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_buttonNewEventActionPerformed
        EventAddWindow newEvent = new EventAddWindow(inst+1, this);
        newEvent.setVisible(true);
    }//GEN-LAST:event_buttonNewEventActionPerformed

    private void jTable1PropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_jTable1PropertyChange

    }//GEN-LAST:event_jTable1PropertyChange

    private void jTable1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jTable1MouseClicked
        //System.out.println(jTable1.getSelectedRow());
        rowSelected = jTable1.getSelectedRow();
        jButton1.setEnabled(true);
        jButton2.setEnabled(true);
    }//GEN-LAST:event_jTable1MouseClicked

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if(rowSelected < 0) {
            JOptionPane.showMessageDialog(this, "Please select event to delete");
        }
        else {
            Event eventSelected = allEventsInstructor.get(rowSelected);
            //System.out.println(eventSelected.toString());
            events.deleteEvent(eventSelected.getId());
            this.updateTable();
        }   
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if(rowSelected < 0) {
            JOptionPane.showMessageDialog(this, "Please select event to update");
        }
        else {
            //get event
            Event eventSelected = allEventsInstructor.get(rowSelected);
            //show window
            EventAddWindow newEvent = new EventAddWindow(inst+1, eventSelected, this);
            newEvent.setVisible(true);
        }  
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButtonPrevMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPrevMonthActionPerformed
        this.currentMonth--;
        if(this.currentMonth < 1)
            this.currentMonth = 12;
        
        jLabelSelectedMonth.setText(months[currentMonth - 1] + " / 2021");
        this.updateTable();
    }//GEN-LAST:event_jButtonPrevMonthActionPerformed

    private void jButtonNextMonthActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonNextMonthActionPerformed
        this.currentMonth++;
        if(this.currentMonth > 12)
            this.currentMonth = 1;
        
        jLabelSelectedMonth.setText(months[currentMonth - 1] + " / 2021");
        this.updateTable();
    }//GEN-LAST:event_jButtonNextMonthActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Scheduler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Scheduler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Scheduler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Scheduler.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Scheduler().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton buttonNewEvent;
    private javax.swing.JComboBox<String> comboInstructores;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButtonNextMonth;
    private javax.swing.JButton jButtonPrevMonth;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabelSelectedMonth;
    private javax.swing.JLabel jLabelTotalDays;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JTable jTable1;
    // End of variables declaration//GEN-END:variables
}
