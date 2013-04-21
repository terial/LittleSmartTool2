/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package littlesmarttool2.model;

import java.util.ArrayList;

/**
 *
 * @author Rasmus
 */
public class Configuration {
    private OutputType outputType;
    private ArrayList<Channel> channels = new ArrayList<>();
    private int irFreq;
    
    public Configuration()
    {
        channels.add(new Channel(1));
        channels.add(new Channel(2));
        channels.add(new Channel(3));
        channels.add(new Channel(4));
    }
    
    public OutputType getOutputType()
    {
        return outputType;
    }
    
    public void setOutputType(OutputType type)
    {
        this.outputType = type;
    }
    
    public ArrayList<Channel> getChannels()
    {
        return channels;
    }
    
    public int getIRFreq()
    {
        return irFreq;
    }
    public void setIRFreq(int freq)
    {
        this.irFreq = freq;
    }
    
}
