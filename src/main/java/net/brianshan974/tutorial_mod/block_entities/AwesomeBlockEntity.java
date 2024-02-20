package net.brianshan974.tutorial_mod.block_entities;

import net.fabricmc.fabric.mixin.transfer.ItemMixin;
import net.minecraft.block.BlockState;
import net.minecraft.block.entity.BlockEntity;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.entity.EquipmentSlot;
import net.minecraft.item.ArmorItem;
import net.minecraft.item.ArmorMaterial;
import net.minecraft.item.ArmorMaterials;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Clearable;
import net.minecraft.util.math.BlockPos;

public class AwesomeBlockEntity extends BlockEntity implements Clearable {

    private ItemStack helmet = ItemStack.EMPTY;
    private ItemStack chestplate = ItemStack.EMPTY;
    private ItemStack leggings = ItemStack.EMPTY;
    private ItemStack boots = ItemStack.EMPTY;

    private ArmorMaterial material = null;

    public AwesomeBlockEntity(BlockEntityType<?> type, BlockPos pos, BlockState state) {
        super(type, pos, state);
    }

    public boolean addItem(ItemStack itemStack) {
        ArmorMaterial material;
        if ((material = getMaterial(itemStack)) == null) return false;
        if (this.material == null) this.material = getMaterial(itemStack);
        if (material.equals(ArmorMaterials.TURTLE)) return false;
        if (!material.equals(this.material)) return false;
        EquipmentSlot slot = ((ArmorItem)itemStack.getItem()).getSlotType();
        switch (slot) {
            case HEAD -> {
                if (helmet.equals(ItemStack.EMPTY)) {
                    helmet = itemStack.split(1);
                    return true;
                }
                return false;
            }
            case CHEST -> {
                if (chestplate.equals(ItemStack.EMPTY)) {
                    chestplate = itemStack.split(1);
                    return true;
                }
                return false;
            }
            case LEGS -> {
                if (leggings.equals(ItemStack.EMPTY)) {
                    leggings = itemStack.split(1);
                    return true;
                }
                return false;
            }
            case FEET -> {
                if (boots.equals(ItemStack.EMPTY)) {
                    boots = itemStack.split(1);
                    return true;
                }
                return false;
            }
            default -> {
                return false;
            }
        }
    }

    private ArmorMaterial getMaterial(ItemStack itemStack) {
        if (itemStack.getItem() instanceof ArmorItem armorItem)
            return armorItem.getMaterial();
        return null;
    }

    @Override
    public void clear() {

    }
}
