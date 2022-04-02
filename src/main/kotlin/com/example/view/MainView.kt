package com.example.view



import javafx.beans.property.SimpleStringProperty
import javafx.geometry.Pos
import javafx.scene.Cursor
import javafx.scene.text.Font
import tornadofx.*

class MainView : View("Chess Game") {

    private val serverUrl: String = "localhost:8090"
    private val username: String = ""
    private val gameId = SimpleStringProperty("")
    private val api: Rest by inject()


    override val root = stackpane {

        prefHeight = 300.0
        prefWidth = 500.0

        vbox(20, Pos.TOP_CENTER) {
            label("Enter server: ") {
                font = Font(20.0)
            }

            textfield(serverUrl) {
                promptText = "GameId"
                maxWidth = 200.0
            }
            button("Generated gameId") {
                cursor = Cursor.HAND
            }.onLeftClick {
                generateGameId()
            }
            textfield(username) {
                promptText = "username"
                maxWidth = 200.0
            }
            textfield(gameId) {
                promptText = "gameId"
                maxWidth = 200.0
            }
            button("Start Game") {
                cursor = Cursor.HAND
            }

        }

    }

    private fun generateGameId() {
        val response = api.post("http://$serverUrl/game").content().toJSON()

        gameId.set(response.getString("id"))

    }


}