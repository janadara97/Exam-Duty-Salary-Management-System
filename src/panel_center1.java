
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.MessageFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.event.PrintJobEvent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.Timer;
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
public final class panel_center1 extends javax.swing.JFrame {
 
    Connection conn=null;   
    ResultSet rs =null; 
    PreparedStatement pst=null;
    
     
    
    public panel_center1(String par) 
    {
        
        initComponents();
       
        conn=db.java_db();
         display.setText(par);
       setExtendedState(getExtendedState() | JFrame.MAXIMIZED_BOTH);
       fillcombo();
       fillcomboSub();
       Update_Table();
       defValue();
       showDate();
       showTime();
       
       day.setVisible(false);
        after.setVisible(false);
        before.setVisible(false);
        welcome.setVisible(true);
        final1.setVisible(false);
        database.setVisible(false);
        rates.setVisible(false);
        changep.setVisible(false);
        userp.setVisible(false);
      Update_subTable();
        
       
       
       
        
    }
    
    public void showDate(){
    Date d=new Date ();
    SimpleDateFormat s=new SimpleDateFormat("dd-MM-yyyy");
    date.setText(s.format(d));
    
    }

    public void showTime() {
    new Timer(0,new ActionListener(){
        @Override
        public void actionPerformed(ActionEvent ae) {
          Date d=new Date ();
    SimpleDateFormat s=new SimpleDateFormat("hh:mm:ss a");
    time.setText(s.format(d));  
        }
    }
    
    
    
    ).start();
    
    
    }
    
  //Change and show salary rates
 public void defValue(){
       try{ 
           
           //String Rates= "SELECT Setter_Essay_1, Setter_Essay_2, Setter_Essay_3, Setter_Mcq, Mod_Essay_1, Mod_Essay_2, Mod_Essay_3, Mod_Mcq,Typing, Duplicating_Machine_Operator, Packeting_And_Sealing, Teacher_For_Printing_Supervision, Supervisor, Invigilator, Hall_Atte, Internal_Essasy, Internal_Mcq, External_Essay, Internal_Diss_Gen, External_Diss_Gen, Internal_Diss_Spe, External_Diss_Spe FROM Salary_Rates";
           String Rates= "SELECT*FROM Salary_Rates";
       
       
       pst=conn.prepareStatement(Rates);
       rs=pst.executeQuery();
        
     if(rs.next()){   
       String s1=rs.getString("Setter_Essay_1");
       String s2=rs.getString("Setter_Essay_2");
       String s3=rs.getString("Setter_Essay_3");
       String sm=rs.getString("Setter_Mcq");
       String m1=rs.getString("Mod_Essay_1");
       String m2=rs.getString("Mod_Essay_2");
       String m3=rs.getString("Mod_Essay_3");
       String mm=rs.getString("Mod_Mcq");
       String ty=rs.getString("Typing");
       String dm=rs.getString("Duplicating_Machine_Operator");
       String ps=rs.getString("Packeting_And_Sealing");
       String tp=rs.getString("Teacher_For_Printing_Supervision");
       String su=rs.getString("Supervisor");
       String in=rs.getString("Invigilator");
       String hl=rs.getString("Hall_Atte");
       String is=rs.getString("Internal_Essay");
       String im=rs.getString("Internal_Mcq");
       String es=rs.getString("External_Essay");
       String idg=rs.getString("Internal_Diss_Gen");
       String ids=rs.getString("External_Diss_Gen");
       String edg=rs.getString("Internal_Diss_Spe");
       String eds=rs.getString("External_Diss_Spe");
       
   
       //hide the text fields in change rates
   setter1Hr.setEditable(false);
   setter2Hr.setEditable(false);
   setter3Hr.setEditable(false);
   setterMCQ.setEditable(false);
   moderator1Hr.setEditable(false);
   moderator2Hr.setEditable(false);
   moderator3Hr.setEditable(false);
   moderatorMCQ.setEditable(false);
   
   typing.setEditable(false);
   duplicate.setEditable(false);
   packeting.setEditable(false);
   supervision.setEditable(false);
   supervisor.setEditable(false);
   invigilator.setEditable(false);
   hallAttendance.setEditable(false);
   markingInternalEssay.setEditable(false);
   markingInternalMCQ.setEditable(false);
   
   markingExternalEssay.setEditable(false);
   internalDissertionGeneral.setEditable(false);
   ExternalDissertionGeneral.setEditable(false);
   InternalDissertionSpecial.setEditable(false);
  ExternalDissertionSpecial.setEditable(false);
    
  //set rates to the text fields
   setter1Hr.setText(s1);
   setter2Hr.setText(s2);
   setter3Hr.setText(s3);
   setterMCQ.setText(sm);
   moderator1Hr.setText(m1);
   moderator2Hr.setText(m2);
   moderator3Hr.setText(m3);
   moderatorMCQ.setText(mm);
   
   typing.setText(ty);
   duplicate.setText(dm);
   packeting.setText(ps);
   supervision.setText(tp);
   supervisor.setText(su);
   invigilator.setText(in);
   hallAttendance.setText(hl);
   markingInternalEssay.setText(is);
   markingInternalMCQ.setText(im);
   
   markingExternalEssay.setText(es);
   internalDissertionGeneral.setText(idg);
   ExternalDissertionGeneral.setText(ids);
   InternalDissertionSpecial.setText(edg);
   ExternalDissertionSpecial.setText(eds);
  
    
     }
       
       
       }
       catch(Exception e) {
       
       }
        
    }
 
 
    
   private void fillcombo(){

        try {
            String abc="select * from Employee";
            pst=conn.prepareStatement(abc);
            rs=pst.executeQuery();
            while(rs.next()){
            String name=rs.getString("Employee_Id");
            AfterSalary.addItem(name);
            DaySalary.addItem(name);
            BeforeSalary.addItem(name);
            
            }
        } catch (Exception e) {
            
         JOptionPane.showMessageDialog(null, e);
        }
        
   }
   
   //fillcombo for subjects
   private void fillcomboSub(){

        try {
            String abc="select * from Subjects";
            pst=conn.prepareStatement(abc);
            rs=pst.executeQuery();
            while(rs.next()){
            String name=rs.getString("Subject_Name");
            AfterSubject1.addItem(name);
            BeforeSubject1.addItem(name);
            DaySubject1.addItem(name);
            
            }
        } catch (Exception e) {
            
         JOptionPane.showMessageDialog(null, e);
        }
        
   }
   
 
   
   private void Update_Table(){
    try{
    String sql="select * from FinalReport";
    pst=conn.prepareStatement(sql);
    rs=pst.executeQuery(); 
    FinalResult.setModel(DbUtils.resultSetToTableModel(rs));
    
    }
    catch(Exception e){
   JOptionPane.showMessageDialog(null, e);
    }
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
    JOptionPane.showMessageDialog(null, e);
    }
    }
private void Update_Table2(){
    try{
    String sql="select * from ExamDay";
    pst=conn.prepareStatement(sql);
    rs=pst.executeQuery(); 
    
    ViewDatabase.setModel(DbUtils.resultSetToTableModel(rs));
    
    }
    catch(Exception e){
    JOptionPane.showMessageDialog(null, e);
    }
    }
private void Update_Table3(){
    try{
    String sql="select * from AfterExam";
    pst=conn.prepareStatement(sql);
    rs=pst.executeQuery(); 
    
    ViewDatabase.setModel(DbUtils.resultSetToTableModel(rs));
    
    }
    catch(Exception e){
    JOptionPane.showMessageDialog(null, e);
    }
    }

//update subject table

private void Update_subTable(){
    try{
    String sql="select * from Subjects";
    pst=conn.prepareStatement(sql);
    rs=pst.executeQuery(); 
    
    subTable.setModel(DbUtils.resultSetToTableModel(rs));
    
    }
    catch(Exception e){
    JOptionPane.showMessageDialog(null, e);
    }
    }
  
private void Update_Tableuser(){
    try{
    String sql="select * from login1";
    pst=conn.prepareStatement(sql);
    rs=pst.executeQuery(); 
    usertable.setModel(DbUtils.resultSetToTableModel(rs));
    
    }
    catch(Exception e){
   JOptionPane.showMessageDialog(null, e);
    }
    }

  private void Update_CuTable(){
      String finalIn=FinalIntake.getSelectedItem().toString();
      String finalSem=FinalSemester.getSelectedItem().toString();
      
     if(finalSem=="All" && finalIn=="All"){
         String sql="select * from FinalReport";
          try {
              pst=conn.prepareStatement(sql);
               rs=pst.executeQuery(); 
         FinalResult.setModel(DbUtils.resultSetToTableModel(rs));
          } catch (SQLException ex) {
              Logger.getLogger(panel_center1.class.getName()).log(Level.SEVERE, null, ex);
          }
   
     }
     else if (finalSem=="All"){
     
     try{
    String sqlr="select * from FinalReport where INTAKE='"+finalIn+"'";
    pst=conn.prepareStatement(sqlr);
    rs=pst.executeQuery(); 
    FinalResult.setModel(DbUtils.resultSetToTableModel(rs));
    
    }
    catch(Exception e){
   JOptionPane.showMessageDialog(null, e);
    }
     }
     else if(finalIn=="All"){
      try{
    String sqlr="select * from FinalReport where SEMESTER='"+finalSem+"'";
    pst=conn.prepareStatement(sqlr);
    rs=pst.executeQuery(); 
    FinalResult.setModel(DbUtils.resultSetToTableModel(rs));
    
    }
    catch(Exception e){
   JOptionPane.showMessageDialog(null, e);
    }
     
     }
     else {
      try{
    String sqlr="select * from FinalReport where INTAKE='"+finalIn+"' and SEMESTER='"+finalSem+"'";
    pst=conn.prepareStatement(sqlr);
    rs=pst.executeQuery(); 
    FinalResult.setModel(DbUtils.resultSetToTableModel(rs));
    
    }
    catch(Exception e){
   JOptionPane.showMessageDialog(null, e);
    }
     
     
     }
    
    }
