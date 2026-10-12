# Rainbow Welcome

Rainbow Welcome sends a message to each player when they join:

- First-time players receive a rainbow welcome.
- Returning players receive a short welcome-back message.

## Build

Use Java 21, then run:

```sh
./gradlew clean build
```

The plugin jar is created in `build/libs/`.

## Install and configure

Copy the jar into your Paper server's `plugins` folder and start the server.
On startup, the plugin creates `plugins/RainbowWelcome/config.yml`. Edit the
message values there, then restart the server to apply changes.

Messages use MiniMessage formatting. Use `<player>` where the joining player's
name should appear. For example:

```yaml
welcome-message: "<rainbow>Welcome to the server, <player>!</rainbow>"
returning-welcome-message: "<gray>Welcome back, <player>!</gray>"
```
