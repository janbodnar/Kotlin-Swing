package com.zetcode

import java.awt.EventQueue
import javax.swing.GroupLayout
import javax.swing.JComponent
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JSlider

class SliderEx(title: String) : JFrame() {

    private lateinit var slider: JSlider
    private lateinit var lbl: JLabel

    init {
        createUI(title)
    }

    private fun createUI(title: String) {

        slider = JSlider(0, 100, 0)
        slider.minorTickSpacing = 5
        slider.majorTickSpacing = 10
        slider.paintTicks = true

        slider.addChangeListener {

            val value: Int = slider.value
            lbl.text = value.toString()
        }

        lbl = JLabel("...")

        createLayout(slider, lbl)
        setTitle(title)

        defaultCloseOperation = EXIT_ON_CLOSE
        setSize(400, 350)
        setLocationRelativeTo(null)
    }


    private fun createLayout(vararg arg: JComponent) {

        val pane = contentPane
        val gl = GroupLayout(pane)
        pane.layout = gl

        gl.autoCreateContainerGaps = true
        gl.autoCreateGaps = true

        gl.setHorizontalGroup(
            gl.createParallelGroup()
                .addComponent(arg[0])
                .addComponent(arg[1])
        )
        gl.setVerticalGroup(
            gl.createSequentialGroup()
                .addComponent(arg[0])
                .addComponent(arg[1])
        )
        pack()
    }
}

private fun createAndShowGUI() {

    val frame = SliderEx("JSlider")
    frame.isVisible = true
}

fun main() {
    EventQueue.invokeLater(::createAndShowGUI)
}
