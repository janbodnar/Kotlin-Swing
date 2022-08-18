package com.zetcode

import java.awt.Color
import java.awt.EventQueue
import javax.swing.GroupLayout
import javax.swing.ImageIcon
import javax.swing.JComponent
import javax.swing.JFrame
import javax.swing.JLabel

class LabelsEx(title: String) : JFrame() {

    init {
        createUI(title)
    }

    private fun createUI(title: String) {

        val title2 = JLabel("Sid the sloth")
        title2.font = title2.font.deriveFont(18f)

        val img = JLabel(ImageIcon("src/main/resources/sid.jpg"))

        createLayout(title2, img)

        contentPane.background = Color(0x358ae6)

        setTitle(title)

        defaultCloseOperation = EXIT_ON_CLOSE
        setLocationRelativeTo(null)
    }

    private fun createLayout(vararg arg: JComponent) {

        val gl = GroupLayout(contentPane)
        contentPane.layout = gl

        gl.autoCreateContainerGaps = true

        gl.setHorizontalGroup(
            gl.createParallelGroup(GroupLayout.Alignment.CENTER)
                .addGap(60, 150, Integer.MAX_VALUE)
                .addComponent(arg[0])
                .addComponent(arg[1])
        )

        gl.setVerticalGroup(
            gl.createSequentialGroup()
                .addComponent(arg[0])
                .addGap(30)
                .addComponent(arg[1])
        )

        pack()
    }
}

private fun createAndShowGUI() {

    val frame = LabelsEx("JLabel")
    frame.isVisible = true
}

fun main() {
    EventQueue.invokeLater(::createAndShowGUI)
}
