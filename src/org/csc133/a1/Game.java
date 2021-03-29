package org.csc133.a1;
import com.codename1.charts.util.ColorUtil;
import com.codename1.ui.Form;
import com.codename1.ui.events.ActionListener;
import com.codename1.ui.Label;
import com.codename1.ui.TextField;
import com.codename1.ui.events.ActionEvent;
import com.codename1.ui.layouts.BoxLayout;

import java.lang.String;
    public class Game extends Form {
    private GameWorld gw;
    //private Helicopter heli;

    public Game() {
        gw = new GameWorld();
        //heli = new Helicopter();

        gw.init();
        play();
    }

    char commands = 'z';
    char a = 'a';  //accelerate
    char b = 'b';  //brake
    char l = 'l';  //left
    char r = 'r'; //right
    char c = 'c'; //collision with helicopter
    char e = 'e';  //refueling blimp
    char g = 'g'; //bird collision gummed up helicopter
    char t = 't'; //time clock ticked
    char d = 'd'; //display
    char m = 'm'; //show map
    char x = 'x'; //call system.exit(0)
    char y = 'y'; //yes
    char n = 'n'; //no


    private void play() {

        Label myLabel = new Label("Enter a Command:");
        this.addComponent(myLabel);
        final TextField myTextField = new TextField();
        this.addComponent(myTextField);
        this.show();
        myTextField.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent evt) {
                String sCommand = myTextField.getText().toString();
                if (sCommand == null || sCommand.equals(""))
                    return;
                myTextField.clear();

                switch (sCommand.charAt(0)) { //beginning of switch statement
                    case '1':
                    case '9':
                    case '8':
                    case '7':
                    case '6':
                    case '5':
                    case '4':
                    case '3':
                    case '2':
                        gw.skyScrapeCheckpoint();
                        break;

                    case 'a':


                        gw.accelerate();
                        break;
                    case 'b':
                        gw.brake();
                        break;

                    case 'l':
                        gw.turnLeft();
                        break;

                    case 'r': //right
                        gw.turnRight();
                        break;

                    case 'c':
                        gw.heliCollision();
                        break;

                    case 'e':  //refueling blimp
                        gw.fuelBlimp();
                        break;

                    case 'g': //bird collision gummed up helicopter
                        gw.birdCollision();
                        break;

                    case 't': //time clock ticked
                        gw.clockTick();
                        break;

                    case 'd': //display
                        gw.showDisplay();
                        break;

                    case 'm':
                        gw.showMap();
                        break;
                   case 'x':  // this will exit the game


                       System.out.print("Are you sure you want to quit?\n ");
                        break;
                    case 'y':
                            System.exit(0);
                    case 'n':

                        System.out.print("Ok, let's keep going!\n");
                         break;
                    default:
                        System.out.println("You entered an incorrect character, Try again");
                        break;
                        }



                }
            });
        }
    }


















