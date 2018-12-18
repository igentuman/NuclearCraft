package nc.network.tile;

import io.netty.buffer.ByteBuf;
import nc.tile.generator.TileFusionCore;
import net.minecraft.util.math.BlockPos;

public class FusionUpdatePacket extends TileUpdatePacket {
	
	public double time;
	public int energyStored;
	public double baseProcessTime;
	public double baseProcessPower;
	public boolean isProcessing;
	public double heat;
	public double efficiency;
	public double speedMultiplier;
	public int size;
	public int complete;
	public double cooling;
	public double heatChange;
	public boolean hasConsumed;
	public boolean computerActivated;
	
	public FusionUpdatePacket() {
		messageValid = false;
	}
	
	public FusionUpdatePacket(BlockPos pos, double time, int energyStored, double baseProcessTime, double baseProcessPower, boolean isProcessing, double heat, double efficiency, double speedMultiplier, int size, int complete, double cooling, double heatChange, boolean hasConsumed, boolean computerActivated) {
		this.pos = pos;
		this.time = time;
		this.energyStored = energyStored;
		this.baseProcessTime = baseProcessTime;
		this.baseProcessPower = baseProcessPower;
		this.isProcessing = isProcessing;
		this.heat = heat;
		this.efficiency = efficiency;
		this.speedMultiplier = speedMultiplier;
		this.size = size;
		this.complete = complete;
		this.cooling = cooling;
		this.heatChange = heatChange;
		this.hasConsumed = hasConsumed;
		this.computerActivated = computerActivated;
		
		messageValid = true;
	}
	
	@Override
	public void readMessage(ByteBuf buf) {
		pos = new BlockPos(buf.readInt(), buf.readInt(), buf.readInt());
		time = buf.readDouble();
		energyStored = buf.readInt();
		baseProcessTime = buf.readDouble();
		baseProcessPower = buf.readDouble();
		isProcessing = buf.readBoolean();
		heat = buf.readDouble();
		efficiency = buf.readDouble();
		speedMultiplier = buf.readDouble();
		size = buf.readInt();
		complete = buf.readInt();
		cooling = buf.readDouble();
		heatChange = buf.readDouble();
		hasConsumed = buf.readBoolean();
		computerActivated = buf.readBoolean();
	}
	
	@Override
	public void writeMessage(ByteBuf buf) {
		buf.writeInt(pos.getX());
		buf.writeInt(pos.getY());
		buf.writeInt(pos.getZ());
		buf.writeDouble(time);
		buf.writeInt(energyStored);
		buf.writeDouble(baseProcessTime);
		buf.writeDouble(baseProcessPower);
		buf.writeBoolean(isProcessing);
		buf.writeDouble(heat);
		buf.writeDouble(efficiency);
		buf.writeDouble(speedMultiplier);
		buf.writeInt(size);
		buf.writeInt(complete);
		buf.writeDouble(cooling);
		buf.writeDouble(heatChange);
		buf.writeBoolean(hasConsumed);
		buf.writeBoolean(computerActivated);
	}
	
	public static class Handler extends TileUpdatePacket.Handler<FusionUpdatePacket, TileFusionCore> {
		
		@Override
		protected void onPacket(FusionUpdatePacket message, TileFusionCore core) {
			core.onGuiPacket(message);
		}
	}
}
