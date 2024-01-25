package quiz.application;


import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;


public class Quiz extends javax.swing.JFrame {

        String questions[][]=new String[10][5];
        String answers[][]=new String[10][2];
        String userans[][]=new String[10][1];
        ButtonGroup buttonGroup;
        
        public static int timer = 15;
        public static int ans = 0;
        public static int count =0;
        public static int score=0;
        public static String name;


    public Quiz(String user) {
        initComponents();
        Quiz.name=user;
        ImageIcon imageicon=new ImageIcon(new ImageIcon("C:/Users/tyagi/OneDrive/Documents/NetBeansProjects/Quiz Application/src/images/quiz.jpg").getImage().getScaledInstance(background.getWidth(), background.getHeight(), Image.SCALE_DEFAULT));
        background.setIcon(imageicon);
        button3.setEnabled(false);
        
    
        questions[0][0] = "Which one of the following river flows between Vindhyan and Satpura ranges?";
        questions[0][1] = "Mahanadi";
        questions[0][2] = "Narmada";
        questions[0][3] = "Son";
        questions[0][4] = "Netravati";

        questions[1][0] = "The metal whose salts are sensitive to light is?";  
        questions[1][1] = "Zinc";
        questions[1][2] = "Silver";
        questions[1][3] = "Copper";
        questions[1][4] = "Aluminum";

        questions[2][0] = "Patanjali is well known for the compilation of –"; 
        questions[2][1] = "Yoga Sutra";
        questions[2][2] = "Panchatantra";
        questions[2][3] = "Brahma Sutra";
        questions[2][4] = "Ayurveda";

        questions[3][0] = "Tsunamis are not caused by";
        questions[3][1] = "Undersea landslides";
        questions[3][2] = "Earthquakes";
        questions[3][3] = "Hurricanes";
        questions[3][4] = "Volcanic eruptions";

        questions[4][0] = "The hottest planet in the solar system?\n";
        questions[4][1] = "Mercury";
        questions[4][2] = "Jupiter";
        questions[4][3] = "Mars";
        questions[4][4] = "Venus";

        questions[5][0] = "Where was the electricity supply first introduced in India –\n";
        questions[5][1] = "Mumbai";
        questions[5][2] = "Dehradun";
        questions[5][3] = "Darjeeling";
        questions[5][4] = "Chennai";

        questions[6][0] = "Which one of the following ports is the oldest port in India?\n";
        questions[6][1] = "Chennai Port";
        questions[6][2] = "Mumbai Port";
        questions[6][3] = "Kolkata Port";
        questions[6][4] = "Vishakhapatnam Port";

        questions[7][0] = "FFC stands for\n";
        questions[7][1] = "Federation of Football Council";
        questions[7][2] = "Film Finance Corporation";
        questions[7][3] = "Foreign Finance Corporation";
        questions[7][4] = "None of the above";

        questions[8][0] = "With which of the following countries, India shares maximum length of border?\n";
        questions[8][1] = "Myanmar";
        questions[8][2] = "China";
        questions[8][3] = "Nepal";
        questions[8][4] = "Bangladesh";

        questions[9][0] = "In which of the following Himalayas, the highest mountain peaks of Himalayas are found?\n";
        questions[9][1] = "Central Himalayas";
        questions[9][2] = "Western Himalayas";
        questions[9][3] = "Eastern Himalayas";
        questions[9][4] = "Trans Himalayan region";
	
        
        answers[0][1] = "Narmada";
        answers[1][1] = "Silver";
        answers[2][1] = "Yoga Sutra";
        answers[3][1] = "Hurricanes";
        answers[4][1] = "Venus";
        answers[5][1] = "Darjeeling";
        answers[6][1] = "Chennai Port";
        answers[7][1] = "Film Finance Corporation";
        answers[8][1] = "Bangladesh";
        answers[9][1] = "Central Himalayas";
        buttonGroup=new ButtonGroup();
        buttonGroup.add(btn1);
        buttonGroup.add(btn2);
        buttonGroup.add(btn3);
        buttonGroup.add(btn4);
        
        start(count);
    }
        @Override
    public void paint(Graphics g){
        super.paint(g);
        
        
        if(timer>0){
            time.setText("TIME LEFT "+ timer +" SECONDS");
        }
        else{
            time.setText("TIME UP !!!");
        }
        
        timer--;
        try{
            Thread.sleep(1000);
            repaint();
            }
            catch(Exception e){
                JOptionPane.showMessageDialog(this, e);
            }
        
        
            if(ans==1){
            ans=0;
            timer=15;
            }
            else if(timer<0){
                timer=15;
                btn1.setEnabled(true);
                btn2.setEnabled(true);
                btn3.setEnabled(true);
                btn4.setEnabled(true);
                
                if(count==8){
                button1.setEnabled(false);
                button3.setEnabled(true);
                }
                if(count==9){   //submit button
                    if(buttonGroup.getSelection()==null){
                        userans[count][0]="";
                    }else{
                        userans[count][0]=buttonGroup.getSelection().getActionCommand();
                    }
                    
                    for(int i=0;i<userans.length;i++){
                        if(userans[i][0].equals(answers[i][1])){
                            score= score+10;
                        }else{
                            score=score+0;
                        }
                    }
                    this.setVisible(false);
                    Scoreclass scoreclass=new Scoreclass(score,name);
                    scoreclass.setVisible(true);
                    
                }
                else{           //next button
                    if(buttonGroup.getSelection()==null){
                        userans[count][0]="";
                    }else{
                        userans[count][0]=buttonGroup.getSelection().getActionCommand();
                    }
                    count++;
                    start(count);
                }
            }
    }
    
