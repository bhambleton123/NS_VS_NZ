package models.characters.tools;

import javafx.scene.image.Image;

public class AnimatedImage
{
    // assumes animation loops,
    //  each image displays for equal time
    public Image[] frames;
    public double duration;
    
    public AnimatedImage(Image[] frames, double duration) {
    	this.frames = frames;
    	this.duration = duration;
    }
    
    public Image getFrame(double time)
    {
        int index = (int)((time % (frames.length * duration)) / duration);
        return frames[index];
    }
}