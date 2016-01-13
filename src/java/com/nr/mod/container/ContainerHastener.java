package com.nr.mod.container;

import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Slot;
import net.minecraft.inventory.SlotFurnace;
import com.nr.mod.blocks.tileentities.TileEntityHastener;
import com.nr.mod.crafting.HastenerRecipes;

public class ContainerHastener extends ContainerMachine {
	public ContainerHastener(InventoryPlayer inventory, TileEntityHastener tileentity) {
		super(inventory, tileentity, HastenerRecipes.instance());
		addSlotToContainer(new Slot(tileentity, 0, 56, 35));
		addSlotToContainer(new SlotFurnace(inventory.player, tileentity, 1, 116, 35));
		addSlotToContainer(new Slot(tileentity, 2, 132, 64));
		addSlotToContainer(new Slot(tileentity, 3, 152, 64));
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 9; j++) {
				addSlotToContainer(new Slot(inventory, j + i*9 + 9, 8 + j*18, 84 + i*18));
			}
		}
		for(int i = 0; i < 9; i++) {
			addSlotToContainer(new Slot(inventory, i, 8 + i*18, 142));
		}
	}
}