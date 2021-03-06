package SSM.Kits;

import SSM.Abilities.WolfStrike;
import SSM.Attributes.DoubleJumps.DirectDoubleJump;
import SSM.Attributes.Ravage;
import SSM.Attributes.Regeneration;
import SSM.Kit;
import org.bukkit.Material;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class KitWolf extends Kit {

    public KitWolf() {
        super();
        this.damage = 5;
        this.armor = 4.5;
        this.speed = 0.2f;
        this.regeneration = 0.25;
        this.knockback = 1.6;
        this.name = "Wolf";
        this.menuItem = Material.BONE;
    }

    public void equipKit(Player player) {
        super.equipKit(player);

        setArmor(Material.CHAINMAIL_LEGGINGS, 1);
        setArmor(Material.CHAINMAIL_CHESTPLATE, 2);

        setItem(Material.IRON_AXE, 0);
        setItem(Material.IRON_SHOVEL, 1, new WolfStrike());

        addAttribute(new Regeneration(regeneration, 1));
        addAttribute(new DirectDoubleJump(1.0, 0.2, 1, Sound.ENTITY_GHAST_SHOOT));
        addAttribute(new Ravage(8, 1, 3));

    }

}
