package net.github.claraworlddom.serilis.common.items;

import net.minecraft.tags.BlockTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.LazyLoadedValue;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.Tier;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.level.block.Block;

import java.util.function.Supplier;

public enum ItemTiers implements Tier {
    BONE(BlockTags.INCORRECT_FOR_WOODEN_TOOL, 12, 3.5F, 0.0F, 0, () -> Ingredient.of(Items.BONE));

    private final TagKey<Block> incorrectBlocksForDrops;
    private final int uses;
    private final float speed;
    private final float damage;
    private final int enchantmentValue;
    private final LazyLoadedValue<Ingredient> repairIngredient;

    private ItemTiers(TagKey<Block> incorrectblockfordrops, int uses, float speed, float damagebonus, int enchantmentval, Supplier<Ingredient> itemrepair) {
        this.incorrectBlocksForDrops = incorrectblockfordrops;
        this.uses = uses;
        this.speed = speed;
        this.damage = damagebonus;
        this.enchantmentValue = enchantmentval;
        this.repairIngredient = new LazyLoadedValue<>(itemrepair);
    }

    public int getUses() {
        return this.uses;
    }

    public float getSpeed() {
        return this.speed;
    }

    public float getAttackDamageBonus() {
        return this.damage;
    }

    @Override
    public TagKey<Block> getIncorrectBlocksForDrops() {
        return this.incorrectBlocksForDrops;
    }

    public int getEnchantmentValue() {
        return this.enchantmentValue;
    }

    public Ingredient getRepairIngredient() {
        return this.repairIngredient.get();
    }
}