//clear fields in before exam
  public void clearFields1(){
  BeforeIntake.setSelectedItem(1);
  
  }
   
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        bindingGroup = new org.jdesktop.beansbinding.BindingGroup();

        topBar = new javax.swing.JPanel();
        time = new javax.swing.JLabel();
        date = new javax.swing.JLabel();
        after = new javax.swing.JLabel();
        welcome = new javax.swing.JLabel();
        day = new javax.swing.JLabel();
        before = new javax.swing.JLabel();
        final1 = new javax.swing.JLabel();
        database = new javax.swing.JLabel();
        rates = new javax.swing.JLabel();
        userp = new javax.swing.JLabel();
        changep = new javax.swing.JLabel();
        subAdd = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        display = new javax.swing.JLabel();
        jButton7 = new javax.swing.JButton();
        sideBar = new javax.swing.JPanel();
        jSeparator1 = new javax.swing.JSeparator();
        pp3 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        jLabel52 = new javax.swing.JLabel();
        pp6 = new javax.swing.JPanel();
        gbgb1 = new javax.swing.JLabel();
        jLabel39 = new javax.swing.JLabel();
        pp1 = new javax.swing.JPanel();
        gbgb = new javax.swing.JLabel();
        jLabel53 = new javax.swing.JLabel();
        pp2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jLabel54 = new javax.swing.JLabel();
        pp5 = new javax.swing.JPanel();
        gbgb2 = new javax.swing.JLabel();
        jLabel49 = new javax.swing.JLabel();
        pphome = new javax.swing.JPanel();
        jLabel50 = new javax.swing.JLabel();
        jLabel51 = new javax.swing.JLabel();
        beforeExam = new javax.swing.JPanel();
        jScrollPane4 = new javax.swing.JScrollPane();
        jPanel3 = new javax.swing.JPanel();
        BeforeSalary = new javax.swing.JComboBox<>();
        Setter_1s = new javax.swing.JSpinner();
        jLabel28 = new javax.swing.JLabel();
        jLabel26 = new javax.swing.JLabel();
        Mod_3s = new javax.swing.JSpinner();
        Typ_3s = new javax.swing.JSpinner();
        Setter_2s = new javax.swing.JSpinner();
        jLabel10 = new javax.swing.JLabel();
        PackSeas = new javax.swing.JSpinner();
        Mod_2s = new javax.swing.JSpinner();
        jLabel27 = new javax.swing.JLabel();
        Setter_3s = new javax.swing.JSpinner();
        Typ_2s = new javax.swing.JSpinner();
        jLabel21 = new javax.swing.JLabel();
        Typ_1s = new javax.swing.JSpinner();
        PrintSups = new javax.swing.JSpinner();
        Setter_Mcqs = new javax.swing.JSpinner();
        jLabel22 = new javax.swing.JLabel();
        Dups = new javax.swing.JSpinner();
        jLabel5 = new javax.swing.JLabel();
        Typ_Mcq = new javax.swing.JSpinner();
        Mod_1s = new javax.swing.JSpinner();
        Mod_Mcqs = new javax.swing.JSpinner();
        BeforeName1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        jLabel29 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel25 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        BeforeIntake = new javax.swing.JComboBox<>();
        BeforeSemester = new javax.swing.JComboBox<>();
        Semester1 = new javax.swing.JLabel();
        Intake1 = new javax.swing.JLabel();
        BeforeSubject = new javax.swing.JLabel();
        BeforeSubject1 = new javax.swing.JComboBox<>();
        kButton2 = new keeptoo.KButton();
        dayExam = new javax.swing.JPanel();
        jScrollPane3 = new javax.swing.JScrollPane();
        jPanel1 = new javax.swing.JPanel();
        DaySubject = new javax.swing.JLabel();
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
        DaySalary = new javax.swing.JComboBox<>();
        BeforeName = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        Intake = new javax.swing.JLabel();
        Semester = new javax.swing.JLabel();
        DaySemester = new javax.swing.JComboBox<>();
        DayIntake = new javax.swing.JComboBox<>();
        jLabel15 = new javax.swing.JLabel();
        DaySubject1 = new javax.swing.JComboBox<>();
        kButton1 = new keeptoo.KButton();
        afterExam = new javax.swing.JPanel();
        jScrollPane5 = new javax.swing.JScrollPane();
        jPanel4 = new javax.swing.JPanel();
        jLabel30 = new javax.swing.JLabel();
        AfterSubject = new javax.swing.JLabel();
        jLabel32 = new javax.swing.JLabel();
        jLabel33 = new javax.swing.JLabel();
        jLabel35 = new javax.swing.JLabel();
        jLabel37 = new javax.swing.JLabel();
        jLabel38 = new javax.swing.JLabel();
        After_Ss = new javax.swing.JSpinner();
        After_Gs = new javax.swing.JSpinner();
        AfterMcqs = new javax.swing.JSpinner();
        AfterEssays = new javax.swing.JSpinner();
        AfterType = new javax.swing.JComboBox<>();
        AfterName = new javax.swing.JTextField();
        jLabel42 = new javax.swing.JLabel();
        AfterSalary = new javax.swing.JComboBox<>();
        AfterIntake = new javax.swing.JComboBox<>();
        Intake2 = new javax.swing.JLabel();
        Semester2 = new javax.swing.JLabel();
        AfterSubject1 = new javax.swing.JComboBox<>();
        jLabel24 = new javax.swing.JLabel();
        AfterSemester1 = new javax.swing.JComboBox<>();
        kButton3 = new keeptoo.KButton();
        finalReport = new javax.swing.JPanel();
        jScrollPane2 = new javax.swing.JScrollPane();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane7 = new javax.swing.JScrollPane();
        FinalResult = new javax.swing.JTable();
        FinalIntake = new javax.swing.JComboBox<>();
        FinalSemester = new javax.swing.JComboBox<>();
        kButton4 = new keeptoo.KButton();
        kButton5 = new keeptoo.KButton();
        Databases = new javax.swing.JPanel();
        jScrollPane6 = new javax.swing.JScrollPane();
        jPanel6 = new javax.swing.JPanel();
        jScrollPane8 = new javax.swing.JScrollPane();
        ViewDatabase = new javax.swing.JTable();
        kButton6 = new keeptoo.KButton();
        kButton7 = new keeptoo.KButton();
        kButton8 = new keeptoo.KButton();
        Welcome = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jPanel7 = new javax.swing.JPanel();
        kButton13 = new keeptoo.KButton();
        kButton16 = new keeptoo.KButton();
        kButton17 = new keeptoo.KButton();
        kButton18 = new keeptoo.KButton();
        Rates = new javax.swing.JPanel();
        jScrollPane9 = new javax.swing.JScrollPane();
        jPanel8 = new javax.swing.JPanel();
        jLabel16 = new javax.swing.JLabel();
        jLabel23 = new javax.swing.JLabel();
        jLabel31 = new javax.swing.JLabel();
        jLabel36 = new javax.swing.JLabel();
        jLabel40 = new javax.swing.JLabel();
        jLabel41 = new javax.swing.JLabel();
        jLabel43 = new javax.swing.JLabel();
        jLabel44 = new javax.swing.JLabel();
        jLabel45 = new javax.swing.JLabel();
        jLabel46 = new javax.swing.JLabel();
        jLabel47 = new javax.swing.JLabel();
        jLabel56 = new javax.swing.JLabel();
        jLabel57 = new javax.swing.JLabel();
        jLabel58 = new javax.swing.JLabel();
        jLabel59 = new javax.swing.JLabel();
        jLabel60 = new javax.swing.JLabel();
        jLabel61 = new javax.swing.JLabel();
        jLabel62 = new javax.swing.JLabel();
        jLabel63 = new javax.swing.JLabel();
        jLabel64 = new javax.swing.JLabel();
        jLabel65 = new javax.swing.JLabel();
        jLabel66 = new javax.swing.JLabel();
        aa = new javax.swing.JLabel();
        setter1Hr = new javax.swing.JTextField();
        setter2Hr = new javax.swing.JTextField();
        setter3Hr = new javax.swing.JTextField();
        setterMCQ = new javax.swing.JTextField();
        moderator1Hr = new javax.swing.JTextField();
        moderator2Hr = new javax.swing.JTextField();
        moderator3Hr = new javax.swing.JTextField();
        moderatorMCQ = new javax.swing.JTextField();
        typing = new javax.swing.JTextField();
        duplicate = new javax.swing.JTextField();
        packeting = new javax.swing.JTextField();
        supervision = new javax.swing.JTextField();
        supervisor = new javax.swing.JTextField();
        invigilator = new javax.swing.JTextField();
        hallAttendance = new javax.swing.JTextField();
        markingInternalEssay = new javax.swing.JTextField();
        markingInternalMCQ = new javax.swing.JTextField();
        markingExternalEssay = new javax.swing.JTextField();
        internalDissertionGeneral = new javax.swing.JTextField();
        ExternalDissertionSpecial = new javax.swing.JTextField();
        setter1HrEd = new javax.swing.JCheckBox();
        setter2HrEd = new javax.swing.JCheckBox();
        setter3HrEd = new javax.swing.JCheckBox();
        setterMCQEd = new javax.swing.JCheckBox();
        moderator1HrEd = new javax.swing.JCheckBox();
        moderator2HrEd = new javax.swing.JCheckBox();
        moderator3HrEd = new javax.swing.JCheckBox();
        moderatorMCQEd = new javax.swing.JCheckBox();
        typingEd = new javax.swing.JCheckBox();
        duplicateEd = new javax.swing.JCheckBox();
        packetingEd = new javax.swing.JCheckBox();
        supervisionEd = new javax.swing.JCheckBox();
        supervisorEd = new javax.swing.JCheckBox();
        invigilatorEd = new javax.swing.JCheckBox();
        hallAttendanceEd = new javax.swing.JCheckBox();
        markingInternalEssayEd = new javax.swing.JCheckBox();
        markingInternalMCQEd = new javax.swing.JCheckBox();
        markingExternalEssayEd = new javax.swing.JCheckBox();
        dissertionGeneralEd = new javax.swing.JCheckBox();
        dissertionSpecialEd = new javax.swing.JCheckBox();
        InternalDissertionSpecial = new javax.swing.JTextField();
        ExternalDissertionGeneral = new javax.swing.JTextField();
        dissertionSpecialEd1 = new javax.swing.JCheckBox();
        dissertionSpecialEd2 = new javax.swing.JCheckBox();
        kButton9 = new keeptoo.KButton();
        User = new javax.swing.JPanel();
        jScrollPane10 = new javax.swing.JScrollPane();
        useradd = new javax.swing.JPanel();
        jScrollPane11 = new javax.swing.JScrollPane();
        usertable = new javax.swing.JTable();
        jLabel68 = new javax.swing.JLabel();
        jLabel69 = new javax.swing.JLabel();
        jLabel70 = new javax.swing.JLabel();
        jLabel71 = new javax.swing.JLabel();
        jLabel72 = new javax.swing.JLabel();
        password = new javax.swing.JTextField();
        username = new javax.swing.JTextField();
        usertype = new javax.swing.JComboBox<>();
        kButton12 = new keeptoo.KButton();
        kButton10 = new keeptoo.KButton();
        Change = new javax.swing.JPanel();
        jScrollPane12 = new javax.swing.JScrollPane();
        ChangeP = new javax.swing.JPanel();
        jLabel74 = new javax.swing.JLabel();
        changeuser = new javax.swing.JTextField();
        jLabel75 = new javax.swing.JLabel();
        jLabel76 = new javax.swing.JLabel();
        changecurrent = new javax.swing.JTextField();
        changenew = new javax.swing.JTextField();
        kButton11 = new keeptoo.KButton();
        addSubjects = new javax.swing.JPanel();
        jScrollPane13 = new javax.swing.JScrollPane();
        jPanel9 = new javax.swing.JPanel();
        jScrollPane14 = new javax.swing.JScrollPane();
        subTable = new javax.swing.JTable();
        jLabel4 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        addName = new javax.swing.JTextField();
        addCode = new javax.swing.JTextField();
        kButton14 = new keeptoo.KButton();
        kButton15 = new keeptoo.KButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        setMaximumSize(new java.awt.Dimension(1690, 7978));
        setPreferredSize(new java.awt.Dimension(2700, 2297));
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        topBar.setBackground(new java.awt.Color(72, 47, 112));

        org.jdesktop.beansbinding.Binding binding = org.jdesktop.beansbinding.Bindings.createAutoBinding(org.jdesktop.beansbinding.AutoBinding.UpdateStrategy.READ_WRITE, sideBar, org.jdesktop.beansbinding.ELProperty.create("${border}"), topBar, org.jdesktop.beansbinding.BeanProperty.create("border"));
        bindingGroup.addBinding(binding);

        topBar.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                topBarmouseclicked(evt);
            }
        });
        topBar.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        time.setFont(new java.awt.Font("Impact", 0, 20)); // NOI18N
        time.setForeground(new java.awt.Color(204, 204, 204));
        time.setText("Time");
        topBar.add(time, new org.netbeans.lib.awtextra.AbsoluteConstraints(1560, 60, -1, -1));

        date.setFont(new java.awt.Font("Impact", 0, 20)); // NOI18N
        date.setForeground(new java.awt.Color(204, 204, 204));
        date.setText("Date");
        topBar.add(date, new org.netbeans.lib.awtextra.AbsoluteConstraints(1560, 10, -1, -1));

        after.setBackground(new java.awt.Color(255, 255, 255));
        after.setFont(new java.awt.Font("Impact", 0, 88)); // NOI18N
        after.setForeground(new java.awt.Color(255, 255, 255));
        after.setText("Enter Details-After Exam");
        topBar.add(after, new org.netbeans.lib.awtextra.AbsoluteConstraints(200, 30, -1, -1));

        welcome.setBackground(new java.awt.Color(255, 255, 0));
        welcome.setFont(new java.awt.Font("Impact", 0, 88)); // NOI18N
        welcome.setForeground(new java.awt.Color(255, 255, 255));
        welcome.setText("Welcome to ExamDept");
        topBar.add(welcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, -1, -1));

        day.setBackground(new java.awt.Color(255, 255, 255));
        day.setFont(new java.awt.Font("Impact", 0, 88)); // NOI18N
        day.setForeground(new java.awt.Color(255, 255, 255));
        day.setText("Enter Details-Exam Day");
        topBar.add(day, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 20, -1, -1));

        before.setBackground(new java.awt.Color(255, 255, 255));
        before.setFont(new java.awt.Font("Impact", 0, 88)); // NOI18N
        before.setForeground(new java.awt.Color(255, 255, 255));
        before.setText("Enter Details-Before Exam");
        topBar.add(before, new org.netbeans.lib.awtextra.AbsoluteConstraints(230, 20, -1, -1));

        final1.setBackground(new java.awt.Color(255, 255, 255));
        final1.setFont(new java.awt.Font("Impact", 0, 88)); // NOI18N
        final1.setForeground(new java.awt.Color(255, 255, 255));
        final1.setText("View Final Results");
        topBar.add(final1, new org.netbeans.lib.awtextra.AbsoluteConstraints(420, 30, -1, -1));

        database.setBackground(new java.awt.Color(255, 255, 255));
        database.setFont(new java.awt.Font("Impact", 0, 88)); // NOI18N
        database.setForeground(new java.awt.Color(255, 255, 255));
        database.setText("View Databases");
        topBar.add(database, new org.netbeans.lib.awtextra.AbsoluteConstraints(213, 10, 940, -1));

        rates.setBackground(new java.awt.Color(255, 255, 255));
        rates.setFont(new java.awt.Font("Impact", 0, 88)); // NOI18N
        rates.setForeground(new java.awt.Color(255, 255, 255));
        rates.setText("Salary Rates");
        topBar.add(rates, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, -1, -1));

        userp.setBackground(new java.awt.Color(255, 255, 255));
        userp.setFont(new java.awt.Font("Impact", 0, 88)); // NOI18N
        userp.setForeground(new java.awt.Color(255, 255, 255));
        userp.setText("User's Settings");
        topBar.add(userp, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, -1, -1));

        changep.setBackground(new java.awt.Color(255, 255, 255));
        changep.setFont(new java.awt.Font("Impact", 0, 88)); // NOI18N
        changep.setForeground(new java.awt.Color(255, 255, 255));
        changep.setText("Change Password");
        topBar.add(changep, new org.netbeans.lib.awtextra.AbsoluteConstraints(440, 30, -1, -1));

        subAdd.setBackground(new java.awt.Color(255, 255, 0));
        subAdd.setFont(new java.awt.Font("Impact", 0, 88)); // NOI18N
        subAdd.setForeground(new java.awt.Color(255, 255, 255));
        subAdd.setText("Add Subjects");
        topBar.add(subAdd, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 30, -1, -1));

        jLabel1.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(204, 204, 204));
        jLabel1.setText("You are Logged in as -");
        topBar.add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(1190, 110, -1, -1));

        display.setFont(new java.awt.Font("Impact", 0, 24)); // NOI18N
        display.setForeground(new java.awt.Color(153, 153, 153));
        display.addPropertyChangeListener(new java.beans.PropertyChangeListener() {
            public void propertyChange(java.beans.PropertyChangeEvent evt) {
                displayPropertyChange(evt);
            }
        });
        topBar.add(display, new org.netbeans.lib.awtextra.AbsoluteConstraints(1450, 100, 80, 40));

        jButton7.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jButton7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_shutdown_26px.png"))); // NOI18N
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        topBar.add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(1560, 100, 50, 40));

        getContentPane().add(topBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(260, 0, 1710, 170));

        sideBar.setBackground(new java.awt.Color(72, 47, 112));
        sideBar.setMaximumSize(new java.awt.Dimension(1000, 2000));
        sideBar.setPreferredSize(new java.awt.Dimension(255, 589));

        jSeparator1.setPreferredSize(new java.awt.Dimension(50, 5));

        pp3.setBackground(new java.awt.Color(96, 61, 166));
        pp3.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pp5MouseClicked(evt);
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

        pp6.setBackground(new java.awt.Color(96, 61, 166));
        pp6.setPreferredSize(new java.awt.Dimension(205, 64));
        pp6.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pp5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pp6MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pp6MouseExited(evt);
            }
        });
        pp6.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        gbgb1.setBackground(new java.awt.Color(153, 153, 153));
        gbgb1.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        gbgb1.setForeground(new java.awt.Color(204, 204, 204));
        gbgb1.setText("View Database");
        pp6.add(gbgb1, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, 52));

        jLabel39.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_report_card_32px_2.png"))); // NOI18N
        pp6.add(jLabel39, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 80, 60));

        pp1.setBackground(new java.awt.Color(96, 61, 166));
        pp1.setPreferredSize(new java.awt.Dimension(205, 64));
        pp1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pp5MouseClicked(evt);
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

        pp2.setBackground(new java.awt.Color(96, 61, 166));
        pp2.setPreferredSize(new java.awt.Dimension(205, 64));
        pp2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pp5MouseClicked(evt);
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

        pp5.setBackground(new java.awt.Color(96, 61, 166));
        pp5.setPreferredSize(new java.awt.Dimension(205, 64));
        pp5.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pp5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pp5MouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pp5MouseExited(evt);
            }
        });
        pp5.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        gbgb2.setBackground(new java.awt.Color(153, 153, 153));
        gbgb2.setFont(new java.awt.Font("Arial Black", 0, 18)); // NOI18N
        gbgb2.setForeground(new java.awt.Color(204, 204, 204));
        gbgb2.setText("Final Results");
        pp5.add(gbgb2, new org.netbeans.lib.awtextra.AbsoluteConstraints(80, 10, -1, 52));

        jLabel49.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_report_card_32px_2.png"))); // NOI18N
        pp5.add(jLabel49, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 0, 80, 60));

        pphome.setBackground(new java.awt.Color(96, 61, 166));
        pphome.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                pphomepp5MouseClicked(evt);
            }
            public void mouseEntered(java.awt.event.MouseEvent evt) {
                pphomeMouseEntered(evt);
            }
            public void mouseExited(java.awt.event.MouseEvent evt) {
                pphomeMouseExited(evt);
            }
        });
        pphome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel50.setBackground(new java.awt.Color(204, 204, 204));
        jLabel50.setIcon(new javax.swing.ImageIcon(getClass().getResource("/images/icons8_purchase_order_52px_1.png"))); // NOI18N
        pphome.add(jLabel50, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 80, 75, 75));

        jLabel51.setBackground(new java.awt.Color(204, 204, 204));
        jLabel51.setFont(new java.awt.Font("Impact", 0, 36)); // NOI18N
        jLabel51.setForeground(new java.awt.Color(255, 255, 255));
        jLabel51.setText("EXAM DEPT");
        pphome.add(jLabel51, new org.netbeans.lib.awtextra.AbsoluteConstraints(50, 20, 182, -1));

        javax.swing.GroupLayout sideBarLayout = new javax.swing.GroupLayout(sideBar);
        sideBar.setLayout(sideBarLayout);
        sideBarLayout.setHorizontalGroup(
            sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideBarLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 233, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, sideBarLayout.createSequentialGroup()
                .addGroup(sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(pp3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(sideBarLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addGroup(sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(pp6, javax.swing.GroupLayout.PREFERRED_SIZE, 257, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(pp2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                                .addComponent(pp1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                                .addComponent(pp5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 257, Short.MAX_VALUE)
                                .addComponent(pphome, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                .addGap(33, 33, 33))
        );
        sideBarLayout.setVerticalGroup(
            sideBarLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(sideBarLayout.createSequentialGroup()
                .addComponent(pphome, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(148, 148, 148)
                .addComponent(pp2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pp3, javax.swing.GroupLayout.PREFERRED_SIZE, 62, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pp1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(51, 51, 51)
                .addComponent(pp5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pp6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7284, 7284, 7284))
        );

        getContentPane().add(sideBar, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 260, 7978));

        beforeExam.setBackground(new java.awt.Color(249, 249, 249));
        beforeExam.setMinimumSize(new java.awt.Dimension(1675, 950));
        beforeExam.setPreferredSize(new java.awt.Dimension(1790, 1500));
        beforeExam.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane4.setPreferredSize(new java.awt.Dimension(1790, 1500));

        jPanel3.setBackground(new java.awt.Color(249, 249, 249));
        jPanel3.setPreferredSize(new java.awt.Dimension(1800, 1500));

        BeforeSalary.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        BeforeSalary.setForeground(new java.awt.Color(151, 232, 122));
        BeforeSalary.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select The ID" }));
        BeforeSalary.setMinimumSize(new java.awt.Dimension(319, 51));
        BeforeSalary.setPreferredSize(new java.awt.Dimension(319, 51));
        BeforeSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BeforeSalaryActionPerformed(evt);
            }
        });

        Setter_1s.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Setter_1s.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel28.setBackground(new java.awt.Color(255, 255, 255));
        jLabel28.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel28.setText("Salary ID");

        jLabel26.setBackground(new java.awt.Color(255, 255, 255));
        jLabel26.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel26.setText("Essay type 03 hour");

        Mod_3s.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Mod_3s.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        Typ_3s.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Typ_3s.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        Setter_2s.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Setter_2s.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel10.setBackground(new java.awt.Color(255, 255, 255));
        jLabel10.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel10.setText("MCQ Script/Essay  01 hour");

        PackSeas.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        PackSeas.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        Mod_2s.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Mod_2s.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel27.setBackground(new java.awt.Color(255, 255, 255));
        jLabel27.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel27.setText("Name");

        Setter_3s.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Setter_3s.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        Typ_2s.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Typ_2s.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel21.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel21.setText("Setter");

        Typ_1s.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Typ_1s.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        PrintSups.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        PrintSups.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        Setter_Mcqs.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Setter_Mcqs.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel22.setBackground(new java.awt.Color(255, 255, 255));
        jLabel22.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel22.setText("Essay type 02 hour");

        Dups.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Dups.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        jLabel5.setBackground(new java.awt.Color(255, 255, 255));
        jLabel5.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel5.setText("Essay type 01 hour");

        Typ_Mcq.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Typ_Mcq.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        Mod_1s.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Mod_1s.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        Mod_Mcqs.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Mod_Mcqs.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        BeforeName1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        BeforeName1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BeforeName1ActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel11.setText("Typing ");

        jLabel29.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel29.setText("Moderater");

        jLabel13.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel13.setText("Packeting & sealing");

        jLabel25.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel25.setText("Printing supervision");

        jLabel12.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel12.setText("Duplicating machine operator");

        BeforeIntake.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        BeforeIntake.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select The Intake", "30", "31", "32", "33", "34", "35", "36" }));
        BeforeIntake.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BeforeIntakeActionPerformed(evt);
            }
        });

        BeforeSemester.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        BeforeSemester.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select The Semester", "1", "2", "3", "4", "5", "6", "7", "8" }));
        BeforeSemester.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BeforeSemesterActionPerformed(evt);
            }
        });

        Semester1.setBackground(new java.awt.Color(255, 255, 255));
        Semester1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        Semester1.setText("Semester");

        Intake1.setBackground(new java.awt.Color(255, 255, 255));
        Intake1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        Intake1.setText("Intake");

        BeforeSubject.setBackground(new java.awt.Color(255, 255, 255));
        BeforeSubject.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        BeforeSubject.setText("Subject");

        BeforeSubject1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        BeforeSubject1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select The Subject" }));
        BeforeSubject1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BeforeSubject1ActionPerformed(evt);
            }
        });

        kButton2.setText("Submit");
        kButton2.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        kButton2.setkEndColor(new java.awt.Color(176, 89, 235));
        kButton2.setkHoverEndColor(new java.awt.Color(255, 176, 244));
        kButton2.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton2.setkHoverStartColor(new java.awt.Color(72, 47, 112));
        kButton2.setkSelectedColor(new java.awt.Color(119, 53, 181));
        kButton2.setkStartColor(new java.awt.Color(72, 47, 112));
        kButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(131, 131, 131)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 440, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(71, 71, 71)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(PackSeas, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(Dups, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(139, 139, 139)
                                        .addComponent(kButton2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel22, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(211, 211, 211)
                                .addComponent(Setter_2s, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(160, 160, 160)
                                .addComponent(Mod_2s, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(160, 160, 160)
                                .addComponent(Typ_2s, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(209, 209, 209)
                                .addComponent(Setter_3s, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(162, 162, 162)
                                .addComponent(Mod_3s, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(160, 160, 160)
                                .addComponent(Typ_3s, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel10, javax.swing.GroupLayout.PREFERRED_SIZE, 420, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(91, 91, 91)
                                .addComponent(Setter_Mcqs, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(160, 160, 160)
                                .addComponent(Mod_Mcqs, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(160, 160, 160)
                                .addComponent(Typ_Mcq, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(201, 201, 201)
                                .addComponent(Setter_1s, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(160, 160, 160)
                                .addComponent(Mod_1s, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(160, 160, 160)
                                .addComponent(Typ_1s, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(511, 511, 511)
                                .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(100, 100, 100)
                                .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80)
                                .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Intake1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 170, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Semester1, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(BeforeSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 190, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(318, 318, 318)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(BeforeIntake, 0, 370, Short.MAX_VALUE)
                                    .addComponent(BeforeSubject1, 0, 370, Short.MAX_VALUE)
                                    .addComponent(BeforeName1)
                                    .addComponent(BeforeSalary, 0, 370, Short.MAX_VALUE)
                                    .addComponent(BeforeSemester, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(949, 949, 949)
                        .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(113, 113, 113)
                        .addComponent(PrintSups, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(338, 338, 338))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(BeforeIntake, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(Intake1, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(BeforeSemester, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Semester1))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BeforeSalary, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel28, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(jLabel27, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(42, 42, 42))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                        .addComponent(BeforeName1, javax.swing.GroupLayout.PREFERRED_SIZE, 58, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(26, 26, 26)))
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BeforeSubject1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(BeforeSubject, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(127, 127, 127)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(8, 8, 8)
                        .addComponent(jLabel21, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jLabel29, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Setter_1s, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Mod_1s, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Typ_1s, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(8, 8, 8)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(Setter_2s, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel22)
                    .addComponent(Mod_2s, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Typ_2s, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel26, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(11, 11, 11)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Setter_3s, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Mod_3s, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(15, 15, 15)
                        .addComponent(Typ_3s, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(15, 15, 15)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel10)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGap(14, 14, 14)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Setter_Mcqs, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Mod_Mcqs, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Typ_Mcq, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(68, 68, 68)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(PackSeas, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(43, 43, 43)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(Dups, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(kButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(40, 40, 40)
                                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(522, 522, 522))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel25, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGap(23, 23, 23)
                                .addComponent(PrintSups, javax.swing.GroupLayout.PREFERRED_SIZE, 30, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(628, 628, 628))))
        );

        jScrollPane4.setViewportView(jPanel3);

        beforeExam.add(jScrollPane4, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 20, 1670, 1260));

        getContentPane().add(beforeExam, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 150, 1710, 1060));

        dayExam.setPreferredSize(new java.awt.Dimension(1790, 1500));
        dayExam.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane3.setPreferredSize(new java.awt.Dimension(1790, 1500));

        jPanel1.setBackground(new java.awt.Color(249, 249, 249));
        jPanel1.setPreferredSize(new java.awt.Dimension(1800, 1500));

        DaySubject.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        DaySubject.setText("Subject ");

        jLabel18.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel18.setText("Name");

        jLabel19.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel19.setText("Supervisor");

        jLabel20.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel20.setText("Invigilator");

        jLabel7.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel7.setText("Hall Attendant");

        Sup_Ts.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Sup_Ts.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        Ing_Ts.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Ing_Ts.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        Hall_Ts.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Hall_Ts.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        Hall_Ps.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Hall_Ps.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        Ing_Ps.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Ing_Ps.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        Sup_Ps.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        Sup_Ps.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));

        DaySalary.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        DaySalary.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select The ID" }));
        DaySalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DaySalaryActionPerformed(evt);
            }
        });

        BeforeName.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        BeforeName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BeforeNameActionPerformed(evt);
            }
        });

        jLabel8.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel8.setText("Theory");

        jLabel9.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel9.setText("Practical");

        Intake.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        Intake.setText("Intake");

        Semester.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        Semester.setText("Semester");

        DaySemester.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        DaySemester.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select The Semester", "1", "2", "3", "4", "5", "6", "7", "8" }));
        DaySemester.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DaySemesterActionPerformed(evt);
            }
        });

        DayIntake.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        DayIntake.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select The Intake", "30", "31", "32", "33", "34", "35", "36" }));
        DayIntake.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DayIntakeActionPerformed(evt);
            }
        });

        jLabel15.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel15.setText("Salary ID");

        DaySubject1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        DaySubject1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select The Subject" }));
        DaySubject1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DaySubject1ActionPerformed(evt);
            }
        });

        kButton1.setText("Submit");
        kButton1.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        kButton1.setkBackGroundColor(new java.awt.Color(255, 255, 255));
        kButton1.setkEndColor(new java.awt.Color(176, 89, 235));
        kButton1.setkHoverEndColor(new java.awt.Color(255, 176, 244));
        kButton1.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton1.setkHoverStartColor(new java.awt.Color(72, 47, 112));
        kButton1.setkSelectedColor(new java.awt.Color(119, 53, 181));
        kButton1.setkStartColor(new java.awt.Color(72, 47, 112));
        kButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(156, 156, 156)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(310, 310, 310)
                        .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(180, 180, 180)
                        .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(749, 749, 749)
                        .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(Semester, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Intake, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(DaySubject, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                                        .addGap(9, 9, 9)
                                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 180, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 220, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 210, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(80, 80, 80)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Hall_Ts, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(210, 210, 210)
                                .addComponent(Hall_Ps, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(DayIntake, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DaySemester, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DaySubject1, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(DaySalary, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(BeforeName, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Sup_Ts, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Ing_Ts, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(210, 210, 210)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(Ing_Ps, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(Sup_Ps, javax.swing.GroupLayout.PREFERRED_SIZE, 130, javax.swing.GroupLayout.PREFERRED_SIZE))))))
                .addContainerGap(681, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DayIntake, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Intake, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(29, 29, 29)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DaySemester, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Semester))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 29, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DaySubject1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(DaySubject, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(DaySalary, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(BeforeName, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Sup_Ts, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Sup_Ps, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel20, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ing_Ts, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Ing_Ps, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(Hall_Ps, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(Hall_Ts, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(29, 29, 29)
                .addComponent(kButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(677, Short.MAX_VALUE))
        );

        jScrollPane3.setViewportView(jPanel1);

        dayExam.add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 20, 1670, 1070));

        getContentPane().add(dayExam, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 150, 1710, 1060));

        afterExam.setPreferredSize(new java.awt.Dimension(1790, 1500));
        afterExam.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane5.setPreferredSize(new java.awt.Dimension(1790, 1500));

        jPanel4.setBackground(new java.awt.Color(249, 249, 249));
        jPanel4.setMinimumSize(new java.awt.Dimension(32767, 32767));
        jPanel4.setPreferredSize(new java.awt.Dimension(1800, 1500));
        jPanel4.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel30.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel30.setText("MCQ");
        jPanel4.add(jLabel30, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 680, 190, 50));

        AfterSubject.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        AfterSubject.setText("Subject");
        jPanel4.add(AfterSubject, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 380, 210, 50));

        jLabel32.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel32.setText("Dissertation");
        jPanel4.add(jLabel32, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 790, 210, 50));

        jLabel33.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel33.setText("Type  ");
        jPanel4.add(jLabel33, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 480, 190, 50));

        jLabel35.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel35.setText("Salary ID");
        jPanel4.add(jLabel35, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 200, 190, 50));

        jLabel37.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel37.setText("Special");
        jPanel4.add(jLabel37, new org.netbeans.lib.awtextra.AbsoluteConstraints(1130, 780, 80, 30));

        jLabel38.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel38.setText("General");
        jPanel4.add(jLabel38, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 780, 90, 30));

        After_Ss.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        After_Ss.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jPanel4.add(After_Ss, new org.netbeans.lib.awtextra.AbsoluteConstraints(1280, 780, 180, 40));

        After_Gs.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        After_Gs.setModel(new javax.swing.SpinnerNumberModel(0, 0, null, 1));
        jPanel4.add(After_Gs, new org.netbeans.lib.awtextra.AbsoluteConstraints(850, 780, 160, 40));

        AfterMcqs.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        AfterMcqs.setModel(new javax.swing.SpinnerNumberModel());
        jPanel4.add(AfterMcqs, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 680, 200, 40));

        AfterEssays.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        AfterEssays.setModel(new javax.swing.SpinnerNumberModel());
        jPanel4.add(AfterEssays, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 580, 200, 40));

        AfterType.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        AfterType.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select ", "External", "Internal" }));
        AfterType.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AfterTypeActionPerformed(evt);
            }
        });
        jPanel4.add(AfterType, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 480, 260, 50));

        AfterName.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        AfterName.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AfterNameActionPerformed(evt);
            }
        });
        jPanel4.add(AfterName, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 300, 380, 50));

        jLabel42.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel42.setText("Essay  ");
        jPanel4.add(jLabel42, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 580, 210, 50));

        AfterSalary.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        AfterSalary.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select The ID" }));
        AfterSalary.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AfterSalaryActionPerformed(evt);
            }
        });
        jPanel4.add(AfterSalary, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 210, 390, 60));

        AfterIntake.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        AfterIntake.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select The Intake", "30", "31", "32", "33", "34", "35", "36" }));
        AfterIntake.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AfterIntakeActionPerformed(evt);
            }
        });
        jPanel4.add(AfterIntake, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 30, -1, -1));

        Intake2.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        Intake2.setText("Intake");
        jPanel4.add(Intake2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 40, -1, -1));

        Semester2.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        Semester2.setText("Semester");
        jPanel4.add(Semester2, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 120, -1, -1));

        AfterSubject1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        AfterSubject1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select The Subject" }));
        AfterSubject1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AfterSubject1ActionPerformed(evt);
            }
        });
        jPanel4.add(AfterSubject1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 390, -1, -1));

        jLabel24.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        jLabel24.setText("Name  ");
        jPanel4.add(jLabel24, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 300, 210, 50));

        AfterSemester1.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        AfterSemester1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select The Semester", "1", "2", "3", "4", "5", "6", "7", "8" }));
        AfterSemester1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AfterSemester1ActionPerformed(evt);
            }
        });
        jPanel4.add(AfterSemester1, new org.netbeans.lib.awtextra.AbsoluteConstraints(680, 120, -1, -1));

        kButton3.setText("Submit");
        kButton3.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        kButton3.setkEndColor(new java.awt.Color(176, 89, 235));
        kButton3.setkHoverEndColor(new java.awt.Color(255, 176, 244));
        kButton3.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton3.setkHoverStartColor(new java.awt.Color(72, 47, 112));
        kButton3.setkSelectedColor(new java.awt.Color(119, 53, 181));
        kButton3.setkStartColor(new java.awt.Color(72, 47, 112));
        kButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton3ActionPerformed(evt);
            }
        });
        jPanel4.add(kButton3, new org.netbeans.lib.awtextra.AbsoluteConstraints(540, 930, 170, 80));

        jScrollPane5.setViewportView(jPanel4);

        afterExam.add(jScrollPane5, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1670, 900));

        getContentPane().add(afterExam, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 150, 1710, 1060));

        finalReport.setPreferredSize(new java.awt.Dimension(1790, 1500));
        finalReport.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane2.setPreferredSize(new java.awt.Dimension(1790, 1500));

        jPanel5.setBackground(new java.awt.Color(249, 249, 249));
        jPanel5.setPreferredSize(new java.awt.Dimension(1800, 1500));

        FinalResult.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
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
        FinalResult.setGridColor(new java.awt.Color(255, 255, 255));
        FinalResult.setRowHeight(20);
        FinalResult.setSelectionBackground(new java.awt.Color(183, 130, 232));
        jScrollPane7.setViewportView(FinalResult);

        FinalIntake.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        FinalIntake.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Intake", "All", "31", "32", "33", "35", "36" }));
        FinalIntake.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                FinalIntakeItemStateChanged(evt);
            }
        });
        FinalIntake.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FinalIntakeActionPerformed(evt);
            }
        });

        FinalSemester.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        FinalSemester.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Semester", "All", "1", "2", "3", "4", "5", "6", "7", "8" }));
        FinalSemester.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                FinalSemesterItemStateChanged(evt);
            }
        });
        FinalSemester.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                FinalSemesterActionPerformed(evt);
            }
        });

        kButton4.setText("Delete");
        kButton4.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        kButton4.setkEndColor(new java.awt.Color(176, 89, 235));
        kButton4.setkHoverEndColor(new java.awt.Color(255, 176, 244));
        kButton4.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton4.setkHoverStartColor(new java.awt.Color(72, 47, 112));
        kButton4.setkSelectedColor(new java.awt.Color(119, 53, 181));
        kButton4.setkStartColor(new java.awt.Color(72, 47, 112));
        kButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton4ActionPerformed(evt);
            }
        });

        kButton5.setText("print");
        kButton5.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        kButton5.setkEndColor(new java.awt.Color(176, 89, 235));
        kButton5.setkHoverEndColor(new java.awt.Color(255, 176, 244));
        kButton5.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton5.setkHoverStartColor(new java.awt.Color(72, 47, 112));
        kButton5.setkSelectedColor(new java.awt.Color(119, 53, 181));
        kButton5.setkStartColor(new java.awt.Color(72, 47, 112));
        kButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(66, 66, 66)
                        .addComponent(FinalIntake, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(60, 60, 60)
                        .addComponent(FinalSemester, javax.swing.GroupLayout.PREFERRED_SIZE, 154, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(248, 248, 248)
                        .addComponent(kButton5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(380, 380, 380)
                        .addComponent(kButton4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 1653, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(147, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(39, 39, 39)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(FinalSemester, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(FinalIntake, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane7, javax.swing.GroupLayout.PREFERRED_SIZE, 578, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 58, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(678, 678, 678))
        );

        jScrollPane2.setViewportView(jPanel5);

        finalReport.add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1670, 900));

        getContentPane().add(finalReport, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 150, 1710, 1060));

        Databases.setMaximumSize(new java.awt.Dimension(3000, 6000));
        Databases.setMinimumSize(new java.awt.Dimension(1382, 304));
        Databases.setPreferredSize(new java.awt.Dimension(1790, 1500));
        Databases.setRequestFocusEnabled(false);
        Databases.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane6.setPreferredSize(new java.awt.Dimension(1790, 1500));

        jPanel6.setBackground(new java.awt.Color(249, 249, 249));
        jPanel6.setPreferredSize(new java.awt.Dimension(1800, 1500));

        ViewDatabase.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        ViewDatabase.setModel(new javax.swing.table.DefaultTableModel(
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
        ViewDatabase.setRowHeight(20);
        ViewDatabase.setSelectionBackground(new java.awt.Color(183, 130, 232));
        jScrollPane8.setViewportView(ViewDatabase);

        kButton6.setText("View Before Exam Database");
        kButton6.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        kButton6.setkEndColor(new java.awt.Color(176, 89, 235));
        kButton6.setkHoverEndColor(new java.awt.Color(255, 176, 244));
        kButton6.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton6.setkHoverStartColor(new java.awt.Color(72, 47, 112));
        kButton6.setkSelectedColor(new java.awt.Color(119, 53, 181));
        kButton6.setkStartColor(new java.awt.Color(72, 47, 112));
        kButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton6ActionPerformed(evt);
            }
        });

        kButton7.setText("View  After Exam Database");
        kButton7.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        kButton7.setkEndColor(new java.awt.Color(176, 89, 235));
        kButton7.setkHoverEndColor(new java.awt.Color(255, 176, 244));
        kButton7.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton7.setkHoverStartColor(new java.awt.Color(72, 47, 112));
        kButton7.setkSelectedColor(new java.awt.Color(119, 53, 181));
        kButton7.setkStartColor(new java.awt.Color(72, 47, 112));
        kButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton7ActionPerformed(evt);
            }
        });

        kButton8.setText("View Exam Day Database");
        kButton8.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        kButton8.setkEndColor(new java.awt.Color(176, 89, 235));
        kButton8.setkHoverEndColor(new java.awt.Color(255, 176, 244));
        kButton8.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton8.setkHoverStartColor(new java.awt.Color(72, 47, 112));
        kButton8.setkSelectedColor(new java.awt.Color(119, 53, 181));
        kButton8.setkStartColor(new java.awt.Color(72, 47, 112));
        kButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton8ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 1666, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addComponent(kButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 337, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(73, 73, 73)
                        .addComponent(kButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 470, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(67, 67, 67)
                        .addComponent(kButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(134, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(127, 127, 127)
                .addComponent(jScrollPane8, javax.swing.GroupLayout.PREFERRED_SIZE, 616, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(74, 74, 74)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(1, 1, 1)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(kButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(kButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(kButton8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(610, Short.MAX_VALUE))
        );

        jScrollPane6.setViewportView(jPanel6);

        Databases.add(jScrollPane6, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1670, 1290));

        getContentPane().add(Databases, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 150, 1760, 1060));
        Databases.getAccessibleContext().setAccessibleParent(Databases);

        Welcome.setPreferredSize(new java.awt.Dimension(1790, 1500));
        Welcome.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane1.setPreferredSize(new java.awt.Dimension(1790, 1500));

        jPanel7.setBackground(new java.awt.Color(249, 249, 249));
        jPanel7.setToolTipText("Admin1");
        jPanel7.setPreferredSize(new java.awt.Dimension(1780, 1399));

        kButton13.setText("Subjects");
        kButton13.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        kButton13.setkEndColor(new java.awt.Color(92, 204, 189));
        kButton13.setkHoverEndColor(new java.awt.Color(167, 235, 225));
        kButton13.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton13.setkHoverStartColor(new java.awt.Color(92, 204, 189));
        kButton13.setkSelectedColor(new java.awt.Color(2, 105, 91));
        kButton13.setkStartColor(new java.awt.Color(2, 105, 91));
        kButton13.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton13ActionPerformed(evt);
            }
        });

        kButton16.setText("Change My Password");
        kButton16.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        kButton16.setkEndColor(new java.awt.Color(92, 204, 189));
        kButton16.setkHoverEndColor(new java.awt.Color(167, 235, 225));
        kButton16.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton16.setkHoverStartColor(new java.awt.Color(92, 204, 189));
        kButton16.setkSelectedColor(new java.awt.Color(2, 105, 91));
        kButton16.setkStartColor(new java.awt.Color(2, 105, 91));
        kButton16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton16ActionPerformed(evt);
            }
        });

        kButton17.setText("Add/Remove User");
        kButton17.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        kButton17.setkEndColor(new java.awt.Color(92, 204, 189));
        kButton17.setkHoverEndColor(new java.awt.Color(167, 235, 225));
        kButton17.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton17.setkHoverStartColor(new java.awt.Color(92, 204, 189));
        kButton17.setkSelectedColor(new java.awt.Color(2, 105, 91));
        kButton17.setkStartColor(new java.awt.Color(2, 105, 91));
        kButton17.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton17ActionPerformed(evt);
            }
        });

        kButton18.setText("Change Salary Rates");
        kButton18.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        kButton18.setkEndColor(new java.awt.Color(92, 204, 189));
        kButton18.setkHoverEndColor(new java.awt.Color(167, 235, 225));
        kButton18.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton18.setkHoverStartColor(new java.awt.Color(92, 204, 189));
        kButton18.setkSelectedColor(new java.awt.Color(2, 105, 91));
        kButton18.setkStartColor(new java.awt.Color(2, 105, 91));
        kButton18.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton18ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(254, 254, 254)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(kButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(270, 270, 270)
                        .addComponent(kButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel7Layout.createSequentialGroup()
                        .addComponent(kButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(270, 270, 270)
                        .addComponent(kButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 370, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(516, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGap(114, 114, 114)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(191, 191, 191)
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(770, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(jPanel7);
        jPanel7.getAccessibleContext().setAccessibleDescription("");

        Welcome.add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1670, 900));
        jScrollPane1.getAccessibleContext().setAccessibleName("");

        getContentPane().add(Welcome, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 150, 1710, 1060));

        Rates.setMinimumSize(new java.awt.Dimension(1670, 900));
        Rates.setPreferredSize(new java.awt.Dimension(1790, 1500));
        Rates.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane9.setPreferredSize(new java.awt.Dimension(1790, 1500));

        jPanel8.setBackground(new java.awt.Color(249, 249, 249));
        jPanel8.setAutoscrolls(true);

        jLabel16.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel16.setText("Setter Essay 1 Hr");

        jLabel23.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel23.setText("Setter Essay 2 Hr");

        jLabel31.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel31.setText("Setter Essay 3 Hr");

        jLabel36.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel36.setText("Setter MCQ/Essay 1 Hr");

        jLabel40.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel40.setText("Moderator Essay 1 Hr");

        jLabel41.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel41.setText("Moderator Essay 2 Hr");

        jLabel43.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel43.setText("Moderator Essay 3 Hr");

        jLabel44.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel44.setText("Moderator MCQ/Essay 1 Hr");

        jLabel45.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel45.setText("Typing");

        jLabel46.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel46.setText("Duplicating Machine Operator");

        jLabel47.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel47.setText("Packeting & Sealing");

        jLabel56.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel56.setText("Teacher for Printing Supervision");

        jLabel57.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel57.setText("Supervisor");

        jLabel58.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel58.setText("Invigilator");

        jLabel59.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel59.setText("Hall Attendance");

        jLabel60.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel60.setText("Marking Internal Essay");

        jLabel61.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel61.setText("Marking Internal MCQ");

        jLabel62.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel62.setText("Marking External Essay");

        jLabel63.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel63.setText("Internal Dissertion-General");

        jLabel64.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel64.setText("External Dissertion-General");

        jLabel65.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel65.setText("External Dissertion-Special");

        jLabel66.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        jLabel66.setText("Internal Dissertion-Special");

        aa.setBackground(new java.awt.Color(102, 255, 102));
        aa.setForeground(new java.awt.Color(255, 255, 255));

        setter1Hr.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        setter2Hr.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        setter3Hr.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        setterMCQ.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        moderator1Hr.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        moderator2Hr.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        moderator3Hr.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        moderatorMCQ.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        typing.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        duplicate.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        packeting.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        supervision.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        supervisor.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        invigilator.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        hallAttendance.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        markingInternalEssay.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        markingInternalMCQ.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        markingExternalEssay.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        internalDissertionGeneral.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        internalDissertionGeneral.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                internalDissertionGeneralActionPerformed(evt);
            }
        });

        ExternalDissertionSpecial.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        setter1HrEd.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        setter1HrEd.setText("Edit");
        setter1HrEd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                setter1HrEdMouseClicked(evt);
            }
        });

        setter2HrEd.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        setter2HrEd.setText("Edit");
        setter2HrEd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                setter2HrEdMouseClicked(evt);
            }
        });

        setter3HrEd.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        setter3HrEd.setText("Edit");
        setter3HrEd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                setter3HrEdMouseClicked(evt);
            }
        });

        setterMCQEd.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        setterMCQEd.setText("Edit");
        setterMCQEd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                setterMCQEdMouseClicked(evt);
            }
        });

        moderator1HrEd.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        moderator1HrEd.setText("Edit");
        moderator1HrEd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                moderator1HrEdMouseClicked(evt);
            }
        });

        moderator2HrEd.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        moderator2HrEd.setText("Edit");
        moderator2HrEd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                moderator2HrEdMouseClicked(evt);
            }
        });

        moderator3HrEd.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        moderator3HrEd.setText("Edit");
        moderator3HrEd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                moderator3HrEdMouseClicked(evt);
            }
        });

        moderatorMCQEd.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        moderatorMCQEd.setText("Edit");
        moderatorMCQEd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                moderatorMCQEdMouseClicked(evt);
            }
        });

        typingEd.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        typingEd.setText("Edit");
        typingEd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                typingEdMouseClicked(evt);
            }
        });

        duplicateEd.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        duplicateEd.setText("Edit");
        duplicateEd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                duplicateEdMouseClicked(evt);
            }
        });

        packetingEd.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        packetingEd.setText("Edit");
        packetingEd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                packetingEdMouseClicked(evt);
            }
        });

        supervisionEd.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        supervisionEd.setText("Edit");
        supervisionEd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                supervisionEdMouseClicked(evt);
            }
        });

        supervisorEd.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        supervisorEd.setText("Edit");
        supervisorEd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                supervisorEdMouseClicked(evt);
            }
        });

        invigilatorEd.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        invigilatorEd.setText("Edit");
        invigilatorEd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                invigilatorEdMouseClicked(evt);
            }
        });

        hallAttendanceEd.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        hallAttendanceEd.setText("Edit");
        hallAttendanceEd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                hallAttendanceEdMouseClicked(evt);
            }
        });

        markingInternalEssayEd.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        markingInternalEssayEd.setText("Edit");
        markingInternalEssayEd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                markingInternalEssayEdMouseClicked(evt);
            }
        });

        markingInternalMCQEd.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        markingInternalMCQEd.setText("Edit");
        markingInternalMCQEd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                markingInternalMCQEdMouseClicked(evt);
            }
        });

        markingExternalEssayEd.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        markingExternalEssayEd.setText("Edit");
        markingExternalEssayEd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                markingExternalEssayEdMouseClicked(evt);
            }
        });

        dissertionGeneralEd.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        dissertionGeneralEd.setText("Edit");
        dissertionGeneralEd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dissertionGeneralEdMouseClicked(evt);
            }
        });

        dissertionSpecialEd.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        dissertionSpecialEd.setText("Edit");
        dissertionSpecialEd.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dissertionSpecialEdMouseClicked(evt);
            }
        });

        InternalDissertionSpecial.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        ExternalDissertionGeneral.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N

        dissertionSpecialEd1.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        dissertionSpecialEd1.setText("Edit");
        dissertionSpecialEd1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dissertionSpecialEd1MouseClicked(evt);
            }
        });

        dissertionSpecialEd2.setFont(new java.awt.Font("Times New Roman", 0, 24)); // NOI18N
        dissertionSpecialEd2.setText("Edit");
        dissertionSpecialEd2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                dissertionSpecialEd2MouseClicked(evt);
            }
        });
        dissertionSpecialEd2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                dissertionSpecialEd2ActionPerformed(evt);
            }
        });

        kButton9.setText("Update");
        kButton9.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        kButton9.setkEndColor(new java.awt.Color(176, 89, 235));
        kButton9.setkHoverEndColor(new java.awt.Color(255, 176, 244));
        kButton9.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton9.setkHoverStartColor(new java.awt.Color(72, 47, 112));
        kButton9.setkSelectedColor(new java.awt.Color(119, 53, 181));
        kButton9.setkStartColor(new java.awt.Color(72, 47, 112));

        javax.swing.GroupLayout jPanel8Layout = new javax.swing.GroupLayout(jPanel8);
        jPanel8.setLayout(jPanel8Layout);
        jPanel8Layout.setHorizontalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel16)
                            .addComponent(jLabel23)
                            .addComponent(jLabel31)
                            .addComponent(jLabel36)
                            .addComponent(jLabel40)
                            .addComponent(jLabel41)
                            .addComponent(jLabel43)
                            .addComponent(jLabel44)
                            .addComponent(jLabel45)
                            .addComponent(jLabel46)
                            .addComponent(jLabel47)
                            .addComponent(jLabel56)
                            .addComponent(jLabel57)
                            .addComponent(jLabel58)
                            .addComponent(jLabel59)
                            .addComponent(jLabel60)
                            .addComponent(jLabel61)
                            .addComponent(jLabel62)
                            .addComponent(jLabel64)
                            .addComponent(jLabel63)
                            .addComponent(jLabel65)
                            .addComponent(jLabel66))
                        .addGap(112, 112, 112)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(moderator1Hr)
                            .addComponent(moderator2Hr)
                            .addComponent(moderator3Hr)
                            .addComponent(moderatorMCQ)
                            .addComponent(typing)
                            .addComponent(duplicate)
                            .addComponent(packeting)
                            .addComponent(supervision)
                            .addComponent(supervisor)
                            .addComponent(invigilator)
                            .addComponent(hallAttendance)
                            .addComponent(markingInternalEssay)
                            .addComponent(markingInternalMCQ)
                            .addComponent(markingExternalEssay)
                            .addComponent(internalDissertionGeneral)
                            .addComponent(ExternalDissertionSpecial)
                            .addComponent(setter2Hr)
                            .addComponent(setter3Hr)
                            .addComponent(setterMCQ)
                            .addComponent(setter1Hr, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                            .addComponent(InternalDissertionSpecial)
                            .addComponent(ExternalDissertionGeneral))
                        .addGap(62, 62, 62)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(dissertionGeneralEd)
                            .addComponent(markingExternalEssayEd)
                            .addComponent(markingInternalMCQEd)
                            .addComponent(markingInternalEssayEd)
                            .addComponent(hallAttendanceEd)
                            .addComponent(invigilatorEd)
                            .addComponent(supervisorEd)
                            .addComponent(supervisionEd)
                            .addComponent(packetingEd)
                            .addComponent(duplicateEd)
                            .addComponent(typingEd)
                            .addComponent(moderatorMCQEd)
                            .addComponent(moderator3HrEd)
                            .addComponent(moderator2HrEd)
                            .addComponent(moderator1HrEd)
                            .addComponent(setterMCQEd)
                            .addComponent(setter3HrEd)
                            .addGroup(jPanel8Layout.createSequentialGroup()
                                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(setter2HrEd)
                                    .addComponent(setter1HrEd))
                                .addGap(189, 189, 189)
                                .addComponent(aa, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(dissertionSpecialEd2)
                            .addComponent(dissertionSpecialEd)
                            .addComponent(dissertionSpecialEd1)))
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(566, 566, 566)
                        .addComponent(kButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(594, Short.MAX_VALUE))
        );
        jPanel8Layout.setVerticalGroup(
            jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel8Layout.createSequentialGroup()
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel16)
                            .addComponent(setter1Hr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(setter1HrEd))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel23)
                            .addComponent(setter2Hr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(setter2HrEd)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addGap(85, 85, 85)
                        .addComponent(aa, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel31)
                    .addComponent(setter3Hr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(setter3HrEd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel36)
                    .addComponent(setterMCQ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(setterMCQEd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel40)
                    .addComponent(moderator1Hr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(moderator1HrEd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel41)
                    .addComponent(moderator2Hr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(moderator2HrEd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel43)
                    .addComponent(moderator3Hr, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(moderator3HrEd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel44)
                    .addComponent(moderatorMCQ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(moderatorMCQEd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel45)
                    .addComponent(typing, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(typingEd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel46)
                    .addComponent(duplicate, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(duplicateEd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel47)
                    .addComponent(packeting, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(packetingEd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel56)
                    .addComponent(supervision, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(supervisionEd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel57)
                    .addComponent(supervisor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(supervisorEd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel58)
                    .addComponent(invigilator, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(invigilatorEd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel59)
                    .addComponent(hallAttendance, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(hallAttendanceEd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel60)
                    .addComponent(markingInternalEssay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(markingInternalEssayEd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel61)
                    .addComponent(markingInternalMCQ, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(markingInternalMCQEd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel62)
                    .addComponent(markingExternalEssay, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(markingExternalEssayEd))
                .addGap(6, 6, 6)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel63)
                    .addComponent(internalDissertionGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dissertionGeneralEd))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel8Layout.createSequentialGroup()
                        .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel64)
                            .addComponent(ExternalDissertionGeneral, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(16, 16, 16))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel8Layout.createSequentialGroup()
                        .addComponent(dissertionSpecialEd2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel66)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(InternalDissertionSpecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dissertionSpecialEd)))
                .addGap(18, 18, 18)
                .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel65)
                    .addGroup(jPanel8Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(ExternalDissertionSpecial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(dissertionSpecialEd1)))
                .addGap(91, 91, 91)
                .addComponent(kButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(149, Short.MAX_VALUE))
        );

        jScrollPane9.setViewportView(jPanel8);

        Rates.add(jScrollPane9, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1670, 900));
        jScrollPane9.getAccessibleContext().setAccessibleParent(pp6);

        getContentPane().add(Rates, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 150, 1710, 1060));

        User.setMinimumSize(new java.awt.Dimension(1670, 900));
        User.setPreferredSize(new java.awt.Dimension(1790, 1500));
        User.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane10.setPreferredSize(new java.awt.Dimension(1790, 1500));

        useradd.setBackground(new java.awt.Color(249, 249, 249));
        useradd.setPreferredSize(new java.awt.Dimension(1780, 1399));

        usertable.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        usertable.setModel(new javax.swing.table.DefaultTableModel(
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
        usertable.setRowHeight(25);
        usertable.setRowMargin(2);
        usertable.setSelectionBackground(new java.awt.Color(183, 130, 232));
        jScrollPane11.setViewportView(usertable);

        jLabel68.setFont(new java.awt.Font("Dialog", 0, 28)); // NOI18N
        jLabel68.setText("users");

        jLabel69.setFont(new java.awt.Font("Dialog", 0, 28)); // NOI18N
        jLabel69.setText("Add New User");

        jLabel70.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel70.setText("Username");

        jLabel71.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel71.setText("User Type");

        jLabel72.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        jLabel72.setText("Password");

        password.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        password.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                passwordActionPerformed(evt);
            }
        });

        username.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        username.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                usernameActionPerformed(evt);
            }
        });

        usertype.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        usertype.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Head", "Admin" }));

        kButton12.setText("Remove User");
        kButton12.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        kButton12.setkEndColor(new java.awt.Color(176, 89, 235));
        kButton12.setkHoverEndColor(new java.awt.Color(255, 176, 244));
        kButton12.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton12.setkHoverStartColor(new java.awt.Color(72, 47, 112));
        kButton12.setkSelectedColor(new java.awt.Color(119, 53, 181));
        kButton12.setkStartColor(new java.awt.Color(72, 47, 112));
        kButton12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton12ActionPerformed(evt);
            }
        });

        kButton10.setText("Add User");
        kButton10.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        kButton10.setkEndColor(new java.awt.Color(176, 89, 235));
        kButton10.setkHoverEndColor(new java.awt.Color(255, 176, 244));
        kButton10.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton10.setkHoverStartColor(new java.awt.Color(72, 47, 112));
        kButton10.setkSelectedColor(new java.awt.Color(119, 53, 181));
        kButton10.setkStartColor(new java.awt.Color(72, 47, 112));
        kButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton10ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout useraddLayout = new javax.swing.GroupLayout(useradd);
        useradd.setLayout(useraddLayout);
        useraddLayout.setHorizontalGroup(
            useraddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(useraddLayout.createSequentialGroup()
                .addGap(71, 71, 71)
                .addComponent(jLabel68)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel69)
                .addGap(727, 727, 727))
            .addGroup(useraddLayout.createSequentialGroup()
                .addGroup(useraddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(useraddLayout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 640, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(81, 81, 81)
                        .addGroup(useraddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel70)
                            .addComponent(jLabel71)
                            .addComponent(jLabel72))
                        .addGap(153, 153, 153)
                        .addGroup(useraddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(password)
                            .addComponent(username)
                            .addComponent(usertype, 0, 188, Short.MAX_VALUE)))
                    .addGroup(useraddLayout.createSequentialGroup()
                        .addGap(149, 149, 149)
                        .addComponent(kButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(606, 606, 606)
                        .addComponent(kButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(602, Short.MAX_VALUE))
        );
        useraddLayout.setVerticalGroup(
            useraddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(useraddLayout.createSequentialGroup()
                .addGroup(useraddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(useraddLayout.createSequentialGroup()
                        .addGap(121, 121, 121)
                        .addComponent(jLabel68)
                        .addGap(41, 41, 41)
                        .addComponent(jScrollPane11, javax.swing.GroupLayout.PREFERRED_SIZE, 411, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(useraddLayout.createSequentialGroup()
                        .addGap(137, 137, 137)
                        .addComponent(jLabel69)
                        .addGroup(useraddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(useraddLayout.createSequentialGroup()
                                .addGap(160, 160, 160)
                                .addComponent(jLabel71)
                                .addGap(63, 63, 63))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, useraddLayout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(usertype, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(71, 71, 71)))
                        .addGroup(useraddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel70)
                            .addComponent(username, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(46, 46, 46)
                        .addGroup(useraddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel72)
                            .addComponent(password, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addGap(132, 132, 132)
                .addGroup(useraddLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(kButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 77, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(kButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(577, Short.MAX_VALUE))
        );

        jScrollPane10.setViewportView(useradd);

        User.add(jScrollPane10, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1670, 900));
        jScrollPane10.getAccessibleContext().setAccessibleParent(Welcome);

        getContentPane().add(User, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 150, 1710, 1060));

        Change.setMinimumSize(new java.awt.Dimension(1670, 900));
        Change.setPreferredSize(new java.awt.Dimension(1790, 1500));
        Change.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane12.setPreferredSize(new java.awt.Dimension(1790, 1500));

        ChangeP.setBackground(new java.awt.Color(249, 249, 249));
        ChangeP.setPreferredSize(new java.awt.Dimension(1780, 1399));

        jLabel74.setFont(new java.awt.Font("Dialog", 0, 28)); // NOI18N
        jLabel74.setText("Username");

        changeuser.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        changeuser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changeuserActionPerformed(evt);
            }
        });

        jLabel75.setFont(new java.awt.Font("Dialog", 0, 28)); // NOI18N
        jLabel75.setText("New Password");

        jLabel76.setFont(new java.awt.Font("Dialog", 0, 28)); // NOI18N
        jLabel76.setText("Current password");

        changecurrent.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        changecurrent.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changecurrentActionPerformed(evt);
            }
        });

        changenew.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        changenew.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                changenewActionPerformed(evt);
            }
        });

        kButton11.setText("Change");
        kButton11.setFont(new java.awt.Font("Times New Roman", 0, 36)); // NOI18N
        kButton11.setkEndColor(new java.awt.Color(176, 89, 235));
        kButton11.setkHoverEndColor(new java.awt.Color(255, 176, 244));
        kButton11.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton11.setkHoverStartColor(new java.awt.Color(72, 47, 112));
        kButton11.setkSelectedColor(new java.awt.Color(119, 53, 181));
        kButton11.setkStartColor(new java.awt.Color(72, 47, 112));
        kButton11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton11ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout ChangePLayout = new javax.swing.GroupLayout(ChangeP);
        ChangeP.setLayout(ChangePLayout);
        ChangePLayout.setHorizontalGroup(
            ChangePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChangePLayout.createSequentialGroup()
                .addGroup(ChangePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(ChangePLayout.createSequentialGroup()
                        .addGap(189, 189, 189)
                        .addGroup(ChangePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel75)
                            .addComponent(jLabel76)
                            .addComponent(jLabel74))
                        .addGap(170, 170, 170)
                        .addGroup(ChangePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(changecurrent, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(changenew, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(changeuser, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(ChangePLayout.createSequentialGroup()
                        .addGap(420, 420, 420)
                        .addComponent(kButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(895, Short.MAX_VALUE))
        );
        ChangePLayout.setVerticalGroup(
            ChangePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(ChangePLayout.createSequentialGroup()
                .addGap(323, 323, 323)
                .addGroup(ChangePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel74)
                    .addComponent(changeuser, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(35, 35, 35)
                .addGroup(ChangePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel76)
                    .addComponent(changecurrent, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addGroup(ChangePLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel75)
                    .addComponent(changenew, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(144, 144, 144)
                .addComponent(kButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(681, Short.MAX_VALUE))
        );

        jScrollPane12.setViewportView(ChangeP);

        Change.add(jScrollPane12, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1670, 900));
        jScrollPane12.getAccessibleContext().setAccessibleParent(Welcome);

        getContentPane().add(Change, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 150, 1710, 1060));

        addSubjects.setMinimumSize(new java.awt.Dimension(1670, 900));
        addSubjects.setPreferredSize(new java.awt.Dimension(1790, 1500));
        addSubjects.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jScrollPane13.setPreferredSize(new java.awt.Dimension(1790, 1500));

        jPanel9.setBackground(new java.awt.Color(249, 249, 249));
        jPanel9.setPreferredSize(new java.awt.Dimension(1780, 1399));

        subTable.setFont(new java.awt.Font("Dialog", 0, 18)); // NOI18N
        subTable.setModel(new javax.swing.table.DefaultTableModel(
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
        subTable.setRowHeight(20);
        subTable.setSelectionBackground(new java.awt.Color(183, 130, 232));
        jScrollPane14.setViewportView(subTable);

        jLabel4.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel4.setText("Subject Code");

        jLabel6.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N
        jLabel6.setText("Subject Name");

        addName.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        addCode.setFont(new java.awt.Font("Dialog", 0, 24)); // NOI18N

        kButton14.setText("Delete");
        kButton14.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        kButton14.setkEndColor(new java.awt.Color(176, 89, 235));
        kButton14.setkHoverEndColor(new java.awt.Color(255, 176, 244));
        kButton14.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton14.setkHoverStartColor(new java.awt.Color(72, 47, 112));
        kButton14.setkSelectedColor(new java.awt.Color(119, 53, 181));
        kButton14.setkStartColor(new java.awt.Color(72, 47, 112));
        kButton14.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton14ActionPerformed(evt);
            }
        });

        kButton15.setText("Add");
        kButton15.setFont(new java.awt.Font("Dialog", 0, 36)); // NOI18N
        kButton15.setkEndColor(new java.awt.Color(176, 89, 235));
        kButton15.setkHoverEndColor(new java.awt.Color(255, 176, 244));
        kButton15.setkHoverForeGround(new java.awt.Color(255, 255, 255));
        kButton15.setkHoverStartColor(new java.awt.Color(72, 47, 112));
        kButton15.setkSelectedColor(new java.awt.Color(119, 53, 181));
        kButton15.setkStartColor(new java.awt.Color(72, 47, 112));
        kButton15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                kButton15ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(61, 61, 61)
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, 576, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(47, 47, 47)
                                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel4)
                                    .addComponent(jLabel6))
                                .addGap(60, 60, 60)
                                .addComponent(addName, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel9Layout.createSequentialGroup()
                                .addGap(355, 355, 355)
                                .addComponent(kButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 143, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(243, 243, 243)
                        .addComponent(kButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 221, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(509, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel9Layout.createSequentialGroup()
                    .addContainerGap(893, Short.MAX_VALUE)
                    .addComponent(addCode, javax.swing.GroupLayout.PREFERRED_SIZE, 377, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(510, 510, 510)))
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel9Layout.createSequentialGroup()
                .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(117, 117, 117)
                        .addComponent(jScrollPane14, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(128, 128, 128)
                        .addComponent(kButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel9Layout.createSequentialGroup()
                        .addGap(192, 192, 192)
                        .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(28, 28, 28)
                        .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 93, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(addName, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(80, 80, 80)
                        .addComponent(kButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 73, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(644, Short.MAX_VALUE))
            .addGroup(jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel9Layout.createSequentialGroup()
                    .addGap(220, 220, 220)
                    .addComponent(addCode, javax.swing.GroupLayout.PREFERRED_SIZE, 56, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(1123, Short.MAX_VALUE)))
        );

        jScrollPane13.setViewportView(jPanel9);

        addSubjects.add(jScrollPane13, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 1610, 900));

        getContentPane().add(addSubjects, new org.netbeans.lib.awtextra.AbsoluteConstraints(255, 150, 1710, 1060));

        bindingGroup.bind();

        pack();
    }// </editor-fold>//GEN-END:initComponents

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
        
        pp1.setBackground(new Color(93,59,161));
        }
        
       if(evt.getSource()==pp2){
        
        pp2.setBackground(new Color(93,59,161));
        }
       if(evt.getSource()==pp3){
        
        pp3.setBackground(new Color(93,59,161));
        }
      
    }//GEN-LAST:event_MouseExited

    private void BeforeNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BeforeNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BeforeNameActionPerformed

    private void DaySalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DaySalaryActionPerformed

        String  selectedValue=DaySalary.getSelectedItem().toString();
        String ttt = "SELECT Employee_Name FROM Employee  WHERE Employee_Id='"+selectedValue+"'";
        try {
            pst=conn.prepareStatement(ttt);
            rs=pst.executeQuery();
            String yy=rs.getString("Employee_Name");

            BeforeName.setText(yy);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }          // TODO add your handling code here:
    }//GEN-LAST:event_DaySalaryActionPerformed
    
    private void AfterTypeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AfterTypeActionPerformed
        // TODO add your handling code here:

    }//GEN-LAST:event_AfterTypeActionPerformed

    private void AfterNameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AfterNameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AfterNameActionPerformed

    private void pp6MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pp6MouseEntered
        // TODO add your handling code here:
        pp6.setBackground(new Color(135,135,135));
    }//GEN-LAST:event_pp6MouseEntered

    private void pp6MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pp6MouseExited
        // TODO add your handling code here:
          pp6.setBackground(new Color(93,59,161));
    }//GEN-LAST:event_pp6MouseExited

    private void pp5MouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pp5MouseEntered

  pp5.setBackground(new Color(135,135,135));        // TODO add your handling code here:
    }//GEN-LAST:event_pp5MouseEntered

    private void pp5MouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pp5MouseExited
        // TODO add your handling code here:
        pp5.setBackground(new Color(93,59,161));
    }//GEN-LAST:event_pp5MouseExited

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

    private void pp5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pp5MouseClicked
        // TODO add your handling code here:
        
        
        if(evt.getSource()==pp3){
        
        dayExam.setVisible(true);
        beforeExam.setVisible(false);
        afterExam.setVisible(false);
        finalReport.setVisible(false);
        Databases.setVisible(false);
        Welcome.setVisible(false);
        Rates.setVisible(false);
        User.setVisible(false);
        Change.setVisible(false);
        
        day.setVisible(true);
        after.setVisible(false);
        before.setVisible(false);
        welcome.setVisible(false);
        final1.setVisible(false);
        database.setVisible(false);
        rates.setVisible(false);
        changep.setVisible(false);
        userp.setVisible(false);
         subAdd.setVisible(false);
         addSubjects.setVisible(false);
        
        
        
      }
        
        if(evt.getSource()==pp5){
        
        dayExam.setVisible(false);
        beforeExam.setVisible(false);
        afterExam.setVisible(false);
        finalReport.setVisible(true);
        Databases.setVisible(false);
        Welcome.setVisible(false);
        Rates.setVisible(false);
        User.setVisible(false);
        Change.setVisible(false);
        
        day.setVisible(false);
        after.setVisible(false);
        before.setVisible(false);
        welcome.setVisible(false);
        final1.setVisible(true);
        database.setVisible(false);
        rates.setVisible(false);
          changep.setVisible(false);
          userp.setVisible(false);
           subAdd.setVisible(false);
         addSubjects.setVisible(false);
        
      }
             if(evt.getSource()==pp2){
        
        dayExam.setVisible(false);
        beforeExam.setVisible(true);
        afterExam.setVisible(false);
        finalReport.setVisible(false);
        Databases.setVisible(false);
        Welcome.setVisible(false);
        Rates.setVisible(false);
        User.setVisible(false);
        Change.setVisible(false);
        
         day.setVisible(false);
        after.setVisible(false);
        before.setVisible(true);
        welcome.setVisible(false);
        final1.setVisible(false);
        database.setVisible(false);
        rates.setVisible(false);
          changep.setVisible(false);
        userp.setVisible(false);
         subAdd.setVisible(false);
         addSubjects.setVisible(false);
      }
                  if(evt.getSource()==pp1){
        
        dayExam.setVisible(false);
        beforeExam.setVisible(false);
        afterExam.setVisible(true);
        finalReport.setVisible(false);
        Databases.setVisible(false);
        Welcome.setVisible(false);
        Rates.setVisible(false);
        User.setVisible(false);
        Change.setVisible(false);
        
        day.setVisible(false);
        after.setVisible(true);
        before.setVisible(false);
        welcome.setVisible(false);
        final1.setVisible(false);
        database.setVisible(false);
        rates.setVisible(false);
          changep.setVisible(false);
        userp.setVisible(false);
         subAdd.setVisible(false);
         addSubjects.setVisible(false);
      }
                            if(evt.getSource()==pp6){
        
        dayExam.setVisible(false);
        beforeExam.setVisible(false);
        afterExam.setVisible(false);
        finalReport.setVisible(false);
        Databases.setVisible(true);
        Welcome.setVisible(false);
        Rates.setVisible(false);
        User.setVisible(false);
        Change.setVisible(false);
        
         day.setVisible(false);
        after.setVisible(false);
        before.setVisible(false);
        welcome.setVisible(false);
        final1.setVisible(false);
        database.setVisible(true);
        rates.setVisible(false);
          changep.setVisible(false);
        userp.setVisible(false);
         subAdd.setVisible(false);
         addSubjects.setVisible(false);
      }
              Update_Table();              
     
    }//GEN-LAST:event_pp5MouseClicked

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
       
        
        dayExam.setVisible(false);
        beforeExam.setVisible(false);
        afterExam.setVisible(false);
        finalReport.setVisible(false);
        Databases.setVisible(false);
        Welcome.setVisible(true);
         subAdd.setVisible(false);
         addSubjects.setVisible(false);
        
      
        
    }//GEN-LAST:event_formWindowOpened

    private void BeforeSalaryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BeforeSalaryActionPerformed

        String  selectedValue=BeforeSalary.getSelectedItem().toString();
        String ttt = "SELECT Employee_Name FROM Employee  WHERE Employee_Id='"+selectedValue+"'";
        try {
            pst=conn.prepareStatement(ttt);
            rs=pst.executeQuery();
            String yy=rs.getString("Employee_Name");

            BeforeName1.setText(yy);
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, ex);
        }           // TODO add your handling code here:
    }//GEN-LAST:event_BeforeSalaryActionPerformed

    private void topBarmouseclicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_topBarmouseclicked
        // TODO add your handling code here:
    }//GEN-LAST:event_topBarmouseclicked

    private void BeforeName1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BeforeName1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BeforeName1ActionPerformed

    private void DaySemesterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DaySemesterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DaySemesterActionPerformed

    private void DayIntakeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DayIntakeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DayIntakeActionPerformed

    private void displayPropertyChange(java.beans.PropertyChangeEvent evt) {//GEN-FIRST:event_displayPropertyChange
        // TODO add your handling code here:

    }//GEN-LAST:event_displayPropertyChange

    private void dissertionSpecialEd2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_dissertionSpecialEd2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_dissertionSpecialEd2ActionPerformed

    private void internalDissertionGeneralActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_internalDissertionGeneralActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_internalDissertionGeneralActionPerformed

    private void setter1HrEdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_setter1HrEdMouseClicked
        // TODO add your handlincode here:
       if (setter1HrEd.isSelected()){ 
           
           setter1Hr.setEditable(true);
       } 
       else{
          setter1Hr.setEditable(false);
       }
       
    }//GEN-LAST:event_setter1HrEdMouseClicked

    private void setter2HrEdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_setter2HrEdMouseClicked
