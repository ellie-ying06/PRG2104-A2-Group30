package a2

/** Entry point: `sbt "run <file>"`; with no argument reads data/dataset.csv.
  * Print ONLY the five sections to standard output (see brief, Section 1.4). */
@main def analyse(args: String*): Unit =
  val path = args.headOption.getOrElse("data/dataset.csv")
  Console.err.println(s"Reading $path")
  // TODO: load with io, report data quality, run the Analysis instances from analysis, format with report
  println("== DATA QUALITY ==")
  println("== Q1 ==")
  println("== Q2 ==")
  println("== Q3 ==")
  println("== Q4 ==")
