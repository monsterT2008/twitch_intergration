package net.mcreator.twitch_intergration.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.twitch_intergration.TwitchIntergrationModElements;

import java.util.Map;

@TwitchIntergrationModElements.ModElement.Tag
public class GiftstatueandesiteOnBlockRightClickedProcedure extends TwitchIntergrationModElements.ModElement {
	public GiftstatueandesiteOnBlockRightClickedProcedure(TwitchIntergrationModElements instance) {
		super(instance, 33);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure GiftstatueandesiteOnBlockRightClicked!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			Entity _ent = entity;
			if (!_ent.world.isRemote && _ent.world.getServer() != null) {
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
						"give @s minecraft:andesite 64");
			}
		}
	}
}
