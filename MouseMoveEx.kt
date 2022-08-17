package com.zetcode

import java.awt.EventQueue
import java.awt.event.ComponentAdapter
import java.awt.event.ComponentEvent
import javax.swing.GroupLayout
import javax.swing.JComponent
import javax.swing.JFrame
import javax.swing.JLabel


class MouseMoveEx(title: String) : JFrame() {

    private lateinit var coords: JLabel

    init {
        createUI(title)
    }

    private fun createUI(title: String) {

        coords = JLabel("")

        addComponentListener(MoveAdapter())
        createLayout(coords)

        setTitle(title)

        defaultCloseOperation = EXIT_ON_CLOSE
        setSize(400, 300)
        setLocationRelativeTo(null)
    }

    private fun createLayout(vararg arg: JComponent) {

        val gl = GroupLayout(contentPane)
        contentPane.layout = gl

        gl.autoCreateContainerGaps = true

        gl.setHorizontalGroup(
            gl.createParallelGroup()
                .addComponent(arg[0])
                .addGap(250)
        )

        gl.setVerticalGroup(
            gl.createSequentialGroup()
                .addComponent(arg[0])
                .addGap(130)
        )

        pack()
    }

    private inner class MoveAdapter : ComponentAdapter() {

        override fun componentMoved(e: ComponentEvent) {
            val x = e.component.x
            val y = e.component.y
            coords.text = "x: $x y: $y"
        }
    }
}


private fun createAndShowGUI() {

    val frame = MouseMoveEx("Mouse move events")
    frame.isVisible = true
}

fun main() {
    EventQueue.invokeLater(::createAndShowGUI)
}
