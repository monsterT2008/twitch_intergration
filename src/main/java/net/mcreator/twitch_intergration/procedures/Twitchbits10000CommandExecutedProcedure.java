package net.mcreator.twitch_intergration.procedures;

import net.minecraft.entity.Entity;

import net.mcreator.twitch_intergration.TwitchIntergrationModElements;

import java.util.Map;

@TwitchIntergrationModElements.ModElement.Tag
public class Twitchbits10000CommandExecutedProcedure extends TwitchIntergrationModElements.ModElement {
	public Twitchbits10000CommandExecutedProcedure(TwitchIntergrationModElements instance) {
		super(instance, 30);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				System.err.println("Failed to load dependency entity for procedure Twitchbits10000CommandExecuted!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			Entity _ent = entity;
			if (!_ent.world.isRemote && _ent.world.getServer() != null) {
				_ent.world.getServer().getCommandManager().handleCommand(_ent.getCommandSource().withFeedbackDisabled().withPermissionLevel(4),
						"give @s twitch_intergration:bits_10000");
			}
		}
	}
}
