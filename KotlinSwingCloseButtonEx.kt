package com.zetcode

import java.awt.EventQueue
import javax.swing.GroupLayout
import javax.swing.JButton
import javax.swing.JComponent
import javax.swing.JFrame

import kotlin.system.exitProcess

class CloseButtonEx(title: String) : JFrame() {

    init {
        createUI(title)
    }

    private fun createUI(title: String) {

        setTitle(title)

        val closeBtn = JButton("Close")

        closeBtn.addActionListener { exitProcess(0) }

        createLayout(closeBtn)

        defaultCloseOperation = EXIT_ON_CLOSE
        setSize(400, 300)
        setLocationRelativeTo(null)
    }


    private fun createLayout(vararg arg: JComponent) {

        val gl = GroupLayout(contentPane)
        contentPane.layout = gl

        gl.autoCreateContainerGaps = true

        gl.setHorizontalGroup(
            gl.createSequentialGroup()
                .addComponent(arg[0])
        )

        gl.setVerticalGroup(
            gl.createSequentialGroup()
                .addComponent(arg[0])
        )

        pack()
    }
}

private fun createAndShowGUI() {

    val frame = CloseButtonEx("Close button")
    frame.isVisible = true
}

fun main() {
    EventQueue.invokeLater(::createAndShowGUI)
}
