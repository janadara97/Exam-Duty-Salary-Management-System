
import java.awt.Color;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import javax.swing.JOptionPane;
import net.proteanit.sql.DbUtils;



/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jana
 */
public class panel_center extends javax.swing.JFrame {
 
    Connection conn=null;
    ResultSet rs =null; 
    PreparedStatement pst=null;
    
   
        
    
    public panel_center() 
    {
        initComponents();
        setVisible(true);
        setLocationRelativeTo(null);
        conn=db.java_db();
        this.setLocationRelativeTo(null);
        setSize(1500,1020);
        setLocation(170,10);
        this.setResizable(false);
        fillcombo();
      
        
    }
    
    
   private void fillcombo(){

        try {
            String abc="select * from Employee";
            pst=conn.prepareStatement(abc);
            rs=pst.executeQuery();
            while(rs.next()){
            String name=rs.getString("Employee_Id");
            AfterSalary.addItem(name);
            
            
            }
        } catch (Exception e) {
            
            JOptionPane.showMessageDialog(null, e);
        }
        
   }
   
   public void setColor(){
   exitPanel.setBackground(new Color(246,106,76));
   }
   
   public void releaseColor(){
   exitPanel.setBackground(new Color(51,51,55));
   }
   
   private void Update_Table(){
    try{
    String sql="select * from FinalReport";
    pst=conn.prepareStatement(sql);
    rs=pst.executeQuery(); 
    FinalResult.setModel(DbUtils.resultSetToTableModel(rs));
    }
    catch(Exception e){
    JOptionPane.showMessageDialog(null, e);}
    }
   
   
    private void Update_Table1(){
    try{
    String sql="select * from BeforeExam";
    pst=conn.prepareStatement(sql);
    rs=pst.executeQuery(); 
    ViewDatabase.setModel(DbUtils.resultSetToTableModel(rs));
    //setModel(DbUtils.resultSetToTableModel(rs));
    }
    catch(Exception e){
    JOptionPane.showMessageDialog(null, e);}
    }
private void Update_Table2(){
    try{
    String sql="select * from ExamDay";
    pst=conn.prepareStatement(sql);
    rs=pst.executeQuery(); 
    
    ViewDatabase.setModel(DbUtils.resultSetToTableModel(rs));
    
    }
    catch(Exception e){
    JOptionPane.showMessageDialog(null, e);}
    }
private void Update_Table3(){
    try{
    String sql="select * from AfterExam";
    pst=conn.prepareStatement(sql);
    rs=pst.executeQuery(); 
    
    ViewDatabase.setModel(DbUtils.resultSetToTableModel(rs));
    
    }
    catch(Exception e){
    JOptionPane.showMessageDialog(null, e);}
    }
    
   
    
   
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel2 = new javax.swing.JPanel();
        pp6 = new javax.swing.JPanel();
        gbgb2 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        jLabel50 = new javax.swing.JLabel();
        jSeparator1 = new javax.swing.JSeparator();
        pp3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        pp5 = new javax.swing.JPanel();
        gbgb1 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        pp1 = new javax.swing.JPanel();
        gbgb = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        pp2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        panel_center = new javax.swing.JPanel();
        p1 = new javax.swing.JPanel();
        jLabel4 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        jLabel18 = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        jLabel20 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        Sup_Ts = new javax.swing.JSpinner();
        Ing_Ts = new javax.swing.JSpinner();
        Hall_Ts = new javax.swing.JSpinner();
        Hall_Ps = new javax.swing.JSpinner();
        Ing_Ps = new javax.swing.JSpinner();
        Sup_Ps = new javax.swing.JSpinner();
        jLabel9 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        BeforeName = new javax.swing.JTextField();
        DayName = new javax.swing.JComboBox<>();
        jButton3 = new javax.swing.JButton();
        Full = new javax.swing.JPanel();
        exitPanel = new javax.swing.JPanel();
        jLabel47 = new javax.swing.JLabel();
        p2 = new javax.swing.JPanel();
        Mod_Mcqs = new javax.swing.JSpinner();
        jLabel21 = new javax.swing.JLabel();
        BeforeName1 = new javax.swing.JTextField();
        Typ_1s = new javax.swing.JSpinner();
        BeforeSalary = new javax.swing.JComboBox<>();
        Typ_2s = new javax.swing.JSpinner();
        PrintSups = new javax.swing.JSpinner();
        Typ_Mcq = new javax.swing.JSpinner();
        beforeCancel = new javax.swing.JButton();
        Dups = new javax.swing.JSpinner();
        Typ_3s = new javax.swing.JSpinner();
        jLabel22 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        beforeHome = new javax.swing.JButton();
        jLabel23 = new javax.swing.JLabel();
        Mod_3s = new javax.swing.JSpinner();
        beforeSubmit = new javax.swing.JButton();
        PackSeas = new javax.swing.JSpinner();
        Mod_2s = new javax.swing.JSpinner();
        jLabel24 = new javax.swing.JLabel();
        Mod_1s = new javax.swing.JSpinner();
        Setter_Mcqs = new javax.swing.JSpinner();
        Setter_3s = new javax.swing.JSpinner();
        Setter_2s = new javax.swing.JSpinner();
        Setter_1s = new javax.swing.JSpinner();
        jLabel25 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        jLabel27 = new javax.swing.JLabel();
        jLabel28 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        p3 = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        afterHome1 = new javax.swing.JButton();
        jLabel30 = new javax.swing.JLabel();
        After_Gs1 = new javax.swing.JSpinner();
        afterCancel1 = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        AfterEssays = new javax.swing.JSpinner();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        AfterSalary1 = new javax.swing.JComboBox<>();
        AfterType = new javax.swing.JComboBox<>();
        AfterName = new javax.swing.JTextField();
        AfterName1 = new javax.swing.JTextField();
        jLabel36 = new javax.swing.JLabel();
        AfterEssays1 = new javax.swing.JSpinner();
        jLabel33 = new javax.swing.JLabel();
        After_Gs = new javax.swing.JSpinner();
        afterSubmit1 = new javax.swing.JButton();
        AfterMcqs = new javax.swing.JSpinner();
        jLabel40 = new javax.swing.JLabel();
        jLabel34 = new javax.swing.JLabel();
        AfterType1 = new javax.swing.JComboBox<>();
        AfterMcqs1 = new javax.swing.JSpinner();
        jLabel32 = new javax.swing.JLabel();
        After_Ss = new javax.swing.JSpinner();
        jLabel35 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel42 = new javax.swing.JLabel();
        afterCancel = new javax.swing.JButton();
        afterSubmit = new javax.swing.JButton();
        afterHome = new javax.swing.JButton();
        jLabel46 = new javax.swing.JLabel();
        AfterSalary = new javax.swing.JComboBox<>();
        p4 = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        FinalResult = new javax.swing.JTable();
        jScrollPane3 = new javax.swing.JScrollPane();
        FinalResult1 = new javax.swing.JTable();
        printt = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jLabel48 = new javax.swing.JLabel();
        p5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        ViewDatabase = new javax.swing.JTable();
        jButton4 = new javax.swing.JButton();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setUndecorated(true);

        jPanel2.setBackground(new java.awt.Color(54, 33, 89));
        jPanel2.setPreferredSize(new java.awt.Dimension(255, 589));