if (setter2HrEd.isSelected()){ 
           
             setter2Hr.setEditable(true);
       } 
       else{
            setter2Hr.setEditable(false);
       }
        
    }//GEN-LAST:event_setter2HrEdMouseClicked

    private void setter3HrEdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_setter3HrEdMouseClicked
      if (setter3HrEd.isSelected()){ 
           
             setter3Hr.setEditable(true);
       } 
       else{
            setter3Hr.setEditable(false);
       }
         
    }//GEN-LAST:event_setter3HrEdMouseClicked

    private void setterMCQEdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_setterMCQEdMouseClicked
        if ( setterMCQEd.isSelected()){ 
           
             setterMCQ.setEditable(true);
       } 
       else{
            setterMCQ.setEditable(false);
       }
      
    }//GEN-LAST:event_setterMCQEdMouseClicked

    private void moderator1HrEdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moderator1HrEdMouseClicked
       if (moderator1HrEd.isSelected()){ 
           
             moderator1Hr.setEditable(true);
       } 
       else{
            moderator1Hr.setEditable(false);
       }
         
     
    }//GEN-LAST:event_moderator1HrEdMouseClicked

    private void moderator2HrEdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moderator2HrEdMouseClicked
         if (moderator2HrEd.isSelected()){ 
           
            moderator2Hr.setEditable(true);
       } 
       else{
            moderator2Hr.setEditable(false);
       }
         
    }//GEN-LAST:event_moderator2HrEdMouseClicked

    private void moderator3HrEdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moderator3HrEdMouseClicked
          if ( moderator3HrEd.isSelected()){ 
           
            moderator3Hr.setEditable(true);
       } 
       else{
            moderator3Hr.setEditable(false);
       }
         
    }//GEN-LAST:event_moderator3HrEdMouseClicked

    private void moderatorMCQEdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_moderatorMCQEdMouseClicked
          if (moderator3HrEd.isSelected()){ 
           
            moderatorMCQ.setEditable(true);
       } 
       else{
            moderatorMCQ.setEditable(false);
       }
        
    }//GEN-LAST:event_moderatorMCQEdMouseClicked

    private void typingEdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_typingEdMouseClicked
         if (typingEd.isSelected()){ 
           
            typing.setEditable(true);
       } 
       else{
            typing.setEditable(false);
       }
        
    }//GEN-LAST:event_typingEdMouseClicked

    private void duplicateEdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_duplicateEdMouseClicked
           if (duplicateEd.isSelected()){ 
           
             duplicate.setEditable(true);
       } 
       else{
             duplicate.setEditable(false);
       }
         
    }//GEN-LAST:event_duplicateEdMouseClicked

    private void packetingEdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_packetingEdMouseClicked
        if (packetingEd.isSelected()){ 
           
             packeting.setEditable(true);
       } 
       else{
             packeting.setEditable(false);
       }
        
    }//GEN-LAST:event_packetingEdMouseClicked

    private void supervisionEdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supervisionEdMouseClicked
        if (supervisionEd.isSelected()){ 
           
             supervision.setEditable(true);
       } 
       else{
             supervision.setEditable(false);
       }
        
    }//GEN-LAST:event_supervisionEdMouseClicked

    private void supervisorEdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_supervisorEdMouseClicked
       if (supervisorEd.isSelected()){ 
           
             supervisor.setEditable(true);
       } 
       else{
             supervisor.setEditable(false);
       }
        
        
    }//GEN-LAST:event_supervisorEdMouseClicked

    private void invigilatorEdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_invigilatorEdMouseClicked
        if (invigilatorEd.isSelected()){ 
           
             invigilator.setEditable(true);
       } 
       else{
             invigilator.setEditable(false);
       }
         
    }//GEN-LAST:event_invigilatorEdMouseClicked

    private void hallAttendanceEdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_hallAttendanceEdMouseClicked
          if (hallAttendanceEd.isSelected()){ 
           
             hallAttendance.setEditable(true);
       } 
       else{
            hallAttendance.setEditable(false);
       }
         
    }//GEN-LAST:event_hallAttendanceEdMouseClicked

    private void markingInternalEssayEdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_markingInternalEssayEdMouseClicked
          if (markingInternalEssayEd.isSelected()){ 
           
             markingInternalEssay.setEditable(true);
       } 
       else{
            markingInternalEssay.setEditable(false);
       }
         
     
    }//GEN-LAST:event_markingInternalEssayEdMouseClicked

    private void markingInternalMCQEdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_markingInternalMCQEdMouseClicked
           if ( markingInternalMCQEd.isSelected()){ 
           
            markingInternalMCQ.setEditable(true);
       } 
       else{
            markingInternalMCQ.setEditable(false);
       }
         
    }//GEN-LAST:event_markingInternalMCQEdMouseClicked

    private void markingExternalEssayEdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_markingExternalEssayEdMouseClicked
         if ( markingExternalEssayEd.isSelected()){ 
           
           markingExternalEssay.setEditable(true);
       } 
       else{
            markingExternalEssay.setEditable(false);
       }
        
    }//GEN-LAST:event_markingExternalEssayEdMouseClicked

    private void dissertionGeneralEdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dissertionGeneralEdMouseClicked
        if (dissertionGeneralEd.isSelected()){ 
           
           internalDissertionGeneral.setEditable(true);
       } 
       else{
           internalDissertionGeneral.setEditable(false);
       }
        
        
    }//GEN-LAST:event_dissertionGeneralEdMouseClicked

    private void dissertionSpecialEd2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dissertionSpecialEd2MouseClicked
         if (dissertionSpecialEd2.isSelected()){ 
           
           ExternalDissertionGeneral.setEditable(true);
       } 
       else{
           ExternalDissertionGeneral.setEditable(false);
       }
        
        
    }//GEN-LAST:event_dissertionSpecialEd2MouseClicked

    private void dissertionSpecialEdMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dissertionSpecialEdMouseClicked
         if (dissertionSpecialEd.isSelected()){ 
           
           InternalDissertionSpecial.setEditable(true);
       } 
       else{
          InternalDissertionSpecial.setEditable(false);
       }
        
         
    }//GEN-LAST:event_dissertionSpecialEdMouseClicked

    private void dissertionSpecialEd1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_dissertionSpecialEd1MouseClicked
         if (dissertionSpecialEd1.isSelected()){ 
           
           ExternalDissertionSpecial.setEditable(true);
       } 
       else{
          ExternalDissertionSpecial.setEditable(false);
       }
        
       
    }//GEN-LAST:event_dissertionSpecialEd1MouseClicked

    private void pphomepp5MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pphomepp5MouseClicked
        
        
        dayExam.setVisible(false);
        beforeExam.setVisible(false);
        afterExam.setVisible(false);
        finalReport.setVisible(false);
        Databases.setVisible(false);
        Welcome.setVisible(true);
        
         day.setVisible(false);
        after.setVisible(false);
        before.setVisible(false);
        welcome.setVisible(true);
        final1.setVisible(false);
        database.setVisible(false);
        rates.setVisible(false);
        changep.setVisible(false);
        userp.setVisible(false);
        
        Rates.setVisible(false);
        User.setVisible(true);
        Change.setVisible(false);
         subAdd.setVisible(false);
         addSubjects.setVisible(false);
        
      
    }//GEN-LAST:event_pphomepp5MouseClicked

    private void pphomeMouseEntered(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pphomeMouseEntered
        // TODO add your handling code here:
         pphome.setBackground(new Color(135,135,135));
    }//GEN-LAST:event_pphomeMouseEntered

    private void pphomeMouseExited(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_pphomeMouseExited
      // TODO add your handling code here:
      pphome.setBackground(new Color(93,59,161));
    }//GEN-LAST:event_pphomeMouseExited

    private void passwordActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_passwordActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_passwordActionPerformed

    private void usernameActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_usernameActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_usernameActionPerformed

    private void changeuserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changeuserActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_changeuserActionPerformed

    private void changecurrentActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changecurrentActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_changecurrentActionPerformed

    private void changenewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_changenewActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_changenewActionPerformed

    private void FinalIntakeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_FinalIntakeItemStateChanged
        // TODO add your handling code here:
        
        Update_CuTable();
    }//GEN-LAST:event_FinalIntakeItemStateChanged

    private void FinalIntakeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FinalIntakeActionPerformed
      
    }//GEN-LAST:event_FinalIntakeActionPerformed

    private void FinalSemesterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_FinalSemesterActionPerformed
        // TODO add your handling code here:
  
    }//GEN-LAST:event_FinalSemesterActionPerformed

    private void FinalSemesterItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_FinalSemesterItemStateChanged
        // TODO add your handling code here:
        Update_CuTable();
    }//GEN-LAST:event_FinalSemesterItemStateChanged

    private void BeforeIntakeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BeforeIntakeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BeforeIntakeActionPerformed

    private void BeforeSemesterActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BeforeSemesterActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BeforeSemesterActionPerformed

    private void AfterSubject1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AfterSubject1ActionPerformed

        // TODO add your handling code here:
    }//GEN-LAST:event_AfterSubject1ActionPerformed

    private void AfterIntakeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AfterIntakeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AfterIntakeActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed

        
        dayExam.setVisible(false);
        beforeExam.setVisible(false);
        afterExam.setVisible(false);
        finalReport.setVisible(false);
        Databases.setVisible(false);
        Welcome.setVisible(false);
        Rates.setVisible(false);
        User.setVisible(false);
        Change.setVisible(false); 
        sideBar.setVisible(false);
        topBar.setVisible(false);
         addSubjects.setVisible(false); 
        
                
         panel_center1 e=new panel_center1("");
                e.setVisible(false);
         
           login d=new login();
                d.setVisible(true);
     
           
        
           
        // TODO add your handling code here:
        
        
    }//GEN-LAST:event_jButton7ActionPerformed

    private void DaySubject1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DaySubject1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_DaySubject1ActionPerformed

    private void BeforeSubject1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BeforeSubject1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_BeforeSubject1ActionPerformed

    private void AfterSemester1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AfterSemester1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_AfterSemester1ActionPerformed

    private void kButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton1ActionPerformed
        // TODO add your handling code here:
           String sqlii="select SalaryId from ExamDay where SalaryId=?";
          String valuee123=DaySalary.getSelectedItem().toString();
        //  String value124=DayIntake.getSelectedItem().toString();

        String aq=valuee123;

        //data redun
        try  {
            
            pst=conn.prepareStatement(sqlii);
            pst.setString(1,valuee123);

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
                
                
               String salary ="SELECT Supervisor,Invigilator,Hall_Atte FROM Salary_Rates WHERE Number='1'";
                pst=conn.prepareStatement(salary);
                rs=pst.executeQuery();
                
                int s13=rs.getInt("Supervisor");
                int s14=rs.getInt("Invigilator");
                int s15=rs.getInt("Hall_Atte");
                
                
                
                int Super_T=((ba1*s13));
                int Super_P=((bb1*s13));
                int Ing_T=((bc1*s14));
                int Ing_P=((bd1*s14));
                int Hall_T=((be1*s15));
                int Hall_P=((be2*s15));
                int payements=(Super_T+Super_P+Ing_T+Ing_P+Hall_T+Hall_P);
              
                pst.close();
                rs.close();
                String sqliii = "SELECT Sup_T,Sup_P,Ing_S,Ing_P,Hall_T,Hall_P,Payments FROM ExamDay  WHERE SalaryId='"+aq+"'";
                pst=conn.prepareStatement(sqliii);
                rs=pst.executeQuery();
                int to=rs.getInt("Sup_T");
                int so=rs.getInt("Sup_P");
                int io=rs.getInt("Ing_S");
                int ho=rs.getInt("Ing_P");
                
                int to1=rs.getInt("Hall_T");
                int so1=rs.getInt("Hall_P");
                
                int ho1=rs.getInt("Payments");
                
                int SUPER_T=(Super_T+to);
                int SUPER_p=(so+Super_P);
                int ING_T=(io+Ing_T);
                int ING_P=(ho+Ing_P);
                
                int HALL_T=(Hall_T+to1);
                int HALL_p=(so1+Hall_P);
                int PAYEMENTS=(ho1+ payements);
               
              

                String sqlip="update ExamDay set Sup_T='"+SUPER_T+"',Sup_P='"+SUPER_p+"',Ing_S=+'"+ING_T+"',Ing_P='"+ING_P+"',Hall_T='"+HALL_T+"',Hall_P='"+HALL_p+"',Payments='"+PAYEMENTS+"' WHERE SalaryId='"+aq+"'";
                //JOptionPane.showMessageDialog(null, "Username and Password is correct");
                pst=conn.prepareStatement(sqlip);
                pst.execute();
                pst.close();
                rs.close();
                
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
              
        try{
             String salary ="SELECT Supervisor,Invigilator,Hall_Atte FROM Salary_Rates WHERE Number='1'";
                pst=conn.prepareStatement(salary);
                rs=pst.executeQuery();
                
                int s13=rs.getInt("Supervisor");
                int s14=rs.getInt("Invigilator");
                int s15=rs.getInt("Hall_Atte");
            
            pst.close();
                rs.close();
            
            String sql="Insert into ExamDay (SalaryId,Name,Subject,Sup_T,Sup_P,Ing_S,Ing_P,Hall_T,Hall_P,Intake,Semester,Payments) values (?,?,?,?,?,?,?,?,?,?,?,?)";
            pst=conn.prepareStatement(sql);
            String valuee12=DaySalary.getSelectedItem().toString();
            pst.setString(1,valuee12);

            pst.setString(2, BeforeName.getText());
            pst.setString(3, BeforeSubject1.getSelectedItem().toString());

            String ba=Sup_Ts.getValue().toString();
            String bb=Sup_Ps.getValue().toString();
            String bc=Ing_Ts.getValue().toString();
            String bd=Ing_Ps.getValue().toString();
            String be=Hall_Ts.getValue().toString();
            String bf=Hall_Ps.getValue().toString();
            String bi=DayIntake.getSelectedItem().toString();
            String bs=DaySemester.getSelectedItem().toString();

            int ba1=Integer.parseInt(ba);
            int bb1=Integer.parseInt(bb);

            int bc1=Integer.parseInt(bc);
            int bd1=Integer.parseInt(bd);
            int be1=Integer.parseInt(be);
            int bf1=Integer.parseInt(bf);
            
             int new1=Integer.parseInt(bi);
            int new2=Integer.parseInt(bs);

            pst.setInt(4,ba1);
            pst.setInt(5,bb1);
            pst.setInt(6,bc1);
            pst.setInt(7,bd1);
            pst.setInt(8,be1);
            pst.setInt(9,bf1);
             pst.setInt(10,new1);
            pst.setInt(11,new2);
            
            
          
                
          

            int PaymentsB = ((ba1*s13)+(bb1*s13)+(bc1*s14)+(bd1*s14)+(be1*s15)+(bf1*s15));
            
            pst.setInt (12,PaymentsB);

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
               JOptionPane.showMessageDialog(null, e);
            }
        }

            }
        }
        catch (Exception e){
        
        JOptionPane.showMessageDialog(null, e);
        }
           
            
