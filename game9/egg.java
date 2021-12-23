import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class egg here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
    
public class egg extends Actor
{
   
    final int speed_jump = 5;
    final int speed_gravity = 5;
    final int speed_lr = 5;
    final int height_jump = 150;
    final int offset_x = 20;
    final int offset_y = 10;
    
    int i=0;
    int jumping  = 0;
    boolean space_pressed = false;
    /**
     * Act - do whatever the egg wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        int x = getX();
        int y = getY();
        int w = getImage().getWidth();
        int h = getImage().getHeight();
        int dx = 0;
        int dy = 0;        
        boolean grounded = false;
        
        if( jumping == 0 ){
            Actor Load = getOneObjectAtOffset(-offset_x,h/2,Load.class);
            if( Load == null ) Load = getOneObjectAtOffset(offset_x,h/2,Load.class);
            if( Load != null ) grounded = true;
        }
        
        if( Greenfoot.isKeyDown( "a" ) ) dx = -speed_lr;
        if( Greenfoot.isKeyDown( "d" ) ) dx = speed_lr;
        if( Greenfoot.isKeyDown( "space" ) ){
            if( !space_pressed ){
                space_pressed = true;
                if( grounded ) jumping = height_jump/speed_jump;
            }
        }
        else space_pressed = false;            

        // 上下移動
        if( jumping > 0 ){
            dy = -speed_jump;
            --jumping;
        }
        else if( !grounded ){
            dy = speed_gravity;
        }

        // ブロックとの衝突判定
        if( dy < 0 ){
            Actor Load = getOneObjectAtOffset(-offset_x,-h/2+dy,Load.class);
            if( Load == null ) Load = getOneObjectAtOffset(offset_x,-h/2+dy,Load.class);
            if( Load != null ){
                int by = Load.getY();
                int bh = Load.getImage().getHeight();
                dy = (by+bh/2)-(y-h/2);
                jumping = 0;
            }
        }
        if( dy > 0 ){
            Actor Load = getOneObjectAtOffset(-offset_x,h/2+dy,Load.class);
            if( Load == null ) Load = getOneObjectAtOffset(offset_x,h/2+dy,Load.class);
            if( Load != null ){   
                int by = Load.getY();
                int bh = Load.getImage().getHeight();
                dy = (by-bh/2)-(y+h/2);
            } 
        } 
        if( dx < 0 ){
            Actor Load = getOneObjectAtOffset(-w/2+dx,-offset_y+dy,Load.class);
            if( Load == null ) Load = getOneObjectAtOffset(-w/2+dx,offset_y+dy,Load.class);
            if( Load != null ){
                int bx = Load.getX();
                int bw = Load.getImage().getWidth();
                dx = (bx+bw/2)-(x-w/2);
            }
        }
        if( dx > 0 ){
            Actor Load = getOneObjectAtOffset(w/2+dx,-offset_y+dy,Load.class);
            if( Load == null ) Load = getOneObjectAtOffset(w/2+dx,offset_y+dy,Load.class);
            if( Load != null ){
                int bx = Load.getX();
                int bw = Load.getImage().getWidth();
                dx = (bx-bw/2)-(x+w/2);
            }
        }
        
        setLocation( x+dx, y+dy );
        getWorld().showText( "grounded: "+grounded, 100, 20 );
        getWorld().showText( "jumping:  "+jumping, 100, 50 );
        
    }
}
