
package net.mcreator.twitch_intergration.command;

import net.minecraftforge.fml.event.server.FMLServerStartingEvent;
import net.minecraftforge.common.util.FakePlayerFactory;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.entity.Entity;
import net.minecraft.command.Commands;
import net.minecraft.command.CommandSource;

import net.mcreator.twitch_intergration.procedures.Twitchgiftedsub20CommandExecutedProcedure;
import net.mcreator.twitch_intergration.TwitchIntergrationModElements;

import java.util.Map;
import java.util.HashMap;
import java.util.Arrays;

import com.mojang.brigadier.context.CommandContext;
import com.mojang.brigadier.builder.LiteralArgumentBuilder;
import com.mojang.brigadier.arguments.StringArgumentType;

@TwitchIntergrationModElements.ModElement.Tag
public class Twitchgiftedsub20Command extends TwitchIntergrationModElements.ModElement {
	public Twitchgiftedsub20Command(TwitchIntergrationModElements instance) {
		super(instance, 19);
	}

	@Override
	public void serverLoad(FMLServerStartingEvent event) {
		event.getCommandDispatcher().register(customCommand());
	}

	private LiteralArgumentBuilder<CommandSource> customCommand() {
		return LiteralArgumentBuilder.<CommandSource>literal("twitch_giftedsub_20").requires(s -> s.hasPermissionLevel(2))
				.then(Commands.argument("arguments", StringArgumentType.greedyString()).executes(this::execute)).executes(this::execute);
	}

	private int execute(CommandContext<CommandSource> ctx) {
		ServerWorld world = ctx.getSource().getWorld();
		double x = ctx.getSource().getPos().getX();
		double y = ctx.getSource().getPos().getY();
		double z = ctx.getSource().getPos().getZ();
		Entity entity = ctx.getSource().getEntity();
		if (entity == null)
			entity = FakePlayerFactory.getMinecraft(world);
		HashMap<String, String> cmdparams = new HashMap<>();
		int[] index = {-1};
		Arrays.stream(ctx.getInput().split("\\s+")).forEach(param -> {
			if (index[0] >= 0)
				cmdparams.put(Integer.toString(index[0]), param);
			index[0]++;
		});
		{
			Map<String, Object> $_dependencies = new HashMap<>();
			$_dependencies.put("entity", entity);
			Twitchgiftedsub20CommandExecutedProcedure.executeProcedure($_dependencies);
		}
		return 0;
	}
}
