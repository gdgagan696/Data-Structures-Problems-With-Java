package dsquestions.strings;

public class RobotBoundedInCircle {

    public static boolean isRobotBounded(String instructions) {

        int distanceX=0;
        int distanceY=0;
        char dir='N';
        for(char ch:instructions.toCharArray()){
            if(ch=='G'){
                if(dir=='N'){
                    distanceY++;
                }
                else if(dir=='S'){
                    distanceY--;
                }
                else if(dir=='W'){
                    distanceX++;
                }
                else if(dir=='E'){
                    distanceX--;
                }
            }
            else if(ch=='L'){
                if(dir=='N'){
                    dir='W';
                }
                else if(dir=='S'){
                    dir='E';
                }
                else if(dir=='W'){
                    dir='S';
                }
                else if(dir=='E'){
                    dir='N';
                }
            }
            else {
                if(dir=='N'){
                    dir='E';
                }
                else if(dir=='S'){
                    dir='W';
                }
                else if(dir=='W'){
                    dir='N';
                }
                else if(dir=='E'){
                    dir='S';
                }
            }
        }
        return (distanceX==0 && distanceY==0) || dir!='N';
    }

    public static void main(String[]args){
        System.out.println(isRobotBounded("LGR"));
    }
}
