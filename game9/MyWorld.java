import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{
    private int time = 0;
    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    
    public MyWorld()
    {    
        
        super(1000, 650, 1);
        showText( "1ぷんかん　にげて！^^", 250, 100 );
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
         Greenfoot.setSpeed(50);
         prepare();
        addObject( new egg(), 100, 600 );
        addObject( new otama(), 600, 400 );
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels. 
        
        int blocksize = 50;
        int y = 650;
        for(int x = blocksize/2;x<=1000-blocksize/2;x+=blocksize){
            addObject( new Load(), x, y);            
        }
        addObject( new Load(), 350, y-blocksize);            
        
    }
    private void prepare()
    {
    time = 3300;
    //adding objects here
    }
    public void act()
{
    time--;
    if (time == 0)
    {
        removeObjects(getObjects(null));
        prepare();
        /** OR **/
        showText( "にげて　どうするの？", 150, 100 );
    }
}
 
}
