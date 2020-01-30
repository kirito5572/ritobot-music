package BOT.Objects;

import BOT.App;
import BOT.Commands.*;
import BOT.Commands.Music.*;
import net.dv8tion.jda.api.entities.TextChannel;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.*;
import java.util.regex.Pattern;

public class CommandManager {
    private final Logger logger = LoggerFactory.getLogger(CommandManager.class);

    private final Map<String, ICommand> commands = new HashMap<>();

    public CommandManager() {
        {
            addCommand(new HelpCommand(this));
            addCommand(new HelpCommand(this) {
                @NotNull
                @Override
                public String getInvoke() {
                    return "help";
                }

                @NotNull
                @Override
                public String getSmallHelp() {
                    return "";
                }

                @NotNull
                @Override
                public String getHelp() {
                    return "Shows a list of all the commands.\n" +
                            "Usage: `" + App.getPREFIX() + getInvoke() + " [command]`";
                }
            });
            addCommand(new PingCommand());
            addCommand(new PingCommand() {
                @NotNull
                @Override
                public String getInvoke() {
                    return "ping";
                }

                @NotNull
                @Override
                public String getSmallHelp() {
                    return "";
                }

                @NotNull
                @Override
                public String getHelp() {
                    return "Pong!\n" +
                            "Usage: `" + App.getPREFIX() + getInvoke() + "`";
                }
            });
            addCommand(new JoinCommand());
            addCommand(new JoinCommand() {
                @NotNull
                @Override
                public String getInvoke() {
                    return "join";
                }

                @NotNull
                @Override
                public String getSmallHelp() {
                    return "";
                }

                @NotNull
                @Override
                public String getHelp() {
                    return "Makes the bot join your channel";
                }
            });
        }
        //------------------------------------------------------------------//
        {
            addCommand(new QueueDelectCommand());
            addCommand(new QueueDelectCommand() {
                @NotNull
                @Override
                public String getInvoke() {
                    return "queuedelect";
                }

                @NotNull
                @Override
                public String getSmallHelp() {
                    return "";
                }

                @NotNull
                @Override
                public String getHelp() {
                    return "Clear Queqe";
                }
            });
            addCommand(new QueueDelectCommand() {
                @NotNull
                @Override
                public String getInvoke() {
                    return "qd";
                }

                @NotNull
                @Override
                public String getSmallHelp() {
                    return "";
                }

                @NotNull
                @Override
                public String getHelp() {
                    return "Clear Queue";
                }
            });
            addCommand(new QueueCommand());
            addCommand(new QueueCommand() {
                @NotNull
                @Override
                public String getInvoke() {
                    return "queue";
                }

                @NotNull
                @Override
                public String getSmallHelp() {
                    return "";
                }

                @NotNull
                @Override
                public String getHelp() {
                    return "Shows the current queue for the music player";
                }
            });
            addCommand(new StopClearCommand());
            addCommand(new StopClearCommand() {
                @NotNull
                @Override
                public String getInvoke() {
                    return "stopclear";
                }

                @NotNull
                @Override
                public String getSmallHelp() {
                    return "";
                }

                @NotNull
                @Override
                public String getHelp() {
                    return "Stop music and clear queue";
                }
            });
            addCommand(new StopClearCommand() {
                @NotNull
                @Override
                public String getInvoke() {
                    return "sc";
                }

                @NotNull
                @Override
                public String getSmallHelp() {
                    return "";
                }

                @NotNull
                @Override
                public String getHelp() {
                    return "Stop music and clear queue";
                }
            });
            addCommand(new PlayCommand());
            addCommand(new PlayCommand() {
                @NotNull
                @Override
                public String getInvoke() {
                    return "play";
                }

                @NotNull
                @Override
                public String getSmallHelp() {
                    return "";
                }

                @NotNull
                @Override
                public String getHelp() {
                    return "Plays a song\n" +
                            "Usage: `" + App.getPREFIX() + getInvoke() + " <song url>`";
                }
            });
            addCommand(new PlayCommand() {
                @NotNull
                @Override
                public String getInvoke() {
                    return "p";
                }

                @NotNull
                @Override
                public String getSmallHelp() {
                    return "";
                }

                @NotNull
                @Override
                public String getHelp() {
                    return "Plays a song\n" +
                            "Usage: `" + App.getPREFIX() + getInvoke() + " <song url>`";
                }
            });
            addCommand(new leaveCommand());
            addCommand(new leaveCommand() {
                @NotNull
                @Override
                public String getInvoke() {
                    return "leave";
                }

                @NotNull
                @Override
                public String getSmallHelp() {
                    return "";
                }

                @NotNull
                @Override
                public String getHelp() {
                    return "Makes the bot leave your channel";
                }
            });

            addCommand(new NowPlayingCommand());
            addCommand(new NowPlayingCommand() {
                @NotNull
                @Override
                public String getInvoke() {
                    return "nowplaying";
                }

                @NotNull
                @Override
                public String getSmallHelp() {
                    return "";
                }

                @NotNull
                @Override
                public String getHelp() {
                    return "Shows the currently playing track";
                }
            });
            addCommand(new NowPlayingCommand() {
                @NotNull
                @Override
                public String getInvoke() {
                    return "np";
                }

                @NotNull
                @Override
                public String getSmallHelp() {
                    return "";
                }

                @NotNull
                @Override
                public String getHelp() {
                    return "Shows the currently playing track";
                }
            });
            addCommand(new SkipCommand());
            addCommand(new SkipCommand() {
                @NotNull
                @Override
                public String getInvoke() {
                    return "skip";
                }

                @NotNull
                @Override
                public String getSmallHelp() {
                    return "";
                }

                @NotNull
                @Override
                public String getHelp() {
                    return "Skips the current song";
                }
            });
            addCommand(new StopCommand());
            addCommand(new StopCommand() {
                @NotNull
                @Override
                public String getInvoke() {
                    return "stop";
                }

                @NotNull
                @Override
                public String getSmallHelp() {
                    return "";
                }

                @NotNull
                @Override
                public String getHelp() {
                    return "Stops the music player";
                }
            });
            addCommand(new VolumeCommand());
            addCommand(new VolumeCommand() {
                @NotNull
                @Override
                public String getInvoke() {
                    return "volume";
                }

                @NotNull
                @Override
                public String getSmallHelp() {
                    return "";
                }

                @NotNull
                @Override
                public String getHelp() {
                    return "Set music player's volume\n" +
                            "Usage: `" + App.getPREFIX() + getInvoke() + " <Volume> `";
                }
            });
            addCommand(new VolumeCommand() {
                @NotNull
                @Override
                public String getInvoke() {
                    return "vol";
                }

                @NotNull
                @Override
                public String getSmallHelp() {
                    return "";
                }

                @NotNull
                @Override
                public String getHelp() {
                    return "Set music player's volume\n" +
                            "Usage: `" + App.getPREFIX() + getInvoke() + " <Volume> `";
                }
            });
            addCommand(new VersionCommand());
            addCommand(new VersionCommand() {
                @NotNull
                @Override
                public String getInvoke() {
                    return "version";
                }

                @NotNull
                @Override
                public String getSmallHelp() {
                    return "";
                }

                @NotNull
                @Override
                public String getHelp() {
                    return "say bot's build version";
                }
            });
        }
        //------------------------------------------------------------------//
        {
            addCommand(new SearchCommand());
            addCommand(new SearchCommand() {
                @NotNull
                @Override
                public String getInvoke() {
                    return "search";
                }

                @NotNull
                @Override
                public String getSmallHelp() {
                    return "";
                }

                @NotNull
                @Override
                public String getHelp() {
                    return "Serach music from youtube\n" +
                            "Usage: `" + App.getPREFIX() + getInvoke() + " <search word> `";
                }
            });
            addCommand(new upTimeCommand());
            addCommand(new upTimeCommand() {
                @NotNull
                @Override
                public String getInvoke() {
                    return "upTime";
                }

                @NotNull
                @Override
                public String getSmallHelp() {
                    return "";
                }

                @NotNull
                @Override
                public String getHelp() {
                    return "Bot's uptime";
                }
            });
            addCommand(new QueueMixCommand());
            addCommand(new QueueMixCommand() {
                @NotNull
                @Override
                public String getInvoke() {
                    return "queuemix";
                }

                @NotNull
                @Override
                public String getSmallHelp() {
                    return "";
                }

                @NotNull
                @Override
                public String getHelp() {
                    return "Mix Queue";
                }
            });
        }
    }

    private void addCommand(@NotNull ICommand command) {
        if(!commands.containsKey(command.getInvoke())) {
            commands.put(command.getInvoke(), command);
        }
    }


    @NotNull
    public Collection<ICommand> getCommands() {
        return commands.values();
    }

    public ICommand getCommand(String name) {
        return commands.get(name);
    }

    public void handleCommand(@NotNull GuildMessageReceivedEvent event) {
        final TextChannel channel = event.getChannel();
        final String[] split = event.getMessage().getContentRaw().replaceFirst(
                "(?i)" + Pattern.quote(App.getPREFIX()), "").split("\\s+");
        final String invoke = split[0].toLowerCase();

        if(commands.containsKey(invoke)) {
            final List<String> args = Arrays.asList(split).subList(1, split.length);

            channel.sendTyping().queue();
            commands.get(invoke).handle(args, event);
        }
    }
}