///////////////////////////////////sssssssssssssssssssssssssssss
        
       
       

        //data redun
        try{
            
              String salary ="SELECT Supervisor,Invigilator,Hall_Atte FROM Salary_Rates WHERE Number='1'";
                pst=conn.prepareStatement(salary);
                rs=pst.executeQuery();
                
                int s13=rs.getInt("Supervisor");
                int s14=rs.getInt("Invigilator");
                int s15=rs.getInt("Hall_Atte");
                
                 pst.close();
                rs.close();
                
             String sqli="select SALARY_ID from FinalReport where SALARY_ID=? ";
            pst=conn.prepareStatement(sqli);
            pst.setString(1,valuee123);
           // pst.setString(2,value124);

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
                
                
               
               
                int Super_T=((ba1*s13));
                int Super_P=((bb1*s13));
                int Ing_T=((bc1*s14));
                int Ing_P=((bd1*s14));
                int Hall_T=((be1*s15));
                int Hall_P=((be2*s15));
                int Super=(Super_T+Super_P);
                int Ing=(Ing_T+Ing_P);
                int Hall=(Hall_T+Hall_P);
                int Total=(Super_T+Super_P+Ing_T+Ing_P+Hall_T+ Hall_P);
                String sqliii = "SELECT TOTAL,SUPERVISOR,INVIGILATOR,HALL_ATTENDANT,SEMESTER,INTAKE FROM FinalReport  WHERE SALARY_ID='"+aq+"'";
                pst=conn.prepareStatement(sqliii);
                rs=pst.executeQuery();
                int to=rs.getInt("TOTAL");
                int so=rs.getInt("SUPERVISOR");
                int io=rs.getInt("INVIGILATOR");
                int ho=rs.getInt("HALL_ATTENDANT");
                String t5=rs.getString("INTAKE");
                String t6=rs.getString("SEMESTER");
                int TOtAL=(Total+to);
                int SUPER=(so+Super);
                int ING=(io+Ing);
                int HALL=(ho+Hall);
                String value127=DayIntake.getSelectedItem().toString();
                String value128=DaySemester.getSelectedItem().toString();
                String in=(t5+","+value127);
                 String se=(t6+","+value128);
                

                String sqliiiiii="update FinalReport set SUPERVISOR='"+SUPER+"',INVIGILATOR='"+ING+"',HALL_ATTENDANT=+'"+HALL+"',INTAKE='"+in+"',SEMESTER='"+se+"',TOTAL='"+TOtAL+"' WHERE SALARY_ID='"+aq+"'";
                //JOptionPane.showMessageDialog(null, "Username and Password is correct");
                pst=conn.prepareStatement(sqliiiiii);
                pst.execute();
                pst.close();
                rs.close();
                
         

            }
            else {
                
                 String salaryy ="SELECT Supervisor,Invigilator,Hall_Atte FROM Salary_Rates WHERE Number='1'";
                pst=conn.prepareStatement(salaryy);
                rs=pst.executeQuery();
                
                int s133=rs.getInt("Supervisor");
                int s144=rs.getInt("Invigilator");
                int s155=rs.getInt("Hall_Atte");
                
                pst.close();
                rs.close();
                
                
                String sql="Insert into FinalReport (SALARY_ID,SUBJECT,NAME_OF_THE_STAFF,SETTER,MODERATOR,TYPING,INTERNAL_EXAMINER,EXTERNAL_EXAMINER,SUPERVISOR,INVIGILATOR,HALL_ATTENDANT,DUPLICATING_MACHINE_OPERATOR,PACKETING_AND_SEALING,TEACHER_FOR_PRINTING_SUPERVISION,INTAKE,SEMESTER,TOTAL) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                pst=conn.prepareStatement(sql);
                String www=DayIntake.getSelectedItem().toString();
                String wwe=DaySemester.getSelectedItem().toString();
                pst.setString(1,valuee123);
                pst.setString(3, BeforeName.getText());
                pst.setString(2, DaySubject1.getSelectedItem().toString());
                   pst.setString(15,www);
                pst.setString(16,wwe);
                String baa=Sup_Ts.getValue().toString();
                String bbb=Sup_Ps.getValue().toString();
                String bcc=Ing_Ts.getValue().toString();
                String bdd=Ing_Ps.getValue().toString();
                String bee=Hall_Ts.getValue().toString();
                String bff=Hall_Ps.getValue().toString();
              
                int ba1=Integer.parseInt(baa);
                int bb1=Integer.parseInt(bbb);

                int bc1=Integer.parseInt(bcc);
                int bd1=Integer.parseInt(bdd);
                int be1=Integer.parseInt(bee);
                int be2=Integer.parseInt(bff);
                
                
            
                

                int Super_T1=((ba1*s133));
                int Super_P1=((bb1*s133));
                int Ing_T1=((bc1*s144));
                int Ing_P1=((bd1*s144));
                int Hall_T1=((be1*s155));
                int Hall_P1=((be2*s155));
                int Super1=(Super_T1+Super_P1);
                int Ing1=(Ing_T1+Ing_P1);
                int Hall1=(Hall_T1+Hall_P1);
                int Total1=(Super_T1+Super_P1+Ing_T1+Ing_P1+Hall_T1+ Hall_P1);
                pst.setInt(9,Super1);
                pst.setInt(10,Ing1);
             
                
                pst.setInt(11,Hall1);
                pst.setInt(17,Total1);
                pst.execute();
                pst.close();
             
        rs.close();
      
            //    this.setVisible(false);
           //     ExamDayDuty d=new ExamDayDuty();
           //     this.setVisible(true);

            }

        }
        catch(Exception e){

            JOptionPane.showMessageDialog(null,e);
        }
       finally{
            try{
              pst.close();
        rs.close();
       
                
            }
            catch(Exception e){
JOptionPane.showMessageDialog(null, e);
            }
        }
        
    }//GEN-LAST:event_kButton1ActionPerformed

    private void kButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton2ActionPerformed


          // TODO add your handling code here:

        try{
            
            String salary ="SELECT Setter_Essay_1,Setter_Essay_2,Setter_Essay_3,Setter_Mcq,Mod_Essay_1,Mod_Essay_2,Mod_Essay_3,Mod_Mcq,Typing,Duplicating_Machine_Operator,Packeting_And_Sealing,Teacher_For_Printing_Supervision FROM Salary_Rates WHERE Number='1'";
                pst=conn.prepareStatement(salary);
                rs=pst.executeQuery();
                
                int s1=rs.getInt("Setter_Essay_1");
                int s2=rs.getInt("Setter_Essay_2");
                int s3=rs.getInt("Setter_Essay_3");
                int s4=rs.getInt("Setter_Mcq");
                int s5=rs.getInt("Mod_Essay_1");
                int s6=rs.getInt("Mod_Essay_2");
                int s7=rs.getInt("Mod_Essay_3");
                int s8=rs.getInt("Mod_Mcq");
                int s9=rs.getInt("Typing");
                int s10=rs.getInt("Duplicating_Machine_Operator");
                int s11=rs.getInt("Packeting_And_Sealing");
                int s12=rs.getInt("Teacher_For_Printing_Supervision");
                
            pst.close();
                rs.close();
            
            String sql="Insert into BeforeExam (SalaryId,Name,Subject,Setter_1,Setter_2,Setter_3,Setter_Mcq,Mod_1,Mod_2,Mod_3,Mod_Mcq,Typ_1,Typ_2,Typ_3,Typ_Mcq,Dup,Print_Sup,Pack_Sea,Intake,Semester,Payment) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
            pst=conn.prepareStatement(sql);
            String valuee16=BeforeSalary.getSelectedItem().toString();
            pst.setString(1,valuee16);
          String valuee123=BeforeIntake.getSelectedItem().toString();
          String value124=BeforeSemester.getSelectedItem().toString();
           pst.setString(19,valuee123);
           pst.setString(20,value124);
          

            pst.setString(2, BeforeName1.getText());
             pst.setString(3, BeforeSubject1.getSelectedItem().toString());
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

            pst.setInt(4,c1*s1);
            pst.setInt(5,d1*s2);
            pst.setInt(6,e1*s3);
            pst.setInt(7,f1*s4);
            pst.setInt(8,g1*s5);
            pst.setInt(9,h1*s6);
            pst.setInt(10,i1*s7);
            pst.setInt(11,j1*s8);

            pst.setInt(12,k1a*s9);
            pst.setInt(13,k1b*s9);
            pst.setInt(14,k1c*s9);
            pst.setInt(15,k1d*s9);

            pst.setInt(16,l1*s10);
            pst.setInt(17,m1*s11);
            pst.setInt(18,n1*s12);
           

            int paymentS = ((c1*s1)+(d1*s2)+(e1*s3)+(f1*s4)+(g1*s5)+(h1*s6)+(i1*s7)+(j1*s8)+(k1a*s9)+(k1b*s9)+(k1c*s9)+(k1d*s9)+(l1*s10)+(m1*s11)+(n1*s12));
            pst.setInt(21,paymentS);

            JOptionPane.showMessageDialog(null,"Data Added Successfully");
            clearFields1();

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
       
        
        
        String valuee164=BeforeSalary.getSelectedItem().toString();
         String valuee123=DaySalary.getSelectedItem().toString();
        

        String aq=valuee164;
         
  //String value124=DayIntake.getSelectedItem().toString();
        //Setter Calculation
        try{
             String salary ="SELECT Setter_Essay_1,Setter_Essay_2,Setter_Essay_3,Setter_Mcq,Mod_Essay_1,Mod_Essay_2,Mod_Essay_3,Mod_Mcq,Typing,Duplicating_Machine_Operator,Packeting_And_Sealing,Teacher_For_Printing_Supervision FROM Salary_Rates WHERE Number='1'";
                pst=conn.prepareStatement(salary);
                rs=pst.executeQuery();
                
                int s1=rs.getInt("Setter_Essay_1");
                int s2=rs.getInt("Setter_Essay_2");
                int s3=rs.getInt("Setter_Essay_3");
                int s4=rs.getInt("Setter_Mcq");
                int s5=rs.getInt("Mod_Essay_1");
                int s6=rs.getInt("Mod_Essay_2");
                int s7=rs.getInt("Mod_Essay_3");
                int s8=rs.getInt("Mod_Mcq");
                int s9=rs.getInt("Typing");
                int s10=rs.getInt("Duplicating_Machine_Operator");
                int s11=rs.getInt("Packeting_And_Sealing");
                int s12=rs.getInt("Teacher_For_Printing_Supervision");
                
            pst.close();
                rs.close();
                
                String sqli="select SALARY_ID from FinalReport where SALARY_ID=?";

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

                int Setter = ((a1*s1)+(a2*s2)+(a3*s3)+(a4*s4));
                // pst.setInt(3,setter);

                int Moderator = ((a5*s5)+(a6*s6)+(a7*s7)+(a8*s8));
                //   pst.setInt(4,Moderator);

                int Typing = ((a9*s9)+(a10*s9)+(a11*s9)+(a12*s9));
                if(Typing>=500){
                    Typing=500;
                    //pst.setInt(5,Typing);
                }
                else {
                    Typing=((a9*s9)+(a10*s9)+(a11*s9)+(a12*s9));
                }

                int Packet = ((a14*s11));
                if(Packet>=2500){
                    Packet=2500;
                    // pst.setInt(12,Packet);
                }
                else {
                    Packet=a14*s11;
                }
                int DUP = ((a13*s10));
                // pst.setInt(11,DUP);
                int Teacher = ((a15*s12));
                // pst.setInt(13,Teacher);

                int Total=(Setter+Moderator+Typing+Packet+DUP+Teacher);
                // pst.setInt(14,Total);

                String sqlid = "SELECT TOTAL,SETTER,MODERATOR,TYPING,DUPLICATING_MACHINE_OPERATOR,PACKETING_AND_SEALING,TEACHER_FOR_PRINTING_SUPERVISION,INTAKE,SEMESTER FROM FinalReport  WHERE SALARY_ID='"+aq+"'";
                pst=conn.prepareStatement(sqlid);
                rs=pst.executeQuery();
                int to=rs.getInt("TOTAL");
                int SS=rs.getInt("SETTER");
                int MS=rs.getInt("MODERATOR");
                int TT=rs.getInt("TYPING");
                int DK=rs.getInt("DUPLICATING_MACHINE_OPERATOR");
                int PD=rs.getInt("PACKETING_AND_SEALING");
                int PT=rs.getInt("TEACHER_FOR_PRINTING_SUPERVISION");
                String t5=rs.getString("INTAKE");
                String t6=rs.getString("SEMESTER");
                
                String value127=BeforeIntake.getSelectedItem().toString();
                String value128=BeforeSemester.getSelectedItem().toString();
                String in=(t5+","+value127);
                 String se=(t6+","+value128);
                int TOtAL=(Total+to);
                int SET=(Setter+SS);
                int MOD=(Moderator+MS);
                int TYP=(Typing+TT);
                int DUPLI=(DUP+DK);
                int PACK=(Packet+PD);
                int TEACHER=(Teacher+PT);

                String sqlii="update FinalReport set SETTER='"+SET+"',MODERATOR='"+MOD+"',TYPING=+'"+TYP+"',DUPLICATING_MACHINE_OPERATOR='"+DUPLI+"',PACKETING_AND_SEALING='"+PACK+"',TEACHER_FOR_PRINTING_SUPERVISION='"+TEACHER+"',TOTAL='"+TOtAL+"',INTAKE='"+in+"',SEMESTER='"+se+"' WHERE SALARY_ID='"+aq+"'";
                //JOptionPane.showMessageDialog(null, "Username and Password is correct");
                pst=conn.prepareStatement(sqlii);
                pst.execute();
                pst.close();
                rs.close();
              
                //            this.setVisible(false);
                //             SetModType d=new SetModType();
                //            d.setVisible(true);

            }
            else{
                
               
                
            pst.close();
                rs.close();

                
                String sql7="Insert into FinalReport (SALARY_ID,SUBJECT,NAME_OF_THE_STAFF,SETTER,MODERATOR,TYPING,INTERNAL_EXAMINER,EXTERNAL_EXAMINER,SUPERVISOR,INVIGILATOR,HALL_ATTENDANT,DUPLICATING_MACHINE_OPERATOR,PACKETING_AND_SEALING,TEACHER_FOR_PRINTING_SUPERVISION,INTAKE,SEMESTER,TOTAL) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                pst=conn.prepareStatement(sql7);
 String www=BeforeIntake.getSelectedItem().toString();
                String wwe=BeforeSemester.getSelectedItem().toString();
                pst.setString(1, valuee164);
                pst.setString(3, BeforeName1.getText());
                pst.setString(2, BeforeSubject1.getSelectedItem().toString());
                 pst.setString(15, www);
                  pst.setString(16, wwe);
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

                int setter = ((a1*s1)+(a2*s2)+(a3*s3)+(a4*s4));
                pst.setInt(4,setter);

                int Moderator = ((a5*s5)+(a6*s6)+(a7*s7)+(a8*s8));
                pst.setInt(5,Moderator);

                int Typing = ((a9*s9)+(a10*s9)+(a11*s9)+(a12*s9));
                if(Typing>=500){
                    Typing=500;
                    pst.setInt(6,Typing);
                }
                else {
                    pst.setInt(6,Typing);
                }

                int Packet = ((a14*s11));
                if(Packet>=2500){
                    Packet=2500;
                    pst.setInt(13,Packet);
                }
                else {
                    pst.setInt(13,Packet);
                }
                int DUP = ((a13*s10));
                pst.setInt(12,DUP);
                int Teacher = ((a15*s12));
                pst.setInt(14,Teacher);

                int Total=(setter+Moderator+Typing+Packet+DUP+Teacher);
                pst.setInt(17,Total);
                 pst.execute();
                pst.close();
               

                JOptionPane.showMessageDialog(null,"Data Added Successfully");
                clearFields1();

                //   this.setVisible(false); //this will close frame i.e. NewJFrame

                //new AfterExam().setVisible(true);
                //AfterExam main = new AfterExam();

                //    main.setVisible(true);
                //   this.dispose();

               

    //            this.setVisible(false);

   //             SetModType d=new SetModType();
     //           d.setVisible(true);

            

           
        }
        }
        catch(Exception e){
            JOptionPane.showMessageDialog(null,e);
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
    }//GEN-LAST:event_kButton2ActionPerformed

    private void kButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton3ActionPerformed

  String sqlii="select SalaryId from ExamDay where SalaryId=?";
          String valuee123=DaySalary.getSelectedItem().toString();
        //  String value124=DayIntake.getSelectedItem().toString();

        String aq=valuee123;

        //data redun
        try  {
            
            pst=conn.prepareStatement(sqlii);
            pst.setString(1,valuee123);

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
                
                
               String salary ="SELECT Supervisor,Invigilator,Hall_Atte FROM Salary_Rates WHERE Number='1'";
                pst=conn.prepareStatement(salary);
                rs=pst.executeQuery();
                
                int s13=rs.getInt("Supervisor");
                int s14=rs.getInt("Invigilator");
                int s15=rs.getInt("Hall_Atte");
                
                
                
                int Super_T=((ba1*s13));
                int Super_P=((bb1*s13));
                int Ing_T=((bc1*s14));
                int Ing_P=((bd1*s14));
                int Hall_T=((be1*s15));
                int Hall_P=((be2*s15));
                int payements=(Super_T+Super_P+Ing_T+Ing_P+Hall_T+Hall_P);
              
                pst.close();
                rs.close();
                String sqliii = "SELECT Sup_T,Sup_P,Ing_S,Ing_P,Hall_T,Hall_P,Payments FROM ExamDay  WHERE SalaryId='"+aq+"'";
                pst=conn.prepareStatement(sqliii);
                rs=pst.executeQuery();
                int to=rs.getInt("Sup_T");
                int so=rs.getInt("Sup_P");
                int io=rs.getInt("Ing_S");
                int ho=rs.getInt("Ing_P");
                
                int to1=rs.getInt("Hall_T");
                int so1=rs.getInt("Hall_P");
                
                int ho1=rs.getInt("Payments");
                
                int SUPER_T=(Super_T+to);
                int SUPER_p=(so+Super_P);
                int ING_T=(io+Ing_T);
                int ING_P=(ho+Ing_P);
                
                int HALL_T=(Hall_T+to1);
                int HALL_p=(so1+Hall_P);
                int PAYEMENTS=(ho1+ payements);
               
              

                String sqlip="update ExamDay set Sup_T='"+SUPER_T+"',Sup_P='"+SUPER_p+"',Ing_S=+'"+ING_T+"',Ing_P='"+ING_P+"',Hall_T='"+HALL_T+"',Hall_P='"+HALL_p+"',Payments='"+PAYEMENTS+"' WHERE SalaryId='"+aq+"'";
                //JOptionPane.showMessageDialog(null, "Username and Password is correct");
                pst=conn.prepareStatement(sqlip);
                pst.execute();
                pst.close();
                rs.close();
                
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
              
        try{
             String salary ="SELECT Supervisor,Invigilator,Hall_Atte FROM Salary_Rates WHERE Number='1'";
                pst=conn.prepareStatement(salary);
                rs=pst.executeQuery();
                
                int s13=rs.getInt("Supervisor");
                int s14=rs.getInt("Invigilator");
                int s15=rs.getInt("Hall_Atte");
            
            pst.close();
                rs.close();
            
            String sql="Insert into ExamDay (SalaryId,Name,Subject,Sup_T,Sup_P,Ing_S,Ing_P,Hall_T,Hall_P,Intake,Semester,Payments) values (?,?,?,?,?,?,?,?,?,?,?,?)";
            pst=conn.prepareStatement(sql);
            String valuee12=DaySalary.getSelectedItem().toString();
            pst.setString(1,valuee12);

            pst.setString(2, BeforeName.getText());
            pst.setString(3, BeforeSubject1.getSelectedItem().toString());

            String ba=Sup_Ts.getValue().toString();
            String bb=Sup_Ps.getValue().toString();
            String bc=Ing_Ts.getValue().toString();
            String bd=Ing_Ps.getValue().toString();
            String be=Hall_Ts.getValue().toString();
            String bf=Hall_Ps.getValue().toString();
            String bi=DayIntake.getSelectedItem().toString();
            String bs=DaySemester.getSelectedItem().toString();

            int ba1=Integer.parseInt(ba);
            int bb1=Integer.parseInt(bb);

            int bc1=Integer.parseInt(bc);
            int bd1=Integer.parseInt(bd);
            int be1=Integer.parseInt(be);
            int bf1=Integer.parseInt(bf);
            
             int new1=Integer.parseInt(bi);
            int new2=Integer.parseInt(bs);

            pst.setInt(4,ba1);
            pst.setInt(5,bb1);
            pst.setInt(6,bc1);
            pst.setInt(7,bd1);
            pst.setInt(8,be1);
            pst.setInt(9,bf1);
             pst.setInt(10,new1);
            pst.setInt(11,new2);
            
            
          
                
          

            int PaymentsB = ((ba1*s13)+(bb1*s13)+(bc1*s14)+(bd1*s14)+(be1*s15)+(bf1*s15));
            
            pst.setInt (12,PaymentsB);

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
               JOptionPane.showMessageDialog(null, e);
            }
        }

            }
        }
        catch (Exception e){
        
        JOptionPane.showMessageDialog(null, e);
        }
           
            
