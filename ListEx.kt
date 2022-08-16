package com.zetcode

import java.awt.EventQueue
import java.awt.Font
import java.awt.GraphicsEnvironment
import javax.swing.GroupLayout
import javax.swing.JComponent
import javax.swing.JFrame
import javax.swing.JLabel
import javax.swing.JList
import javax.swing.JScrollPane
import javax.swing.event.ListSelectionEvent

class ListEx(title: String) : JFrame() {

    private lateinit var label: JLabel
    private lateinit var spane: JScrollPane

    init {
        createUI(title)
    }

    private fun createUI(title: String) {

        val ge = GraphicsEnvironment.getLocalGraphicsEnvironment()
        val fonts = ge.availableFontFamilyNames
        val list: JList<*> = JList<Any?>(fonts)

        list.addListSelectionListener { e: ListSelectionEvent ->
            if (!e.valueIsAdjusting) {
                val name = list.selectedValue as String
                val font = Font(name, Font.PLAIN, 12)
                label.font = font
            }
        }

        spane = JScrollPane()
        spane.viewport.add(list)

        label = JLabel("Aguirre, der Zorn Gottes")
        label.font = Font("Serif", Font.PLAIN, 14)

        createLayout(spane, label)

        setTitle(title)

        defaultCloseOperation = EXIT_ON_CLOSE
        setSize(500, 400)
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

    val frame = ListEx("JList")
    frame.isVisible = true
}

fun main() {
    EventQueue.invokeLater(::createAndShowGUI)
}
