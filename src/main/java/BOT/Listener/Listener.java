package BOT.Listener;

import BOT.App;
import BOT.Constants;
import BOT.Objects.CommandManager;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.entities.*;
import net.dv8tion.jda.api.events.ReadyEvent;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import org.jetbrains.annotations.NotNull;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileReader;
import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class Listener extends ListenerAdapter {
    private final CommandManager manager;
    private final Logger logger = LoggerFactory.getLogger(Listener.class);
    private static String ID1;
    private static String ID2;
    public Listener(CommandManager manager) {
        this.manager = manager;
    }

    @Override
    public void onReady(@NotNull ReadyEvent event) {
        logger.info(String.format("music_core 로그인 성공: %#s", event.getJDA().getSelfUser()));
        System.out.println(String.format("music_core 로그인 성공: %#s", event.getJDA().getSelfUser()));
    }

    @Override
    public void onMessageReceived(@NotNull MessageReceivedEvent event) {

        User author = event.getAuthor();
        Message message = event.getMessage();
        String content = message.getContentDisplay();

        if (event.isFromType(ChannelType.TEXT)) {

            Guild guild = event.getGuild();
            TextChannel textChannel = event.getTextChannel();

            logger.info(String.format("\n" +
                    "보낸사람: %#s\n" +
                    "친 내용: %s\n" +
                    "[서버: %s]  " +
                    "[채팅방: %s]", author, content, guild.getName(), textChannel.getName()));
        } else if (event.isFromType(ChannelType.PRIVATE)) {
            logger.info(String.format("[PRIV]<%#s>: %s", author, content));
        }
    }

    @Override
    public void onGuildMessageReceived(@NotNull GuildMessageReceivedEvent event) {
        Message message = event.getMessage();
        StringBuilder IDreader = new StringBuilder();
        StringBuilder IDreader1 = new StringBuilder();
        try {
            File file = new File("C:\\DiscordServerBotSecrets\\rito-bot\\OWNER_ID.txt");
            File file1 = new File("C:\\DiscordServerBotSecrets\\rito-bot\\OWNER_ID1.txt");
            FileReader fileReader = new FileReader(file);
            FileReader fileReader1 = new FileReader(file1);
            int singalCh, singalCh1;
            while((singalCh = fileReader.read()) != -1) {
                IDreader.append((char) singalCh);
            }
            while((singalCh1 = fileReader1.read()) != -1) {
                IDreader1.append((char) singalCh1);
            }
        } catch (Exception e) {

            StackTraceElement[] eStackTrace = e.getStackTrace();
            StringBuilder a = new StringBuilder();
            for (StackTraceElement stackTraceElement : eStackTrace) {
                a.append(stackTraceElement).append("\n");
            }
            logger.warn(a.toString());
        }
        ID1 = IDreader.toString();
        ID2 = IDreader1.toString();
        if (event.getMessage().getContentRaw().equalsIgnoreCase(App.getPREFIX() + "종료 music") &&
                (
                        (event.getAuthor().getIdLong() == Long.decode(ID1)) ||
                        (event.getAuthor().getIdLong() == Long.decode(ID2))
                )) {
            shutdown(event.getJDA(), event);
            return;

        }
        if(event.getAuthor().isBot()) {
            if(!event.getAuthor().getId().equals("617912267597676545")) {
                return;
            }
        }
        if(event.getMessage().isWebhookMessage()) {

            return;
        }
        if(event.getGuild().getId().equals("600010501266866186")) {
            if(!event.getChannel().getId().equals("600012818879741963")) {
                if(!Objects.requireNonNull(event.getMember()).hasPermission(Permission.MANAGE_ROLES)) {
                    Role role = event.getGuild().getRoleById("600012069559074822");
                    if(!event.getMember().getRoles().contains(role)) {
                        if(!event.getAuthor().getId().equals("278086240195182592")) {
                            if (event.getMessage().getContentRaw().startsWith(App.getPREFIX())) {
                                event.getChannel().sendMessage(event.getMember().getAsMention() + " , 명령어는 봇 명령어 채널에서 사용해주세요").complete().delete().queueAfter(7, TimeUnit.SECONDS);

                                message.delete().queue();

                                return;
                            }
                        } else {
                            if(!event.getMessage().getContentRaw().startsWith(App.getPREFIX() + "투표")) {
                                event.getChannel().sendMessage(event.getMember().getAsMention() + " , 명령어는 봇 명령어 채널에서 사용해주세요").complete().delete().queueAfter(7, TimeUnit.SECONDS);

                                message.delete().queue();

                                return;
                            }
                        }
                    }
                }
            }
        }
        if(event.getGuild().getId().equals("617222347425972234")) {
            if(!event.getChannel().getId().equals("617230917315854356")) {
                if(!event.getChannel().getId().equals("617229595628011520")) {
                    if (!Objects.requireNonNull(event.getMember()).hasPermission(Permission.MANAGE_ROLES)) {
                        if (event.getMessage().getContentRaw().startsWith(Constants.PREFIX)) {
                            event.getChannel().sendMessage(event.getMember().getAsMention() + " , 명령어는 봇 명령어 채널에서 사용해주세요").complete().delete().queueAfter(7, TimeUnit.SECONDS);

                            message.delete().queue();

                            return;
                        }
                    }
                }
            }
        }
        if(event.getGuild().getId().equals("607390893804093442")) {
            if(!event.getChannel().getId().equals("620095220729511977")) {
                if(!Objects.requireNonNull(event.getMember()).hasPermission(Permission.MANAGE_ROLES)) {
                    if (event.getMessage().getContentRaw().startsWith(Constants.PREFIX)) {
                        event.getChannel().sendMessage(event.getMember().getAsMention() + " , 명령어는 봇 명령어 채널에서 사용해주세요").complete().delete().queueAfter(7, TimeUnit.SECONDS);

                        message.delete().queue();

                        return;
                    }
                }
            }
        }
        if(event.getGuild().getId().equals("607390203086372866")) {
            if(!event.getChannel().getId().equals("619271283586367498")) {
                if(!Objects.requireNonNull(event.getMember()).hasPermission(Permission.MANAGE_ROLES)) {
                    if (event.getMessage().getContentRaw().startsWith(Constants.PREFIX)) {
                        event.getChannel().sendMessage(event.getMember().getAsMention() + " , 명령어는 봇 명령어 채널에서 사용해주세요").complete().delete().queueAfter(7, TimeUnit.SECONDS);

                        message.delete().queue();

                        return;
                    }
                }
            }
        }
        if(event.getGuild().getId().equals("439780696999985172")) {
            if(!event.getChannel().getId().equals("447727416660721665")) {
                if(!Objects.requireNonNull(event.getMember()).hasPermission(Permission.MANAGE_ROLES)) {
                    if (event.getMessage().getContentRaw().startsWith(Constants.PREFIX)) {
                        event.getChannel().sendMessage(event.getMember().getAsMention() + " , 명령어는 봇 명령어 채널에서 사용해주세요").complete().delete().queueAfter(7, TimeUnit.SECONDS);

                        message.delete().queue();

                        return;
                    }
                }
            }
        }
        if(event.getGuild().getId().equals("609985979167670272")) {
            if(!event.getChannel().getId().equals("612293836458426378")) {
                if(!Objects.requireNonNull(event.getMember()).hasPermission(Permission.MANAGE_ROLES)) {
                    if (event.getMessage().getContentRaw().startsWith(Constants.PREFIX)) {
                        event.getChannel().sendMessage(event.getMember().getAsMention() + " , 명령어는 봇 명령어 채널에서 사용해주세요").complete().delete().queueAfter(7, TimeUnit.SECONDS);

                        message.delete().queue();

                        return;
                    }
                }
            }
        }

        if (event.getMessage().getContentRaw().startsWith(Constants.PREFIX)) {
            manager.handleCommand(event);
        }
    }
    private void shutdown(@NotNull JDA jda, @NotNull GuildMessageReceivedEvent event) {
        new Thread(() -> {
            event.getChannel().sendMessage("music core 종료 완료.").queue();
            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {

                StackTraceElement[] eStackTrace = e.getStackTrace();
                StringBuilder a = new StringBuilder();
                for (StackTraceElement stackTraceElement : eStackTrace) {
                    a.append(stackTraceElement).append("\n");
                }
                logger.warn(a.toString());
            }
            jda.shutdown();
            System.exit(0);
        }).start();
    }


    public static String getID1() {
        return ID1;
    }

    public static String getID2() {
        return ID2;
    }
}

