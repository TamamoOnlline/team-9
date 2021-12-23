 import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class otama here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class otama extends Actor
{
    
    /**
     * Act - do whatever the otama wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
        Actor actor = getOneIntersectingObject( egg.class );
        private int flag_otama = 0;

            
 
     public void act() 
    {   
            if( flag_otama > 0 ) flag_otama--;
            if( Greenfoot.isKeyDown( "space" ) ){
                if( flag_otama == 0 ){
                getWorld().addObject( new otama(), getX(), getY() );
                flag_otama = 50;  // 数字を変えると発射間隔が変わる
                }   
            }
            if( actor != null ){
                    getWorld().showText( "TAMAGO is DEAD", 500, 500 );
                    Greenfoot.stop();// TAMAGO とぶつかった時の処理を書く
            }       
            if( isAtEdge() ){
                    getWorld().removeObject( this );
                }
            move(-5);  
     
    }   
}
