package com.hamezboi.ctr;

import com.tterrag.registrate.util.entry.ItemEntry;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;

/**
 * Item registration. Each item overrides its model to borrow a vanilla texture, so the
 * template builds with no texture files of its own. Point the model at your own texture,
 * or remove the override and add assets/ctr/textures/item/name.png.
 */
public class AllItems {

    public static final ItemEntry<Item> EXAMPLE_ITEM = CTR.REGISTRATE
            .item("example_item", Item::new)
            .model((c, p) -> p.generated(c::getEntry, new ResourceLocation("minecraft", "item/amethyst_shard")))
            .register();

    /**
     * Output of the sequenced assembly and several other example recipes.
     */
    public static final ItemEntry<Item> EXAMPLE_RESULT = CTR.REGISTRATE
            .item("example_result", Item::new)
            .model((c, p) -> p.generated(c::getEntry, new ResourceLocation("minecraft", "item/netherite_ingot")))
            .register();

    /**
     * Transitional item carried between the steps of the sequenced assembly recipe.
     */
    public static final ItemEntry<Item> INCOMPLETE_EXAMPLE = CTR.REGISTRATE
            .item("incomplete_example", Item::new)
            .model((c, p) -> p.generated(c::getEntry, new ResourceLocation("minecraft", "item/brick")))
            .register();

    public static void register() {
        // Force class loading to trigger Registrate calls
    }
}
