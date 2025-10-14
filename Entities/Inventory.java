package Entities;

import Weapons.IWeapon;
import java.util.ArrayList;
import java.util.List;

public class Inventory {
    
    public List<IWeapon> weapons = new ArrayList<>();
    
    public Inventory(List<IWeapon> weapons) {
        this.weapons = weapons;
    }

}
