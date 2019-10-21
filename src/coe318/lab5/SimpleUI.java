package coe318.lab5;
//@author Michael Karimizadeh 500831189
import java.util.Scanner;

public class SimpleUI implements UserInterface {
    private BlackjackGame game;
    private Scanner user = new Scanner(System.in);
    private String ans;
    private int helper=0;
    /*
     * This variable streamlines output and allows the program to only show user information needed to make a decision
     * while hiding what would have been redundant outputs
     * Following start(), helper=1 and stops output
     * UNLESS, user doesn't want cards & house needs cards, there it would output
     * If user needs more cards, helper=0 and the display outputs are reused to ask for decision
     */
  @Override
    public void setGame(BlackjackGame game) {
        this.game = game;
    }

  @Override
    public void display() {
        if (helper==0){
            System.out.println("\nThe house's hand: "+game.getHouseCards());
            System.out.println("Your hand: "+game.getYourCards());
            System.out.println("More cards? (Y/N)");
            do{
                ans = user.nextLine().toUpperCase();
                switch (ans) {//Switch just used to obtain correct input
                    case "Y":
                        break;
                    case "N":
                        break;
                    default:
                        System.out.print("Invalid input, please answer yes (Y), or no (N)");
                        break;
                }
            }while(!(ans.equals("Y")||ans.equals("N")));
            helper=1;//House will not output
        }
        else if(ans.equals("N")){
            System.out.println("\nThe house's hand: "+game.getHouseCards());
            System.out.println("Your hand: "+game.getYourCards());
        }
    }

  @Override
    public boolean hitMe(){
        if(ans.equals("Y")){
            helper=0;//Will perform card dealing after house turn and will ask for input from the user during their turn
            return true;
        }
        return false;
    }

  @Override
    public void gameOver() {
        int pScore,hScore;
        hScore = game.score(game.getHouseCards());
        pScore = game.score(game.getYourCards());
        System.out.println("\n///////////////////////////////////\nGAME FINISHED\n///////////////////////////////////");
        System.out.println("Summary:");
        System.out.println("The house's hand: "+game.getHouseCards());
        System.out.println("Score: "+hScore);
        System.out.println("\nYour hand: "+game.getYourCards());
        System.out.println("Score: "+pScore);
        if(hScore<=21 && pScore<=21){//Winner based on higher score
            if(hScore>pScore){
                System.out.println("Sorry! House is the victor.");
            }else if(pScore>hScore){
                System.out.println("Congrats! You are the the victor.");
            }
            else{
                System.out.println("Hey! It's a draw!");
            }
        }else if(pScore>21 && hScore<=21){//Player goes over 21
            System.out.println("Sorry! House is the victor.");
        }
        else{//House goes over 21
            System.out.println("Congrats! You are the the victor.");
        }
    }
}
