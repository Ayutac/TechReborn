package techreborn.client.gui;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;
import techreborn.client.container.ContainerAlloySmelter;
import techreborn.client.container.ContainerBlastFurnace;
import techreborn.tiles.TileAlloySmelter;
import techreborn.tiles.TileBlastFurnace;

public class GuiAlloySmelter extends GuiContainer {

	private static final ResourceLocation texture = new ResourceLocation(
			"techreborn", "textures/gui/electric_alloy_furnace.png");

	TileAlloySmelter alloysmelter;

	public GuiAlloySmelter(EntityPlayer player,
			TileAlloySmelter tilealloysmelter)
	{
		super(new ContainerAlloySmelter(tilealloysmelter, player));
		this.xSize = 176;
		this.ySize = 167;
		alloysmelter = tilealloysmelter;
	}
	
    @Override
    public void initGui() {

        this.buttonList.clear();
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.buttonList.add(new GuiButton(0, k + 4,  l + 4, 20, 20, "R"));
        super.initGui();
    }

	@Override
	protected void drawGuiContainerBackgroundLayer(float p_146976_1_,
			int p_146976_2_, int p_146976_3_)
	{
		this.mc.getTextureManager().bindTexture(texture);
		int k = (this.width - this.xSize) / 2;
		int l = (this.height - this.ySize) / 2;
		this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
	}

	protected void drawGuiContainerForegroundLayer(int p_146979_1_,
			int p_146979_2_)
	{
		this.fontRendererObj.drawString(StatCollector.translateToLocal("tile.techreborn.alloysmelter.name"), 40, 6, 4210752);
		this.fontRendererObj.drawString(
				I18n.format("container.inventory", new Object[0]), 8,
				this.ySize - 96 + 2, 4210752);
	}
}