///////////////////////////////////sssssssssssssssssssssssssssss
        
       
       

        //data redun
        try{
            
              String salary ="SELECT Supervisor,Invigilator,Hall_Atte FROM Salary_Rates WHERE Number='1'";
                pst=conn.prepareStatement(salary);
                rs=pst.executeQuery();
                
                int s13=rs.getInt("Supervisor");
                int s14=rs.getInt("Invigilator");
                int s15=rs.getInt("Hall_Atte");
                
                 pst.close();
                rs.close();
                
             String sqli="select SALARY_ID from FinalReport where SALARY_ID=? ";
            pst=conn.prepareStatement(sqli);
            pst.setString(1,valuee123);
           // pst.setString(2,value124);

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
                
                
               
               
                int Super_T=((ba1*s13));
                int Super_P=((bb1*s13));
                int Ing_T=((bc1*s14));
                int Ing_P=((bd1*s14));
                int Hall_T=((be1*s15));
                int Hall_P=((be2*s15));
                int Super=(Super_T+Super_P);
                int Ing=(Ing_T+Ing_P);
                int Hall=(Hall_T+Hall_P);
                int Total=(Super_T+Super_P+Ing_T+Ing_P+Hall_T+ Hall_P);
                String sqliii = "SELECT TOTAL,SUPERVISOR,INVIGILATOR,HALL_ATTENDANT,SEMESTER,INTAKE FROM FinalReport  WHERE SALARY_ID='"+aq+"'";
                pst=conn.prepareStatement(sqliii);
                rs=pst.executeQuery();
                int to=rs.getInt("TOTAL");
                int so=rs.getInt("SUPERVISOR");
                int io=rs.getInt("INVIGILATOR");
                int ho=rs.getInt("HALL_ATTENDANT");
                String t5=rs.getString("INTAKE");
                String t6=rs.getString("SEMESTER");
                int TOtAL=(Total+to);
                int SUPER=(so+Super);
                int ING=(io+Ing);
                int HALL=(ho+Hall);
                String value127=DayIntake.getSelectedItem().toString();
                String value128=DaySemester.getSelectedItem().toString();
                String in=(t5+","+value127);
                 String se=(t6+","+value128);
                

                String sqliiiiii="update FinalReport set SUPERVISOR='"+SUPER+"',INVIGILATOR='"+ING+"',HALL_ATTENDANT=+'"+HALL+"',INTAKE='"+in+"',SEMESTER='"+se+"',TOTAL='"+TOtAL+"' WHERE SALARY_ID='"+aq+"'";
                //JOptionPane.showMessageDialog(null, "Username and Password is correct");
                pst=conn.prepareStatement(sqliiiiii);
                pst.execute();
                pst.close();
                rs.close();
                
         

            }
            else {
                
                 String salaryy ="SELECT Supervisor,Invigilator,Hall_Atte FROM Salary_Rates WHERE Number='1'";
                pst=conn.prepareStatement(salaryy);
                rs=pst.executeQuery();
                
                int s133=rs.getInt("Supervisor");
                int s144=rs.getInt("Invigilator");
                int s155=rs.getInt("Hall_Atte");
                
                pst.close();
                rs.close();
                
                
                String sql="Insert into FinalReport (SALARY_ID,SUBJECT,NAME_OF_THE_STAFF,SETTER,MODERATOR,TYPING,INTERNAL_EXAMINER,EXTERNAL_EXAMINER,SUPERVISOR,INVIGILATOR,HALL_ATTENDANT,DUPLICATING_MACHINE_OPERATOR,PACKETING_AND_SEALING,TEACHER_FOR_PRINTING_SUPERVISION,INTAKE,SEMESTER,TOTAL) values (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
                pst=conn.prepareStatement(sql);
                String www=DayIntake.getSelectedItem().toString();
                String wwe=DaySemester.getSelectedItem().toString();
                pst.setString(1,valuee123);
                pst.setString(3, BeforeName.getText());
                pst.setString(2, DaySubject1.getSelectedItem().toString());
                   pst.setString(15,www);
                pst.setString(16,wwe);
                String baa=Sup_Ts.getValue().toString();
                String bbb=Sup_Ps.getValue().toString();
                String bcc=Ing_Ts.getValue().toString();
                String bdd=Ing_Ps.getValue().toString();
                String bee=Hall_Ts.getValue().toString();
                String bff=Hall_Ps.getValue().toString();
              
                int ba1=Integer.parseInt(baa);
                int bb1=Integer.parseInt(bbb);

                int bc1=Integer.parseInt(bcc);
                int bd1=Integer.parseInt(bdd);
                int be1=Integer.parseInt(bee);
                int be2=Integer.parseInt(bff);
                
                
            
                

                int Super_T1=((ba1*s133));
                int Super_P1=((bb1*s133));
                int Ing_T1=((bc1*s144));
                int Ing_P1=((bd1*s144));
                int Hall_T1=((be1*s155));
                int Hall_P1=((be2*s155));
                int Super1=(Super_T1+Super_P1);
                int Ing1=(Ing_T1+Ing_P1);
                int Hall1=(Hall_T1+Hall_P1);
                int Total1=(Super_T1+Super_P1+Ing_T1+Ing_P1+Hall_T1+ Hall_P1);
                pst.setInt(9,Super1);
                pst.setInt(10,Ing1);
             
                
                pst.setInt(11,Hall1);
                pst.setInt(17,Total1);
                pst.execute();
                pst.close();
             
        rs.close();
      
            //    this.setVisible(false);
           //     ExamDayDuty d=new ExamDayDuty();
           //     this.setVisible(true);

            }

        }
        catch(Exception e){

            JOptionPane.showMessageDialog(null,e);
        }
       finally{
            try{
              pst.close();
        rs.close();
       
                
            }
            catch(Exception e){
JOptionPane.showMessageDialog(null, e);
            }
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_kButton3ActionPerformed

    private void kButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton4ActionPerformed
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
        // TODO add your handling code here:
    }//GEN-LAST:event_kButton4ActionPerformed

    private void kButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton5ActionPerformed
  // TODO add your handling code here:
        MessageFormat header =new MessageFormat("Final salaery Report");
        MessageFormat footer =new MessageFormat("page{0,number,integer}");

        try {
            FinalResult.print();
        } catch (PrinterException e) {
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_kButton5ActionPerformed

    private void kButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton6ActionPerformed
  try {
              Update_Table1();   
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
   Update_Table1();   
        // TODO add your handling code here:
    }//GEN-LAST:event_kButton6ActionPerformed

    private void kButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton7ActionPerformed

   Update_Table3();  
        // TODO add your handling code here:
    }//GEN-LAST:event_kButton7ActionPerformed

    private void kButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton8ActionPerformed
        // TODO add your handling code here:
          Update_Table2();  
    }//GEN-LAST:event_kButton8ActionPerformed

    private void kButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton12ActionPerformed

 
        int row=usertable.getSelectedRow();
        String cell=usertable.getModel().getValueAt(row,0).toString();
        String sql="DELETE FROM login1 where NUMBER = " +cell;
        try {
            pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Deleted Successfully");
            Update_Tableuser();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);}
        // TODO add your handling code here:
    }//GEN-LAST:event_kButton12ActionPerformed

    private void kButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton10ActionPerformed
