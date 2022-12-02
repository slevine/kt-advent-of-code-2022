package net.blue64.util

import java.io.File

/**
 * Created by IntelliJ IDEA.
 * Author: Steve Levine
 * Date: 12/1/22
 */
object FileUtil {

  const val TEST_DIR = "src/test/resources"
  const val SRC_DIR = "src/main/resources"

  fun readStringsFromFile(dir: String, fileName: String): List<String> =
    File(dir, fileName).readLines()
}
