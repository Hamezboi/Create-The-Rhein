package com.hamezboi.ctr.content.engines.digital;

import com.simibubi.create.foundation.fluid.CombinedTankWrapper;

import net.minecraft.core.BlockPos;
import net.minecraft.world.level.block.entity.BlockEntityType;
import net.minecraft.world.level.block.state.BlockState;

import net.minecraftforge.common.capabilities.ForgeCapabilities;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.fluids.capability.IFluidHandler;

public abstract class AbstractSteamEngineBlockEntity
        extends com.simibubi.create.content.kinetics.base.KineticBlockEntity {

    public SteamEngineFluidTank steamTank;
    public LazyOptional<IFluidHandler> fluidCapability;

    public float rpm = 0;
    public float steamInjectionRate = 0;

    public boolean reverse = false;

    public int highestSignal;
    public int signal;

    public boolean signalChanged;

    public int steamConsumptionTimer = 0;

    public AbstractSteamEngineBlockEntity(
            BlockEntityType<?> type,
            BlockPos pos,
            BlockState state
    ) {
        super(type, pos, state);

        steamTank = new SteamEngineFluidTank(
                4000,
                false,
                true,
                null
        );

        fluidCapability = LazyOptional.of(
                () -> new CombinedTankWrapper(steamTank)
        );

        refreshCapability();
    }
    
    public void refreshCapability() {
        LazyOptional<IFluidHandler> oldCapability = fluidCapability;

        fluidCapability = LazyOptional.of(
                () -> new CombinedTankWrapper(steamTank)
        );

        oldCapability.invalidate();
    }

    public IFluidHandler handlerForCapability() {
        return new CombinedTankWrapper(steamTank);
    }
}