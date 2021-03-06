package SSM.Attributes;

import SSM.Attribute;
import SSM.Attributes.DoubleJumps.DoubleJump;
import SSM.GameManagers.KitManager;
import SSM.Utilities.Utils;
import org.bukkit.block.BlockFace;
import org.bukkit.util.Vector;

public class Climb extends Attribute {

    protected double power;
    protected boolean chargedDoubleJump;

    public Climb(double power) {
        super();
        this.name = "Spider Climb";
        this.expUsed = 0.01f;
        this.power = power;
        this.chargedDoubleJump = false;
        task = this.runTaskTimer(plugin, 0L, 1L);
    }

    @Override
    public void run() {
        if (Utils.playerIsOnGround(owner)) {
            chargedDoubleJump = false;
        }
        if (!owner.isSneaking()) {
            return;
        }
        checkAndActivate();
    }

    public void activate() {
        for (BlockFace face : BlockFace.values()) {
            if (!owner.getLocation().getBlock().getRelative(face).isPassable()) {
                owner.setVelocity(new Vector(0, power, 0));
                if(!chargedDoubleJump) {
                    KitManager.getPlayerKit(owner).getAttributes().forEach(attribute -> {
                        if(attribute instanceof DoubleJump) {
                            DoubleJump dj = (DoubleJump) attribute;
                            dj.resetDoubleJumps();
                            chargedDoubleJump = true;
                        }
                    });
                }
                break;
            }
        }
    }

}
