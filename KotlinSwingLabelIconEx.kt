package com.zetcode

import javax.swing.*

class KotlinSwingLabelIconEx(title: String) : JFrame() {

    init {
        createUI(title)
    }

    private fun createUI(title: String) {

        val lbl1 = JLabel(ImageIcon("src/main/resources/cpu.png"))
        val lbl2 = JLabel(ImageIcon("src/main/resources/drive.png"))
        val lbl3 = JLabel(ImageIcon("src/main/resources/laptop.png"))
        val lbl4 = JLabel(ImageIcon("src/main/resources/player.png"))

        createLayout(lbl1, lbl2, lbl3, lbl4)

        setTitle(title)
        defaultCloseOperation = JFrame.EXIT_ON_CLOSE
        setLocationRelativeTo(null)
    }

    private fun createLayout(vararg arg: JComponent) {

        val gl = GroupLayout(contentPane)
        contentPane.layout = gl

        gl.autoCreateContainerGaps = true
        gl.autoCreateGaps = true

        gl.setHorizontalGroup(gl.createSequentialGroup()
                .addComponent(arg[0])
                .addComponent(arg[1])
                .addComponent(arg[2])
                .addComponent(arg[3])
        )

        gl.setVerticalGroup(gl.createParallelGroup()
                .addComponent(arg[0])
                .addComponent(arg[1])
                .addComponent(arg[2])
                .addComponent(arg[3])
        )

        pack()
    }
}

private fun createAndShowGUI() {

    val frame = KotlinSwingLabelIconEx("Icons")
    frame.isVisible = true
}

fun main(args: Array<String>) {
    SwingUtilities.invokeLater(::createAndShowGUI)
}
