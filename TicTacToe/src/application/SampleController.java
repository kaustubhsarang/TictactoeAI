package application;

import java.util.Random;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class SampleController {
	
	@FXML private Button button1;
	@FXML private Button button2;
	@FXML private Button button3;
	@FXML private Button button4;
	@FXML private Button button5;
	@FXML private Button button6;
	@FXML private Button button7;
	@FXML private Button button8;
	@FXML private Button button9;
	@FXML private Button play;
	@FXML private Button Player;
	@FXML private Button Computer;
	@FXML private Label label;
	 private boolean run;
	int player = 1;
	int[][] pos = new int[3][3];
	Game g = new Game();
	
	@FXML private void game(ActionEvent event)
	{
		Random rand = new Random();
		//Game g=null;
		//if(g==null) {
		// g = new Game();
		// }
		String id;
		Button btn = (Button) event.getSource();
		id = btn.getId();
		boolean flag;
		int but;
		if(player==2)
		{
			label.setText("Players turn");
		}
		/*
		 * else { label.setText("Player "+player+" turn"); }
		 */
		if(id.contains("play"))
		{
			enable();
		}
		if(id.contains("Computer"))
		{
			Point p = new Point(rand.nextInt(3),rand.nextInt(3));
			g.placeAMove(p, 1);	
			setButton(p, 1);
		
		}
		Point userMove=new Point(-1,-1);
		
		//while(!g.isGameOver())
		if(!g.isGameOver())
		{
			if(!id.contains("Computer")) {
			if(!id.contains("play")) {
			if(id.contains("button1")) {userMove = new Point(0,0);}if(id.contains("button2")) {userMove = new Point(0,1);}
			if(id.contains("button3")) {userMove = new Point(0,2);}if(id.contains("button4")) {userMove = new Point(1,0);}
			if(id.contains("button5")) {userMove = new Point(1,1);}if(id.contains("button6")) {userMove = new Point(1,2);}
			if(id.contains("button7")) {userMove = new Point(2,0);}if(id.contains("button8")) {userMove = new Point(2,1);}
			if(id.contains("button9")) {userMove = new Point(2,2);}
			g.placeAMove(userMove,2);
			setButton(userMove,2);
			//if (g.isGameOver()) break;
			g.minimax(0, 1);              
            g.placeAMove(g.computersMove, 1);
            setButton(g.computersMove, 1);
            id="play";
		//} 
			}}
		}
		if(g.isGameOver()) {
		if (g.hasXWon()) {
            System.out.println("Unfortunately, you lost!");
			label.setText("Computer won...booo!!!");}
        else if (g.hasOWon()) {
            System.out.println("You win!"); //Can't happen
		label.setText("You won!!!!Yipeee");}
        else {
            System.out.println("It's a draw!");
            label.setText("It's a draw!!!");}
		}
		
	}
	
	
	
	public void disable()
	{
		button1.setDisable(true);
		button2.setDisable(true);
		button3.setDisable(true);
		button4.setDisable(true);
		button5.setDisable(true);
		button6.setDisable(true);
		button7.setDisable(true);
		button8.setDisable(true);
		button9.setDisable(true);
		Player.setDisable(true);
		Computer.setDisable(true);
	}
	public void enable()
	{
		int i,j;
		button1.setDisable(false);button1.setText("");
		button2.setDisable(false);button2.setText("");
		button3.setDisable(false);button3.setText("");
		button4.setDisable(false);button4.setText("");
		button5.setDisable(false);button5.setText("");
		button6.setDisable(false);button6.setText("");
		button7.setDisable(false);button7.setText("");
		button8.setDisable(false);button8.setText("");
		button9.setDisable(false);button9.setText("");
		Player.setDisable(false);
		Computer.setDisable(false);
		player=1;
		for(i=0;i<3;i++)
		{
			for(j=0;j<3;j++)
			{
				pos[i][j]=0;
			}
		}
		
		label.setText("Player "+player+" turn");
	}
	
	public void set()
	{
		if(player==1)
		{
			label.setText("Player 2 wins");
		}
		else
		{
			label.setText("Player 1 wins");
		}
		disable();
	}
	
	
	public void setButton(Point p, int player) {
		String str="";
		if(p.x==0 && p.y==0) {str="button1";}if(p.x==0 && p.y==1) {str="button2";}if(p.x==0 && p.y==2) {str="button3";}
		if(p.x==1 && p.y==0) {str="button4";}if(p.x==1 && p.y==1) {str="button5";}if(p.x==1 && p.y==2) {str="button6";}
		if(p.x==2 && p.y==0) {str="button7";}if(p.x==2 && p.y==1) {str="button8";}if(p.x==2 && p.y==2) {str="button9";}
			
	
	if(str.contains("button1"))
	{
		button1.setDisable(true);
		//but=1;
		if(player==1)
		{
			button1.setText("X");
		}
		else
		{
			button1.setText("0");
		}			
		//setpos(but);
		//label.setText("Player"+player+" turn");				
		
	}
	else if(str.contains("button2"))
	{
		button2.setDisable(true);
		
		if(player==1)
		{
			button2.setText("X");
		}
		else
		{
			button2.setText("0");
		}	
		
		//label.setText("Player "+player+" turn");
		
	}
	else if(str.contains("button3"))
	{	
		button3.setDisable(true);
		
		if(player==1)
		{
			button3.setText("X");
		}
		else
		{
			button3.setText("0");
		}	
		
		//label.setText("Player "+player+" turn");
		
	}
	else if(str.contains("button4"))
	{	
		button4.setDisable(true);
		
		if(player==1)
		{
			button4.setText("X");
		}
		else
		{
			button4.setText("0");
		}	
		
		//label.setText("Player "+player+" turn");
	}
	else if(str.contains("button5"))
	{	
		button5.setDisable(true);
		
		if(player==1)
		{
			button5.setText("X");
		}
		else
		{
			button5.setText("0");
		}	
		
		//label.setText("Player "+player+" turn");
		
	}
	else if(str.contains("button6"))
	{	
		button6.setDisable(true);
		if(player==1)
		{
			button6.setText("X");
		}
		else
		{
			button6.setText("0");
		}	
		//label.setText("Player "+player+" turn");
	}
	else if(str.contains("button7"))
	{	
		button7.setDisable(true);
		if(player==1)
		{
			button7.setText("X");
		}
		else
		{
			button7.setText("0");
		}	
		//label.setText("Player "+player+" turn");
		
	}
	else if(str.contains("button8"))
	{	
		button8.setDisable(true);
		if(player==1)
		{
			button8.setText("X");
		}
		else
		{
			button8.setText("0");
		}	
	
		//label.setText("Player "+player+" turn");
		
	}
	else if(str.contains("button9"))
	{
		button9.setDisable(true);
		
		if(player==1)
		{
			button9.setText("X");
		}
		else
		{
			button9.setText("0");
		}	
		;
		//label.setText("Player "+player+" turn");
		
	}}
}
