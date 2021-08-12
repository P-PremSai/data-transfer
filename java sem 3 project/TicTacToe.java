import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
class TicTacToe implements ActionListener {
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_Panel = new JPanel();
    JPanel button_panel= new JPanel();
    JLabel text_field= new JLabel();
    JButton[] buttons= new JButton[15];
    boolean player1_turn;
    int count_X=0,count_O=0;
    TicTacToe(){
        ImageIcon image = new ImageIcon("tictactoe.png");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(700,800);
        frame.getContentPane().setBackground(new Color(100,100,100));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);
        frame.setTitle("Tic Tac Toe");

        text_field.setBackground(new Color(25,25,25));
        text_field.setForeground(new Color(25,255,0));
        text_field.setFont(new Font("Ink Free",Font.BOLD,75));
        text_field.setHorizontalAlignment(JLabel.CENTER);
        text_field.setText("Tic-Tac-Toe");
        text_field.setOpaque(true);

        title_Panel.setLayout(new BorderLayout());
        title_Panel.setBounds(0,0,800,100);

        button_panel.setLayout(new GridLayout(5,3));
        button_panel.setBackground(new Color(125,125,125));

        for(int i=0;i<15;i++){
            buttons[i]=new JButton();
            button_panel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,100));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
        }
        for(int i=0;i<9;i++){
            buttons[i].setBackground(new Color(255,187,51));
        }

        buttons[9].setFont(new Font("Monaco",Font.BOLD,35));
        buttons[9].setText("Reset");
        buttons[12].setFont(new Font("Monaco",Font.BOLD,40));
        buttons[12].setText("Exit");

        buttons[10].setFont(new Font("MV Boli",Font.BOLD,30));
        buttons[10].setText("Player X");
        buttons[10].setEnabled(false);
        buttons[10].setBackground(new Color(102,255,255));
        buttons[11].setFont(new Font("MV Boli",Font.BOLD,30));
        buttons[11].setText("Player O");
        buttons[11].setEnabled(false);
        buttons[11].setBackground(new Color(102,255,255));

        buttons[13].setFont(new Font("Monaco",Font.BOLD,75));
        buttons[13].setText("0");
        buttons[13].setEnabled(false);
        buttons[13].setBackground(new Color(170,255,128));
        buttons[14].setFont(new Font("Monaco",Font.BOLD,75));
        buttons[14].setText("0");
        buttons[14].setEnabled(false);
        buttons[14].setBackground(new Color(170,255,128));

        title_Panel.add(text_field);
        frame.add(title_Panel,BorderLayout.NORTH);
        frame.add(button_panel);
        frame.setIconImage(image.getImage());

        firstTurn();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        for(int i=0;i<9;i++){
            if(e.getSource()==buttons[i]){
                if(player1_turn){
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("O");
                        player1_turn=false;
                        text_field.setText("player X's turn");
                        check();
                    }
                }
                else{
                    if(buttons[i].getText()==""){
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText("X"); 
                        player1_turn=true;
                        text_field.setText("player O's turn");
                        check();
                    }
                }
            }

        }
        if(e.getSource()==buttons[9]){
            for(int i=0;i<9;i++){
                buttons[i].setEnabled(true);
                buttons[i].setText("");
                buttons[i].setBackground(new Color(255,187,51));
            }
        } 
        if(e.getSource()==buttons[12]){
            System.exit(0);
        }  
    }
    public void firstTurn() {
        if(random.nextInt(2)==0){
            player1_turn=true;
            text_field.setText("player O's turn");
        }
        else{
            player1_turn=false;
            text_field.setText("player X's turn");
        }
    }
    public void check(){
        if((buttons[0].getText()!="") &&
        (buttons[1].getText()!="") &&
        (buttons[2].getText()!="") &&
        (buttons[3].getText()!="") &&
        (buttons[4].getText()!="") &&
        (buttons[5].getText()!="") &&
        (buttons[6].getText()!="") &&
        (buttons[7].getText()!="") &&
        (buttons[8].getText()!="")){
         matchDraw();
        }
        if((buttons[0].getText()=="X") 
             && (buttons[1].getText()=="X")
             && (buttons[2].getText()=="X")){
                 xwins(0, 1, 2);
        }
        if((buttons[3].getText()=="X") 
             && (buttons[4].getText()=="X")
             && (buttons[5].getText()=="X")){
                 xwins(3, 4, 5);
        }
        if((buttons[6].getText()=="X") 
             && (buttons[7].getText()=="X")
             && (buttons[8].getText()=="X")){
                 xwins(6, 7, 8);
        }
        if((buttons[0].getText()=="X") 
             && (buttons[3].getText()=="X")
             && (buttons[6].getText()=="X")){
                 xwins(0, 3, 6);
        }
        if((buttons[1].getText()=="X") 
             && (buttons[4].getText()=="X")
             && (buttons[7].getText()=="X")){
                 xwins(1, 4, 7);
        }
        if((buttons[2].getText()=="X") 
             && (buttons[5].getText()=="X")
             && (buttons[8].getText()=="X")){
                 xwins(2, 5, 8);
        }
        if((buttons[0].getText()=="X") 
             && (buttons[4].getText()=="X")
             && (buttons[8].getText()=="X")){
                 xwins(0, 4, 8);
        }
        if((buttons[2].getText()=="X") 
             && (buttons[4].getText()=="X")
             && (buttons[6].getText()=="X")){
                 xwins(2, 4, 6);
        }
        if((buttons[0].getText()=="O") 
             && (buttons[1].getText()=="O")
             && (buttons[2].getText()=="O")){
                 owins(0, 1, 2);
        }
        if((buttons[3].getText()=="O") 
             && (buttons[4].getText()=="O")
             && (buttons[5].getText()=="O")){
                 owins(3, 4, 5);
        }
        if((buttons[6].getText()=="O") 
             && (buttons[7].getText()=="O")
             && (buttons[8].getText()=="O")){
                 owins(6, 7, 8);
        }
        if((buttons[0].getText()=="O") 
             && (buttons[3].getText()=="O")
             && (buttons[6].getText()=="O")){
                 owins(0, 3, 6);
        }
        if((buttons[1].getText()=="O") 
             && (buttons[4].getText()=="O")
             && (buttons[7].getText()=="O")){
                 owins(1, 4, 7);
        }
        if((buttons[2].getText()=="O") 
             && (buttons[5].getText()=="O")
             && (buttons[8].getText()=="O")){
                 owins(2, 5, 8);
        }
        if((buttons[0].getText()=="O") 
             && (buttons[4].getText()=="O")
             && (buttons[8].getText()=="O")){
                 owins(0, 4, 8);
        }
        if((buttons[2].getText()=="O") 
             && (buttons[4].getText()=="O")
             && (buttons[6].getText()=="O")){
                 owins(2, 4, 6);
        }
    }
    public void xwins(int a,int b,int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        text_field.setText("Player X won");
        count_X+=1;
        buttons[13].setText(Integer.toString(count_X));
    }
    public void owins(int a,int b,int c){
        buttons[a].setBackground(Color.GREEN);
        buttons[b].setBackground(Color.GREEN);
        buttons[c].setBackground(Color.GREEN);

        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        text_field.setText("Player O won");
        count_O+=1;
        buttons[14].setText(Integer.toString(count_O));
    }
    public void matchDraw(){
        for(int i=0;i<9;i++){
            buttons[i].setEnabled(false);
        }
        text_field.setText("Match Draw");
    }
}
class main {
    public static void main(String[] args) {
        TicTacToe tictactoe = new TicTacToe();
    }
}
