package net.mineset.patheo.games.pet;

import net.minecraft.server.v1_8_R3.Navigation;
import net.minecraft.server.v1_8_R3.PathEntity;
import net.minecraft.server.v1_8_R3.PathfinderGoal;

public class PathfinderGoalFollowPetOwner extends PathfinderGoal {

    private double speed;

    private Pet pet;

    private Navigation navigation;

    public PathfinderGoalFollowPetOwner(Pet pet, double speed) {
        this.pet = pet;
        this.navigation = (Navigation) this.pet.getNavigation();
        this.speed = speed;
    }

    @Override
    public void c() {
        PathEntity pathEntity = this.navigation.a(
                pet.getOwner().getLocation().getX() + 1,
                pet.getOwner().getLocation().getY() + 1,
                pet.getOwner().getLocation().getZ() + 1);

        this.navigation.a(pathEntity, speed);
    }

    @Override
    public void e() {
        c();
    }

    @Override
    public boolean a() {
        return true;
    }
}