        pp6.setBackground(new java.awt.Color(85, 65, 100));
        pp6.setPreferredSize(new java.awt.Dimension(205, 64));
        pp6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pp6mouseclicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pp6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pp6MouseExited(evt);
            }
        });
        pp6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        gbgb2.setBackground(new java.awt.Color(153, 153, 153));
        gbgb2.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        gbgb2.setForeground(new java.awt.Color(204, 204, 204));
        gbgb2.setText("View Database");
        pp6.add(gbgb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, 160, 52));

        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_report_card_32px_2.png"))); // NOI18N
        pp6.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 80, 60));

        jLabel50.setBackground(new java.awt.Color(204, 204, 204));
        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_purchase_order_52px_1.png"))); // NOI18N

        jSeparator1.setBackground(new java.awt.Color(255, 255, 255));
        jSeparator1.setForeground(new java.awt.Color(160, 160, 160));
        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 5));

        pp3.setBackground(new java.awt.Color(85, 65, 118));
        pp3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mouseclicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExited(evt);
            }
        });
        pp3.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel3.setBackground(new java.awt.Color(153, 153, 153));
        jLabel3.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(204, 204, 204));
        jLabel3.setText("Exam Day");
        pp3.add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, 36));

        jLabel52.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_play_26px.png"))); // NOI18N
        pp3.add(jLabel52, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 60, -1));

        jLabel51.setBackground(new java.awt.Color(204, 204, 204));
        jLabel51.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        jLabel51.setText("EXAM DEPT");

        pp5.setBackground(new java.awt.Color(85, 65, 100));
        pp5.setPreferredSize(new java.awt.Dimension(205, 64));
        pp5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pp5mouseclicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pp5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pp5MouseExited(evt);
            }
        });
        pp5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        gbgb1.setBackground(new java.awt.Color(153, 153, 153));
        gbgb1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        gbgb1.setForeground(new java.awt.Color(204, 204, 204));
        gbgb1.setText("Final Results");
        pp5.add(gbgb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, 52));

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_report_card_32px_2.png"))); // NOI18N
        pp5.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 80, 60));

        pp1.setBackground(new java.awt.Color(85, 65, 118));
        pp1.setPreferredSize(new java.awt.Dimension(205, 64));
        pp1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mouseclicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExited(evt);
            }
        });
        pp1.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        gbgb.setBackground(new java.awt.Color(153, 153, 153));
        gbgb.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        gbgb.setForeground(new java.awt.Color(204, 204, 204));
        gbgb.setText("After Exam");
        pp1.add(gbgb, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 0, -1, 60));

        jLabel53.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_play_26px.png"))); // NOI18N
        pp1.add(jLabel53, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 60, -1));

        pp2.setBackground(new java.awt.Color(85, 65, 118));
        pp2.setPreferredSize(new java.awt.Dimension(205, 64));
        pp2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mouseclicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                MouseExited(evt);
            }
        });
        pp2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel2.setBackground(new java.awt.Color(153, 153, 153));
        jLabel2.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(204, 204, 204));
        jLabel2.setText("Before Exam");
        pp2.add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 20, -1, -1));

        jLabel54.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_play_26px.png"))); // NOI18N
        pp2.add(jLabel54, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 20, 60, -1));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(93, 93, 93))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addComponent(pp5, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pp3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 245, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pp2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pp1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(pp6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(60, Short.MAX_VALUE)
                    .addComponent(jLabel51, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(27, 27, 27)))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(63, 63, 63)
                .addComponent(jLabel50, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(125, 125, 125)
                .addComponent(pp2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pp3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(142, 142, 142)
                .addComponent(pp5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pp6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addGap(22, 22, 22)
                    .addComponent(jLabel51)
                    .addContainerGap(1262, Short.MAX_VALUE)))
        );

        getContentPane().add(jPanel2, java.awt.BorderLayout.LINE_START);

        panel_center.setBackground(new java.awt.Color(255, 255, 255));
        panel_center.setLayout(new java.awt.CardLayout());

        jLabel4.setFont(new java.awt.Font("Times New Roman", 1, 80)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Enter Details-Exam Day");

        jLabel14.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Salary ID");

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Name");

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Supervisor");

        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel20.setForeground(new java.awt.Color(0, 0, 0));
        jLabel20.setText("Invigilator");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Hall Attendant");

        Sup_Ts.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        Ing_Ts.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        Hall_Ts.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        Hall_Ps.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        Ing_Ps.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        Sup_Ps.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Practical");

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Theory");

        BeforeName.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        BeforeName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BeforeNameActionPerformed(evt);
            }
        });

        DayName.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        DayName.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select The ID" }));
        DayName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DayNameActionPerformed(evt);
            }
        });

        jButton3.setBackground(new java.awt.Color(51, 51, 51));
        jButton3.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jButton3.setText("Submit");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        Full.setBackground(new java.awt.Color(122, 72, 221));
        Full.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                mouseclicked(evt);
            }
        });

        javax.swing.GroupLayout FullLayout = new javax.swing.GroupLayout(Full);
        Full.setLayout(FullLayout);
        FullLayout.setHorizontalGroup(
            FullLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2078, Short.MAX_VALUE)
        );
        FullLayout.setVerticalGroup(
            FullLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 122, Short.MAX_VALUE)
        );

        exitPanel.setMinimumSize(new java.awt.Dimension(43, 75));
        exitPanel.setPreferredSize(new java.awt.Dimension(60, 89));
        exitPanel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                exitPanelMouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                exitPanelMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                exitPanelMouseExited(evt);
            }
        });
        exitPanel.setLayout(new java.awt.BorderLayout());

        jLabel47.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel47.setText("X");
        exitPanel.add(jLabel47, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout p1Layout = new javax.swing.GroupLayout(p1);
        p1.setLayout(p1Layout);
        p1Layout.setHorizontalGroup(
            p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(Full, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(exitPanel, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p1Layout.createSequentialGroup()
                        .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jButton3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p1Layout.createSequentialGroup()
                                .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 870, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(p1Layout.createSequentialGroup()
                                        .addGap(210, 210, 210)
                                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(140, 140, 140)
                                        .addComponent(DayName, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(p1Layout.createSequentialGroup()
                                        .addGap(210, 210, 210)
                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(190, 190, 190)
                                        .addComponent(BeforeName, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(p1Layout.createSequentialGroup()
                                        .addGap(410, 410, 410)
                                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(160, 160, 160)
                                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(p1Layout.createSequentialGroup()
                                        .addGap(100, 100, 100)
                                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(140, 140, 140)
                                        .addComponent(Sup_Ts, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(190, 190, 190)
                                        .addComponent(Sup_Ps, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(p1Layout.createSequentialGroup()
                                        .addGap(100, 100, 100)
                                        .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(110, 110, 110)
                                        .addComponent(Ing_Ts, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(190, 190, 190)
                                        .addComponent(Ing_Ps, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(p1Layout.createSequentialGroup()
                                        .addGap(100, 100, 100)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(100, 100, 100)
                                        .addComponent(Hall_Ts, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(200, 200, 200)
                                        .addComponent(Hall_Ps, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(72, 72, 72)))
                        .addGap(300, 300, 300))))
        );
        p1Layout.setVerticalGroup(
            p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p1Layout.createSequentialGroup()
                .addComponent(exitPanel, javax.swing.GroupLayout.PREFERRED_SIZE, 71, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Full, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(DayName, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p1Layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(BeforeName, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(p1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Sup_Ts, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Sup_Ps, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(30, 30, 30)
                .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ing_Ts, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ing_Ps, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(40, 40, 40)
                .addGroup(p1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Hall_Ts, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Hall_Ps, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(102, 102, 102)
                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(327, Short.MAX_VALUE))
        );

        panel_center.add(p1, "card2");

        Mod_Mcqs.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel21.setText("Setter");

        BeforeName1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N

        Typ_1s.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        BeforeSalary.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        BeforeSalary.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select The ID" }));
        BeforeSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BeforeSalaryActionPerformed(evt);
            }
        });

        Typ_2s.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        PrintSups.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        Typ_Mcq.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        beforeCancel.setBackground(new java.awt.Color(51, 51, 51));
        beforeCancel.setFont(new java.awt.Font("Times New Roman", 1, 28)); // NOI18N
        beforeCancel.setText("Cancel");
        beforeCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beforeCancelActionPerformed(evt);
            }
        });

        Dups.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        Typ_3s.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel22.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel22.setForeground(new java.awt.Color(0, 0, 0));
        jLabel22.setText("Essay type 02 hour");

        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Essay type 01 hour");

        beforeHome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        beforeHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beforeHomeActionPerformed(evt);
            }
        });

        jLabel23.setBackground(new java.awt.Color(51, 51, 51));

        Mod_3s.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        beforeSubmit.setBackground(new java.awt.Color(51, 51, 51));
        beforeSubmit.setFont(new java.awt.Font("Times New Roman", 1, 28)); // NOI18N
        beforeSubmit.setText("Submit");
        beforeSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                beforeSubmitActionPerformed(evt);
            }
        });

        PackSeas.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        Mod_2s.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel24.setFont(new java.awt.Font("Times New Roman", 1, 80)); // NOI18N
        jLabel24.setForeground(new java.awt.Color(0, 0, 0));
        jLabel24.setText("Enter Details - Before Exam");

        Mod_1s.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        Setter_Mcqs.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        Setter_3s.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        Setter_2s.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        Setter_1s.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel25.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel25.setText("Printing supervision");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel13.setText("Packeting & sealing");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel12.setText("Duplicating machine operator");

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel11.setText("Typing ");

        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("MCQ Script/Essay  01 hour");

        jLabel26.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel26.setForeground(new java.awt.Color(0, 0, 0));
        jLabel26.setText("Essay type 03 hour");

        jLabel27.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel27.setForeground(new java.awt.Color(0, 0, 0));
        jLabel27.setText("Name");

        jLabel28.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel28.setForeground(new java.awt.Color(0, 0, 0));
        jLabel28.setText("Salary ID");

        jLabel29.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel29.setText("Moderater");

        javax.swing.GroupLayout p2Layout = new javax.swing.GroupLayout(p2);
        p2.setLayout(p2Layout);
        p2Layout.setHorizontalGroup(
            p2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2078, Short.MAX_VALUE)
            .addGroup(p2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(p2Layout.createSequentialGroup()
                    .addGap(0, 294, Short.MAX_VALUE)
                    .addGroup(p2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(880, 880, 880)
                            .addComponent(Mod_Mcqs, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(880, 880, 880)
                            .addComponent(Mod_2s, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(150, 150, 150)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(150, 150, 150)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(150, 150, 150)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(990, 990, 990)
                            .addComponent(beforeSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(1130, 1130, 1130)
                            .addComponent(Typ_1s, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(880, 880, 880)
                            .addComponent(Mod_3s, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(20, 20, 20)
                            .addComponent(beforeHome, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(160, 160, 160)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(870, 870, 870)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(610, 610, 610)
                            .addComponent(PrintSups, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(600, 600, 600)
                            .addComponent(BeforeName1, javax.swing.GroupLayout.PREFERRED_SIZE, 740, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(150, 150, 150)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(1130, 1130, 1130)
                            .addComponent(Typ_3s, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(1130, 1130, 1130)
                            .addComponent(Typ_2s, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(1130, 1130, 1130)
                            .addComponent(Typ_Mcq, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(860, 860, 860)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(610, 610, 610)
                            .addComponent(Setter_Mcqs, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(610, 610, 610)
                            .addComponent(Setter_1s, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(150, 150, 150)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(250, 250, 250)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 1020, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(160, 160, 160)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(1200, 1200, 1200)
                            .addComponent(PackSeas, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(610, 610, 610)
                            .addComponent(Dups, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(150, 150, 150)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(880, 880, 880)
                            .addComponent(Mod_1s, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(610, 610, 610)
                            .addComponent(Setter_3s, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(1130, 1130, 1130)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(620, 620, 620)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(610, 610, 610)
                            .addComponent(BeforeSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 570, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(610, 610, 610)
                            .addComponent(Setter_2s, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 1490, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(1260, 1260, 1260)
                            .addComponent(beforeCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 294, Short.MAX_VALUE)))
        );
        p2Layout.setVerticalGroup(
            p2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1329, Short.MAX_VALUE)
            .addGroup(p2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(p2Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addGroup(p2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(670, 670, 670)
                            .addComponent(Mod_Mcqs, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(540, 540, 540)
                            .addComponent(Mod_2s, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(590, 590, 590)
                            .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(530, 530, 530)
                            .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(840, 840, 840)
                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(930, 930, 930)
                            .addComponent(beforeSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(480, 480, 480)
                            .addComponent(Typ_1s, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(600, 600, 600)
                            .addComponent(Mod_3s, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(60, 60, 60)
                            .addComponent(beforeHome, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(360, 360, 360)
                            .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(840, 840, 840)
                            .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(790, 790, 790)
                            .addComponent(PrintSups, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(350, 350, 350)
                            .addComponent(BeforeName1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(770, 770, 770)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(600, 600, 600)
                            .addComponent(Typ_3s, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(540, 540, 540)
                            .addComponent(Typ_2s, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(670, 670, 670)
                            .addComponent(Typ_Mcq, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(420, 420, 420)
                            .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(670, 670, 670)
                            .addComponent(Setter_Mcqs, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(480, 480, 480)
                            .addComponent(Setter_1s, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(660, 660, 660)
                            .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(80, 80, 80)
                            .addComponent(jLabel24, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(270, 270, 270)
                            .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(850, 850, 850)
                            .addComponent(PackSeas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(860, 860, 860)
                            .addComponent(Dups, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(470, 470, 470)
                            .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(480, 480, 480)
                            .addComponent(Mod_1s, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(600, 600, 600)
                            .addComponent(Setter_3s, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(420, 420, 420)
                            .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(420, 420, 420)
                            .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(242, 242, 242)
                            .addComponent(BeforeSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(540, 540, 540)
                            .addComponent(Setter_2s, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jLabel23, javax.swing.GroupLayout.PREFERRED_SIZE, 1050, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(p2Layout.createSequentialGroup()
                            .addGap(930, 930, 930)
                            .addComponent(beforeCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        panel_center.add(p2, "card3");

        jScrollPane4.setMaximumSize(new java.awt.Dimension(2333, 1329));

        jPanel1.setMaximumSize(new java.awt.Dimension(1500, 1000));

        afterHome1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        afterHome1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                afterHome1ActionPerformed(evt);
            }
        });

        jLabel30.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel30.setText("MCQ");

        After_Gs1.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        afterCancel1.setBackground(new java.awt.Color(51, 51, 51));
        afterCancel1.setFont(new java.awt.Font("Times New Roman", 1, 28)); // NOI18N
        afterCancel1.setText("Cancel");
        afterCancel1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                afterCancel1ActionPerformed(evt);
            }
        });

        jLabel17.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel17.setText("Name  ");

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel16.setText("Essay  ");

        jLabel31.setText("jLabel10");

        AfterEssays.setModel(new javax.swing.SpinnerNumberModel());

        jLabel37.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel37.setText("Special");

        jLabel38.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel38.setText("General");

        AfterSalary1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        AfterSalary1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select The ID" }));
        AfterSalary1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AfterSalary1ActionPerformed(evt);
            }
        });

        AfterType.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        AfterType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select ", "External", "Internal" }));
        AfterType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AfterTypeActionPerformed(evt);
            }
        });

        AfterName.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        AfterName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AfterNameActionPerformed(evt);
            }
        });

        AfterName1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        AfterName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AfterName1ActionPerformed(evt);
            }
        });

        jLabel36.setBackground(new java.awt.Color(51, 51, 51));
        jLabel36.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N

        AfterEssays1.setModel(new javax.swing.SpinnerNumberModel());

        jLabel33.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel33.setText("Type  ");

        After_Gs.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        afterSubmit1.setBackground(new java.awt.Color(51, 51, 51));
        afterSubmit1.setFont(new java.awt.Font("Times New Roman", 1, 28)); // NOI18N
        afterSubmit1.setText("Submit");
        afterSubmit1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                afterSubmit1ActionPerformed(evt);
            }
        });

        AfterMcqs.setModel(new javax.swing.SpinnerNumberModel());

        jLabel40.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel34.setFont(new java.awt.Font("Times New Roman", 1, 60)); // NOI18N
        jLabel34.setText("Enter The Details-After");

        AfterType1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        AfterType1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select ", "External", "Internal" }));
        AfterType1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AfterType1ActionPerformed(evt);
            }
        });

        AfterMcqs1.setModel(new javax.swing.SpinnerNumberModel());

        jLabel32.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel32.setText("Dissertation");

        After_Ss.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel35.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel35.setText("Salary ID");

        jLabel15.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        jLabel6.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel6.setText("MCQ");

        jLabel41.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel41.setText("Dissertation");

        jLabel45.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel45.setText("Salary ID");

        jLabel44.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel44.setText("Name  ");

        jLabel43.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel43.setText("Type  ");

        jLabel42.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel42.setText("Essay  ");

        afterCancel.setBackground(new java.awt.Color(51, 51, 51));
        afterCancel.setFont(new java.awt.Font("Times New Roman", 1, 28)); // NOI18N
        afterCancel.setText("Cancel");
        afterCancel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                afterCancelActionPerformed(evt);
            }
        });

        afterSubmit.setBackground(new java.awt.Color(51, 51, 51));
        afterSubmit.setFont(new java.awt.Font("Times New Roman", 1, 28)); // NOI18N
        afterSubmit.setText("Submit");
        afterSubmit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                afterSubmitActionPerformed(evt);
            }
        });

        afterHome.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        afterHome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                afterHomeActionPerformed(evt);
            }
        });

        jLabel46.setFont(new java.awt.Font("Times New Roman", 1, 60)); // NOI18N
        jLabel46.setText("Enter The Details-After");

        AfterSalary.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        AfterSalary.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select The ID" }));
        AfterSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AfterSalaryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(afterHome, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(afterHome1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel31))
                        .addGap(350, 350, 350)
                        .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(130, 130, 130)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AfterSalary1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AfterSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel40, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(110, 110, 110)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AfterName, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AfterName1, javax.swing.GroupLayout.PREFERRED_SIZE, 400, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(130, 130, 130)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AfterType1, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AfterType, javax.swing.GroupLayout.PREFERRED_SIZE, 260, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(110, 110, 110)
                        .addComponent(AfterEssays, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(130, 130, 130)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(AfterMcqs, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AfterMcqs1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(110, 110, 110)
                        .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(After_Gs, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(40, 40, 40)
                        .addComponent(After_Ss, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(920, 920, 920)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(afterSubmit1, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(afterSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(70, 70, 70)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(afterCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(afterCancel1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(710, 710, 710)
                        .addComponent(After_Gs1, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(280, 280, 280)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(600, 600, 600)
                        .addComponent(AfterEssays1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(450, 450, 450)
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 630, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 1490, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(afterHome, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(afterHome1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addComponent(jLabel31))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(30, 30, 30)
                                .addComponent(jLabel46, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(50, 50, 50)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(40, 40, 40)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel45, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel35, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addComponent(AfterSalary1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AfterSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel44, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(40, 40, 40)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel15)
                                            .addComponent(jLabel40)))))
                            .addComponent(AfterName, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(AfterName1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(20, 20, 20)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel33, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel43, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(AfterType1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(AfterType, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel42, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel16, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(AfterEssays, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel30, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(AfterMcqs, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(AfterMcqs1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel32, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel38, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(After_Gs, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(20, 20, 20)
                                .addComponent(jLabel37, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(After_Ss, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(140, 140, 140)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(afterSubmit1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(afterSubmit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(afterCancel, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(afterCancel1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(640, 640, 640)
                        .addComponent(After_Gs1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(630, 630, 630)
                        .addComponent(jLabel41, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(330, 330, 330)
                        .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(480, 480, 480)
                        .addComponent(AfterEssays1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel34, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel36, javax.swing.GroupLayout.PREFERRED_SIZE, 1000, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jScrollPane4.setViewportView(jPanel1);

        javax.swing.GroupLayout p3Layout = new javax.swing.GroupLayout(p3);
        p3.setLayout(p3Layout);
        p3Layout.setHorizontalGroup(
            p3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 2078, Short.MAX_VALUE)
            .addGroup(p3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p3Layout.createSequentialGroup()
                    .addContainerGap(291, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(270, 270, 270)))
        );
        p3Layout.setVerticalGroup(
            p3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 1329, Short.MAX_VALUE)
            .addGroup(p3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p3Layout.createSequentialGroup()
                    .addContainerGap(161, Short.MAX_VALUE)
                    .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(141, 141, 141)))
        );

        panel_center.add(p3, "card4");

        FinalResult.setAutoCreateRowSorter(true);
        FinalResult.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        FinalResult.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        FinalResult.setAlignmentY(2.0F);
        FinalResult.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        FinalResult.setIntercellSpacing(new java.awt.Dimension(4, 4));
        FinalResult.setRowHeight(30);
        jScrollPane2.setViewportView(FinalResult);

        FinalResult1.setAutoCreateRowSorter(true);
        FinalResult1.setFont(new java.awt.Font("Times New Roman", 0, 16)); // NOI18N
        FinalResult1.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        FinalResult1.setAlignmentY(2.0F);
        FinalResult1.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        FinalResult1.setIntercellSpacing(new java.awt.Dimension(4, 4));
        FinalResult1.setRowHeight(30);
        jScrollPane3.setViewportView(FinalResult1);

        printt.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        printt.setText("Print");
        printt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                printtActionPerformed(evt);
            }
        });

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jButton1.setText("Back");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 36)); // NOI18N
        jButton2.setText("Delete");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jLabel48.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        jLabel48.setText("Welcome !!!!!!!!!!!!!!");

        javax.swing.GroupLayout p4Layout = new javax.swing.GroupLayout(p4);
        p4.setLayout(p4Layout);
        p4Layout.setHorizontalGroup(
            p4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p4Layout.createSequentialGroup()
                .addGroup(p4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(p4Layout.createSequentialGroup()
                        .addGap(227, 227, 227)
                        .addComponent(printt, javax.swing.GroupLayout.PREFERRED_SIZE, 270, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(161, 161, 161)
                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(153, 153, 153)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 280, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(p4Layout.createSequentialGroup()
                        .addGap(412, 412, 412)
                        .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 296, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 1930, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(148, Short.MAX_VALUE))
            .addGroup(p4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(p4Layout.createSequentialGroup()
                    .addGap(0, 65, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 1930, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 83, Short.MAX_VALUE)))
        );
        p4Layout.setVerticalGroup(
            p4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, p4Layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addComponent(jLabel48, javax.swing.GroupLayout.PREFERRED_SIZE, 74, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 840, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 205, Short.MAX_VALUE)
                .addGroup(p4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(printt, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(49, 49, 49))
            .addGroup(p4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(p4Layout.createSequentialGroup()
                    .addGap(0, 280, Short.MAX_VALUE)
                    .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 643, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(0, 406, Short.MAX_VALUE)))
        );

        panel_center.add(p4, "card5");

        jScrollPane1.setAutoscrolls(true);

        ViewDatabase.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4", "Title 5", "Title 6", "Title 7", "Title 8", "Title 9", "Title 10"
            }
        ));
        ViewDatabase.setAlignmentY(2.0F);
        ViewDatabase.setAutoResizeMode(javax.swing.JTable.AUTO_RESIZE_ALL_COLUMNS);
        ViewDatabase.setIntercellSpacing(new java.awt.Dimension(4, 4));
        ViewDatabase.setMaximumSize(new java.awt.Dimension(2147483647, 160));
        ViewDatabase.setMinimumSize(new java.awt.Dimension(60, 160));
        ViewDatabase.setPreferredSize(new java.awt.Dimension(300, 120));
        ViewDatabase.setRowHeight(30);
        jScrollPane1.setViewportView(ViewDatabase);

        jButton4.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton4.setText("View Before Exam Database");
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });

        jButton5.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton5.setText("View Exam Day Database");
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });

        jButton6.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jButton6.setText("View After Exam Database");
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout p5Layout = new javax.swing.GroupLayout(p5);
        p5.setLayout(p5Layout);
        p5Layout.setHorizontalGroup(
            p5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p5Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 2040, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 38, Short.MAX_VALUE))
            .addGroup(p5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 330, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(130, 130, 130)
                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(110, 110, 110)
                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 320, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        p5Layout.setVerticalGroup(
            p5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(p5Layout.createSequentialGroup()
                .addGap(75, 75, 75)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 610, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(149, 149, 149)
                .addGroup(p5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(415, Short.MAX_VALUE))
        );

        panel_center.add(p5, "card6");

        getContentPane().add(panel_center, java.awt.BorderLayout.CENTER);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void mouseclicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_mouseclicked
        if(evt.getSource()==pp3){
        
        p1.setVisible(true);
        p2.setVisible(false);
        p3.setVisible(false);
        p4.setVisible(false);
        
      }
       
             if(evt.getSource()==pp2){
        
        p1.setVisible(false);
        p2.setVisible(true);
        p3.setVisible(false);
        p4.setVisible(false);
        
      }
                  if(evt.getSource()==pp1){
        
        p1.setVisible(false);
        p2.setVisible(false);
        p3.setVisible(true);
        p4.setVisible(false);
        
      }
        
    }//GEN-LAST:event_mouseclicked

    private void MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MouseEntered
        // TODO add your handling code here:
        if(evt.getSource()==pp1){
        
        pp1.setBackground(new Color(135,135,135));
        }
        
       if(evt.getSource()==pp2){
        
        pp2.setBackground(new Color(135,135,135));
        }
       if(evt.getSource()==pp3){
        
        pp3.setBackground(new Color(135,135,135));
        }
       
    }//GEN-LAST:event_MouseEntered

    private void MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_MouseExited
        // TODO add your handling code here:
        
        if(evt.getSource()==pp1){
        
        pp1.setBackground(new Color(85,65,118));
        }
        
       if(evt.getSource()==pp2){
        
        pp2.setBackground(new Color(85,65,118));
        }
       if(evt.getSource()==pp3){
        
        pp3.setBackground(new Color(85,65,118));
        }
      
    }//GEN-LAST:event_MouseExited

    private void BeforeNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BeforeNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BeforeNameActionPerformed

    private void DayNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DayNameActionPerformed

        String  selectedValue=DayName.getSelectedItem().toString();
        String ttt = "SELECT Employee_Name FROM Employee  WHERE Employee_Id='"+selectedValue+"'";
        try {
            pst=conn.prepareStatement(ttt);
            rs=pst.executeQuery();
            String yy=rs.getString("Employee_Name");

            BeforeName.setText(yy);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }          // TODO add your handling code here:
    }//GEN-LAST:event_DayNameActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        // TODO add your handling code here:

        try{
            String sql="Insert into ExamDay (SalaryId,Name,Sup_T,Sup_P,Ing_S,Ing_P,Hall_T,Hall_P,Payments) values (?,?,?,?,?,?,?,?,?)";
            pst=conn.prepareStatement(sql);
            String valuee12=DayName.getSelectedItem().toString();
            pst.setString(1,valuee12);

            pst.setString(2, BeforeName.getText());

            String ba=Sup_Ts.getValue().toString();
            String bb=Sup_Ps.getValue().toString();
            String bc=Ing_Ts.getValue().toString();
            String bd=Ing_Ps.getValue().toString();
            String be=Hall_Ts.getValue().toString();
            String bf=Hall_Ps.getValue().toString();

            int ba1=Integer.parseInt(ba);
            int bb1=Integer.parseInt(bb);

            int bc1=Integer.parseInt(bc);
            int bd1=Integer.parseInt(bd);
            int be1=Integer.parseInt(be);
            int bf1=Integer.parseInt(bf);

            pst.setInt(3,ba1);
            pst.setInt(4,bb1);
            pst.setInt(5,bc1);
            pst.setInt(6,bd1);
            pst.setInt(7,be1);
            pst.setInt(8,bf1);

            int PaymentsB = ((ba1*1000)+(bb1*2000)+(bc1*600)+(bd1*1200)+(be1*250)+(bf1*500));
            pst.setInt (9,PaymentsB);

            JOptionPane.showMessageDialog(null,"Data Added Successfully");

            //   this.setVisible(false); //this will close frame i.e. NewJFrame

            //new AfterExam().setVisible(true);
            //AfterExam main = new AfterExam();

            //    main.setVisible(true);
            //   this.dispose();

            pst.execute();

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            try{
                pst.close();
                rs.close();
                conn.close();
                sqlite3_finalize();
            }
            catch(Exception e){

            }
        }

        /*
        try{
            String sql="Insert into FinalReport (SALARY_ID,SUBJECT_AND_NAME_OF_THE_STAFF,SETTER,MODERATOR,TYPING,INTERNAL_EXAMINER,EXTERNAL_EXAMINER,SUPERVISOR,INVIGILATOR,HALL_ATTENDANT,DUPLICATING_MACHINE_OPERATOR,PACKETING_AND_SEALING,TEACHER_FOR_PRINTING_SUPERVISION,TOTAL) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst=conn.prepareStatement(sql);

            pst.setString(1, BeforeSalary.getText());
            pst.setString(2, BeforeName.getText());
            String ba=Sup_T.getSelectedItem().toString();
            String bb=Sup_P.getSelectedItem().toString();
            String bc=Ing_T.getSelectedItem().toString();
            String bd=Ing_P.getSelectedItem().toString();
            String be=Hall_T.getSelectedItem().toString();
            String bf=Hall_P.getSelectedItem().toString();

            int ba1=Integer.parseInt(ba);
            int bb1=Integer.parseInt(bb);

            int bc1=Integer.parseInt(bc);
            int bd1=Integer.parseInt(bd);
            int be1=Integer.parseInt(be);
            int be2=Integer.parseInt(bf);

            int Super_T=((ba1*1000));
            int Super_P=((bb1*1000));
            int Ing_T=((bc1*600));
            int Ing_P=((bd1*600));
            int Hall_T=((be1*250));
            int Hall_P=((be2*250));
            Super=(Super_T+Super_P);
            Ing=(Ing_T+Ing_P);
            Hall=(Hall_T+Hall_P);
            int Total=(Super_T+Super_P+Ing_T+Ing_P+Hall_T+ Hall_P);
            pst.setInt(8,Super);
            pst.setInt(9,Ing);
            pst.setInt(10,Hall);
            pst.setInt(14,Total);

            // JOptionPane.showMessageDialog(null,"Data Added Successfully");

            //   this.setVisible(false); //this will close frame i.e. NewJFrame

            //new AfterExam().setVisible(true);
            //AfterExam main = new AfterExam();

            //    main.setVisible(true);
            //   this.dispose();

            pst.execute();

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            try{
                pst.close();
                rs.close();
            }
            catch(Exception e){

            }
        }

        */
        String valuee12=DayName.getSelectedItem().toString();

        String aq=valuee12;
        String sqli="select SALARY_ID from FinalReport where SALARY_ID=?";

        //data redun
        try{
            pst=conn.prepareStatement(sqli);
            pst.setString(1,valuee12);

            rs=pst.executeQuery();
            if(rs.next()){

                //pst.setString(1, BeforeSalary.getText());
                //  pst.setString(2, BeforeName.getText());
                String ba=Sup_Ts.getValue().toString();
                String bb=Sup_Ps.getValue().toString();
                String bc=Ing_Ts.getValue().toString();
                String bd=Ing_Ps.getValue().toString();
                String be=Hall_Ts.getValue().toString();
                String bf=Hall_Ps.getValue().toString();

                int ba1=Integer.parseInt(ba);
                int bb1=Integer.parseInt(bb);

                int bc1=Integer.parseInt(bc);
                int bd1=Integer.parseInt(bd);
                int be1=Integer.parseInt(be);
                int be2=Integer.parseInt(bf);

                int Super_T=((ba1*1000));
                int Super_P=((bb1*1000));
                int Ing_T=((bc1*600));
                int Ing_P=((bd1*600));
                int Hall_T=((be1*250));
                int Hall_P=((be2*250));
                int Super=(Super_T+Super_P);
                int Ing=(Ing_T+Ing_P);
                int Hall=(Hall_T+Hall_P);
                int Total=(Super_T+Super_P+Ing_T+Ing_P+Hall_T+ Hall_P);
                String sqliii = "SELECT TOTAL,SUPERVISOR,INVIGILATOR,HALL_ATTENDANT FROM FinalReport  WHERE SALARY_ID='"+aq+"'";
                pst=conn.prepareStatement(sqliii);
                rs=pst.executeQuery();
                int to=rs.getInt("TOTAL");
                int so=rs.getInt("SUPERVISOR");
                int io=rs.getInt("INVIGILATOR");
                int ho=rs.getInt("HALL_ATTENDANT");
                int TOtAL=(Total+to);
                int SUPER=(so+Super);
                int ING=(io+Ing);
                int HALL=(ho+Hall);

                String sqlii="update FinalReport set SUPERVISOR='"+SUPER+"',INVIGILATOR='"+ING+"',HALL_ATTENDANT=+'"+HALL+"',TOTAL='"+TOtAL+"' WHERE SALARY_ID='"+aq+"'";
                //JOptionPane.showMessageDialog(null, "Username and Password is correct");
                pst=conn.prepareStatement(sqlii);
                pst.execute();
                pst.close();
                rs.close();
                conn.close();
          //      this.setVisible(false);
              //  ExamDayDuty d=new ExamDayDuty();
             //   d.setVisible(true);
                // pst.setInt(8,Super);
                // pst.setInt(9,Ing);
                // pst.setInt(10,Hall);
                // pst.setInt(14,Total);

                /*        String sqlii="update FinalResult set SUPERVISOR=Super,INVIGILATOR=Ing,HALL_ATTENDANT=Hall ";
                JOptionPane.showMessageDialog(null, "Username and Password is correct");
                pst=conn.prepareStatement(sqlii);
                pst.execute();
                pst.close();
                rs.close();
                DutySelection d=new DutySelection();
                d.setVisible(true);
                this.setVisible(false);*/

            }
            else {
                String sql="Insert into FinalReport (SALARY_ID,SUBJECT_AND_NAME_OF_THE_STAFF,SETTER,MODERATOR,TYPING,INTERNAL_EXAMINER,EXTERNAL_EXAMINER,SUPERVISOR,INVIGILATOR,HALL_ATTENDANT,DUPLICATING_MACHINE_OPERATOR,PACKETING_AND_SEALING,TEACHER_FOR_PRINTING_SUPERVISION,TOTAL) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                pst=conn.prepareStatement(sql);

                pst.setString(1,valuee12);
                pst.setString(2, BeforeName.getText());
                String ba=Sup_Ts.getValue().toString();
                String bb=Sup_Ps.getValue().toString();
                String bc=Ing_Ts.getValue().toString();
                String bd=Ing_Ps.getValue().toString();
                String be=Hall_Ts.getValue().toString();
                String bf=Hall_Ps.getValue().toString();

                int ba1=Integer.parseInt(ba);
                int bb1=Integer.parseInt(bb);

                int bc1=Integer.parseInt(bc);
                int bd1=Integer.parseInt(bd);
                int be1=Integer.parseInt(be);
                int be2=Integer.parseInt(bf);

                int Super_T=((ba1*1000));
                int Super_P=((bb1*1000));
                int Ing_T=((bc1*600));
                int Ing_P=((bd1*600));
                int Hall_T=((be1*250));
                int Hall_P=((be2*250));
                int Super=(Super_T+Super_P);
                int Ing=(Ing_T+Ing_P);
                int Hall=(Hall_T+Hall_P);
                int Total=(Super_T+Super_P+Ing_T+Ing_P+Hall_T+ Hall_P);
                pst.setInt(8,Super);
                pst.setInt(9,Ing);
                pst.setInt(10,Hall);
                pst.setInt(14,Total);
                pst.execute();
                pst.close();
                rs.close();
                conn.close();
            //    this.setVisible(false);
           //     ExamDayDuty d=new ExamDayDuty();
           //     this.setVisible(true);

            }

        }
        catch(Exception e){

            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            try{
                pst.close();
                rs.close();
                conn.close();
                sqlite3_finalize();
            }
            catch(Exception e){

            }
        }

    }//GEN-LAST:event_jButton3ActionPerformed

    private void BeforeSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BeforeSalaryActionPerformed

        String  selectedValue=BeforeSalary.getSelectedItem().toString();
        String ttt = "SELECT Employee_Name FROM Employee  WHERE Employee_Id='"+selectedValue+"'";
        try {
            pst=conn.prepareStatement(ttt);
            rs=pst.executeQuery();
            String yy=rs.getString("Employee_Name");

            BeforeName.setText(yy);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }           // TODO add your handling code here:
    }//GEN-LAST:event_BeforeSalaryActionPerformed

    private void beforeCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beforeCancelActionPerformed
        // TODO add your handling code here:
        System.exit(1);
    }//GEN-LAST:event_beforeCancelActionPerformed

    private void beforeHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beforeHomeActionPerformed
     //   // TODO add your handling code here:
      //  new DutySelection().setVisible(true);
      //  this.setVisible(false);

    }//GEN-LAST:event_beforeHomeActionPerformed

    private void beforeSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_beforeSubmitActionPerformed
        // TODO add your handling code here:

        try{
            String sql="Insert into BeforeExam (SalaryId,Name,Setter_1,Setter_2,Setter_3,Setter_Mcq,Mod_1,Mod_2,Mod_3,Mod_Mcq,Typ_1,Typ_2,Typ_3,Typ_Mcq,Dup,Print_Sup,Pack_Sea,Payment) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst=conn.prepareStatement(sql);
            String valuee16=BeforeSalary.getSelectedItem().toString();
            pst.setString(1,valuee16);

            pst.setString(2, BeforeName.getText());
            String value=Setter_1s.getValue().toString();
            String valuee=Setter_2s.getValue().toString();
            String g=Setter_3s.getValue().toString();
            String valueee=Setter_Mcqs.getValue().toString();
            String valueeee=Mod_1s.getValue().toString();
            String valueeeee=Mod_2s.getValue().toString();
            String a=Mod_3s.getValue().toString();
            String b=Mod_Mcqs.getValue().toString();

            String ca=Typ_1s.getValue().toString();
            String cb=Typ_2s.getValue().toString();
            String cc=Typ_3s.getValue().toString();
            String cd=Typ_Mcq.getValue().toString();

            String d=Dups.getValue().toString();
            String e=PrintSups.getValue().toString();
            String f=PackSeas.getValue().toString();

            int c1=Integer.parseInt(value);
            int d1=Integer.parseInt(valuee);
            int e1=Integer.parseInt(g);
            int f1=Integer.parseInt(valueee);
            int g1=Integer.parseInt(valueeee);
            int h1=Integer.parseInt(valueeeee);
            int i1=Integer.parseInt(a);
            int j1=Integer.parseInt(b);

            int k1a=Integer.parseInt(ca);
            int k1b=Integer.parseInt(cb);
            int k1c=Integer.parseInt(cc);
            int k1d=Integer.parseInt(cd);

            int l1=Integer.parseInt(d);
            int m1=Integer.parseInt(e);
            int n1=Integer.parseInt(f);

            pst.setInt(3,c1);
            pst.setInt(4,d1);
            pst.setInt(5,e1);
            pst.setInt(6,f1);
            pst.setInt(7,g1);
            pst.setInt(8,h1);
            pst.setInt(9,i1);
            pst.setInt(10,j1);

            pst.setInt(11,k1a);
            pst.setInt(12,k1b);
            pst.setInt(13,k1c);
            pst.setInt(14,k1d);

            pst.setInt(15,l1);
            pst.setInt(16,m1);
            pst.setInt(17,n1);

            int paymentS = ((c1*400)+(d1*800)+(e1*1200)+(f1*400)+(g1*400)+(h1*800)+(i1*1200)+(j1*400)+(k1a*100)+(k1b*100)+(k1c*100)+(k1d*100)+(l1*100)+(m1*50)+(n1*100));
            pst.setInt(18,paymentS);

            JOptionPane.showMessageDialog(null,"Data Added Successfully");

            //   this.setVisible(false); //this will close frame i.e. NewJFrame

            //new AfterExam().setVisible(true);
            //AfterExam main = new AfterExam();

            //    main.setVisible(true);
            //   this.dispose();

            pst.execute();

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);

        }
        finally{
            try{
                pst.close();
                rs.close();
                conn.close();
                sqlite3_finalize();
            }
            catch(Exception e){

            }
        }
        String valuee164=BeforeSalary.getSelectedItem().toString();

        String aq=valuee164;
        String sqli="select SALARY_ID from FinalReport where SALARY_ID=?";

        //Setter Calculation
        try{

            pst=conn.prepareStatement(sqli);

            pst.setString(1,valuee164);

            rs=pst.executeQuery();
            if(rs.next()){

                // pst.setString(1, BeforeSalary.getText());
                //pst.setString(2, BeforeName.getText());
                String aa=Setter_1s.getValue().toString();
                String bb=Setter_2s.getValue().toString();
                String cc=Setter_3s.getValue().toString();
                String dd=Setter_Mcqs.getValue().toString();
                String ee=Mod_1s.getValue().toString();
                String ff=Mod_2s.getValue().toString();
                String gg=Mod_3s.getValue().toString();
                String hh=Mod_Mcqs.getValue().toString();

                String iia=Typ_1s.getValue().toString();
                String iib=Typ_2s.getValue().toString();
                String iic=Typ_3s.getValue().toString();
                String iid=Typ_Mcq.getValue().toString();

                String jj=Dups.getValue().toString();
                String kk=PrintSups.getValue().toString();
                String ll=PackSeas.getValue().toString();

                int a1=Integer.parseInt(aa);
                int a2=Integer.parseInt(bb);
                int a3=Integer.parseInt(cc);
                int a4=Integer.parseInt(dd);
                int a5=Integer.parseInt(ee);
                int a6=Integer.parseInt(ff);
                int a7=Integer.parseInt(gg);
                int a8=Integer.parseInt(hh);

                int a9=Integer.parseInt(iia);
                int a10=Integer.parseInt(iib);
                int a11=Integer.parseInt(iic);
                int a12=Integer.parseInt(iid);

                int a13=Integer.parseInt(jj);
                int a14=Integer.parseInt(kk);
                int a15=Integer.parseInt(ll);

                int Setter = ((a1*400)+(a2*800)+(a3*1200)+(a4*400));
                // pst.setInt(3,setter);

                int Moderator = ((a5*400)+(a6*800)+(a7*1200)+(a8*400));
                //   pst.setInt(4,Moderator);

                int Typing = ((a9*100)+(a10*100)+(a11*100)+(a12*100));
                if(Typing>=500){
                    Typing=500;
                    //pst.setInt(5,Typing);
                }
                else {
                    Typing=((a9*100)+(a10*100)+(a11*100)+(a12*100));
                }

                int Packet = ((a14*50));
                if(Packet>=2500){
                    Packet=2500;
                    // pst.setInt(12,Packet);
                }
                else {
                    Packet=a14*50;
                }
                int DUP = ((a13*100));
                // pst.setInt(11,DUP);
                int Teacher = ((a15*100));
                // pst.setInt(13,Teacher);

                int Total=(Setter+Moderator+Typing+Packet+DUP+Teacher);
                // pst.setInt(14,Total);

                String sqliii = "SELECT TOTAL,SETTER,MODERATOR,TYPING,DUPLICATING_MACHINE_OPERATOR,PACKETING_AND_SEALING,TEACHER_FOR_PRINTING_SUPERVISION FROM FinalReport  WHERE SALARY_ID='"+aq+"'";
                pst=conn.prepareStatement(sqliii);
                rs=pst.executeQuery();
                int to=rs.getInt("TOTAL");
                int SS=rs.getInt("SETTER");
                int MS=rs.getInt("MODERATOR");
                int TT=rs.getInt("TYPING");
                int DK=rs.getInt("DUPLICATING_MACHINE_OPERATOR");
                int PD=rs.getInt("PACKETING_AND_SEALING");
                int PT=rs.getInt("TEACHER_FOR_PRINTING_SUPERVISION");

                int TOtAL=(Total+to);
                int SET=(Setter+SS);
                int MOD=(Moderator+MS);
                int TYP=(Typing+TT);
                int DUPLI=(DUP+DK);
                int PACK=(Packet+PD);
                int TEACHER=(Teacher+PT);

                String sqlii="update FinalReport set SETTER='"+SET+"',MODERATOR='"+MOD+"',TYPING=+'"+TYP+"',DUPLICATING_MACHINE_OPERATOR='"+DUPLI+"',PACKETING_AND_SEALING='"+PACK+"',TEACHER_FOR_PRINTING_SUPERVISION='"+TEACHER+"',TOTAL='"+TOtAL+"' WHERE SALARY_ID='"+aq+"'";
                //JOptionPane.showMessageDialog(null, "Username and Password is correct");
                pst=conn.prepareStatement(sqlii);
                pst.execute();
                pst.close();
                rs.close();
                conn.close();
    //            this.setVisible(false);
   //             SetModType d=new SetModType();
    //            d.setVisible(true);

            }
            else{

                String sql="Insert into FinalReport (SALARY_ID,SUBJECT_AND_NAME_OF_THE_STAFF,SETTER,MODERATOR,TYPING,INTERNAL_EXAMINER,EXTERNAL_EXAMINER,SUPERVISOR,INVIGILATOR,HALL_ATTENDANT,DUPLICATING_MACHINE_OPERATOR,PACKETING_AND_SEALING,TEACHER_FOR_PRINTING_SUPERVISION,TOTAL) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                pst=conn.prepareStatement(sql);

                pst.setString(1, valuee164);
                pst.setString(2, BeforeName.getText());
                String aa=Setter_1s.getValue().toString();
                String bb=Setter_2s.getValue().toString();
                String cc=Setter_3s.getValue().toString();
                String dd=Setter_Mcqs.getValue().toString();
                String ee=Mod_1s.getValue().toString();
                String ff=Mod_2s.getValue().toString();
                String gg=Mod_3s.getValue().toString();
                String hh=Mod_Mcqs.getValue().toString();

                String iia=Typ_1s.getValue().toString();
                String iib=Typ_2s.getValue().toString();
                String iic=Typ_3s.getValue().toString();
                String iid=Typ_Mcq.getValue().toString();

                String jj=Dups.getValue().toString();
                String kk=PrintSups.getValue().toString();
                String ll=PackSeas.getValue().toString();

                int a1=Integer.parseInt(aa);
                int a2=Integer.parseInt(bb);
                int a3=Integer.parseInt(cc);
                int a4=Integer.parseInt(dd);
                int a5=Integer.parseInt(ee);
                int a6=Integer.parseInt(ff);
                int a7=Integer.parseInt(gg);
                int a8=Integer.parseInt(hh);

                int a9=Integer.parseInt(iia);
                int a10=Integer.parseInt(iib);
                int a11=Integer.parseInt(iic);
                int a12=Integer.parseInt(iid);

                int a13=Integer.parseInt(jj);
                int a14=Integer.parseInt(kk);
                int a15=Integer.parseInt(ll);

                int setter = ((a1*400)+(a2*800)+(a3*1200)+(a4*400));
                pst.setInt(3,setter);

                int Moderator = ((a5*400)+(a6*800)+(a7*1200)+(a8*400));
                pst.setInt(4,Moderator);

                int Typing = ((a9*100)+(a10*100)+(a11*100)+(a12*100));
                if(Typing>=500){
                    Typing=500;
                    pst.setInt(5,Typing);
                }
                else {
                    pst.setInt(5,Typing);
                }

                int Packet = ((a14*50));
                if(Packet>=2500){
                    Packet=2500;
                    pst.setInt(15,Packet);
                }
                else {
                    pst.setInt(15,Packet);
                }
                int DUP = ((a13*100));
                pst.setInt(11,DUP);
                int Teacher = ((a15*100));
                pst.setInt(16,Teacher);

                int Total=(setter+Moderator+Typing+Packet+DUP+Teacher);
                pst.setInt(17,Total);

                // JOptionPane.showMessageDialog(null,"Data Added Successfully");

                //   this.setVisible(false); //this will close frame i.e. NewJFrame

                //new AfterExam().setVisible(true);
                //AfterExam main = new AfterExam();

                //    main.setVisible(true);
                //   this.dispose();

                pst.execute();

    //            this.setVisible(false);

   //             SetModType d=new SetModType();
     //           d.setVisible(true);

            }

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            try{
                pst.close();
                rs.close();
                conn.close();
                sqlite3_finalize();
            }
            catch(Exception e){

            }
        }

        /*
        try{
            String sql="Insert into AfterExam (SalaryId,Name,Type,Essay,Mcq,Diss_G,Diss_S) values (?,?,?,?,?,?,?)";
            pst=conn.prepareStatement(sql);

            pst.setString(1, AfterSalary.getText());
            pst.setString(2, AfterName.getText());
            String value=AfterType.getSelectedItem().toString();
            pst.setString(3,value);
            String valuee=AfterEssay.getSelectedItem().toString();
            pst.setString(4,valuee);
            String valueee=AfterMcq.getSelectedItem().toString();
            pst.setString(5,valueee);
            String valueeee=After_G.getSelectedItem().toString();
            pst.setString(6,valueeee);
            String valueeeee=After_S.getSelectedItem().toString();
            pst.setString(7,valueeeee);

            JOptionPane.showMessageDialog(null,"Data Added Successfully");

            //   this.setVisible(false); //this will close frame i.e. NewJFrame

            //new AfterExam().setVisible(true);
            //AfterExam main = new AfterExam();

            //    main.setVisible(true);
            //   this.dispose();

            pst.execute();

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            try{
                pst.close();
                rs.close();
            }
            catch(Exception e){

            }
        }*/

    }//GEN-LAST:event_beforeSubmitActionPerformed

    private void afterSubmit1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_afterSubmit1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_afterSubmit1ActionPerformed

    private void afterCancel1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_afterCancel1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_afterCancel1ActionPerformed

    private void AfterSalary1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AfterSalary1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AfterSalary1ActionPerformed

    private void AfterName1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AfterName1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AfterName1ActionPerformed

    private void afterHome1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_afterHome1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_afterHome1ActionPerformed

    private void AfterType1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AfterType1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AfterType1ActionPerformed

    private void AfterTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AfterTypeActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_AfterTypeActionPerformed

    private void AfterNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AfterNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AfterNameActionPerformed

    private void afterCancelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_afterCancelActionPerformed
        // TODO add your handling code here:
        System.exit(1);
    }//GEN-LAST:event_afterCancelActionPerformed

    private void afterSubmitActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_afterSubmitActionPerformed
        // TODO add your handling code here:

        try{
            String sql="Insert into AfterExam (SalaryId,Name,Type,Essay,Mcq,Diss_G,Diss_S) values (?,?,?,?,?,?,?)";
            pst=conn.prepareStatement(sql);
            String valuee1=AfterSalary.getSelectedItem().toString();
            pst.setString(1,valuee1);
            pst.setString(2, AfterName.getText());

            String value=AfterType.getSelectedItem().toString();
            pst.setString(3,value);

            String valuee=AfterEssays.getValue().toString();

            String valueee=AfterMcqs.getValue().toString();

            String valueeee=After_Gs.getValue().toString();

            String valueeeee=After_Ss.getValue().toString();

            int d1=Integer.parseInt(valuee);
            int f1=Integer.parseInt(valueee);
            int g1=Integer.parseInt(valueeee);
            int h1=Integer.parseInt(valueeeee);

            pst.setInt(4,d1);

            pst.setInt(5,f1);
            pst.setInt(6,g1);
            pst.setInt(7,h1);

            JOptionPane.showMessageDialog(null,"Data Added Successfully");

            //   this.setVisible(false); //this will close frame i.e. NewJFrame

            //new AfterExam().setVisible(true);
            //AfterExam main = new AfterExam();

            //    main.setVisible(true);
            //   this.dispose();

            pst.execute();

        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null, e);
        }
        finally{
            try{
                pst.close();
                rs.close();
                conn.close();
                sqlite3_finalize();

            }
            catch(Exception e){

            }
        }
        String sqli="select SALARY_ID from FinalReport where SALARY_ID=?";
        String aq=AfterSalary.getSelectedItem().toString();
        String aaa=AfterType.getSelectedItem().toString();

        if (aaa=="Internal"){

            try{

                pst=conn.prepareStatement(sqli);

                String valuee12=AfterSalary.getSelectedItem().toString();
                pst.setString(1,valuee12);

                rs=pst.executeQuery();
                if(rs.next()){

                    //  pst.setString(1, AfterSalary.getText());
                    //  pst.setString(2, AfterName.getText());

                    //String val=AfterType.getSelectedItem().toString();

                    String aa=AfterEssays.getValue().toString();

                    String bb=AfterMcqs.getValue().toString();

                    String cc=After_Gs.getValue().toString();

                    String dd=After_Ss.getValue().toString();

                    int a1=Integer.parseInt(aa);
                    int a2=Integer.parseInt(bb);
                    int a3=Integer.parseInt(cc);
                    int a4=Integer.parseInt(dd);

                    int Internal_Essay= ((a1*100));
                    int Internal_MCQ=((a2*40));
                    int Internal_Dissa_Gen=((a3*400));
                    int Internal_Dissa_Spe=((a4*600));
                    int Internal_Total=(Internal_Essay+Internal_MCQ+Internal_Dissa_Gen+Internal_Dissa_Spe);
                    //pst.setInt(14,Internal_Total);
                    // pst.setInt(1,Internal_Total);
                    pst.execute();
                    String sqliii = "SELECT TOTAL FROM FinalReport  WHERE SALARY_ID='"+aq+"'";
                    pst=conn.prepareStatement(sqliii);
                    rs=pst.executeQuery();
                    int to=rs.getInt("TOTAL");
                    int TOTAL=(Internal_Total+to);

                    String sqlii="update FinalReport set INTERNAL_EXAMINER='"+Internal_Total+"',TOTAL='"+TOTAL+"' WHERE SALARY_ID='"+aq+"'";

                    pst=conn.prepareStatement(sqlii);
                    pst.execute();
                    pst.close();
                    rs.close();
                    conn.close();
    //                this.setVisible(false);
      //              AfterExam d=new AfterExam();
       //             d.setVisible(true);

                }

                else{
                    String sql="Insert into FinalReport (SALARY_ID,SUBJECT_AND_NAME_OF_THE_STAFF,SETTER,MODERATOR,TYPING,INTERNAL_EXAMINER,EXTERNAL_EXAMINER,SUPERVISOR,INVIGILATOR,HALL_ATTENDANT,DUPLICATING_MACHINE_OPERATOR,PACKETING_AND_SEALING,TEACHER_FOR_PRINTING_SUPERVISION,TOTAL) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                    pst=conn.prepareStatement(sql);
                    String valuee13=AfterSalary.getSelectedItem().toString();
                    pst.setString(1,valuee13);

                    pst.setString(2, AfterName.getText());

                    String val=AfterType.getSelectedItem().toString();

                    String aa=AfterEssays.getValue().toString();

                    String bb=AfterMcqs.getValue().toString();

                    String cc=After_Gs.getValue().toString();

                    String dd=After_Ss.getValue().toString();

                    int a1=Integer.parseInt(aa);
                    int a2=Integer.parseInt(bb);
                    int a3=Integer.parseInt(cc);
                    int a4=Integer.parseInt(dd);

                    int Internal_Essay= ((a1*100));
                    int Internal_MCQ=((a2*40));
                    int Internal_Dissa_Gen=((a3*400));
                    int Internal_Dissa_Spe=((a4*600));
                    int Internal_Total=(Internal_Essay+Internal_MCQ+Internal_Dissa_Gen+Internal_Dissa_Spe);
                    pst.setInt(14,Internal_Total);
                    pst.setInt(6,Internal_Total);
                    pst.execute();
                    conn.close();

    //                this.setVisible(false);
     //               AfterExam d=new AfterExam();
           //        d.setVisible(true);

                }

            }

            catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
            finally{
                try{
                    pst.close();
                    rs.close();
                    conn.close();
                    sqlite3_finalize();

                }
                catch(Exception e){

                }
            }
        }
    }//GEN-LAST:event_afterSubmitActionPerformed

    private void afterHomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_afterHomeActionPerformed
        // TODO add your handling code here:
  //      new DutySelection().setVisible(true);
    //    this.setVisible(false);
    }//GEN-LAST:event_afterHomeActionPerformed

    private void AfterSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AfterSalaryActionPerformed

        String  selectedValue=AfterSalary.getSelectedItem().toString();
        String ttt = "SELECT Employee_Name FROM Employee  WHERE Employee_Id='"+selectedValue+"'";
        try {
            pst=conn.prepareStatement(ttt);
            rs=pst.executeQuery();
            String yy=rs.getString("Employee_Name");

            AfterName.setText(yy);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }          // TODO add your handling code here:
    }//GEN-LAST:event_AfterSalaryActionPerformed

    private void pp5mouseclicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pp5mouseclicked


 
        if(evt.getSource()==pp5){
        
        p1.setVisible(false);
        p2.setVisible(false);
        p3.setVisible(false);
        p4.setVisible(true);
        
      }        // TODO add your handling code here:
    }//GEN-LAST:event_pp5mouseclicked

    private void pp5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pp5MouseEntered
        // TODO add your handling code here:
        pp5.setBackground(new Color(135,135,135));
    }//GEN-LAST:event_pp5MouseEntered

    private void pp5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pp5MouseExited
        // TODO add your handling code here:
          pp5.setBackground(new Color(85,65,100));
    }//GEN-LAST:event_pp5MouseExited

    private void exitPanelMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitPanelMouseEntered
        // TODO add your handling code here:
        
        setColor();
    }//GEN-LAST:event_exitPanelMouseEntered

    private void exitPanelMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitPanelMouseExited
releaseColor();
    }//GEN-LAST:event_exitPanelMouseExited

    private void exitPanelMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_exitPanelMouseClicked

System.exit(0);        // TODO add your handling code here:
    }//GEN-LAST:event_exitPanelMouseClicked

    private void printtActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_printtActionPerformed
        // TODO add your handling code here:
        MessageFormat header =new MessageFormat("Final salaery Report");
        MessageFormat footer =new MessageFormat("page{0,number,integer}");

        try {
            FinalResult.print();
        } catch (PrinterException e) {
        }
    }//GEN-LAST:event_printtActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
       

    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
        int row=FinalResult.getSelectedRow();
        String cell=FinalResult.getModel().getValueAt(row,0).toString();
        String sql="DELETE FROM FinalReport where NUMBER = " +cell;
        try {
            pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Deleted Successfully");
            Update_Table();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);}
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        // TODO add your handling code here:
        Update_Table1();

    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        // TODO add your handling code here:
        Update_Table2();
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        // TODO add your handling code here:
        Update_Table3();
    }//GEN-LAST:event_jButton6ActionPerformed

    private void pp6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pp6MouseExited
        // TODO add your handling code here:
    }//GEN-LAST:event_pp6MouseExited

    private void pp6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pp6MouseEntered
        // TODO add your handling code here:
    }//GEN-LAST:event_pp6MouseEntered

    private void pp6mouseclicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pp6mouseclicked

        if(evt.getSource()==pp5){

            p1.setVisible(false);
            p2.setVisible(false);
            p3.setVisible(false);
            p4.setVisible(false);
            p5.setVisible(true);
        }

        // TODO add your handling code here:
    }//GEN-LAST:event_pp6mouseclicked

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
            java.util.logging.Logger.getLogger(panel_center.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(panel_center.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(panel_center.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(panel_center.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            @Override
            public void run() {
                new panel_center().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner AfterEssays;
    private javax.swing.JSpinner AfterEssays1;
    private javax.swing.JSpinner AfterMcqs;
    private javax.swing.JSpinner AfterMcqs1;
    private javax.swing.JTextField AfterName;
    private javax.swing.JTextField AfterName1;
    private javax.swing.JComboBox<String> AfterSalary;
    private javax.swing.JComboBox<String> AfterSalary1;
    private javax.swing.JComboBox<String> AfterType;
    private javax.swing.JComboBox<String> AfterType1;
    private javax.swing.JSpinner After_Gs;
    private javax.swing.JSpinner After_Gs1;
    private javax.swing.JSpinner After_Ss;
    private javax.swing.JTextField BeforeName;
    private javax.swing.JTextField BeforeName1;
    private javax.swing.JComboBox<String> BeforeSalary;
    private javax.swing.JComboBox<String> DayName;
    private javax.swing.JSpinner Dups;
    private javax.swing.JTable FinalResult;
    private javax.swing.JTable FinalResult1;
    private javax.swing.JPanel Full;
    private javax.swing.JSpinner Hall_Ps;
    private javax.swing.JSpinner Hall_Ts;
    private javax.swing.JSpinner Ing_Ps;
    private javax.swing.JSpinner Ing_Ts;
    private javax.swing.JSpinner Mod_1s;
    private javax.swing.JSpinner Mod_2s;
    private javax.swing.JSpinner Mod_3s;
    private javax.swing.JSpinner Mod_Mcqs;
    private javax.swing.JSpinner PackSeas;
    private javax.swing.JSpinner PrintSups;
    private javax.swing.JSpinner Setter_1s;
    private javax.swing.JSpinner Setter_2s;
    private javax.swing.JSpinner Setter_3s;
    private javax.swing.JSpinner Setter_Mcqs;
    private javax.swing.JSpinner Sup_Ps;
    private javax.swing.JSpinner Sup_Ts;
    private javax.swing.JSpinner Typ_1s;
    private javax.swing.JSpinner Typ_2s;
    private javax.swing.JSpinner Typ_3s;
    private javax.swing.JSpinner Typ_Mcq;
    private javax.swing.JTable ViewDatabase;
    private javax.swing.JButton afterCancel;
    private javax.swing.JButton afterCancel1;
    private javax.swing.JButton afterHome;
    private javax.swing.JButton afterHome1;
    private javax.swing.JButton afterSubmit;
    private javax.swing.JButton afterSubmit1;
    private javax.swing.JButton beforeCancel;
    private javax.swing.JButton beforeHome;
    private javax.swing.JButton beforeSubmit;
    private javax.swing.JPanel exitPanel;
    private javax.swing.JLabel gbgb;
    private javax.swing.JLabel gbgb1;
    private javax.swing.JLabel gbgb2;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel20;
    private javax.swing.JLabel jLabel21;
    private javax.swing.JLabel jLabel22;
    private javax.swing.JLabel jLabel23;
    private javax.swing.JLabel jLabel24;
    private javax.swing.JLabel jLabel25;
    private javax.swing.JLabel jLabel26;
    private javax.swing.JLabel jLabel27;
    private javax.swing.JLabel jLabel28;
    private javax.swing.JLabel jLabel29;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel30;
    private javax.swing.JLabel jLabel31;
    private javax.swing.JLabel jLabel32;
    private javax.swing.JLabel jLabel33;
    private javax.swing.JLabel jLabel34;
    private javax.swing.JLabel jLabel35;
    private javax.swing.JLabel jLabel36;
    private javax.swing.JLabel jLabel37;
    private javax.swing.JLabel jLabel38;
    private javax.swing.JLabel jLabel39;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel40;
    private javax.swing.JLabel jLabel41;
    private javax.swing.JLabel jLabel42;
    private javax.swing.JLabel jLabel43;
    private javax.swing.JLabel jLabel44;
    private javax.swing.JLabel jLabel45;
    private javax.swing.JLabel jLabel46;
    private javax.swing.JLabel jLabel47;
    private javax.swing.JLabel jLabel48;
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JSeparator jSeparator1;
    private javax.swing.JPanel p1;
    private javax.swing.JPanel p2;
    private javax.swing.JPanel p3;
    private javax.swing.JPanel p4;
    private javax.swing.JPanel p5;
    private javax.swing.JPanel panel_center;
    private javax.swing.JPanel pp1;
    private javax.swing.JPanel pp2;
    private javax.swing.JPanel pp3;
    private javax.swing.JPanel pp5;
    private javax.swing.JPanel pp6;
    private javax.swing.JButton printt;
    // End of variables declaration//GEN-END:variables

    private void sqlite3_finalize() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