    public void start(int count){
        qno.setText("" + (count +1) + ".");
        ques.setText(questions[count][0]);
    
        btn1.setText(questions[count][1]);
        btn1.setActionCommand(questions[count][1]);
        
        btn2.setText(questions[count][2]);
        btn2.setActionCommand(questions[count][2]);
        
        btn3.setText(questions[count][3]);
        btn3.setActionCommand(questions[count][3]);
        
        btn4.setText(questions[count][4]);
        btn4.setActionCommand(questions[count][4]);
        
        buttonGroup.clearSelection();
    }
    

    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        qno = new javax.swing.JLabel();
        btn1 = new javax.swing.JRadioButton();
        btn2 = new javax.swing.JRadioButton();
        btn3 = new javax.swing.JRadioButton();
        btn4 = new javax.swing.JRadioButton();
        button1 = new javax.swing.JButton();
        button2 = new javax.swing.JButton();
        button4 = new javax.swing.JButton();
        ques = new javax.swing.JLabel();
        time = new javax.swing.JLabel();
        button3 = new javax.swing.JButton();
        background = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setUndecorated(true);

        qno.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        button1.setBackground(new java.awt.Color(0, 153, 153));
        button1.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        button1.setForeground(new java.awt.Color(255, 255, 255));
        button1.setText("NEXT");
        button1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button1ActionPerformed(evt);
            }
        });

        button2.setBackground(new java.awt.Color(0, 102, 102));
        button2.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        button2.setForeground(new java.awt.Color(255, 255, 255));
        button2.setText("50-50 LIFELINE");
        button2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                button2MouseClicked(evt);
            }
        });
        button2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button2ActionPerformed(evt);
            }
        });

        button4.setBackground(new java.awt.Color(51, 51, 51));
        button4.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        button4.setForeground(new java.awt.Color(255, 255, 255));
        button4.setText("QUIT");
        button4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button4ActionPerformed(evt);
            }
        });

        ques.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N

        time.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        time.setForeground(new java.awt.Color(255, 0, 51));

        button3.setBackground(new java.awt.Color(0, 153, 153));
        button3.setFont(new java.awt.Font("Segoe UI", 1, 14)); // NOI18N
        button3.setForeground(new java.awt.Color(255, 255, 255));
        button3.setText("SUBMIT");
        button3.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        button3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                button3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(button4))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(qno, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(ques, javax.swing.GroupLayout.PREFERRED_SIZE, 558, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(time, javax.swing.GroupLayout.DEFAULT_SIZE, 196, Short.MAX_VALUE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(button1, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btn2, javax.swing.GroupLayout.DEFAULT_SIZE, 208, Short.MAX_VALUE)
                                    .addComponent(btn1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(8, 8, 8)
                                        .addComponent(button2)
                                        .addGap(38, 38, 38)
                                        .addComponent(button3, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(109, 109, 109)
                                        .addComponent(btn4, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                        .addGap(109, 109, 109)
                                        .addComponent(btn3, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addGap(35, 35, 35))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(17, 17, 17)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(time, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE)
                    .addComponent(qno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(ques, javax.swing.GroupLayout.DEFAULT_SIZE, 27, Short.MAX_VALUE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn1)
                    .addComponent(btn3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn2)
                    .addComponent(btn4))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(button1)
                    .addComponent(button2)
                    .addComponent(button3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(button4)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(background, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(background, javax.swing.GroupLayout.PREFERRED_SIZE, 229, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void button4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button4ActionPerformed
        System.exit(0);
    }//GEN-LAST:event_button4ActionPerformed

    private void button3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button3ActionPerformed

          ans = 1;
          if(count==9){   //submit button
                    if(buttonGroup.getSelection()==null){
                        userans[count][0]="";
                    }else{
                        userans[count][0]=buttonGroup.getSelection().getActionCommand();
                    }
                    
                    for(int i=0;i<userans.length;i++){
                        if(userans[i][0].equals(answers[i][1])){
                            score= score+10;
                        }else{
                            score=score+0;
                        }
                    }
                    Scoreclass scoreclass=new Scoreclass(score,name);
                    this.setVisible(false);
                    scoreclass.setVisible(true);
                }
    }//GEN-LAST:event_button3ActionPerformed

    private void button1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button1ActionPerformed
        repaint();
                btn1.setEnabled(true);
                btn2.setEnabled(true);
                btn3.setEnabled(true);
                btn4.setEnabled(true);
        
        ans = 1;
        
        if(buttonGroup.getSelection()==null){
                userans[count][0]="";
        }
        else{
                userans[count][0]=buttonGroup.getSelection().getActionCommand();
        }
        
        if(count==8){
            button1.setEnabled(false);
            button3.setEnabled(true);
        }
            count++;
            start(count);
            
    }//GEN-LAST:event_button1ActionPerformed

    private void button2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_button2ActionPerformed
        if(count==2 || count==4 || count==6 || count==8 || count==9){
            btn2.setEnabled(false);
            btn3.setEnabled(false);
        }
        else{
            btn1.setEnabled(false);
            btn4.setEnabled(false);
        }
        button2.setEnabled(false);
    }//GEN-LAST:event_button2ActionPerformed

    private void button2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_button2MouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_button2MouseClicked


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel background;
    private javax.swing.JRadioButton btn1;
    private javax.swing.JRadioButton btn2;
    private javax.swing.JRadioButton btn3;
    private javax.swing.JRadioButton btn4;
    private javax.swing.JButton button1;
    private javax.swing.JButton button2;
    private javax.swing.JButton button3;
    private javax.swing.JButton button4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel qno;
    private javax.swing.JLabel ques;
    private javax.swing.JLabel time;
    // End of variables declaration//GEN-END:variables
}
