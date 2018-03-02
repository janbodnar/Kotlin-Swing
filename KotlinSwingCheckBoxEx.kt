package com.zetcode

import java.awt.EventQueue
import java.awt.event.ItemEvent
import javax.swing.GroupLayout
import javax.swing.JCheckBox
import javax.swing.JComponent
import javax.swing.JFrame

class KotlinSwingCheckBoxEx(title: String) : JFrame() {

    init {
        createUI(title)
    }

    private fun createUI(title: String) {

        setTitle(title)

        val checkBox = JCheckBox("Show title", true)

        checkBox.addItemListener { e ->
            val sel: Int = e.stateChange
            if (sel == ItemEvent.SELECTED) {
                setTitle("JCheckBox")
            } else {
                setTitle("")
            }
        }

        createLayout(checkBox)

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

    val frame = KotlinSwingCheckBoxEx("JCheckBox")
    frame.isVisible = true
}

fun main(args: Array<String>) {
    EventQueue.invokeLater(::createAndShowGUI)
}
