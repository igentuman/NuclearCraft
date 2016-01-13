 package com.nr.mod.gui;
 
 import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

import com.nr.mod.blocks.tileentities.TileEntityElectrolyser;
import com.nr.mod.container.ContainerElectrolyser;

 public class GuiElectrolyser extends GuiContainer {
   public static final ResourceLocation bground = new ResourceLocation("nr:textures/gui/electrolyser.png");
   
   public TileEntityElectrolyser electrolyser;
   
 
   public GuiElectrolyser(InventoryPlayer inventoryPlayer, TileEntityElectrolyser entity) {
     super(new ContainerElectrolyser(inventoryPlayer, entity));
 
     this.electrolyser = entity;
     
     this.xSize = 176;
     this.ySize = 174;
   }

   public void drawGuiContainerForegroundLayer(int par1, int par2) {
     String name = StatCollector.translateToLocal("tile.electrolyserIdle.name");
     this.fontRendererObj.drawString(name, this.xSize / 2 - this.fontRendererObj.getStringWidth(name) / 2, 6, 4210752);
     this.fontRendererObj.drawString(electrolyser.energy + " RF", 28, this.ySize - 94, 4210752);
   }
   
   protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
     GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
     
     Minecraft.getMinecraft().getTextureManager().bindTexture(bground);
     drawTexturedModalRect(this.guiLeft, this.guiTop, 0, 0, this.xSize, this.ySize);
     
 
     int e = electrolyser.energy * 82 / 50000;
     drawTexturedModalRect(guiLeft + 8, guiTop + 6 + 82 - e, 176, 3 + 82 - e, 16, e);
     
 
     int k = (int) Math.ceil(this.electrolyser.cookTime * 70 / this.electrolyser.getFurnaceSpeed);
     drawTexturedModalRect(guiLeft + 59, guiTop + 32, 3, 174, k, 38);
   }
 }
