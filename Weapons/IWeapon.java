package Weapons;

import Entities.Entity;

public interface IWeapon {

    void attack(Entity player, Entity enemy);

    String getName();
    double getBaseDamage();
    double getManaCost();
    double getRequiredStrength();
    double getRequiredDexterity();
    double getRequiredIntelligence();
}