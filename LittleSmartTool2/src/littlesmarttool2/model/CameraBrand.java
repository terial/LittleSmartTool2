/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package littlesmarttool2.model;

/**
 *
 * @author amrcher89
 */
public class CameraBrand {

    private String name;
    private CameraModel[] models;

    public CameraBrand(String name, CameraModel[] models){
        this.name = name;
        this.models = models;
    }
    
    public String getName() {
        return name;
    }

    public CameraModel[] getModels() {
        return models;
    }
    
    @Override
    public String toString() {
        return getName();
    }
}
