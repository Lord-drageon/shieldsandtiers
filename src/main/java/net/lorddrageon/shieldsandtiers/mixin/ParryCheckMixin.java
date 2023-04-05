package net.lorddrageon.shieldsandtiers.mixin;

import net.lorddrageon.shieldsandtiers.ShieldsAndTiers;
import net.lorddrageon.shieldsandtiers.item.custom.ParryShieldBase;
import net.minecraft.client.MinecraftClient;
import net.minecraft.entity.damage.DamageSource;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.Unique;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.ModifyArg;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import net.minecraft.client.network.ClientPlayerEntity;
import net.minecraft.util.Hand;

import javax.annotation.Nullable;

@Mixin(ClientPlayerEntity.class)
public class ParryCheckMixin {

    @Shadow public boolean isParryClicking;
    @Shadow public int ParryClickTimer;


    @Inject(method = "applyDamage", at = @At(value = "HEAD", ordinal = 0))
    public void applyDamage(DamageSource source, float amount,CallbackInfo info, ClientPlayerEntity player){
        if(player==null){
            ShieldsAndTiers.LOGGER.info("couldn't find player");
            return;
        }
        if(isParryClicking&&(player.getMainHandStack().getItem() instanceof ParryShieldBase||
                player.getOffHandStack().getItem() instanceof ParryShieldBase)){

            Item handItem;
            ShieldsAndTiers.LOGGER.info("parried?");
            if(player.getMainHandStack().getItem() instanceof ParryShieldBase){
                handItem=(ParryShieldBase)player.getMainHandStack().getItem();
            }else{
                handItem=(ParryShieldBase)player.getOffHandStack().getItem();
            }
            try{
                ((ParryShieldBase) handItem).isParrying=true;
                ((ParryShieldBase) handItem).parryTimer=15;
                if(amount< ((ParryShieldBase) handItem).getDamageThreshold()) {
                        source.getSource().damage(source, amount);
                }

            }catch(Exception e){
                //the shield isnt a parrying shield, not sure how you got there but whatever
            }
            amount=0;
        }

    }

    @Inject(method = "tick",at=@At("HEAD"))public void tick(CallbackInfo info){
        if(ParryClickTimer>0){
            ParryClickTimer--;
        }else{
            ParryClickTimer=0;
        }
    }

}
