package com.hamezboi.ctr.content.templatestuff.ponder;

import com.hamezboi.ctr.AllBlocks;
import com.hamezboi.ctr.CTR;

import net.createmod.ponder.api.registration.PonderPlugin;
import net.createmod.ponder.api.registration.PonderSceneRegistrationHelper;
import net.minecraft.resources.ResourceLocation;

/**
 * Ponder plugin for the addon, registered client-side in CTR. registerScenes
 * associates a storyboard with one or more items. Each scene has two parts: a schematic
 * saved as an nbt file under assets/ctr/ponder, whose name matches the id passed
 * to addStoryBoard, and the storyboard code in ExamplePonderScenes.
 */
public class ExamplePonderPlugin implements PonderPlugin {

    @Override
    public String getModId() {
        return CTR.ID;
    }

    @Override
    public void registerScenes(PonderSceneRegistrationHelper<ResourceLocation> helper) {
        helper.forComponents(AllBlocks.EXAMPLE_KINETIC_BLOCK.getId())
                .addStoryBoard("example_ponder", ExamplePonderScenes::examplePonder);

        helper.forComponents(com.simibubi.create.AllBlocks.DESK_BELL.getId())
                .addStoryBoard("desk_bell", DeskbellScenes::intro);
    }
}
