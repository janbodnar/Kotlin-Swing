package com.zetcode

import java.awt.Color
import java.awt.EventQueue
import java.awt.Graphics
import java.awt.Graphics2D
import java.awt.RenderingHints
import java.awt.geom.Ellipse2D
import javax.swing.JFrame
import javax.swing.JPanel

class Surface : JPanel() {

    private fun doDrawing(g: Graphics) {

        val g2d = g as Graphics2D
        g2d.paint = Color(150, 150, 150)

        val rh = RenderingHints(
            RenderingHints.KEY_ANTIALIASING,
            RenderingHints.VALUE_ANTIALIAS_ON
        )
        rh[RenderingHints.KEY_RENDERING] = RenderingHints.VALUE_RENDER_QUALITY
        g2d.setRenderingHints(rh)
        
        g2d.fillRect(30, 20, 50, 50)
        g2d.fillRect(120, 20, 90, 60)
        g2d.fillRoundRect(250, 20, 70, 60, 25, 25)
        g2d.fill(Ellipse2D.Double(10.0, 100.0, 80.0, 100.0))
        g2d.fillArc(120, 130, 110, 100, 5, 150)
        g2d.fillOval(270, 130, 50, 50)
    }

    public override fun paintComponent(g: Graphics) {
        super.paintComponent(g)

        doDrawing(g)
    }
}

class ShapesEx(title: String) : JFrame() {

    init {
        createUI(title)
    }

    private fun createUI(title: String) {

        add(Surface())

        setTitle(title)

        defaultCloseOperation = EXIT_ON_CLOSE
        setSize(400, 350)
        setLocationRelativeTo(null)
    }
}

private fun createAndShowGUI() {

    val frame = ShapesEx("Shapes")
    frame.isVisible = true
}

fun main() {
    EventQueue.invokeLater(::createAndShowGUI)
}
