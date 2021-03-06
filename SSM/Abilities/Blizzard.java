package SSM.Abilities;

import SSM.Ability;
import SSM.EntityProjectile;
import SSM.GameManagers.OwnerEvents.OwnerRightClickEvent;
import org.bukkit.entity.Player;
import org.bukkit.entity.Snowball;
import org.bukkit.event.player.PlayerInteractEvent;

public class Blizzard extends Ability implements OwnerRightClickEvent {

    int BlizzardAmount = 5;

    public Blizzard() {
        super();
        this.name = "Blizzard";
        this.cooldownTime = 0;
        this.expUsed = 0.2F;
    }

    public void onOwnerRightClick(PlayerInteractEvent e) {
        checkAndActivate();
    }

    public void activate() {
        for (int i = 0; i < BlizzardAmount; i++) {
            Snowball firing = owner.getWorld().spawn(owner.getEyeLocation(), Snowball.class);
            EntityProjectile projectile = new EntityProjectile(plugin, owner.getEyeLocation(), name, firing);
            projectile.setFirer(owner);
            projectile.setDamage(1.0);
            projectile.setSpeed(1.0);
            projectile.setKnockback(0.2);
            projectile.setUpwardKnockback(0.1);
            projectile.setHitboxSize(1.0);
            projectile.setSpread(25);
            projectile.launchProjectile();
        }
    }
}
