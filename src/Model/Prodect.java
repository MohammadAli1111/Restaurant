/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import javafx.scene.control.Button;

/**
 *
 * @author Mohammad
 */
public class Prodect {
    
    String Type;
    String Name;
    float Price;

    public Prodect() {
    }

    public Prodect(String Type, String name, float price) {
        this.Type = Type;
        this.Name = name;
        this.Price = price;
        
        
        
    }

    public String getType() {
        return Type;
    }

    public void setType(String Type) {
        this.Type = Type;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        this.Name = name;
    }

    public float getPrice() {
        return Price;
    }

    public void setPrice(float price) {
        this.Price = price;
    }
    
    
    
}
