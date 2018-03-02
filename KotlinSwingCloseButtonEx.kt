package com.zetcode

import java.awt.EventQueue
import javax.swing.*

class KotlinSwingCloseButtonEx(title: String) : JFrame() {

    init {
        createUI(title)
    }

    private fun createUI(title: String) {

        setTitle(title)

        val closeBtn = JButton("Close")

        closeBtn.addActionListener { System.exit(0) }

        createLayout(closeBtn)

        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setSize(300, 200)
        setLocationRelativeTo(null)
    }


    private fun createLayout(vararg arg: JComponent) {

        val gl = GroupLayout(contentPane)
        contentPane.layout = gl

        gl.autoCreateContainerGaps = true

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
        )

        gl.setVerticalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
        )

        pack()
    }
}

private fun createAndShowGUI() {

    val frame = KotlinSwingCloseButtonEx("Close button")
    frame.isVisible = true
}

fun main(args: Array<String>) {
    EventQueue.invokeLater(::createAndShowGUI)
}
