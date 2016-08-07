/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.neural.net.gui;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.util.List;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.SwingWorker;
import javax.swing.filechooser.FileFilter;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;

import com.neural.net.NeuralNetController;
import com.neural.net.model.DataPoint;

/**
 *
 * @author Standard
 */
public class NeuralInterface extends javax.swing.JFrame {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 4739427075023079422L;
	private static NeuralNetController controller;
	private NeuralInterface ui = this;
	
	FileFilter filter = new FileNameExtensionFilter("CSV", "csv");
    /**
     * Creates new form NeuralInterface
     */
    public NeuralInterface() {
    	controller = new NeuralNetController();
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblStatusHead = new javax.swing.JLabel();
        lblStatusData = new javax.swing.JLabel();
        btnTrain = new javax.swing.JButton();
        btnProcess = new javax.swing.JButton();
        lblTitle = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        outputTable = new javax.swing.JTable();
        trainingStatusBar = new javax.swing.JProgressBar();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        lblStatusHead.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblStatusHead.setText("Status:");
        lblStatusHead.setName("jLblStatusHead"); // NOI18N

        lblStatusData.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblStatusData.setText("Ready to Train");
        lblStatusData.setName("jLblStatus"); // NOI18N

        btnTrain.setText("Train");
        btnTrain.setName("jBtnTrain"); // NOI18N
        btnTrain.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnTrainMouseClicked(evt);
            }
        });

        btnProcess.setText("Process");
        btnProcess.setEnabled(false);
        btnProcess.setName("jBtnProcess"); // NOI18N
        btnProcess.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnProcessMouseClicked(evt);
            }
        });

        lblTitle.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        lblTitle.setText("Neural Network Java Implementation 1.0");

        outputTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
            },
            new String [] {
                "Name", "Expected Result", "Network Output"
            }
        ));
        jScrollPane1.setViewportView(outputTable);

        trainingStatusBar.setVisible(false);

        jLabel1.setText("Network Output");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(96, 96, 96)
                .addComponent(lblTitle)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblStatusHead)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblStatusData)
                                .addGap(18, 18, 18)
                                .addComponent(trainingStatusBar, javax.swing.GroupLayout.PREFERRED_SIZE, 380, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 553, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnTrain)
                                .addGap(34, 34, 34)
                                .addComponent(btnProcess))))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel1)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(7, 7, 7)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 22, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(lblStatusHead)
                            .addComponent(lblStatusData)))
                    .addComponent(trainingStatusBar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnTrain)
                    .addComponent(btnProcess))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 413, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnTrainMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnTrainMouseClicked
// TODO add your handling code here:
        
        SwingWorker<String, Object> worker = new SwingWorker<String, Object>() {
            @Override
            protected String doInBackground() throws Exception {   
            	 boolean success = true;
            	 JFileChooser trainFile = new JFileChooser();
                 trainFile.setDialogTitle("Choose a training file.");
                 trainFile.setFileFilter(filter);
                 
                 int returnVal = trainFile.showOpenDialog(NeuralInterface.this);
                 
                 if (returnVal == JFileChooser.APPROVE_OPTION)
                 {
                     
                     File file = trainFile.getSelectedFile();

                     try
                     {
                    	 lblStatusData.setText("Training...");
                    	 trainingStatusBar.setVisible(true);
                    	 runTrainingFile(file);
                     }
                     catch(Exception ex)
                     {
                        JOptionPane.showMessageDialog(null, "Not a valid training file.");
                        success = false;
                     }
                     
                     trainingStatusBar.setVisible(false);
                     if (success){
                    	 lblStatusData.setText("Ready to Process");
                    	 btnProcess.setEnabled(true);
                     } else {
                    	 //if training fails but the NN was already trained (as evidenced by the process button's
                    	 //enabled status, status message should say ready to process
                    	 if(btnProcess.isEnabled())               		 
                    		 lblStatusData.setText("Ready to Process");
                    	 else
                    		 lblStatusData.setText("Ready to Train");
                     }
                    
                     
                     
                 } else {
                     lblStatusData.setText("Ready to Train");
                 }
                 return "";
            }
            @Override
            protected void done() {
                try {
                    
                } catch (Exception e) {
                    //ignore
                }
            }
        };      
        worker.execute();
       
            
        
        
    }//GEN-LAST:event_btnTrainMouseClicked
    
    public void runTrainingFile(File file) throws Exception{
    	controller.initializeTraining(file, ui);
    }

    private void btnProcessMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnProcessMouseClicked
        if (btnProcess.isEnabled()){
        JFileChooser dataFile = new JFileChooser();
        dataFile.setDialogTitle("Choose a data file to process.");
        dataFile.setFileFilter(filter);
        
        int returnVal = dataFile.showOpenDialog(NeuralInterface.this);   
        
        if (returnVal == JFileChooser.APPROVE_OPTION) {
        	
        	JFileChooser outputFile = new JFileChooser();
            outputFile.setDialogTitle("Choose the name of the output file.");
            
            int outputReturn = outputFile.showSaveDialog(NeuralInterface.this);
            
            if (outputReturn == JFileChooser.APPROVE_OPTION){
          
            	File output = outputFile.getSelectedFile();
	        	File inputFile = dataFile.getSelectedFile();
	        	
	        	// if file doesnt exists, then create it
				
				
	        	 lblStatusData.setText("Processing.");
	             
	             try //to process
	             {
	            	runInputData(inputFile, output);
	             }
	             catch(Exception ex)
	             {
	                 JOptionPane.showMessageDialog(null, "Not a valid data file.");
	                 //when done, pass or fail, reset label
	                 lblStatusData.setText("Ready To Process.");
	             }
            }  
        }
      
        //if it parses, start processing
        
       
        //successful process.
        lblStatusData.setText("Ready To Process.");
        }  
    }//GEN-LAST:event_btnProcessMouseClicked
    
    public void runInputData(File inputFile, File output) throws Exception{
    	List<DataPoint> outputDataPoints = controller.processInput(inputFile);
		 
		DefaultTableModel model = ((DefaultTableModel)outputTable.getModel());
		 
		if (!output.exists()) {
				output.createNewFile();
			}

		FileWriter fw = new FileWriter(output.getAbsoluteFile());
		BufferedWriter bw = new BufferedWriter(fw);
		
		bw.write("Name, Expected Result, Network Result");
		bw.newLine();
		
		int rowCount = model.getRowCount();
		    //Remove rows one by one from the end of the table
		for (int i = rowCount - 1; i >= 0; i--) {
		    model.removeRow(i);
		}
		for (DataPoint point : outputDataPoints){
		    model.addRow(new Object[]{point.getName(),point.getStatus(), point.getResult()});
		    bw.write(point.getName() + ", " + point.getStatus() + ", " + point.getResult());
		    bw.newLine();
		}
		bw.close();
    }
    
    public void updateStatusBar(int value){
    	trainingStatusBar.setValue(value);
    }
    
    public void showStatusBar(boolean value){
    	trainingStatusBar.setVisible(value);
    }
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
            java.util.logging.Logger.getLogger(NeuralInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NeuralInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NeuralInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NeuralInterface.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NeuralInterface().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnProcess;
    private javax.swing.JButton btnTrain;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblStatusData;
    private javax.swing.JLabel lblStatusHead;
    private javax.swing.JLabel lblTitle;
    private javax.swing.JTable outputTable;
    private javax.swing.JProgressBar trainingStatusBar;
    // End of variables declaration//GEN-END:variables
}
