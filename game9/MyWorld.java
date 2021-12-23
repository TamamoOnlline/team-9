import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MyWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MyWorld extends World
{

    /**
     * Constructor for objects of class MyWorld.
     * 
     */
    public MyWorld()
    {    
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels.
        super(1000, 650, 1); 
        addObject( new egg(), 100, 600 );
        
        // Create a new world with 600x400 cells with a cell size of 1x1 pixels. 
        
        int blocksize = 50;
        int y = 650;
        for(int x = blocksize/2;x<=1000-blocksize/2;x+=blocksize){
            addObject( new Load(), x, y);            
        }
        addObject( new Load(), 350, y-blocksize);            
        
    }
}
