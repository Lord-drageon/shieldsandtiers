package net.lorddrageon.shieldsandtiers.mixin;

import net.lorddrageon.shieldsandtiers.ShieldsAndTiers;
import net.lorddrageon.shieldsandtiers.item.custom.ParryShieldBase;
import net.minecraft.client.MinecraftClient;
import net.lorddrageon.shieldsandtiers.mixin.ParryCheckMixin;
import net.minecraft.client.network.ClientPlayerEntity;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.Shadow;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;
import org.spongepowered.asm.mixin.injection.callback.LocalCapture;

import javax.annotation.Nullable;
import java.sql.Array;

@Mixin(MinecraftClient.class)//Error in this class. java won't tell me where tho.
public class ParryClientMixin {
    @Shadow @Nullable ClientPlayerEntity player;
    @Inject(method = "handleInputEvents", at = @At(value = "INVOKE", target = "Lnet/minecraft/client/MinecraftClient;doAttack()Z", ordinal = 1), cancellable = true)
    public void onLeftClick(CallbackInfo info) {

        if(player != null && !player.isSpectator() && player.getMainHandStack().getItem() instanceof ParryShieldBase) {
            try {
                //player.isParryClicking=true;
                //player.ParryClickTimer=15;

            }catch (Exception e){

            }

            info.cancel();
        }
    }




}
