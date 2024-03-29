package com.epam.sparkconsumer.program

import org.apache.commons.cli._

/**
 * Command line utilities.
 */
object CmdUtils {
  /**
   * Argument constants below.
   */
  val Topic = "topic"
  val Url = "url"
  val FilePath = "filePath"
  val FileFormat = "fileFormat"
  val DoBatch = "doBatch"
  val Help = "help"

  private val HasArg = true
  private val NoArg = false

  /**
   * Possible command line options for this program.
   */
  private val Options = new Options()
    .addOption(Topic, HasArg, "Topic name. Required to run the program.")
    .addOption(Url, HasArg, "Topic url. Required to run the program.")
    .addOption(FilePath, HasArg, "File path. Required to run the program.")
    .addOption(FileFormat, HasArg, "File format. Required to run the program.")
    .addOption(DoBatch, HasArg, "Tells whether we should use batching or streaming. Required.")
    .addOption(Help, NoArg, "Help. Optional.")

  /**
   * Parses cmd arguments into a CommandLine object.
   *
   * @param args cmd args.
   * @return CommandLine object.
   */
  def parserArgs(args: Array[String]): CommandLine = {
    val cmdParser = new PosixParser
    cmdParser.parse(Options, args)
  }

  /**
   * Checks if there are enough arguments to run this program.
   * Also checks that nTheads is a number.
   *
   * @param cmdLine command line object.
   * @return true of false, telling whether there are enough arguments.
   */
  def checkArguments(cmdLine: CommandLine): Unit = {
    val allArgumentsArePresent =
      cmdLine.hasOption(Topic) &&
        cmdLine.hasOption(Url) &&
        cmdLine.hasOption(DoBatch) &&
        cmdLine.hasOption(FilePath) &&
        cmdLine.hasOption(FileFormat)

    if (!allArgumentsArePresent) {
      throw new IllegalArgumentException("You provided bad arguments")
    }
  }

  /**
   * Prints help if the user specified the -help flag.
   */
  def printHelpIfNeeded(cmdLine: CommandLine): Unit = {
    if (cmdLine.hasOption(Help)) {
      val helpFormatter = new HelpFormatter
      helpFormatter.printHelp("Consumer.", Options)
    }
  }
}
