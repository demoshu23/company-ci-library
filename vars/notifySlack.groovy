def call(String message) {
    slackSend(
        channel: "#ci-cd",
        message: message
    )
}
