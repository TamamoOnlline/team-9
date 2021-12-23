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
        super(600, 400, 1); 
        
        int blocksize = 50;
        int y = 350;
        for(int x = blocksize/2;x<=600-blocksize/2;x+=blocksize){
            addObject( new Block(), x, y);            
        }
        addObject( new Block(), 250, y-blocksize);            
        addObject( new Block(), 450, y-blocksize*3);            
        
        addObject( new Taro(), 300,100);
    }
}
