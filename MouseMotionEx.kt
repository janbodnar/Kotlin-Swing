package com.zetcode

import java.awt.EventQueue
import java.awt.event.MouseEvent
import java.awt.event.MouseMotionAdapter
import javax.swing.GroupLayout
import javax.swing.JComponent
import javax.swing.JFrame
import javax.swing.JLabel


class MouseMotionEx(title: String) : JFrame() {

    private lateinit var coords:JLabel

    init {
        createUI(title)
    }

    private fun createUI(title: String) {

        coords = JLabel("")

        createLayout(coords)

        addMouseMotionListener(object : MouseMotionAdapter() {

            override fun mouseMoved(e: MouseEvent) {
                super.mouseMoved(e)
                val x: Int = e.x
                val y: Int = e.y
                coords.text = "x: $x, y: $y"
            }
        })

        setTitle(title)

        defaultCloseOperation = EXIT_ON_CLOSE
        setSize(400, 300)
        setLocationRelativeTo(null)
    }

    private fun createLayout(vararg arg: JComponent) {

        val gl = GroupLayout(contentPane)
        contentPane.layout = gl

        gl.autoCreateContainerGaps = true

        gl.setHorizontalGroup(gl.createParallelGroup()
            .addComponent(arg[0])
            .addGap(250)
        )

        gl.setVerticalGroup(gl.createSequentialGroup()
            .addComponent(arg[0])
            .addGap(130)
        )

        pack()
    }
}

private fun createAndShowGUI() {

    val frame = MouseMotionEx("Mouse move events")
    frame.isVisible = true
}

fun main() {
    EventQueue.invokeLater(::createAndShowGUI)
}
