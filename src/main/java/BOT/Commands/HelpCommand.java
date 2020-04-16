package BOT.Commands;

import BOT.App;
import BOT.Objects.CommandManager;
import BOT.Objects.ICommand;
import me.duncte123.botcommons.messaging.EmbedUtils;
import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import org.jetbrains.annotations.NotNull;

import java.util.Collection;
import java.util.List;

public class HelpCommand implements ICommand {

    @NotNull
    private final CommandManager manager;
    @NotNull
    private final Collection<ICommand> Commands;

    public HelpCommand(@NotNull CommandManager manager) {
        this.manager = manager;
        Commands = manager.getCommands();
    }

    @Override
    public void handle(@NotNull List<String> args, @NotNull GuildMessageReceivedEvent event) {
        String joined = String.join(" ", args);

        if(joined.equals("")) {
            generateAndSendEmbed(event);
            return;
        }


        ICommand command = manager.getCommand(joined);

        if(command == null) {
            return;
        }
        if(command.getSmallHelp().equals("null")) {
            return;
        }
        String message = "`" + command.getInvoke() + "` 에 대한 설명\n" + command.getHelp();

        event.getChannel().sendMessage(message).queue();
    }

    private void generateAndSendEmbed(@NotNull GuildMessageReceivedEvent event) {
        EmbedBuilder builder = EmbedUtils.defaultEmbed().setTitle("명령어 리스트:");

        StringBuilder music = new StringBuilder();
        builder.appendDescription(App.getPREFIX() + getInvoke() + " <명령어>를 입력하면 명령어별 상세 정보를 볼 수 있습니다.");
        Commands.forEach(iCommand -> {
            if (iCommand.getSmallHelp().equals("music")) {
                music.append(iCommand.getInvoke()).append("\n");
            }
        });
        builder.addField(
                "음악",
                music.toString(),
                false
        );
        event.getChannel().sendMessage(builder.build()).queue();
    }

    @NotNull
    @Override
    public String getHelp() {
        return "모르는 명령어는 어디서? 여기서.\n" +
                "명령어: `" + App.getPREFIX() + getInvoke() + " [command]`";
    }

    @NotNull
    @Override
    public String getInvoke() {
        return "명령어";
    }

    @NotNull
    @Override
    public String getSmallHelp() {
        return "other";
    }
}