String type=usertype.getSelectedItem().toString();
String name=username.getText();
String Password=password.getText();


String Add="Insert into login1 (NUMBER,username,password,User_Type) values (?,?,?,?)";
        try {
            pst=conn.prepareStatement(Add);
            pst.setString(2,name);
            pst.setString(3,Password);
            pst.setString(4,type);
            JOptionPane.showMessageDialog(null,"User Added Successfully");
            pst.execute();
            Update_Tableuser();
            
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_kButton10ActionPerformed

    private void kButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton11ActionPerformed

 String sql="select username from Login1 where username=?";
    
        
       
         try{
               String newP=changenew.getText();
            String currentp=changecurrent.getText();
            String userN=changeuser.getText();
             pst=conn.prepareStatement(sql);

            pst.setString(1,changeuser.getText());
           
            
             rs=pst.executeQuery();
              
         if(rs.next()){
         
             
             
             String salary ="select password from Login1 where username='"+userN+"'";
                pst=conn.prepareStatement(salary);
                rs=pst.executeQuery();
                
          
                String s2=rs.getString("password");
                
                
                pst.close();
                rs.close();
             
             
             
             
           if(s2.equals(currentp)){
               
               String aaa="update login1 set password='"+newP+"' where username='"+userN+"'";
            pst=conn.prepareStatement(aaa);
                 rs=pst.executeQuery();
                 Update_Tableuser();
           } else {
               JOptionPane.showMessageDialog(null, "Your Old Password Is Wrong");
           }
         
         }
             
             
         else{
         JOptionPane.showMessageDialog(null,"You Have Entered An Wrong Password");
         
         }    
             
         

            
        }
        catch(Exception e){

            JOptionPane.showMessageDialog(null, e);
        
        }
      
        // TODO add your handling code here:
    }//GEN-LAST:event_kButton11ActionPerformed

    private void kButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton14ActionPerformed
 int row=subTable.getSelectedRow();
        String cell=subTable.getModel().getValueAt(row,0).toString();
        String sql="DELETE FROM Subjects where Subject_Code = " +cell;
        try {
            pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null,"Deleted Successfully");
            
            Update_subTable();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);}     
        // TODO add your handling code here:
    }//GEN-LAST:event_kButton14ActionPerformed

    private void kButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton15ActionPerformed
    // TODO add your handling code here:
     
