/* Copyright (C) 2021-2025
 * Julian Valentin, Daniel Spitzer, lsp-cli-plus Development Community
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package org.bsplines.lspcli.tools

import org.bsplines.lspcli.client.Checker
import org.bsplines.lspcli.client.LspCliTextDocumentItem
import org.eclipse.lsp4j.Diagnostic
import org.eclipse.lsp4j.DiagnosticSeverity
import org.eclipse.lsp4j.Position
import org.eclipse.lsp4j.Range
import org.junit.jupiter.api.assertDoesNotThrow
import java.io.ByteArrayOutputStream
import java.io.PrintStream
import kotlin.io.path.Path
import kotlin.test.Test

class CheckerTest {
  @Test
  fun `check printing multi line diagnostic`() {
    val path = Path("test.tex")
    val documentText = "This is a test document.\nIt has multiple lines.\nEnd of document."
    val document = LspCliTextDocumentItem("test", "plaintext", 1, documentText)
    val diagnostic =
      Diagnostic(
        Range(Position(0, 5), Position(2, 25)),
        "Test error message",
        DiagnosticSeverity.Error,
        "source",
        "code",
      )
    val codeActionTitles = listOf("Fix this error")
    val terminalWidth = 80

    // Redirect stdout
    val originalOut = System.out
    val byteArrayOutputStream = ByteArrayOutputStream()
    val printStream = PrintStream(byteArrayOutputStream)
    System.setOut(printStream)

    try {
      assertDoesNotThrow {
        Checker.printDiagnostic(path, document, diagnostic, codeActionTitles, terminalWidth)
      }
    } finally {
      // Restore stdout
      System.setOut(originalOut)
    }
  }
}
