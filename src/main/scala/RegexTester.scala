//package io.github.ruffy.tools

object RegexTester extends App {

  val mainWindow = new MainFrame()

  mainWindow.show
}

import javax.swing._
import java.awt.BorderLayout
import javax.swing.event.{DocumentListener, DocumentEvent}

class MainFrame extends JFrame("Regex Tester") {

  setSize(800, 500)


    val splitPane = new JSplitPane
    val regexTxt = new JTextField
    val inputTextTxt = new JTextArea
    val leftPanel = new JPanel(new BorderLayout)
    val matchesTxt = new JTextArea

  initializeComponents


  private def initializeComponents = {

    splitPane.setDividerLocation(500)

    regexTxt.getDocument.addDocumentListener(new CallbackListener( de => {
      updateRegex
      updateMatches
    }));

    inputTextTxt.getDocument.addDocumentListener(new CallbackListener( de => {
      updateMatches
    }));


    leftPanel.add(regexTxt, BorderLayout.NORTH)
    leftPanel.add(inputTextTxt, BorderLayout.CENTER)

    splitPane.setLeftComponent(leftPanel)

    splitPane.setRightComponent(matchesTxt)

    add(splitPane)
  }

  private def updateMatches() {

    val inputText = inputTextTxt.getText
    val matches = _regex findAllIn inputText toArray

    val matchString = matches.mkString("\n")
    matchesTxt.setText(matchString)
  }

  private var _regex = "".r
  private var _lastRegexString= ""

  private def updateRegex() {
    if(_lastRegexString != regexTxt.getText) {
      try{
        _lastRegexString = regexTxt.getText
        _regex = _lastRegexString.r.unanchored
      } catch {
        case _ :Throwable => 
      }
    }
  }


  class CallbackListener(callback: DocumentEvent => Unit) extends DocumentListener {
    def changedUpdate(de : DocumentEvent) {
      callback(de)
    }

    def insertUpdate(de : DocumentEvent) {
      callback(de)
    }

    def removeUpdate(de : DocumentEvent) {
      callback(de)
    }
  }
}