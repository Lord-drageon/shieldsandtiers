package net.lorddrageon.shieldsandtiers.item.custom;

import com.github.crimsondawn45.fabricshieldlib.lib.object.FabricShieldItem;
import net.lorddrageon.shieldsandtiers.ShieldsAndTiers;
import net.minecraft.block.BlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.LivingEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.UseAction;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;

public class ParryShieldBase extends FabricShieldItem {
    public float DamageThreshold;
    protected int recoveryTicks=45;
    public boolean isParrying=false;
    public int parryTimer=0;

    public  ParryShieldBase(Settings settings, int cooldownTicks,int enchantibility){
        super(settings,cooldownTicks,enchantibility, Items.AIR);
    }
    public boolean isParrying(){
        return  isParrying;
    }
    public float getDamageThreshold(){return DamageThreshold;}
    /*@Override
    public boolean postMine(ItemStack stack, World world, BlockState state, BlockPos pos, LivingEntity miner) {
        if(miner.isUsingItem()&&!stack.isEmpty()&&miner.isPlayer()){
            PlayerEntity playr=(PlayerEntity) miner;
            Item item=stack.getItem();
            if(item.getUseAction(stack)!= UseAction.BLOCK){
                return false;

            }else{
                isParrying=true;
                parryTimer=15;
                playr.getItemCooldownManager().set(stack.getItem(),15+recoveryTicks);
                ShieldsAndTiers.LOGGER.info("tried to parry");
                return true;
            }

        }
        return false;
    }*/
    @Override
    public void inventoryTick(ItemStack stack, World world, Entity entity, int slot, boolean selected) {
if(parryTimer>0){
    parryTimer--;
}else{
    parryTimer=0;
    ShieldsAndTiers.LOGGER.info("test");
}
        if(parryTimer==0&&isParrying) {
            isParrying = false;
            setCoolDownTicks(recoveryTicks);
        }
    }

}
