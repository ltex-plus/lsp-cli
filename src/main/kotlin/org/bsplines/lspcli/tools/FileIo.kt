/* Copyright (C) 2021-2025
 * Julian Valentin, Daniel Spitzer, lsp-cli-plus Development Community
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at https://mozilla.org/MPL/2.0/.
 */

package org.bsplines.lspcli.tools

import java.io.IOException
import java.nio.charset.StandardCharsets
import java.nio.file.Files
import java.nio.file.Path

object FileIo {
  fun readFile(filePath: Path): String? =
    try {
      readFileWithException(filePath)
    } catch (e: IOException) {
      Logging.logger.warning(I18n.format("couldNotReadFile", e, filePath.toString()))
      null
    }

  fun readFileWithException(filePath: Path): String =
    String(Files.readAllBytes(filePath), StandardCharsets.UTF_8)

  @Suppress("ComplexCondition", "ComplexMethod", "LongMethod")
  fun getCodeLanguageIdFromPath(path: Path): String? {
    val fileName: String = path.fileName.toString()

    return if (fileName.endsWith(".bib")) {
      "bibtex"
    } else if (fileName.endsWith(".c") ||
      fileName.endsWith(".h")
    ) {
      "c"
    } else if (fileName.endsWith(".clj")) {
      "clojure"
    } else if (fileName.endsWith(".coffee")) {
      "coffeescript"
    } else if (fileName.endsWith(".cc") ||
      fileName.endsWith(".cpp") ||
      fileName.endsWith(".cxx") ||
      fileName.endsWith(".hh") ||
      fileName.endsWith(".hpp") ||
      fileName.endsWith(".inl")
    ) {
      "cpp"
    } else if (fileName.endsWith(".cs")) {
      "csharp"
    } else if (fileName.endsWith(".dart")) {
      "dart"
    } else if (fileName.endsWith(".ex")) {
      "elixir"
    } else if (fileName.endsWith(".elm")) {
      "elm"
    } else if (fileName.endsWith(".erl")) {
      "erlang"
    } else if (fileName.endsWith(".f90")) {
      "fortran-modern"
    } else if (fileName.endsWith(".fs")) {
      "fsharp"
    } else if (fileName.endsWith(".go")) {
      "go"
    } else if (fileName.endsWith(".groovy")) {
      "groovy"
    } else if (fileName.endsWith(".hs")) {
      "haskell"
    } else if (fileName.endsWith(".htm") ||
      fileName.endsWith(".html") ||
      fileName.endsWith(".xht") ||
      fileName.endsWith(".xhtml")
    ) {
      "html"
    } else if (fileName.endsWith(".java")) {
      "java"
    } else if (fileName.endsWith(".js")) {
      "javascript"
    } else if (fileName.endsWith(".jl")) {
      "julia"
    } else if (fileName.endsWith(".kt")) {
      "kotlin"
    } else if (fileName.endsWith(".tex")) {
      "latex"
    } else if (fileName.endsWith(".lisp")) {
      "lisp"
    } else if (fileName.endsWith(".lua")) {
      "lua"
    } else if (fileName.endsWith(".md")) {
      "markdown"
    } else if (fileName.endsWith(".m")) {
      "matlab"
    } else if (fileName.endsWith(".mdx")) {
      "mdx"
    } else if (fileName.endsWith(".norg")) {
      "neorg"
    } else if (fileName.endsWith(".org")) {
      "org"
    } else if (fileName.endsWith(".pl")) {
      "perl"
    } else if (fileName.endsWith(".php")) {
      "php"
    } else if (fileName.endsWith(".txt")) {
      "plaintext"
    } else if (fileName.endsWith(".ps1")) {
      "powershell"
    } else if (fileName.endsWith(".pp")) {
      "puppet"
    } else if (fileName.endsWith(".py")) {
      "python"
    } else if (fileName.endsWith(".r")) {
      "r"
    } else if (fileName.endsWith(".rst")) {
      "restructuredtext"
    } else if (fileName.endsWith(".Rnw") ||
      fileName.endsWith(".rnw")
    ) {
      "rsweave"
    } else if (fileName.endsWith(".rb")) {
      "ruby"
    } else if (fileName.endsWith(".rs")) {
      "rust"
    } else if (fileName.endsWith(".scala")) {
      "scala"
    } else if (fileName.endsWith(".sh")) {
      "shellscript"
    } else if (fileName.endsWith(".sql")) {
      "sql"
    } else if (fileName.endsWith(".swift")) {
      "swift"
    } else if (fileName.endsWith(".ts")) {
      "typescript"
    } else if (fileName.endsWith(".typ")) {
      "typst"
    } else if (fileName.endsWith(".vb")) {
      "vb"
    } else if (fileName.endsWith(".v")) {
      "verilog"
    } else {
      null
    }
  }
}
