package com.zetcode

import java.awt.EventQueue
import java.awt.event.ActionEvent
import java.awt.event.KeyEvent
import javax.swing.*


class KotlinSwingSimpleMenuEx(title: String) : JFrame() {

    init {
        createUI(title)
    }

    private fun createUI(title: String) {

        setTitle(title)

        createMenuBar()

        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setSize(300, 200)
        setLocationRelativeTo(null)
    }

    private fun createMenuBar() {

        val menubar = JMenuBar()
        val icon = ImageIcon("src/main/resources/exit.png")

        val file = JMenu("File")
        file.mnemonic = KeyEvent.VK_F

        val eMenuItem = JMenuItem("Exit", icon)
        eMenuItem.mnemonic = KeyEvent.VK_E
        eMenuItem.toolTipText = "Exit application"
        eMenuItem.addActionListener { _: ActionEvent -> System.exit(0) }

        file.add(eMenuItem)

        menubar.add(file)

        jMenuBar = menubar
    }
}

private fun createAndShowGUI() {

    val frame = KotlinSwingSimpleMenuEx("Simple menu")
    frame.isVisible = true
}

fun main(args: Array<String>) {
    EventQueue.invokeLater(::createAndShowGUI)
}