String name=addName.getText();
String subCode=addCode.getText();


String Add="Insert into Subjects (Subject_Code,Subject_Name) values (?,?)";
        try {
            pst=conn.prepareStatement(Add);
            pst.setString(1,subCode);
            pst.setString(2,name);
           
            JOptionPane.showMessageDialog(null,"Subject Is Added Successfully");
            pst.execute();
            Update_subTable();
            
        } catch (SQLException e) {
           JOptionPane.showMessageDialog(null, e);
        }
        // TODO add your handling code here:
    }//GEN-LAST:event_kButton15ActionPerformed

    private void kButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton16ActionPerformed

  // TODO add your handling code here:
        dayExam.setVisible(false);
        beforeExam.setVisible(false);
        afterExam.setVisible(false);
        finalReport.setVisible(false);
        Databases.setVisible(false);
        Welcome.setVisible(false);
        Rates.setVisible(false);
        User.setVisible(false);
        Change.setVisible(true);
         day.setVisible(false);
        after.setVisible(false);
        before.setVisible(false);
        welcome.setVisible(false);
        final1.setVisible(false);
        database.setVisible(false);
        rates.setVisible(false);
        userp.setVisible(true);
        changep.setVisible(false);
        subAdd.setVisible(false);
        // TODO add your handling code here:
    }//GEN-LAST:event_kButton16ActionPerformed

    private void kButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton18ActionPerformed
 dayExam.setVisible(false);
        beforeExam.setVisible(false);
        afterExam.setVisible(false);
        finalReport.setVisible(false);
        Databases.setVisible(false);
        Welcome.setVisible(false);
        Rates.setVisible(true);
        User.setVisible(false);
        Change.setVisible(false);
        
        
        day.setVisible(false);
        after.setVisible(false);
        before.setVisible(false);
        welcome.setVisible(false);
        final1.setVisible(false);
        database.setVisible(false);
        rates.setVisible(true);
        userp.setVisible(false);
        changep.setVisible(false);
        userp.setVisible(false);
         subAdd.setVisible(false);
         addSubjects.setVisible(false);
        // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_kButton18ActionPerformed

    private void kButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton13ActionPerformed

  dayExam.setVisible(false);
        beforeExam.setVisible(false);
        afterExam.setVisible(false);
        finalReport.setVisible(false);
        Databases.setVisible(false);
        Welcome.setVisible(false);
        Rates.setVisible(false);
        User.setVisible(false);
        Change.setVisible(false);
         day.setVisible(false);
        after.setVisible(false);
        before.setVisible(false);
        welcome.setVisible(false);
        final1.setVisible(false);
        database.setVisible(false);
        rates.setVisible(false);
        userp.setVisible(false);
        changep.setVisible(false);
        addSubjects.setVisible(true);
         subAdd.setVisible(true);
        // TODO add your handling code here:
    }//GEN-LAST:event_kButton13ActionPerformed

    private void kButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_kButton17ActionPerformed
        // TODO add your handling code here:
        dayExam.setVisible(false);
        beforeExam.setVisible(false);
        afterExam.setVisible(false);
        finalReport.setVisible(false);
        Databases.setVisible(false);
        Welcome.setVisible(false);
        Rates.setVisible(false);
        User.setVisible(true);
        Change.setVisible(false);

        day.setVisible(false);
        after.setVisible(false);
        before.setVisible(false);
        welcome.setVisible(false);
        final1.setVisible(false);
        database.setVisible(false);
        rates.setVisible(false);
        userp.setVisible(true);
        changep.setVisible(false);
        subAdd.setVisible(false);
        addSubjects.setVisible(false);

        try {
            Update_Tableuser();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }
        Update_Tableuser();        // TODO add your handling code here:
        // TODO add your handling code here:
    }//GEN-LAST:event_kButton17ActionPerformed

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
            java.util.logging.Logger.getLogger(panel_center1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(panel_center1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(panel_center1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(panel_center1.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new panel_center1("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JSpinner AfterEssays;
    private javax.swing.JComboBox<String> AfterIntake;
    private javax.swing.JSpinner AfterMcqs;
    private javax.swing.JTextField AfterName;
    private javax.swing.JComboBox<String> AfterSalary;
    private javax.swing.JComboBox<String> AfterSemester1;
    private javax.swing.JLabel AfterSubject;
    private javax.swing.JComboBox<String> AfterSubject1;
    private javax.swing.JComboBox<String> AfterType;
    private javax.swing.JSpinner After_Gs;
    private javax.swing.JSpinner After_Ss;
    private javax.swing.JComboBox<String> BeforeIntake;
    private javax.swing.JTextField BeforeName;
    private javax.swing.JTextField BeforeName1;
    private javax.swing.JComboBox<String> BeforeSalary;
    private javax.swing.JComboBox<String> BeforeSemester;
    private javax.swing.JLabel BeforeSubject;
    private javax.swing.JComboBox<String> BeforeSubject1;
    private javax.swing.JPanel Change;
    private javax.swing.JPanel ChangeP;
    private javax.swing.JPanel Databases;
    private javax.swing.JComboBox<String> DayIntake;
    private javax.swing.JComboBox<String> DaySalary;
    private javax.swing.JComboBox<String> DaySemester;
    private javax.swing.JLabel DaySubject;
    private javax.swing.JComboBox<String> DaySubject1;
    private javax.swing.JSpinner Dups;
    private javax.swing.JTextField ExternalDissertionGeneral;
    private javax.swing.JTextField ExternalDissertionSpecial;
    private javax.swing.JComboBox<String> FinalIntake;
    private javax.swing.JTable FinalResult;
    private javax.swing.JComboBox<String> FinalSemester;
    private javax.swing.JSpinner Hall_Ps;
    private javax.swing.JSpinner Hall_Ts;
    private javax.swing.JSpinner Ing_Ps;
    private javax.swing.JSpinner Ing_Ts;
    private javax.swing.JLabel Intake;
    private javax.swing.JLabel Intake1;
    private javax.swing.JLabel Intake2;
    private javax.swing.JTextField InternalDissertionSpecial;
    private javax.swing.JSpinner Mod_1s;
    private javax.swing.JSpinner Mod_2s;
    private javax.swing.JSpinner Mod_3s;
    private javax.swing.JSpinner Mod_Mcqs;
    private javax.swing.JSpinner PackSeas;
    private javax.swing.JSpinner PrintSups;
    private javax.swing.JPanel Rates;
    private javax.swing.JLabel Semester;
    private javax.swing.JLabel Semester1;
    private javax.swing.JLabel Semester2;
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
    private javax.swing.JPanel User;
    private javax.swing.JTable ViewDatabase;
    private javax.swing.JPanel Welcome;
    private javax.swing.JLabel aa;
    private javax.swing.JTextField addCode;
    private javax.swing.JTextField addName;
    private javax.swing.JPanel addSubjects;
    private javax.swing.JLabel after;
    private javax.swing.JPanel afterExam;
    private javax.swing.JLabel before;
    private javax.swing.JPanel beforeExam;
    private javax.swing.JTextField changecurrent;
    private javax.swing.JTextField changenew;
    private javax.swing.JLabel changep;
    private javax.swing.JTextField changeuser;
    private javax.swing.JLabel database;
    private javax.swing.JLabel date;
    private javax.swing.JLabel day;
    private javax.swing.JPanel dayExam;
    private javax.swing.JLabel display;
    private javax.swing.JCheckBox dissertionGeneralEd;
    private javax.swing.JCheckBox dissertionSpecialEd;
    private javax.swing.JCheckBox dissertionSpecialEd1;
    private javax.swing.JCheckBox dissertionSpecialEd2;
    private javax.swing.JTextField duplicate;
    private javax.swing.JCheckBox duplicateEd;
    private javax.swing.JLabel final1;
    private javax.swing.JPanel finalReport;
    private javax.swing.JLabel gbgb;
    private javax.swing.JLabel gbgb1;
    private javax.swing.JLabel gbgb2;
    private javax.swing.JTextField hallAttendance;
    private javax.swing.JCheckBox hallAttendanceEd;
    private javax.swing.JTextField internalDissertionGeneral;
    private javax.swing.JTextField invigilator;
    private javax.swing.JCheckBox invigilatorEd;
    private javax.swing.JButton jButton7;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
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
    private javax.swing.JLabel jLabel49;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel50;
    private javax.swing.JLabel jLabel51;
    private javax.swing.JLabel jLabel52;
    private javax.swing.JLabel jLabel53;
    private javax.swing.JLabel jLabel54;
    private javax.swing.JLabel jLabel56;
    private javax.swing.JLabel jLabel57;
    private javax.swing.JLabel jLabel58;
    private javax.swing.JLabel jLabel59;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel60;
    private javax.swing.JLabel jLabel61;
    private javax.swing.JLabel jLabel62;
    private javax.swing.JLabel jLabel63;
    private javax.swing.JLabel jLabel64;
    private javax.swing.JLabel jLabel65;
    private javax.swing.JLabel jLabel66;
    private javax.swing.JLabel jLabel68;
    private javax.swing.JLabel jLabel69;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel70;
    private javax.swing.JLabel jLabel71;
    private javax.swing.JLabel jLabel72;
    private javax.swing.JLabel jLabel74;
    private javax.swing.JLabel jLabel75;
    private javax.swing.JLabel jLabel76;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel8;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane10;
    private javax.swing.JScrollPane jScrollPane11;
    private javax.swing.JScrollPane jScrollPane12;
    private javax.swing.JScrollPane jScrollPane13;
    private javax.swing.JScrollPane jScrollPane14;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JScrollPane jScrollPane4;
    private javax.swing.JScrollPane jScrollPane5;
    private javax.swing.JScrollPane jScrollPane6;
    private javax.swing.JScrollPane jScrollPane7;
    private javax.swing.JScrollPane jScrollPane8;
    private javax.swing.JScrollPane jScrollPane9;
    private javax.swing.JSeparator jSeparator1;
    private keeptoo.KButton kButton1;
    private keeptoo.KButton kButton10;
    private keeptoo.KButton kButton11;
    private keeptoo.KButton kButton12;
    private keeptoo.KButton kButton13;
    private keeptoo.KButton kButton14;
    private keeptoo.KButton kButton15;
    private keeptoo.KButton kButton16;
    private keeptoo.KButton kButton17;
    private keeptoo.KButton kButton18;
    private keeptoo.KButton kButton2;
    private keeptoo.KButton kButton3;
    private keeptoo.KButton kButton4;
    private keeptoo.KButton kButton5;
    private keeptoo.KButton kButton6;
    private keeptoo.KButton kButton7;
    private keeptoo.KButton kButton8;
    private keeptoo.KButton kButton9;
    private javax.swing.JTextField markingExternalEssay;
    private javax.swing.JCheckBox markingExternalEssayEd;
    private javax.swing.JTextField markingInternalEssay;
    private javax.swing.JCheckBox markingInternalEssayEd;
    private javax.swing.JTextField markingInternalMCQ;
    private javax.swing.JCheckBox markingInternalMCQEd;
    private javax.swing.JTextField moderator1Hr;
    private javax.swing.JCheckBox moderator1HrEd;
    private javax.swing.JTextField moderator2Hr;
    private javax.swing.JCheckBox moderator2HrEd;
    private javax.swing.JTextField moderator3Hr;
    private javax.swing.JCheckBox moderator3HrEd;
    private javax.swing.JTextField moderatorMCQ;
    private javax.swing.JCheckBox moderatorMCQEd;
    private javax.swing.JTextField packeting;
    private javax.swing.JCheckBox packetingEd;
    private javax.swing.JTextField password;
    private javax.swing.JPanel pp1;
    private javax.swing.JPanel pp2;
    private javax.swing.JPanel pp3;
    private javax.swing.JPanel pp5;
    private javax.swing.JPanel pp6;
    private javax.swing.JPanel pphome;
    private javax.swing.JLabel rates;
    private javax.swing.JTextField setter1Hr;
    private javax.swing.JCheckBox setter1HrEd;
    private javax.swing.JTextField setter2Hr;
    private javax.swing.JCheckBox setter2HrEd;
    private javax.swing.JTextField setter3Hr;
    private javax.swing.JCheckBox setter3HrEd;
    private javax.swing.JTextField setterMCQ;
    private javax.swing.JCheckBox setterMCQEd;
    private javax.swing.JPanel sideBar;
    private javax.swing.JLabel subAdd;
    private javax.swing.JTable subTable;
    private javax.swing.JTextField supervision;
    private javax.swing.JCheckBox supervisionEd;
    private javax.swing.JTextField supervisor;
    private javax.swing.JCheckBox supervisorEd;
    private javax.swing.JLabel time;
    private javax.swing.JPanel topBar;
    private javax.swing.JTextField typing;
    private javax.swing.JCheckBox typingEd;
    private javax.swing.JPanel useradd;
    private javax.swing.JTextField username;
    private javax.swing.JLabel userp;
    private javax.swing.JTable usertable;
    private javax.swing.JComboBox<String> usertype;
    private javax.swing.JLabel welcome;
    private org.jdesktop.beansbinding.BindingGroup bindingGroup;
    // End of variables declaration//GEN-END:variables

    private void sqlite3_finalize() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
