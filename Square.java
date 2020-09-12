
public class Square {
    int height;
    int v;
    public Square(){
        height = 0;
        v = 0;
    }
    public int getHeight(){
        return height;
    }

    public void jump(){
        if(height == 0){
            v=20;
        }
    }

    public void update(){
        height += v;
        if ( height >= 0) {
            v -= 1;
        }
        else{
            v=0;
            height=0;
        }
    }

}
